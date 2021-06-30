<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New</title>
<!-- <script type="text/javascript" src = "detail.js"></script> -->
<!-- <script type="text/javascript"> -->
<!-- </script> -->

</head>
<body>
	Registration Form
	<form action="createNew" method="post">
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
<!-- 		<button type = "submit" onclick="mySave(this)" id = "submit_id" >Submit</button> -->
		<input type="submit">
	</form>
</body>
</html>