<%@page import="java.sql.Connection"%>
<%@page import="com.connection.DbConnect"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhonebookProject</title>
<%@include file="allFiles/allCss.jsp"%>

<style>

.header
{
    height: 90Vh;
    width: 100%;
   background-color: black;
    color: white;
    background-size: cover;
}


.message
{
    background-image: linear-gradient(to top,#fad0c4 0%,#ffd1ff 100%);
}


.classHover:hover
{
	background-color: black;
        color: white;
        border-radius: 20px;
        border-color: blue;
        border-style: solid;
}
/*#0d6efd*/
.bg-color
{
   background-color: #0d6efd;
}




</style>

</head>
<!--<body style="background: url(img/black.png); background-size: cover;background-attachment: fixed;">-->
<body>
<%@include file="allFiles/navbar.jsp"%>

<div class="back-img text-center text-white mt-0">
<header class="header">

        <div class="container h-100">

            <div class="row h-100 align-items-center">

                <div class="col-md-12 text-center">

                    <h1>welcome to learn code</h1>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt sit ullam deserunt quisquam sed
                        eveniet laudantium officiis natus provident veritatis cupiditate accusamus, ea consequatur,
                        nesciunt velit nisi odit, ex fugit facilis odio quos. Maiores doloremque, ad saepe magni
                        praesentium impedit quam earum, autem odit mollitia in, accusantium et aliquid asperiores.</p>
                    <button class="btn btn-primary">Start learning</button>
                </div>

            </div>

        </div>

    </header>

    
     <!--section-2 starts-->
     
     
      <section class="message py-5">
        <!-- padding py-5  -->

        <div class="container text-center text-dark">


            <h1>we have got what you need</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil quam id mollitia beatae dolor repellat
                animi veniam, ad cupiditate non saepe nulla necessitatibus eligendi iste omnis, natus quasi? Soluta,
                minima. Iste tenetur unde animi adipisci eius corporis error, corrupti omnis? Voluptate consequuntur
                alias ab quisquam sed quaerat delectus sit officiis.</p>

            <button class="btn btn-primary">
                Check it out
            </button>

        </div>


    </section>

     <!--section-2 ends-->
     
     
     

    <!-- services section  -->

    <section class="services">


        <div class="container text-center py-5 text-dark">

            <h1 class="pb-4">About our services</h1>

            <div class="row">

                <div class="col-md-4 pb-3">
                    <!-- first col -->

                    <div class="card classHover">

                        <div class="card-body">
                            <h3>Best explaination</h3>   
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi sint alias ipsam tempore
                                maiores, delectus perferendis porro amet doloribus recusandae voluptatem magni earum!
                                Corporis, velit? Numquam voluptas unde fugit iure?</p>
                        </div>

                    </div>

                </div>
                <div class="col-md-4 pb-3">
                    <div class="card classHover">

                        <div class="card-body">
                            <h3>Best explaination</h3>   
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi sint alias ipsam tempore
                                maiores, delectus perferendis porro amet doloribus recusandae voluptatem magni earum!
                                Corporis, velit? Numquam voluptas unde fugit iure?</p>
                        </div>

                    </div>
                </div>
                <div class="col-md-4 pb-3">
                    <div class="card classHover">

                        <div class="card-body">
                            <h3>Best explaination</h3>   
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi sint alias ipsam tempore
                                maiores, delectus perferendis porro amet doloribus recusandae voluptatem magni earum!
                                Corporis, velit? Numquam voluptas unde fugit iure?</p>
                        </div>

                    </div>
                </div>

            </div>

        </div>

    </section>


    <!-- end of services section  -->
    
    
    <!--start of footer-->
   
      
  
<%@include file="allFiles/footer.jsp" %>

</body>
</html>