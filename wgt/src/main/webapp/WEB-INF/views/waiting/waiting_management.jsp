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
	<script type="text/javascript">
		function back() {
			history.back();
		}
	</script>
	<div id="wrap">
		<header id="header">
			<h3 style="font-size: 40px;">나의 매장 웨이팅 내역</h3>
		</header>
		<hr>
		<div id="content">
			<div style="text-align: center; font-size: 45px;" class="inner">
				<c:forEach var="waiting" items="${MyShopWaitingList}"
					varStatus="status">
					<form action="waitingCheck" method="post">
						순번 : ${status.index+1}<br>
						고객ID : <input name="userId"
							value="${waiting.userId}"
							style="opacity: 0; width: 0; height: 0;">${waiting.userId}<br>
						인원수 : ${waiting.num_people}
						<div>
							<input type="submit" value="확인" class="prev_btn">
						</div>
					</form>
				</c:forEach>
			</div>
			<form action="allWaitingClear" method="post" class="form_style">
				<div class="btn_wrap">
					<input type="button" onclick="back()" value="뒤로가기" class="prev_btn">
					<input type="submit" value="내역 초기화" class="next_btn">
				</div>
			</form>
		</div>
		<hr>

		<footer id="footer">Copyright (c) 2022 Copyright Holder All
			Rights Reserved.</footer>
	</div>
</body>
</html>
