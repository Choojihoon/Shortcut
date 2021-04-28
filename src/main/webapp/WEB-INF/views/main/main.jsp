<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- 파비콘 -->
<link rel="shortcut icon" href="${ pageContext.servletContext.contextPath }/resources/img/logo1.png" type="image/x-icon">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/index.css">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> -->
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	
	

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

	<title>Short Cut</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="main_content">
		<div class="row">
			<div class="main_text_area">
				<div class="main_text1">
					Work on big ideas, 
				</div>
				<div class="main_text1">
					without the busywork
				</div>
				
				<div class="main_line"></div>
				<div class="main_text2">
					From the small stuff to the big picture, ShortCut organizes work so teams know what to do, why it matters, and how to get it done.
				</div>
			</div>
			<div class="main_img_area">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner">
						 <div class="item active">
					     	<img class="img_detail" src="./resources/img/mainimg1.png">
					     </div>
					     <div class="item">
					     	<img class="img_detail" src="./resources/img/mainimg2.png">
					     </div>
					     <div class="item">
					     	<img class="img_detail" src="./resources/img/mainimg3.png">
					     </div>
					</div>
				</div>		
			</div>				
		</div>
	</div>
	<script>
		const message = '${ requestScope.message }';
		if(message != null && message !== '') {
			alert(message);
		}
	</script>
	
	<!-- 모달  -->
	
	<jsp:include page="../modal/modal_login.jsp"></jsp:include>
	<jsp:include page="../modal/modal_logout.jsp"></jsp:include>
	<jsp:include page="../modal/modal_password_find.jsp"></jsp:include>
	<jsp:include page="../modal/modal_password_reconfirm.jsp"></jsp:include>
	<jsp:include page="../modal/modal_password_reset.jsp"></jsp:include>
	<jsp:include page="../modal/modal_password_resetcomplete.jsp"></jsp:include>
	<jsp:include page="../modal/modal_regist.jsp"></jsp:include>
</body>
</html>