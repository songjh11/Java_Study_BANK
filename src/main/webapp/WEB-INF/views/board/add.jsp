<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Add</title>
</head>
<body>
<h1>Add Page</h1>

<form action="add.do" method="POST">
<table border="1">
<tr> 
	<td>글 제 목</td>
	<td> <input type="text" name="tName"></td>
</tr>
<tr>
	<td>작 성 자</td>
	<td><input type="text" name="writer" readonly value=${sessionScope.member.userName}></td>
</tr>
<tr>
	<td colspan="2">글 내 용</td>
</tr>
<tr>
	<td colspan="2"><textarea rows="30" cols="50" name="tContents"></textarea></td>
</tr>
</table>
<br>
<input type="submit" value="글 등록">
</form>

</body>
</html>