<html>
    <head>
        <title>Language Learner</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    </head>
    <body>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <form action="login" method="post">
                                <h1>Login</h1>
                                <div class="form-group">
                                    <input name="username" class="form-control" type="text" />
                                </div>
                                <div class="form-group">
                                    <input name="password" class="form-control" type="password" />
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                                <%=request.getParameter("error")!=null?"Email or password is incorrect!!!":""%>
                                <input class="btn btn-primary" type="submit" value="Login"/>
                            </form>
                        </div>
                    </div>
                </div>
    </body>
</html>