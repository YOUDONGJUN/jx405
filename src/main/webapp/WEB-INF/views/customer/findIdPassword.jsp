<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>HTA CINEMA</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="/resources/css/common.css" />
	<link rel="stylesheet" href="/resources/css/customer/customerCommon.css" />
	<link rel="stylesheet" href="/resources/css/customer/findIdPassword.css" />
	<link rel="icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@include file="/WEB-INF/views/common/noticeModal.jsp"%>
	<div class="container">
		<div class="content-wrap mx-auto">
			<div class="row">
				<div class="col">
					<a class="nav-link my-5" href="/">
						<img id="img-logo" src="/resources/images/logo/logo-htacinema-purple.png">
					</a>
				</div>
			</div>
			<div class="row mb-4">
				<div class="col">
					<h3>아이디/비밀번호 찾기</h3>
				</div>
			</div>
			<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="findId-tab" data-bs-toggle="tab" data-bs-target="#findId" 
					type="button" role="tab" aria-controls="findId" aria-selected="true">아이디 찾기</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="findPassword-tab" data-bs-toggle="tab" data-bs-target="#findPassword" 
					type="button" role="tab" aria-controls="findPassword" aria-selected="false">비밀번호 찾기</button>
				</li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="findId" role="tabpanel" aria-labelledby="findId-tab">
					<form id="form-findId">
						<input type="hidden" name="find" value="id" />
						<div class="row mt-4">
							<div class="col p-0">
								<h5>간편 찾기</h5>
							</div>
						</div>
						<div class="row p-0 row-top">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findId-name">이름</label>
							</div>
							<div class="col-9 align-self-center">
								<input type="text" class="form-control" id="input-findId-name" name="name" placeholder="이름" maxlength="17" />
							</div>
						</div>
						<div class="row p-0 row-other">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findId-birthDate">생년월일</label>
							</div>
							<div class="col-9 align-self-center">
								<input type="text" class="form-control" id="input-findId-birthDate" name="birthDate" placeholder="생년월일 앞8자리" maxlength="8" />
							</div>
						</div>
						<div id="div-birthDate-error" class="row p-0 row-other" hidden>
							<div class="col-3 m-0 ps-3 py-3 col-label"></div>
							<div class="col-9 align-self-center">
								<span class="error">잘못된 생년월일 형식입니다.</span>
							</div>
						</div>
						<div class="row p-0 row-other">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findId-phoneNumber">휴대폰 번호</label>
							</div>
							<div class="col-9 align-self-center">
								<input type="text" class="form-control" id="input-findId-phoneNumber" name="phoneNumber" placeholder="'-' 없이 입력" maxlength="11" />
							</div>
						</div>
						<div id="div-findId-phoneNumber-error" class="row p-0 row-other" hidden>
							<div class="col-3 m-0 ps-3 py-3 col-label"></div>
							<div class="col-9 align-self-center">
								<span class="error">잘못된 휴대폰 번호 형식입니다.</span>
							</div>
						</div>
						<div class="row mt-4">
							<div class="d-grid col-6 mx-auto">
								<button id="btn-findId" type="button" class="btn btn-primary btn-lg" disabled>아이디 찾기</button>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane" id="findPassword" role="tabpanel" aria-labelledby="findPassword-tab">
					<form id="form-findPassword" action="/customer/resetPasswordForm" method="post">
						<input type="hidden" name="find" value="password" />
						<div class="row mt-4">
							<div class="col p-0">
								<h5>간편 찾기</h5>
							</div>
						</div>
						<div class="row p-0 row-top">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findPassword-id">아이디</label>
							</div>
							<div class="col-9 align-self-center">
								<input type="text" class="form-control" id="input-findPassword-id" name="id" placeholder="아이디" maxlength="12" />
							</div>
						</div>
						<div class="row p-0 row-other">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findPassword-name">이름</label>
							</div>
							<div class="col-9 align-self-center">
								<input type="text" class="form-control" id="input-findPassword-name" name="name" placeholder="이름" maxlength="17" />
							</div>
						</div>
						<div class="row p-0 row-other">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findPassword-phoneNumber">휴대폰 번호</label>
							</div>
							<div class="col-6 align-self-center">
								<input type="text" class="form-control" id="input-findPassword-phoneNumber" name="phoneNumber" placeholder="'-' 없이 입력" maxlength="11" />
							</div>
							<div class="col-3 align-self-center">
								<button id="btn-request-authentication" type="button" class="btn btn-primary" disabled>인증요청</button>
							</div>
						</div>
						<div id="div-findPassword-phoneNumber-error" class="row p-0 row-other" hidden>
							<div class="col-3 m-0 ps-3 py-3 col-label"></div>
							<div class="col-9 align-self-center">
								<span class="error">잘못된 휴대폰 번호 형식입니다.</span>
							</div>
						</div>
						<div class="row p-0 row-other">
							<div class="col-3 m-0 ps-3 py-3 col-label">
								<label for="input-findPassword-authenticationCode">인증번호</label>
							</div>
							<div class="col-6 align-self-center position-relative">
								<input type="number" class="form-control" id="input-findPassword-authenticationCode" />
								<span id="span-remainTime" class="position-absolute top-50 translate-middle-y" hidden></span>
							</div>
							<div class="col-3 align-self-center">
								<button type="button" id="btn-check-authentication" class="btn btn-primary" disabled>인증확인</button>
							</div>
						</div>
						<div id="div-findPassword-check-authentication-error" class="row p-0 row-other" hidden>
							<div class="col-3 m-0 ps-3 py-3 col-label"></div>
							<div class="col-9 align-self-center">
								<span id="span-findPassword-check-authentication-error" class="error"></span>
							</div>
						</div>
						<div class="row mt-4">
							<div class="d-grid col-6 mx-auto">
								<button id="btn-findPassword" type="submit" class="btn btn-primary btn-lg" disabled>비밀번호 찾기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/resources/js/customer/regExp.js"></script>
<script src="/resources/js/customer/showErrorDiv.js"></script>
<script src="/resources/js/customer/enableButton.js"></script>
<script src="/resources/js/customer/Validation.js"></script>
<script src="/resources/js/customer/ValidationWithSave.js"></script>
<script src="/resources/js/customer/BirthDateValidation.js"></script>
<script src="/resources/js/customer/formToJson.js"></script>
<script>
	$(function() {
		const findIdNameInput = $("#input-findId-name");
		const findIdBirthDateInput = $("#input-findId-birthDate");
		const findIdPhoneNumberInput = $("#input-findId-phoneNumber");
		const findPasswordIdInput = $("#input-findPassword-id");
		const findPasswordNameInput = $("#input-findPassword-name");
		const findPasswordPhoneNumberInput = $("#input-findPassword-phoneNumber");
		const findPasswordAuthenticationCodeInput = $("#input-findPassword-authenticationCode");
		
		const findIdBirthDateErrorDiv = $("#div-birthDate-error");
		const findIdPhoneNumberErrorDiv = $("#div-findId-phoneNumber-error");
		const findPasswordPhoneNumberErrorDiv = $("#div-findPassword-phoneNumber-error");
		const findPasswordCheckAuthenticationErrorDiv = $("#div-findPassword-check-authentication-error");
		
		const findPasswordRemainTimeSpan = $("#span-remainTime");
		
		const findIdButton = $("#btn-findId");
		const findPasswordButton = $("#btn-findPassword");
		const findPasswordRequestAuthenticationButton = $("#btn-request-authentication");
		const findPasswordCheckAuthenticationButton = $("#btn-check-authentication");
		
		const noticeModal = new bootstrap.Modal(document.getElementById("modal-notice"), {
			keyboard: false
		});
		const noticeModalMessageSpan = document.getElementById("span-notice-message");
		
		const findIdNameValidationWithSave = new ValidationWithSave(findIdNameInput, nameReg);
		const findIdBirthDateOnlyNumberAllowedValidationWithSave = new ValidationWithSave(findIdBirthDateInput, onlyNumberReg);
		const findIdBirthDateValidation = new BirthDateValidation(findIdBirthDateInput);
		const findIdPhoneNumberValidationWithSave = new ValidationWithSave(findIdPhoneNumberInput, onlyNumberReg);
		const findIdPhoneNumberValidation = new Validation(findIdPhoneNumberInput, phoneNumberReg);
		const findPasswordIdValidationWithSave = new ValidationWithSave(findPasswordIdInput, idReg);
		const findPasswordNameValidationWithSave = new ValidationWithSave(findPasswordNameInput, nameReg);
		const findPasswordPhoneNumberValidationWithSave = new ValidationWithSave(findPasswordPhoneNumberInput, onlyNumberReg);
		const findPasswordPhoneNumberValidation = new Validation(findPasswordPhoneNumberInput, phoneNumberReg);
		
		// 인증번호
		let authenticationCode;
		// 남은 인증시간을 계산하기 위한 interval
		let remainTimeInterval;
		// 인증확인 제한시간(초)
		const limitTime = 10;
		
		// 고객 정보 존재 여부
		// 인증요청을 성공하면 true로 변경된다.
		let isCustomerExist = false;
		
		// 아이디 찾기의 모든 유효성 검사 flag가 true인지 확인한다.
		function isFindIdAllFlagTrue() {
			return findIdNameValidationWithSave.flag
				&& findIdBirthDateValidation.flag
				&& findIdPhoneNumberValidation.flag;
		}
		
		// 비밀번호 찾기의 모든 유효성 검사 flag가 true인지 확인한다.
		function isFindPasswordAllFlagTrue() {
			return findPasswordIdValidationWithSave.flag
				&& findPasswordNameValidationWithSave.flag
				&& findPasswordPhoneNumberValidation.flag;
		}
		
		// 아이디 찾기의 이름에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findIdNameInput.on("input", function() {
			findIdNameValidationWithSave.test();
			
			enableButton(findIdButton, isFindIdAllFlagTrue());
		});
		
		// 아이디 찾기의 생년월일에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findIdBirthDateInput.on("input", function() {
			findIdBirthDateOnlyNumberAllowedValidationWithSave.test();
			findIdBirthDateValidation.test();
			
			showErrorDiv(findIdBirthDateErrorDiv, !findIdBirthDateValidation.flag);
			enableButton(findIdButton, isFindIdAllFlagTrue());
		});
		
		// 아이디 찾기의 휴대폰 번호에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findIdPhoneNumberInput.on("input", function() {
			findIdPhoneNumberValidationWithSave.test();
			findIdPhoneNumberValidation.test();
			
			showErrorDiv(findIdPhoneNumberErrorDiv, !findIdPhoneNumberValidation.flag);
			enableButton(findIdButton, isFindIdAllFlagTrue());
		});
		
		// 비밀번호 찾기의 아이디에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findPasswordIdInput.on("input", function() {
			findPasswordIdValidationWithSave.test();
			
			enableButton(findPasswordRequestAuthenticationButton, isFindPasswordAllFlagTrue());
		});
		
		// 비밀번호 찾기의 이름에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findPasswordNameInput.on("input", function() {
			findPasswordNameValidationWithSave.test();
			
			enableButton(findPasswordRequestAuthenticationButton, isFindPasswordAllFlagTrue());
		});
		
		// 비밀번호 찾기의 휴대폰 번호에 키보드 입력이 있을 때마다 실행되며 input 값에 대해 유효성 검사를 실시한다.
		findPasswordPhoneNumberInput.on("input", function() {
			findPasswordPhoneNumberValidationWithSave.test();
			findPasswordPhoneNumberValidation.test();
			
			showErrorDiv(findPasswordPhoneNumberErrorDiv, !findPasswordPhoneNumberValidation.flag);
			enableButton(findPasswordRequestAuthenticationButton, isFindPasswordAllFlagTrue());
		});
		
		// 인증번호에 사용되는 4자리 난수를 생성한다.
		// 1000 ~ 9999
		function generateAuthenticationCode() {
			authenticationCode = Math.floor(Math.random()*(9999 - 1000 + 1)) + 1000;
		}
		
		// 시간(초)을 "15:30"와 같은 string으로 변환한다.
		function timeToString(time) {
			const minute = parseInt(time/60);
			let second = time%60;
			
			if (second < 10) {
				second = "0" + second;
			}
			
			return minute + ":" + second;
		}
		
		// 인증요청을 성공했을 때 실행하는 작업들이다.
		function passedRequestAuthentication() {
			isCustomerExist = true;
			generateAuthenticationCode();
			
			findPasswordAuthenticationCodeInput.attr("placeholder", authenticationCode);
			findPasswordRequestAuthenticationButton.text("재전송");
			findPasswordCheckAuthenticationButton.prop("disabled", false);
			$("#form-findPassword").find("input:not(#input-findPassword-authenticationCode)").prop("readonly", true);
			findPasswordRemainTimeSpan.prop("hidden", false);
			noticeModalMessageSpan.innerHTML = "인증번호를 전송했습니다.<br>"
				+ "인증번호가 도착하지 않았을 경우 재전송을 눌러주세요.";
			
			let remainTime = limitTime;
			// 1초마다 남은 시간을 표시하고 남은 시간에서 1을 줄인다.
			// 남은 시간이 0일 경우 "인증확인" 버튼을 비활성화하고 interval을 종료한다.
			remainTimeInterval = setInterval(function() {
				findPasswordRemainTimeSpan.text(timeToString(remainTime));
				
				if (remainTime === 0) {
					findPasswordCheckAuthenticationButton.prop("disabled", true);
					
					findPasswordCheckAuthenticationErrorDiv.find("span").text("유효시간이 초과되었습니다. 인증번호 재전송을 통해 다시 인증해주세요.");
					showErrorDiv(findPasswordCheckAuthenticationErrorDiv, true);
					
					clearInterval(remainTimeInterval);
				}
				remainTime--;
			}, 1000)
		}
		
		// ajax 통신을 통해 서버에 formElement 내부의 input 값들을 보내고 그에 대한 결과를 받아온다.
		function findIdPasswordAjax(formElement) {
			const jsonData = JSON.stringify(formToJson(formElement));
			
			$.ajax({
				type: "post",
				url: "/customer/findIdPassword",
				data: jsonData,
				contentType: "application/json",
				dataType: "json",
				success: function(response) {
					if (response.status) {
						if (formElement.attr("id") === "form-findId") {
							let {items:{id, createdDate}} = response;
							
							let message = "회원님의 아이디는 [" + id + "] 입니다.<br>"
								+ "가입일: " + createdDate;
							noticeModalMessageSpan.innerHTML = message;
						} else {
							passedRequestAuthentication();
						}
					} else {
						noticeModalMessageSpan.innerHTML = response.error;
					}
					noticeModal.show();
				}
			});
		}
		
		findIdButton.click(function(event) {
			findIdPasswordAjax($("#form-findId"));
		});
		
		// 비밀번호 찾기의 "인증요청" 버튼을 누를 때마다 실행되며, isCustomerExist가 true일 경우 ajax 통신을 생략한다.
		findPasswordRequestAuthenticationButton.click(function(event) {
			findPasswordAuthenticationCodeInput.val("");
			showErrorDiv(findPasswordCheckAuthenticationErrorDiv, false);
			
			if (isCustomerExist) {
				clearInterval(remainTimeInterval);
				passedRequestAuthentication();
				noticeModal.show();
			} else {
				findIdPasswordAjax($("#form-findPassword"));
			}
		});
		
		// 비밀번호 찾기의 "인증확인" 버튼을 누를 때마다 실행되며, 인증번호가 맞거나 틀린 경우 각각에 대해 필요한 작업을 수행한다.
		findPasswordCheckAuthenticationButton.click(function(event) {
			const targetDiv = $(this).parent().parent();
			
			if (findPasswordAuthenticationCodeInput.val() == authenticationCode) {
				findPasswordRequestAuthenticationButton.prop("disabled", true);
				findPasswordButton.prop("disabled", false);
				targetDiv.remove();
				$(".error").parent().parent().remove();
				
				noticeModalMessageSpan.innerHTML = "휴대폰 인증을 완료했습니다.";
				noticeModal.show();
			} else {
				targetDiv.removeClass("row-other");
				targetDiv.next().find("span").text("인증번호가 일치하지 않습니다.");
				targetDiv.next().prop("hidden", false);
			}
		});
	});
</script>
</html>