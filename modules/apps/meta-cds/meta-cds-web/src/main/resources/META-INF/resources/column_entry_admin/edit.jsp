<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
ColumnEntry columnEntry = (ColumnEntry)request.getAttribute("columnEntry");
String redirect = ParamUtil.getString(request, "redirect");
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<liferay-frontend:info-bar
	fixed="<%= true %>"
>
</liferay-frontend:info-bar>

<portlet:actionURL name="/columnentry/crud" var="columnentryEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid container-fluid-max-xl entry-body">
	<aui:form action="<%= columnentryEditURL %>" method="post" name="columnentryEdit">
		<aui:model-context bean="<%= columnEntry %>" model="<%= ColumnEntry.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= columnEntry.getPrimaryKey() %>" />

		<div class="lfr-form-content">
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>
					<c:if test="<%= Constants.ADD.equals(CMD) %>">
						<aui:input name="addGuestPermissions" type="hidden" value="true" />
						<aui:input name="addGroupPermissions" type="hidden" value="true" />
					</c:if>

<%--   --%>
						<liferay-ui:error key="duplicated-url-title"
												  message="duplicated-url-title" />
<%-- 						<aui:input name="columnName" label="title" />--%>
<%-- 						<aui:input name="columnFullName" label="summary" />--%>
<%--  --%>

					<%
					String requiredLabel = "";
					%>

<%--   --%>

		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="columntype-required"
						  message="columntype-required" />

					<aui:input name="columnType" disabled="false"
						label='<%=LanguageUtil.get(request, "columntype")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="columnname-required"
						  message="columnname-required" />

					<aui:input name="columnName" disabled="false"
						label='<%=LanguageUtil.get(request, "columnname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="columnfullname-required"
						  message="columnfullname-required" />

					<aui:input name="columnFullName" disabled="false"
						label='<%=LanguageUtil.get(request, "columnfullname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="tableentryid-required"
						  message="tableentryid-required" />


					<%
					TableEntryViewHelper tableEntryViewHelper = (TableEntryViewHelper) request
							.getAttribute(TableEntryWebKeys.TABLEENTRY_VIEW_HELPER);

					SearchContainerResults<TableEntry> tableEntryResults = tableEntryViewHelper.getListFromDB(
							renderRequest, -1, -1, "tableName", "asc", new int[] {WorkflowConstants.STATUS_APPROVED});
					%>
					<liferay-ui:error key="tableentryid-not-found"
									  message="tableentryid-not-found" />

					<aui:select name="tableEntryId"
						label='<%=LanguageUtil.get(request, "tableentryid")
								+ requiredLabel%>'>
						<aui:option value=""><%=LanguageUtil.get(request, "please-select") %></aui:option>
						<% for(TableEntry tableEntry : tableEntryResults.getResults()) { %>
						<aui:option value="<%= tableEntry.getTableEntryId() %>"><%=tableEntry.getTableName() %></aui:option>
						<% } %>
					</aui:select>

		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="tablename-required"
						  message="tablename-required" />

					<aui:input name="tableName" disabled="false"
						label='<%=LanguageUtil.get(request, "tablename")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="systemname-required"
						  message="systemname-required" />

					<aui:input name="systemName" disabled="false"
						label='<%=LanguageUtil.get(request, "systemname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="databasename-required"
						  message="databasename-required" />

					<aui:input name="databaseName" disabled="false"
						label='<%=LanguageUtil.get(request, "databasename")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="description-required"
						  message="description-required" />

					<aui:input name="description" disabled="false"
						label='<%=LanguageUtil.get(request, "description")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="datatype-required"
						  message="datatype-required" />

					<aui:input name="dataType" disabled="false"
						label='<%=LanguageUtil.get(request, "datatype")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="datasize-required"
						  message="datasize-required" />

					<aui:input name="dataSize" disabled="false"
						label='<%=LanguageUtil.get(request, "datasize")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="isPrimaryKey" disabled="false"
						label='<%=LanguageUtil.get(request, "isprimarykey")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="isNotNull" disabled="false"
						label='<%=LanguageUtil.get(request, "isnotnull")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="isActive" disabled="false"
						label='<%=LanguageUtil.get(request, "isactive")
						+ requiredLabel%>'
					/>
<%--  --%>

					<%
					if (columnEntry.getPrimaryKey() != 0) {
					%>

						<liferay-ratings:ratings
							className="<%= ColumnEntry.class.getName() %>"
							classPK="<%= columnEntry.getPrimaryKey() %>"
						/>

					<%
					}
					%>

					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="categorization">
							<aui:input name="categories" type="assetCategories" />

							<aui:input name="tags" type="assetTags" />
						</aui:fieldset>
					</aui:fieldset-group>

					<%
					if (columnEntry.getPrimaryKey() != 0 && false == fromAsset) {
					%>

						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
								<liferay-asset:input-asset-links
									className="<%= ColumnEntry.class.getName() %>"
									classPK="<%= columnEntry.getPrimaryKey() %>"
								/>
							</aui:fieldset>
						</aui:fieldset-group>

					<%
					}
					%>

					<aui:button-row>

						<%
						String publishButtonLabel = "submit";
						%>

						<%
						if (WorkflowDefinitionLinkLocalServiceUtil
							.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, ColumnEntry.class.getName())) {

								publishButtonLabel = "submit-for-publication";
						}
						%>

						<aui:button
							cssClass="btn-lg"
							onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEditors();" %>'
							primary="<%= false %>"
							type="submit"
							value="<%= publishButtonLabel %>"
						/>

						<%
						if (!fromAsset) {
						%>

							&nbsp;&nbsp;&minus; <liferay-ui:message key="or" /> &minus;
							<aui:button onClick="<%= redirect %>" type="cancel" />

						<%
						}
						%>

					</aui:button-row>

				</aui:fieldset>
			</aui:fieldset-group>
		</div> <!-- lfr-form-content -->
	</aui:form>

	<%
	if (columnEntry.getPrimaryKey() != 0 && false == fromAsset) {
	%>

		<liferay-ui:panel-container
			extended="<%= false %>"
			id="columnEntryCommentsPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="columnEntryCommentsPanel"
				persistState="<%= true %>"
				title='<%= LanguageUtil.get(request, "comments") %>'
			>
				<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

				<liferay-comment:discussion
					className="<%= ColumnEntry.class.getName() %>"
					classPK="<%= columnEntry.getPrimaryKey() %>"
					formName="fm2"
					ratingsEnabled="<%= true %>"
					redirect="<%= currentURL %>"
					userId="<%= columnEntry.getUserId() %>"
				/>
			</liferay-ui:panel>
		</liferay-ui:panel-container>

	<%
	}
	%>

</div>

<%--   --%>
<%--  --%>

<aui:script>
	function <portlet:namespace />saveEditors() {
<%--   --%>
<%--  --%>
		submitForm(document.<portlet:namespace />columnentryEdit);
	}
</aui:script>

<%--   --%>
<%--  --%>
