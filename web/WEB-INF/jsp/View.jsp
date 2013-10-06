<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sanych.forAimprosoft.database.model.Department" %>
<%@ page import="java.util.Map" %>


<html>
<head>
    <title></title>
</head>
<body>
<%
    Object err = request.getAttribute("errorsDep");
    Map<String, String> errors = err == null ? null : (Map<String, String>) err;
%>
<table>
    <form action="/servlet/CreateDep" method="post">

        <tr>
            <td>Enter the name of the department:</td>
        </tr>
        <tr>
            <% String dep = request.getParameter("department"); %>
            <td><input type="text" name="department" value="<%=dep == null ? "" : dep %>"/></td>
            <td style="color: red;">
                <% String nameError = errors == null ? "" : errors.get("department"); %>
                <%= nameError == null ? "" : nameError %>
            </td>
        </tr>
        <tr><input type="submit" value="Add"></tr>
    </form>
</table>
<table>
    <tr>
        <td><b>Department</b></td>
    </tr>

    <%
        List<Department> departments = (List<Department>) request.getAttribute("Data");
        for (Department d : departments) {
    %>
    <tr>

        <form action="/servlet/UpdateDep" method="post">
            <td><input type="text" value="<%=d.getNameDep()%>" name="depart"/>
            <td><input type="hidden" value="<%=d.getId()%>" name="id"/>
            <td><input type="submit" value="Update"/></td>
        </form>
        <form action="/servlet/DeleteDep" method="get">
            <td><input type="hidden" value="<%=d.getId()%>" name="id"/>
            <td><input type="submit" value="Delete"/></td>
        </form>
        <form action="/servlet/ViewEmp" method="get">
            <td><input type="hidden" value="<%=d.getId()%>" name="id"/>
            <td><input type="submit" value="List"/></td>
        </form>
    </tr>
    <%}%>


</table>
</body>
</html>