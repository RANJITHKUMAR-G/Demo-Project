<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New</title>

</head>
<body>
	Edit Registration Form
	<form action="edit" method="post">
	    ID : <input type="text" name=id  id="id" readonly="readonly" >
		<br>
		First Name : <input type="text" name=name  id="fistName">
		<br>
		D.O.B : <input type="date" name=date id="dob">
		<br> 
		Gender : <input type="radio" id="male" name="gender" value="male"> 
		<label for="male">Male</label>
		<input type="radio" id="female" name="gender" value="female">
		<label for="female">Female</label> 
		<input type="radio" id="other" name="gender" value="other"> 
		<label for="other">Other</label>
		<br>
		<input type="submit">
	</form>
</body>
</html>