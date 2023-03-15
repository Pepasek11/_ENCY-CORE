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

package cz.csob.ency.modules.apps.meta.cds.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import cz.csob.ency.modules.apps.meta.cds.constants.MetaCdsPortletKeys;
import cz.csob.ency.modules.apps.meta.cds.exception.ColumnEntryValidateException;
import cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry;
import cz.csob.ency.modules.apps.meta.cds.service.ColumnEntryService;
import cz.csob.ency.modules.apps.meta.cds.web.constants.ColumnEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.ColumnEntryEntryPermission;
import cz.csob.ency.modules.apps.meta.cds.web.upload.ColumnEntryItemSelectorHelper;

// //
import cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService;
import cz.csob.ency.modules.apps.meta.cds.web.constants.TableEntryWebKeys;
import cz.csob.ency.modules.apps.meta.cds.web.util.TableEntryViewHelper;
//  //

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * ColumnEntry CRUD Render
 *
 * @author Miroslav Čermák
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MetaCdsPortletKeys.METACDS_ADMIN,
		"mvc.command.name=/columnentry/crud"
	},
	service = MVCRenderCommand.class
)
public class ColumnEntryAdminCrudMVCRenderCommand implements MVCRenderCommand {

	/**
	 * Edit Page JSP file
	 */
	public String getEditPageJSP() {
		return ColumnEntryWebKeys.ADMIN_EDIT_JSP;
	}

	/**
	 * View Page JSP file
	 */
	public String getViewPageJSP() {
		return ColumnEntryWebKeys.ADMIN_VIEW_JSP;
	}

	/**
	 * View Record JSP file
	 */
	public String getViewRecordPageJSP() {
		return ColumnEntryWebKeys.ADMIN_VIEW_RECORD_JSP;
	}

	@Override
	public String render(RenderRequest request, RenderResponse response)
		throws PortletException {

		String renderJSP = getViewPageJSP();

		// Fetch command

		String cmd = ParamUtil.getString(request, Constants.CMD);

		// Fetch primary key

		long primaryKey = ParamUtil.getLong(request, "resourcePrimKey", 0);
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			if (cmd.equalsIgnoreCase(Constants.UPDATE)) {
				renderJSP = update(request, themeDisplay, primaryKey);
			}
			else if (cmd.equalsIgnoreCase(Constants.VIEW)) {
				renderJSP = view(request, themeDisplay, primaryKey);
			}
			else {
				renderJSP = add(request, themeDisplay, primaryKey);
			}
		}
		catch (PortalException pe) {
			throw new PortletException(pe.getMessage());
		}


//  //

		request.setAttribute(TableEntryWebKeys.TABLEENTRY_VIEW_HELPER, _tableEntryViewHelper);
        request.setAttribute(ColumnEntryWebKeys.TABLEENTRY_LOCAL_SERVICE, _tableEntryLocalService);
// //
		request.setAttribute(
			ColumnEntryWebKeys.COLUMNENTRY_ITEM_SELECTOR_HELPER,
			_columnEntryItemSelectorHelper);

		return renderJSP;
	}

	/**
	 * Add record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 * @throws PortletException
	 */
	protected String add(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, PortletException, ColumnEntryValidateException {

		ColumnEntry record = null;

		if (Validator.isNull(request.getParameter("addErrors"))) {
			record = _columnEntryService.getInitializedColumnEntry(
				primaryKey, request);
		}
		else {
			record = _columnEntryService.getColumnEntryFromRequest(
				primaryKey, request);
		}

		request.setAttribute("columnEntry", record);

		return getEditPageJSP();
	}

	/**
	 * Update record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return JSP file path to open
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	protected String update(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, ColumnEntryValidateException {

		ColumnEntry record = _columnEntryService.getColumnEntry(primaryKey);

		if (!ColumnEntryEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record,
				ActionKeys.UPDATE)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new ColumnEntryValidateException(error);
		}

		request.setAttribute("columnEntry", record);

		return getEditPageJSP();
	}

	/**
	 * View record
	 *
	 * @param request
	 * @param themeDisplay
	 * @param primaryKey
	 * @return
	 * @throws PortalException
	 * @throws ColumnEntryValidateException
	 */
	protected String view(
			RenderRequest request, ThemeDisplay themeDisplay, long primaryKey)
		throws PortalException, ColumnEntryValidateException {

		ColumnEntry record = _columnEntryService.getColumnEntry(primaryKey);

		if (!ColumnEntryEntryPermission.contains(
				themeDisplay.getPermissionChecker(), record, ActionKeys.VIEW)) {

			List<String> error = new ArrayList<>();
			error.add("permission-error");

			throw new ColumnEntryValidateException(error);
		}

		request.setAttribute("columnEntry", record);

		return getViewRecordPageJSP();
	}
	@Reference
	private ColumnEntryService _columnEntryService;

//  //

	@Reference
	private TableEntryViewHelper _tableEntryViewHelper;

    @Reference
    private TableEntryLocalService _tableEntryLocalService;
// //
	
	@Reference
	private ColumnEntryItemSelectorHelper _columnEntryItemSelectorHelper;

}
