<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/incl/button.css'/>" />
</head>

<body>
	<a class="userInformation"> <span></span></a>
		<nav id=gnb>
		<ul>
			<!-- userId를 세션으로 받아서 사용하세요  -->
			<li class="sub1"><span>${userId}님<br> 반가워요 !</span></li>
			<hr style="border: none; background-color: #DA0037; margin-bottom: 20px; height: 2px; width: 200px;">
			<li class="sub2">
				<form id="submitID" action="go_get_waiting" method="post">
					<a onclick="submit_form()">나의 웨이팅</a>
				</form>
			</li>
			<li class="sub3"><a onclick="location.href='/wgt/userInfo';">회원정보
					보기</a></li>
			<li class="sub4"><a onclick="location.href='/wgt/logOut';">로그아웃</a>
			</li>
		</ul>
	</nav>
</body>
<script>
//이걸로 감싸면 뒤에 화면 opacity가 줄어듭니다
//<div class="header_form"></div>

//여기를 클릭하면 상세보기 삭제 (감싸서 쓰세요) 만들어도 되고
//<div class="click"></div>

//여기 부분을 클릭하면 상세보기 삭제(스크립트) 아이디 적어서 쓰시면 됩니다.
//var click = document.getElementById('')
const bodyClick = document.querySelector(".click")
const toggleBtn = document.querySelector(".userInformation")
const gnbBtn = document.querySelector("#gnb")
const bodytoggle = document.querySelector(".header_form")
		function onClicksubMit() {
			bodytoggle.submit(event.target.value);
		}

		function toggleHandler() {
			toggleBtn.classList.toggle("open")
			gnbBtn.classList.toggle("on")
			bodytoggle.classList.toggle("on")
		}

		function removeOn() {
			bodytoggle.classList.remove("on")
			toggleBtn.classList.remove("open")
			gnbBtn.classList.remove("on")
		}
		
		//위에 var click에 Id를 적었으면 밑에 부분 주석풀고 쓰면 바로 작동됩니다.
		//click.addEventListener("click", removeOn);
		bodyClick.addEventListener("click", removeOn);
		
</script>
</html>