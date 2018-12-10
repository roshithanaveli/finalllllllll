<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.controller.*,com.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<div class="nav-bar">
		</div>
	
		<!-- <link rel="stylesheet" href="quespaper.css"> -->
		<a href="end.jsp"><img src="bg1.jpg"  width="30" height="30"></a>
		    <title>QuestionPaper</title>
	<style>
			body
			{
			         background-image:linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)),url(bg.jpg);
			
			       height:100vh;
			
			       background-size:cover;
			
			       background-position:center;
			
			}
			 .form {
			    position: relative;
			    z-index: 1;
			    background: rgba(7,0,0,0.4);
			    max-width: 360px;
			    margin: 0 auto 100px;
			    padding: 45px;
			    }
			    #otc
			
			{
			
			       color:#66ccff;
			
			       text-align:center;
			
			}.registerdiv
			
			{
			
			       width:500px;
			
			       padding:5% 0 0;
			
			       margin:auto;
			
			}
			.form input {
			    font-family: "Roboto", sans-serif;
			    outline: 1;
			    background: #f2f2f2;
			    size: 4;
			    maxlength: 10;
			    border: 0;
			    margin: 0 0 15px;
			    padding-left: 10px;
			    padding-right: 10px;
			    padding-bottom: 5px;
			    padding-top: 5px;
			    box-sizing: border-box;
			    font-size: 14px;
			    }
    
	</style>
	</head>
	<body>
	       <div class="registerdiv">
			<div class="form">
				<form class="registerform" action="eval" method="post">
					<h2><center><font color=orange>QUESTION PAPER</font></center></h2>
					<% 
						int i=1;
						List<Question> quest = (List<Question>)request.getAttribute("questions");
						for(Question q:quest)
						{
							List<Answer> ans = q.getAnswerList();
							String qt = q.getQuestiontype();
							String comp = qt.matches("Single.+")?"radio":"checkbox";
					%>
						<font color=white><%= i %>&nbsp;.)&nbsp;
						
						<%= q.getQuestiondescription() %></font>
						<br/><br/>
					
					<% 
					
					int count=0;
					
						for(Answer a:ans)
						{
							
							
							if(comp.equalsIgnoreCase("radio"))
							{
					%>
						<%-- <input type="${comp}" name="ans" value="<%= a.getAnswerid() %>"><%= a.getAnswerdescription() %><br/> 
						--%>
						
						 <input type="radio"  name="<%= q.getQuestionid() %>" value="<%= a.getAnswerid() %>"><font color=grey><%= a.getAnswerdescription() %></font><br>
						 <%
							}
							else if(comp.equalsIgnoreCase("checkbox"))
							{
						 %>
						 <input type="checkbox"  name="<%= q.getQuestionid() %>" value="<%= a.getAnswerid() %>"><font color=grey><%= a.getAnswerdescription() %></font><br>
						 <%
							}
							count++;
						%>
					<%		
						}
					i++;
					%>
						
					
					
					<br/>
					<hr/>
					<br/>
					<%
					}
						HttpSession session1=request.getSession();
						session1.setAttribute("qus", quest); 
					%>
					
					
				<input type="submit" value="submit" style='margin-right:10px' />
					
					</form>
					
				
			</div>
		</div>
		
		<script>
			
		</script>
		
	</body>
</html>
