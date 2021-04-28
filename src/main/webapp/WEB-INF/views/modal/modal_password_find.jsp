<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="password_find">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<div class="modal-title">비밀번호를 잊어버리셨나요 ??</div>						
				</div>
				<div class="modal_explanation">
					<div class="modal_text1">
						아래 사용중인  이메일 주소를 입력해주시면 비밀 번호 변경 인증번호를 보내드립니다.
					</div>
				</div>
	
				<!-- Modal body -->
				<form action="" method="">
					<div class="modal-body">
						<div class="login_info">
							<input class="input_detail" type="text" name="email" placeholder="Email 주소를 입력해주세요 ">	
						</div>											
					</div>
	
					
					<div class="modal_btn_area">
						<button type="button" class="modal_btn">인증번호 전송</button>
					</div>
				</form>	
				<div class="modal_text_area">
					<!-- <div class="modal_text">
						<a class="modal_text_detail type11" href="#" data-toggle="modal" data-target="#member_regist">회원가입</a> 
					</div> -->
					<div class="modal_text">
						<a class="modal_text_detail type3" href="#">이미 계정이 있으면 로그인 해주세요 </a>
					</div>
				</div>				
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function() {
	
			
			$(".modal_text_detail.type3").click(function(e) {
				e.preventDefault();
				
				$('#password_find').modal("hide");
				$('#member_login').modal("toggle");
			});
			
		
			
	
			$(".modal_btn").click(function(e){
				e.preventDefault();
	
				$('#password_find').modal("hide");
				$('##password_reset').modal("toggle");
			})
		})
	
	
	
	</script>
</body>
</html>