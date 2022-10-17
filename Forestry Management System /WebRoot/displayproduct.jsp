<jsp:useBean id="pb" class="beans.ProductBean">
<jsp:setProperty name="pb" property="*"/>
<% pb.select(); %>
<form action="./modifyproduct.jsp">
Prod ID   <input type="text" name="prodid" value="<jsp:getProperty name='pb' property='prodid'/>">
Prod Name <input type="text" name="pname" value="<jsp:getProperty name='pb' property='pname'/>">
Prod Descr<input type="text" name="pdesc" value="<jsp:getProperty name='pb' property='pdesc'/>">
<input type="submit" name="submit" value="Modify">
</form>
</jsp:useBean>