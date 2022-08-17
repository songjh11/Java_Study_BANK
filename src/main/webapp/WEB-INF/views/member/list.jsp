<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>List Page</h1>
<form action="search", method="POST">

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

	 	<c:forEach items="${list}" var="dto">
	 		<tr> 
	 			<td>${pageScope.dto.userName}</td>
	 			<td>${pageScope.dto.password}</td>
	 			<td>${pageScope.dto.name}</td>
	 			<td>${pageScope.dto.email}</td>
	 			<td>${pageScope.dto.phone}</td>
	 		</tr>
	 	</c:forEach>
		
	</tbody>
</table>

</form>
</body>
</html>