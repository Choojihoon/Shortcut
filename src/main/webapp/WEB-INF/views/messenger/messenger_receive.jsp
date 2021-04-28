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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/messenger.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"	rel="stylesheet">



	<title>Short Cut</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="messenger_area">
		<div class="row">
			
			<div class="messenger_right_area">
				<div class="messenger_list">
					<div class="row">
						<div class="item_list">
							<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger">쪽지보내기</a>
						</div>
						<div class="item_list">
							<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger_receive">받은 쪽지함</a>
						</div>
						<div class="item_list">
							<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger_inbox_send">보낸	쪽지함</a>
						</div>
					</div><!-- 탭 영역 끝 -->
					
					<div class="messenger_line"></div>
					<div class="messenger_receiver_area">
						<div class="row type">
							<div class="recv_header">번호</div>
							<div class="recv_header">프로젝트명</div>
							<div class="recv_header">구분</div>
							<div class="recv_header">내용</div>
							<div class="recv_header">받은 사람</div>
							<div class="recv_header">보낸 날짜</div>
						</div>
						<div class="row">
						<c:forEach var="msgList" items="${requestScope.msgList }">
							<div class="recv_item"><c:out value="${ msgList.no }"/></div>
							<div class="recv_item"><c:out value="${ msgList.pjtName }"/></div>
							<div class="recv_item"><c:out value="${ msgList.type }"/></div>
							<div class="recv_item"><c:out value="${ msgList.txt }"/></div>
							<div class="recv_item"><c:out value="${ msgList.memName }"/></div>
							<div class="recv_item"><c:out value="${ msgList.date }"/></div>
                         </c:forEach>
						</div>
					</div>
					<!-- 리스트 영역 끝 -->
					<div class="msg_search_area">
						<div class="row">
							<select>
								<option>전체</option>
								<option>프로젝트명</option>
								<option>구분</option>
								<option>보낸사람</option>
							</select> <input class="input_detail" type="text" name=""
								placeholder="Search">
							<button class="btn_detail">검색</button>
						</div>
					</div><!-- 검색영역 끝 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>