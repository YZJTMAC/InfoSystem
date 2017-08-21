<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改调查问卷</title>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/paperValidate.js"></script>  
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectPaperModify.js"></script>
</head>

<body>
	<input type="hidden" id="projectId" value="${eduPaper.projectId}"/>
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
				<li><a href="ssadmin.html">培训项目</a></li>
				<li>继教信息板块</li>
	            <li>添加</li>
		  	</ul>
		</div>

		<div class="formbody">
			<div class="tabson" id="txtBox">
				<form id="paperForm">
						<input type="hidden" id="paperId" name="id" value="${eduPaper.id}"/>
						<table border="0" cellspacing="0" cellpadding="0"
							style="line-height: 40px; margin: 0 auto;">
			 				<tr>
								<td>问卷名称</td>
								<td colspan="4"><input name="name" type="text"
									class="scinput" style="width: 400px;" id="name" value="${eduPaper.name}"/>&nbsp;
									<input type="checkbox" id="isforce" name="isforce" value="0" <c:if test="${eduPaper.isforce==0}">checked</c:if>/>是否强制执行</td>
									
							</tr>
							 <tr>
								<td width="84">开始时间:</td>
								<td width="260"> <input type="text" name="startDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onClick="WdatePicker()" value="${eduPaper.startDate}"></td>
								<td width="60">&nbsp;</td>
								<td>结束时间:</td>
								<td width="260"><input type="text" name="endDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onclick="WdatePicker()" value="${eduPaper.endDate}"/></td>
							</tr>
							 <tr>
								<td>备注：</td>
								<td colspan="4"><textarea name="note" id="note"
										style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;">${eduPaper.note}</textarea></td>
							</tr>
						</table>
			            <br />
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto;">
							<tr>
								<td><a href="javascript:savePaper();" class="dian3" id="savePaper">保 存</a></td>
								<td style="width: 30px;">&nbsp;</td>
								<td><a href="javascript:history.go(-1);" class="dian3" id="cancleSave">取 消</a></td>
							</tr>
						</table>
				</form>	
			</div>
		
			<div class="chauxnJS jsTool">
		          <span style="float:left;">
		          <!--<a href="peixun_1.1.1.html" class="huibtn_a  " style=" margin-left:6px">保存问卷</a>&nbsp; --> <a href="javascript:addQuestion(${eduPaper.id })" class="huibtn_a  " style=" margin-left:6px">增加问题</a>&nbsp; 
		    		<a href="<%=basePathHeader %>/edupm/paper/toUploadQuestions.htm?paperId=${eduPaper.id}&click=32" class="huibtn_a " style="margin-left: 6px">批量导入</a>
							
		          <a href="#" onclick="goback('${eduPaper.projectId}')" class="huibtn_a  " style=" margin-left:6px" id="back">返回</a>&nbsp;    	</span>
		  	</div>
		  	
			<table class="tablelist">
		      <thead>
		        <tr>
		          <th width="4%">序号</th>
		           
		          <th width="10%">问题</th>
		          <th width="3%">类型</th> 
				  <th width="10%">操作</th>
		        </tr>
		      </thead>
		      <tbody id="questionList">
		      </tbody>
		    </table>
	
	
		</div>
		 <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
		<!-- 分页 -->

</div>

</body>

</html>
