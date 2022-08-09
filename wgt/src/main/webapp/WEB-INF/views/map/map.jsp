<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0"/>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/mapcss/map.css'/>" />
	
</head>
<body>
	<form class="header_form" action="map" method="post">
		<select class="selectbox">
			<option value="주소">주소</option>
			<option value="메뉴">메뉴</option>
		</select>
		<input class="inputtext" type="text" name="search">
	</form>
	<form class="body_form" action="map" method="get">
		<div id="map" style="width:370px;height:700px;margin-left:10px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5b341178fe09d0d9b1f0550b3aa199be"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script>
<input class="searchbtn" type="submit" value="검색"/>
	</form>
</body>
</html>