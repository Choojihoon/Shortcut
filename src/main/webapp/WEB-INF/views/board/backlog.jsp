<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/backlog.css">
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
	<div class="backlog_area">
		<div class="backlog_header_area">
			<span class="backlog_header">
				Backlog	& Sprint		
			</span>
			<!-- -----------------------미팅로그 이동, 프로젝트 수정 버튼-------------------------- -->
			<form action="${ pageContext.servletContext.contextPath }/meeting/meetinglog/" method="get">
				<input type="text" value="${pjtNo }" id="pjtNo" name="pjtNo" style="display: none;">
				<input type="text" value="${projectName }" id="projectName" name="projectName" style="display: none;">
				<input type="text" value="${requestScope.project.pjtNo }" id="pjtNo" name="pjtNo" style="display: none;">
				<input type="text" value="${requestScope.project.projectName }" id="projectName" name="projectName" style="display: none;">
				<input type="text" value="${backlog.blgNo }" id="blgNo1" name="blgNo1" style="display: none;">
				<button type="submit" class="meeting_btn">Meeting Log</button>
			</form>
			<div class="meeting_btn"  data-toggle="modal" data-target="#project_produce_Detail">Edit Project</div>
			<%-- <a class="meeting_btn" href="${ pageContext.servletContext.contextPath }/meeting/meetinglog">Meeting Log</a>  --%>
		</div>
		
		<!-------------------------------------------- 스프린트 영역 -------------------------------------------------->

		<div class="sprint_box_area">			
			<div class="sprint_text_btn">
				<span class="sprint_text">Sprint</span>		
			</div>				
			<div class="backlog_line"></div>		
			<div class="sprint_box on"></div>
			<div class="table_area">
				<div class="table_item nk">
					<table style="width: 100%;"  id="sprintViewList">
						<thead>
							<tr>
								<th class="th_detail type1">번호</th>
								<th class="th_detail type1">스프린트번호</th>
								<th class="th_detail type1">스프린트 이름</th>
								<th class="th_detail type1">스프린트 시작날짜</th>
								<th class="th_detail type1">스프린트 종료날짜</th>
								<th class="th_detail type1">스프린트 목표</th>
								<th class="th_detail type1">스프린트 시작/수정</th>
							</tr>
						</thead>
						<tbody id="sprintBody">
							<c:choose>
								<c:when test="${fn:length(requestScope.sprintList) > 0 }">
											
								</c:when>
								<c:otherwise>
										<tr>
											<td colspan="8">조회된 결과가 없습니다.</td>
										</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
					<div id="sprintPagingArea" class="paging_area type" align="center"></div>
						
				</div>
			</div>
		</div>
			
		<!-- 	<!-- =====================스프린트 페이징 처리 =======================-->
	<script>
	/* 페이지 로드 될 때 시작 */
	$('document2').ready(function() {
		
		/* 프로젝트 번호 */
		var pjtNo = ${requestScope.pjtNo};
		/* 게시판 Body */
		var $sprintBody = $("#sprintBody");
		/* 페이징 버튼 */
		var $sprintPagingArea = $("#sprintPagingArea");
		/* 페이징 함수 호출 */
		sprintPagingAjax(pjtNo, 1, $sprintBody, $sprintPagingArea);
		
	});
	
	/* 페이징 함수 */
	function sprintPagingAjax(pjtNo, currentSprintPage, $sprintBody, $sprintPagingArea) {
		
		/* Body 영역 지우기 */
		$sprintBody.empty();
		/* ajax 호출 */
		$.ajax({
			url : "${pageContext.servletContext.contextPath}/board/sprint/sprintPaging",
			method : "post",
			data : {
				pjtNo : pjtNo,
				currentSprintPage : currentSprintPage
			},
			success : function(data, status, xhr) {
				console.log(data);
				if(0 == data.length) {

				} else {
					/* DTO에 담긴 시작페이지, 끝페이지, 마지막페이지 꺼내기 */
					var startSprintPage = data[0].startPage;
					var endSprintPage = data[0].endPage;
					var maxSprintPage = data[0].maxPage;
					for(let index in data) {
						
						/* 버튼 생성 */
					 	var sprintBtnHtml = '<button class="btn_detail nk"  data-toggle="modal" data-target="#myModalSprintEdit" id="EditBackLog" onclick="btnSprintDetail(this)" value=' +data[index].sprNo +'>Edit Sprint</button>'   
			                              + '<a href="${pageContext.servletContext.contextPath }/board/kanbanboard/?pjtNo= + ${ requestScope.pjtNo } + &sprNo='+ data[index].sprNo +'&projectName= + ${requestScope.projectName} + ">'
			                              + '<button class="btn_detail nk" >Start sprint </button>';
						
						/* tr태그에 만들어 값 담기 */
						$tr = $("<tr>");
						$rnum = $("<td>").text(data[index].rnum);
						$sprNo = $("<td>").text("SPRINT-" + data[index].sprNo);
						$sprName = $("<td>").text(data[index].sprName);
						$sprStardDate = $("<td>").text(data[index].sprStardDate);
						$sprEndDate = $("<td>").text(data[index].sprEndDate);
						$sprGoal = $("<td>").text(data[index].sprGoal);
						$sprintBtnHtml = $("<td>").html(sprintBtnHtml);
						
						/* $tr.append($backlogCountNumber); */
						$tr.append($rnum);
						$tr.append($sprNo);
						$tr.append($sprName);
						$tr.append($sprStardDate);
						$tr.append($sprEndDate);
						$tr.append($sprGoal);
						$tr.append($sprintBtnHtml);
						
						/* 테이블에 추가 */
						$sprintBody.append($tr);
					}
					
					/* 페이징 버튼 함수 호출 - 페이지 정보와 페이징영역 정보 인자로 전달 */
					navisprint(startSprintPage, endSprintPage, maxSprintPage, $sprintPagingArea, currentSprintPage);
				}
				
				console.log(data);
				console.log(status);
				console.log(xhr);
			},
			error : function(xhr, status, error) {
				console.log(xhr);
				console.log(status);
				console.log(error);
			}
		});
	}
	
	/* 페이징 버튼 함수 */
	function navisprint(startSprintPage, endSprintPage, maxSprintPage, $sprintPagingArea, currentSprintPage) {
		
		/* 페이징영역 지우기 */
		$sprintPagingArea.empty();
		
		/* 시작페이지가 1페이지일 때 disabled된 <<, < 버튼 추가
		      아니라면, 활성화된 버튼 추가하고 startBacklogPage(), prevBacklogPage 함추 호출
		*/
		if(startPage <= 1) {
			$sprintPagingArea.append('<button class="pageBtn" disabled><<</button>')
			$sprintPagingArea.append('<button class="pageBtn" disabled><</button>');
		} else {
			$sprintPagingArea.append('<button class="pageBtn" onclick="startSprintPage();"><<</button>');
			$sprintPagingArea.append('<button class="pageBtn" onclick="prevSprintPage(' + startSprintPage + ');"><</button>');
		}
		
		/* 현재 페이지와 같지 않는 버튼은 moveBacklogPage()함수 호출 가능 */
		for(let i = startSprintPage; i <= endSprintPage; i++) {
			if(i == currentSprintPage) {
				$sprintPagingArea.append('<button class="pageBtn on" disabled>' + i + '</button>');
			} else {
				$sprintPagingArea.append('<button class="pageBtn" onclick="moveSprintPage(' + i + ')">' + i + '</button>');
			}
		}
		
		if(endSprintPage == maxSprintPage) {
			$sprintPagingArea.append('<button class="pageBtn" disabled>></button>');
			$sprintPagingArea.append('<button class="pageBtn" disabled>>></button>');
		} else {
			$sprintPagingArea.append('<button class="pageBtn" onclick="nextSprintPage(' + endSprintPage + ')">></button>');
			$sprintPagingArea.append('<button class="pageBtn" onclick="maxSprintPage(' + maxSprintPage + ')">>></button>');
		}
	}
	
	/* 페이징 버튼 함수들 */
	function startPage1() {
		
		var pjtNo = ${requestScope.pjtNo};
		var $sprintBody = $("#sprintBody");
		var $sprintPagingArea = $("#sprintPagingArea");
		
		/* 다시 pagingAjax 함수 호출해서 정보 뿌려주기 */
		new sprintPagingAjax(pjtNo, 1, $sprintBody, $sprintPagingArea);
	}
	
	function prevSprintPage(currentSprintPage) {
		
		var pjtNo = ${requestScope.pjtNo};
		var $sprintBody = $("#sprintBody");
		var $sprintPagingArea = $("#sprintPagingArea");
		
		new sprintPagingAjax(pjtNo, currentSprintPage - 1, $sprintBody, $sprintPagingArea);
	}
	
	function nextSprintPage(currentSprintPage) {
		
		var pjtNo = ${requestScope.pjtNo};
		var $sprintBody = $("#sprintBody");
		var $sprintPagingArea = $("#sprintPagingArea");
		
		new sprintPagingAjax(pjtNo, currentSprintPage + 1, $sprintBody, $sprintPagingArea);
	}
	
	function maxSprintPage(maxSprintPage) {
		
		var pjtNo = ${requestScope.pjtNo};
		var $sprintBody = $("#sprintBody");
		var $sprintPagingArea = $("#sprintPagingArea");
		
		new sprintPagingAjax(pjtNo, maxSprintPage, $sprintBody, $sprintPagingArea);
	}
	
	function moveSprintPage(chooseSprintPage) {
		
		var pjtNo = ${requestScope.pjtNo};
		var $sprintBody = $("#sprintBody");
		var $sprintPagingArea = $("#sprintPagingArea");
		
		new sprintPagingAjax(pjtNo, chooseSprintPage, $sprintBody, $sprintPagingArea);
	}
	
	</script>

	
	<!-- 스프린트 수정 -->
	<div class="modal fade" id="myModalSprintEdit">
		<div class="modal-dialog type2">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div class="header_detail type1">Edit Sprint</div>					
				</div>
				<p class="m_text"></p>
		 		<div class="row detailpage">
		         	<div class="left_area">
			         	<div class="modal-body">
							<div class="sprint_item">
								<div class="item_name nk">
									기존 스프린트 이름
								</div>
								<input class="input_detail nk" type="text" id="sprintRegistNameDetail" readonly>
							</div>
							<div class="sprint_item">
								<div class="item_name nk">
									기존 시작 날짜
								</div>
								<input class="input_detail nk" type="text" id="sprintRegistStartDateDetail"readonly>
							</div>
							<div class="sprint_item">
								<div class="item_name nk">
									기존 종료 날짜
								</div>
								<input class="input_detail nk" type="text" id="sprintRegistEndDateDetail" readonly>
							</div>
							<div class="sprint_item">
								<div class="item_name nk">
									스프린트 목표
								</div>
								<input class="input_detail nk" id="sprintRegistGoalDetail" readonly>
							</div>
							<div class="sprint_item">
								<div class="item_name nk" style="display: none">
									스프린트의 백로그 번호
								</div>
								<textarea class="textarea_detail nk" id="BacklogNoDetail" style="display: none"></textarea>
							</div>
			         	</div>
		       		</div>
         
	         
					<!-- Modal body -->
					<div class="modal-body">
					
						<div class="sprint_item">
							<div class="item_name">
								* 변경할 스프린트 이름
							</div>
							<input class="input_detail" type="text" id="sprintupdateNameDetail">
						</div>	
						<div class="sprint_item">
							<div class="item_name nk">
								* 변경 할 시작 날짜
							</div>
							<input class="input_detail" type="date" id="sprintupdateStartDateDetail">
						</div>
						<div class="sprint_item">
							<div class="item_name nk">
								* 변경 할 종료 날짜
							</div>
							<input class="input_detail" type="date" id="sprintupdateEndDateDetail">
						</div>
						<div class="sprint_item">
							<div class="item_name nk">
								* 스프린트 목표
							</div>
							<textarea class="textarea_detail" id="sprintupdateGoalDetail"></textarea>
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal_btn_area">
						<button type="button" class="btn_detail" id="EditSprint">수정</button>
						<button type="button" class="btn_detail" id="RemoveSprint">삭제</button>
						<button type="button" class="btn_detail" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>	
		
			
		
		
	<script>
	/* 스프린트 수정하기 위해 수정 버튼 누루면 조회된 결과 출력 */
		function btnSprintDetail(beta){
			var sprNo = $(beta).val();
			console.log(sprNo);
			console.log("스프린트 번호 :"  + sprNo);
			/* 스프린트 조회  */
					 $.ajax({
							url : "sprintDetail", 
							type: "POST",
							data: { "sprNo" : sprNo  },
							success : function (data,status,xhr){
								console.log(data.blgName);
								console.table(data);
								console.log(data.blgNo);
								$("#sprintRegistNameDetail").attr('placeholder',"");
								$("#sprintRegistStartDateDetail").attr('placeholder',"");
								$("#sprintRegistEndDateDetail").attr('placeholder',"");
								$("#sprintRegistGoalDetail").attr('placeholder',"");
								$("#BacklogNoDetail").attr('placeholder',"");
								
								$("#backlogNo11").attr('value',data.blgNo);
								$("#sprintRegistNoDetail").attr('placeholder',data.sprNo);
								$("#sprintRegistNameDetail").attr('placeholder',data.sprName);
								$("#sprintRegistStartDateDetail").attr('placeholder',data.sprStardDate);
								$("#sprintRegistEndDateDetail").attr('placeholder',data.sprEndDate);
								$("#sprintRegistGoalDetail").attr('placeholder',data.sprGoal);
								$("#BacklogNoDetail").attr('placeholder',data.sprBlgNo);
							},
							error : function (xhr, status, data){
								console.log(data);
							}
								
							})
			/*스프린트 삭제 */
				$("#RemoveSprint").click(function(){ 
				 if(confirm("정말 삭제하시겠습니까 ?") == true){
						var baglogNotosprintremove = document.getElementById("BacklogNoDetail").value;
						console.log("백로그 번호 : " + baglogNotosprintremove);
						 console.log("djdjdjdj  : " + sprNo);
							 $.ajax({
									url : "${pageContext.servletContext.contextPath}/board/sprint/sprint_remove",
									type : "post",
									data : {sprNo : sprNo},
									success : function(data, textStatus, xhr){
										alert("스프린트 삭제가 완료되었습니다");
										document.location.reload();
									},
									error : function(xhr, status, error){
										console.log(error);
										alert("스프린트 삭제가 취소되었습니다");
									}
							 })
					}else{
						return;
						}
				});
			
			/* 스프린트 수정 */
				$("#EditSprint").click(function(){ 
					 var sprName = document.getElementById("sprintupdateNameDetail").value;
					 var sprStardDate = document.getElementById("sprintupdateStartDateDetail").value;
					 var sprEndDate = document.getElementById("sprintupdateEndDateDetail").value;
					 var sprGoal = document.getElementById("sprintupdateGoalDetail").value;
					
					 if(!vali(sprName) && !vali(sprStardDate) && !vali(sprEndDate) && !vali(sprGoal)){
					 $.ajax({
								url : "${pageContext.servletContext.contextPath}/board/sprint/sprint_Edit",
								type : "post",
								data : {
									sprNo : sprNo,
									sprName : sprName,
									sprStardDate : sprStardDate,
									sprEndDate : sprEndDate,
									sprGoal : sprGoal
								},
								success : function(data, textStatus, xhr){
									alert("스프린트 수정이 완료되었습니다.");
									document.location.reload();
								},
								error : function(xhr, status, error){
									console.log(error);
									alert("스프린트 수정이 취소되었습니다.");
								}
					 })
					 }else{
						 alert("빠진 부분을 채워주세요~");
					 }
				})
			} 
	</script>        
		
		<!-- -------------------------------------백로그 영역------------------------------------------ -->
		<div class="backlog_create_area">
			<div class="create_sprint_btn">backlog						
			</div>
			<div class="backlog_line"></div>
			<div class="backlog_table_area">				
				<div class="table_area">
					<div class="table_item">
						<table style="width: 100%;"  id="backlogViewList">
							<thead>
								<tr>
									<th class="th_detail type">No</th>
									<th class="th_detail type">백로그 번호</th>
									<th class="th_detail type">백로그 이름</th>
									<th class="th_detail type">우선순위</th>
									<th class="th_detail type">데모방식</th>
									<th class="th_detail type">비고</th>
									<th class="th_detail type">백로그 수정/스프린트 생성</th>
									<!-- <th class="">스프린트 생성</th> -->
								</tr>
							</thead>
							<tbody id="backlogBody">
								<c:choose>
									<c:when test="${fn:length(requestScope.backlogList) > 0 }">
										
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="8">조회된 결과가 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<div id="backlogPagingArea" align="center">
						</div>
			</div>
		</div>
	</div>
			
			
			<!-- =====================백로그 페이징 처리 =======================-->
			<script>
			/* 페이지 로드 될 때 시작 */
			$('document1').ready(function() {
				
				/* 프로젝트 번호 */
				var pjtNo = ${requestScope.pjtNo};
				/* 게시판 Body */
				var $backlogBody = $("#backlogBody");
				/* 페이징 버튼 */
				var $backlogPagingArea = $("#backlogPagingArea");
				/* 페이징 함수 호출 */
				boardPagingAjax(pjtNo, 1, $backlogBody, $backlogPagingArea);
				
				
			});
			
			/* 페이징 함수 */
			function boardPagingAjax(pjtNo, currentBacklogPage, $backlogBody, $backlogPagingArea) {
				
				/* Body 영역 지우기 */
				$backlogBody.empty();
				/* ajax 호출 */
				$.ajax({
					url : "${pageContext.servletContext.contextPath}/board/backlog/backlogPaging",
					method : "post",
					data : {
						pjtNo : pjtNo,
						currentBacklogPage : currentBacklogPage
					},
					success : function(data, status, xhr) {
						console.log(data);
						if(0 == data.length) {

						} else {
							/* DTO에 담긴 시작페이지, 끝페이지, 마지막페이지 꺼내기 */
							var startBacklogPage = data[0].startPage;
							var endBacklogPage = data[0].endPage;
							var maxBacklogPage = data[0].maxPage;
							for(let index in data) {
								
								
								/* 버튼 생성 */
								var backlogBtnHtml = '<button class="btn_detail on"  data-toggle="modal" data-target="#myModalEdit"  id="EditBackLog" onclick="EditBacklogBtn(this)" value='+data[index].blgNo+'>Edit Backlog</button>'
								                   + '<button class="btn_detail "  data-toggle="modal" id="makeSprint" onclick="MakeSprintByn(this)" value=' + data[index].blgNo + ' data-target="#myModal3">Make Sprint</button>';
								
								/* tr태그에 만들어 값 담기 */
								$tr = $("<tr>");
								$rnum = $("<td>").text(data[index].rnum);
								$blgNo = $("<td>").text("BACKLOG-" + data[index].blgNo);
								$nameTd = $("<td>").text(data[index].blgName);
								$priTd = $("<td>").text(data[index].blgPri);
								$demoMemoTd = $("<td>").text(data[index].blgDemoMemo);
								$refMemoTd = $("<td>").text(data[index].blgRefMemo);
								$backlogBtnHtml = $("<td>").html(backlogBtnHtml);
								
								/* $tr.append($backlogCountNumber); */
								$tr.append($rnum);
								$tr.append($blgNo);
								$tr.append($nameTd);
								$tr.append($priTd);
								$tr.append($demoMemoTd);
								$tr.append($refMemoTd);
								$tr.append($backlogBtnHtml);
								
								/* 테이블에 추가 */
								$backlogBody.append($tr);
							}
							
							/* 페이징 버튼 함수 호출 - 페이지 정보와 페이징영역 정보 인자로 전달 */
							navibacklog(startBacklogPage, endBacklogPage, maxBacklogPage, $backlogPagingArea, currentBacklogPage);
						}
						
						console.log(data);
						console.log(status);
						console.log(xhr);
					},
					error : function(xhr, status, error) {
						console.log(xhr);
						console.log(status);
						console.log(error);
					}
				});
			}
			
			/* 페이징 버튼 함수 */
			function navibacklog(startBacklogPage, endBacklogPage, maxBacklogPage, $backlogPagingArea, currentBacklogPage) {
				
				/* 페이징영역 지우기 */
				$backlogPagingArea.empty();
				
				/* 시작페이지가 1페이지일 때 disabled된 <<, < 버튼 추가
				      아니라면, 활성화된 버튼 추가하고 startBacklogPage(), prevBacklogPage 함추 호출
				*/
				if(startPage <= 1) {
					$backlogPagingArea.append('<button class="pageBtn" disabled><<</button>')
					$backlogPagingArea.append('<button class="pageBtn" disabled><</button>');
				} else {
					$backlogPagingArea.append('<button class="pageBtn" onclick="startBacklogPage();"><<</button>');
					$backlogPagingArea.append('<button class="pageBtn" onclick="prevBacklogPage(' + startBacklogPage + ');"><</button>');
				}
				
				/* 현재 페이지와 같지 않는 버튼은 moveBacklogPage()함수 호출 가능 */
				for(let i = startBacklogPage; i <= endBacklogPage; i++) {
					if(i == currentBacklogPage) {
						$backlogPagingArea.append('<button class="pageBtn on" disabled>' + i + '</button>');
					} else {
						$backlogPagingArea.append('<button class="pageBtn" onclick="moveBacklogPage(' + i + ')">' + i + '</button>');
					}
				}
				
				if(endBacklogPage == maxBacklogPage) {
					$backlogPagingArea.append('<button class="pageBtn" disabled>></button>');
					$backlogPagingArea.append('<button class="pageBtn" disabled>>></button>');
				} else {
					$backlogPagingArea.append('<button class="pageBtn" onclick="nextBacklogPage(' + endBacklogPage + ')">></button>');
					$backlogPagingArea.append('<button class="pageBtn" onclick="maxBacklogPage(' + maxBacklogPage + ')">>></button>');
				}
			}
			
			/* 페이징 버튼 함수들 */
			function startPage1() {
				
				var pjtNo = ${requestScope.pjtNo};
				var $backlogBody = $("#backlogBody");
				var $backlogPagingArea = $("#backlogPagingArea");
				
				/* 다시 pagingAjax 함수 호출해서 정보 뿌려주기 */
				new boardPagingAjax(pjtNo, 1, $backlogBody, $backlogPagingArea);
			}
			
			function prevBacklogPage(currentBacklogPage) {
				
				var pjtNo = ${requestScope.pjtNo};
				var $backlogBody = $("#backlogBody");
				var $backlogPagingArea = $("#backlogPagingArea");
				
				new boardPagingAjax(pjtNo, currentBacklogPage - 1, $backlogBody, $backlogPagingArea);
			}
			
			function nextBacklogPage(currentBacklogPage) {
				
				var pjtNo = ${requestScope.pjtNo};
				var $backlogBody = $("#backlogBody");
				var $backlogPagingArea = $("#backlogPagingArea");
				
				new boardPagingAjax(pjtNo, currentBacklogPage + 1, $backlogBody, $backlogPagingArea);
			}
			
			function maxBacklogPage(maxBacklogPage) {
				
				var pjtNo = ${requestScope.pjtNo};
				var $backlogBody = $("#backlogBody");
				var $backlogPagingArea = $("#backlogPagingArea");
				
				new boardPagingAjax(pjtNo, maxBacklogPage, $backlogBody, $backlogPagingArea);
			}
			
			function moveBacklogPage(chooseBacklogPage) {
				
				var pjtNo = ${requestScope.pjtNo};
				var $backlogBody = $("#backlogBody");
				var $backlogPagingArea = $("#backlogPagingArea");
				
				new boardPagingAjax(pjtNo, chooseBacklogPage, $backlogBody, $backlogPagingArea);
			}
			
			</script>
			
			
			
			
			
	<script>
	/* 백로그 수정하기 위해 수정 버튼 누루면 조회된 결과 출력 */
		function EditBacklogBtn(beta){
			var blgNo = $(beta).val();
			console.log("ㅇ응ㅇ:?" + blgNo);
			var projectNo = ${ requestScope.pjtNo };
			console.log("백로그 번호 :"  + blgNo);
			console.log("플젝" + projectNo);
			
					 $.ajax({
							url : "backlogDetail", 
							type: "POST",
							data: { "blgNo" : blgNo,
								    "projectNo" : projectNo },
							success : function (data,status,xhr){
								console.table(data);
								console.log(data.blgNo);
								$("#importance11").empty();
								$("#backlogName11").attr('value',"");
								$("#DemoDetail11").attr('value',"");
								$("#Reference11").attr('value',"");
								
								$("#backlogNo11").attr('value', data.blgNo);
								//$("#BacklogNoTosprintRegist").attr('value',data.blgNo);				//스프린트 생성할 때 도 부여
								//$("#BacklogNoTosprintRegist").attr('placeholder',data.blgNo);				//스프린트 생성할 때 도 부여
								$("#backlogName11").attr('value',data.blgName);
								$("#DemoDetail11").attr('value',data.blgDemoMemo);
								$("#Reference11").attr('value',data.blgRefMemo);
								$("#importance11").append( Eggpri(data.blgPri));
							},
							error : function (xhr, status, data){
								console.log(data);
							}
					})
				} 
					 	
	function Eggpri(num){
		if(num == 1){
			var html = "<option selected > 1 </option>" + "<option > 2 </option>" + "<option > 3 </option>"  
		} else if(num == 2){
			var html = "<option > 1 </option>" + "<option selected> 2 </option>" + "<option > 3 </option>"
		} else if(num == 3){
			var html = "<option > 1 </option>" + "<option > 2 </option>" + "<option selected> 3 </option>"
		} else {
			 var html = '잘 모르겠습니다.'
		}
		return html;
	}
	</script>  
	
	
	<!-- 스프린트 생성 버튼 클릭시 -->
	<script>
	
		function MakeSprintByn(beta){
			var sprBlgNo = $(beta).val();
			
			$("#MakeSprint").click(function(){ 
				console.log("wefihweif");
				 var sprName = document.getElementById("sprintRegistName").value;
				 var sprStardDate = document.getElementById("sprintRegistStartDate").value;
				 var sprEndDate = document.getElementById("sprintRegistEndDate").value;
				 var sprGoal = document.getElementById("sprintRegistGoal").value;
				 
				 $.ajax({
					url : "${pageContext.servletContext.contextPath}/board/sprint/sprint_regist",
					type : "post",
					data : {
						sprBlgNo : sprBlgNo,
						sprName : sprName,
						sprStardDate : sprStardDate,
						sprEndDate : sprEndDate,
						sprGoal : sprGoal
					},
					success : function(data, textStatus, xhr){
						location.reload();//새로고침
						alert("스프린트 생성이 완료되었습니다");
					},
					error : function(xhr, status, error){
						console.log(error);
						alert("스프린트 생성이 취소되었습니다");
					}
				 })
			})
		}
	</script>
	
	
	
		<div class="create_backlog_btn">
			<label>
				<i class="fas fa-plus"></i>
				<button class="backlog_btn_detail"  data-toggle="modal" data-target="#myModal">Create Backlog</button>	
			</label>					
		</div>
	</div>	




	
	<!-- 스프린트 생성 -->
	<div class="modal fade" id="myModal3">
		<div class="modal-dialog type2">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div class="header_detail type1">Start Sprint</div>					
				</div>
				<p class="m_text"></p>

				<!-- Modal body -->
				<div class="modal-body type3">
					<div class="sprint_item">
						
					
						<div class="item_name">
							Sprint name
						</div>
						<input class="input_detail" type="text" id="sprintRegistName">
					</div>
					<div class="sprint_item">
						<div class="item_name">
							Start Date
						</div>
						<input class="input_detail" type="date" id="sprintRegistStartDate">
					</div>
					<div class="sprint_item">
						<div class="item_name">
							End Date
						</div>
						<input class="input_detail" type="date" id="sprintRegistEndDate">
					</div>
					<div class="sprint_item">
						<div class="item_name">
							Sprint Goal
						</div>
						<textarea class="textarea_detail" id="sprintRegistGoal"></textarea>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn_detail" id="MakeSprint">생성</button>
					<button type="button" class="btn_detail" data-dismiss="modal">취소</button>
				</div>

			</div>
		</div>
	</div>
	
	
	
	
		<div class="sprint_box_area">			
			
			<div class="sprint_text_btn">
				<span class="sprint_text">Sprint Review</span>					
			</div>	
			<div class="backlog_line"></div>
			<div class="sprint_box on"></div>
			
			<div class="table_area">
				<div class="table_item">
					<div class="row">
						<table style="width: 100%;">
							<thead>
								<tr>
									<th class="th_detail type">No</th>
									<th class="th_detail type">이름</th>
									<th class="th_detail type">우선순위</th>
									<th class="th_detail type">종료날짜</th>
									<th class="th_detail type">데모방식</th>
									<th class="th_detail type">비고</th>
									<th class="th_detail type">리뷰 작성 / 수정</th>
								</tr>
							</thead>
							<tbody id="reviewBody">
								<c:choose>
									<c:when test="${fn:length(requestScope.finishSprintList) > 0 }">
										
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="8">조회된 결과가 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
					<div id="pagingArea" align="center"></div>
					
					
					<!-- Ajax 스프린트 리뷰 게시판 페이징 시작 -->
					<script>
						/* 페이지 로드 될 때 시작 */
						$('document').ready(function() {
							
							/* 프로젝트 번호 */
							var pjtNo = ${requestScope.pjtNo};
							/* 게시판 Body */
							var $reviewBody = $("#reviewBody");
							/* 페이징 버튼 */
							var $pagingArea = $("#pagingArea");
							/* 페이징 함수 호출 */
							pagingAjax(pjtNo, 1, $reviewBody, $pagingArea);
							
						});
						
						/* 페이징 함수 */
						function pagingAjax(pjtNo, currentPage, $reviewBody, $pagingArea) {
							
							/* Body 영역 지우기 */
							$reviewBody.empty();
							
							/* ajax 호출 */
							$.ajax({
								url : "${pageContext.servletContext.contextPath}/board/backlog/reviewPaging",
								method : "GET",
								data : {
									pjtNo : pjtNo,
									currentPage : currentPage
								},
								success : function(data, status, xhr) {
									
									if(0 == data.length) {

									} else {
										/* DTO에 담긴 시작페이지, 끝페이지, 마지막페이지 꺼내기 */
										var startPage = data[0].startPage;
										var endPage = data[0].endPage;
										var maxPage = data[0].maxPage;
										
										for(let index in data) {
											
											/* 0보다 크면 null이 아니기에 리뷰 수정 버튼 */
											let retrospectButtonType = ""; 
											if(data[index].reviewRegistYn > 0) {
												retrospectButtonType = "기록";
											} else {
												retrospectButtonType = "리뷰 작성";
											}
											
											/* 버튼 생성 */
											var retrospectBtnHtml = '<input class="retrospectBtn" type="button" value="' + retrospectButtonType + '" onclick="retrospect(this);">';
											
											/* tr태그에 만들어 값 담기 */
											$tr = $("<tr>");
											$noTd = $("<td>").text(data[index].blgNo);
											$nameTd = $("<td>").text(data[index].blgName);
											$priTd = $("<td>").text(data[index].blgPri);
											
											let spDate = new Date(data[index].sprEndDate);
											console.log("spDate : " + spDate);
											let spYear = spDate.getFullYear();
											console.log(spYear);
											let spMonth = (spDate.getMonth() + 1);
											console.log(spMonth);
											let sprrDate = spDate.getDate();
											console.log(sprrDate); 
											
											$sprEndDate = $("<td>").text(spYear + "-" + spMonth + "-" + sprrDate);
											$demoMemoTd = $("<td>").text(data[index].blgDemoMemo);
											$refMemoTd = $("<td>").text(data[index].blgRefMemo);
											$retrospectBtnTd = $("<td>").html(retrospectBtnHtml);
											
											$tr.append($noTd);
											$tr.append($nameTd);
											$tr.append($priTd);
											$tr.append($sprEndDate);
											$tr.append($demoMemoTd);
											$tr.append($refMemoTd);
											$tr.append($retrospectBtnTd);
											
											/* 테이블에 추가 */
											$reviewBody.append($tr);
										}
										
										/* 페이징 버튼 함수 호출 - 페이지 정보와 페이징영역 정보 인자로 전달 */
										navi(startPage, endPage, maxPage, $pagingArea, currentPage);
									}
									
									console.log(data);
									console.log(status);
									console.log(xhr);
								},
								error : function(xhr, status, error) {
									console.log(xhr);
									console.log(status);
									console.log(error);
								}
							});
						}
						
						/* 페이징 버튼 함수 */
						function navi(startPage, endPage, maxPage, $pagingArea, currentPage) {
							
							/* 페이징영역 지우기 */
							$pagingArea.empty();
							
							/* 시작페이지가 1페이지일 때 disabled된 <<, < 버튼 추가
							      아니라면, 활성화된 버튼 추가하고 startPage(), prevPage 함추 호출
							*/
							if(startPage <= 1) {
								$pagingArea.append('<button class="pageBtn" disabled><<</button>')
								$pagingArea.append('<button class="pageBtn" disabled><</button>');
							} else {
								$pagingArea.append('<button class="pageBtn" onclick="startPage();"><<</button>');
								$pagingArea.append('<button class="pageBtn" onclick="prevPage(' + startPage + ');"><</button>');
							}
							
							/* 현재 페이지와 같지 않는 버튼은 movePage()함수 호출 가능 */
							for(let i = startPage; i <= endPage; i++) {
								if(i == currentPage) {
									$pagingArea.append('<button class="pageBtn on" disabled>' + i + '</button>');
								} else {
									$pagingArea.append('<button class="pageBtn" onclick="movePage(' + i + ')">' + i + '</button>');
								}
							}
							
							if(endPage == maxPage) {
								$pagingArea.append('<button class="pageBtn" disabled>></button>');
								$pagingArea.append('<button class="pageBtn" disabled>>></button>');
							} else {
								$pagingArea.append('<button class="pageBtn" onclick="nextPage(' + endPage + ')">></button>');
								$pagingArea.append('<button class="pageBtn" onclick="maxPage(' + maxPage + ')">>></button>');
							}
						}
						
						/* 페이징 버튼 함수들 */
						function startPage() {
							
							var pjtNo = ${requestScope.pjtNo};
							var $reviewBody = $("#reviewBody");
							var $pagingArea = $("#pagingArea");
							
							/* 다시 pagingAjax 함수 호출해서 정보 뿌려주기 */
							new pagingAjax(pjtNo, 1, $reviewBody, $pagingArea);
						}
						
						function prevPage(currentPage) {
							
							var pjtNo = ${requestScope.pjtNo};
							var $reviewBody = $("#reviewBody");
							var $pagingArea = $("#pagingArea");
							
							new pagingAjax(pjtNo, currentPage - 1, $reviewBody, $pagingArea);
						}
						
						function nextPage(currentPage) {
							
							var pjtNo = ${requestScope.pjtNo};
							var $reviewBody = $("#reviewBody");
							var $pagingArea = $("#pagingArea");
							
							new pagingAjax(pjtNo, currentPage + 1, $reviewBody, $pagingArea);
						}
						
						function maxPage(maxPage) {
							
							var pjtNo = ${requestScope.pjtNo};
							var $reviewBody = $("#reviewBody");
							var $pagingArea = $("#pagingArea");
							
							new pagingAjax(pjtNo, maxPage, $reviewBody, $pagingArea);
						}
						
						function movePage(choosePage) {
							
							var pjtNo = ${requestScope.pjtNo};
							var $reviewBody = $("#reviewBody");
							var $pagingArea = $("#pagingArea");
							
							new pagingAjax(pjtNo, choosePage, $reviewBody, $pagingArea);
						}
						
						/* 스프린트 리뷰 작성 버튼 */
						function retrospect($retrospectTd) {
							
							/* 백로그 번호 */
					    	const blgNo = $retrospectTd.parentNode.parentNode.children[0].innerText;
					    	console.log(blgNo);
					    		
					    	location.href = "${ pageContext.servletContext.contextPath }/board/backlog/retrospect/" + blgNo;
						} 
					</script>
					<!-- Ajax 스프린트 리뷰 게시판 페이징 끝-->
				</div>
			</div>
		</div>
	
	
<!-- 백로그 생성 모달 -->
  <!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div class="header_detail">Create Backlog</div>					
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="row nk3">
						<div class="backlog_info">
							
							<div class="info_item">
								<div class="info_detail">* 이름</div>
								<input class="input_detail" type="text" id="backlogName">
							</div>
							<div class="info_item">
								<div class="info_detail">* 중요도</div>
								<select id="importance">
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</div>
						</div>
						<div class="backlog_textarea">
							<div class="text_item">
								<div class="text_detail">* 데모 방식</div>
								<textarea class="textarea_detail" id="DemoDetail"></textarea>
							</div>
							<div class="text_item">
								<div class="text_detail">* 참고</div>
								<textarea class="textarea_detail" id="Reference"></textarea>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn_detail" id="createBacklog">생성</button>
					<button type="button" class="btn_detail" data-dismiss="modal">취소</button>
				</div>

			</div>
		</div>
	</div>
	
	<!-- 백로그 생성 버튼 클릭시 -->
		<script>
		/* null 체크 */
		function vali(value){
		    if (value === null) return true; 
		    if (typeof value === 'string' && value === '') return true;
		    if (typeof value === 'undefined') return true;
		    return false;
		}
		
			$("#createBacklog").click(function(){ 
				var pjtNo = ${ requestScope.pjtNo };
				 var blgName = document.getElementById("backlogName").value;
				 var blgPri = document.getElementById("importance").value;
				 var blgDemoMemo = document.getElementById("DemoDetail").value;
				 var blgRefMemo = document.getElementById("Reference").value;
				if(!vali(blgName) && !vali(blgPri) && !vali(blgDemoMemo) && !vali(blgRefMemo)){
				 $.ajax({
					url : "${pageContext.servletContext.contextPath}/board/backlog/backlog_regist",
					type : "post",
					data : {
						pjtNo : pjtNo,
						blgName : blgName,
						blgPri : blgPri,
						blgDemoMemo : blgDemoMemo,
						blgRefMemo : blgRefMemo
					},
					success : function(data, textStatus, xhr){
						location.reload();//새로고침
						alert("백로그 생성이 완료되었습니다");
					},
					error : function(xhr, status, error){
						console.log(error);
						alert("백로그 생성이 취소되었습니다");
					}
				 })
				}else{
					alert("필수 항목을 채워주세요.");
				}
			});
		</script>
		
	
	
	
	<!-- 백로그 수정 모달 -->
	<!-- The Modal -->
	<div class="modal fade" id="myModalEdit">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div class="header_detail">Edit Backlog</div>					
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="row nk3">
						<div class="backlog_info">
							<div class="info_item">
								<div class="info_detail nk">* 이름</div>
								<input class="input_detail" type="text" id="backlogName11" value="" >
							</div>
							
							<div class="info_item">
								<div class="info_detail nk"><!--  style="display: none;" -->백로그 번호</div>
								<input class="input_detail" type="text" id="backlogNo11" value="" readonly> <!-- style="display: none;" -->
							</div>
							
							
							<div class="info_item">
								<div class="info_detail nk">* 중요도</div>
								<select id="importance11">
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</div>
						</div>
						<div class="backlog_textarea">
							<div class="text_item">
								<div class="info_detail nk">* 데모 방식</div>
								<input type="text" class="textarea_detail" id="DemoDetail11"  value="" >
							</div>
							<div class="text_item">
								<div class="info_detail nk">* 참고</div>
								<input type="text" class="textarea_detail" id="Reference11"  value="" >
							</div>
						</div>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn_detail" id="EditBacklog">수정</button>
					<button type="button" class="btn_detail" id="removeBacklog">삭제</button>
					<button type="button" class="btn_detail" data-dismiss="modal">취소</button>
				</div>

			</div>
		</div>
	</div>
	
	
	
<!-- 백로그 수정 버튼 클릭시 -->
		<script>
		/* function btnDetail(beta){
			var blgNo = $(beta).val(); */
			
			$("#EditBacklog").click(function(){ 
				var pjtNo = ${ requestScope.pjtNo };
				 var blgNo = document.getElementById("backlogNo11").value;
				 var blgName = document.getElementById("backlogName11").value;
				 var blgPri = document.getElementById("importance11").value;
				 var blgDemoMemo = document.getElementById("DemoDetail11").value;
				 var blgRefMemo = document.getElementById("Reference11").value;
				 console.log("넘ㅂ : " + pjtNo);
				 console.log("넘ㅂ : " + blgNo);
				 console.log("넘ㅂ : " + blgName);
				 console.log("넘ㅂ : " + blgPri);
				 console.log("넘ㅂ : " + blgDemoMemo);
				 console.log("넘ㅂ : " + blgPri);
				 if(!vali(blgNo) && !vali(blgName) && !vali(blgPri) && !vali(blgDemoMemo) && !vali(blgRefMemo)){
				 $.ajax({
					url : "${pageContext.servletContext.contextPath}/board/backlog/backlog_Edit",
					type : "post",
					data : {
						pjtNo : pjtNo,
						blgNo : blgNo,
						blgName : blgName,
						blgPri : blgPri,
						blgDemoMemo : blgDemoMemo,
						blgRefMemo : blgRefMemo
					},
					success : function(data, textStatus, xhr){
						alert("백로그 수정이 완료되었습니다.");
						document.location.reload();
					},
					error : function(xhr, status, error){
						console.log(error);
						alert("백로그 수정이 취소되었습니다.");
					}
				 })
				 }else{
						alert("빠진 부분을 채워주세요~");					 
				 }
				}
			)
		
		</script>
		
		<!-- 백로그 삭제 버튼 클릭시 -->
			<script>
				$("#removeBacklog").click(function(){ 
					 if(confirm("정말 삭제하시겠습니까 ?") == true){
					var pjtNo = ${ requestScope.pjtNo };
					 var blgNo = document.getElementById("backlogNo11").value;
					 
					 $.ajax({
						url : "${pageContext.servletContext.contextPath}/board/backlog/backlog_Remove",
						type : "post",
						data : {
							pjtNo : pjtNo,
							blgNo : blgNo,
						},
						success : function(data, textStatus, xhr){
							alert("백로그 삭제가 완료되었습니다");
							document.location.reload();
						},
						error : function(xhr, status, error){
							console.log(error);
							alert("백로그 삭제가 취소되었습니다");
						}
					 })
				}else{
					return;
					}
				})
			</script>


	
	
	<!-- 프로젝트 수정 모달 -->
	<div class="modal fade" id="project_produce_Detail">
	   <div class="modal-dialog">
	      <div class="modal-content">
	
	         <!-- Modal Header -->
	         <div class="row detailpage">
	         	<div class="left_area">
	         		<div class="modal-header">
						<div class="item_detail">프로젝트 이름</div>
						<input class="input_detail nk type" type="text" id="projectName" placeholder="${projectList.projectName }" readonly>            
					</div>
			         <div class="modal-header">
			         	<div class="item_detail">시작 날짜 </div>
			         	<input class="input_detail nk type" type="text" id="projectStartDate" placeholder="${projectList.projectStartDate } " readonly style="border : 0;"/>
			         </div>
	         		<div class="modal-header">
			         	<div class="item_detail">종료 날짜</div>
			         	<input class="input_detail nk type" type="text" id="projectEndDate" placeholder="${projectList.projectEndDate } " readonly style="border : 0;"/>
			         </div>
			         <div class="modal-header">
			            <div class="item_detail">프로젝트 색상</div>
			        	<input class="input_detail nk type" style="background-color: ${projectList.projectColor};" id="projectColor" readonly style="border : 0;">  
			         </div> 
	         	</div>
	         	<div class="right_area">
					<div class="modal-header">
						<div class="item_detail">* 프로젝트 이름</div>
						<input class="input_detail nk type" type="text" id="projectNameEdit" placeholder="수정할 프로젝트 이름">            
					</div>
					<div class="modal-header">
						<div class="item_detail">* 수정 시작 날짜</div>
			            <input class="input_detail nk type" type="date" id="projectStartDateEdit"  placeholder="${projectList.projectStartDate }">         
			         </div>
			         <div class="modal-header">
			            <div class="item_detail">* 수정 종료 날짜</div>
			         	<input class="input_detail nk type" type="date" id="projectEndDateEdit">  
			         </div>
			         <div class="modal-header">
			            <div class="item_detail">* 수정할 프로젝트 색상</div>
			        	<input class="input_detail nk type" type="color" id="projectColorEdit">  
			         </div> 
	         	</div>
	         </div>
         
                
         <!-- Modal body -->
         <!-- 프로젝트 수정 -->
         <div class="modal-body">
            <div class="row">
               <i class="fas fa-search"></i>
               <input class="input_detail1" type="text" id="emailEdit" placeholder="Add Member" style="width:66%;">
               <select class="select_detail nk" id="selectrollEdit">
                  <option>Admin</option>
                  <option>Member</option>
                  <option>Client</option>
               </select>
               <input class="input_detail2 nk" type="button" id="addpersonButtonEdit" value="+">      
               <input class="input_detail2 nk" type="button" id="removepersonButtonEdit" value="-">      
            </div>

				<table class="select_member" id="projectMember" border="1" style="width:100%; height:30px; text-align: center">
					<thead>
					<tr>
						<th style="width:60px; ">번호</th>
						<th>이메일</th>
						<th style="width:100px;">권한</th>
						<th style="width:100px; display:none">회원번호</th>
					</tr>
					</thead>
					<tbody  id="dynamicTbody">
					<c:if test="${ !empty requestScope.memberList }">
					  <c:forEach items="${memberList}" var="member" varStatus="st" >
					  <tr>
					  <c:set var="countMember" value="${st.count}"  />	
						<th  class="memberCount">${countMember }</th>
						<th class="Email">${member.memberId}</th>
						<th class="roll">
						<c:choose>
							<c:when test="${ member.projectRole == 1}">Admin</c:when>
							<c:when test="${ member.projectRole == 2}">Member</c:when>
							<c:when test="${ member.projectRole == 3}">Client</c:when>
						</c:choose>
						
						</th>
						<th class="memberNo" style="display:none">${member.memberNo}</th>
						</tr>
						</c:forEach>
					</c:if> 
					</tbody>
				</table>
       		  </div>
       	 	 <div class="modal_btn_area">
            <button class="btn_detail" id="editProject">Edit Project</button>
            <button class="btn_detail" id="removeProject">Remove Project</button>
         </div>            
      </div>
   </div>
</div>
</div>

</body>

<script>
		/* 시큐리티 권한  */
		const token = $("meta[name='_csrf']").attr("content");
		const header = $("meta[name='_csrf_header']").attr("content");
		
		$(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		});
		var start = ${projectList.projectStartDate };
		var End = ${projectList.projectEndDate };
		var projectName = "${projectName}";
		console.log(" projectName : " + projectName);
		
		var idcount = ${countMember};
		//인원삭제 버튼 클릭
		$("#removepersonButtonEdit").click(function(){
			$("#dynamicTbody tr:last").remove();
			idcount--;
		});
		
		/* 이메일 null 체크 */
		function vali(value){
		    if (value === null) return true; 
		    if (typeof value === 'string' && value === '') return true;
		    if (typeof value === 'undefined') return true;
		    return false;
		}
		/* var idcount = 1; */
		var addMemberNo = $("#projectMember tr:last");
		console.log("마지막 번호" + $("#projectMember #memberCount").val());
		
		
		/* 인원추가 */
		$("#addpersonButtonEdit").click(function(){
			
			var email = $("#emailEdit").val();			//입력한 이메일
			
				if(!vali($("#emailEdit").val())){
					/* 아이디 중복 체크 */
					$.ajax({
						url:"${pageContext.servletContext.contextPath}/board/projectidDupCheckEdit",
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
								 insertTr += '<td class="Email">'+	document.getElementById("emailEdit").value + '</td>';
								 insertTr += '<td class="roll">'+	document.getElementById("selectrollEdit").value + '</td>';
								 insertTr += '<td class="memberNo" style="display:none">' + data + '</td>';
								 insertTr += '</tr>';
								 $("#dynamicTbody").append(insertTr);
								 $("#emailEdit").val('');	//입력 후 input  비워주기
							}else{
							alert("가입된 이메일주소가 아닙니다. 확인 해주세요~");
							 $("#emailEdit").val('');
							}
							
						}, error:function(data){
						}
					});
					
			}else{
				alert("이메일을 입력해주세요");
			}
				});
		
		/* 프로젝트 수정 버튼 클릭 */
		$("#editProject").click(function(){ 
			function makeTag(name, value){
				var hiddenTag = document.createElement('input');
				hiddenTag.setAttribute("type", "hidden")
				hiddenTag.setAttribute("name", name)
				hiddenTag.setAttribute("value", value)
				return hiddenTag
			}
			
		   var memberNo = ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no};
		   console.log(memberNo);
			const projectMemberList = document.getElementById('dynamicTbody').innerHTML;
			var $form = $('<form></form>');
		   var projectName = document.getElementById("projectNameEdit").value;
		   var projectStartDate = document.getElementById("projectStartDateEdit").value;
		   var projectEndDate = document.getElementById("projectEndDateEdit").value;
		   var projectColor = document.getElementById("projectColorEdit").value;
		   console.log("projectName : " + projectName);
		   console.log("projectStartDate : " + projectStartDate);
		   console.log("projectEndDate : " + projectEndDate);
		   console.log("projectColor : " + projectColor);
		   
		  		   	
		   var pjtNo = ${ requestScope.pjtNo };
		   var nk1 = $('form[name=projectMemberList]').serializeArray();
		   nk1.push(
				      { name : "idcount", value : idcount},
					  { name : "pjtNo", value : pjtNo},
					  { name : "memberNo", value : memberNo},
					  { name : "projectName", value : projectName}, 
					  { name : "projectStartDate",value : projectStartDate},
					  { name : "projectEndDate",value : projectEndDate},
					  { name : "projectColor",value : projectColor}
						);
		   
		   var projectMaker = $("#projectMember").find(".memberNo").eq(0).text();
		    for(let i = 0; i < idcount; i++){
			   memberId = $("#projectMember").find(".Email").eq(i).text();
			   console.log("Email : " + memberId);
			   projectRole = $("#projectMember").find(".roll").eq(i).text().trim();
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
				
			   $form.append(makeTag(memberId, memberId));
			   $form.append(makeTag(projectRole, projectRole));
		   } 
		   
		   console.table("얍 " + nk1);
		   console.log("djdjdndnd : " + pjtNo);
		   
		   if(!vali(projectName) && !vali(projectStartDate) && !vali(projectEndDate) && !vali(projectColor)){
		   $.ajax({
			   url :"${pageContext.servletContext.contextPath}/board/backlog/project_edit",
			   type : "post",
			   data :  {
				   nk1 : nk1,
				    },
			
			   success : function(data, textStatus, xhr) {
				   alert("프로젝트 수정이 완료되었습니다.");
					location.reload();//새로고침
			   },
				error : function(xhr, status, error) {
					console.log(error);
					alert("프로젝트 수정이 취소되었습니다.");
					location.href = "${pageContext.servletContext.contextPath}/board/backlog";
				}
		   });
		   }else{
			   alert("빠진 부분을 채워주세요~");
		   }
		   
		});
		</script>
		<script>
		var memberNo = ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no};
		var projectStartDate = "${projectList.projectStartDate }";
		var projectEndDate = "${projectList.projectEndDate }";
		var projectName = "${projectList.projectName }";
		var projectColor = "${projectList.projectColor }";
				   
		/* 프로젝트 삭제 버튼 클릭시 */
		$("#removeProject").click(function(){
			   if(confirm("정말 삭제하시겠습니까 ?") == true){
			var pjtNo = ${ requestScope.pjtNo };
					$.ajax({
						url:"${pageContext.servletContext.contextPath}/board/projectRemove",
						type:"post",
						data:{
							pjtNo :pjtNo,
							projectName : projectName,
							projectStartDate : projectStartDate,
							projectEndDate : projectEndDate,
							projectColor : projectColor
						},
						success:function(data, textStatus, xhr) {
						     alert("프로젝트가 삭제되었습니다");
						     location.href = "${pageContext.servletContext.contextPath}/board/project_board/" + memberNo;
						}, error:function(xhr, status, error){
						     location.href = "${pageContext.servletContext.contextPath}/board/backlog"+ ${ requestScope.pjtNo };
							
						}
					});
					
			   }
			    else{
			        return ;
			    }
					
			});
</script>

</html>