<clay:content-row>
    <clay:content-col expand="true">
        <liferay-ui:panel title="<%=tableTitle%>" collapsible="false" iconCssClass="<%=iconCssClass%>">
            <table id="<%=tableId%>" class="table display compact table-bordered table-hover table-striped" style="width:100%">
                <thead class="table-columns">
                <tr>
                    <th class="table-first-header"><liferay-ui:message key="tablename"/></th>
                    <th class="table-header"><liferay-ui:message key="tabledatabase"/></th>
                    <th class="table-header" ><liferay-ui:message key="description"/></th>
                    <th class="table-last-header"><liferay-ui:message key="dsa"/></th>
                </tr>
                </thead>
                <tbody>
                <tr><td colspan="4" class="no-data-info-row"><liferay-ui:message key="no-data-available"/></td></tr>
                </tbody>
            </table>
        </liferay-ui:panel>
    </clay:content-col>
</clay:content-row>