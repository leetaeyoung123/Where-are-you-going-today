# Where-are-you-going-today
* 매장 웨이팅 등록 및 매장 개인 게시판 기능

### 팀 구성
* 총 5명 
  * [이태영](https://github.com/leetaeyoung123) 
  * [한태우](https://github.com/workhan0918) 
  * [박상규](https://github.com/parkSangGyu98) 
  * [이성호](https://github.com/LeeSeongHo7984)
  * [백기열](https://github.com/BaekKiYeol)
  
### 개발환경 및 사용한 기술
* Window
* eclipse
* Java
* Spring
* Jsp
* MySQL
* HTML/CSS3
* Javascript
* Tomcat

### 주요 기능
* 사용자
  * 로그인, 로그아웃
  * 회원가입, 수정, 탈퇴
  * 웨이팅 등록, 조회, 삭제
  * 게시판 좋아요, 등록, 삭제, 수정
  
* 점주
  * 점주 로그인, 로그아웃
  * 점주 회원가입
  * 가게 등록, 수정
  * 가게 메뉴 등록, 수정, 삭제
  * 게시판 삭제
  
* 관리자
  * 가게 경도, 위도 등록
  
### 담당 기능
* 메인페이지 지도 생성
* 지도 마커 등록
* 마커 클릭 이벤트
* 키워드 검색
* 관리자 페이지 생성
* 경도, 위도

### 담당 부분 코드
* 마커생성
``` javascript
var MARKER_WIDTH = 24, // 기본, 클릭 마커의 너비
MARKER_HEIGHT = 35, // 기본, 클릭 마커의 높이
GPS_MARKER_WIDTH = 20, GPS_MARKER_HEIGHT = 20, OFFSET_X = 12, // 기본, 클릭 마커의 기준 X좌표
OFFSET_Y = MARKER_HEIGHT, // 기본, 클릭 마커의 기준 Y좌표
OVER_MARKER_WIDTH = 31, // 오버 마커의 너비
OVER_MARKER_HEIGHT = 41, // 오버 마커의 높이
OVER_OFFSET_X = 13, // 오버 마커의 기준 X좌표
OVER_OFFSET_Y = OVER_MARKER_HEIGHT, // 오버 마커의 기준 Y좌표
CLICK_MARKER_WIDTH = 17, CLICK_MARKER_HEIGHT = 29;
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
// 마커 이미지를 생성합니다    
var markerSize = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT), // 기본, 클릭 마커의 크기
markerOffset = new kakao.maps.Point(OFFSET_X, OFFSET_Y), // 기본, 클릭 마커의 기준좌표
overMarkerSize = new kakao.maps.Size(OVER_MARKER_WIDTH,
    OVER_MARKER_HEIGHT), // 오버 마커의 크기
overMarkerOffset = new kakao.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y), // 오버 마커의 기준 좌표
clickMarkerSize = new kakao.maps.Size(CLICK_MARKER_WIDTH,
    CLICK_MARKER_HEIGHT), gpsMarkerSize = new kakao.maps.Size(
    GPS_MARKER_WIDTH, GPS_MARKER_HEIGHT);
selectedMarker = null; // 클릭한 마커를 담을 변수
selectedContent = null;
```

* 카카오 API를 사용하여 지도 생성
``` javascript
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
```

* 클릭 이벤트 및 지도 위 마커 생성
 ``` javascript

// 마커를 생성하고 지도 위에 표시하고, 마커에 mouseover, mouseout, click 이벤트를 등록하는 함수입니다
function addMarker(position, inputText, content, normalOrigin,
  overOrigin, clickOrigin) {
var markerImage = new kakao.maps.MarkerImage(imageSrc, markerSize), overMarker = new kakao.maps.MarkerImage(
    imageSrc, overMarkerSize), clickMarker = new kakao.maps.MarkerImage(
    imageSrc, clickMarkerSize);
// 마커를 생성하고 이미지는 기본 마커 이미지를 사용합니다
var marker = new kakao.maps.Marker({
  map : map,
  position : position,
  image : markerImage
});
var overlay = new kakao.maps.CustomOverlay({
  content : content,
  map : map,
  position : position
});
marker.markerImage = markerImage;
// 마커에 click 이벤트를 등록합니다
overlay.setMap(null);
kakao.maps.event.addListener(marker, 'click', function() {
  // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
  // 마커의 이미지를 클릭 이미지로 변경합니다
  for (var i = 0, len = count; i < len; i++) {
    document.getElementById("inputSearch").value = inputText
  }
  if (!selectedMarker || selectedMarker !== marker) {
    // 클릭된 마커 객체가 null이 아니면
    // 클릭된 마커의 이미지를 기본 이미지로 변경하고
    !!selectedMarker
        && selectedMarker
            .setImage(selectedMarker.markerImage);
    !!selectedContent && selectedContent.setMap(null);
  }
  filter()
  // 현재 클릭된 마커의 이미지는 클릭 이미지로 변경, 컨테츠를 띄워줌
  if (marker.markerImage != clickMarker) {
    marker.setImage(clickMarker)
    overlay.setMap(map)
  }
  // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
  selectedMarker = marker;
  selectedContent = overlay;
});
```

* 키워드 검색 Dao
``` java
public List<Map> search(String name){
  String sql = "SELECT * FROM map WHERE name like '%" + name +"%' ";
  return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Map>(Map.class));
}
```

* 경도 위도 등록 Dao
``` java
public void insertPosition(Map map) {
  String sql = "INSERT INTO map (businessNumber, longitude, latitude) VALUES( ? ,? ,? )";
  jdbcTemplate.update(sql,map.getBusinessNumber(), map.getLongitude(), map.getLatitude());
}
```

### 구현 화면
* 담당 구현화면


