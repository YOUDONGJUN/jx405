<%--
  Created by IntelliJ IDEA.
  User: ehdwnsdb
  Date: 2023-02-15
  Time: 오후 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row vh-100 align-items-center text-center">
        <div class="row justify-content-center">
            <form action="/user/auth.jsp" method="post">
                <div class="row justify-content-center mb-2">
                    <div class="col-6">
                        <div class="form-floating">
                            <input type="text" id="username" name="username" class="form-control" placeholder="아이디">
                            <label for="username">아이디</label>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-6">
                        <div class="form-floating">
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="비밀번호">
                            <label for="password">비밀번호</label>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <button class="btn btn-outline-primary col-3 m-1">로그인</button>
                    <div class="col-3 btn btn-outline-secondary m-1" onclick="location.href='/user/register.jsp'">회원가입
                    </div>
                </div>
            </form>

        </div>
    </div>

    <div class="nav">
        <div class="contents">
            <h1><a href="/" tabindex="-1"><img src="https://img.cgv.co.kr/R2014/images/common/logo/logoWhite.png"
                                               alt="CGV"/></a></h1>
            <ul class="nav_menu">
                <li>
                    <h2><a href="/movies/?lt=1&ft=0">영화</a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/movies/?lt=1&ft=0" tabindex="-1">영화</a></h2></dt>
                        <dd><h3><a href="/movies/?lt=1&ft=0">무비차트</a></h3></dd>
                        <dd><h3><a href="/arthouse/">아트하우스</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/detailViewUnited.aspx?seq=30717">ICECON</a></h3></dd>
                    </dl>
                </li>
                <li>
                    <h2><a href="/theaters/">극장</a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/theaters/" tabindex="-1">극장</a></h2></dt>
                        <dd><h3><a href="/theaters/">CGV 극장</a></h3></dd>
                        <dd><h3><a href="/theaters/special/defaultNew.aspx">특별관</a></h3></dd>
                    </dl>
                </li>
                <li>
                    <h2><a href="/ticket/"><strong>예매</strong></a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/ticket/" tabindex="-1">예매</a></h2></dt>
                        <dd><h3><a href="/ticket/">빠른예매</a></h3></dd>
                        <dd><h3><a href="/reserve/show-times/">상영스케줄</a></h3></dd>
                        <dd><h3><a href="/ticket/eng/newdefault.aspx">English Ticketing</a></h3></dd>
                        <dd><h3><a href="/reserve/show-times/eng/">English Schedule</a></h3></dd>
                    </dl>
                </li>
                <li>
                    <h2><a href="/culture-event/popcorn-store/">스토어</a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/culture-event/popcorn-store/" tabindex="-1">스토어</a></h2></dt>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=2">영화관람권</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=3">기프트카드</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=4">콤보</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=5">팝콘</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=6">음료</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=7">스낵</a></h3>
                        </dd>

                        <dd><h3><a href="/culture-event/popcorn-store/store-category.aspx?CategoryIdx=10">플레이존</a></h3>
                        </dd>

                        <dd><h3><a href="https://brand.naver.com/cgv" class="arrowR" target="_blank">씨네샵</a></h3></dd>
                    </dl>
                </li>
                <li>
                    <h2 onclick="gaEventLog('PC_GNB','주메뉴_이벤트','')"><a
                            href="/culture-event/event/defaultNew.aspx">이벤트</a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/culture-event/event/defaultNew.aspx?mCode=001" tabindex="-1">이벤트</a></h2></dt>
                        <dd><h3><a href="/culture-event/event/defaultNew.aspx?mCode=001">SPECIAL</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/defaultNew.aspx?mCode=004">영화/예매</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/defaultNew.aspx?mCode=008">멤버십/CLUB</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/defaultNew.aspx?mCode=005">CGV 극장별</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/defaultNew.aspx?mCode=006">제휴할인</a></h3></dd>
                        <dd><h3><a href="/user/mycgv/event/result_list.aspx">당첨자 발표</a></h3></dd>
                        <dd><h3><a href="/culture-event/event/end-list.aspx">종료된 이벤트</a></h3></dd>
                    </dl>
                </li>
                <li>
                    <h2 onclick="gaEventLog('PC_GNB','주메뉴_해택','')"><a href="/discount/discountlist.aspx">혜택</a></h2>
                    <dl class="nav_overMenu">
                        <dt><h2><a href="/discount/discountlist.aspx" tabindex="-1">혜택</a></h2></dt>
                        <dd><h3><a href="/discount/discountlist.aspx">CGV 할인정보</a></h3></dd>
                        <dd><h3><a href="https://www.cgv.co.kr/user/memberShip/ClubService.aspx">CLUB 서비스</a></h3></dd>
                        <dd><h3><a href="/user/vip-lounge/">VIP 라운지</a></h3></dd>
                    </dl>
                </li>
            </ul>
            <div class="totalSearch_wrap">
                <label for="totalSearch">
                    <input type="text" id="header_keyword" value=""/>
                    <input type="hidden" id="header_ad_keyword" name="header_ad_keyword"/>
                </label>
                <button type="button" class="btn_totalSearch" id="btn_header_search">검색</button>
                <iframe src="//ad.cgv.co.kr/NetInsight/html/CGV/CGV_201401/main@Search_txt" width="0" height="0"
                        title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0"
                        allowfullscreen="allowfullscreen" mozallowfullscreen="mozallowfullscreen"
                        msallowfullscreen="msallowfullscreen" oallowfullscreen="oallowfullscreen"
                        webkitallowfullscreen="webkitallowfullscreen"></iframe>
                <!--<div class="totalSearchAutocomplete_wrap">
                    <dl class="totalSearchAutocomplete_list">
                        <dt>영화</dt>
                        <dd><a href="#none"><strong>전지</strong>적 작가시점</a></dd>
                        <dd><a href="#none">내언니 <strong>전지</strong>현과 나</a></dd>
                        <dd><a href="#none">수호<strong>전지</strong> 영웅본색</a></dd>
                    </dl>
                    <dl class="totalSearchAutocomplete_list">
                        <dt>인물</dt>
                        <dd><a href="#none"><strong>전지</strong>현</a></dd>
                        <dd><a href="#none"><strong>전지</strong>희</a></dd>
                        <dd><a href="#none">이<strong>전지</strong></a></dd>
                    </dl>
                    <a href="#none" class="btn_totalSearchAutocomplete_close">닫기</a>
                </div>//-->
            </div>
        </div>
    </div>


    <div class="header_content">
        <div class="contents">
            <h1 onclick=""><a href="/"><img src="https://img.cgv.co.kr/R2014/images/common/logo/logoRed.png" alt="CGV"/></a><span>CULTUREPLEX</span>
            </h1>
            <ul class="memberInfo_wrap">
                <!-- Advertisement -->

                <div class="ad-partner">
                    <a href="http://www.cgv.co.kr/culture-event/event/detailViewUnited.aspx?seq=31426&menu=006">
                        <img src="https://img.cgv.co.kr/WingBanner/2023/0208/16758461047540.png" alt="현대M포인트"
                             onerror="this.onerror=null;javascript:;$('.ad-partner').hide();"/>
                    </a>
                </div>

                <!-- /Advertisement -->


                <li><a href="/user/login/?returnURL=https%3a%2f%2fwww.cgv.co.kr%2fdefault.aspx"><img
                        src="https://img.cgv.co.kr/R2014/images/common/ico/loginPassword.png"
                        alt="로그인"/><span>로그인</span></a></li>
                <li><a href="/user/join/"><img src="https://img.cgv.co.kr/R2014/images/common/ico/loginJoin.png"
                                               alt="회원가입"/><span>회원가입</span></a></li>


                <li><a href="/user/mycgv/"><img src="https://img.cgv.co.kr/R2014/images/common/ico/loginMember.png"
                                                alt="MY CGV"/><span>MY CGV</span></a></li>
                <li><a href="/support/default.aspx"><img
                        src="https://img.cgv.co.kr/R2014/images/common/ico/loginCustomer.png"
                        alt="고객센터"/><span>고객센터</span></a></li>
            </ul>
        </div>
    </div>


</div>
</body>
</html>
