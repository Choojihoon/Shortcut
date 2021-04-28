<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="member_logout">
		<div class="modal-dialog">
			<div id="asdf" class="modal-content login">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<div class="modal-title">정말 로그아웃 하시겠습니까?</div>						
				</div>
				
				<!-- Modal body -->
				<form action="${ pageContext.servletContext.contextPath }/logoutAsk" method="post">
	
					<!-- Modal footer -->
	
					<!-- <div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>	 -->
					<div class="login_btn_area">
						<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
						<button class="login_btn" type="submit">Logout</button>
						<!-- <a class="login_btn" href="http://kordzor.cafe24.com/final/project_board.html">Login</a> -->
					</div>
				</form>
			</div>
		</div>
	</div>


<script type="text/javascript">
	$(function() {
		/* $(".modal_text_detail").click(function(e) {
			e.preventDefault();

			var $t = $(this);
			
			$('#member_logout').modal("toggle");
		}); */
		
	})

</script>


</body>
</html>