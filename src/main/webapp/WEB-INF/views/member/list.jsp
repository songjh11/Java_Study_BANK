<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankmember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>
<form action="search", method="POST">
<%if(ar != null){ %>
<table border="1">
	<thead>
		<tr>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
		</tr>
	</thead>
	<tbody>
		<% for(BankMembersDTO b: ar){ %>
			<tr>
				<td><%= b.getUsername() %></td>
				<td><%= b.getPassward() %></td>
				<td><%= b.getName() %></td>
				<td><%= b.getEmail() %></td>
				<td><%= b.getPhone() %></td>
				</tr>
		<%} %> 
	</tbody>
</table>
<%} else{ %>
데이터가 없음
<%} %>
</form>
</body>
</html>