<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("one");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
</head>
<body>
<h1>Detail Page</h1>
<!-- 상대경로 -->
<a href="../member/login">Login</a>
<!-- 절대경로 -->
<a href = "/member/join">Join</a>
<a href = "./list">List</a>
<% if(bankBookDTO != null) {%>
<table border = "1">
	<thead>
		<tr>
			<td>BOOKNUM</td>
			<td>BOOKNAME</td>
			<td>BOOKRATE</td>
			<td>BOOKSALE</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%= bankBookDTO.getBooknum() %></td>
			<td><%= bankBookDTO.getBookname() %></td>
			<td><%= bankBookDTO.getBookrate() %></td>
			<td><% if(bankBookDTO.getBooksale()==1){ %>
					판매 중
				<%} else{%>
					판매 종료
				<%} %>
			</td>
		</tr> 
		
	</tbody>
</table>
<% } else{ %>
데이터가 없음
<%} %>
</body>
</html>