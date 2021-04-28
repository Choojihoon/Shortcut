<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="member_regist">
		<div class="modal-dialog">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<div class="modal-title">회원가입</div>						
				</div>
				
	
				<!-- Modal body -->
				<form action="${ pageContext.servletContext.contextPath }/regist" method="post">
					<div class="modal-body">
						<div class="login_info">
							<span class="regist_icon">*</span>
							<input class="input_detail" type="text" name="name" placeholder="이름 ">	
						</div>
						<div class="login_info">
							<span class="regist_icon">*</span>
							<input class="input_detail" type="text" name="email" placeholder="이메일 ">	
						</div>	
						<div class="login_info">
							<span class="regist_icon">*</span>
							<input class="input_detail" type="password" name="password" placeholder="비밀번호 ">	
						</div>
						<div class="login_info">
							<span class="regist_icon">*</span>
							<input class="input_detail" type="password" name="passwordcheck" placeholder="비밀번호 확인 ">	
						</div>
						<div class="login_info">
							<span class="regist_icon">*</span>
							<input class="input_detail" type="text" name="phone" placeholder="연락처">	
						</div>											
					</div>
					
					<div class="login_btn_area">
						<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
						<button id="join_btn" class="login_btn" type="submit">회원가입</button>
					</div>
				</form>	
				<div class="modal_text_area">				
					<div class="modal_text">
						<a class="modal_text_detail type5" href="#" >이미 계정이 있으면 로그인 해주세요 </a>
					</div>
				</div>				
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function() {
	
			
			$(".modal_text_detail.type5").click(function(e) {
				e.preventDefault();
	
				
				$('#member_regist').modal("hide");
				$('#member_login').modal("toggle");
			});
			
		})
	
	</script>

<!-- <script type="text/javascript">

	$(function() {
		
		var regex_num_only = /^[0-9]*$/;	
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
		

		$("#join_btn").click(function(e) {
			e.preventDefault();
			


			var f = document.from_join;

			if(f.name.value == "") {
				alert("이름을 작성해 주세요.");
				return;
			}

			if(f.email.value == "") {
				alert("이메일을 기재해 주세요.");
				return;
			}

			if(!regExp.test(f.email.value)) {
				alert("이메일 양식으로 작성해 주세요.");
				return;
			}

			if(f.password.value == "") {
				alert("비밀번호를 입력해 주세요.");
				return;
			}
			if(f.passwordcheck.value == "") {
				alert("비밀번호를 확인해 주세요.");
				return;
			}

			


			//	가입 폼 유효성 인증 완료 시
			

			
		});
	});
</script> -->
</body>
</html>