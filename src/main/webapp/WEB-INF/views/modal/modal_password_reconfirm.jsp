<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="password_reconfirm">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<div class="modal-title">이메일 주소 재확인 요청</div>						
				</div>
				<div class="modal_explanation">
					<div class="modal_text1">
						기입하신 이메일 주소로 <span class="text_detail">가입된 정보가 없습니다.</span> 확인 후 다시 입력해 주세요.
					</div>
				</div>
	
				<!-- Modal body -->
				<form action="" method="">
					<div class="modal-body">
						<div class="login_info">
							<input class="input_detail" type="text" name="email" placeholder="Email 주소를 입력해주세요 ">	
						</div>											
					</div>
	
					
					<div class="login_btn_area">
						<button type="button" class="login_btn" data-toggle="modal" data-target="#password_reset">인증번호 전송</button>
					</div>
				</form>	
				<div class="modal_text_area">
					<!-- <div class="modal_text">
						<a class="modal_text_detail type1" href="#" data-toggle="modal" data-target="#member_regist">회원가입</a> 
					</div> -->
					<div class="modal_text">
						<a class="modal_text_detail type1" href="#" data-toggle="modal" data-target="#myModal">이미 계정이 있으면 로그인 해주세요 </a>
					</div>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>