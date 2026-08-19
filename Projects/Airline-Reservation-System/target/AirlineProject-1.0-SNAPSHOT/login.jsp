<%-- 
    Document   : login
    Created on : Apr 21, 2017, 6:06:19 PM
    Author     : Gursangeet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Free HTML5 Templates</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
  <link href="css/login.css" rel="stylesheet" type="text/css"/> 
  <!-- modernizr enables HTML5 elements and feature detects -->
</head>

<body id="main">
    <div>
<div class="login-box">
      <div class="login-logo">
        <a href="javascript:;"><b>Geet Airlines</b></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body" style="background: #333;">
        <p class="login-box-msg">Sign in to start your session</p>
        <h5><span class="text-danger text-bold" >${error}<%session.removeAttribute("error");%></span></h5>
        <form action="login" method="post">
          <div class="form-group has-feedback">
            <input type="email" name="email" class="form-control" placeholder="Email">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" name="password" class="form-control" placeholder="Password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
                <label>
                  <input type="checkbox"> Remember Me
                </label>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div><!-- /.col -->
          </div>
        </form>
        <a href="register.jsp" class="text-center">Register a new membership</a>

      </div><!-- /.login-box-body -->
    </div>
    
    </div><!--close main-->
     
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  
</body>
</html>
