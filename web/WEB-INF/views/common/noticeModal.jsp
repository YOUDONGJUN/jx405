<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="modal-notice" data-bs-backdrop="static" tabindex="-1" aria-labelledby="noticeModalLabel" aria-hidden="true">
	<div id="modal-dialog" class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="noticeModalLabel">알림</h5>
				<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<p id="span-notice-message"></p>
				<div class="d-flex justify-content-center mt-3">
					<button class="btn btn-primary" data-bs-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>