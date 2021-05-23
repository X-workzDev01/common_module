<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<header>hello </header>
	<body>
		${msg} 
		<form action="registration.mod" method="post">
			<div>
				<label>FullName : </label>
				<input type="text" name="fullName">
			</div>
			<div>
				<label>EmailId : </label>
				<input type="email" name="EmailId">
			</div>
			<div>
				<label>DOB : </label>
				<input type="date" name="dob">
			</div>
			<div>
				<label>Contact : </label>
				<input type="number" name="contact">
			</div>
			<div>
				<label>Address : </label>
				<input type="text" name="address">
			</div>
			<div>
				<label>Gender : </label>
				<input type="radio" name="gender" value="male">Male
				<input type="radio" name="gender" value="female">Female
				<input type="radio" name="gender" value="others">Others
				
			</div>
			<div>
				<label>Password : </label>
				<input type="password" name="password">
			</div>
			<div>
				<label>Cnf Password : </label>
				<input type="password" name="cnfPassword">
			</div>
			
			<input type="submit" value="save">
			<input type="reset" value="reset">
		
		
		</form>	
	</body>
	<footer>footer</footer>
</html>