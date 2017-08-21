<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改问题</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/questionValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectQuestionModify.js"></script>  
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select2").uedSelect({
		width : 167  
	});
})
</script>

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
			<li><a href="ssadmin.html">培训项目</a></li>

			<li>继教信息板块</li>
            <li>修改</li>
  </ul>
</div>

<div class="formbody">
<div class="tabson" id="txtBox">

<form id="questionForm">
<input type="hidden" id="proId" name="proId" value="${paper.projectId}"/>
<input type="hidden" id="paperId" name="paperId" value="${equ.paperId }"/>
<input type="hidden"  name="id" value="${equ.id }"/>
<input type="hidden" name="createDate" value="${equ.createDate}"/>
<input type="hidden" name="questionType"  id="questionType"/>
<input type="hidden" name="rank"  id="rank"/>
<input type="hidden" name="title"  id="title"/>
<input type="hidden" name="requiredAnswer"  id="requiredAnswer"/>
<input type="hidden" name="showStyle"  id="showStyle"/>
<input type="hidden" name="option1"  id="option1"/>
<input type="hidden" name="option2"  id="option2"/>
<input type="hidden" name="op1id"  id="op1id"/>
<input type="hidden" name="op2id"  id="op2id"/>
<input name="showStyle" id="showStyle1" type="hidden"  value="${equ.showStyle}"/>

		<table border="0" cellspacing="0" cellpadding="0"
				style="line-height: 40px; margin: 0 auto;">
				 	<tr>
					<td width="84">问题类型:：</td>
					<td width="260">
							<c:if  test="${equ.questionType==1}">
							<select  disabled="disabled" name="questionType" id="questionType1"class="select2">
						<!-- 		<option value="2">单选</option>
								<option value="3">多选</option> -->
								<option selected="selected" value="1">问答</option>
								<!-- <option value="0">填空</option> -->
							</select>
							</c:if>
							<c:if test="${equ.questionType==2}">
							<select name="questionType" id="questionType1"class="select2">
								<option selected="selected" value="2">单选</option>
							<!-- 	<option value="3">多选</option>
								<option value="1">问答</option>
								<option value="0">填空</option> -->
							</select>
							</c:if>
							
							<c:if test="${equ.questionType==3}">
							<select name="questionType" id="questionType1"class="select2">
								<!-- <option value="2">单选</option> -->
								<option selected="selected" value="3">多选</option>
								<!-- <option value="1">问答</option>
								<option value="0">填空</option> -->
							</select>
							</c:if>
							<c:if test="${equ.questionType==0}">
							<select disabled="disabled" name="questionType" id="questionType1"class="select2">
							<!-- 	<option value="2">单选</option>
								<option value="3">多选</option>
								<option value="1">问答</option> -->
								<option value="0" selected="selected">填空</option>
							</select>
							</c:if>
					</td>
					<td width="60">&nbsp;</td>
					<td>是否必填:</td>
					<td width="260">
						<c:if test="${equ.requiredAnswer=='Y'}">
							<input name="requiredAnswer1" id="requiredAnswer1" type="radio" value="Y" checked="checked"/>是 &nbsp;
							<input name="requiredAnswer1" id="requiredAnswer2" type="radio" value="N" />否　
						</c:if>
						<c:if test="${equ.requiredAnswer=='N'}">
							<input name="requiredAnswer2" id="requiredAnswer1" type="radio" value="Y"/>是 &nbsp;
							<input name="requiredAnswer2" id="requiredAnswer2" type="radio" value="N" checked="checked" />否　
						</c:if>
					</td>
				</tr> 
				
					<tr>
					<td>排序:</td>
					<td width="260"><input name="rank" id="rank1" type="text"
						class="scinput" value="${equ.rank }"/></td>
				</tr> 
				
				 
				 <tr>
					<td>题干：</td>
					<td colspan="4"><textarea maxlength="300" name="title1" id="title1"
							style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;">${equ.title }</textarea></td>
				</tr>
					 <tr>
					<td> </td>
					<td colspan="4">&nbsp;</td>
				</tr>
				   <c:forEach items="${oplist}" var="op" varStatus="status">
						<tr id="opt${status.index+1}">
						<td>选项${status.index+1}：</td>
						<td colspan="4"><input type="hidden" name="optionId" value="${op.id}"/>
							<textarea maxlength="200" id="tex${status.index+1}"  name="option" style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;">${op.content}</textarea></td>
						</tr>
				   </c:forEach>
			</table>

			<table border="0" cellspacing="0" cellpadding="0"
				style="margin: 0 auto;">
				<tr>
				<!-- <td><a href="#" id="addButton" class="dian3">加选项</a></td>
					<td style="width: 30px;">&nbsp;</td>
					<td><a href="#" id="subButton" class="dian3">减选项</a></td>
					<td style="width: 30px;">&nbsp;</td> -->
					<td><a href="javascript:saveQuestion()" class="dian3">保 存</a></td>
					<td style="width: 30px;">&nbsp;</td>
					<td><a href="#" onclick="goback('${equ.paperId}')" class="dian3">返 回</a></td>
				</tr>
			</table>
</form>
		</div>
</div>
<script>
	$(document).ready(function(){
		var qt = $("#questionType1").val();
		if(qt==0||qt==1){
			$("#opt1").hide();
			$("#addButton").hide();
			$("#subButton").hide();
		}
		
		
		$("#addButton").click(function(){
			var num=$("#topTable").find("tr").length;//获得表格行数
			num = num-3;//去掉表头前3行非选项信息
			var tr = "<tr><td>选项"+num+"：</td><td colspan='4'><textarea name='option'	style='width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;'></textarea></td></tr>";
			$("#topTable").append(tr);//向table中追加tr
		});
		$("#subButton").click(function(){
			var num=$("#topTable").find("tr").length;//获得表格行数
			var deleteNum = num-2;//要是删的行从0开始为第一行
			if(num==5){
				alert("至少保留一个选项吧，好不好");
				return;
			}
			$("#topTable tr:gt(0):eq("+deleteNum+")").remove();
		});
		
	});
	
	
	/**检查数据**/	
function check(){
	var objText = $("textarea[name='option']");
	var title = $("#title1").val();
	var str = /^[0-9]*[1-9][0-9]*$/;
	var opcount = $("#showStyle1").val();
	var order = $("#rank1").val();
	
	
	if(!str.test(opcount)||!str.test(order)){
		alert("选项数和排序必须为正数");
		return false;
	}
	
	if(title==""||title==null){
		alert("题干不能为空");
		return false;
	}
	
	for(var i=0;i<objText.size();i++){
		if(objText[i].value==""||objText[i].value==null){
 			alert("选项"+(i+1)+"不能为空");
 			return false;
 		}
 	}
 	
	return true;
}  
	
	
</script>
</body>

</html>
