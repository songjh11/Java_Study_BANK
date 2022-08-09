<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//스크립틀릿 형태 <% Java 코드 작성 시 사용% >
    	//표현식 HTML <%=자바변수 또는 값% >
    	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
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
			<th>BOOKNUM</th> 
			<th>BOOKNAME</th> 
			<th>BOOKRATE</th> 
			<th>BOOKSALE</th>
		</tr>
	</thead>
	<tbody>
		<% for(BankBookDTO b: ar){ %>
			<tr>
				<td><a href="./detail?booknum=<%=b.getBooknum()%>">
					<%= b.getBookname() %></a>
				</td>
				<td><%= b.getBookrate() %></td>
				</tr>
		<%} %>
	</tbody>

</table>
<br><br>
<!-- /bankbook/detail -->
<!-- 링크 주소는 상대경로 작성 -->
<a href = "detail">Detail Page</a>



</body>
</html>