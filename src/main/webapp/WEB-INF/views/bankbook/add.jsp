<%@page import="java.util.Calendar"%>
<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% BankBookDTO bankBookDTO = new BankBookDTO(); %>
    <% Calendar cal = Calendar.getInstance(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
<h1>Add Book Page</h1>
<form action="add" method = "POST">

계좌명
<br>
<input type="text" name= "bookname"><br>
이자율
<br>
<input type= "number" name = "bookrate"><br>
<input type="submit" value="상품 등록">
</form> 
</body>
</html>