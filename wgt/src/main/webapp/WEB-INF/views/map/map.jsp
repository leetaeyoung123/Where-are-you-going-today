<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!-- width 370 height= 700 margin-left 10  -->
</head>
<body>
	<a class="back" href="<c:url value='/login'/>"><img src="../resources/mapcss/img/backicon.png"></a>
			<input id="inputaddr" value="${addr}"/>
			<input id="autoName" value="${autoName}"/>
	<a class="userInformation">
	<span></span>
	</a>
	<form class="header_form" action="map" method="post"><br>
		<select class="selectbox">
			<option >주소</option>
			<option >메뉴</option>
		</select>
		<input id="inputSearch" class="inputtext" type="text" name="name">

				<div id="map" style="width:370px;height:700px;margin-left:10px;"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5b341178fe09d0d9b1f0550b3aa199be&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(35.864402760, 128.593350427), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(document.getElementById("inputaddr").value, function(result, status) {
    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: document.getElementById("autoName").value
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
<input class="searchbtn" type="submit" value="검색"/>
</form>
</body>
</html>

