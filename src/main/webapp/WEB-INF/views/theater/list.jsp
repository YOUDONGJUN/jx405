<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/navbar.css" />
<style type="text/css">
button {
	height: 32px;
	padding: 0 12px;
	line-height: 30px;
	font-size: .9333em;
	display: inline-block;
	margin: 0;
	text-align: center;
	font-weight: 400;
	border-radius: 4px;
	font-family: NanumBarunGothic, Dotum, '돋움', sans-serif;
	border: 1px solid #503396;
	vertical-align: middle;
	background-color: #fff;
}
a{
	text-decoration: none;
	color: black;
}

ul.tabs {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

ul.tabs li {
	background: none;
	color: #222;
	display: inline-block;
	padding: 10px 15px;
	cursor: pointer;
}

.tabs ul li a {
	color: #444;
}

a:link {
	color: #444;
	text-decoration: none;
}

ul.tabs li.current {
	background: #ededed;
	color: #222;
}

.tab-content {
	display: none;
	background: #ededed;
	padding: 15px;
}

.tab-content.current {
	display: inherit;
}

li {
	display: inline-block;
}

.wrap {
	position: relative;
	display: block;
	width: 100%;
	min-height: 190px;
	border: 3px solid #686571;
	border-radius: 10px;
}

.tab-content { .theater-box .theater-list { display:none;
	position: absolute;
	left: 0;
	top: 48px;
	width: 100%;
	min-height: 85px;
	padding: 30px 0;
}

}
.my-fav-theater {
	position: absolute;
	padding: 0 20px;
	width: 100%;
	bottom: 0;
	left: 0;
	line-height: 54px;
	border-radius: 0 0 10px 10px;
	background-color: #ecf0f4;
}
</style>
</head>
<body>
	<div class="container">
	<%@include file="../common/tags.jsp" %>
	<%@include file="../common/navbar.jsp"%>

		<div class="mt-5">
			<h1>전체극장</h1>
		</div>
		<div class="wrap">
			<ul class="tabs">
				<li class="tab-link current" style="width: 11.8%" data-tab="tab-1">서울</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-2">경기</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-3">인천</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-4">대전</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-5">부산</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-6">광주</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-7">강원</li>
			</ul>
			<div id="tab-1" class="tab-content current">
				<ul>
					<c:forEach var="theater" items="${theaters.seoul}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div id="tab-2" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.kyungki}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div id="tab-3" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.incheon}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div id="tab-4" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.daejeon}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div id="tab-5" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.busan}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
					<::after></::after>
				</ul>
			</div>
			<div id="tab-6" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.kwangju}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
					<::after></::after>
				</ul>
			</div>
			<div id="tab-7" class="tab-content">
				<ul>
					<c:forEach var="theater" items="${theaters.kangwon}">
						<li class="theaterName" style="width: 23.6%"><a
							href="detail?no=${theater.no }">${theater.name}</a></li>
					</c:forEach>
					<::after></::after>
				</ul>
			</div>
			<div class="my-fav-theater">
				나의 선호영화관 정보 <a href="/common/loginFormModal.jsp" id="moveLogin"><button class="login">로그인하기</button></a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {

			$('ul.tabs li').click(function() {
				var tab_id = $(this).attr('data-tab');

				$('ul.tabs li').removeClass('current');
				$('.tab-content').removeClass('current');

				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})
		})
	</script>
</body>
</html>