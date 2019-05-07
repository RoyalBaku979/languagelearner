<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

    <style>

        .error{
            color:red;
        }
    </style>
</head>
<body>

<%@include file="header.jsp" %>
<br/>

    <div class="container">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <f:form method="post" modelAttribute="user">
                    <h1>Add</h1>
                    <div class="form-group">
                        <input type="text" name="name" class="form-control"  placeholder="name" />
                        <f:errors path="name" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <input name="surname" class="form-control"  placeholder="surname"/>
                        <f:errors path="surname" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <input name="email" class="form-control" type="email" placeholder="email"/>
                        <f:errors path="email" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <input name="password" class="form-control" type="password" placeholder="password"/>
                        <f:errors path="password" cssClass="error"/>
                    </div>
                    <input class="btn btn-primary" type="submit" value="Add"/>
                </f:form>
            </div>
        </div>
    </div>


<br/>
<%@include file="footer.jsp" %>

</body>
