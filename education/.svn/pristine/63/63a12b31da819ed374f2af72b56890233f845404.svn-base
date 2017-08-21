<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加问题</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/questionValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectQuestionAdd.js"></script>  
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select2").uedSelect({
		width : 167  
	});
});
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
            <li>添加</li>
	  	</ul>
	</div>

<div class="formbody">
<div class="tabson" id="txtBox">

<form id="questionForm" onsubmit="return check();" method="post"  action="<%=path %>/edupm/paper/AddQuestion.do">
<input type="hidden" id="proId" name="proId" value="${eduPaper.projectId}"/>
<input type="hidden" id="paperId" name="paperId" value="${eduPaper.id}"/>
<input type="hidden" name="username"  value="${username}"/>
<input type="hidden" name="sta"  value="0"/>
<input type="hidden" name="createDate"/>
<input name="showStyle" id="showStyle1" type="hidden" value="2" />
		<table id="topTable" border="0" cellspacing="0" cellpadding="0"
				style="line-height: 40px; margin: 0 auto;">
				 	<tr>
					<td width="84">问题类型:：</td>
					<td width="260">
						<select onchange="hideObj(this.value)" name="questionType" id="questionType1"class="select2">
							<option value="2">单选</option>
							<option value="3">多选</option>
							<option value="1">问答</option>
			<!-- 				<option value="0">填空</option> -->
						</select> 
					</td>
					<td width="60">&nbsp;</td>
					<td>是否必填:：</td>
					<td width="260">
						<input name="requiredAnswer" type="radio" value="Y" checked="checked"/>是 &nbsp;
						<input name="requiredAnswer" type="radio" value="N" />否
					</td>
				</tr> 
				
					<tr>
					<td>排序:</td>
					<td width="260"><input name="rank" id="rank1" type="text"
						class="scinput" value="1"/></td>
				</tr> 
				
				 
				 <tr>
					<td>题干：</td>
					<td colspan="4"><textarea maxlength="300" name="title" id="title1"
							style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"></textarea></td>
				</tr>
					 <tr>
					<td> </td>
					<td colspan="4">&nbsp;</td>
				</tr>
				  <tr id="opt1">
					<td>选项１：</td>
					<td colspan="4"><textarea maxlength="200" id="tex1"  name="option"
							style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"></textarea>
					<br/>
					</td>
				</tr>
			</table>
			<table border="0" cellspacing="0" cellpadding="0"
				style="margin: 0 auto;">
				<tr>
					<td colspan="5"><br/></td>
				</tr>
				<tr>
				<td>
					
				<a href="#" id="addButton" class="dian3">加选项</a></td>
					<td style="width: 30px;">&nbsp;</td>
					<td><a href="#;" id="subButton" class="dian3">减选项</a></td>
					<td style="width: 30px;">&nbsp;</td>
					<td><input type="submit" class="dian3" value="保存" /> </td>
					<td style="width: 30px;">&nbsp;</td>
					<td><a href="#" onclick="goback(${eduPaper.id})" class="dian3">返 回</a></td>
				</tr>
			</table>
</form>	
		</div>

	

</div>
</div>
<script type="text/javascript">
	function hideObj(v){
		if(v==1||v==0){
			$("#tex1").val("");
			$("#opt1").hide();
			$(".opt2").hide();
			$("#addButton").hide();
			$("#subButton").hide();
		}else{
			$("#opt1").show();
			$(".opt2").remove();
			$("#addButton").show();
			$("#subButton").show();
		}
	}

	/* $(document).ready(function(){ */
	
		$("#addButton").click(function(){
			var num=$("#topTable").find("tr").length;//获得表格行数
			num = num-3;//去掉表头前3行非选项信息
			var tr = "<tr class='opt2'><td>选项"+num+"：</td><td colspan='4'><textarea name='option'	style='width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;'></textarea></td></tr>";
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
		
	/* }); */


	/**检查数据**/	
	function check(){
		var objText = $("textarea[name='title']");
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
