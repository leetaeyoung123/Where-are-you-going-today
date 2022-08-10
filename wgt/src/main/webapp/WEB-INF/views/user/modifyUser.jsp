<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>

<body>
	<form action="modifyUser" method="post">
		<div>회원수정</div>
		<!-- required는 입력을 안할시 자동으로 입력하라고 알림창을 띄움 -->
		<div>회원 아이디 <input type="text" name="userId" value="${user.userId}" readonly> </div><br> 
		<div>비밀번호 <input type="password" name="passwd" value="${user.passwd}" required></div><br>
		<div>이름 <input type="text" name="name" value="${user.name}" required></div><br>
		<div>주민번호 <input type="text" name="ssn" value="${user.ssn}" readonly></div><br>
		<div>전화번호 <input type="text" name="phone" value="${user.phone}" required></div><br>
		<div>주소 <input type="text" name="addr" value="${user.addr}" required></div><br>
		<button type="submit">수정완료</button>
	</form>
	
	<form action="delete/deleteUser">
		<button type="submit">회원탈퇴</button>
	</form>
</body>
</html>