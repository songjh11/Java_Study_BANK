<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
<h1>Update Page</h1>

<form action="update" method="POST">
	<div>
		<input type="hidden" name="booknum" value="${update.booknum}">
	</div>
	<br>
	<div>
		Name:  <input type="text" name="bookname" value="${update.bookname}">
	</div>
	<br>
	<div>
		Rate:  <input type="text" name="bookrate" value="${update.bookrate}">
	</div>
	<br>
	<button type="submit">수정</button>
	<a href="../"><input type="button" value="메인"></a>
</form>
</body>
</html>