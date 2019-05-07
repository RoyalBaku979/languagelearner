<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>

    <%@include file="header.jsp" %>
    <br/>
    <form action="users" method="get">
        <div class="form-group">
            <input name="name" class="form-control" type="text" />
        </div>
        <div class="form-group">
            <input name="surname" class="form-control" type="text" />
        </div>
        <input class="btn btn-primary" type="submit" value="Search"/>
        <a href="users/add" >ADD</a>
    </form>

    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>name</th>
                <th>surname</th>
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>

        <c:forEach items="${users}" var="u" varStatus="uStatus">
            <tr>
                <th scope="row">${uStatus.index}</th>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td><a href="users/${u.id}/edit">EDIT</a></td>
                <td>
                    <form action="users/${u.id}/delete" method="post">
                        <input class="btn btn-primary" type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


<%@include file="footer.jsp" %>

</body>
