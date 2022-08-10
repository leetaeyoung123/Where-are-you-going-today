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
			<h3 style="font-size: 40px;">현재 웨이팅 내역</h3>
		</header>
		<hr>
		<div id="content">
			<div style="text-align: center; font-size: 45px;" class="inner">
				<c:forEach var="x" items="${waiting}" varStatus="status">
							매장명 : ${x.barName} <br>
							매장 전화번호 : <br>053-587-1234<br>
							인원 : ${x.num_people}<br>
							내 앞 대기팀 : 7
				</c:forEach>

			</div>
			<div class="btn_wrap">
				<input type="submit" value="뒤로가기" class="prev_btn"> <input
					type="submit" value="웨이팅 취소" class="next_btn">
			</div>
			</form>
		</div>
		<hr>

		<footer id="footer">Copyright (c) 2022 Copyright Holder All
			Rights Reserved.</footer>
	</div>
</body>
</html>
