<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<h1>List Page</h1>
<table border="1">
	<thead>
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${blist}" var="bdto">
			<tr> 
	 			<td>${bdto.textNum}</td>
	 		<td><a href="./detail.do?textNum=${bdto.textNum}">
	 			${bdto.tName}</a></td>
	 			<td>${bdto.writer}</td>
	 			<td>${bdto.wDate}</td>
	 			<td>${bdto.viewNum}</td>
	 		</tr>
		</c:forEach>	
</tbody>
<br>
<a href="./detail.do">글 상세보기</a><br>
<c:if test="${not empty sessionScope.member}">
<a href="./add.do">글 작성하기</a>
</c:if>

</body>
</html>