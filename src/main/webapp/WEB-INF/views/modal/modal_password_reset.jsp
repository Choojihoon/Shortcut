<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="password_reset">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<div class="modal-title">비밀번호 재설정</div>						
				</div>
				
	
				<!-- Modal body -->
				<form action="" method="">
					<div class="modal-body">
						<div class="login_info">
							<input class="input_detail" type="text" name="email" placeholder="인증번호 ">	
						</div>	
						<div class="login_info">
							<input class="input_detail" type="password" name="email" placeholder="변경할 비밀번호 ">	
						</div>															
					</div>
	
					
					<div class="login_btn_area">
						<button class="login_btn">비밀번호 변경</button>
					</div>
				</form>	
				<div class="modal_text_area">
					<!-- <div class="modal_text">
						<a class="modal_text_detail type2" href="#" data-toggle="modal" data-target="#member_regist">회원가입</a> 
					</div> -->
					<div class="modal_text">
						<a class="modal_text_detail type4" href="#">이미 계정이 있으면 로그인 해주세요 </a>
					</div>
				</div>				
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
	
			$(".modal_text_detail.type4").click(function(e) {
				e.preventDefault();
	
				
				$('#password_reset').modal("hide");
				$('#member_login').modal("toggle");
			});
			
		})
	
	</script>
</body>
</html>