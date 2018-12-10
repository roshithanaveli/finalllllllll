<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="SetQ.css">
	 <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
	<title>Set Question Paper</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
		/* Ajax Function */
			$(document).ready(function(){
					   $("#technology").change(function(){
				          $("#Trainername").html("");
				          alert($("#technology").val());
				            $.ajax({
				                    type: "GET",
				                    url: "trainee",
				                    data: "technology="+$("#technology").val(),
				                    dataType: "text",
				                    success: function(result){
				                    	 var jd = $.parseJSON(result);
				                        $(jd).each(function (index, data) {
				                       
				                            $("#Trainername").append("<option value='"+data.trainerid+"'>"+data.trainername+"</option>");
				                            
				                        });
				                       
				                    }
				                 
				                });
				        });
				        
				         
		        });
			
		 /* User Function */
          var cmt=1;
          function myFunction() 
          {
        	  alert($("#anscnt").val());
                var qt = $("#qtype").val();
                var opt = (qt=="Multiple Choice")?"checkbox":"radio";
                var chk = "<input type='"+opt+"' name='anschk' value='ans"+cmt+"' />";
                
                 var comp="<input type='text' name='anstxt"+cmt+"'/><br/>";
                 $("#ans").append(chk+comp);
                 
                 cmt=cmt+1;
                 $("#anscnt").val(cmt-1);      
          }
          
	</script>
</head>
<body>
	<sql:setDataSource
		var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/otp"
		user="root" password="root"
	/>
	<sql:query var="stmt" dataSource="${ds}">
		SELECT * FROM SUBJECT
	</sql:query>


         
	<div id=otc><h1>Online Training Portal</h1></div>
	<div class="topnav">
				<a href="Registertrainerafterlogin.jsp">Register Trainer</a>
	  		<a href="RegisterTraineeafterlogin.jsp">Register Trainee</a>
	  		<a href="SetQP.jsp">Set Question Paper</a>
	  		<a href="AppearExam.jsp">Appear For Exam</a>
	  		<a href="Generatejsp.jsp">Generate Exam Report</a>
	  		<a href="index1.jsp" style="float:right">Home</a>
				  	
			</div>
              <div class="registerdiv">
                  <div class="form">
                       <form class="registerform" action="SetQ" method="post">
                        	<h1><center><font color=orange>Set Question Paper</font></center></h1>
             			 	<table  name= 'suji' border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
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
								<tr> <td>&nbsp;</td> </tr>
								<tr>
								    <td align='center'>  <label>Location:</label></td>
								    <td><select id="location" name="location">
                                            <option>SELECT..  </option>
                                            <option>Hyderabad</option>
                                            <option>Chennai</option>
                                            <option>Coimbtore</option>
                                            <option>Pune</option>
                                            <option>Kolkata</option>
                              			</select>
                           			</td>
								</tr>
								<tr> <td>&nbsp;</td> </tr>
								<tr>
									<td align='center'><label>Trainer:</label></td>
									<td>
			                             <select id="Trainername" name="Trainername">
													<option value="">SELECT..</option>
			      						</select></td>
								</tr>
								<tr> <td>&nbsp;</td> </tr>
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
								<tr> <td>&nbsp;</td> </tr>
								<tr>
									<td align='center'>  <label>Question Type:</label></td>
									 <td>
                                 		<select name="qtype" id="qtype" name="qtype">
                                        	<option>SELECT</option>
                                       		 <option val="2">Multiple Choice</option>
                                        	<option val="1">Single Choice</option>
                                 		</select>
                                 	</td>
                               </tr>
                               
                              	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                                <tr>
                                   <td align='center'><label>Question Description:</label></td>
                                   <td>
                                       <input type="textarea" height="5" name="aq" id="aq" placeholder="Type Question">
                                   </td>
                               	</tr>
                                <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                                <tr>
                                    <td align='center'>
                                        <div id="addans">
                                            <button type="button" onclick="myFunction()" class="aa">Add Answer</button>
             							</div>
     							  	</td>
     							  	<td><input type="text" name="anscnt" id="anscnt" hidden="true" readonly />
								</tr>
								<tr>
       								<td>&nbsp;</td>
    							   <td><div id="ans"></div></td>
								</tr>
								
								<tr>
  								  <td align='center'>  
          					      <button type="submit" value="Submit" id="sub">Submit</button>
   								 </td>
  									<td align='center'>
     								   <button type="reset" value="Reset" id="res">reset</button>
    								</td>
								</tr>
								<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
             	       </table>     
           		   </form>           
			</div>
		</div>
	</body>
</html>