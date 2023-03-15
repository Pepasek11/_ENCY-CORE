// 
//  //
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package cz.csob.ency.modules.apps.meta.cds.web.util;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayActionRequest;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryLocalServiceUtil;
import cz.csob.ency.modules.apps.meta.cds.web.portlet.action.MetaCdsConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * View Helper
 *
 * @author Miroslav Čermák
 */
@Component(immediate = true, service = ColumnEntryViewHelper.class)
public class ColumnEntryViewHelper {

	/**
	 * Get Data list from Database
	 *
	 * @param request     PortletRequest
	 * @param start       int
	 * @param end         int
	 * @param orderByCol  String
	 * @param orderByType String
	 * @return SearchContainerResults<ColumnEntry>
	 * @throws ParseException
	 */
	public SearchContainerResults<ColumnEntry> getListFromDB(
			PortletRequest request, int start, int end, String orderByCol,
			String orderByType, int[] state)
		throws ParseException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);
		PortletPreferences portletPreferences = request.getPreferences();

		// Filter type

		String prefsViewType = portletPreferences.getValue(
			MetaCdsConfiguration.CONF_PREFS_VIEW_TYPE,
			MetaCdsConfiguration.PREFS_VIEW_TYPE_DEFAULT);

		long groupId = themeDisplay.getScopeGroupId();
		int containerStart = start;
		int containerEnd = end;

		List<ColumnEntry> results = new ArrayList<>();

		int total = 0;

		// Get Order

		OrderByComparator<ColumnEntry> orderByComparator = getOrderByComparator(
			orderByCol, orderByType);

		if (prefsViewType.equals(
				MetaCdsConfiguration.PREFS_VIEW_TYPE_DEFAULT)) {

			results = ColumnEntryLocalServiceUtil.findAllInGroup(
				groupId, containerStart, containerEnd, orderByComparator,
				state);
			total = ColumnEntryLocalServiceUtil.countAllInGroup(groupId, state);
		}
		else if (prefsViewType.equals(
					MetaCdsConfiguration.PREFS_VIEW_TYPE_USER)) {

			results = ColumnEntryLocalServiceUtil.findAllInUser(
				themeDisplay.getUserId(), containerStart, containerEnd,
				orderByComparator, state);
			total = ColumnEntryLocalServiceUtil.countAllInUser(
				themeDisplay.getUserId(), state);
		}
		else {
			results = ColumnEntryLocalServiceUtil.findAllInUserAndGroup(
				themeDisplay.getUserId(), groupId, containerStart, containerEnd,
				orderByComparator, state);
			total = ColumnEntryLocalServiceUtil.countAllInUserAndGroup(
				themeDisplay.getUserId(), groupId, state);
		}

		return new SearchContainerResults<>(results, total);
	}

	/**
	 * Get Data list from Database
	 *
	 * @param request         PortletRequest
	 * @param searchContainer SearchContainer<?>
	 * @return SearchContainerResults<ColumnEntry>
	 * @throws ParseException
	 */
	public SearchContainerResults<ColumnEntry> getListFromDB(
			PortletRequest request, SearchContainer<?> searchContainer,
			int[] state)
		throws ParseException {

		return getListFromDB(
			request, searchContainer.getStart(), searchContainer.getEnd(),
			searchContainer.getOrderByCol(), searchContainer.getOrderByType(),
			state);
	}

	/**
	 * Get Data list from Index
	 *
	 * @param request PortletRequest
	 * @param start   int
	 * @param end     int
	 * @throws SearchException
	 */
	public SearchContainerResults<ColumnEntry> getListFromIndex(
			PortletRequest request, int start, int end, int state)
		throws SearchException {
		
		int total = 0;
		List<ColumnEntry> tempResults = new ArrayList<>();
		
		
		Map<String, Object> advSearchKeywords = new HashMap<>();
		try {			
			advSearchKeywords =	getAdvSearchKeywordsObject(request);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		if(!advSearchKeywords.isEmpty()) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			BooleanQuery booleanQuery = getBooleanQuery(advSearchKeywords);
			
			SearchRequestBuilder searchRequestBuilder =
				    searchRequestBuilderFactory.builder();
			searchRequestBuilder.emptySearchEnabled(true);
			
			searchRequestBuilder.withSearchContext(
				    searchContext -> {
						searchContext.setAttribute(Field.STATUS, state);
						searchContext.setStart(start);
						searchContext.setEnd(end);
						searchContext.setEntryClassNames(new String[] {ColumnEntry.class.getName()});
				        searchContext.setCompanyId(themeDisplay.getCompanyId());
				    });
			
			SearchRequest searchRequest = 
				    searchRequestBuilder.query(booleanQuery).build();
					
			
			SearchResponse searchResponse = searcher.search(searchRequest);
			SearchHits searchHits = searchResponse.getSearchHits();
			List<SearchHit> searchHitsList = searchHits.getSearchHits();
					
			total = GetterUtil.getInteger(searchHits.getTotalHits());
			
			for(SearchHit searchHit : searchHitsList) {
				ColumnEntry resReg = null;

				// Entry

				long entryId = GetterUtil.getLong(searchHit.getDocument().getLong(Field.ENTRY_CLASS_PK));

				try {
					resReg = ColumnEntryLocalServiceUtil.getColumnEntry(entryId);

					resReg = resReg.toEscapedModel();

					tempResults.add(resReg);
				}
				catch (Exception e) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"ColumnEntry search index is stale and contains entry " +
								entryId);
					}

					continue;
				}
			}
		} else {
		
	
		// Search Key

		String searchFilter = ParamUtil.getString(
			request, DisplayTerms.KEYWORDS);

		Indexer<ColumnEntry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			ColumnEntry.class);

		SearchContext searchContext = SearchContextFactory.getInstance(
			PortalUtil.getHttpServletRequest(request));

		// TODO : When WorkflowConstants.STATUS_ANY, this parameter should be set to
		// display all records in the list
		// searchContext.setAndSearch(true);

		searchContext.setAttribute(Field.STATUS, state);

		searchContext.setKeywords(searchFilter);
		searchContext.setStart(start);
		searchContext.setEnd(end);

		// Search in index

		Hits results = indexer.search(searchContext);

		// Initialize return values

		total = results.getLength();

		for (int i = 0; i < results.getDocs().length; i++) {
			Document doc = results.doc(i);

			ColumnEntry resReg = null;

			// Entry

			long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

			try {
				resReg = ColumnEntryLocalServiceUtil.getColumnEntry(entryId);

				resReg = resReg.toEscapedModel();

				tempResults.add(resReg);
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"ColumnEntry search index is stale and contains entry " +
							entryId);
				}

				continue;
			}
		}

		}

		return new SearchContainerResults<>(tempResults, total);
	}

	/**
	 * Get Data list from Index
	 *
	 * @param request PortletRequest
	 * @return searchContainer SearchContainer<?>
	 * @throws SearchException
	 */
	public SearchContainerResults<ColumnEntry> getListFromIndex(
			PortletRequest request, SearchContainer<?> searchContainer,
			int state)
		throws SearchException {

		return getListFromIndex(
			request, searchContainer.getStart(), searchContainer.getEnd(),
			state);
	}

	/**
	 *
	 * Order Comparetor
	 *
	 * @param searchContainer
	 * @return OrderByComparator
	 */
	public OrderByComparator<ColumnEntry> getOrderByComparator(
		SearchContainer<?> searchContainer) {

		return getOrderByComparator(
			searchContainer.getOrderByCol(), searchContainer.getOrderByType());
	}

	/**
	 *
	 * Order Comparetor
	 *
	 * @param orderByCol
	 * @param orderByType
	 * @return OrderByComparator
	 */
	public OrderByComparator<ColumnEntry> getOrderByComparator(
		String orderByCol, String orderByType) {

		if (_log.isDebugEnabled()) {
			_log.debug(
				"searchContainer.getOrderByCol()" +
					(null != orderByCol ? orderByCol : "null"));
			_log.debug(
				"searchContainer.getOrderByType()" +
					(null != orderByType ? orderByType : "null"));
		}

		return OrderByComparatorFactoryUtil.create(
			"ColumnEntry_ColumnEntry", orderByCol, getOrder(orderByType));
	}
	
	public static Map<String, String> getAdvSearchKeywords(LiferayActionRequest request) {
		return getAdvSearchKeywords((PortletRequest) request);
	}
		
	public static Map<String, String> getAdvSearchKeywords(PortletRequest request) {
    	MetaCdsConfiguration columnEntryConfiguration =
				(MetaCdsConfiguration) request.getAttribute(MetaCdsConfiguration.class.getName());
				
		PortletPreferences portletPreferences = request.getPreferences();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(
			HtmlUtil.escape(
                portletPreferences.getValue(
                    "dateFormat", Validator.isNull(columnEntryConfiguration) ? "yyyy/MM/dd" : columnEntryConfiguration.dateFormat())));

    	Map<String, Object> advSearchKeywordsObj = new HashMap<>();
    	
    	try {
    		advSearchKeywordsObj = getAdvSearchKeywordsObject(request);
    	} catch(ParseException e) {
    		e.printStackTrace();
    	}		
		
    	Map<String, String> advSearchKeywords = new HashMap<>();
    	
    	for(String key : advSearchKeywordsObj.keySet()) {
    		if(advSearchKeywordsObj.get(key) instanceof Map) {
    			Map<String, Object> map = (Map<String, Object>) advSearchKeywordsObj.get(key);
    			
    			for(String hashKey : map.keySet()) {
    				if(map.get(hashKey) instanceof Calendar) {
    					advSearchKeywords.put(key + hashKey.substring(0, 1).toUpperCase() + hashKey.substring(1), 
    							dateFormat.format(((Calendar) map.get(hashKey)).getTime()));    					
    				} else if (map.get(hashKey) instanceof Long || 
    						map.get(hashKey) instanceof Double || 
    						map.get(hashKey) instanceof Integer ) {
    					advSearchKeywords.put(key + hashKey.substring(0, 1).toUpperCase() + hashKey.substring(1), 
    							map.get(hashKey).toString());
    				}    				
    			}
    		} else if(advSearchKeywordsObj.get(key) instanceof String) {
    			advSearchKeywords.put(key, (String) advSearchKeywordsObj.get(key));
    		} 
    	}
    	return advSearchKeywords;
    }
	
	protected static Map<String, Object> getAdvSearchKeywordsObject(PortletRequest request) throws ParseException {
    	MetaCdsConfiguration columnEntryConfiguration =
    	        (MetaCdsConfiguration) request.getAttribute(MetaCdsConfiguration.class.getName());
    	
    	PortletPreferences portletPreferences = request.getPreferences();
    	String dateFormatVal = HtmlUtil.escape(
                portletPreferences.getValue("dateFormat", 
                		Validator.isNull(columnEntryConfiguration) ? "yyyy/MM/dd" : columnEntryConfiguration.dateFormat()));
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
    	
    	Map<String, Object> advSearchKeywords = new HashMap<String, Object>();
    	
			
				Map<String, Long> searchColumnEntryId = new HashMap<>();		    	
		    	if(ParamUtil.getLong(request, "searchColumnEntryIdStart", 0) != 0) {
		    		searchColumnEntryId.put("start", ParamUtil.getLong(request, "searchColumnEntryIdStart"));
		    	}
		    	if(ParamUtil.getLong(request, "searchColumnEntryIdEnd", 0) != 0) {
		    		searchColumnEntryId.put("end", ParamUtil.getLong(request, "searchColumnEntryIdEnd"));		    		
		    	}		    	
		    	if(!searchColumnEntryId.isEmpty()) {
		    		advSearchKeywords.put("searchColumnEntryId", searchColumnEntryId);
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchColumnType", "").isEmpty()) {
		        	advSearchKeywords.put("searchColumnType", ParamUtil.getString(request, "searchColumnType"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchColumnName", "").isEmpty()) {
		        	advSearchKeywords.put("searchColumnName", ParamUtil.getString(request, "searchColumnName"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchColumnFullName", "").isEmpty()) {
		        	advSearchKeywords.put("searchColumnFullName", ParamUtil.getString(request, "searchColumnFullName"));
		    	}
				
					
			
				Map<String, Long> searchTableEntryId = new HashMap<>();		    	
		    	if(ParamUtil.getLong(request, "searchTableEntryIdStart", 0) != 0) {
		    		searchTableEntryId.put("start", ParamUtil.getLong(request, "searchTableEntryIdStart"));
		    	}
		    	if(ParamUtil.getLong(request, "searchTableEntryIdEnd", 0) != 0) {
		    		searchTableEntryId.put("end", ParamUtil.getLong(request, "searchTableEntryIdEnd"));		    		
		    	}		    	
		    	if(!searchTableEntryId.isEmpty()) {
		    		advSearchKeywords.put("searchTableEntryId", searchTableEntryId);
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchTableName", "").isEmpty()) {
		        	advSearchKeywords.put("searchTableName", ParamUtil.getString(request, "searchTableName"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchSystemName", "").isEmpty()) {
		        	advSearchKeywords.put("searchSystemName", ParamUtil.getString(request, "searchSystemName"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchDatabaseName", "").isEmpty()) {
		        	advSearchKeywords.put("searchDatabaseName", ParamUtil.getString(request, "searchDatabaseName"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchDescription", "").isEmpty()) {
		        	advSearchKeywords.put("searchDescription", ParamUtil.getString(request, "searchDescription"));
		    	}
				
					
			
				if(!ParamUtil.getString(request, "searchDataType", "").isEmpty()) {
		        	advSearchKeywords.put("searchDataType", ParamUtil.getString(request, "searchDataType"));
		    	}
				
					
			
				Map<String, Long> searchDataSize = new HashMap<>();		    	
		    	if(ParamUtil.getLong(request, "searchDataSizeStart", 0) != 0) {
		    		searchDataSize.put("start", ParamUtil.getLong(request, "searchDataSizeStart"));
		    	}
		    	if(ParamUtil.getLong(request, "searchDataSizeEnd", 0) != 0) {
		    		searchDataSize.put("end", ParamUtil.getLong(request, "searchDataSizeEnd"));		    		
		    	}		    	
		    	if(!searchDataSize.isEmpty()) {
		    		advSearchKeywords.put("searchDataSize", searchDataSize);
		    	}
				
					
			
				
					
			
				
					
			
				
					
		
    	return advSearchKeywords;
    }

	private BooleanQuery getBooleanQuery(Map<String, Object> advSearchKeywords) {
		
    	BooleanQuery booleanQuery = queries.booleanQuery();
    	List<Query> queryList = new ArrayList<>();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	
    	for(String key : advSearchKeywords.keySet()) {
    		String column = key.replaceFirst("search","");
    		column = column.substring(0, 1).toLowerCase() + column.substring(1, column.length());
    		
    		if(advSearchKeywords.get(key) instanceof Map) {
    			Map<String, Object> map = (Map<String, Object>) advSearchKeywords.get(key);
    			
    			if(map.get("start") instanceof Calendar && map.get("end") instanceof Calendar) {
    				queryList.add(queries.dateRangeTerm(column, true, true, 
    						sdf.format(((Calendar)map.get("start")).getTime()), 
    						sdf.format(((Calendar)map.get("end")).getTime())));    				
    			} else if((map.get("start") instanceof Long && map.get("end") instanceof Long) || 
    					(map.get("start") instanceof Double && map.get("end") instanceof Double) ||
    					(map.get("start") instanceof Integer && map.get("end") instanceof Integer)) {
    				queryList.add(queries.rangeTerm(column, true, true, map.get("start"), map.get("end")));
        		}
    		} else if(advSearchKeywords.get(key) instanceof String) {
    			queryList.add(queries.match(column, advSearchKeywords.get(key)));
    		}
    	}
    	
    	booleanQuery.addMustQueryClauses(queryList.toArray(new Query[] {}));
    	
    	return booleanQuery;
	}

	/**
	 * Order string to boolean
	 *
	 * @param order
	 * @return if true if order is "asc" or false
	 */
	protected boolean getOrder(String order) {
		if ("asc".equalsIgnoreCase(order)) {
			return true;
		}

		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(
	    ColumnEntryViewHelper.class);
	
	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;
	
	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;
}