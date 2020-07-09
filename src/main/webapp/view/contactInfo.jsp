<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	
	<style type="text/css">
	
	@import url("https://fonts.googleapis.com/css?family=Open+Sans");

/* Styles */
* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Open Sans";
  font-size: 14px;
}

.container {
  width: 500px;
  margin: 25px auto;
}

form {
  padding: 20px;
  background: #2c3e50;
  color: #fff;
  -moz-border-radius: 4px;
  -webkit-border-radius: 4px;
  border-radius: 4px;
}
form label,
form input,
form button {
  border: 0;
  margin-bottom: 3px;
  display: block;
  width: 100%;
}
form input {
  height: 25px;
  line-height: 25px;
  background: #fff;
  color: #000;
  padding: 0 6px;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
form button {
  height: 30px;
  line-height: 30px;
  background: #e67e22;
  color: #fff;
  margin-top: 10px;
  cursor: pointer;
}
form .error {
  color: #ff0000;
}
	
	</style>

<script type="text/javascript">

$(function() {
	  // Initialize form validation on the registration form.
	  // It has the name attribute "registration"
	  $("form[name='registration']").validate({
	    // Specify validation rules
	    rules: {
	      // The key name on the left side is the name attribute
	      // of an input field. Validation rules are defined
	      // on the right side
	      contactName: "required",
	     
	      contactEmail: {
	        required: true,
	        // Specify that email should be validated
	        // by the built-in "email" rule
	       email: true
	      },
	      contactNumber: {
	        required: true,
	        minlength: 5
	      }
	    },
	    // Specify validation error messages
	    messages: {
	    	contactName: "Please enter your firstname",
	     
	    	contactNumber: {
	        required: "Please provide a contactNumber",
	       
	      },
	      contactEmail: "Please enter a valid email address"
	    },
	    // Make sure the form is submitted to the destination defined
	    // in the "action" attribute of the form when valid
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	});

</script>
</head>
<body>

<h2> Save Contact</h2>
<p><font color='green'>${successMsg}</font></p>
<p><font color='red'>${errorMsg}</font></p>

<form:form action="saveContact" modelAttribute="contact" method="post" name="registration">
<table>

<tr>
<form:hidden path="contactId"/>
<td>contactName</td>
  
<td><form:input path="contactName" name="contactName"/></td>
</tr>
<tr>
<td>contactEmail</td>

<td><form:input path="contactEmail" name="contactEmail"/></td>
</tr>
<tr>
<td>contactNumber</td>
<td><form:input path="contactNumber"  name="contactNumber"/></td>
</tr>

<tr>
<td><input type="reset" value="Reset"/></td>
<td><input type="submit" value="Save"></td>
</tr>

</table>
</form:form>
<a href="viewContact">View All Contacts</a>
</body>
</html>