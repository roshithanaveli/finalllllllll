
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	 	<header>
			<div class="nav-bar"></div>
	        <link rel="stylesheet" href="generatecss.css" />
	        <link rel="stylesheet" href="SetQ.css">
			<a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
		</header>	
		<title>EXAM REPORT</title>
		<style>
			body
			{
			
			       background-image:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url(bg.jpg);
			
			       height:100vh;
			
			       background-size:cover;
			
			       background-position:center;
			
			}
			
			h1
			{
				background-color: black;
				color:white;
			}
			
			.registerdiv
			
			{
			
			       width:500px;
			
			       padding:5% 0 0;
			
			       margin:auto;
			       
			
			}
			
			.form
			
			{
			
			       position:relative;
			
			       z-index:1;
			
			       background:rgba(7,0,0,0.4);
			
			       max-width:500px;
			
			       margin:0 auto 100px;
			
			       padding:45px;
			
			  		text-align:right;
			
			  		margin-right:5px;
			  		
			}		
			.header{
			   width:auto;
			   background-color: black;
				color:white;
			    }
			.left{
			    width:100px;
			    float:left;
			    text-align:left;
			    }
			 .middle
			 {
			 	padding-left: 20px;
			 	padding-right:20px;
			 	text-align:right;
			 	float:left;
			 	
			 }
			.right{
			    width:100px;
			    float:right;
			    text-align:right;
			  }
			  
			  
			  .dateclass
			  {
			   
				color:white;
				float:right;
			  }
			  img{
			  float:right;
				 border-radius: 50%;
				 }
				.topnav {
					  overflow: hidden;
					  background:rgba(7,0,0,0.4);
					}
					
					.topnav a {
					  float: left;
					  color: white;
					  text-align: center;
					  padding: 14px 16px;
					  text-decoration: none;
					  font-size: 17px;
					}
					
					.topnav a:hover {
					  background-color: #ddd;
					  color: black;
					}
					
					.topnav a.active {
					  background-color: #4CAF50;
					  color: white;
					}
									
									  
								}
	
		</style>
	</head>
	<body>
		<div id=otc>
			<h1>Online Training Portal</h1>
       	</div>
       	<div class="topnav">
			<a href="Registertrainerafterlogin.jsp">Register Trainer</a>
			<a href="RegisterTraineeafterlogin.jsp">Register Trainee</a>
			<a href="SetQP.jsp">Set Question Paper</a>
			<a href="AppearExam.jsp">Appear For Exam</a>
			<a href="GenerateExamReportlast.jsp">Generate Exam Report</a>
			<a href="index.jsp" style="float:right">Home</a>
   		</div>
		<sql:setDataSource var="ds"
			driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/otp"
			user="root"
			password="root"
		/>
		<sql:query var="stmt" dataSource="${ds}"
			sql="SELECT te.traineename, te.technology, s.subjectname, e.score
			FROM exam e JOIN trainee te ON(te.userid=e.traineeid)
			JOIN subject s ON(e.subjectid=s.subjectid)
			JOIN question q ON(e.subjectid=q.subjectid)
			WHERE e.examdate='${param.poy}' 
			AND q.trainerid='${param.Trainername}' 
			AND te.location='${param.location}'" 
		/>
		<div class="registerdiv">
			<div class="form">
				<h2><center>Exam Report</center></h2>
				</br>
				<div class="dateclass">
					<label>date: ${param.poy}</label>  <!-- write the code for date  -->
	            </div>
	            </br>
	            </br>
	  			<div class="header">
	  				<div class="left">Trainee Name</div>
	  				<div class="middle">Technology</div>
	  				<div class="middle">Subject</div>
	  				<div class="right">Marks Scored</div>
	  			</div>
	  			</br>
	  			<hr color="black">
	  			<!-- write the code for result set  -->
	  			<c:forEach var="rs" items="${stmt.rows}">
	  				<div class="header">
		  				<div class="left">${rs.traineename}</div>
		  				<div class="middle">${rs.technology}</div>
		  				<div class="middle">${rs.subjectname}</div>
		  				<div class="right">${rs.score}</div>
		  			</div>
		  			</br>
	  			</c:forEach>
	 		</div>
		</div>
	</body>
</html>



