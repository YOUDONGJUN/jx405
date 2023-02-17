<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<link rel="stylesheet" href="/resources/css/navbar.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<style>
.zxc {
	position: relative;
	background-color: #234254;
	border-radius: 5px;
	color: #fff;
	padding: 20px;
	cursor: pointer;
}

.zzxc {
	position: absolute;
	display: none;
	color: #000;
	top: 58px;
	background-color: yellow;
	padding: 20px;
	border-radius: 10px;
}

.open {
	display: block;
}
</style>
</head>
<body>
	<%@include file="../common/tags.jsp"%>
	<%@include file="../common/navbar.jsp"%>
	<div class="container">
		<div class="zxc">
			<ul class="tabs">
				<li class="tab-link current" style="width: 11.8%" data-tab="tab-1">서울</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-2">경기</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-3">인천</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-4">대전</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-5">부산</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-6">광주</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-7">강원</li>
			</ul>
			<div class="zzxc">
				<ul>
					<li>백</li>
					<li>승</li>
					<li>욱</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="fee-table">
		<div class="row">
			<div class="col"width: 50%>
				<table border="1"  cellspacing="5" width="50%" height="200">
					<th border="1">테이블</th>
					<th border="1">만들기</th>
					<tr border="1">
						<!-- 첫번째 줄 시작 -->
						<td border="1">첫번째 칸</td>
						<td>두번째 칸</td>
					</tr>
					<!-- 첫번째 줄 끝 -->
					<tr>
						<!-- 두번째 줄 시작 -->
						<td>첫번째 칸</td>
						<td>두번째 칸</td>
					</tr>
					<!-- 두번째 줄 끝 -->
				</table>
			</div>
		</div>
	</div>

	<script>
		const btn = document.querySelector(".zxc");
		btn.addEventListener("mouseenter", function(e) {
			const collapseBox = document.querySelector(".zzxc");
			collapseBox.classList.add("open");
		});
		btn.addEventListener("mouseleave", function(e) {
			const collapseBox = document.querySelector(".zzxc");
			collapseBox.classList.remove("open");
		});
	</script>
</body>

</html>