<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Object err = request.getAttribute("errors");
    Map<String, String> errors = err == null ? null : (Map<String, String>) err;
%>
<form action="/servlet/CreateEmp" method="post">

    <table>
        <tr>
            <td>Name:</td>
            <td>
                <% String name = request.getParameter("nameEmp"); %>
                <input type="text" name="nameEmp" value="<%=name == null ? "" : name%>"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td>
                <% String surname = request.getParameter("surname"); %>
                <input type="text" name="surname" value="<%=surname == null ? "" : surname%>"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>Age</td>
            <td>
                <% String age = request.getParameter("age"); %>
                <input type="int" name="age" value="<%=age == null ? "" : age%>"/>
            </td>
            <td style="color: red;">
                <% String ageError = errors == null ? "" : errors.get("age"); %>
                <%= ageError == null ? "" : ageError %>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <% String email = request.getParameter("email"); %>
                <input type="text" name="email" value="<%=email == null ? "" : email %>"/>
            </td>
            <td style="color: red;">
                <% String emailError = errors == null ? "" : errors.get("email"); %>
                <%= emailError == null ? "" : emailError %>
            </td>
        </tr>
        <tr>
            <td>Birth Day</td>
            <td>
                <% String bday = request.getParameter("birthDay"); %>
                <input type="date" name="birthDay" value="<%=bday == null ? "" : bday%>">
            </td>
            <td style="color: red">
                <% String dateError = errors == null ? "" : errors.get("date"); %>
                <%= dateError == null ? "" : dateError %>
            </td>
        </tr>
        <tr>
            <td><input type="hidden" value="<%=request.getAttribute("Data3")%>" name="id"/></td>
            <td><input type="submit" value="Add"/></td>
            <td></td>
        </tr>


    </table>

</form>
</body>
</html>