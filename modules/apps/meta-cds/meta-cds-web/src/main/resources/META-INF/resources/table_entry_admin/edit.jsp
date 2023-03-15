<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
TableEntry tableEntry = (TableEntry)request.getAttribute("tableEntry");
String redirect = ParamUtil.getString(request, "redirect");
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<liferay-frontend:info-bar
	fixed="<%= true %>"
>
</liferay-frontend:info-bar>

<portlet:actionURL name="/tableentry/crud" var="tableentryEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid container-fluid-max-xl entry-body">
	<aui:form action="<%= tableentryEditURL %>" method="post" name="tableentryEdit">
		<aui:model-context bean="<%= tableEntry %>" model="<%= TableEntry.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= tableEntry.getPrimaryKey() %>" />

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
<%-- 						<aui:input name="tableName" label="title" />--%>
<%-- 						<aui:input name="description" label="summary" />--%>
<%--  --%>

					<%
					String requiredLabel = "";
					%>

<%--   --%>

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
		<liferay-ui:error key="tablefullname-required"
						  message="tablefullname-required" />

					<aui:input name="tableFullName" disabled="false"
						label='<%=LanguageUtil.get(request, "tablefullname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="tabletype-required"
						  message="tabletype-required" />

					<aui:input name="tableType" disabled="false"
						label='<%=LanguageUtil.get(request, "tabletype")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="tabledatabase-required"
						  message="tabledatabase-required" />

					<aui:input name="tableDatabase" disabled="false"
						label='<%=LanguageUtil.get(request, "tabledatabase")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="systementryid-required"
						  message="systementryid-required" />


					<%
					SystemEntryViewHelper systemEntryViewHelper = (SystemEntryViewHelper) request
							.getAttribute(SystemEntryWebKeys.SYSTEMENTRY_VIEW_HELPER);

					SearchContainerResults<SystemEntry> systemEntryResults = systemEntryViewHelper.getListFromDB(
							renderRequest, -1, -1, "systemName", "asc", new int[] {WorkflowConstants.STATUS_APPROVED});
					%>
					<liferay-ui:error key="systementryid-not-found"
									  message="systementryid-not-found" />

					<aui:select name="systemEntryId"
						label='<%=LanguageUtil.get(request, "systementryid")
								+ requiredLabel%>'>
						<aui:option value=""><%=LanguageUtil.get(request, "please-select") %></aui:option>
						<% for(SystemEntry systemEntry : systemEntryResults.getResults()) { %>
						<aui:option value="<%= systemEntry.getSystemEntryId() %>"><%=systemEntry.getSystemName() %></aui:option>
						<% } %>
					</aui:select>

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
		<liferay-ui:error key="description-required"
						  message="description-required" />

					<aui:input name="description" disabled="false"
						label='<%=LanguageUtil.get(request, "description")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="dsaurl-required"
						  message="dsaurl-required" />

					<aui:input name="dsaUrl" disabled="false"
						label='<%=LanguageUtil.get(request, "dsaurl")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="contactpersonname-required"
						  message="contactpersonname-required" />

					<aui:input name="contactPersonName" disabled="false"
						label='<%=LanguageUtil.get(request, "contactpersonname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="contactpersonid-required"
						  message="contactpersonid-required" />

					<aui:input name="contactPersonId" disabled="false"
						label='<%=LanguageUtil.get(request, "contactpersonid")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="specificationownername-required"
						  message="specificationownername-required" />

					<aui:input name="specificationOwnerName" disabled="false"
						label='<%=LanguageUtil.get(request, "specificationownername")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="specificationownerid-required"
						  message="specificationownerid-required" />

					<aui:input name="specificationOwnerId" disabled="false"
						label='<%=LanguageUtil.get(request, "specificationownerid")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="unstructuredclause-required"
						  message="unstructuredclause-required" />

					<aui:input name="unstructuredClause" disabled="false"
						label='<%=LanguageUtil.get(request, "unstructuredclause")
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
					if (tableEntry.getPrimaryKey() != 0) {
					%>

						<liferay-ratings:ratings
							className="<%= TableEntry.class.getName() %>"
							classPK="<%= tableEntry.getPrimaryKey() %>"
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
					if (tableEntry.getPrimaryKey() != 0 && false == fromAsset) {
					%>

						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
								<liferay-asset:input-asset-links
									className="<%= TableEntry.class.getName() %>"
									classPK="<%= tableEntry.getPrimaryKey() %>"
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
							.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, TableEntry.class.getName())) {

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
	if (tableEntry.getPrimaryKey() != 0 && false == fromAsset) {
	%>

		<liferay-ui:panel-container
			extended="<%= false %>"
			id="tableEntryCommentsPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="tableEntryCommentsPanel"
				persistState="<%= true %>"
				title='<%= LanguageUtil.get(request, "comments") %>'
			>
				<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

				<liferay-comment:discussion
					className="<%= TableEntry.class.getName() %>"
					classPK="<%= tableEntry.getPrimaryKey() %>"
					formName="fm2"
					ratingsEnabled="<%= true %>"
					redirect="<%= currentURL %>"
					userId="<%= tableEntry.getUserId() %>"
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
		submitForm(document.<portlet:namespace />tableentryEdit);
	}
</aui:script>

<%--   --%>
<%--  --%>
