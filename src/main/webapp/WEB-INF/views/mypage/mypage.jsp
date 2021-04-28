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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/mypage.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

	
    


	<title>Short Cut</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="mypage_area">
		<div class="mypage_header">내설정</div>
		<div class="row">
			<div class="mypage_left_area">				
				<div class="mypage_btn_area">
					<div class="btn_item">
						<a class="btn_detail" href="${ pageContext.servletContext.contextPath }/mypage/mypage">계정 정보</a>
					</div>					
					<div class="btn_item">
						<a class="btn_detail" href="${ pageContext.servletContext.contextPath }/mypage/mypage_password">비밀번호 변경</a>
					</div>				
				</div>
			</div>
			<div class="mypage_right_area">
				<div class="mypage_right_header">계정 정보</div>
				<form action="${ pageContext.servletContext.contextPath }/update" method="post">
					<div class="mypage_info_area">
						<div class="mypage_info_box">
							<div class="info_item">
								<div class="info_name">사용자 이름</div>
								<input class="input_detail" type="text" name="name" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}">
							</div>
							<div class="info_item">
								<div class="info_name">이메일</div>
								<input class="input_detail" type="text" name="email" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}" readonly>
							</div>
							<div class="info_item">
								<div class="info_name">휴대폰 번호</div>
								<input class="input_detail" type="text" name="phone" placeholder="휴대폰 번호를 입력해주세요!">
							</div>
						</div>	
						<div class="mypage_right_btn">
							<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
							<button class="mypage_btn_detail" type="submit">변경</button>
							<button class="mypage_btn_detail">취소</button>
						</div>
					</div>
				</form>
				<div class="member_quit">
					<div class="member_text">
						회원탈퇴를 원하시나요? 만일 원하신다면, <a href="#">이 곳을 눌러주세요</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>