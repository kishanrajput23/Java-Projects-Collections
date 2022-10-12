<html>
<jsp:userBean name="user"  scope="session"  class="obs.User" />

<div style="font:700 11pt verdana" border=1>
Welcome <b><jsp:getProperty id="user" property="uname"/> </b>
</div>

