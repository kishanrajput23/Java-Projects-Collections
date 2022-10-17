<jsp:useBean id="cb" class="beans.CustomerBean" scope="request">
<jsp:setProperty name="cb" property="*"/>
<% cb.select();%>
<PRE>
<form action="./modifycustomer.jsp">
Customer ID     <INPUT type="text" name="custid" value='<jsp:getProperty name="cb" property="custid"/>'></input>
Customer Name   <INPUT type="text" name="cname" value='<jsp:getProperty name="cb" property="cname"/>'></input>
Street Address1 <INPUT type="text" name="stad1" value='<jsp:getProperty name="cb" property="stad1"/>'></input>
Street Address2 <INPUT type="text" name="stad2" value='<jsp:getProperty name="cb" property="stad2"/>'></input>
Town			<INPUT type="text" name="town" value='<jsp:getProperty name="cb" property="town"/>'></input>
Postal Code		<INPUT type="text" name="postcode" value='<jsp:getProperty name="cb" property="postcode"/>'></input>
Email			<INPUT type="text" name="email" value='<jsp:getProperty name="cb" property="email"/>'></input>
Telephone Number<INPUT type="text" name="telno" value='<jsp:getProperty name="cb" property="telno"/>'></input>
<input type="submit" name="submit" value="Modify">
</form>
</PRE>

</jsp:useBean>