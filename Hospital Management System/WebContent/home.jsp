<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO HOSPITAL MANAGEMENT SYSTEM</title>
<link rel="stylesheet" href="dropdown.css" type="text/css" />
<script src = "dropdown.js" language="JavaScript"></script>
<style>
a.notr:link { color:#666666; }
a.notr:visited {color:#666666;}
a.notr:hover {color:#666666; }
</style>
</head>
<body background ="1.jpg">
<center>
<table width=1000 border=5 >
<TR BGCOLOR="#99CCCC">
<TD><h1>HOSPITAL MANAGEMENT SYSTEM</h1>
</TD>
</TR>
<TR >
<TD>
<pre>
<dl  class="dropdown" style="left:135;" >
  <dt id="one-ddheader" onmouseover="ddMenu('one',1)" onmouseout="ddMenu('one',-1)">DOCTOR</dt>

  <dd id="one-ddcontent" onmouseover="cancelHide('one')" onmouseout="ddMenu('one',-1)">
    <ul>
      <li><a href="addoc.jsp" class="underline">ADD DOCTOR</a></li>
      <li><a href="addoc.jsp" class="underline">UPDATE DOCTOR DETAILS</a></li>
      <li><a href="addoc.jsp" class="underline">DELETE DOCTOR</a></li>
    </ul>
  </dd>
</dl>
<dl style="position:absolute;left:400px;top:75px;width:150px" class="dropdown">
  <dt id="two-ddheader" onmouseover="ddMenu('two',1)" onmouseout="ddMenu('two',-1)">PATIENT</dt>
  <dd id="two-ddcontent" onmouseover="cancelHide('two')" onmouseout="ddMenu('two',-1)">
    <ul>
      <li><a href="addpt.jsp" class="underline">ADD PATIENT</a></li>
      <li><a href="addpt.jsp" class="underline">UPDATE PATIENT DETAILS</a></li>
      <li><a href="dischrg.jsp" class="underline">DISCHARGE PATIENT</a></li>
    </ul>
  </dd>
</dl>
<dl style="position:absolute;left:650px;top:75px;width:100px" class="dropdown">
  <dt id="three-ddheader" onmouseover="ddMenu('three',1)" onmouseout="ddMenu('three',-1)">NURSE</dt>
  <dd id="three-ddcontent" onmouseover="cancelHide('three')" onmouseout="ddMenu('three',-1)">
    <ul>
      <li><a href="adnurse.jsp" class="underline">ADD NURSE</a></li>
      <li><a href="adnurse.jsp" class="underline">UPDATE NURSE</a></li>
      <li><a href="adnurse.jsp" class="underline">DELETE NURSE</a></li>
    </ul>
  </dd>
</dl>
<dl style="position:absolute;left:920px;top:75px;width:150px" class="dropdown">
  <dt id="four-ddheader" onmouseover="ddMenu('four',1)" onmouseout="ddMenu('four',-1)">WORK TIME</dt>
  <dd id="four-ddcontent" onmouseover="cancelHide('four')" onmouseout="ddMenu('four',-1)">
    <ul>
      <li><a href="empattn.jsp" class="underline">EMPLOYEE WORKTIME</a></li>
    </ul>
  </dd>
</dl>
<BR><BR><BR>
<dl class="dropdown">
  <dt id="five-ddheader" onmouseover="ddMenu('five',1)" onmouseout="ddMenu('five',-1)">DEPARTMENT</dt>
  <dd id="five-ddcontent" onmouseover="cancelHide('five')" onmouseout="ddMenu('five',-1)">
    <ul>
      <li><a href="DEPT.jsp" class="underline">DEPARTMENT DETAILS</a></li>
    </ul>
  </dd>
</dl>
<dl  class="dropdown">
  <dt id="six-ddheader" onmouseover="ddMenu('six',1)" onmouseout="ddMenu('six',-1)">MEDICINE</dt>
  <dd id="six-ddcontent" onmouseover="cancelHide('six')" onmouseout="ddMenu('six',-1)">
    <ul>
      <li><a href="addmed.jsp" class="underline">ADD NEW MEDICINE</a></li>
      <li><a href="addmed.jsp" class="underline">UPDATE MEDICINE DETAILS</a></li>
      <li><a href="addmed.jsp" class="underline">DELETE EXPIRED MEDICINE</a></li>
    </ul>
  </dd>
</dl>
<dl  class="dropdown">
  <dt id="seven-ddheader" onmouseover="ddMenu('seven',1)" onmouseout="ddMenu('seven',-1)">REPORT</dt>
  <dd id="seven-ddcontent" onmouseover="cancelHide('seven')" onmouseout="ddMenu('seven',-1)">
    <ul>
      <li><a href="docrep.jsp" class="underline">DOCTOR</a></li>
      <li><a href="patrep.jsp" class="underline">PATIENT</a></li>
      <li><a href="medrep.jsp" class="underline">MEDICINE</a></li>
    </ul>
  </dd>
</dl>
</pre>
</td>
</tr>
</table>
</center>
</body>
</html>