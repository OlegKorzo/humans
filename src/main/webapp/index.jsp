<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
                                 "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Plugin tester</title>
</head>
 
<body>
    <h2>Check of existing user</h2>
    ${answer}
    <br/>
     <%
     	String userId = "";	
     	String userName = "";
     	String userAge  = "";
     	
     	try {
     		userId = request.getAttribute("uid").toString();
     		userName = request.getAttribute("uname").toString();
     		userAge = request.getAttribute("uage").toString();
 		} catch (Exception e) {
 			userId = "-1";
 			userName = "";
 			userAge  = "";
 		}
     	
     	userId = request.getAttribute("uid").toString();
     	
     	
     	if (userId.equals("-1")) {%>
     	no such user
     <%
     	} else { 
     %> <%= userName%> is <%= userAge%>, id=<%= userId%> 
     <%} %>
     
	
    <form action = "userlist" method = "GET">
    	<table border = "0">
    		<tr>
        		<td><b>Username</b></td>
        		<td><input type = "text" name = "user" value = "${uname}" size = "70"/></td>
    		</tr>
    		<tr>
        		<td colspan = "2"><input type = "submit" value = "Check"/></td>
    		</tr>
    	</table>
    </form>
    
    <br/><br/><br/><br/><br/>
    
    <h3>Add new user</h3>
    <form action = "useradd" method = "GET">
		<table border = "0">
    		<tr>
        		<td><b>Username</b></td>
        		<td><input type = "text" name = "user" value = "" size = "70"/></td>
    		</tr>
    		<tr>
        		<td><b>Age</b></td>
        		<td><input type = "text" name = "age" value = "" size = "70"/></td>
    		</tr>
    		<tr>
        		<td><b>Profession</b></td>
        		<td>
        			<select name = "p_name">
				    	<c:forEach var="section" items="${plist}">
							<option value="${section.name}">${section.name}</option>
						</c:forEach>
					</select>
        		</td>
    		</tr>
    		<tr>
        		<td colspan = "2"><input type = "submit" value = "Add"/></td>
    		</tr>
    	</table>
    </form>
    
    
    
</body>
</html>