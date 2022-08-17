<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Update</title>
</head>
<body>
<h1>Update Page</h1>
<form action="update.do" method="POST">
<table border="1">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>	
			<td><input type="text" name= "textNum" readonly value=${bdetail.textNum}></td>
	 		<td><input type="text" name="tName" value=${bdetail.tName}></td>
	 		<td>${bdetail.writer}</td>
	 		<td>${bdetail.wDate}</td>
	 		<td>${bdetail.viewNum}</td>
		<tr>
			<td colspan="5">내용</td>
		</tr>	
	<tr>
		<td colspan="5"><textarea rows="30" cols="80" name="tContents" value=${bdetail.tContents}>${bdetail.tContents}</textarea></td>	
	</tr>
</table>
<br>
<input type="submit" value="수정 등록">
</form>

</body>
</html>