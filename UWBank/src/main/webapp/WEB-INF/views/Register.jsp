<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link href="css/Style.css" rel="stylesheet" media="all">
</head>
<body>


	<sf:form method="post" action="doRegister" modelAttribute="customer">
		<h4>Please register for a current account here .</h4>
		<h4>Enter your details below:</h4>

		Title<sf:select path="title" required="required">
					<sf:option value="Mr">Mr</sf:option>
					<sf:option value="Mrs">Mrs</sf:option> </>
					<sf:option value="Ms">Ms</sf:option> </>
					<sf:option value="Dr">Dr</sf:option> </>
			</sf:select>

		First Name <sf:input type="text" path="firstName" required="required" />
		<br /> 
		Last Name <sf:input type="text" path="lastName" required="required" />
		<br /> 	
		Username <sf:input type="text" path="username" required="required" />
		<br /> 
		Password <sf:password path="password" required="required" />
		<br /> 
		Confirm Password <sf:password path="confirmPassword" required="required" />
		<br />
		Email <sf:input type="text" path="emailAddress" required="required" />
		<br />
		Contact Number <sf:input type="text" path="phoneNumber"
			required="required" />
		<br /> 
		Address<sf:input type="text" path="address" required="required" />
		<br />
		Date of Birth: please enter in the format dd/mm/yyyy <sf:input
			path="dobString" required="required" />
		<input type="submit" value="Register">
	</sf:form>
</body>
</html>