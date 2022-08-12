<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<link rel="stylesheet" href="resources/user/modify.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>회원정보 수정</title>
</head>

<body>
	<a class="back" href="<c:url value='/map/map'/>"><img src="resources/mapcss/img/backicon.png"></a>
	<form action="modifyUser" method="post">
		<c:forEach var="user" items="${userList}">
		<div style="font-size: 100px; text-align: center; padding-top: 40px;">회원수정</div>
		<!-- required는 입력을 안할시 자동으로 입력하라고 알림창을 띄움 -->
		<div style="text-align: center; padding-top: 20px; font-size: 30px;">아이디 
		<input type="text" name="userId" value="${user.userId}" readonly></div><br> 
		
		<div style="margin-left: 55px; padding-top: 20px; font-size: 30px;">비밀번호 
		<input type="password" name="passwd" value="${user.passwd}" required></div><br>
		
		<div style="margin-left: 95px; padding-top: 20px; font-size: 30px;">이름 
		<input type="text" name="name" value="${user.name}" required></div><br>
		
		<div style="margin-left: 55px; padding-top: 20px; font-size: 30px;">주민번호 
		<input type="text" name="ssn" value="${user.ssn}" readonly></div><br>
		
		<div style="margin-left: 47px; padding-top: 20px; font-size: 30px;">전화번호 
		<input type="text" name="phone" value="${user.phone}" required></div><br>
		
		<div style="margin-left: 95px; padding-top: 20px; font-size: 30px;">주소 
		<input type="text" name="addr" value="${user.addr}" required></div><br>
		
		<div style="text-align: center; font-size: 30px; padding-top: 10px;">프로필 사진<br>
		<div style="margin-left: 20px; padding-top: 20px; font-size: 30px;">파일 업로드 <input type="file" accept=".jpg" name="file" value="${user.imgName}"></div><br>
		<button type="submit" class="mBtn">수정완료</button>
		</c:forEach>
	</form>
	
	<form action="deleteUser" method="post">
		<button type="submit" class="dBtn">회원탈퇴</button>
	</form>
</body>
</html>