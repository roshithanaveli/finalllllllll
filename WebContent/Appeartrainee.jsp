<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="AppearExam.css" />
<link rel="stylesheet" href="SetQ.css">
  <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
  	<title>Appear for exam</title>
	
</head>
<body>

	<sql:setDataSource
			var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/otp"
			user="root" password="root"
	/>
	<sql:query var="stmt" dataSource="${ds}">
		SELECT * FROM SUBJECT
	</sql:query>
	
	<sql:query var="stmt2" dataSource="${ds}">
		SELECT userid,traineename FROM trainee;
	</sql:query>
	
	<div id=otc><h1>Online Training Portal</h1> </div>
		<div class="topnav">
			<a href="traineeRegistertrainee.jsp">Register Trainee</a>
			<a href="AppearExam.jsp">Appear For Exam</a>
			<a href="index2.jsp" style="float:right">Home</a>
		</div>
	<div class="registerdiv">
		<div class="form">
	       <form action="prepareQues.do" class="registerform" method="post">
	       	<h1><center><font color='orange'>Question Paper</font> </center></h1>
	       	<table  border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
				<tr>
					<td align='center'><label>Technology:</label></td>
					<td> <select id="technology" name="technology">
						 <option value="">SELECT</option>
	                     <option value="JAV">Java</option>
	                     <option value="NET">.NET</option>
	                     <option value="SAP">SAP</option>
	                     <option value="CPP">C++</option>
	              		</select>
	             	</td>
				</tr>
				<tr height="30px"> <td></td><td></td> </tr>
				<tr>
					<td align='center'>   <label>Subject:</label></td>
					<td>
	                   <select name="subject" id="Subject">
							<option value="">SELECT</option>
	                        <c:forEach var="rs" items="${stmt.rows}">
	                           <option value="${rs.subjectid}">${rs.subjectname}</option>
	                        </c:forEach>
						</select>
					</td>    			
				</tr>
				<tr height="30px"> <td></td><td></td> </tr>
				<tr>
				    <td align='center'>  <label>Location:</label></td>
			    	<td>
			    		<select id="location" name="location">
	                           <option>SELECT..  </option>
	                           <option>Hyderabad</option>
	                           <option>Chennai</option>
	                           <option>Coimbtore</option>
	                           <option>Pune</option>
	                           <option>Kolkata</option>
	                     </select>
	                 </td>
				</tr>
				<tr height="30px"> <td></td><td></td> </tr>
				<tr>
				    <td align='center'>  <label>Trainee:</label></td>
				    <td>
	                   <select name="trainee" id="trainee">
							<option value="">SELECT</option>
	                        <c:forEach var="rs2" items="${stmt2.rows}">
	                           <option value="${rs2.userid}">${rs2.traineename}</option>
	                        </c:forEach>
						</select>
					</td>
			    </tr>
				<tr height="30px"> <td></td><td></td> </tr>
				<tr>
					<td align='center'>   
						<input type="submit" value="Next" style='margin-right:10px' />
					</td>
					<td align='center'>
						<input type="reset" style='margin-right:60px' value="Clear" />
					</td>
				</tr>
				<tr height="30px"> <td></td><td></td> </tr>
				</table>
			</form>   
			<br/>
			<br/>
			${msg}          
		</div>
 	 </div>
 </body>
</html>
