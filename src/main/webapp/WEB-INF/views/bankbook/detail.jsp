<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
<a href="../member/login.do">Login</a>
<!-- 절대경로 -->
<a href = "/member/join.do">Join</a>
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
 			<td>${one.booknum}</td>
			<td>${one.bookname}</td>
			<td>${one.bookrate}</td>
			<td>${one.booksale}</td>
		</tr> 
		
	</tbody>
</table>
<br>
<a href = "./list.do">리스트 보기</a>
<br><br>
<a href= "./update.do?booknum=${one.booknum}">수정하기</a>
<a href="./delete.do?booknum=${one.booknum}">삭제하기</a>
<c:if test="${not empty sessionScope.member}">
<a href="../bankAccount/add.do?booknum=${one.booknum}">가입하기</a>
</c:if>

</body>
</html>