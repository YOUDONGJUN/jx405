<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/resources/css/navbar.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/theaterDetail.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</head>
<body>
	<%@include file="../common/tags.jsp"%>
	<%@include file="../common/navbar.jsp"%>
	
	<div class="container">
		<input type="hidden" name="no" value="${param.no }">
		<div class="row">
			<ul class="theater-menu">
				<li><a href="/theater/list">전체극장</a></li>
				<li>></li>
				<li><a>극장정보</a></li>
			</ul>
		</div>
		<div class="list-tab">
			<ul class="region-tab">
				<li class="tab-link" style="width: 11.8%" data-tab="tab-1">서울
					<div id="tab-1" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.seoul}">
								<li class="theaterName" style="width: 23.6%"><a
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-2">경기
					<div id="tab-2" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.kyungki}">
								<li class="theaterName" style="width: 23.6%"><a
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-3">인천
					<div id="tab-3" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.incheon}">
								<li class="theaterName" style="width: 23.6%"><a
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul class="depth1">
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-4">대전
					<div id="tab-4" class="tab-content">
						<ul>
							<c:forEach var="theater" items="${dto.theaterList.daejeon}">
								<li class="theaterName" style="width: 23.6%"><a class="movieName"
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-5">부산
					<div id="tab-5" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.busan}">
								<li class="theaterName" style="width: 23.6%"><a
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-6">광주
					<div id="tab-6" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.kwangju}">
								<li class="theaterName" style="width: 23.6%"><a
									href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
				<li class="tab-link" style="width: 11.8%" data-tab="tab-7">강원
					<div id="tab-7" class="tab-content">
						<ul class="depth1">
							<c:forEach var="theater" items="${dto.theaterList.kangwon}">
								<li class="theaterName" style="width: 23.6%" ><a 
									 href="detail?no=${theater.no}">${theater.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</ul>
			<h2 class="movie-name">${dto.theater.name}</h2>
		</div>


		<div class="inner-wrap pt40">
			<ul class="info-tab">
				<li class="tab-info ${empty param.showDate ? 'current' : '' }" data-tab="info-1">극장정보</li>
				<li class="tab-info ${not empty param.showDate ? 'current' : '' }" data-tab="info-2">상영시간표</li>
				<li class="tab-info" data-tab="info-3">관람료</li>
			</ul>
			<div class="contents-wrap">
				<div id="info-1" class="info-content current">
					<div class="theater-info-text">
						<div class=detail-info-wrap">
							<h2 class="tit small mt70">시설안내</h2>
							<h3 class="tit small">보유시설</h3>
						</div>
						<div class="theater-facility">
							<c:forEach var="facility" items="${dto.facilityList}">
								<c:choose>
									<c:when test="${facility.facilityTypeName eq '일반상영관'}">
										<p>
											<i class="iconset ico-facility-theater"></i> "일반상영관"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '장애인석'}">
										<p>
											<i class="iconset ico-facility-disabled"></i> "장애인석"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '컴포트'}">
										<p>
											<i class="iconset ico-facility-comfort"></i> "컴포트"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == 'MX'}">
										<p>
											<i class="iconset ico-facility-mx"></i> "MX"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '부티크'}">
										<p>
											<i class="iconset ico-facility-boutique"></i> "부티크"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '스위트룸'}">
										<p>
											<i class="iconset ico-facility-sweet"></i> "스위트룸"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '로얄석'}">
										<p>
											<i class="iconset ico-facility-royal"></i> "로얄석"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '커플석'}">
										<p>
											<i class="iconset ico-facility-couple"></i> "커플석"
										</p>
									</c:when>
									<c:when test="${facility.facilityTypeName == '발코니'}">
										<p>
											<i class="iconset ico-facility-balcony"></i> "발코니"
										</p>
									</c:when>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					<div>
						<h2 class="tit small mt70">교통안내</h2>
						<h3 class="tit small">약도</h3>
						<p>도로명주소:"${dto.theater.streetAddress }"</p>
						<a
							href="http://m.map.naver.com/map.nhn?lng=${dto.theater.latitude}&lat=${dto.theater.longitude}& level=2"
							class="button purple" target="_blank" title="새창열림">실시간 길찾기</a>
					</div>

					<div class="public-transportation">
						<!-- 버스 정보 -->

						<!-- 만약 아무대중교통도 없으면 대중교통 없다고 출력 -->
						<c:if test="${empty dto.transportationList }">
							<div class="transportation-section">
								<div class="icon-box">
									<p>이용가능한 대중교통이 없습니다.</p>
								</div>
							</div>
						</c:if>
						<!-- 버스정보 있으면 출력 -->
						<c:forEach var="transportation" items="${dto.transportationList}">
							<c:choose>
								<c:when test="${100 eq transportation.typeNo }">
									<div class="transportation-section">
										<div class="icon-box">
											<i class="iconset ico-bus" title="버스">버스</i>
										</div>
										<div class="info">
											<p class="tit">버스</p>
											<ul class="dot-list">
												<li>"${transportation.content }"</li>
											</ul>
										</div>
									</div>
								</c:when>
								<c:when test="${101 eq transportation.typeNo }">
									<div class="transportation-section">
										<div class="icon-box">
											<i class="iconset ico-metro" title="지하철">지하철</i>
										</div>
										<div class="info">
											<p class="tit">지하철</p>
											<ul class="dot-list">
												<li>"${transportation.content }"</li>
											</ul>
										</div>
									</div>
								</c:when>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
			

			<div id="info-2" class="info-content">
				<div class="col-10">
					<div class="show-schedule">
						<div class="day">
							<!-- 페이지 네이션으로 입력할 것 -->
							<!--일에 따라서 class가 바뀐다. -->
							<div class="month"></div>
							<div class="now-day"></div>
						</div>
						<div class="schedule-list">
							<div class="movie-option mb20">
								<div class="option">
									<ul>
										<li><i class="iconset ico-stage" title="무대인사"></i>무대인사</li>
										<li><i class="iconset ico-user" title="회원시사"></i>회원시사</li>
										<li><i class="iconset ico-open" title="오픈시사"></i>오픈시사</li>
										<li><i class="iconset ico-goods" title="굿즈패키지"></i>굿즈패키지</li>
										<li><i class="iconset ico-singalong" title="싱어롱"></i>싱어롱</li>
										<li><i class="iconset ico-gv" title="GV"></i>GV</li>
										<li><i class="iconset ico-sun" title="조조"></i>조조</li>
										<li><i class="iconset ico-brunch" title="브런치"></i>브런치</li>
										<li><i class="iconset ico-moon" title="심야"></i>심야</li>
									</ul>
								</div>
								<div class="rateing-lavel">
									<a href="" class="" title="관람등급안내">관람등급안내</a>
								</div>
							</div>

							<c:forEach var="showSchedule" items="${dto.showScheduleList}">

								<div class="theater-list">
									<div class="theater-tit">
										<!-- 관람등급 사진 -->
										<p class="movie-grade age-12"></p>
										<p>
											<a href="/movie/detail?no=${showSchedule.showDto.movieNo }"
												title="${showSchedule.showDto.movieName } 상세보기">
												${showSchedule.showDto.movieName }</a>
										</p>
									</div>
									<c:forEach var="screen" items="${showSchedule.screenList}">

										<div class="theater-type-box">
											<div class="theater-type">
												<p class="theater-name">${screen.screenName}</p>
												<br>
												<p class="chair">총 ${screen.totalSeat}</p>
											</div>
											<div class="theater-time">
												<div class="theater-type-area">${screen.showTypeName}</div>
												<div class="theater-time-box">
													<c:forEach var="schedule" items="${screen.scheduleList}">


														<table class="time-list-table">
															<caption>상영시간을 보여주는 표 입니다.</caption>
															<colgroup>
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
																<col style="width: 99px;">
															</colgroup>
															<tbody>
																<tr>
																	<td class="" brch-no="1372"
																		play-schdl-no="2202151372020" rpst-movie-no="22000800"
																		theab-no="05" play-de="20220215" play-seq="2">
																		<div class="td-ab">
																			<div class="txt-center">
																				<a href="/ticketing/screenList" title="영화예매하기">
																				
																					<p class="time"><fmt:formatDate value="${schedule.startTime}" pattern="hh:mm" />~</p>
																					<p class="time"><fmt:formatDate value="${schedule.endTime}" pattern="hh:mm" /></p>
																					
																					<div class="play-time">
																						<p></p>
																						<p>${schedule.timeNo}회차</p>
																					</div>
																				</a>
																			</div>
																		</div>
																	</td>
																</tr>
															</tbody>
														</table>
													</c:forEach>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div id="info-3" class="info-content">가격</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('ul.info-tab li').click(function() {
				var tab_id = $(this).attr('data-tab');
				$('ul.info-tab li').removeClass('current');
				$('.info-content').removeClass('current');
				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})
		})
		
		var currentTabId = $('ul.info-tab li.current').attr('data-tab');
		$('.info-content').removeClass('current');
		$("#" + currentTabId).addClass('current');
		
		$(document).ready(function() {

			$('div.play-time ').mouseover(function() {
				var tab_id = $(this).attr('data-tab');

				$('ul.region-tab li').removeClass('current');
				$('.tab-content').removeClass('current');

				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})
			$('ul.region-tab li').mouseleave(function() {
				$('ul.region-tab li').removeClass('current');
				$('.tab-content').removeClass('current');
			})
		})
		

		$(document).ready(function() {

			$('ul.region-tab li').mouseover(function() {
				var tab_id = $(this).attr('data-tab');

				$('ul.region-tab li').removeClass('current');
				$('.tab-content').removeClass('current');

				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})
			$('ul.region-tab li').mouseleave(function() {
				$('ul.region-tab li').removeClass('current');
				$('.tab-content').removeClass('current');
			})
		})
		
		

		const dataDate = new Date();
		let year = dataDate.getFullYear();
		let month = dataDate.getMonth();
		let dataDay = dataDate.getDate();
		let dayLabel = dataDate.getDay();
		let dayNumber = Number(dataDay);
		$('div.month').text((Number(month) + 1) + "월");

		const reserveDate = $('div.now-day');

		const weekOfDay = [ "일", "월", "화", "수", "목", "금", "토" ];
		let thisWeek = [];
		let button = "";
		let spanWeekOfDay = "";
		let spanDay = "";
		let div = "";
		
		
		for (let i = dayNumber; i <= dayNumber + 11; i++) {

			div = document.createElement("div");
			button = document.createElement("button");
			spanWeekOfMonth = document.createElement("span");
			spanWeekOfDay = document.createElement("span");
			spanDay = document.createElement("strong");
			spanWeekOfMonth.classList = "movie-week-of-month";
			spanWeekOfDay.classList = 'movie-week-of-day';
			spanDay.classList = 'movie-day';
			let resultDay = new Date(year, month, i);
			let yyyy = resultDay.getFullYear();
			let mm = Number(resultDay.getMonth()) + 1;
			let dd = resultDay.getDate();
			let d = resultDay.getDay();

			mm = String(mm).length === 1 ? '0' + mm : mm;
			dd = String(dd).length === 1 ? '0' + dd : dd;
			d = String(d).length === 1 ? '0' + d : d;
			spanWeekOfMonth.innerHTML = mm;
			spanWeekOfDay.innerHTML = dd;

			button.append(spanWeekOfDay);
			if (d == '01') {
				d = weekOfDay[1];
				button.classList = "mon";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '02') {
				d = weekOfDay[2];
				button.classList = "mon";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '03') {
				d = weekOfDay[3];
				button.classList = "mon";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '04') {
				d = weekOfDay[4];
				button.classList = "mon";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '05') {
				d = weekOfDay[5];
				button.classList = "mon";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '06') {
				d = weekOfDay[6];
				button.classList = "mon sat";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			} else if (d == '00') {
				d = weekOfDay[0];
				button.classList = "mon sun";
				button.setAttribute('data-day', yyyy + mm + dd + d);
			}
			if (i === dayNumber) {
				button.classList = "mon active";
				//해당날짜는 버튼이 눌려있게 설정함
			}
			spanDay.innerHTML = d;
			button.append(spanDay);
			reserveDate.append(button);

			thisWeek[i] = yyyy + "-" + mm + '-' + dd + '-' + d;
		}

		$("button.mon").click(function() {
			var no = $(":input[name=no]").val();
			var day = $(this).attr('data-day').substr(0, 8);
			location.href = "detail?no=" + no + "&showDate=" + day;
		});
		
		function sendName(theaterName) {
			const movieName = document.querySelector('.movie-name');
			movieName.innerText = theaterName;
		}
	</script>
</body>

</html>