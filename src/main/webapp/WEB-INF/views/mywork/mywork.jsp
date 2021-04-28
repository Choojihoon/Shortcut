<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/mywork.css">
	

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	
	<!-- 구글 차트 -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
	
	<title>Short Cut</title>

	<script type="text/javascript">

		var requestCount = ${ requestScope.reqCardCount }
		var doingCount = ${ requestScope.doingCardCount }
		var doneCount = ${ requestScope.doneCardCount }
		var waitCount = ${ requestScope.waitCardCount }
	    google.charts.load("current", {packages:["corechart"]});
	    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable([
	        ['Task', 'Hours per Day'],
	        ['요청 중',     requestCount],
	        ['진행 중',      doingCount],
	        ['완료',  doneCount],
	        ['보류', waitCount]
	          
	      ]);
	
	      var options = {
	        title: '내 업무 그래프',
	        pieHole: 0.4,
	      };
	
	      var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
	      chart.draw(data, options);
	    }
    </script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="mywork_area">
		<div class="mywork_header_list">
			<div class="row">
				<a class="header_list on" href="${ pageContext.servletContext.contextPath }/mywork/mywork">My work</a>
				<a class="header_list" href="${ pageContext.servletContext.contextPath }/mywork/client">Client</a>
			</div>
		</div>
		<div class="chart_area">			
			<div class="chart">
				<div id="donutchart" style="width: 1000px; height: 600px;"></div>
			</div>			
		</div>
		<div class="container schedule_area">
			<div class="sch_title">
				Schedule
			</div>
			<div class="schedule_line"></div>
			<div class="schedule_item">
				<div class="row">
					<div class="item_title">
						미팅
					</div>
					<div class="item_type1">
						<div class="item_name">
							기간
						</div>
						<div class="item_content">
							<c:forEach var="meetingList" items="${ requestScope.meetingList }">
								<span><c:out value="${ meetingList.schStartDate } ~ ${ meetingList.schEndDate }"/></span> <br>
							</c:forEach> 
						</div>
					</div>
					<div class="item_type2">
						<div class="item_name">
							제목
						</div>
						<div class="item_content">
							<c:forEach var="meetingList" items="${ requestScope.meetingList }">
								<span><c:out value="${ meetingList.crdName }"/></span> <br>
							</c:forEach> 
						</div>
					</div>
				</div>
			</div>

			<div class="sch_title">
				My work
			</div>
			<div class="schedule_line"></div>
			<div class="schedule_item" id="mywork">
				<div class="row" id="request">
					<div class="item_title">
						요청
					</div>
					<div class="item_type3">
						<div class="item_name">
							기간
						</div>
						<div class="item_content">
						
						</div>
					</div>
					<div class="item_type4">
						<div class="item_name">
							완료
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type5">
						<div class="item_name">
							제목
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type6">
						<div class="item_name">
							비고
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type7">
						<div class="item_pagenavi"></div>
					</div>
				</div>
				<div class="row" id="doing">
					<div class="item_title">
						진행중
					</div>
					<div class="item_type3 ">
						<div class="item_name">
							기간
						</div>
						<div class="item_content">
							<c:forEach var="req_cardList" items="${ requestScope.cardProgress2List }">
								<span><c:out value="${ req_cardList.tkStartDate }"/></span> <br>
							</c:forEach> 
						</div>
					</div>
					
					<div class="item_type4">
						<div class="item_name">
							완료
						</div>
						<div class="item_content">
							<c:forEach var="req_cardList" items="${ requestScope.cardProgress2List }">
								<span><c:out value="${ req_cardList.tkEndDate }"/></span> <br>
							</c:forEach> 
						</div>
					</div>
					<div class="item_type5">
						<div class="item_name">
							제목
						</div>
						<div class="item_content">
						</div>
					</div>
					<div class="item_type6">
						<div class="item_name">
							비고
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type7">
						<div class="item_pagenavi"></div>
					</div>
				</div>
				
				<script type="text/javascript">
				
					/* 회원 정보 찾기 */
					const $memNo = ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.no};
					/* sequrity값 찾기 */
					const token = $("meta[name='_csrf']").attr("content");
					const header = $("meta[name='_csrf_header']").attr("content");
					$(document).ajaxSend(function(e, xhr, options) {
					    xhr.setRequestHeader(header, token);
					});
					
					/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
					
					/* 페이지 접근 시 초기화  */
					$('document').ready(function(){
						
						for( let i = 1; i < 5; i++){
							var idvalue = reversetypestandard(i)
							var allcan = $("div[id^='" + idvalue + "']").find("[class*='_content']");
							console.log(idvalue+ " : " +allcan)
							var allvar = $("div[id^='" + idvalue + "']").find('.item_pagenavi');
							console.log(allvar);
							pagenation($memNo,allcan,1,allvar,i);
							console.log("@@@@@@@@@@@@@@@" + idvalue)
						}
					});
					
					/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
					/* 날짜 변경 함수 */
					function gettoDate(data){
						var tag = document
						var date = new Date(data);
						var year = date.getFullYear();
						var month = ("0" + (1+ date.getMonth())).slice(-2);
						var day = ("0" + date.getDate()).slice(-2);
						return year+ "-" + month + "-" + day;
					}
					/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
					
					/* 페이지 네비게이션 갱신 함수 */
					function navi(firstPage, lastPage, maxPage,domain,page){					
						domain.empty();
						if ( firstPage <= 1){
							domain.append('<button class="pnbutton" disabled><<</button>');
							domain.append('<button class="pnbutton" disabled><</button>');						
						} else {
							domain.append('<button class="pnbutton" onclick="startPage(this)"><<</button>');
							domain.append('<button class="pnbutton" onclick="prevPage('+ firstPage +',this)"><</button>');
						}
						for( let i = firstPage; i <= lastPage; i++ ){
							if( i == page){
							domain.append('<button class="pnbutton on"  disabled>'+i+'</button>');	
							} else {
							domain.append('<button class="pnbutton" onclick="movePage('+ i +',this)">'+i+'</button>');
							}
						}
						if (lastPage == maxPage) {
							domain.append('<button class="pnbutton" disabled>></button>');
							domain.append('<button class="pnbutton" disabled>>></button>');
						}else {
							domain.append('<button class="pnbutton" onclick="nextPage('+ lastPage +',this)">></button>');
							domain.append('<button class="pnbutton" onclick="rumPage('+ maxPage +',this)">>></button>');
						}
					}
					/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
					
					/* 리스트 조회 함수  */
					function pagenation($memNo,slect,page,aslt,type){
						console.log("현재페이지는 : "+  page);
						console.log("type : " + type);
						slect.empty();
						$.ajax({
							url: "requestPaging",
							method: "post",
							data: {"currentPage": page,
								   "memNo": $memNo,
								   "type" : type
							      },
							success: function(data, status, xhr) {
								console.table(data);
								if (0==data.length){
									
								} else {
									var start = data[0].startPage
									var end = data[0].endPage
									var max = data[0].maxPage
									var crdtype = data[0].tkProgress;
									var startdate = data[0].tkStartDate;
									var endate = data[0].tkEndDate; 
									console.log("start : " + start);
									console.log("end : " + end);
									console.log("max : " + max)
									console.log("crdtype: " + crdtype);
									console.log("startdate : " + gettoDate(startdate));
									console.log("endDate : " + gettoDate(endate));
									console.log("length:" + slect.length);
								
									  for(let i = 0; i < slect.length; i++){
										 for(let j=0; j < slect.length; j++){
	
											 if(typeof(data[j]) == "undefined" || data[j] == "" || data[j] === null) {
													 
											 } else {
												 
												 /* 값 넣기 */
												 if( i == 0){
														$(slect[i]).append(gettoDate(data[j].tkStartDate)+'<br>');
												 }
												 if( i == 1){
													$(slect[i]).append(gettoDate(data[j].tkEndDate)+'<br>');
												 }
												 if( i == 2){
													 $(slect[i]).append((data[j].crdName)+'<br>');
													 console.log("data[j].crdName : " + data[j].crdName);
												 }
												 /* 버튼 넣기 */
												 if( i == 3){
													 if(type == 1){
													 var inputBtnHtml ='<input type="button" class="remarkBtn" value="수락" onclick="updateProgress('+data[j].crdNo+','+ type+',' + 2 +')" title="진행 중으로 카드를 옮깁니다."/> <input type="button" class="remarkBtn" value="보류" onclick="updateProgress('+data[j].crdNo+','+ type+',' + 4 +')" title="보류로 카드를 옮깁니다."/> <br>'
													 
														 $(slect[3]).append(inputBtnHtml);
													 }
													 if(type == 2){
														 var inputBtnHtml ='<input type="button" class="remarkBtn" value="완료" onclick="updateProgress('+data[j].crdNo+','+ type+',' + 3 +')" title="완료로 카드를 옮깁니다."/><br>'
															 $(slect[3]).append(inputBtnHtml);
													 }
													 if(type == 3){
														 var inputBtnHtml ='<input type="button" class="remarkBtn" value="진행" onclick="updateProgress('+data[j].crdNo+','+ type+',' + 2 +')" title="진행 중으로 카드를 옮깁니다."/><br>'
															 $(slect[3]).append(inputBtnHtml);
													 }
													 if(type == 4){
														 var inputBtnHtml ='<input type="button" class="remarkBtn" value="진행" onclick="updateProgress('+data[j].crdNo+','+ type+',' + 2 +')" title="진행 중으로 카드를 옮깁니다."/><br>'
															 $(slect[3]).append(inputBtnHtml);
													 }
												}
											}
									 	}								
									 } 
									  
								navi(start,end, max, aslt,page);
									 
								}
	
							},
							error: function(xhr, status, data){
								console.log(data);
							}
						})	
					}
				
					/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
					
					/* 타입 변경 함수  */
					function typestandard(txt){
						var num = 0;
						if('request'=== txt) {
							num = 1;
						
						} else if('doing'=== txt) {
							num = 2;
							
						} else if('done'=== txt) {
							num = 3;
						} else if('wait'=== txt) {
							num = 4;
						}
						
						return num;
					}
					
					function reversetypestandard(num){
						var txt = '';
						if(1 === num) {
							txt = 'request';
						
						} else if(2=== num) {
							txt = 'doing';
							
						} else if(3=== num) {
							txt = 'done';
						} else if(4=== num) {
							txt = 'wait';
						}
						
						return txt;
					}
					
					/* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ */
		
					/* 버튼 함수  */
					function movePage(page,beta) {
						var slect = $(beta).closest('.row').find("[class*='_content']");
						var aslt = $(beta).closest('.item_pagenavi')
						var pretype = $(beta).closest('.row').attr('id');
						var type = typestandard(pretype);
						new pagenation($memNo,slect,page,aslt,type);
						
					};
					
					function startPage(beta) {
						var slect = $(beta).closest('.row').find("[class*='_content']");
						var aslt = $(beta).closest('.item_pagenavi')
						var pretype = $(beta).closest('.row').attr('id');
						var type = typestandard(pretype);
						new pagenation($memNo,slect,1,aslt,type);				
					};
					
					function nextPage(page, beta) {
						var slect = $(beta).closest('.row').find("[class*='_content']");
						var aslt = $(beta).closest('.item_pagenavi')
						var pretype = $(beta).closest('.row').attr('id');
						var type = typestandard(pretype);
						new pagenation($memNo,slect,page+1,aslt,type);				
					};
					
					function prevPage(page, beta) {
						var slect = $(beta).closest('.row').find("[class*='_content']");
						var aslt = $(beta).closest('.item_pagenavi')
						var pretype = $(beta).closest('.row').attr('id');
						var type = typestandard(pretype);
						new pagenation($memNo,slect,page-1,aslt,type);			
					};
					
					function rumPage(page, beta) {
						var slect = $(beta).closest('.row').find("[class*='_content']");
						var aslt = $(beta).closest('.item_pagenavi')
						var pretype = $(beta).closest('.row').attr('id');
						var type = typestandard(pretype);
						new pagenation($memNo,slect,page,aslt,type);				
					};
					
					function updateProgress(crdNo, type, intenType){
						console.log(crdNo);
						console.log(type);
						console.log(intenType);
						 $.ajax({
							url: "updateProgress",
							method: "post",
							data: {"crdNo": crdNo,
								   "type" : type,
								   "intenType" : intenType
							      },
							success: function(data, status, xhr) {
								console.log(data);
								location.href= "${ pageContext.servletContext.contextPath }/" + data;
							},
							error: function(xhr, status, error){
								console.log(error)
							}   
						}); 
					}
					
				
					
				</script>
				<div class="row" id="done">
					<div class="item_title">
						완료
					</div>
					<div class="item_type3">
						<div class="item_name">
							기간
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type4">
						<div class="item_name">
							완료
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type5">
						<div class="item_name">
							제목
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type6">
						<div class="item_name">
							비고
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type7">
						<div class="item_pagenavi"></div>
					</div>
				</div>
				<div class="row" id="wait">
					<div class="item_title">
						보류
					</div>
					<div class="item_type3">
						<div class="item_name">
							기간
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type4">
						<div class="item_name">
							완료
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type5">
						<div class="item_name">
							제목
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type6">
						<div class="item_name">
							비고
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type7">
						<div class="item_pagenavi"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function pageMove(pg){
			$.ajax({
				type	: "POST",
				url	    : "",
				data	: {	
					'page'		: pg,
					'perPgLine' 	: perPgLine
				},
					dataType: 'JSON',
				success : function(result) {
					page = pg;
					//update board fromd data
					updatePaging("pageMove", page, allRowCnt, perPgLine, 3);
				},
				error : function(e) {
				console.log(e);
				}
			});
		}
	
	</script>
	
</body>
</html>