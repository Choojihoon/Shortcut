<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}">
	
	<!-- 알람 -->
	<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.no" var="no"/>
	<script>
		var wsUri = "ws://127.0.0.01:8001/shortcut/count";
		
		function send_message() {
			websocket = new WebSocket(wsUri);
			websocket.onopen = function(evt) {
				onOpen(evt);
			}
			
			websocket.onmessage = function(evt) {
				onMessage(evt);
			}
			
			websocket.onerror = function(evt) {
				onError(evt);
			}
		}
		
		function onOpen(evt) {
			websocket.send("${no}");
		}
		
		function onMessage(evt) {
			console.log(evt.data);
			var $div = $("<div>").text(evt.data);
			/* $div.attr("id", "allAlarmBtn"); */
			$div.attr("class", "alarmCount");
			$(".aab").css("opacity", "0");
			/* $div.attr("class", "alarmCount2");
			$div.removeClass("alarmCount"); */
			
			if(evt.data > 0) {
				/* $div.removeClass("alarmCount2");
				$div.attr("class", "alarmCount"); */
				$div.attr("id", "allAlarmBtn");
				$(".aab").css("opacity", "1");
				$(".aab").append($div);
			}
			
		}
		
		function onError(Evt) {
			
		}
		
		$(document).ready(function() {
			send_message();
			console.log("시작!");
		})
	</script>
	</security:authorize>
</head>
<body>
	<div class="top_area">
		<div class="row">
			<div class="top_logo_area">
				<a class="top_logo_detail" href="${ pageContext.servletContext.contextPath }/main">
					<img class="logo_detail" src="${ pageContext.servletContext.contextPath }/resources/img/logo1.png">
					<span class="logo_text">Short Cut</span>	
				</a>			
			</div>
			<div class="top_menu_area">			
				<a class="menu_list" href="${ pageContext.servletContext.contextPath }/mypage/mypage">
					<i class="fas fa-cog"></i>
				</a>
				<div class="aab" id=""></div>
				<a class="menu_list" id="">
					<i class="far fa-bell" id="allAlarmBtn"></i>
				</a>	
				<c:if test="${!empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username }">
				<a class="menu_list" data-toggle="modal" data-target="#messenger_show" onclick="messengerShow(${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no})">
					<i class="far fa-envelope"></i>	
				</a>
				</c:if>
				<c:choose>
					<c:when test="${!empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
						<a class="menu_list" data-toggle="modal" data-target="#member_logout">로그아웃</a>
						<a class="menu_list">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username} 님이 로그인 되었습니다.</a>	
					</c:when>
					
					<c:otherwise>
						<a class="menu_list" data-toggle="modal" data-target="#member_regist">회원가입</a>
						<a class="menu_list" data-toggle="modal" data-target="#member_login">로그인</a>
					</c:otherwise>
				</c:choose>
				<input type="text" id="ABC" style="display: none;" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}">
				<a class="menu_list" href="${ pageContext.servletContext.contextPath }/board/project_board/${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}">프로젝트</a>
				<a class="menu_list" href="${ pageContext.servletContext.contextPath }/mywork/mywork">내업무</a>
				<a class="menu_list" href="#">한국어</a>
				<a class="menu_list">${requestScope.loginFailMsg}</a>
				
			</div>
		</div>
	</div>


	<div class="modal fade" id="messenger_show" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">
            Project Member
          </h4>
        </div>
        <div class="modal-body type3">
          <div class="participation_list">
            <div class="participation_item messengermodallist">
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>



  <div class="modal fade" id="messenger_chatting" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content type3">
        <div class="modal-header type3">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <div class="chatting_header">
            <div class="row">
              <div class="chatting_logo">
                <img class="chatting_logo_detail" src="${ pageContext.servletContext.contextPath }/resources/img/logo1.png">
              </div>              
              <div class="chatting_info messengerto">
              </div>  
            </div>            
          </div>         
        </div>
        <div class="modal-body chat-list">
         <div id="chat-list"></div>
        </div>        
        <div class="input_area">
          <input id="msg" class="messagebox_detail" type="text" name="" placeholder="내용을 입력해주세요">
          <button id="msg_process" class="message_send">보내기</button>
        </div>
      </div>
    </div>
  </div>



<!-- <script src="/socket.io/socket.io.js"></script> -->
<script src="http://localhost:8002/socket.io/socket.io.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
	var toUserNo = "";
  $(function(){
	 /*유저의 Login값 저장*/
	  const userNo = "${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}";
	
	  /* 유저 로그인 시 소켓 연결 */ 
    if( userNo ){
    	console.log("ID조회가 가능, 소켓 연결을 시작함")
    	 const socket = io("http://localhost:8002", {
             withCredentials: false,
             extraHeaders: {
               "Access-Control-Allow-Origin": "*"
             },
             transport: ['websocket']
         });
    	
   		
    	//UserNo 전달 
    	socket.emit("login",userNo);
    	
    	console.log("아이디를 전송하였음.")
    	
    	//UserNo에 따른 확인하지 않은 메세지 존재하는지 여부 확인
    	 //msg에서 키를 누를떄
        $("#msg").keydown(function(key){
            //해당하는 키가 엔터키(13) 일떄
            if(key.keyCode == 13){
                //msg_process를 클릭해준다.
                msg_process.click();
            }
        });
        
       
    
	  
	 /* 목록에서 '대화'버튼 클릭 시 */
    $(this).on("click",".send_btn", function(){

      let num= this.dataset.num;
      toUserNo = num;
      let name= this.dataset.name;
      console.log("num:" + num);
      console.log("name:" + name);
      
      /* 리스트를 접고, 대화창 오픈 */
      $("#messenger_show").modal("hide")
      $("#messenger_chatting").modal("show")
      $("#chat-list").empty();
      $("#messenger_chatting").find(".messengerto").empty();
      $("#messenger_chatting").find(".messengerto").append("<span>"+name+"</span>");
      socket.emit("mgsList", toUserNo,userNo);
      
    });
	 
	
	//전체 대화 내용 수신 데이터 수신 
    socket.on("receiveMgsList", function (data) {
    	 mkgchatList(data);
    	 console.log(data);
      });
    //msg_process를 클릭할 때
    
    //대화 수신
      socket.on("send_msg", function (msg,loginId) {
    	//  socket.id = userNo;
       let chatting = {
        	fromUser: loginId,
        	msg: msg,
        }
    	  console.log("데이터가 왔다!!! ");
    	  console.log(msg);
    	  console.log(loginId);
    	  mkgchatList(chatting);
      });
      
      
    $("#msg_process").click(function(){
        let chatting = {
        	toUser: toUserNo,
        	fromUser: userNo,
        	msg: $("#msg").val(),
        }
        
    	//소켓에 send_msg라는 이벤트로 input에 #msg의 벨류를 담고 보내준다.
         socket.emit("write_msg", toUserNo,$("#msg").val());
        
         mkgchatList(chatting);
        //#msg에 벨류값을 비워준다.
        $("#msg").val("");
    });
    function mkgchatList(data) {
		 
		const speechBubble = document.createElement('div');
    	
    	if(data.fromUser === userNo){
    	 speechBubble.classList.add('mine');
    	} else {
    	 speechBubble.classList.add('other');
    	}
    	const name = document.createElement('div');
    	name.textContent = data.fromUser;
    	speechBubble.appendChild(name);
    	
    	const chat = document.createElement('div');
        chat.textContent = data.msg;
        speechBubble.appendChild(chat);
        
    	 document.querySelector('#chat-list').appendChild(speechBubble);
   
	}

   
    
    }
	  ///////
	  
  });
  
  
	
	
	
/*메신저 클릭 시 (리스트 노출)*/	
  function messengerShow(userNo){
	
	  const token = $("meta[name='_csrf']").attr("content");
		const header = $("meta[name='_csrf_header']").attr("content");
		
		$(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		});
		
		
	  console.log("userNo: " + userNo);
	  $.ajax({
		 url: "${pageContext.servletContext.contextPath}/messenger/member",
		 method: "post",
		 data: {"userNo": userNo
		      },
		 success: function(data, status, xhr) {
				console.table(data); 
				let messengerList = $('.messengermodallist')
				for (let i = 0 ; i < data.length; i++){
					let html ='<div class="row">'+'<div class="item_list type1">'+ data[i].name 
					+'</div>'+'<div class="item_list type2">'+data[i].email
					+'</div><div class="item_list type3"><button class="send_btn" data-num="'+data[i].no+'" data-name="'+data[i].name+'">'
					+'대화</button></div></div>';  	
					messengerList.append(html);
				}
				 
		},
		 error: function(xhr, status, error){
			 console.log(error);
		 }
		
	  });
  }
  
  
 
  /*
        $(document).ready(function(){
                //var socket = io("http://localhost:8002");
                
                //const io = require("socket.io-client");
                const socket = io("http://localhost:8002", {
                  withCredentials: false,
                  extraHeaders: {
                    "Access-Control-Allow-Origin": "*"
                  },
                  transport: ['websocket']
                });
                
                
               
                
                
                //msg에서 키를 누를떄
                $("#msg").keydown(function(key){
                    //해당하는 키가 엔터키(13) 일떄
                    if(key.keyCode == 13){
                        //msg_process를 클릭해준다.
                        msg_process.click();
                    }
                });
                
                //msg_process를 클릭할 때
                $("#msg_process").click(function(){
                    //소켓에 send_msg라는 이벤트로 input에 #msg의 벨류를 담고 보내준다.
                     socket.emit("send_msg", $("#msg").val());
                    //#msg에 벨류값을 비워준다.
                    $("#msg").val("");
                });
                
                //소켓 서버로 부터 send_msg를 통해 이벤트를 받을 경우 
                socket.on('send_msg', function(msg) {
                    //div 태그를 만들어 텍스트를 msg로 지정을 한뒤 #chat_box에 추가를 시켜준다.
                    $('<div></div>').text(msg).appendTo("#chat_box");
                });

            });
 */
</script>














<c:choose>
	<c:when test="${!empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
		<div>
			
			<!-- <button id="allAlarmBtn">AlARM</button> -->
			<div class="alarmArea on">
				<div class="btn-group btn-group-justified">
					<span><button class="btn btn-default" id="generalAlarmBtn" type="button">Alarm</button></span>
					<span><button class="btn btn-default" id="githubAlarmBtn" type="button">Github Commit</button></span>
				</div>
				<hr>
				<div class="generalAlarmArea">
					<h4 align="center" style="font-weight: bold;">Alarm</h4>
					<div id="generalAlarmDiv"></div>
				</div>
				<div class="githubAlarmArea">
					<c:if test="${ empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.gitUrl }">
					<form action="${ pageContext.servletContext.contextPath }/alarm/github/regist" method="POST">										
						<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
						<input name="memNo" type="text" id="memNo" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}" style="display: none;">
						<input name="githubInfo" style="width: 100%;" type="text" id="githubInfo" placeholder="깃허브 주소">
						<br><br>
						<input class="btn btn-default" style="width: 100%;" type="submit" value="등록">
					</form>
					</c:if> 
					<c:if test="${ !empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.gitUrl }">
						<div id="githubUrlArea" class="ghu1 main"></div>
						<div id="githubUrlArea" class="ghu2 main"></div>
						<div class="ghu3"></div>
						<br>
						<button class="btn btn-default" id="modifyGitUrl" type="button" onclick="modifyGitUrlBtn();" style="width: 100%">수정</button>
					</c:if>
					<br>
					<br>
					<table>
						<thead>
							<tr>
								<th><h4 align="center" style="font-weight: bold;">Github Issues</h4></th>
							</tr>
							<tr style="height: 10px;"></tr>
						</thead>
						<tbody id=githubArea>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
			<script>
				function modifyGitUrlBtn() {
					
					$(".ghu3").empty();
					
					$("#modifyGitUrl").remove();
					
					$(".ghu3").append('<br>');
					$(".ghu3").append('<form id="gitForm" method="POST">');
					$("#gitForm").append('<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>');
					$("#gitForm").append('<input name="memNo" type="text" id="memNo" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}" style="display: none;">');
					$("#gitForm").append('<input type="text" class="im" name="modifyUrl" value="${ sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.gitUrl }" style="margin: 3px; width: 100%; font-size: 15px;">');
					$("#gitForm").append('<button id="rModifyGitUrl" class="btn btn-default" type="button" style="margin: 3px; width: 100%; background-color: white;">등록</button>');
					$("#gitForm").append('<button id="dModifyGitUrl" class="btn btn-default" type="button" style="margin: 3px; width: 100%; background-color: white;">삭제</button>');
					$("#gitForm").append('<br>');
					$("#gitForm").append('<br>');
					$("#gitForm").append('<button class="btn btn-default" type="button" style="margin: 3px; width: 100%; background-color: white;" onclick="cancelGitBtn();">취소</button>');
					$("#gitForm").append('<hr>');
					$("#gitForm").append('</form>');
				}
				
				function cancelGitBtn() {
	
					$(".ghu3").empty();
					
					$(".ghu3").append('<br>');
					$(".ghu3").append('<button class="btn btn-default" id="modifyGitUrl" type="button" onclick="modifyGitUrlBtn();" style="width: 100%">수정</button>');
					
				}
			</script>
			<script>
				$(function() {
					
		            const flashMessage = '${ requestScope.flashMessage }';
		            if(flashMessage != null && flashMessage !== '') {
		            	
		                alert(flashMessage);
		                
		            	$.ajax({
		            		url : "${pageContext.servletContext.contextPath}/session/expire",
		            		method : "GET",
		            		success : function(data, status, xhr) {
		            			console.log(data);
		            		},
		            		error : function(xhr, status, error) {
		            			console.log(error);
		            		}
		            	});
		            	
		            	location.reload();
		            }
					
					$(document).on("click","#rModifyGitUrl", function() {
						const $gitForm = document.getElementById("gitForm");
						$gitForm.action = "${pageContext.servletContext.contextPath}/alarm/github/modify";
						$gitForm.submit(); 
					});
					
					$(document).on("click", "#dModifyGitUrl", function() {
						const $gitForm = document.getElementById("gitForm");
						$gitForm.action = "${pageContext.servletContext.contextPath}/alarm/github/remove";
						$gitForm.submit(); 
					});
					
					/* 알람 삭제 */
					$(document).on("click", ".altDelBtn", function() {
						
						var altDelNo = $(this).attr("id");
						console.log(altDelNo);
						
						const token = $("meta[name='_csrf']").attr("content");
						const header = $("meta[name='_csrf_header']").attr("content");
						
						$(document).ajaxSend(function(e, xhr, options) {
						    xhr.setRequestHeader(header, token);
						});
						
						$.ajax({
							url : "${pageContext.servletContext.contextPath}/alarm/general/remove",
							method : "POST", 
							data : {
								altDelNo : altDelNo	
							},
							success : function(data, status, xhr) {
								
								console.log(data);	
							
								var $generalAlarmDiv = document.getElementById("generalAlarmDiv");
								while($generalAlarmDiv.firstChild) {
									$generalAlarmDiv.removeChild($generalAlarmDiv.firstChild);
								}
								
								generalAlarm();
							},
							error : function(xhr, status, error) {
								console.log(error);
							}
						});
						
					});
					
					/* const githubArea = document.getElementById("githubArea");
					
					$(".generalAlarmArea").hide();
					$(".githubAlarmArea").hide();
					$("#generalAlarmBtn").hide();
					$("#githubAlarmBtn").hide();
					let flag = false;
					
					$("#allAlarmBtn").click(function() {
						
						if(!flag) {
							flag = true;
							$(".generalAlarmArea").show();
							$(".githubAlarmArea").hide();
							$("#generalAlarmBtn").show();
							$("#githubAlarmBtn").show();
						} else if(flag) {
							flag = false;
							$(".generalAlarmArea").hide();
							$(".githubAlarmArea").hide();
							$("#generalAlarmBtn").hide();
							$("#githubAlarmBtn").hide();
						}
						
					}); */
					
					function generalAlarm() {

						var $generalAlarmDiv = document.getElementById("generalAlarmDiv");
						
						$.ajax({
							url : "${pageContext.servletContext.contextPath}/alarm/general",
							method : "GET",
							data : { no : "${ sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no }" },
							success : function(data, status, xhr) {
								console.log(data);
								
								for(index in data) {
									
									let alarmToday = new Date(data[index].altEnrollDate);
									
									let alarmYear = alarmToday.getFullYear();
									let alarmMonth = "" + (alarmToday.getMonth() + 1);
									let alarmDate = "" + alarmToday.getDate();
									let alarmDay = alarmToday.getDay();
									let alarmHour = alarmToday.getHours();
									let alarmMinutes = alarmToday.getMinutes();
									
									const $altTxt = document.createElement("a");
									const $altEnrollDate = document.createElement("div");
									const $altDelBtn = document.createElement("button");
									const $hr = document.createElement("hr");
									
									$altTxt.setAttribute("class", "altTxt");
									$altDelBtn.setAttribute("class", "altDelBtn");
									$altDelBtn.setAttribute("type", "button");
									$altDelBtn.setAttribute("id", data[index].altNo);
									$altEnrollDate.setAttribute("class", "altEnrollDate");
									
									$altTxt.text = data[index].altTxt;
									$altTxt.href = data[index].altUri;
									$altDelBtn.innerHTML = "X";
									$altEnrollDate.innerHTML = alarmYear + "-" + alarmMonth + "-" + alarmDate;
									
									$generalAlarmDiv.append($altTxt);
									$generalAlarmDiv.append($altDelBtn);
									$generalAlarmDiv.append($altEnrollDate);
									$generalAlarmDiv.append($hr);
								}
							},
							error : function(xhr, status, error) {
								console.log(error);
							}
						});
					}
					
					/* 알람 읽었음 */
					function alarmRead() {
						
						const token = $("meta[name='_csrf']").attr("content");
						const header = $("meta[name='_csrf_header']").attr("content");
						
						$(document).ajaxSend(function(e, xhr, options) {
						    xhr.setRequestHeader(header, token);
						});
					
						$.ajax({
							url : "${pageContext.servletContext.contextPath}/alarm/general/read",
							method : "POST", 
							data : {
								no : "${ sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no }" 
							},
							success : function(data, status, xhr) {
								console.log(data);
							},
							error : function(xhr, status, error) {
								console.log(error);
							}
						});
					}
					
					$(document).on("click", "#allAlarmBtn", function() {
					/* $("#allAlarmBtn").click(function(){ */
						var $gaDiv = document.getElementById("generalAlarmDiv");

					    while($gaDiv.firstChild) {
					    	$gaDiv.removeChild($gaDiv.firstChild);
						}
						
						$(".alarmArea").toggleClass("on");
						$(".githubAlarmArea").hide();
						$(".generalAlarmArea").show();
						
						generalAlarm();
						alarmRead();
					});
					
					$("#generalAlarmBtn").click(function() {
						$(".generalAlarmArea").show();
						$(".githubAlarmArea").hide();
					});
					
					$("#githubAlarmBtn").click(function() {
						$(".githubAlarmArea").show();
						$(".generalAlarmArea").hide();
						
						var memNo = ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no};
						console.log(memNo);
						var $githubArea = document.getElementById("githubArea");
						let $githubUrlArea = document.getElementById("githubUrlArea");
						
						var gitInfo = "${ sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.gitUrl }";
						var gitInfoArray = gitInfo.split("https://github.com/");
						var gitDetailInfo = gitInfoArray[1].split("/");
						console.table(gitInfoArray);
						console.log(gitInfoArray[1]); 
						console.table(gitDetailInfo);
						console.log(gitDetailInfo[0]);
						console.log(gitDetailInfo[1]);
						var gitId = gitDetailInfo[0];
						var gitIdProject = gitDetailInfo[1];
						
						var ghu1 = $(".ghu1");
						var ghu2 = $(".ghu2");
						var ghuInfo1 = "Id : " + gitId;
						var ghuInfo2 = "Project : " + gitIdProject;
						
						ghu1.text("");
						ghu2.text("");
						
						ghu1.text(ghuInfo1);
						ghu2.text(ghuInfo2);
						
						let today = new Date();
						
						let year = today.getFullYear();
						let month = "" + (today.getMonth() + 1);
						let beforMonth = "" + (today.getMonth() + 1 - 3);
						let date = "" + today.getDate();
						let day = today.getDay();
						
						if(month.length == 1) {
							month = "0" + month;
						}
						if(beforMonth.length == 1) {
							beforMonth = "0" + beforMonth;
						}
						if(date.length == 1) {
							date = "0" + date;
						}
						
						//var url = "https://api.github.com/search/issues?q=author:" + gitId + " repo:" + gitId + "/" + gitIdProject;
						var url = "https://api.github.com/search/commits?q=repo:" + gitId + "/" + gitIdProject + " author-date:" + year + "-" + beforMonth + "-" + date +
								".." + year + "-" + month + "-" + date;
						//var url = "https://api.github.com/search/commits?q=repo:" + "freecodecamp" + "/" + "freecodecamp" + " author-date:" + year + "-" + beforMonth + "-" + date +
						//		".." + year + "-" + month + "-" + date;
						//var url = "https://api.github.com/search/commits?q=repo:freecodecamp/freecodecamp author-date:2021-02-01..2021-03-31";
						//var url="https://api.github.com/search/commits?q=repo:Gingmin/semi-project author-date:2021-02-01..2021-03-31";
						console.log(url);
						getCommits(url);
					});
					
					async function getCommits(url) {
						clear();
						const headers = {
								"Accept": "application/vnd.github.cloak-preview"
								
						} 
						const response = await fetch(url, {
							"method" : "GET",
							"headers" : headers
						});
						
						const link = response.headers.get("link");
						const links = link.split(",");
						const urls = links.map(a=> {
							return {
								url: a.split(";")[0].replace(">", "").replace("<", ""),
								title: a.split(";")[1]
							}
						});
						const result = await response.json();
						
						let count = 0;
						
						result.items.forEach(i=>{
							count++;
							/* console.log(i); */
							const img = document.createElement("img");
							if(null != i.author && null != i.author.avatar_url) {
								img.src = i.author.avatar_url;
							} else {
								img.setAttribute("src", "${pageContext.servletContext.contextPath}/resources/img/randompeople.png")
							}
							img.style.width = "32px";
							img.style.height = "32px";
							const anchor = document.createElement("a");
							if(null != i.author && null != i.html_url) {
								anchor.href = i.html_url;
							}
							anchor.textContent = i.commit.message.substr(0, 70) + "...";
							githubArea.appendChild(img); 
							githubArea.appendChild(anchor);
							githubArea.appendChild(document.createElement("br"));
							githubArea.appendChild(document.createElement("hr"));
						});
						
						console.log("count : " + count);
						
						urls.forEach(u => {
							
							const btn = document.createElement("button");
							btn.setAttribute('class', "gitPagingBtn");
							let buttonStr = u.title.substring(6);
							btn.textContent = buttonStr.substring(0, buttonStr.lastIndexOf("\""));
							btn.addEventListener("click", e=> getCommits(u.url));
							githubArea.appendChild(btn);
							
						});
					}
					
					function clear() {
						while(githubArea.firstChild)
							githubArea.removeChild(githubArea.firstChild);
					}
				});
			</script>
					   <%-- async function getIssues() {
						
						var gitInfo = "${ sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.gitUrl }";
						var gitInfoArray = gitInfo.split("https://github.com/");
						var gitDetailInfo = gitInfoArray[1].split("/");
						console.table(gitInfoArray);
						console.log(gitInfoArray[1]); 
						console.table(gitDetailInfo);
						console.log(gitDetailInfo[0]);
						console.log(gitDetailInfo[1]);
						var gitId = gitDetailInfo[0];
						var gitIdProject = gitDetailInfo[1];
						
						clear();
						const headers = {
								"Accept": "application/vnd.github.cloak-preview"
								
						} 
						const url = "https://api.github.com/search/issues?q=author:" + gitId + " repo:" + gitId + "/" + gitIdProject;
						const response = await fetch(url);
						
						const link = response.headers.get("link");
						const links = link.split(",");
						const urls = links.map(a=> {
							return {
								url: a.split(";")[0].replace(">", "").replace("<", ""),
								title: a.split(";")[1]
							}
						});
						
						const result = await response.json();
						
						result.items.forEach(i=>{
							const img = document.createElement("img");
							img.src = i.author.avatar_url;
							img.style.width = "32px";
							img.style.height = "32px";
							const anchor = document.createElement("a");
							anchor.href = i.html_url;
							anchor.textContent = i.title.substr(0, 120) + "...";
							githubArea.appendChild(anchor);
							githubArea.appendChild(document.createElement("br"));
						});
						
						urls.forEach(u => {
							
							const btn = document.createElement("button");
							btn.textContent = u.title;
							btn.addEventListener("click", e=> getIssues(u.url));
							githubArea.appendChild(btn);
							
						});
					}  --%>
					
	</c:when>
	
</c:choose>

</body>
</html>