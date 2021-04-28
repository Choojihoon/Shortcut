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
	<link rel="stylesheet" type="text/css" href="${ pageContext.servletContext.contextPath }/resources/css/mywork.css">
	

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	
	<!-- 구글 차트 -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
	
	<title>Short Cut</title>

	<script type="text/javascript">
	var request = ${fn:length(requestScope.cardProgress1List) };
	var doing = ${fn:length(requestScope.cardProgress2List) };
	var done = ${fn:length(requestScope.cardProgress3List) };
	var wait = ${fn:length(requestScope.cardProgress4List) };
	console.log(request);
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['요청 중',     request],
          ['진행 중',      doing],
          ['완료',  done],
          ['보류', wait]
          
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
						<div class="item_content"></div>
					</div>
					<div class="item_type2">
						<div class="item_name">
							제목
						</div>
						<div class="item_content"></div>
					</div>
				</div>
				<div class="row">
					<div class="item_title">
						할일
					</div>
					<div class="item_type1">
						<div class="item_name">
							기간
						</div>
						<div class="item_content"></div>
					</div>
					<div class="item_type2">
						<div class="item_name">
							제목
						</div>
						<div class="item_content"></div>
					</div>
				</div>
			</div>

			<div class="sch_title">
				My work
			</div>
			<div class="schedule_line"></div>
			<div class="schedule_item">
				<div class="row">
					<div class="item_title">
						요청
					</div>
					<div class="item_type3">
						<div class="item_name">
							기간
						</div>
						<div class="item_content">
						<c:forEach var="req_cardList" items="${ requestScope.cardProgress1List }">
							<c:out value="${ req_cardList.tkStartDate }"/> <br>
						</c:forEach>
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
						<div class="item_content">1 2 3</div>
					</div>
				</div>
				<div class="row">
					<div class="item_title">
						진행중
					</div>
					<div class="item_type3">
						<div class="item_name">
							기간
						</div>
						<div class="item_content">
						<%-- <c:forEach var="req_cardList" items="${ requestScope.cardProgress2List }">
							<span><c:out value="${ req_cardList.tkStartDate }"/></span> <br>
						</c:forEach> --%>
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
				</div>
				<div class="row">
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
				</div>
				<div class="row">
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