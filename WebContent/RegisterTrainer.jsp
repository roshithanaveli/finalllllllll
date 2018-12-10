<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


              <title>Trainer Registration</title>
              
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			
			
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
 <div id=otc>

              <h1>Online Training Portal</h1>

              </div>
<div class="topnav">
  <a  href="Login.jsp">Back to login</a>
  <a href="RegisterTrainee.jsp">Register Trainee</a>
</div>

              <div class="registerdiv">

                     <div class="form">

                           <form class="registerform" action="trainer" method="post">

								<h2><center>REGISTER TRAINER</center></h2><br>
                                  
                                  <font color=red>*</font><label>Name:</label><input type="text" name="name" id="name" placeholder="Name" required><br><br>
                                 
                                  <label>Technology:</label>

                                  <select id="technology" name="technology" required>

                                         <option>  SELECT  </option>

                                         <option>   Java </option>

                                         <option>   .NET  </option>

                                         <option>  SAP  </option>
                                         <option>  C++  </option>

                                  </select><br><br>

                                 

                                  <label>Location:</label>

                                  <select id="location" name="location" required>

                                                <option>  SELECT  </option>

                                                <option>Hyderabad</option>

                                                <option>  Chennai  </option>

                                                <option>  Coimbtore  </option>

                                                <option>  pune  </option>

                                                <option>  kolkata  </option>

                                               

                                  </select><br><br>

                                 

                                  <label>Contact Number:</label><input type="text" name="cn" id="cn" placeholder="MOBILE NUMBER" required><br><br>

 

                                 

                                  <label>Email:</label><input type="email" name="email"  id="email" placeholder="E-MAIL ID" required><br><br>

                                 

                          

                                  <label>UserName:</label><input type="text" name="uname" id="uname" pattern="[a-z0-9]+" placeholder="USERNAME" required><br><br>

                    

                                 

                                  <label>Password:</label><input type="password" name="pass" id="pass" placeholder="PASSWORD" required><br><br>

                                 

                                 

                                  <label>Confirm Password:</label><input type="password" name="cpass" id="cpass" placeholder="CONFIRM PASSWORD" required><br><br>

           
                                  <button type="submit" value="Submit" id="sub">register</button>
									<button type="reset" value="Reset" id="res">reset</button>
									
									
                     </form>
                     {err}

             
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