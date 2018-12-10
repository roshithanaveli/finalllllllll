<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
       <head>
     <header>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--  <link rel="stylesheet" href="RegisterTraineeafterlogin.css"> -->
  <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
        <title>Trainer Registration</title>
        <style>
        @CHARSET "ISO-8859-1";
body

{

       background-image:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url(bg.jpg);

       height:100vh;

       background-size:cover;

       background-position:center;

}
/* h2
{
	background-color: black;
	color:white;
} */
#otc

{

       color:#66ccff;

       text-align:center;

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
          float:left;
           height:25px;
       border-radius:10px;

}

.form label

{

       font-family: "Roboto", sans-serif;

       color: #f2f2f2;
       left:auto;
display:inline-block;
       width:auto;
          float:left;

}

.registerdiv [type="button"]
{
	text-align:left;
}

.form select
{
left:auto;
min-width: 150px;
display:inline-block;
float:left;
} 

.aa
{
	float:left;
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
             <a href="Registertrainerafterlogin.jsp">Register Trainer</a>
                     <a href="RegisterTraineeafterlogin.jsp">Register Trainee</a>
                     <a href="SetQP.jsp">Set Question Paper</a>
                     <a href="AppearExam.jsp">Appear For Exam</a>
					  <a href="Generatejsp.jsp">Generate Exam Report</a>
					  <a href="index1.jsp" style="float:right">Home</a>
              </div>
              <div class="registerdiv">
                     <div class="form">
                              <form class="registerform" action="RegisterTrainerafterlogin" method="post">

                                                       <h2><center>REGISTER TRAINER</center></h2><br>
                                                       <table  border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
                                  <tr>
                                  <td align='left'><font color=red>*</font><label>Name:</label></td>
                                  <td><input type="text" name="name" id="name" placeholder="Name" required></td>
                                 </tr>
                                  <tr> <td>&nbsp;</td> </tr> 
                                  
                                  
                                  <tr>
                                  <td align='left'><font color=red>*</font><label>Technology:</label></td>

                                  <td><select id="technology" name="technology" required>

                                         <option>  SELECT  </option>

                                         <option>   Java </option>

                                         <option>   .NET  </option>

                                         <option>  SAP  </option>
                                         <option>  C++  </option>

                                  </select></td>
                                  </tr>
                                    <tr> <td>&nbsp;</td> </tr> 

                                 
                                 
                                 
                                 
                                    <tr>
                                  <td align='left'><font color=red>*</font><label>Location:</label></td>

                                  <td><select id="location" name="location" required>

                                                <option>  SELECT  </option>

                                                <option>Hyderabad</option>

                                                <option>  Chennai  </option>

                                                <option>  Coimbtore  </option>

                                                <option>  pune  </option>

                                                <option>  kolkata  </option>

                                               

                                  </select></td>
                                  </tr>
                                                             <tr> <td>&nbsp;</td> </tr> 
                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font><label>Contact Number:</label></td>
                                  <td><input type="text" name="cn" id="cn" placeholder="MOBILE NUMBER" required></td>
                                 </tr>



                                 
                                                       <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Email:</label></td><td><input type="email" name="email"  id="email" placeholder="E-MAIL ID" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr> 
                                 

                          
                                                                
                                                       <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>UserName:</label></td><td><input type="text" name="uname" id="uname" pattern="[A-Za-z0-9]+" placeholder="USERNAME" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr> 
                    

                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Password:</label></td><td><input type="password" name="pass" id="pass" placeholder="PASSWORD" required></td>
                                                              </tr>
                                        <tr> <td>&nbsp;</td> </tr> 

                                 
                                                              <tr>
                                  <td align='left'><font color=red>*</font>
                                  <label>Confirm Password:</label></td><td><input type="password" id="cpass"name="cpass" id="cpass" placeholder="CONFIRM PASSWORD" required></td>
                                  </tr>
                                                                     <tr> <td>&nbsp;</td> </tr>
           
                                  <tr> <td align='center'><button type="submit" value="Submit" id="sub">register</button></td>
                                    <td align='center'><button type="reset" value="Reset" id="res">reset</button></td></tr>
                                                              
                                              <tr> <td>&nbsp;</td> </tr>                      
                      </table>                                        
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
                             
  </header>
</body>
</html>

