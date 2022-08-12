<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<link rel="stylesheet" href="resources/user/user.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>회원가입</title>
</head>

<body>
	<a class="back" href="<c:url value='/login'/>"><img src="resources/mapcss/img/backicon.png"></a>
	<form action="addUser" method="post">
		<div style="font-size: 80px; text-align: center; padding-top: 20px;">회원가입</div>
		<!-- required는 입력을 안할시 자동으로 입력하라고 알림창을 띄움 -->
		<div style="text-align: center; font-size: 30px; padding-top: 30px;">아이디 <input type="text" name="userId" required style="margin-left: 20px; height: 20px;"> </div><br> 
		<div style="margin-left: 45px; font-size: 30px; padding-top: 30px;">비밀번호 <input type="password" name="passwd" required style="margin-left: 20px; height: 20px;"></div><br>
		<div style="margin-left: 86px; font-size: 30px; padding-top: 30px;">이름 <input type="text" name="name" required style="margin-left: 20px; height: 20px;"></div><br>
		<div style="margin-left: 45px; font-size: 30px; padding-top: 30px;">주민번호 <input type="text" name="ssn" required style="margin-left: 20px; height: 20px;"></div><br>
		<div style="margin-left: 40px; font-size: 30px; padding-top: 30px;">전화번호 <input type="text" name="phone" required style="margin-left: 20px; height: 20px;"></div><br>
		<div style="margin-left: 90px; font-size: 30px; padding-top: 30px;">주소 <input type="text" name="addr" required style="margin-left: 20px; height: 20px;"></div><br>
		<div style="margin-left: 20px; font-size: 30px; padding-top: 30px;">프로필 사진 <input type="file" class="add" value="등록" required></div>
		<input type="submit" value="회원가입" class="btn" />
	</form>
</body> 
</html>