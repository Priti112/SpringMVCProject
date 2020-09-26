<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
<h1>Book List</h1>
<h2>
	<a href="new">Add New Book</a>
	&nbsp;&nbsp;&nbsp;
	<a href="list">List all Book</a>
</h2>
<table border="1">
<tr>
   <th>ID</th>
   <th>Name</th>
   <th>Price</th>
   <th colspan="2">Actions</th>

<c:forEach var="book" items="${listBook}">
<tr>
   <td>${book.id}</td>
   <td>${book.name}</td>
   <td>${book.price}</td>
   <td>
   <a href="edit/${book.id}">Edit</a>
   &nbsp;&nbsp;&nbsp;
   <a onclick="return confirm('Are you sure you want to delete')" href="delete/${book.id}">Delete</a>
   </td>
</tr>   
</c:forEach>  
</table>
</body>
</html>