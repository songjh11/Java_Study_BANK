<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
<h1>Join Page</h1>
  <form action="join" method="POST">
            이용 약관 동의(필수)<input type="checkbox"><br>
            개인정보 수집 및 이용 동의(필수)<input type="checkbox"><br>
            위치 기반 서비스 이용 약관 동의(선택)<input type="checkbox"><br>
            프로모션 정보 수신 동의(선택)<input type="checkbox"><br>
            <hr>
            아이디<br>
            <input type="text" name="username">
            <input type="button" value="아이디 중복 확인">
            <br>
            비밀번호<br>
            <input type="password" name="passward"><br>
            비밀번호 재확인<br>
            <input type="password"><br>
            <br>
            
            이름<br>
            <input type="text" name="name"><br><br>
            생년월일<br>
            <input type="date"><br><br>
            성별<br>
            여자<input type="radio" name="g1">
            남자<input type="radio" name="g1">
            <br><br>
            본인 확인 이메일(선택)<br>
            <input type="text" value="선택입력" name="email">@
            <select name="mail">
                <option>naver.com</option>
                <option>gmail.com</option>
                <option>kakao.com</option>
                 </select>
            <br><br>
            휴대전화<br>
                통신사<select name="phone1">
                <option>SKT</option>
                <option>KT</option>
                <option>LG</option>
                <option>SKT알뜰폰</option>
                <option>KT알뜰폰</option>
                <option>LG알뜰폰</option>
                </select>
                <input type="text" value="전화번호 입력" name="phone">
                <input type="button" value="인증번호 받기"><br>
                <input type="text" value="인증번호를 입력하세요">

            <br><br>

            <input type="submit" value="가입하기">
            <a href = "./login" ><input type="button" value="로그인 화면으로 돌아가기"></a>

        </form>

</body>
</html>