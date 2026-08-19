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

                <div class="col-md-6 offset-md-3 p-5">

                    <div class="card">
                        
                        <div class="card-header p-0 bg-info">
                               <h4 class="p-3 mb-2 bg-info text-white text-center">Registration Page</h4>

                        </div>
                        
                        <div class="body">
                            <form action="RegisterServlet" method="POST">


                                <%
                                    String registersuccess = (String) session.getAttribute("registersuccess");
                                    String registerfail = (String) session.getAttribute("errorMsg");
                                    if (registersuccess != null) {
                                %>
                                <p class="text-success text-center alert alert-success"><%= registersuccess%></p>
                                <%
                                    session.removeAttribute("registersuccess");
                                    }

                                 if (registerfail != null) {%>
                                 <p class="text-danger text-center alert alert-danger"><%= registerfail %></p>
                                <%
                                    session.removeAttribute("registerfail");
                                    }
                                
                                %>



                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter name</label>
                                    <input type="text" name="name" class="form-control" id="exampleInputEmail1"
                                           aria-describedby="emailHelp" placeholder="Enter name" required="required" >


                                </div>




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

                                    <button type="submit" class="btn btn-primary">Register</button>
                                </div>						


                            </form>

                        </div>

                    </div>


                </div>


            </div>

        </div>
     
                                
    </body>
</html>