<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<body>
	<form action="addUser" method="post">
		<div>회원가입</div>
		<!-- required는 입력을 안할시 자동으로 입력하라고 알림창을 띄움 -->
		<div>회원 아이디 <input type="text" name="userId" required> </div><br> 
		<div>비밀번호 <input type="password" name="passwd" required></div><br>
		<div>이름 <input type="text" name="name" required></div><br>
		<div>주민번호 <input type="text" name="ssn" required></div><br>
		<div>전화번호 <input type="text" name="phone" required></div><br>
		<div>주소 <input type="text" name="addr" required></div><br>
		<input type="submit" value="회원가입" />
	</form>
</body> 
</html>