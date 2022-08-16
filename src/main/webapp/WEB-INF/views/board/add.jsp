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

제    목: <input type="text" name="tName"><br><br>
작 성 자: <input type="text" name="writer" readonly value="${sessionScope.member.username}"><br><br>
내    용: <br>
<textarea rows="50" cols="50" name="tContents"></textarea><br><br>
<input type="submit" value="글 등록">


</form>

</body>
</html>