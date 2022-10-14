<%@ page import="java.sql.*"%>


<%!
Connection con;
Statement  st;
String sql,s,t,u,v,w,x,y,z,m,n,o;


%>
<body bgcolor="#d3d2d1">
<%
try
{

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

s=request.getParameter("a");
t=request.getParameter("b");
u=request.getParameter("c");
v=request.getParameter("d");
w=request.getParameter("e");
x=request.getParameter("f");
y=request.getParameter("g");
z=request.getParameter("h");
m=request.getParameter("i");
n=request.getParameter("j");
o=request.getParameter("k");



}
catch(ClassNotFoundException e)
{
out.println(e.getMessage());
}

try
{


con=DriverManager.getConnection("Jdbc:Odbc:orads","scott","tiger");

st=con.createStatement();

sql="insert into organizationmeeting values('"+s+"','"+t+"','"+u+"','"+v+"','"+w+"','"+x+"','"+y+"','"+z+"','"+m+"','"+n+"','"+o+"')";

st.executeQuery(sql);
}
catch(Exception e)
{
out.println("ASSOCIATION Meeting Scheduled Sucsessfully");

}
%>
</body>
