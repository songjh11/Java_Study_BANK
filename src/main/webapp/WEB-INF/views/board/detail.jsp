<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
</head>
<body>
<h1>Detail Page</h1>
<table border="1">
	<thead>
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<tr>
				<td>${bdetail.textNum}</td>
	 			<td>${bdetail.tName}</td>
	 			<td>${bdetail.writer}</td>
	 			<td>${bdetail.wDate}</td>
	 			<td>${bdetail.viewNum}</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>내                   용</td>
		</tr>
		<tr>
				<td>${bdetail.tContents}</td>
		</tr>
	</tbody>
</table><c:if test="${not empty sessionScope.member}">
<a href="./update.do?textNum=${bdetail.textNum}">글 수정하기</a>
<a href="./delete.do">글 삭제하기</a>
</c:if>
</body>
</html>