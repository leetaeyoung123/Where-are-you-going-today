<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../resources/board/home.css">
<link
	href="https://fonts.googleapis.com/css2?family=Lobster&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

<title>게시판</title>
</head>
<body>

	<header class="headerContainer">
		<!--상단 탭 만들기 뼈대구조-->
		<div class="headerContents">
			<!--상단 탭 내용물 감싼구조-->
			<div class="WestagramTag">
				<!--상단 좌측 내용물-->
				<a href="home"><i class="fab fa-instagram"></i> | <span>Wgt</span>agram</a>
			</div>
			<div class="headerSearchBar">
				<!--상단 중앙 내용물-->
				<i class="fas fa-search"></i> <input type="text" placeholder="검색"
					style="border: none;">
			</div>
			<div class="write_btn">
				<form action="home" method="post">
					<button type="submit" value="글쓰기"
						style="position: relative; left: 31%; margin-top: 55px; cursor: pointer; z-index: 1000;">글쓰기</button>
				</form>
			</div>
		</div>
	</header>
	<div class="mypage">
		<a href="mypage"><img id="user"
			src="../resources/board/img/user.png" width="30px" height="30px"
			style="cursor: pointer;"></a>
	</div>

	<div class="body1">
		<div class="feedReactionButton">
				<!-- <button class="heartbtn" onclick="addLike()"><i class="far fa-heart"></i></button> -->
				<!--  <div class = "feedReaction">
   						<span>좋아요 ??개</span>
 					  </div> -->
			<div class="boardarea">
			<c:forEach var="item" items="${board}">
				<div class="write" style="margin-bottom: 30px;">
					<img src="../resources/board/img/upload/${item.imgname}.jpg" style="width:370px;height:330px"><br>
				<div class="emptyheart">
					<button onclick="changeImg()" style="display:flex;"><img id ="img1" src = "../resources/board/img/emptyheart.png" width = "18px" height = "18px" style="cursor:pointer;"></button>
					<%-- <p><%= nowTime %></p> --%>
					<p><%= sf.format(nowTime) %></p>
					<!-- <img id ="img2" src = "../resources/board/img/redheart.png" width = "20px" height = "20px" onclick="imgToggle"> -->
				</div>
					<h4>${item.title}</h4>
					<br> ${item.content}<br>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function changeImg() {
			document.getElementById("img1").src = "../resources/board/img/redheart.png";
		}
	</script>

</body>
</html>