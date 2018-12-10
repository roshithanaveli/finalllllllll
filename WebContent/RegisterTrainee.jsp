<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.controller.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Trainer Registration</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
  			$(document).ready(function(){
  					   $("#technology").change(function(){
  				         
  				            $.ajax({
  				                    type: "GET",
  				                    url: "GetTrainers",
  				                    data: "technology="+$("#technology").val(),
  				                    dataType: "text",
  				                    success: function(result){
  				                    	 var jd = $.parseJSON(result);
  				                        $(jd).each(function (index, data) {
  				                       
  				                            $("#Trainername").append("<option value='"+data.trainername+"'>"+data.trainername+"</option>");
  				                            
  				                        });
  				                       
  				                    }
  				                 
  				                });
  				        });
  				        
  				         
  				        });
        </script>
        <div id="otc">
        	<h1>Online Training Portal</h1>
        </div>
    <style>
			body
			{
				  background-image:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url(bg.jpg);
			
			       height:100vh;
			
			       background-size:cover;
			
			       background-position:center;
			
			}
			center
			{
				 background:rgba(7,0,0,0.4);
				 color: white;
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
			
			       max-width:360px;
			
			       margin:0 auto 100px;
			
			       padding:45px;
			
			  text-align:right;
			
			  margin-right:5px;
			}
			.form input
			{
			    font-family: "Roboto", sans-serif;
			
			       outline:1;
			
			       background: #f2f2f2;
			
			       /* width:"28" height:"20"; */
			
			       size:4;
			
			       maxlength:10;
			
			       border:0;
			
			       margin:0 0 15px;
			
			       padding-left:10px;
			
			       padding-right:10px;
			
			       padding-bottom:5px;
			
			       padding-top:5px;
			
			       box-sizing:border-box;
			
			       font-size:14px;
			}
			#otc
			{
			      color:#66ccff;
			
			       text-align:center;
			}
			.form label
			{
			       font-family: "Roboto", sans-serif;
			
			       color: #f2f2f2;
			
			       width:25%;
			}
			button
			{
				text-color:white;
			    border: none;
			    color: white;
			    padding: 15px 32px;
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    font-size: 16px;
			    margin: 4px 2px;
			    cursor: pointer;
			}
			button {background-color: #008CBA;} /* Blue */
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
		</head>
	<body>
		<div class="topnav">
			  <a  href="Login.jsp">Back to Login</a>
			  <a href="RegisterTrainer.jsp">Register Trainer</a>
		</div>
		<div class="registerdiv">
			<div class="form">
				<form class="registerform" action="trainee" method="post">
					<h2><center>REGISTER TRAINEE</center></h2>
					<label>Name:</label>
					<input type="text" name="name" id="name" placeholder="Name"><br><br>
					<label>Technology:</label>
					<select id="technology" name="technology">
					 <option>  SELECT  </option>
					 <option>   Java </option>
					 <option>   .NET  </option>
					 <option>  SAP  </option>
					 <option>  C++  </option>
					 </select><br><br>
					 <label>Location:</label>
					 <select id="location" name="location">
					 <option>  SELECT  </option>
					 <option>Hyderabad</option>
					 <option>  Chennai  </option>
					 <option>  Coimbtore  </option>
					 <option>  pune  </option>
					 <option>  kolkata  </option>
					 </select>
					 <br><br>
					 <label>Contact Number:</label><input type="text" name="cn" id="cn" placeholder="MOBILE NUMBER"><br><br>
   					 <label>Trainer:</label>
					<select id="Trainername" name="Trainername">
					<option>  SELECT  </option>
					</select><br><br>
                    <label>Domain:</label><input type="text" name="domain" id="domain" placeholder="DOMAIN"><br><br>
                    <label>Education:</label><input type="text" name="edu" id="edu" placeholder="EDUCATION"><br><br>
					<label>Pass out Year:</label><input type="text" name="poy" id="poy" placeholder="PASSOUT YEAR"><br><br>
					<label>UserName:</label><input type="text" name="uname" id="uname" placeholder="USERNAME"><br><br>
					<label>Password:</label><input type="password" id="pass" name="pass" id="pass" placeholder="PASSWORD"><br><br>
					<label>Confirm Password:</label><input type="password" id="cpass" name="cpass" id="cpass" placeholder="CONFIRM PASSWORD"><br><br>
					<button type="submit" value="Submit" id="sub">register</button>
					<button type="reset" value="Reset" id="res">reset</button>
							
					</form>
		
					</div>
					</div>
			<script type="text/javascript">
					    $(function () {
					        $("#sub").click(function () {
					            var password = $("#pass").val();
					            var confirmPassword = $("#cpass").val();
					            if (password != confirmPassword) {
					                alert("Passwords do not match.");
					                return false;
					            }
					            return true;
					        });
					    });
		</script> 
		<script type="text/javascript">
		
		    $(function () {
		        $("#sub").click(function () {
		            var password = $("#pass").val();
		            var username = $("#uname").val();
		            if (password == username) {
		                alert("Password and username are same.");
		                return false;
		            }
		            return true;
		        });
		    });
		</script>
</body>
</html>