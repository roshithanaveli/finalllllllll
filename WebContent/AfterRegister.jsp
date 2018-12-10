<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Registration</title>
	<div id=otc>
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
			#otc
			{
				 color:#66ccff;
				 text-align:center;
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
			button {
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
			.form label
			{
				font-family: "Roboto", sans-serif;
				color: #f2f2f2;
				width:25%;
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
</style>
</head>
<body>

  <div class="login">
      <div class="form">
          <form class="register-form">
               <button id=button1 type="submit"><a href="#">trainer</a></button>
               <button id=button2 type="submit"><a href="#">trainee</a></button>
			</form>
		</div>
	</div>           
</body>
</html>