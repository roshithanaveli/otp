<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.controller.*,com.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<div class="nav-bar">
		</div>
		<link rel="stylesheet" href="quespaper.css">
		<a href="end.html"><img src="bg1.jpg"  width="30" height="30"></a>
		    <title>QuestionPaper</title>
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
						<%= i %>&nbsp;.)&nbsp;
						<%= q.getQuestiondescription() %>
						<br/>
					
					<% 
					
					int count=0;
					
						for(Answer a:ans)
						{
							
							
							if(comp.equalsIgnoreCase("radio"))
							{
					%>
						<%-- <input type="${comp}" name="ans" value="<%= a.getAnswerid() %>"><%= a.getAnswerdescription() %><br/> 
						--%>
						
						 <input type="radio" name="<%= q.getQuestionid() %>" value="<%= a.getAnswerid() %>"><%= a.getAnswerdescription() %><br>
						 <%
							}
							else if(comp.equalsIgnoreCase("checkbox"))
							{
						 %>
						 <input type="checkbox" name="<%= q.getQuestionid() %>" value="<%= a.getAnswerid() %>"><%= a.getAnswerdescription() %><br>
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
