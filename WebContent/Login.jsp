<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
          
           <title>Login</title>
           
           <link rel="stylesheet" href="login.css">
          
	</head>
	<body>
	<!-- heading -->
		<div id=otc>
			<h1>Online Training Portal</h1>
		</div>
		
		<div class="login">
			<div class="form">
				<form class="register-form" action="Login" method="post">
					<!-- mine/ -->
					<!-- <input name="user" type="text" placeholder="username"/><br><br>
					<input name="pass" type="password" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="password"/><br><br>
					 -->
					<!--jwala original -->
					<input name="user" type="text" placeholder="username" pattern="[A-Za-z0-9 ]+" title="Only Alphanumeric"/><br><br>
					<input name="pass" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="password"/><br><br>
					
					<button id=button1 type="submit">login</button>&nbsp;&nbsp;&nbsp;
					<button id=button3 type="reset">reset</button>
					
					<p class ="message">New User? &nbsp; Register Here  &nbsp; <a id=link href="register.jsp">Register</a></p>
					
					
				</form>
				${err}
				${errmsg}
			</div>
		</div>
	</body>

</html>
