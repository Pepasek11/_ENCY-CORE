<%@ include file="/init.jsp" %>


<%
    final String navigation = ParamUtil.getString(request, MetaCdsWebKeys.NAVIGATION, MetaCdsWebKeys.NAVIGATION_SYSTEMS);
%>

<clay:navigation-bar
        inverted="<%= true %>"
        navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(navigation.equals(MetaCdsWebKeys.NAVIGATION_SYSTEMS));
						navigationItem.setHref(
                                renderResponse.createRenderURL(),
                                MetaCdsWebKeys.NAVIGATION,
                                MetaCdsWebKeys.NAVIGATION_SYSTEMS
                                );
						navigationItem.setLabel(LanguageUtil.get(httpServletRequest, "systems"));
					});
				add(
					navigationItem -> {
						navigationItem.setActive(navigation.equals(MetaCdsWebKeys.NAVIGATION_TABLES));
						navigationItem.setHref(
                                renderResponse.createRenderURL(),
                                MetaCdsWebKeys.NAVIGATION,
                                MetaCdsWebKeys.NAVIGATION_TABLES
                                );
						navigationItem.setLabel(LanguageUtil.get(httpServletRequest, "tables"));
					});
                add(
					navigationItem -> {
						navigationItem.setActive(navigation.equals(MetaCdsWebKeys.NAVIGATION_COLUMNS));
						navigationItem.setHref(
                                renderResponse.createRenderURL(),
                                MetaCdsWebKeys.NAVIGATION,
                                MetaCdsWebKeys.NAVIGATION_COLUMNS
                                );
						navigationItem.setLabel(LanguageUtil.get(httpServletRequest, "columns"));
					});
                add(
					navigationItem -> {
						navigationItem.setActive(navigation.equals(MetaCdsWebKeys.NAVIGATION_DASHBOARD));
						navigationItem.setHref(
                                renderResponse.createRenderURL(),
                                MetaCdsWebKeys.NAVIGATION,
                                MetaCdsWebKeys.NAVIGATION_DASHBOARD
                                );
						navigationItem.setLabel(LanguageUtil.get(httpServletRequest, "dashboard"));
					});
			}
		}
	%>'
/>

<c:choose>
    <c:when test='<%= navigation.equals("tables") %>'>
        <liferay-util:include page="/table_entry_admin/view.jsp" servletContext="<%= application %>"/>
    </c:when>
    <c:when test='<%= navigation.equals("columns") %>'>
        <liferay-util:include page="/column_entry_admin/view.jsp" servletContext="<%= application %>"/>
    </c:when>
    <c:when test='<%= navigation.equals("dashboard") %>'>
        <liferay-util:include page="/meta_cds_admin/view_dashboard.jsp" servletContext="<%= application %>"/>
    </c:when>
    <c:otherwise>
        <liferay-util:include page="/system_entry_admin/view.jsp" servletContext="<%= application %>"/>
    </c:otherwise>
</c:choose>