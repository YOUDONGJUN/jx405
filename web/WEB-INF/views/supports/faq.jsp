<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<link rel="stylesheet" href="/resources/css/movieList.css" />
  	<link rel="stylesheet" href="/resources/css/navbar.css" />
  	<link rel="stylesheet" href="/resources/css/common.css" />
  	<link rel="stylesheet" href="/resources/css/movieDetail.css" />
  	<link rel="stylesheet" href="/resources/css/supports/supports.css" />
  	<link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">
<title>고객센터</title>
</head>
<body>
<%@include file="../common/tags.jsp" %>
<%@include file="../common/navbar.jsp"%>
<div class="container">
	<div>
		<div class="menu mt-5">
			<div>
				<div class="col p-0 page-title text-center">
					<h3>고객센터</h3>
				</div>
			</div>
			<div class="row mypage">
				<div class="col p-0 aside text-center mt-3">
					<ul class="nav flex-column p-0">
						<li class=""><a href="/supports" class="nav-link p-0">자주 묻는 질문</a></li>
					</ul>
					<ul class="nav flex-column p-0">
						<li class=""><a href="/supports/inquiry" class="nav-link p-0">1:1 문의</a></li>
					</ul>
				</div>
				<div class="text-center mt-3 mb-3">
					<span>HTA CINEMA 고객센터</span>
					<span>10:30~18:30</span>
				</div>
			</div>
		</div>
		
		<div class="supports col-9">
			<div class="row">
				<div class="offset ms-4 col-7 p-0" style="margin-left: 20px;">
					<div class="mt-5 mb-3">
						<h1>자주 묻는 질문</h1>
					</div>
					<div class="rounded row p-3 mb-3">
						<div class="col">
							<span>질문을 검색해 보세요.</span>
							<input id="search-input" type="text" class="form-control mt-2" placeholder="질문 검색">
						</div>
						<div class="col-2">
							<button type="button" class="btn btn-primary btn-sm" style="margin-top: 34px;" id="btn-search">검색</button>
						</div>
					</div>
					<div>
						<nav>
							<div class="nav nav-tabs nav-justified mt-3" id="nav-tab" role="tablist">
								<button class="nav-link active faq-list" name="option" value="전체" id="nav-all-tab" data-bs-toggle="tab" data-bs-target="#nav-all" type="button"
									role="tab" aria-controls="nav-all" aria-selected="true">전체</button>
								<button class="nav-link faq-list" name="option" value="예매" id="nav-ticket-tab" data-bs-toggle="tab" data-bs-target="#nav-ticket" type="button" role="tab"
									aria-controls="nav-ticket" aria-selected="false">영화예매</button>
								<button class="nav-link faq-list" name="option" value="극장" id="nav-theater-tab" data-bs-toggle="tab" data-bs-target="#nav-theater" type="button" role="tab"
									aria-controls="nav-theater" aria-selected="false">극장</button>
							</div>
						</nav>
					</div>
					<div class="col mt-5 ms-3">
						<span><span id="ask-type">전체 </span><strong id="count"></strong> 건</span>
					</div>
					<div id="faq-lists" class="tab-content" id="nav-tabContent">
						<div class="tab-pane fade show active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">
							<div class="row mt-3 faq">
							</div>
						</div>
						<div class="ms-4 tab-pane fade" id="nav-ticket" role="tabpanel" aria-labelledby="nav-ticket-tab">
							<div class="row mt-3 faq">
							</div>
						</div>
						<div class="ms-4 tab-pane fade" id="nav-theater" role="tabpanel" aria-labelledby="nav-theater-tab">
							<div class="row mt-3 faq">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<nav aria-label="Page navigation example">
								<!-- ajax 페이지네이션 -->
								<ul class="pagination justify-content-center">
								</ul>
							</nav>
						</div>				
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function() {
		let option = "전체";
		let keyword = '';
		let currentPage = 1;
		let $div = $("#faq-lists .faq");
		
		showFaqLists();
		
		$(".faq-list").click(function() {
			option = $(this).attr('value');
			$("#ask-type").text(option+' ');
			
			currentPage = 1;
			$div.empty();
		 	showFaqLists();
		})
		
		$("#btn-search").click(function() {
			keyword = $("#search-input").val();
			
			currentPage = 1;
			$div.empty();
			showFaqLists();
		})
		
		function showFaqLists() {
			$.ajax({
				type: "get",
				url: "/rest/supports/faq",
				data: {option: option, keyword: keyword, page: currentPage},
				dataType: 'json',
				success: function(response) {
					let faqList = response.items.faqList;
					
					let paging = response.items.pagination;
					let pageNav = "";
					let ul = $(".pagination");
					
					$("#count").text(paging.totalRecords);
					$.each(faqList, function(index, faq) {
						
						let output = "";
						
						output += 	"<div class='accordion accordion-flush mb-3' id='faqlist' style='border-bottom:1px solid #d5d5d5;'>"
						output +=         "<div class='accordion-item'>"
						output +=        	    "<div class='row ps-2 pe-2 pt-3 pb-3'>"
						output += 				"<div class='col-2' style='position:relative;'>"
						output += 					"<div style='position:absolute; top:50%; transform:translateY(-50%); left:40px;'>"
						output += 						"<span><strong>["+faq.questionName+"]</strong></span><br>"
						output += 					"</div>"
						output += 				"</div>"
						output += 				"<div class='col-9 mt-4'>"
						output += 					"<span>Q. "+faq.faqQuestion+"</span>"
						output += 				"</div>"
						output += 				"<div class='col mt-3 text-end'>"
						output += 					"<h2 class='accordion-header' id='faq-heading-"+faq.faqNo+"'>"
						output +=                         "<button class='accordion-button collapsed' style='width: 1px;'" 
						output +=                        	"type='button' data-bs-toggle='collapse' data-bs-target='#faq-content-"+faq.faqNo+"'>"
						output +=                        "</button>"
						output +=                	"</h2>"
						output +=				"</div>"
						output +=			"</div>"
						output +=           "<div id='faq-content-"+faq.faqNo+"' class='accordion-collapse collapse' data-bs-parent='#faqlist'>"
						output +=               "<div class='accordion-body'>"
						output +=                    "<strong>A. </strong><span>"+faq.faqAnswer+"</span>"
						output +=                "</div>"
						output +=            "</div>"
						output +=        "</div>"
						output +=	"</div>";
                
						$div.append(output);
					})
					
					// 이전 페이지
					if (!paging.existPrev) {
						pageNav += "<li class='page-item disabled'><a class='page-link'>이전</a></li>"
					} else {
						pageNav += "<li class='page-item'><a class='page-link' data-page='"+paging.prevPage+"'>이전</a></li>"
					}
					
					// 현재 페이지
					if (paging.pageNo == 0) {
						pageNav += "<li class='page-item disabled'><a class='page-link'>1</a></li>"
					} else {
						for (let i = paging.beginPage; i <= paging.endPage; i++) {
							if (currentPage == i) {
								pageNav += "<li class='page-item active'><a class='page-link' data-page='"+i+"'>"+i+"</a></li>"
							} else {
								pageNav += "<li class='page-item'><a class='page-link' data-page='"+i+"'>"+i+"</a></li>"
							}
						}
					}
					
					// 다음 페이지
					if (!paging.existNext) {
						pageNav += "<li class='page-item disabled'><a class='page-link'>다음</a></li>"
					} else {
						pageNav += "<li class='page-item'><a class='page-link' data-page='"+paging.nextPage+"'>다음</a></li>"
					}
					ul.html(pageNav);
				}
			})
		}
		
		$(".pagination").on('click', '.page-link', function(e) {
			e.preventDefault();
			currentPage = $(this).attr("data-page");
			$div.empty();
			showFaqLists();
		})
	})
</script>
</html>