<%@ page import="com.company.dao.inter.UserDaoInter" %>
<%@ page import="com.company.Context" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>

<%@include file="header.jsp" %>
    <br/>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>

    <form action="users" method="get">
        <div class="form-group">
            <input name="name" class="form-control" type="text" />
        </div>
        <div class="form-group">
            <input name="surname" class="form-control" type="text" />
        </div>
        <input class="btn btn-primary" type="submit" value="Search"/>
        <a href="useradd" >ADD</a>
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
        <%
            for(int i=0;i<users.size();i++){
                User user = users.get(i);
        %>
            <tr>
                <th scope="row"><%=i+1%></th>
                <td><%=user.getName()%></td>
                <td><%=user.getSurname()%></td>
                <td><a href="useredit?userId=<%=user.getId()%>">EDIT</a></td>
                <td>
                    <form action="users" method="post">
                        <input type="hidden" name="action" value="delete"/>
                        <input type="hidden" name="userId" value="<%=user.getId()%>"/>
                        <input class="btn btn-primary" type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        <%}%>
        </tbody>
    </table>


<%@include file="footer.jsp" %>

</body>
