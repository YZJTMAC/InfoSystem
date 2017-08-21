<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String vertical="|";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调查问卷结果分析</title>
<%@include file="../common/commonHead.jsp"%>
<link href="<%=basePathHeader%>/style/q.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/JSClass/FusionCharts.js"></script>
</head>
<body>

	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="project" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/projectLeft.jsp"%>
	</div>
	<div class="content">
		<div class="place">
			<span>位置：</span>
	    <ul class="placeul">
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">项目调查与评估</a></li>
    <li><a href="#">结果报告</a></li>
    </ul>
		</div>
		<div class="surveyhead" style="border: 0px;">
    <h1><span>${paper.name }</span></h1>
	</div>
		<c:forEach items="${pgq}" var="question" varStatus="status">
		<div style="margin-left:100px;margin-right:100px;">
			<div class="div_question" id="div1">
				<div class="div_title_question_all">
					<div class="div_topic_question">
						<b>${status.index+1 }.</b>
					</div>
					<div id="divTitle1" class="div_title_question">
						${question.title}<font style="color:red;">&nbsp;*</font>
					</div>
					<div style="clear:both;"></div>
				</div>
				<c:set var="qid"   value="${question.id}" /> 
				<div class="div_table_radio_question" id="divquestion1">
					<div class="div_table_clear_top"></div>
					<ul style="margin:5px 0 0 5px;">
						<li class="notchoice" style="padding-right:15px;padding-top:5px;">
						<b>
								<c:if test="${question.questionType==2}">
										<div id="chartdiv${question.id}" align="center">FusionCharts.</div> 
										<script type="text/javascript">
									     var chart = new FusionCharts("<%=basePathHeader%>/javascript/Charts/Column2D.swf", "ChartId", "500", "300", "0", "0");
									     chart.setDataXML("<graph caption='${question.title}' xAxisName='' yAxisName='person' yAxisMaxValue='5' showNames='1' decimalPrecision='0' formatNumberScale='0' showBorder='1'>" 
							                            <c:forEach items="${mapQP[qid]}" var="option" varStatus="status">
														<c:set var="opid"   value="${option.id}" /> 
														  +"<set label='${option.content}' value='${map[opid]}' />"
														</c:forEach>
														+"</graph>");    
									      chart.render("chartdiv${question.id}");
									     </script>
								</c:if>
								<c:if test="${question.questionType==3}">
										<div id="chartdiv${question.id}" align="center">FusionCharts.</div> 
										<script type="text/javascript">
									     var chart = new FusionCharts("<%=basePathHeader%>/javascript/Charts/Column2D.swf", "ChartId", "500", "300", "0", "0");
									     chart.setDataXML("<graph caption='${question.title}' xAxisName='' yAxisName='person' yAxisMaxValue='5' showNames='1' decimalPrecision='0' formatNumberScale='0' showBorder='1'>" 
							                            <c:forEach items="${mapQP[qid]}" var="option" varStatus="status">
														<c:set var="opid"   value="${option.id}" /> 
														  +"<set label='${option.content}' value='${map[opid]}' />"
														</c:forEach>
							                              +"</graph>");    
									      chart.render("chartdiv${question.id}");
									     </script>
								</c:if>
	
						</b>
						</li>
						<div style="clear:both;"></div>
					</ul>
					<div style="clear:both;"></div>
					<div class="div_table_clear_bottom"></div>
				</div>
			</div>
	</div>
	</c:forEach>
	<div align="center"><a href="javascript:history.go(-1);" class="dian3">返回</a></div>
</div>
</body>

</html>
