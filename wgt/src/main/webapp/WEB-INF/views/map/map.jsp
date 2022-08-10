<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/mapcss/map.css'/>" />
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 286px;
	height: 120px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 13px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info .img {
	position: absolute;
	top: 6px;
	left: 5px;
	width: 73px;
	height: 71px;
	border: 1px solid #ddd;
	color: #888;
	overflow: hidden;
}

.info:after {
	content: '';
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
	color: #5085BB;
}
</style>
</head>

<body>
	<a class="back" href="<c:url value='/login'/>"><img
		src="../resources/mapcss/img/backicon.png"></a>
	<input id="inputaddr" value="${addr}" />
	<input id="autoName" value="${autoName}" />
	<c:forEach var="item" items="${find}">
		<input id=findName value="${item.name}"/>
		<input id=findAddr value="${item.address}"/>
	</c:forEach>
	<a class="userInformation"> <span></span>
	</a>
	<form class="header_form" action="map" method="post">
		<br> <select class="selectbox">
			<option>주소</option>
			<option>메뉴</option>
		</select> <input id="inputSearch" class="inputtext" type="text" name="name">

		<div id="map" style="width: 370px; height: 700px; margin-left: 10px;"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5b341178fe09d0d9b1f0550b3aa199be&libraries=services"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new kakao.maps.LatLng(35.864402760, 128.593350427), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption);
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(document.getElementById("inputaddr").value,
					function(result, status) {
						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {
							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);
							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});

			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

			var positions = [
				{
				
				title : '고영희식당',//document.getElementById("findName").value,
				latlng : new kakao.maps.LatLng(35.86583282479493,
												128.59449168013143),
				addr : 1,//document.getElementById("findAddr").value,
				subaddr: '(지번)덕산동 128-13',
				phone: '053-256-0808'
				},
				
				{
				title : '뜨돈',//document.getElementById("findName").value,
				latlng : new kakao.maps.LatLng(35.866625070474846,
												128.59403980555334),
				addr : 2,//document.getElementById("findAddr").value,
				subaddr: '(지번)덕산동 128-13',
				phone: '053-256-0808'	
				}
			];

			for (var i = 0; i < positions.length; i++) {
				var content = '<div class="wrap">' + 
	            '    <div class="info">' + 
	            '        <div class="title">' + 
	            '             '+ positions[i].title + 
	            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
	            '        </div>' + 
	            '        <div class="body">' + 
	            '            <div class="img">' +
	            '                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
	            '           </div>' + 
	            '            <div class="desc">' + 
	            '                <div class="ellipsis">' + positions[i].addr + '</div>' + 
	            '                <div class="jibun ellipsis">'+ positions[i].subaddr +'</div>' + 
	            '                <div class="link">'+ positions[i].phone +'</div>' + 
	            '            </div>' + 
	            '        </div>' + 
	            '    </div>' +    
	            '</div>';

				var imageSize = new kakao.maps.Size(24, 35);

				var markerImage = new kakao.maps.MarkerImage(imageSrc,
						imageSize);

				var marker = new kakao.maps.Marker({
					map : map,
					position : positions[i].latlng,
					image : markerImage,
					clickable: true
				});
				
				var overlay = new kakao.maps.CustomOverlay({
					content: content,
					map: map,
					position: marker.getPosition() 
				});
				
				overlay.setMap(null); // 클릭하기전에 값이 안보이게
				
				kakao.maps.event.addListener(marker, 'click', function() {
					overlay.setMap(map);
				});
			}

			function closeOverlay() {
				overlay.setMap(null);
			}

		</script>
		<input class="searchbtn" type="submit" value="검색" />
	</form>
</body>
</html>

