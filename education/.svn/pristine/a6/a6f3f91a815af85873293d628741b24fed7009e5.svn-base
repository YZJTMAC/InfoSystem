<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看项目</title>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	var projectId = '<%=request.getParameter("projectId")%>';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgProjectInfo.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgProjectModify.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
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
	    		<li>承培项目管理</li>
				<li>设置项目</li>
	    	</ul>
    	</div>
		<div class="formbody">
						<div class="tabson" id="txtBox">
				<h4 style="padding: 0 0 20px 40px;">项目基本信息：</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
			      <tr>
					  <td>项目名称：</td>
					  <td id="projectName" colspan="4"></td>
				    </tr>
					<tr>
			            <td  width="84">项目年度：</td>
			          	<td id="year" width="260"></td>
			          	<td width="60">&nbsp;</td>
			          	<td>项目编号：</td>
			          	<td width="260" id="projectNo" >  </td>
			        </tr>
					<tr>
			          	<td>项目开始时间：</td>
			          	<td id="startDate"></td>
			          	<td>&nbsp;</td>
			          	<td>项目结束时间：</td>
			          	<td id="endDate"></td>
			        </tr>
			    </table>
				<h4 style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
					项目内容：
				</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
				  	<tr>
			            <td width="84">培训人数：</td>
			          	<td width="260"><div id="planNum" class="vocation"></div></td>
			          	<td width="60">&nbsp;</td>
			          	<td width="84"> </td>
			          	<td width="260"></td>
			        </tr>
			        <tr>
			          <td width="84">项目范围：</td>
			          <td id="projectScopeName" width="260"></td>
			          <td width="60">&nbsp;</td>
			          <td width="84">培训范围：</td>
			          <td id="trainScopeName" width="260"></td>
			        </tr>
			        <tr>
			          <td>项目性质：</td>
			          <td id="projectPropertyName"></td>
			          <td>&nbsp;</td>
			          <td>培训类型：</td>
			          <td id="trainTypeName"></td>
			        </tr>
			    </table>
			    <h4 style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
					项目培训对象：
				</h4>
				
				
				 <table border="0" cellpadding="0" cellspacing="0" style="line-height:42px; margin:0 auto;">
			        <tr> 
			          <td width="60">年级：</td>
			          <td id="gradeName" width="187"></td>
			          <td width="60">性别：</td>
			          <td id="sex" width="187"></td>
			          <td width="90">学历：</td>
			          <td id="educationBackgroundName" width="187"></td>
			        </tr>
			        <tr>
			           
			          <td>职务：</td>
			          <td id="positionName"></td>
			          <td>职称：</td>
			          <td id="professionalTitleName"></td>
			          <td>是否为班主任：</td>
			          <td><div id="isClassCharger" class="vocation"></div></td>
			        </tr>
			        <tr>
			           
			          <td>学科：</td>
			          <td id="subjectName"></td>
			          <td>学段：</td>
			          <td id="stdutySection"></td>
			          <td>是否收费：</td>
			          <td id="isFree"></td>
			        </tr>
			        <tr>
			          <td>是否审核&nbsp;</td>
			          <td id="mustAudit"></td>
			          <td>&nbsp;</td>
			          <td>&nbsp;</td> 
			          <td>收费标准：</td>
			          <td id="chargingStandard"></td>
			        </tr>
			    </table>
				<h4	style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
					项目说明：
				</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height: 40px; margin: 0 auto;">
					<tr>
						<td width="84">项目范围：</td>
						<td id="memo" width="400"></td>
					</tr>
					<tr>
						<td width="84">附件：</td>
						<td id="projectAttchement" width="260"></td>
					</tr>
				</table>
				<h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">继教信息：</h4>
			      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
			        <tr>
			          <td id="classPeriod" width="84">学时:</td>
			          <td id="classScore" width="400">学分:</td>
			        </tr>
			      </table>
	   			<h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">培训实施机构：</h4>
      			<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        			<tr>
          				<td id="orgName" width="84"></td>
        			</tr>
        			<tr>
          				<td width="84">培训平台地址：</td>
          				<td width="260"> <input id="trainingAddress" name="input4" type="text" class="scinput" style="width:571px;"/></td>
        			</tr>
      			</table>
	  		<table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
			  	<tr>
			    	<td><a id="save" href="###" class="dian3">保 存</a></td>
			    	<td style="width:30px;">&nbsp;</td>
			    	<td><a id="back" href="###" class="dian3">取 消</a></td>
			  	</tr>
			</table>
			</div>
		</div>
	</div>
	<input id="updateDate" type="hidden"/>
	<div class="black" style="display: none;" id="black"></div>
</body>
</html>
