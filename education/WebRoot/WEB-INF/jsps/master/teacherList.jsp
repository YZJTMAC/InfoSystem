<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>教师列表</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp" %>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/teacherList.js"></script>
<script type="text/javascript">
var comparisonId = ${comparisonId};
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
	<!-- left END -->
	<div class="content">
		<div class="place">
	    	<span>位置：</span>
	    	<ul class="placeul">
	     		<li><a href="">XXXXX</a></li>
			    <li><a href="">XXXXX</a></li>
				<li><a href="">XXXXX</a></li>
		    </ul>
    	</div>
	    <div class="formbody">
			<div class="tabson">
		   		<p class="xmTool">评比活动：<b>${comparisonName }</b></p> 
		   		<div style="float:center;">
					<ul class="seachform" id="seachform">
						<li>
							<label>
								教师姓名：
							</label>
							<input name="input" type="text" value="" class="scinput" id="teacherName" />
						</li>
						<li>
							<input name="" id="toPage" onclick="qryPro();" type="button" class="sure1" value="查 询" />
						</li>
					</ul>
				</div> 
				
				<div class="chauxnJS jsTool">
					<span style="float: left;margin-left: 20px">
						<a onclick="javascript:window.history.back();">返回</a> 
					</span>
				</div>	
				
	    		<table class="tablelist" >
	      			<thead>
	       			    <tr>
					        <th width="8%">头像</th>
					        <th width="5%">姓名</th>
					        <th width="9%">身份证号</th>
					        <th width="5%">学段</th>
					        <th width="5%">学科</th>
					        <th width="8%">学校</th>
					        <th width="8%">电话</th>
							<th width="17%">备注</th>
							<th width="8%">状态</th>
							<th width="5%">附件</th>
							<!-- <th width="5%">得分</th> -->
							<th width="15%">操作</th>
	        			</tr>
	      			</thead>
	      			<tbody id="proList1">
			
	     			 </tbody>
	    		</table>
	    	</div> 
	 	</div>
	 	<!-- 分页 -->
	 		<input id="roleId" type="hidden" value="${sessionScope.userinfo.roleId}"  />
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
		<!-- 分页 -->
	</div> 
	<!-- 查看附件 -->	
	<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  		<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3 id="projectName2"></h3><label>附件</label>
  		</div>
  		<div class="modal-body">
    		<form id="declareForm" enctype="multipart/form-data" method="post">
			<input id="projectId" name="projectId" type="hidden" value="" />
				<input id="projectName3" name="projectName" type="hidden" value="" />
				<input id="type" name="type" type="hidden" value="declareTemplate" />
				<table id="hasUpload" class="table table-hover table-condensed"></table>
				<table id="noUpload" class="table"></table>
			</form>
 		</div>
 		<div class="modal-footer">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  		</div>
	</div>
	<!-- 查看附件结束 -->	
	<!-- 项目详情 -->
<!-- 	<div class="tip" style=" z-index: 1; width:500px"> -->
<!-- 		<div class="tiptop"> -->
<!-- 			<span>教师得分详情</span><a href="javascript:hideMe();"></a> -->
<!-- 		</div> -->
<!-- 		<div class="tabson"> -->
<!-- 			<table class="tablelist" style="margin-left: 20px;width: 460px"> -->
<!-- 	      		<thead> -->
<!-- 	       		    <tr> -->
<!-- 				        <th width="8%">专家</th> -->
<!-- 				        <th width="5%">分数</th> -->
<!-- 	        		</tr> -->
<!-- 	      		</thead> -->
<!-- 	      		<tbody id="proList2"> -->
		
<!-- 	    		 </tbody> -->
<!-- 	    	</table> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- 审核意见对话框开始-->	
		<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
			<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    	<h3 id="projectName9">审核意见</h3>
		  	</div>
		  	<div class="modal-body">
				<div id="provinceMemo"></div>
				<div id="cityMemo"></div>
				<div id="districtMemo"></div>
		  	</div>
		  	<div class="modal-footer">
		 		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		  	</div>
		</div>
		
		<!-- 评审详情	 -->
	<!-- 	<div id="judgeModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
			<div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    	<h3 id="projectName9">教师得分详情</h3>
		  	</div>
		  	<div class="modal-body">
				最终得分：<label  id="finalScore" ></label>
				<table class="tablelist">
	      		<thead>
	       		    <tr>
				        <th width="10%">专家</th>
				        <th width="10%">分数</th>
				        <th width="10%">评审时间</th>
				        <th width="70%">评审意见</th>
	        		</tr>
	      		</thead>
	      		<tbody id="proList2">
		
	    		 </tbody>
	    	</table>
		  	</div>
		  	<div class="modal-footer">
		 		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		  	</div>
		</div> -->
		<!-- 评审打分 -->
	<div class="tip">
		<div class="tiptop">
			<span>评审</span><a href="javascript:hideMe();"></a>
		</div>
		<div class="tipinfo" style="height:200px;margin-left: 25%;">
			<ul class="forminfo" style="padding:0; margin:0;">
				<li>
					<div class="vocation">
						教师：<input name="input" type="text" class="scinput"  id="teacherName1" disabled="disabled"/>
					</div>
				</li>
<!-- 				<li> -->
<!-- 					<div class="vocation"> -->
<!-- 						<span style="width:100px;height:25px;padding-top:5px;"><input type="radio" name="isPass" value="1" onclick="isPass(1)" checked="checked"/>通过</span> -->
<!-- 						<span style="width:110px;height:25px;padding-top:5px;"><input type="radio" name="isPass" value="0" onclick="isPass(0)"/>不通过</span> -->
<!-- 					</div> -->
<!-- 				</li> -->
				<li id="scoreBlock">
					<div class="vocation">
						审核:<input name="review" type="radio" value="pass" />通过
							<input name="review" type="radio" value="unPass" />不通过  
					</div>
				</li>
				<li id="momeBlock" style="margin-left: -25px">
					<div class="vocation">
							<label >评审 意见：</label>
							<textarea  cols="" rows=""
							style="width: 200px; border: #eee 1px solid; height: 100px; border-color: #a7b5bc #ced9df #ced9df #a7b5bc; -moz-border-radius: 5px; -webkit-border-radius: 5px; border-radius: 5px;margin-left: -25px"
							id="memo"></textarea>
					</div>
				</li>
			</ul>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确 认" onclick="judge();" />&nbsp; 
			<input name="" type="button" class="cancel" value="取消" onclick="hideMe();" />
		</div>
	</div>
</body>
</html>