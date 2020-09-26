<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entry Page</title>
</head>
<body>
<h1>Book Entry</h1>
<form:form action="/SpringMVCProject/save" method="post">
<form:hidden path="id"/>
<table border="1">
<tr>
   <th>Name:</th>
   <td><form:input path="name"/></td>
</tr>
<tr>
   <th>Price:</th>
   <td><form:input path="price"/></td>
</tr>               
<tr>
   <td></td>
   <td><input type="submit" name="submit" value="submit"></td>
</tr>   
</table>
</form:form>
</body>
</html>





