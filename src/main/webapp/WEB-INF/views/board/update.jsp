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
	<thead>
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>	
	</thead>
	<tbody>
			<td>${bdetail.textNum}</td>
	 		<td><input type="text" value="${bdetail.tName}"></td>
	 		<td>${bdetail.writer}</td>
	 		<td>${bdetail.wDate}</td>
	 		<td>${bdetail.viewNum}</td>
	</tbody>
</table>
<table border="1">
	<thead>
		<tr>
			<td>내용</td>
		</tr>	
	</thead>
	<tbody>
		<textarea rows="50" cols="50" name="tContents" value="${bdetail.tContents}"></textarea>	
	</tbody>
</table>
<input type="submit" value="수정 등록">
</form>

</body>
</html>