<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="F:\wallies\HD Wallpapers\img36.jpg">



 <!-- <script language="javascript">
    var dminute=0,dsecond=10;
	function delay()
	{
		
    	
    	document.write("TIME LEFT - " + dminute +":" + dsecond);
        if (dminute==0 && dsecond ==0)
        {alert( "TIME IS OVER");
        location = "page1.jsp";
        }
        if (dsecond==0)
	    {   
             dminute = dminute - 1;
             dsecond = 60;
        }
        dsecond = dsecond - 1;
 			}
window.onload = function()
{
		while(dminute!=-1 && dsecond!=0)
		{
		setTimeout(delay,1000);
		}
	}
</script>  -->

<font size=5 face="Times New Roman" color=LIGHTgrey>

<%
try{
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
    Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs=st.executeQuery("select * from question");
    
    
   rs.next();
   
    
    	
    out.println( "<h1>              Author          :-</h>"         + rs.getString(4) );	
   	out.println( "<br><br>"+rs.getString(1) );
    out.println(  rs.getString(2) );
    out.println("<br><br> <input type='radio' name='o1'> " + rs.getString(5) );
  	out.println(" <br><br><input type='radio' name='o1'> " + rs.getString(6) );
  	out.println(" <br><br><input type='radio' name='o1'> " + rs.getString(7) );
    out.println(" <br><br><input type='radio' name='o1'>" + rs.getString(8) );
    	
   
    	
    	
    	
    	
    	
    	
    	
    	
    }
catch(Exception e)
{
	out.println(e);
}

%>
<script language="JAVASCRIPT">
function getDet()
{

	rs.next();
	out.println( "<h1>              Author          :-</h>"         + rs.getString(4) );	
   	out.println( "<br><br>"+rs.getString(1) );
    out.println(  rs.getString(2) );
    out.println("<br><br> <input type='radio' name='o1'> " + rs.getString(5) );
  	out.println(" <br><br><input type='radio' name='o1'> " + rs.getString(6) );
  	out.println(" <br><br><input type='radio' name='o1'> " + rs.getString(7) );
    out.println(" <br><br><input type='radio' name='o1'>" + rs.getString(8) );
}

</script>


<br><br><br><input type="BUTTON" value="NEXT" onclick="getDet()">

</font>
</body>
</html>
