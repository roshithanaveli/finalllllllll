<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" import="java.util.*,com.controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
 		<header>
        	<div class="nav-bar"></div>
           <!--  <link rel="stylesheet" href="quespaper.css"> -->
            <link rel="stylesheet" href="SetQ.css">
  			<a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
        </header>
        <style>
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
        	
        </style>
     	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Trainer Registration</title>
  		<script>
   			$(document).ready(function(){
        		$("#location").change(function(){
        			$.ajax({
        				type: "GET",
        				url: "GetTrainees",
        				data: "location="+$("#location").val(),
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
        </script>
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
			 <a href="Generatejsp.jsp">Generate Exam Report</a>
			 <a href="index1.jsp" style="float:right">Home</a>
		</div>
		 <div class="registerdiv">
			<div class="form">
				<form class="registerform" action="GenerateExamReportlast.jsp" method="post">
					<h2><center>
						<font color=orange>Generate Report</font>
					</center></h2>
					<table  border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
						<tr>
						    <td align='left'><font color=red>*</font> <label>Date</label></td>
						    <td>
						      <input type="Date" name="poy" id="poy" placeholder="date" height="20"  required>
					      	</td>
						</tr>
						<tr> <td>&nbsp;</td> </tr>
						<tr>
  							 <td align='left'> <font color=red>*</font> <label>Location:</label>
							 </td>
    						 <td>
    						 	<select id="location" name="location">
									<option>  SELECT  </option>
									<option>Hyderabad</option>
									<option>  Chennai  </option>
									<option>  Coimbtore  </option>
                                    <option>  pune  </option>
                                    <option>  kolkata  </option>                                             
                                </select>
                              </td>
						</tr>
						<tr><td>&nbsp;</td> </tr>
						<tr>
						    <td align='left'><font color=red>*</font> <label>Trainer:</label></td>
							<td>
								<select id="Trainername" name="Trainername">
									<option>  SELECT  </option>
							 	</select>
						 	</td>
						</tr>
						<tr> <td>&nbsp;</td> </tr>
						<tr> <td>&nbsp;</td> </tr>
						<tr>
							<td align='center'>
								<input type="submit" value="Generate" id="sub">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	<!-- 	<script>
		function validateForm() {
      	  
      	  var today = new Date();
      	  var inputDateStr = document.getElementById("poy").value;
      	  
      	  console.log(inputDateStr.substring(0, 10));
      	  
      	  var inputDate = new Date(inputDateStr.substring(0, 10));
      	  
      	  console.log(today.getTime());
      	  console.log(inputDate.getTime());
      	  
      	  var date1_ms = today.getTime();
      	  var date2_ms = inputDate.getTime();
      	  
      	  var difference_ms = date2_ms - date1_ms;
      	  //take out milliseconds
      	  difference_ms = difference_ms/1000;
      	  var seconds = Math.floor(difference_ms % 60);
      	  difference_ms = difference_ms/60; 
      	  var minutes = Math.floor(difference_ms % 60);
      	  difference_ms = difference_ms/60; 
      	  var hours = Math.floor(difference_ms % 24);  
      	  var days = Math.floor(difference_ms/24);
      	  
      	  console.log(days);
      	  
      	  if(days < 1) {
      	  	return true;
      	  }
      	  else {
      		  
      		$("#errmsg").html("<font color=red>Please enter a past date!</font>");  
      		  
      	  	return false;
      	  }
      	  
        }
		</script> -->
	</body>
</html>