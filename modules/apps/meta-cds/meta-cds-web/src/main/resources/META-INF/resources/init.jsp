<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ratings" prefix="liferay-ratings" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.asset.constants.AssetWebKeys" %>
<%@ page import="com.liferay.asset.util.AssetHelper" %>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainerResults" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.trash.TrashHelper" %>
<%@ page import="com.liferay.trash.util.TrashWebKeys" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.model.ColumnEntry" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.model.SystemEntry" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.model.TableEntry" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.service.SystemEntryLocalService" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalService" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.service.TableEntryLocalServiceUtil" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.constants.ColumnEntryWebKeys" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.constants.MetaCdsWebKeys" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.constants.SystemEntryWebKeys" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.constants.TableEntryWebKeys" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.internal.display.context.*" %>
<%@ page
        import="cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.ColumnEntryEntryPermission" %>
<%@ page
        import="cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.SystemEntryEntryPermission" %>
<%@ page
        import="cz.csob.ency.modules.apps.meta.cds.web.internal.security.permission.resource.TableEntryEntryPermission" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.portlet.action.MetaCdsConfiguration" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.util.SystemEntryViewHelper" %>
<%@ page import="cz.csob.ency.modules.apps.meta.cds.web.util.TableEntryViewHelper" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.text.SimpleDateFormat" %>


<liferay-frontend:defineObjects/>
<liferay-theme:defineObjects/>
<portlet:defineObjects/>

<%
    AssetHelper assetHelper = (AssetHelper) request.getAttribute(AssetWebKeys.ASSET_HELPER);
    TrashHelper trashHelper = (TrashHelper) request.getAttribute(TrashWebKeys.TRASH_HELPER);

    MetaCdsConfiguration metaCdsConfiguration =
            (MetaCdsConfiguration)
                    renderRequest.getAttribute(MetaCdsConfiguration.class.getName());

    String prefsViewType = StringPool.BLANK;
    String dateFormatVal = StringPool.BLANK;
    String datetimeFormatVal = StringPool.BLANK;
    String datePickerFormatVal = StringPool.BLANK;

    if (Validator.isNotNull(metaCdsConfiguration)) {
        prefsViewType = HtmlUtil.escape(portletPreferences.getValue("prefsViewType", String.valueOf(metaCdsConfiguration.prefsViewType())));

        dateFormatVal = HtmlUtil.escape(portletPreferences.getValue("dateFormat", metaCdsConfiguration.dateFormat()));

        datetimeFormatVal = HtmlUtil.escape(portletPreferences.getValue("datetimeFormat", metaCdsConfiguration.datetimeFormat()));

        datePickerFormatVal = HtmlUtil.escape(portletPreferences.getValue("datePickerFormat", metaCdsConfiguration.datePickerFormat()));
    }
%>
