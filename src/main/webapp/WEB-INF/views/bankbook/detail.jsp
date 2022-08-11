<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <% //요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope(Request영역)
    	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("one");
    %> --%>
    
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
<br><br>
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
 			<td>${requestScope.one.getBooknum()}</td>
			<td>${requestScope.one.bookname}</td>
			<td>${one.bookrate}</td>
			<td>${one.booksale}</td>
		</tr> 
		
	</tbody>
</table>
<br>
<a href = "./list">리스트 보기</a>
<br><br>
<a href= "./update?booknum=${one.booknum}">수정하기</a>
<a href="./delete?booknum=${one.booknum}">삭제하기</a>
</body>
</html>