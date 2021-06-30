<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
function mySave(){
 	document.getElementById("fistName").disabled = true;
 	document.getElementById("dob").disabled = false;
 	document.getElementById("male").disabled = false;
 	document.getElementById("female").disabled = false;
 	document.getElementById("other").disabled = false;
 }
 $(document).ready(function(){
	 $ajax("getDetails",{
		 type:"post",
		 async:false,
		 success: function(resultData){
			 console.log("Success");
//			 document.getElementById("fistName").value = ;
		 }
	 });
 })
</script>
<body>${message} ${errorMessage}
Registration Form
	<form>
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
		</form>
</body>
</html>