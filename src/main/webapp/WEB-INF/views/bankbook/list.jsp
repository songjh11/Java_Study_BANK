<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%
    	//스크립틀릿 형태 <% Java 코드 작성 시 사용% >
    	//표현식 HTML <%=자바변수 또는 값% >
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook List</title>
</head>
<body>
	<h1>BankBook Page</h1>
<!-- /bankbook/list<-이 주소를 클릭했을때 이 페이지가 보이도록 -->


<table border = "1">
	<thead>
		<tr>
			<th>BOOKNAME</th> 
			<th>BOOKRATE</th> 
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./detail.do?booknum=${dto.booknum}">
					${dto.bookname}</a></td>
					<td>${dto.bookrate}</td>
				</tr>
			</c:forEach>		
	</tbody>

</table>
<br>
<!-- /bankbook/detail -->
<!-- 링크 주소는 상대경로 작성 -->
<a href = "add.do">상품등록</a>



</body>
</html>