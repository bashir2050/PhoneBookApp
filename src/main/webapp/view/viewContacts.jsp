<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">     
	<title>Spring Boot Application</title>
	<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>	
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
<script >
    $(document).ready(function() {
        $('#contactTbl').DataTable( {
            "pagingType": "full_numbers"
        });
    });

    function confirmDelete(){
	   return confirm("are you sure, you want to delete?");
    }
    
</script>
</head>
<h3> view contacts </h3>
<a href="addContact">Add New Contact</a>
<body>
<table  border=1 id="contactTbl">
<thead>
<tr>
<th>S.NO</th>
<th>Name</th>
<th>Email</th>
<th>Phno</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${msg}" var="c" varStatus="index" >
<tr>
<td>${index.count}</td>
<td>${c.contactName }</td>
<td>${c.contactEmail }</td>
<td>${c.contactNumber }</td>
<td><a href="editContact?cid=${c.contactId }">Edit</a>
<a href="deleteContact?cid=${c.contactId }" onclick="confirmDelete()">Delete</a></td>
</c:forEach>
</tr>
</tbody>
</table>
</body>
</html>