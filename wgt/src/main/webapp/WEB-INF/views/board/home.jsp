<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="../resources/board/home.css">
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<title>게시판</title>
</head>
<body>

<header class = "headerContainer"> <!--상단 탭 만들기 뼈대구조-->
  <div class = "headerContents"> <!--상단 탭 내용물 감싼구조-->
    <div class = "WestagramTag"> <!--상단 좌측 내용물-->    
     <a href = "home"><i class="fab fa-instagram"></i> | <span>Wgt</span>agram</a>
    </div>
  <div class = "headerSearchBar"><!--상단 중앙 내용물-->
    <i class="fas fa-search"></i>
    <input type = "text" placeholder="검색" style="border:none;">
  </div>
	<form action="home" method="post">
		<button type="submit" value="글쓰기" style="position:relative; left:31%; margin-top:55px;">글쓰기</button>
	</form>
 </div>
</header>
<div class = "body1">
<div class="number">
	<form action="home" method="post">
		<c:forEach var="item" items="${board}">
			<h4>No.${item.number}</h4>
		</c:forEach>
	</form>
</div>
 <div class = "feedImage">
   <img src = "../resources/board/img/yas.png" width = "330px" height = "330px">
 </div>
  <div class = "feedReactionButton">
   <div class = "reactionButton1">
   <button><i class="far fa-heart"></i></button>
 <div class = "feedReaction">
   <span>좋아요 갯수</span>
 </div>
  </div> 
  <div class="write">
  <form action="home" method="post">
		<c:forEach var="item" items="${board}">
			<span>${item.title}</span><br>
			${item.content}<br>
		</c:forEach>
	</form>
	</div>
</div>
 </div>
</body>
</html>