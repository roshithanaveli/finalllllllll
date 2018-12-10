<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="RegisterTraineeafterlogin.css">
<link rel="stylesheet" href="SetQ.css">
  <a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

                     
              <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
               <script>
                           $(document).ready(function(){
                                            $("#technology").change(function(){
                                                   $("#Trainername").html("");
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
       
<title>Traineehomepage</title>

</head>
<body>
<div id=otc>
                     <h1>Online Training Portal</h1>
              </div>
<div class="topnav">
             <a href="traineeRegistertrainee.jsp">Register Trainee</a>
             <a href="Appeartrainee.jsp">Appear For Exam</a>
             <a href="index2.jsp" style="float:right">Home</a>  
</div>
          <div class="registerdiv">

                     <div class="form">

                           <form class="registerform" action="TraineeRegister" method="post">

                               <h2><center>REGISTER TRAINEE</center></h2>
                              
                               <table  border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
                                                              
                                 
                                 
                                 <tr>
                                               <td align='left'><font color=red>*</font><label>Name:</label></td><td>

                                  <input type="text" name="name" id="name" placeholder="Name"></td>
                                  </tr>

                                         <tr> <td>&nbsp;</td> </tr>
                                 
                                 
                                 
                                 
                                                               
                                 <tr>
                                               <td align='left'><font color=red>*</font>
                                  <label>Technology:</label></td><td>

                                  <select id="technology" name="technology">

                                         <option>  SELECT  </option>

                                         <option>   Java </option>

                                         <option>   .NET  </option>

                                         <option>  SAP  </option>

                                         <option>  C++  </option>
                                   
                                  </select></td>
                                  </tr>
                                                              <tr> <td>&nbsp;</td> </tr>
                                 

                                   <tr>
                                               <td align='left'><font color=red>*</font>
                                               <label>Location:</label></td><td>

                                  <select id="location" name="location">

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
                                               <td align='left'><font color=red>*</font><label>Contact Number:</label></td><td><input type="text" name="cn" id="cn" placeholder="MOBILE NUMBER"></td>
                                               </tr>
                                                <tr> <td>&nbsp;</td> </tr>
   
                                                      <tr>
                                               <td align='left'><font color=red>*</font> <label>Trainer:</label></td><td>

                                  <select id="Trainername" name="Trainername">

                                                <option>  SELECT  </option>


   
                                  </select></td>
                                  </tr>
                                   <tr> <td>&nbsp;</td> </tr>
                                  
                                 <tr>
                                               <td align='left'><font color=red>*</font><label>Domain:</label></td><td><input type="text" name="domain" id="domain" placeholder="DOMAIN"></td>
                                               </tr>
                                                <tr> <td>&nbsp;</td> </tr>
                                               
                                               
                                  
                                                       <tr>
                                               <td align='left'><font color=red>*</font><label>Education:</label></td><td><input type="text" name="edu" id="edu" placeholder="EDUCATION"></td>
                                               </tr>
                                                              <tr> <td>&nbsp;</td> </tr>
                                                     
                                                     
                                                       <tr>
                                               <td align='left'><font color=red>*</font><label>Pass out Year:</label></td><td><input type="text" name="poy" id="poy" placeholder="PASSOUT YEAR"></td>
                                               </tr>
                                                              <tr> <td>&nbsp;</td> </tr>


                                       <tr>
                                               <td align='left'><font color=red>*</font><label>UserName:</label></td><td><input type="text" name="uname" id="uname" placeholder="USERNAME"></td>
                                                              </tr>
                                                              <tr> <td>&nbsp;</td> </tr>

                                       <tr>
                                               <td align='left'><font color=red>*</font><label>Password:</label></td><td><input type="password"  id="pass" name="pass" id="pass" placeholder="PASSWORD"></td>
                                                                     </tr>
                                                              <tr> <td>&nbsp;</td> </tr>
                                 
                                       <tr>
                                               <td align='left'><font color=red>*</font><label>Confirm Password:</label></td><td><input type="password"  name="cpass" id="cpass" placeholder="CONFIRM PASSWORD"></td>
                                               </tr>
                                                              <tr> <td>&nbsp;</td> </tr>
                                                              

                                   <tr> <td align='center'><button type="submit" value="Submit" id="sub">register</button></td>
                                        <td align='center'>   <button type="reset" value="Reset" id="res">reset</button></td></tr>
                                         
                                         
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
</body>
</html>
