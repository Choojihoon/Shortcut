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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/retrospect.css">

	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	
	<!-- 구글 차트 -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    


	<title>Short Cut</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="retrospect_area">
		<div class="retrospect_header">
			<div class="header_text1">
				${ requestScope.pjtName } 프로젝트
			</div>
			<div class="header_text2">
				${ requestScope.sprName } 스프린트
			</div>	
		</div>
		<div class="time_area">
			<div class="row">
				
			</div>
		</div>
		<div class="retrospect_content">
			<form method="post" id="myForm">
				<input type="text" name="blgNo" id="blgNo" value="${ requestScope.blgNo }" style="display: none;">
				<input type="text" name="pjtNo" id="pjtNo" value="${ requestScope.pjtNo }" style="display: none;">
				<input type="text" name="pjtName" id="pjtName" value="${ requestScope.pjtName }" style="display: none;">
				<table>
					<tr>
						<th></th>
						<th>만족스러웠던 점</th>
						<th>깨달았거나 배웠던 점</th>
						<th>놓쳤거나 부족 햇던 점</th>
					</tr>
					<c:choose>
						<c:when test="${ !empty requestScope.review }">
							<c:forEach var="review" items="${ requestScope.review }">
								<tr>
									<td><input type="text" name="memName" value="${ review.memName }" style="border: 0; outline: 0; text-align: center;"></td>
									<td><textarea name="reviewLikeTxt" class="text_detail">${ review.reviewLikeTxt }</textarea></td>
									<td><textarea name="reviewLearnTxt" class="text_detail">${ review.reviewLearnTxt }</textarea></td>
									<td><textarea name="reviewMissTxt" class="text_detail">${ review.reviewMissTxt }</textarea></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="rpm" items="${ requestScope.reviewAndProjectMemberList }">
								<tr>
									<td><input type="text" name="memName" value="${ rpm.memberDTO.name }" style="border: 0; outline: 0; text-align: center;"></td>
									<td><textarea name="reviewLikeTxt" class="text_detail"></textarea></td>
									<td><textarea name="reviewLearnTxt" class="text_detail"></textarea></td>
									<td><textarea name="reviewMissTxt" class="text_detail"></textarea></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
				<c:choose>
					<c:when test="${ !empty requestScope.review }">
						<div class="save_btn">
							<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
							<button class="btn_detail" type="button" onclick="modifyReview();">수정</button>
							<button class="btn_detail" type="button" onclick="removeReview();">삭제</button>
							<input class="btn_detail" type="reset" value="초기화">
						</div>
					</c:when>
					<c:otherwise>
						<div class="save_btn">
							<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
							<button class="btn_detail" type="button" onclick="registReview();">저장</button>
							<input class="btn_detail" type="reset" value="초기화">
						</div>
					</c:otherwise>
				</c:choose>
			</form>
			<script>
				function modifyReview() {
					const $myForm = document.getElementById("myForm");
					
					$myForm.action = "${ pageContext.servletContext.contextPath }/board/backlog/retrospect/modify";
					$myForm.submit();
				}
				
				function removeReview() {
					const $myForm = document.getElementById("myForm");
					
					$myForm.action = "${ pageContext.servletContext.contextPath }/board/backlog/retrospect/remove";
					$myForm.submit();
				}
				
				function registReview() {
					const $myForm = document.getElementById("myForm");
					
					$myForm.action = "${ pageContext.servletContext.contextPath }/board/backlog/retrospect/regist";
					$myForm.submit();
				}
			</script>
		</div>
	</div>
</body>
</html>