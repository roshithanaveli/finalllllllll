<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>your result</title>

<link rel="stylesheet" href="Registertrainerafterlogin.css" />
<link rel="stylesheet" href="SetQ.css">
  <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
</head>
<body>
	<div id=otc><h1>Online Training Portal</h1> </div>
	<div class="topnav">
		<a href="index2.jsp" style="float:right">Home</a>
	</div>
	<div class="registerdiv">
		<div class="form">
      	 <form action="prepareQues.do" class="registerform" method="post">
       		<!-- <h1><center><font color='orange'></font> </center></h1> -->
			<h1 style="color:white"> your score is</h1>
			<h1 style="color:white">${result}</h1>h1>
			</form>   
		<br/>
		<br/>        
	</div>
	</div>
</body>
</html>