<jsp:useBean id="pb" class="beans.HaulierBean" scope="request">
<jsp:setProperty name="pb" property="*"/>
<% pb.select(); %>
<form action="./modifyhaulier.jsp">
<PRE>
Prod ID   		<input type="text" name="haulid" value="<jsp:getProperty name='pb' property='haulid'/>">
Prod Name 		<input type="text" name="hname" value="<jsp:getProperty name='pb' property='hname'/>">
Street Address1 <input type="text" name="hstad1" value="<jsp:getProperty name='pb' property='hstad1'/>">
Street Address1	<input type="text" name="hstad2" value="<jsp:getProperty name='pb' property='hstad2'/>">

Town/City 		<input type="text" name="htown" value="<jsp:getProperty name='pb' property='htown'/>">
Postal Code		<input type="text" name="hpostcode" value="<jsp:getProperty name='pb' property='hpostcode'/>">
Telephone Number<input type="text" name="htelno" value="<jsp:getProperty name='pb' property='htelno'/>">
Email			<input type="text" name="hemail" value="<jsp:getProperty name='pb' property='hemail'/>">
<input type="submit" name="submit" value="Modify">
</PRE>
</form>
</jsp:useBean>