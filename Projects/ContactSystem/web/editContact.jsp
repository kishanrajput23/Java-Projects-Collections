<%-- 
    Document   : editContact
    Created on : 05-Jul-2022, 2:35:41 pm
    Author     : VINIT
--%>

<%@page import="com.entity.Contact"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="com.dao.ContactDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allFiles/allCss.jsp"%>

    </head>
    <body>

      <%@include file="allFiles/navbar.jsp"%>

      <% 
          if(user==null)
          {
             session.setAttribute("invalidMsg","Please Login");
             response.sendRedirect("login.jsp");
          }
      %>
      
      
      
      
        
        <div class="container">
            <div class="row">

                <div class="col-md-6 offset-md-3 p-5">

                    <div class="card">
                        <div class="body">
                            <form action="EditContact" method="POST">

                               <% 
                                
                                  int cid = Integer.parseInt(request.getParameter("cid"));
                                   
                                   ContactDao dao = new ContactDao(DbConnect.getConnection());
                                   

                                 Contact c = dao.getContactbyId(cid);
                               %>
                                
                               <input type="hidden" value="<%= cid %>" name="cid"> 
                               
                                <h4 class="p-3 mb-2 bg-info text-white text-center">Edit
                                    Contact Page</h4>

                                 <%
                                 String failedMsg = (String) session.getAttribute("failedMsg");
                      
                                      
                                 if (failedMsg!= null) {%>
                                 <p class="text-danger text-center alert alert-danger"><%= failedMsg%></p>
                                <%
                                    session.removeAttribute("failedMsg");
                                    }
                                
                                %>

                               
                               
                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter name</label> <input
                                        type="text" name="name" value="<%= c.getName()%>" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp">


                                </div>




                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Email address</label> <input
                                        type="email" name="email" value="<%= c.getEmail() %>" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp">
                                </div>



                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter phonenumber</label> <input
                                        type="number" name="phno" value="<%= c.getPhno() %>" class="form-control" id="exampleInputEmail1"
                                        aria-describedby="emailHelp">
                                </div>



                                <div class="form-group p-2">
                                    <label for="exampleInputEmail1">Enter about him/her</label> <input
                                        type="text" name="about" value="<%= c.getAbout() %>" class="form-control"
                                       />



                                </div>



                                <div class="text-center pb-3">

                                    <button type="submit" class="btn btn-primary">Edit
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
