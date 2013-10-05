<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sanych.forAimprosoft.database.model.Department" %>

<html>
<head>
    <title></title>
</head>
<body>
<table>
    <form action="/servlet/CreateDep" method="">
        <tr>
            <td>Enter the name of the department:</td>
        </tr>
        <tr>
            <td><input type="text" name="department">
                <input type="submit" value="Add"></td>
        </tr>
    </form>
    <tr>
        <td><b>Department</b></td>
    </tr>

    <% List<Department> departments = (List<Department>) request.getAttribute("Data");
    for (Department d : departments) {%>
    <tr>

        <td><%=d.getNameDep()%>
        </td>
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