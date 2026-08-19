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

        <% 
             if(user==null)
             {
                session.setAttribute("invalidMsg", "Please Login To Add Contact");
                response.sendRedirect("login.jsp");
             }
        %>
        
        
        
        <div class="container">
            <div class="row">

                <div class="col-md-6 offset-md-3 p-5">

                    <div class="card">
                        <div class="body">
                            <form action="AddContact" method="POST">

                               <% 
                                 if(user!=null)
                                 {
                                 %>
                                 
                                <input type="hidden"  value="<%= user.getId() %>" name="userid">
                                 <%     
                               }
                               
                               %>
                                
                                <h4 class="p-3 mb-2 bg-info text-white text-center">Add
                                    Contact Page</h4>

                                   <%
                                    String successMsg = (String) session.getAttribute("successMsg");
                                    String failedMsg = (String) session.getAttribute("failedMsg");
                                    if (successMsg != null) {
                                %>
                                <p class="text-success text-center alert alert-success"><%= successMsg%></p>
                                <%
                                    session.removeAttribute("successMsg");
                                    }

                                 if (failedMsg!= null) {%>
                                 <p class="text-danger text-center alert alert-danger"><%= failedMsg%></p>
                                <%
                                    session.removeAttribute("failedMsg");
                                    }
                                
                                %>

                               
                               
                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter name</label> <input
                                        type="text" name="name" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp" placeholder="Enter name">


                                </div>




                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Email address</label> <input
                                        type="email" name="email" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp" placeholder="Enter email">
                                </div>



                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter phonenumber</label> <input
                                        type="number" name="phno" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp" placeholder="Enter phonenumber">
                                </div>



                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter about him/her</label> <input
                                        type="text" name="about" class="form-control"
                                        placeholder="Enter about" />



                                </div>



                                <div class="text-center pb-3">

                                    <button type="submit" class="btn btn-primary">Save
                                        Contact</button>
                                </div>


                            </form>

                        </div>

                    </div>


                </div>


            </div>

        </div>


    </body>
</html>