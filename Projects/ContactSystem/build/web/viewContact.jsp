<%@page import="com.entity.Contact"%>
<%@page import="com.connection.DbConnect"%>
<%@page import="java.util.*"%>

<%@page import="com.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>viewContact</title>
        <%@include file="allFiles/allCss.jsp"%>

        <style type="text/css">
            .crd-ho:hover{
                background-color: black;
                color: white;
                border-radius: 20px;


            }

        </style>

    </head>
    <body style="background: #f0f1f2;">

        <%@include file="allFiles/navbar.jsp"%>




        <%    if (user == null) {

                session.setAttribute("invalidMsg", "Please Login To View Contact");
                response.sendRedirect("login.jsp");
            }
        %>

        <%
            String successMsg = (String) session.getAttribute("successMsg");
            String failedMsg = (String) session.getAttribute("failedMsg");
            if (successMsg != null) {
        %>
        <div class="alert alert-success text-center" role="alert"><%= successMsg%></div>
        <%
                  session.removeAttribute("successMsg");

              }
              if (failedMsg != null) {%>
        <p class="text-danger text-center alert alert-danger"><%= failedMsg%></p>
        <%
                session.removeAttribute("failedMsg");
            }

        %>
      



        <div class="container">
            <div class="row p-5">


                <%      if (user != null) {

                        ContactDao dao = new ContactDao(DbConnect.getConnection());

                        List<Contact> contact = dao.getAllContact(user.getId());

                        for (Contact c : contact) {
                %>
                <div class="col-sm-6 pb-4">
                    <div class="card crd-ho">
                        <div class="card-body">

                            <p>Name : <%= c.getName()%></p>
                            <p>Phone : <%= c.getPhno()%></p>
                            <p>Email: <%= c.getEmail()%></p>
                            <p>About : <%= c.getAbout()%></p>

                            <div class="text-white text-center">

                                <a href="DeleteContact?cid=<%= c.getId()%>" class="btn btn-danger pl-1 pr-1 btn-sm">Delete</a>
                                <a href="editContact.jsp?cid=<%= c.getId()%>" class="btn btn-primary ml-1 btn-sm">Edit</a>

                            </div>

                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>







            </div>

        </div>



    </body>
</html>