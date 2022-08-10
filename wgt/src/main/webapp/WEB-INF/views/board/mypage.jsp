<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="../resources/board/write.css">
<link rel="stylesheet" type="text/css" href="../resources/board/home.css">
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

<title>마이페이지</title>
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
	<form action="update" method="post">
		<button type="submit" value="수정" style="position:relative; left:31%; margin-top:55px;">수정</button>
	</form>
	<form action="delete" method="post">
		<button type="submit" value="삭제" style="position:relative; left:31%; margin-top:55px;">삭제</button>
	</form>
 </div>
</header>
  <div class="mypage">
  	<a href="mypage"><img id ="user" src = "../resources/board/img/user.png" width = "30px" height = "30px" style="cursor:pointer;"></a>
  </div>
  
 	userId<br>
 	name<br>
  	phone<br>
	게시물 수정 및 삭제
 
</body>
</html>