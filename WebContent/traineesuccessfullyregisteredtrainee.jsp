<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	 <head>
	 	<meta charset="ISO-8859-1">
           <title>traineesuccessfullyregisteredtrainee</title>
           <link rel="stylesheet" href="endcss.css">
           <link rel="stylesheet" href="setQ.css">
           <link rel="stylesheet" href="traineeRegistertrainee.css">
           <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30">
           </a>
     </head>
     <body>
     	<div id=otc>
          <h1>Online Training Portal</h1>
      	</div>
     	<div class="topnav">
			 <a href="traineeRegistertrainee.jsp">Register Trainee</a>
             <a href="Appeartrainee.jsp">Appear For Exam</a>
             <a href="index2.jsp" style="float:right">Home</a>  
		</div>
        <div class="registerdiv">
          <div class="form">
             <form class="register-form" action="TraineeRegister" method="post">
                <h2><font color =#66ff33>Registration successful! </font></h2>
				<font color =#ffc61a>your user name is: ${usernametre}</font><br><br>
				<font color =#ffc61a>your password is: ${passwordtre}</font><br><br>
				<button id=button1 type="submit"><a href="Login.jsp">Logout and Back To Login</a></button>
				&nbsp;&nbsp;&nbsp;
	          </form>
		</div>
	 </div>
  </body>
</html>