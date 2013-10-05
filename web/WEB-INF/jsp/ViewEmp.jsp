<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sanych.forAimprosoft.database.model.Employee" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Employees</h2>
<table>
    <thead>
    <tr>
        <th><b>Name</b></th>
        <th><b>Surname</b></th>
        <th><b>Age</b></th>
        <th><b>Email</b></th>
    </tr>
    </thead>
    <tbody>
    <% List<Employee> employees = (List<Employee>) request.getAttribute("Data1");
        for (Employee e : employees) {%>

    <tr>
        <td><%=e.getName()%>
        </td>
        <td><%=e.getSurname()%>
        </td>
        <td><%=e.getAge()%>
        </td>
        <td><%=e.getEmail()%>
        </td>
        <form action="/servlet/DeleteEmp" method="get">
            <td><input type="hidden" value="<%=e.getId()%>" name="em_id"/>
            <td><input type="hidden" value="<%=e.getDepartment()%>" name="id"/>
            <td><input type="submit" value="Delete"/></td>
        </form>
    </tr>
    <%}%>
    </tbody>
</table>
<form action="/servlet/Redirect" method="">
    <input type="hidden" value="<%=request.getAttribute("Data2")%>" name="id"/>
    <input type="submit" value="Add Employee"/>
</form>

<form action="/servlet/View" method="post">
    <input type="submit" value="Back"/>
</form>

</body>
</html>