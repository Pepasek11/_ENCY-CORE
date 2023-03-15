<%@ page import="java.util.Enumeration" %>
<%@ include file="../entry/init.jsp" %>
    <table>
        <thead>
        <tr>
            <td>name</td>
            <td>value</td>
        </tr>
        </thead>

        <%
            Enumeration<String> names = request.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
        %>
        <tr>
            <td><%=name%></td>
            <td><%=request.getAttribute(name)%></td>
        </tr>
        <%
            }
        %>
    </table>
    <hr/>

    <div>zacatek wrapperu</div>
    <div>content: <%=bodyContentString%></div>
    <div>konec wrapperu</div>
