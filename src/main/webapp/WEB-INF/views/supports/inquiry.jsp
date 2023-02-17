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
  	<link rel="stylesheet" href="/resources/css/supports/supports.css" />
  	<link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">
<title>고객센터</title>
</head>
<body>
<%@include file="../common/tags.jsp" %>
<%@include file="../common/navbar.jsp"%>
<div class="container">
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
	
	<div class="supports col-6">
		<div class="row">
			<div class="col mt-3">
				<h1>1:1 문의</h1>
			</div>
		</div>
		<div>
			<form id="qnaForm" action="/qna" method="post" enctype="multipart/form-data">
				<table class="table mt-3">
					<colgroup>
						<col style="width:150px;">
						<col>
						<col>
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">
								<label for="ask-type">문의지점</label>
								<span class="red">*</span>
							</th>
							<td colspan="">
								<div class="row">
									<div class="col">
										<select id="region" class="form-select">
											<option selected disabled>지역선택</option>
											<c:forEach var="region" items="${regions }" >
												<option value="${region.no }">${region.name }</option>
											</c:forEach>
										</select>
									</div>
									<div class="col">
										<select id="theater" name="theaterNo" class="form-select" disabled>
											<option value="">극장선택</option>
										</select>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="ask-type">문의유형</label>
								<span class="red">*</span>
							</th>
							<td colspan="3">
								<select id="ask-type" name="qnaTypeNo" class="form-select">
									<option value="" selected disabled>문의유형선택</option>
									<c:forEach var="category" items="${categories }">
										<option value="${category.no }">${category.typeName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="name">이름</label>
								<span class="red">*</span>
							</th>
							<td>
								<input type="text" id="userName" value="${LOGIN_USER.name }" class="form-control" maxlength="15"/>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="email">이메일</label>
								<span class="red">*</span>
							</th>
							<td>
								<input type="text" id="email" value="${LOGIN_USER.email }" class="form-control"/>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="phone">휴대전화</label>
								<span class="red">*</span>
							</th>
							<td>
								<input type="text" id="phone" value="${LOGIN_USER.phoneNumber }" class="form-control"/>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="title">제목</label>
								<span class="red">*</span>
							</th>
							<td>
								<input type="text" id="title" name="title" value="" class="form-control"/>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="textarea">내용</label>
								<span class="red">*</span>
							</th>
							<td>
								<div class="textarea">
									<textarea class="form-control" name="content" id="textarea" rows="5" cols="30" maxlength="1000" placeholder="※ 불편사항이나 문의사항을 남겨주시면 최대한 신속하게 답변 드리겠습니다."></textarea>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">
								<label for="upfiles">사진첨부</label>
								<span class="red">*</span>
							</th>
							<td>
								<div>
									<p>* 5M 이하의 파일만 첨부 가능합니다. (최대 3개)</p>
									<p>* 개인정보가 포함된 이미지 등록은 자제하여 주시기 바랍니다.</p>
									<button id="addFile" type="button" class="btn mb-3 btn-primary">파일 추가</button>
								</div>
								<div id="imgList">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<c:choose>
					<c:when test="${not empty LOGIN_USER }">
						<div class="text-center">
							<button id="qna-submit" type="button" class="btn btn-primary">등록</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="text-center">
							<p>일대일 문의는 로그인 후 사용하실 수 있습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>
</div>
<%@include file="../common/errorModal.jsp"%>
</body>
<script type="text/javascript">
	$(function() {
		
		var errorModal = new bootstrap.Modal(document.getElementById("modal-info-error"), {
			keyboard: false
		});

		// 에러창을 보여주는 모달
		function showError(message) {
			$("#span-error").text(message);
			errorModal.show();
			
			$("#submit").click(function() {
				errorModal.hide();
			})
		}
		
		$("#qna-submit").click(function() {
			
			if (!$("#theater").val()) {
				showError("문의 지점을 선택해 주세요.");
				return;
			}
			
			if (!$("#ask-type").val()) {
				showError("문의 유형을 선택해 주세요.");
				return;
			}
			
			if (!$("#userName").val()) {
				showError("사용자명을 입력해 주세요.");
				return;
			}
			
			if (!$("#email").val()) {
				showError("이메일을 입력해 주세요.");
				return;
			}
			
			if (!$("#phone").val()) {
				showError("휴대폰번호를 입력해 주세요.");
				return;
			}
			
 			if (!$("#title").val()) {
				showError("제목을 입력해 주세요.");
				return;
			}
			
 			if (!$("#textarea").val()) {
				showError("문의 내용을 입력해 주세요.");
				return;
			}
			
 			$("#qnaForm").submit();
		})
		
		let count = 0;
		$("#addFile").click(function() {
			addFile();
			count++;
			
			if (count >= 3) {
				$(this).attr('disabled', true);
			}
		})

	    function addFile() {
	    	let html = "";

	    	html += "<div class='list mb-2'>"
	    	html += "<input multiple='multiple' type='file' class='border fileList' name='upfiles'/>"
	    	html += "<button type='button' class='deleteFile mt ms-2 btn btn-sm btn-secondary'>삭제</button>";
	    	html += "</div>"
	    	
	    	$("#imgList").append(html);
	    }
		
		deleteFile();
		
	    function deleteFile() {
	    	$("#imgList").on('click', ".deleteFile", function() {
		    	let button = $(this);
		    	button.closest('div').remove();
		    	count--;
		    	
		    	if (count <= 3) {
					$("#addFile").attr('disabled', false);
				}
		    })
	    }
	    
	    $("#imgList").on('change', '.fileList', function() {
	    	let maxSize = 5242880; // 5MB 파일 용량 제한
			let files = $("[name=upfiles]");
	    	
	    	for (let i = 0; i <= files.length; i++) {
				let size = files[i].files[0].size;
				
				if (size > maxSize) {
					$(this).val('');
					
					showError("5MB 이상의 파일을 업로드할 수 없습니다.");
					return;
				}
			}
	    })
		
		function resetTheater() {
			$('#theater option').remove();
			$('#theater').append($('<option>').val('').text('극장선택'));
			$('#theater').attr('disabled', true);
		}
		
		$("#region").click(function() {
			let $option = $("#theater");
			let regionNo = $("#region option:selected").val();
			
			if (regionNo != '지역선택') {  
				resetTheater();
				$("#theater").attr("disabled", false);
				
				$.getJSON("/rest/theater", {regionNo: regionNo}, function(response) {
					let theaters = response.items;
					$.each(theaters, function(index, theater) {
						let output = "";
						output = "<option value='"+theater.no+"'>"+theater.name+"</option>";
						$option.append(output);
					})
				})
			}
		})
	})
</script>
</html>