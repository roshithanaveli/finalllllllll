
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>.:|Home Page|:.</title>
       <link rel="stylesheet" type="text/css" href="homepage.css">
       <link rel="stylesheet" type="text/css" href="Registertrainerafterlogin.css">
       
  <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
</head>
<body>

       <div class="row1">
       <div class="header">
         <h1>ONLINE TRAINING PORTAL</h1>
       </div>
       </div>
       
       <div class="topnav">
        <a href="traineeRegistertrainee.jsp">Register Trainee</a>
             <a href="Appeartrainee.jsp">Appear For Exam</a>
         <a href="index2.jsp" style="float:right">Home</a>
       </div>
       
       <div class="row">
         <div class="leftcolumn">
           <div class="card">
            
             <h5><%= new java.util.Date() %></h5>
              <h3><font color=yellow >Welcome Trainee...</font></h3>
             <ul>
             <li type="circle">Register Another Trainee</li>
             <li type="circle">Appear for Exam</li>
             </ul> 
           </div>
           
         </div>
         <div class="rightcolumn">
           <div class="card">
             <h2>About Us</h2>
         
             <ul><font color=yellow >Wecome to the Online Training Portal!</font> <br><br> 
             "You cannot teach a man anything.<br> You can only help him discover it within himself."
             <br>-Galileo Galilei<br><br>Here you can find lot of exciting tests on various technologies.<br>
             All the best!</ul>

         </div>
       </div>
       
       

</body>
</html>
