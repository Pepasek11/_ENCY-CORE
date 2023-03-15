<%@ include file="init.jsp" %>

<c:choose>
    <c:when test="<%= "edit".equals(mode)%>">
        <aui:input
                id="<%=id%>"
                name="<%=name%>"
                title="<%=title%>"
                value="<%=value%>"
                label="<%=label%>"
                type="text"/>

    </c:when>
    <c:otherwise>
        <aui:field-wrapper name="<%=name%>"
                           label="<%=label%>"
        >
            <%=value%>
        </aui:field-wrapper>
    </c:otherwise>
</c:choose>
