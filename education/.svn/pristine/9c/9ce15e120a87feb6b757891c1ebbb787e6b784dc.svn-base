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
<title>我的问卷</title>
<%@include file="../common/commonHead.jsp"%>
<link href="<%=basePathHeader%>/style/q.css" rel="stylesheet" type="text/css" />
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
				<li><a href="###">培训项目</a>
				</li>

				<li>项目调查</li>
				<li>预览调查问卷</li>
			</ul>
		</div>
		<div class="surveyhead" style="border: 0px;">
    <h1><span>${paper.name }</span></h1>
	</div>
	<form action="<%=path%>/teacher/teacherProject/tjPaper.htm?click=11" id="thisForm" method="post">
	   <input type="hidden" name="paperId" id="paperId" value="${paper.id}" />
	   <input type="hidden" name="projectId" id="projectId" value="${paper.projectId}" />
		<c:forEach items="${pgq}" var="question" varStatus="status">
		<div style="margin-left:100px;margin-right:100px;">
			<div class="div_question" id="div1">
				<div class="div_title_question_all">
					<div class="div_topic_question">
						<b>${status.index+1 }.</b>
					</div>
					<div id="divTitle1" class="div_title_question">
						${question.title}
                        <c:if test="${question.requiredAnswer=='Y'}">
							<font style="color:red;">&nbsp;*</font>
						</c:if>
					</div>
					<div style="clear:both;"></div>
				</div>
				<c:set var="qid"   value="${question.id}" /> 
				<c:set var="string1" value=""/>
				<div class="div_table_radio_question" id="divquestion1">
					<div class="div_table_clear_top"></div>
					<ul style="margin:5px 0 0 5px;">
						<li class="notchoice" style="padding-right:15px;padding-top:5px;">
						<b>
							<c:choose>
						
								<c:when test="${question.questionType==1}">
									<c:forEach items="${map[qid]}" var="option" varStatus="status">
									<textarea name="questionType_${qid}"  style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;">${mapERQ[qid]}</textarea>
									</c:forEach>
								</c:when>
								<c:when test="${question.questionType==2}">
									<c:forEach items="${map[qid]}" var="option" varStatus="status">
									<input type="radio" name="questionType_${qid}" <c:if test="${fn:contains(mapERQ[qid], option.id)}">checked</c:if> value="${option.id}"/><label for="q5_1">&nbsp;${option.content }</label>
									</c:forEach>
								</c:when>
								<c:when test="${question.questionType==3}">
									<c:forEach items="${map[qid]}" var="option" varStatus="status">
										<c:set var="string2" value="${option.id}|"/>
										<input type="checkbox" name="questionType_${qid}" value="${option.id}" <c:if test="${fn:contains(mapERQ[qid], string2)}">checked</c:if>/>&nbsp;${option.content } &nbsp;&nbsp;&nbsp;&nbsp;
          						 	</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${map[qid]}" var="option" varStatus="status">
          								<textarea name="questionType_${qid}"  style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;">${mapERQ[qid]}</textarea>
          						</c:forEach>
								</c:otherwise>
							</c:choose>
	
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
	<div align="center"><a href="javascript:history.go(-1);" class="dian3">关闭</a></div>
   </form>
</div>

</body>

</html>
