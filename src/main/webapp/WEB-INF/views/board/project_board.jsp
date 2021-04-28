<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<!-- 파비콘 -->
	<link rel="shortcut icon" href="${ pageContext.servletContext.contextPath }/resources/img/logo1.png" type="image/x-icon">
	<meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}">
	
	<meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/index.css">
   <link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/project_board.css">
   <link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/modal.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


   <!-- 폰트어썸 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">


   <title>Short Cut</title>
</head>
<body>
   <jsp:include page="../common/header.jsp"></jsp:include>
   <div class="project_content">
      <div class="row">
         <div class="project_text_area">
            <div class="project_text1">
               Description
            </div>
            <div class="project_line"></div>
            <div class="project_text2">
               Why do we use it?
            </div>
            <div class="project_text3">
           		It is a long established fact
				that a reader will be distracted by the readable content of a page
				when looking at its layout. The point of using Lorem Ipsum is that
				it has a more-or-less normal distribution of letters, as opposed to
				using 'Content here, content here', making it look like readable
				English. Many desktop publishing packages and web page editors now
				use Lorem Ipsum as their default model text, and a search for
				'lorem ipsum' will uncover many web sites still in their infancy.
				Various versions have evolved over the years, sometimes by
				accident, sometimes on purpose (injected humour and the like).
			</div>               
         </div>   
         <div class="project_board_area">
            <div class="project_text1">
               Project   
            </div>
            <div class="project_line2"></div>

            <div class="row" >
               <div class="board_list">
                  <a class="board_detail" href="#" data-toggle="modal" data-target="#project_produce">
                     <i class="fas fa-plus"></i>
                  </a>
                  <div class="board_text">
                     new Project   
                  </div>               
               </div>
              <%--  <div class="board_list">
                  <a class="board_detail type" href="${pageContext.servletContext.contextPath }/board/backlog">
                     <img src="${pageContext.servletContext.contextPath}/resources/img/board_icon.png" style="height:70px; width:70px;">
                  </a> --%>
                  <div id="pjSelectOne">
                  <!-- 프로젝트 수정을 하기 위함 -->
                  <!-- <div class="board_text"  data-toggle="modal" data-target="#project_modify">
                     The joeun   
                  </div> --> 
                  </div>
                  <c:forEach var="project" items="${ requestScope.projectList }">
					    <div class="board_list">
							<!-- <div class="board_text"  data-toggle="modal" data-target="#project_modify"> -->
							<form action="${ pageContext.servletContext.contextPath }/board/backlog" method="get">
								<input type="text" value="${project.pjtNo }" id="pjtNo" name="pjtNo" style="display: none;">
								<input type="text" value="${project.projectName }" id="projectName" name="projectName" style="display: none;">
								<button class="board_detail type" style="background-color: ${project.projectColor};" id="moveProject" type="submit">
									<img src="${ pageContext.servletContext.contextPath }/resources/img/board_icon.png" style="height:70px; width:70px;">
								</button>
							</form>
							<div style="display: none;">
								<c:out value="${ project.pjtNo }"/>
							</div>
							<div class="board_text" >
								<c:out value="${ project.projectName }"/>	
							</div>	
						</div>
					</c:forEach>				
					<!-- </div> -->
              </div>
            </div>
         </div>         
      </div>




	<div class="modal fade" id="project_produce">
	   <div class="modal-dialog">
	      <div class="modal-content">
	
	         <!-- Modal Header -->
	         <div class="modal-header">
	            <input class="input_detail" type="text" id="projectNameNK" placeholder="* Add Project Title">            
	         </div>
	         
			<div class="modal-header">
				<div>* 시작 날짜</div>
	            <input class="input_detail nk" type="date" id="projectStartDate">         
	         </div>
	         
	         <div class="modal-header">
	            <p>* 종료 날짜</p>
	         <input class="input_detail  nk" type="date" id="projectEndDate">  
	         </div>
	         
	         <div class="modal-header">
	            <p>* 프로젝트 색상</p>
	         <input class="input_detail  nk1" type="color" id="projectColor">  
	         </div> 
	         
	                
	         <!-- Modal body -->
	         
	         <div class="modal-body">
	            <div class="row">
	               <i class="fas fa-search"></i>
	               <input class="input_detail1" type="text" id="email" placeholder="Add Member">
	               <select class="select_detail nk" id="selectroll">
	                  <option>Admin</option>
	                  <option>Member</option>
	                  <option>Client</option>
	               </select>
	               <input class="input_detail2 nk" type="button" id="addpersonButton" value="+">      
	               <input class="input_detail2 nk" type="button" id="removepersonButton" value="-">      
	            </div>
				<table class="select_member" id="projectMember" border="1" style="width:100%; height:30px; text-align: center">
					<thead>
					<tr>
						<th style="width:60px; align-content: center;" >인원 수</th>
						<th>이메일</th>
						<th style="width:100px;">권한</th>
						<th style="width:100px; display:none">회원번호</th>
					</tr>
					<tr>
						<th>1</th>
						<th  class="Email">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</th>
						<th class="roll">Admin</th>
						<th class="memberNo" style="display:none">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no}</th>
					</tr>
					</thead>
					<tbody  id="dynamicTbody">
						</tbody>
				</table>
	         </div>
	         <div class="modal_btn_area">
	            <button class="btn_detail" id="createProject">Create Project</button>
	         </div>            
	      </div>
	   </div>
	</div>
<!-- <script>
if(document.getElementById("pjSelectOne")) {
	
	  const $pjSelectOne = document.getElementById("pjSelectOne");
	  console.log($pjSelectOne);
	  const $pjList = $pjSelectOne.childNodes;
	  
			console.log("오호?" + $pjList[5]);
	  for(let i = 0; i < $pjList.length; i++) {
		  
		  $pjList[i].onclick = function() {
			  const no = this.childNodes[3].innerText;
			  location.href="${ pageContext.servletContext.contextPath}/mywork/client/projectInfo/" + no;
		  }
	  }
	  
  }
</script> -->
	<script>
		/* 시큐리티 권한  */
		const token = $("meta[name='_csrf']").attr("content");
		const header = $("meta[name='_csrf_header']").attr("content");
		
		$(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		});
		
		 const $pjSelectOne = document.getElementById("pjSelectOne");
	  	 
		 /* null 체크 */
			function vali(value){
			    if (value === null) return true; 
			    if (typeof value === 'string' && value === '') return true;
			    if (typeof value === 'undefined') return true;
			    return false;
			}
		 
		/* 멤버 수 count */
		var idcount = 1;
		$("#addpersonButton").click(function(){
		var email = $("#email").val();			//입력한 이메일
			if(!vali($("#email").val())){
				/* 아이디 중복 체크 */
				$.ajax({
					url:"${pageContext.servletContext.contextPath}/board/projectidDupCheck",
					type:"post",
					data:{email :email},
					success:function(data){
						console.log(data);
						/* 아이디가 있을 때 */
						if(data !== 0){
							var addMember = $("#projectMember tr:last");
							var insertTr="";
							 insertTr += '<tr id="addpersionList_' + (idcount++) +'">';
							 insertTr += '<td class="num">'+  (idcount) + '</td>';
							 insertTr += '<td class="Email">'+	document.getElementById("email").value + '</td>';
							 insertTr += '<td class="roll">'+	document.getElementById("selectroll").value + '</td>';
							 insertTr += '<td class="memberNo" style="display:none">' + data + '</td>';
							 insertTr += '</tr>';
							 $("#dynamicTbody").append(insertTr);
							 $("#email").val('');	//입력 후 input  비워주기
						}else{
						alert("가입된 이메일주소가 아닙니다. 확인 해주세요~");
						 $("#email").val('');
						}
						
					}, error:function(data){
						
					}
				});
		}else{
			alert("이메일을 입력해주세요");
		}
			});
		/* 프로젝트 멤버 삭제 버튼 클릭 시 */	
		$("#removepersonButton").click(function(){
			$("#projectMember tr:last").remove();
			idcount--;
		});
		
		
		projectStartDate
		/* 프로젝트 생성 버튼 클릭 시*/
		$("#createProject").click(function(){ 
			if(!vali($("#projectNameNK").val()) && !vali($("#projectStartDate").val()) && !vali($("#projectEndDate").val()) && !vali($("#projectColor").val())){
				
							
			function makeTag(name, value){
				var hiddenTag = document.createElement('input');
				hiddenTag.setAttribute("type", "hidden")
				hiddenTag.setAttribute("name", name)
				hiddenTag.setAttribute("value", value)
		
				return hiddenTag
			}
			
		   var loginNo = ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no};
		   console.log(loginNo);
		   
		   /* 프로젝트 정보 */
		   const projectMemberList = document.getElementById('dynamicTbody').innerHTML;
		   var projectName = document.getElementById("projectNameNK").value;
		   var projectStartDate = document.getElementById("projectStartDate").value;
		   var projectEndDate = document.getElementById("projectEndDate").value;
		   var projectColor = document.getElementById("projectColor").value;
		   console.log("projectName : " + projectName);
		   console.log("projectStartDate : " + projectStartDate);
		   console.log("projectEndDate : " + projectEndDate);
		   console.log("projectColor : " + projectColor);
		 
		   	
		   var nk1 = $('form[name=projectMemberList]').serializeArray();
		   var projectMaker = $("#projectMember").find(".memberNo").eq(0).text();
		    for(let i = 0; i < idcount; i++){
			   memberId = $("#projectMember").find(".Email").eq(i).text();
			   console.log("Email : " + memberId);
			   projectRole = $("#projectMember").find(".roll").eq(i).text();
			   memberNo = $("#projectMember").find(".memberNo").eq(i).text();
			   if(projectRole === 'Admin'){
				   projectRole = 1;
			   }else if(projectRole === 'Member'){
				   projectRole = 2;
			   }else if(projectRole === 'Client'){
				   projectRole = 3;
			   }
			   console.log("roll : " + projectRole);
			   
			   nk1.push({ name : "memberNo", value : memberNo}, 
						{ name : "projectRole",value : projectRole}
						);
				
		   } 
		   
		   /* 프로젝트 멤버, 정보 전송 */
		   $.ajax({
			   url :"${pageContext.servletContext.contextPath}/board/project_regist",
			   type : "post",
			   data :  {
				   nk1 : nk1,
				   memberNo : projectMaker,
				   projectName : projectName,
				   projectStartDate : projectStartDate,
				   projectEndDate : projectEndDate,
				   projectColor : projectColor
				    },
			
			   success : function(data, textStatus, xhr) {
				   alert("프로젝트 생성이 완료되었습니다.");
				   document.location.reload();
					location.href = "${pageContext.servletContext.contextPath}/board/project_board/" + loginNo;
			   },
				error : function(xhr, status, error) {
					console.log(error);
					alert("프로젝트 생성이 취소되었습니다.");
					location.href = "${pageContext.servletContext.contextPath}/board/project_board";
				}
		   });
		   
			}else{
				alert("필수 항목을 모두 채워주세요!");
			}
		})
	</script>

</body>
</html>