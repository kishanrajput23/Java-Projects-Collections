<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="F:\wallies\HD Wallpapers\img36.jpg">
<form action="question.jsp" method=post>
<center>
<table cellpadding=8 cellspacing=8 border="10" bgcolor="transparent">
<BR><BR><BR><BR>
<th bgcolor="transparent" colspan=2>
<font size=10 face="Times New Roman" color=LIGHTgrey>QUESTION BANK</font>
<br>
</th>
 
<tr bgcolor="transparent">
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>Q.NO.</b>
</font>
<input type="text" name="t1" value=""  id="txt1" size=3 maxlength=3></td>
<td valign=top> 
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>AUTHOR</b>
</font>
<input type="text" name="t2" value="" size=30 maxlength=30></td>
</tr>

<tr bgcolor="transparent">
<td align=center colspan=2>
<font size=5 face="Times New Roman" color=LIGHTYELLOW>
<b>QUESTION</b>
</font>
<br><TEXTAREA name="t3" rows=5 cols=100 Wrap=true> </TEXTAREA></td>
</tr>
<tr bgcolor="transparent">
<td align=center colspan=2>
<input type='radio' name='o1'>1
<input type="text" name="t4" value="" size=40 maxlength=40><br>
<input type='radio' name='o1'>2
<input type="text" name="t5" value="" size=40 maxlength=40><br>
<input type='radio' name='o1'>3
<input type="text" name="t6" value="" size=40 maxlength=40><br>
<input type='radio' name='o1'>4
<input type="text" name="t7" value="" size=40 maxlength=40>
</td>
</tr>

<tr bgcolor="transparent">
<td align=center colspan=2>
<input type="SUBMIT" value="SUBMIT">


<%
String qid=request.getParameter("t1");
String author=request.getParameter("t2");
String quest=request.getParameter("t3");
String op1=request.getParameter("t4");
String op2=request.getParameter("t5");
String op3=request.getParameter("t6");
String op4=request.getParameter("t7");
String ans=request.getParameter("o1");
if(!(qid==" " && author==" "  && quest==" "  && op1== " "&& op2== " "&& op3== " "&& op4== " "&& ans== " "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    
    st.executeQuery("insert into question values("+qid+",'"+quest+"',"+ans+",'"+author+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"')");
    
    
    out.println ("Insert Successful");

}catch(Exception e1)
{
	out.println(e1);
}
}
%>
<input type="button" value="SEARCH" >

<%
if(!( qid==" " ))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select * from question");
    while(rs.next())
         {
         String username=rs.getString(1);
         if(qid.equals(username) )
             {

           //setElementById("txt1")=rs.getString(2);
        	 }
         
  
     }
     if(rs.isLast()==true)
     {
    	 out.println("Login Failed,Please try Again");
     }

}catch(Exception e1)
{
}
}

%>
<input type="SUBMIT" value="DELETE" >
<%
qid=request.getParameter("t2");
if(!(qid==" "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    String query="delete from question where q_id="+qid;
     st.executeUpdate(query);
    
}catch(Exception e1)
{
}
}
%>



<input type="SUBMIT" value="UPDATE">
<%
qid=request.getParameter("t1");
author=request.getParameter("t2");
quest=request.getParameter("t3");
 op1=request.getParameter("t4");
 op2=request.getParameter("t5");
 op3=request.getParameter("t6");
 op4=request.getParameter("t7");
 ans=request.getParameter("o1");

 if(!(qid==" " && author==" "  && quest==" "  && op1== " "&& op2== " "&& op3== " "&& op4== " "&& ans== " "))
{


     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:abc", "scott", "tiger");
     Statement st=con.createStatement();
    String query="update question set q_id="+qid+",ques='"+quest+"',ans="+ans+",author='"+author+"',op1='"+op1+"',op2='"+op2+"',op3='"+op3+"',op4='"+op4+"'where q_id="+qid;
     st.executeUpdate(query);
    
}catch(Exception e1)
{
}
}
%>

<input type="button" value="   EXIT     " onclick="location.href='page1.jsp'">
</td>
</tr>

</table>
</center>
 </form>
</body>
</html>





















