<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>.:|Home Page|:.</title>
	<link rel="stylesheet" type="text/css" href="layout.css">
</head>
<body>

	<div class="header">
	  <h1>Online Training Portal</h1>
	</div>
	
	<div class="topnav">
	  <a href="RegisterTrainer.jsp">Register Trainer</a>
	  <a href="RegisterTrainee.jsp">Register Trainee</a>
	  <a href="SetQP.jsp">Set Quetion Paper</a>
	  <a href="AppearExam.jsp">Appear For Exam</a>
	  <a href="Generatejsp.jsp">Generate Exam Report</a>
	  <a href="index.jsp" style="float:right">Home</a>
	</div>
	
	<div class="row">
	  <div class="leftcolumn">
	    <div class="card">
	      <h2>ONLINE TRAINING PORTAL</h2>
	      <h5><%= new java.util.Date() %></h5>
	      <div class="fakeimg" style="height:200px;">Image</div>
	      <p>For Trainers...</p>
	      <ul>
	      	<li>Register Another Trainer</li>
	      	<li>Register New Trainee</li>
	      	<li>Set Question Paper</li>
	      	<li>Generate Report</li>
	      </ul>
	      <br/>
	      <h3>For Trainees...</h3>
	      <ul>
	      	<li>Register Another Trainee</li>
	      	<li>Appear for Exam</li>
	      </ul>
	    </div>
	    
	  </div>
	  <div class="rightcolumn">
	    <div class="card">
	      <h2>About Us</h2>
	      <div class="fakeimg" style="height:100px;"></div>
	      <p>About Us</p>
	    </div>
	  </div>
	</div>
	
	<div class="footer">
	  <h2>Copyright @Online Training Portal</h2>
	</div>

</body>
</html>
