<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<!-- 파비콘 -->
	<link rel="shortcut icon" href="${ pageContext.servletContext.contextPath }/resources/img/logo1.png" type="image/x-icon">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/meetinglog.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

	<title>Short Cut</title>
</head>
<body>
	<div class="modal fade" id="deleteCheck">
		<div class="modal-dialog">			
			<div class="modal-content">
				<div class="modal-body">
		     	      게시물을 정말 삭제하시겠습니까?
		        </div>
				<!-- Modal footer -->
				<div class="modal_footer">								
					<div class="btn_area">
						<input name="${_csrf.parameterName}" type="hidden"  value="${_csrf.token}">
						<input type="button" id="deletedBtn" class="upload_btn meetingBtn" value="삭제하기">	
						<button type="button" class="upload_btn meetingBtn" data-dismiss="modal">취소하기</button>
					</div>														
				</div>
			</div>
		</div>
	</div>
</body>
</html>