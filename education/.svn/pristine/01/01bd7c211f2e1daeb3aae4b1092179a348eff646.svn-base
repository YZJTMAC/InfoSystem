<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="project.person.pojo.EduUserActivty" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int roleId = ((EduUserActivty)session.getAttribute("userinfo")).getRoleId();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>选择教师</title>
<%@include file="../common/commonHead.jsp"%>
<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript">
	var projectId = ${projectId};
	var areaId = ${areaId};
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_selectTeacherByAreaCXBMss.js"></script>
<%-- <script type="text/javascript" src="<%=basePathHeader%>/javascript/project/tree.js"></script> --%>

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
<!-- left END -->

<div class="content">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
     <li><a href="#">培训项目管理</a></li>
    <li><a href="#">培训名额上报</a></li>
	<li><a href="#">重新报名</a></li>
	
    </ul>
    </div>
    
    <div class="formbody">
      <div class="tabson">
	   <p class="xmTool">项目名称：<b>${name }</b>计划培训人数：<b>${planNum }</b>    地区:<b>${area }</b> </p>  
		<div style="float:center;">
	<ul class="seachform" id="seachform">
			<li>
				<label>
				     教师姓名：
				</label>
				<input name="input" type="text" value="" class="scinput" id="name" />
			</li>
			
			<li>
								<label>
									学科:
								</label>
								<input  type="text" value="" class="scinput" name="schoolTypeId"  id="schoolTypeId"/>
							</li>
			<li>
				<input name="" id="toPage" onclick="qryPro();" type="button" class="sure1" value="查 询" />
			</li>
		</ul>
	
	</div> 
	 <div style="width:30%; float:left;">
				<div style="width:180px; float:left;">
				 <ul id="treeDemo2" class="ztree"></ul>
				  
				   <ul id="treeDemo" class="ztree"></ul>
				   
					<span class="tabson">
						<div id="using_json"></div> </span>
				</div>

		</div>
		
	<div style="width:70%; float:left;">
	<% if(roleId == 4){	%>	 
	<a class="huibtn_a" href="javascript:bathSignUp()">批量报名</a>
	<% }%>
    <table class="tablelist" style="margin-top: 10px">
      <thead>
        <tr>
          <th width="3%"><input name="tids" type="checkbox" value=""/></th>
          <th width="4%">姓名</th>
          <th width="6%">身份证号</th>
          <th width="8%" >学科</th>
          <th width="5%">省</th>
          <th width="5%">市</th>
          <th width="5%">县</th>
          <th width="6%">校</th>
		  <th width="5%">手机</th>
		  <th width="6%">报名状态</th>
		  <th width="12%">操作</th>
        </tr>
      </thead>
      <tbody id="proList1">
		
      </tbody>
    </table>
     <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
      </div>
    </div> 
 </div>
 <!-- 页面隐藏域 -->
					<%--<input id="txtProvinceId" type="hidden"  />
					<input id="txtCityId" type="hidden"  />
					<input id="txtDistrictId" type="hidden"  />
					<input id="txtSchoolId" type="hidden"  />
					
					--%>
					
					<input id="txtSchoolType"  type="hidden"  />
					<input id="txtAreaLevel" type="hidden"  />
					<input id="txtAreaId" type="hidden"  />
<!-- 页面隐藏域 -->
  <%-- <div class="tip">
    	<div class="tiptop"><span>审核情况</span><a></a></div>
        
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin:0;">
       </div>
        <ul class="forminfo" style="padding:0; margin:0;">
     <li> 审核结果:未通过审核 
    </li>
	<li> 审核人:   王辉(第八中学学校管理员)
		 
    </li>
   
	  <li> 审核时间:2014-2-21 14:57
    </li>
	  <li> 审核意见:不需要参加此次培训 
    </li>
	
  
        </ul>
        
      </div>
        
        <div class="tipbtn">
        
        <input name="" type="button"  class="cancel" value="关闭" />
        </div>
    
    </div>--%>
    
    
    <div class="tip_vp" id="tip">
    	<div class="tiptop"><a href="javascript:hideMe();"></a></div>
        <p class="xmTool">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>以下教师不符合报名条件</b> </p>  
      <table class="tablelist" style=" width:440px;margin:20px;">
				<thead>
					<tr>
						<th>教师姓名</th>
						<th>身份证号码</th>
					</tr>
				</thead>
                
				<tbody id="orgStatus">
			</tbody>
			</table>
        <table width="130" style="margin:0 auto;">
        <tr>
					  <td width="130"><a href="javascript:hideMe();" class="sure dian3"/>确定</a></td>
					</tr>
        
        </table>
     </div>
</div> 

<div id="alertDiv" class="tip"  style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li >
			  		<h4 style="margin-left: 120px;" id="alertInfo">报名失败，请确认是否符合报名条件！</h4>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn"  style="margin-top: -130px;"> 
        	<input style="margin-left: 70px;"  type="button"  class="sure" value="确定" onclick="hideAlert();"/>&nbsp;
        </div>
</div>  
</body>
</html>