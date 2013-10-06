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
        <th><b>Birthday</b></th>
    </tr>
    </thead>
    <tbody>
    <% List<Employee> employees = (List<Employee>) request.getAttribute("Data1");
        for (Employee e : employees) {%>

    <tr>
        <form action="/servlet/UpdateEmp" method="get">
            <td><input type="text" value="<%=e.getName()%>" name="nameEmp"/>
            </td>
            <td><input type="text" value="<%=e.getSurname()%>" name="surname"/>
            </td>
            <td><input type="text" value="<%=e.getAge()%>" name="age"/>
            </td>
            <td><input type="text" value="<%=e.getEmail()%>" name="email"/>
            </td>
            <td><input type="text" value="<%=e.getBirthday()%>" name="birthDay"/>
            </td>
            <td><input type="hidden" value="<%=e.getId()%>" name="em_id"/>
            </td>
            <td><input type="hidden" value="<%=e.getDepartment()%>" name="id"/>
            </td>
            <td><input type="submit" value="Update"/></td>
        </form>
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