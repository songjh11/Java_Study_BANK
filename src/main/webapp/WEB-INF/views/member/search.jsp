<%@page import="com.iu.start.bankmember.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%BankMembersDTO bankMembersDTO = new BankMembersDTO(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Search Page</h1>

<form action="search.do" method="POST">
	회원 이름 입력: <input type="text" name="search">
	<button type="submit">검    색</button>
</form>

</body>
</html>