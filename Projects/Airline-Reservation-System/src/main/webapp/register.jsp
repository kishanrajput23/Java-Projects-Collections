<%-- 
    Document   : register
    Created on : Apr 21, 2017, 6:51:13 PM
    Author     : Gursangeet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="main">
        <div class="register-box">
            <div class="register-logo">
                <a href="../../index2.html"><b>Geet</b> Airlines</a>
            </div>

            <div class="register-box-body" style="background: #333;">
                <p class="login-box-msg">Register a new membership</p>
                <h5><span class="text-danger text-bold">${error}<%session.removeAttribute("error");%></span></h5>
                <form action="register" method="post">
                    <div class="form-group ">
                        <input type="text" name="firstname" required class="form-control" placeholder="Full name">
                    </div>
                    <div class="form-group ">
                        <input type="email" name="email" required class="form-control" placeholder="Email">
                    </div>
                    <div class="form-group ">
                        <textarea name="address" placeholder="Enter your address" class="form-control" ></textarea>
                    </div>
                    <div class="form-group ">
                        <input type="password" id="password" required name="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group ">
                        <input type="password" equalTo="#password" required class="form-control" placeholder="Retype password">
                    </div>
                    <div class="form-group ">
                        <input type="text" name="phone" required class="form-control" placeholder="Phone">
                    </div>
                    <div class="form-group ">
                        <input type="radio"  name="gender" value="M" required class="radio-inline">Male

                        <input type="radio" name="gender" required value="F" class="radio-inline">Female

                        <input type="radio" name="gender" value="O" required class="radio-inline">Other
                    </div>



                    <div class="row">
                        <div class="col-xs-12">
                            <button type="submit" class="btn btn-primary btn-block btn-flat pull-left">Register</button>
                        </div><!-- /.col -->
                    </div>
                </form>

                <a href="login.jsp" class="text-center">I already have a membership</a>
            </div><!-- /.form-box -->
        </div>
    </body>
</html>
