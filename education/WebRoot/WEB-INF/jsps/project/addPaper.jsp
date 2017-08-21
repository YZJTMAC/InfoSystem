<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加调查问卷</title>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/paperValidate.js"></script>  
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectPaperAdd.js"></script>
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
				<form id="paperForm">
				<input type="hidden" id="projectId" name="projectId" value="<%=request.getAttribute("proId") %>"/>
				<input type="hidden" id="username" name="username" value="<%=request.getAttribute("username") %>"/>
				<input type="hidden" id="attendedNum" name="attendedNum" value="0"/>
				<input type="hidden" id="status" name="status" value="0"/>
				<input name="areaId" type="hidden" value="1"/>
				<input name="subjectId" type="hidden" value="1"/>

				<table border="0" cellspacing="0" cellpadding="0" style="line-height: 40px; margin: 0 auto;">
	 				<tr>
						<td>问卷名称</td>
						<td colspan="4"><input name="name" type="text"
							class="scinput" style="width: 400px;" id="name"/> &nbsp;
							<input type="checkbox" id="isforce" name="isforce" value="0"/>是否强制执行</td>
					</tr>
	<!-- 
						<tr>
						<td width="84">地区:</td>
						<td width="260">  <input name="areaId" type="text" class="scinput" id="areaId" colspan="4" value="1"/>
	          <input name="input2" type="button" value="选 择"  class="btnXuan"/> </td>
						<td width="60">&nbsp;</td>
						<td>学科:</td>
						<td width="260"> <input name="subjectId" class="scinput" readonly="readonly" value="1"/>
	          <input name="input2" type="button" value="选 择" class="btnXuan" onclick="showS();"/> </td>
					</tr> -->
					<tr>
						<td width="84">开始时间:</td>
						<td width="260"> <input type="text" name="startDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onClick="WdatePicker()" /></td>
						<td width="60">&nbsp;</td>
						<td>结束时间:</td>
						<td width="260"><input type="text" name="endDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onclick="WdatePicker()" /></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td colspan="4"><textarea name="note" id="note"
								style="width: 600px; height: 100px; max-width: 600px; border: 1px solid #ccc; border-color: #a7b5bc #ced9df #ced9df #a7b5bc;"></textarea></td>
					</tr>
				</table>
	            <br/>
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

		<!-- <div class="chuang" id="chuang" style="display: none;">
			<span style="text-align: right; padding: 10px 10px 0 0;"><a
				href="#" title="关闭窗口" id="closed"><img src="images/guanbi.gif"
					width="16" height="16" /></a></span>
			<table border="0" cellspacing="0" cellpadding="0"
				style="margin: 20px auto 0 auto; line-height: 42px;">
				<tr>
					<td width="40">&nbsp;</td>
					<td width="138"><input type="checkbox" name="checkbox"
						id="checkbox" /> 教师网</td>
					<td width="138"><input type="checkbox" name="checkbox2"
						id="checkbox2" /> 果实网</td>
					<td width="138"><input type="checkbox" name="checkbox3"
						id="checkbox3" /> 继教网</td>
					<td width="40">&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan="3"><table border="0" cellspacing="0"
							cellpadding="0" style="margin: 0 auto;">
							<tr>
								<td width="111"><a href="javascript:;" class="dian1"
									id="baocun">保 存</a></td>
								<td width="40">&nbsp;</td>
								<td width="111"><a href="javascript:history.go(-1);" class="dian2"
									id="quxiao">取 消</a></td>
							</tr>
						</table></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<div class="black" style="display: none;" id="black"></div> -->
		<div class="kuang" style="width:auto;">
			<b>[说明]：</b>操作提示: 问卷状态,创建时默认设为"未启动＂.<br/><br/>
		</div>

</div>
</div>

<!-- 选择学段学科 -->    
<!-- <div class="tip" id="XDshow" style="display:none;width: 600px;height: 600px">
    <div class="tiptop"><span>选择学段/学科</span><a href="javascript:hideMe();"></a></div>
    <div style="position: absolute;margin-left: 20px;width: 560px;margin-top: 2%">
    已选：
    	  <ol class="xuanDQ">
		    <li id="hasSelected"></li>
		    <li style="float:right"><a href="###" onclick="lastSure();" class="souXX">确 定</a></li>
	  </ol>
    </div>
    
      <div style="width: 100px;position: absolute;margin-top: 15%;margin-left: 20px;width: 100%">
      学段：
        <table style="width:100%;margin-top: 5px">
        	<tbody id="section">
      		</tbody>
        </table>
      </div>
      
      <div style="margin-left: 20px;position: absolute;margin-top: 25%;width: 560px;background-color:#E5E5E5;height: 65%" >
      
      	<table  style="width: 100%;margin-top: 10px;" cellpadding="0" cellspacing="0">
      		<tbody id="subject">
      		</tbody>
      	</table>
      </div>
  </div> -->
</body>
<!-- <script>
	window.onload = function() {
		var chuang = document.getElementById('chuang')
		var black = document.getElementById('black')
		var btn = document.getElementById('xz')
		var closed = document.getElementById('closed')
		var txtBox = document.getElementById('txtBox')
		var baocun = document.getElementById('baocun')
		var quxiao = document.getElementById('quxiao')

		btn.onclick = function() {
			openDiv();
		}
		closed.onclick = baocun.onclick = quxiao.onclick = function() {
			closedDiv();
		}
		function openDiv() {
			chuang.style.display = 'block';
			black.style.display = 'block';
			txtBox.style.display = 'none';
		}
		function closedDiv() {
			chuang.style.display = 'none';
			black.style.display = 'none';
			txtBox.style.display = 'block';
		}
	}
</script> -->
</html>
