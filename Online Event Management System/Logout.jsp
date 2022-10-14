<%@ page language="java" %>

<body bgcolor="#d3d2d1">
<%
        session.putValue("UID","");
        session.putValue("PWD","");
		
%>
                <center>         <br><br><br>
                        <h1> You have Successfully Logged Out </h1> <p>
                        <h1> Visit Again </h1>
                        <a href="login.html"><h2> Go to Login </h2></a>
                </center>
<%
        System.out.println("-------- Logging Out ----------");
        System.out.println("   UID  =  "+session.getValue("UID"));
        System.out.println("   PWD  =  "+session.getValue("PWD"));
%>
</body>

