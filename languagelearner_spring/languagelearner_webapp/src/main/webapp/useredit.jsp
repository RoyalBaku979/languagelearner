<%@ page import="com.company.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>

<%@include file="header.jsp" %>
<br/>

<%
        User user = (User) request.getAttribute("user");
%>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form method="post">
                <h1>Edit</h1>
                <div class="form-group">
                    <input name="name" class="form-control" type="text" placeholder="name" value="<%=user.getName()%>"/>
                </div>
                <div class="form-group">
                    <input name="surname" class="form-control" type="text" placeholder="surname" value="<%=user.getSurname()%>"/>
                </div>
                <div class="form-group">
                    <input name="email" class="form-control" type="email" placeholder="email" value="<%=user.getEmail()%>"/>
                </div>
                <div class="form-group">
                    <input name="password" class="form-control" type="password" placeholder="password" value="<%=user.getPassword()%>"/>
                </div>
                <input class="btn btn-primary" type="submit" value="Edit"/>
            </form>
        </div>
    </div>
</div>


<br/>
<%@include file="footer.jsp" %>

</body>
