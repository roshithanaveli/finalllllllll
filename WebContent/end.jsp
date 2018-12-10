<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

       <head>

              <meta charset="ISO-8859-1">

              <title>Login</title>

              <link rel="stylesheet" href="endcss.css">

              <div id=otc>

              <h1>Online Training Portal</h1>

              </div>

       </head>

       <body>

              <div class="login">

                     <div class="form">

                           <form class="register-form">

                                                <h2><font color =#66ff33>your successfully logged-out </font></h2>
                                                <%
                                                HttpSession SESSION=request.getSession();
                                    			
                                                SESSION.invalidate();
                                                %>
                                                              <button id=button1 type="submit"><a href="Login.jsp">Back To Login
                                                              </a></button>
                           	 &nbsp;&nbsp;&nbsp;
                            </div>
                               
                             </form>

                     </div>

              </div>



       </body>

</html>








