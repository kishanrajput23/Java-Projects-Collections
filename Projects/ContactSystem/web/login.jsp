<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <%@include file="allFiles/allCss.jsp"%>

    </head>
    <body style="background: #f0f1f2;">
        <%@include file="allFiles/navbar.jsp"%>

        <div class="container">
            <div class="row">

                <div class="col-md-4 offset-md-4 p-5">

                    <div class="card">
                        
                        <div class="card-header bg-info p-0">
                           <h4 class="p-3 mb-2 bg-info text-white text-center">Login Page</h4>
                        </div>
                        
                        
                        <div class="body">
                            <form action="LoginServlet" method="POST">
                                   

               
                                <%
                                                      String invalidMsg = (String) session.getAttribute("invalidMsg");

                                                      if (invalidMsg != null) {%>

                                                      <p class="text-danger alert alert-danger text-center"><%= invalidMsg%></p>
                                <%
                                    }
                                                    session.removeAttribute("invalidMsg");
                                %>

                                
                                <%
                                                      String LogOutMsg = (String) session.getAttribute("LogOutMsg");

                                                      if (LogOutMsg != null) {%>

                                                      <p class="text-success alert alert-success text-center"><%= LogOutMsg%></p>
                                <%
                                    }
                                                    session.removeAttribute("LogOutMsg");
                                %>
                                
                                
                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                                           aria-describedby="emailHelp" placeholder="Enter email" required="required">
                                </div>




                                <div class="form-group p-2">
                                    <label for="exampleInputPassword1">Password</label> <input
                                        type="password" name="password" class="form-control" id="exampleInputPassword1"
                                        placeholder="Password" required="required">
                                </div>

                                <div class="text-center pb-3">

                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>						
                            </form>
                        </div>

                    </div>

                </div>

            </div>

        </div>

                                
    </body>
</html>