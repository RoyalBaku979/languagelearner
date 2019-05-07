<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>

<%@include file="header.jsp" %>
<br/>

    <div class="container">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form action="useradd" method="post">
                    <h1>Add</h1>
                    <div class="form-group">
                        <input name="name" class="form-control" type="text" placeholder="name" />
                    </div>
                    <div class="form-group">
                        <input name="surname" class="form-control" type="text" placeholder="surname"/>
                    </div>
                    <div class="form-group">
                        <input name="email" class="form-control" type="email" placeholder="email"/>
                    </div>
                    <div class="form-group">
                        <input name="password" class="form-control" type="password" placeholder="password"/>
                    </div>
                    <input class="btn btn-primary" type="submit" value="Add"/>
                </form>
            </div>
        </div>
    </div>


<br/>
<%@include file="footer.jsp" %>

</body>
