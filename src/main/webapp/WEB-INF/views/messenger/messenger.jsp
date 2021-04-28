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
	<meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}">
	
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/messenger.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"	rel="stylesheet">


	<title>Short Cut</title>

	<style>
		#addMember_btn.on {
			display: none;
		}
		#label {
			font-size:25px;
		}
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<!-- 쪽지 보내기 -->
	<form action="${ pageContext.servletContext.contextPath }/messenger"method="post">
		<div class="messenger_area">
			<div class="row">
				<div class="messenger_right_area">
					<div class="messenger_list">
						<div class="row">
							<div class="item_list">
								<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger">쪽지보내기</a>
							</div>
							<div class="item_list">
								<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger_receive">받은쪽지함</a>
							</div>
							<div class="item_list">
								<a class="item_detail" href="${ pageContext.servletContext.contextPath }/messenger/messenger_inbox_send">보낸	쪽지함</a>
							</div>
						</div>
						<!-- 쪽지 -->
						<div class="messenger_line"></div>
						<div class="send_area">
							<div class="row">
								<div class="send_itme">보내는 사람</div>
								<div class="send_itme_detail" style="font-size: 35px;">
									${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}</div>
							</div>

							<div class="row">
								<div class="send_itme">프로젝트</div>
								<div class="send_itme_detail">
									<input class="input_detail type1" id="selectpjt" type="text"
										name="addPjt" placeholder="Select Project" value=""> <input
										class="input_detail type2" id="addPjt" type="button"
										name="addPjt" value="프로젝트">
								</div>
								<div id="project"></div>
							</div>

							<div class="row" >
								<div class="send_itme">받는 사람</div>
								<div class="send_itme_detail">
									<input class="input_detail type1" id="selectmember" type="text"	name="addMember" placeholder="Add Member" value=""> 
									<input class="input_detail type2" id="addMember" type="button" name="addMember" value="멤버추가">
								</div>
								<div id="member"></div>
							</div>

							<div class="row">
								<div class="send_itme">구분</div>
								<div class="send_itme_detail">
									<input type="radio" name="messenger" id="work" value=1 style="width:20px; height:20px; border:1px;"><label for="work" id="label">업무</label>
									<input type="radio" name="messenger" id="etc" value=2 style="width:20px; height:20px; border:1px; margin-left:100px;"><label for="etc" id="label">기타</label>
								</div>
							</div>


							<div class="row type">
								<textarea class="textarea_detail"></textarea>
							</div>
							<div class="row">
								<div class="btn_area">
									<input name="${_csrf.parameterName}" type="hidden"  value="${_csrf.token}">
									<button type="submit" class="upload_btn" id="btnSend">올리기</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 쪽지 영역 끝 -->

	<script>
		/* 시큐리티 권한  */
		const token = $("meta[name='_csrf']").attr("content");
		const header = $("meta[name='_csrf_header']").attr("content");

		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});

		/* 멤버 버튼 한번만 */

		/* 멤버 추가 */
		$("#addMember").one("click", function() {
							$.ajax({
								type : "POST",
								url : "${pageContext.servletContext.contextPath}/messenger/messenger",
								success : function(data, status, xhr) {
									console.log(data);
									let memberList = data;
									let res = "";
									var selectMember = document.getElementById("selectmember").value;
									var member = document.getElementById("member");
									for (let i = 0; i < memberList.length; i++) {
										const mh = document.createElement("input");
										mh.value = memberList[i].memName;
										member.readOnly = true;
										member.appendChild(mh);
									}
								}
							});
						});
		/* 프로젝트 추가 */
		$("#addPjt").one("click", function() {
							$.ajax({
								type : "POST",
								url : "${pageContext.servletContext.contextPath}/messenger/messenger",
								success : function(data, status, xhr) {
									console.log(data);
									let pjtList = data;
									let res = "";
									
									var selectMember = document.getElementById("selectpjt").value;
									var project = document.getElementById("project");
									for (let i = 0; i < pjtList.length; i++) {
										const hmh = document.createElement("input");
										hmh.value = pjtList[i].pjtName;
										project.readOnly = true;
										project.appendChild(hmh);
									}
								}
							});
						});
		
		/* 웹 소켓 쪽지 보내기 */
		var ws;
		var userId = '${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}';
		
		function connect() {
			
			/* url 연결할 서버 경로 */
			ws = new WebSocket('ws:http://127.0.0.1:8001/shortcut/messenger/messenger/chat');
			
			ws.onopen = function() {
				console.log('연결 생성');
				register();
			};
			
			ws.onmessage = function(e) {
				console.log('메시지 받음');
				var data = e.data;
				addMsg(data);
			};
			
			ws.onclose = function() {
				console.log('연결 끊김');
			};
			
			function register() {
				var msg = {
						type:"register",
						userId : '${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}'
				};
				
				ws.send(JSON.stringify(msg));
			}
			
			function sendMsg() {
				var msg = {
						target : $("#targetUser").val(),
						message : $("#chatMsg").vla()
				};
				ws.send(JSON.stringigy(msg));
			}
			
			$(function() {
				connect();
				$("#btnSend").on("click", function() {
					var chat = $("#msgArea").val();
					chat = chat + "\n나 : " + $("#chatMsg").val();
					$("msgArea").val(chat);
					sendMsg();
					$("#chatMsg").val("");
				})
			});
		
		}
		
	</script>
</body>
</html>