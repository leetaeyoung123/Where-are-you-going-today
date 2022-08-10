<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<link rel="stylesheet" href="../resources/initialize.css">
<link rel="stylesheet" href="../resources/shopStyle.css">
<link rel="stylesheet" href="../resources/waitingStyle.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>Add Waiting</title>
</head>
<body>

	<div id="wrap">
		<header id="header">
			<h3>가게이름</h3>
		</header>
		<hr>
		<div id="content">
			<div class="inner">
				<c:forEach var="waiting" items="${nowWaiting}" varStatus="status">
							현재 웨이팅 테이블 : ${status.index+1}
				</c:forEach>
			</div>
			<div class="input_wrap">
				<form action="waiting" method="post">
					<input class="input_num" placeholder="인원수" name="num_people"
						type="number" min="1" value="1">
				</form>
			</div>
			<div class="input_wrap">
				<input class="input_style" type=button value="-"
					onClick="javascript:this.form.num_people.value--;"> <input
					type=button value="+"
					onClick="javascript:this.form.num_people.value++;">
			</div>
			<div class="btn_wrap">
				<input type="submit" value="뒤로가기" class="prev_btn"> <input
					type="submit" value="웨이팅" class="next_btn">
			</div>
		</div>
		<hr>

		<footer id="footer">Copyright (c) 2022 Copyright Holder All
			Rights Reserved.</footer>
	</div>
</body>
</html>
