<%@ include file="/init.jsp" %>

<%
PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
SystemEntry systemEntry = (SystemEntry)request.getAttribute("systemEntry");
String redirect = ParamUtil.getString(request, "redirect");
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<liferay-frontend:info-bar
	fixed="<%= true %>"
>
</liferay-frontend:info-bar>

<portlet:actionURL name="/systementry/crud" var="systementryEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid container-fluid-max-xl entry-body">
	<aui:form action="<%= systementryEditURL %>" method="post" name="systementryEdit">
		<aui:model-context bean="<%= systemEntry %>" model="<%= SystemEntry.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= systemEntry.getPrimaryKey() %>" />

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
<%-- 						<aui:input name="systemName" label="title" />--%>
<%-- 						<aui:input name="description" label="summary" />--%>
<%--  --%>

					<%
					String requiredLabel = "";
					%>

<%--   --%>

		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="systemcode-required"
						  message="systemcode-required" />

					<aui:input name="systemCode" disabled="false"
						label='<%=LanguageUtil.get(request, "systemcode")
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
		<liferay-ui:error key="systemtitle-required"
						  message="systemtitle-required" />

					<aui:input name="systemTitle" disabled="false"
						label='<%=LanguageUtil.get(request, "systemtitle")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="systemtype-required"
						  message="systemtype-required" />

					<aui:input name="systemType" disabled="false"
						label='<%=LanguageUtil.get(request, "systemtype")
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
		<liferay-ui:error key="stewardname-required"
						  message="stewardname-required" />

					<aui:input name="stewardName" disabled="false"
						label='<%=LanguageUtil.get(request, "stewardname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="stewardid-required"
						  message="stewardid-required" />

					<aui:input name="stewardId" disabled="false"
						label='<%=LanguageUtil.get(request, "stewardid")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="stewarddepartment-required"
						  message="stewarddepartment-required" />

					<aui:input name="stewardDepartment" disabled="false"
						label='<%=LanguageUtil.get(request, "stewarddepartment")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="businessownername-required"
						  message="businessownername-required" />

					<aui:input name="businessOwnerName" disabled="false"
						label='<%=LanguageUtil.get(request, "businessownername")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="businessownerid-required"
						  message="businessownerid-required" />

					<aui:input name="businessOwnerId" disabled="false"
						label='<%=LanguageUtil.get(request, "businessownerid")
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
		<liferay-ui:error key="sandboxname-required"
						  message="sandboxname-required" />

					<aui:input name="sandboxName" disabled="false"
						label='<%=LanguageUtil.get(request, "sandboxname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="gestordepartmentid-required"
						  message="gestordepartmentid-required" />

					<aui:input name="gestorDepartmentId" disabled="false"
						label='<%=LanguageUtil.get(request, "gestordepartmentid")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="gestordepartmentname-required"
						  message="gestordepartmentname-required" />

					<aui:input name="gestorDepartmentName" disabled="false"
						label='<%=LanguageUtil.get(request, "gestordepartmentname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="role-required"
						  message="role-required" />

					<aui:input name="role" disabled="false"
						label='<%=LanguageUtil.get(request, "role")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="snowassettagid-required"
						  message="snowassettagid-required" />

					<aui:input name="snowAssetTagId" disabled="false"
						label='<%=LanguageUtil.get(request, "snowassettagid")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="snowassettagname-required"
						  message="snowassettagname-required" />

					<aui:input name="snowAssetTagName" disabled="false"
						label='<%=LanguageUtil.get(request, "snowassettagname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="isSlaSigned" disabled="false"
						label='<%=LanguageUtil.get(request, "isslasigned")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="isSelfBi" disabled="false"
						label='<%=LanguageUtil.get(request, "isselfbi")
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
					if (systemEntry.getPrimaryKey() != 0) {
					%>

						<liferay-ratings:ratings
							className="<%= SystemEntry.class.getName() %>"
							classPK="<%= systemEntry.getPrimaryKey() %>"
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
					if (systemEntry.getPrimaryKey() != 0 && false == fromAsset) {
					%>

						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
								<liferay-asset:input-asset-links
									className="<%= SystemEntry.class.getName() %>"
									classPK="<%= systemEntry.getPrimaryKey() %>"
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
							.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, SystemEntry.class.getName())) {

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
	if (systemEntry.getPrimaryKey() != 0 && false == fromAsset) {
	%>

		<liferay-ui:panel-container
			extended="<%= false %>"
			id="systemEntryCommentsPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="systemEntryCommentsPanel"
				persistState="<%= true %>"
				title='<%= LanguageUtil.get(request, "comments") %>'
			>
				<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

				<liferay-comment:discussion
					className="<%= SystemEntry.class.getName() %>"
					classPK="<%= systemEntry.getPrimaryKey() %>"
					formName="fm2"
					ratingsEnabled="<%= true %>"
					redirect="<%= currentURL %>"
					userId="<%= systemEntry.getUserId() %>"
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
		submitForm(document.<portlet:namespace />systementryEdit);
	}
</aui:script>

<%--   --%>
<%--  --%>
