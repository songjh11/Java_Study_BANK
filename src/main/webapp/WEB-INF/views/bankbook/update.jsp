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

<form action="update.do" method="POST">
	<div>
		<input type="hidden" name="bookNum" value="${update.bookNum}">
	</div>
	<br>
	<div>
		Name:  <input type="text" name="bookName" value="${update.bookName}">
	</div>
	<br>
	<div>
		Rate:  <input type="text" name="bookRate" value="${update.bookRate}">
	</div>
	<br>
	<button type="submit">수정</button>
	<a href="../.do"><input type="button" value="메인"></a>
</form>
</body>
</html>