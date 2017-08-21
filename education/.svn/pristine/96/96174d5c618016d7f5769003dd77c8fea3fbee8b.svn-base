<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="project.person.pojo.EduUserActivty" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int roleId = ((EduUserActivty)session.getAttribute("userinfo")).getRoleId();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>报名教师</title>
<%@include file="../common/commonHead.jsp"%>
<%@include file="../common/commonAreaSelect.jsp" %>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/teacherComment.js"></script>
<script type="text/javascript">
var comparisonId = ${comparisonId};
</script>
</head>
	<style>
		 { border:1px solid #000000;  text-align: center;}
	</style>
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
							<input name="" id="toPage" onclick="queryTeacher();" type="button" class="sure1" value="查 询" />
						</li>
					</ul>
				</div> 
				
				<div class="chauxnJS jsTool">
					<span style="float: left;margin-left: 20px">
						<a href="javascript:window.location.href='<%=path %>/master/toManageComparison.htm'" >返回</a> 
					</span>
				</div>	
				
	    		<table class="tablelist" >
	      			<thead>
	       			    <tr>
					        <th width="8%">头像</th>
					        <th width="8%">姓名</th>
					        <th width="15%">身份证号</th>
					        <th width="10%">学段</th>
					        <th width="10%">学科</th>
					        <th width="15%">学校</th>
							<th width="8%">状态</th>
							<th width="8%">得分</th>
							<th width="18%">操作</th>
	        			</tr>
	      			</thead>
	      			<tbody id="proList1">
			
	     			 </tbody>
	    		</table>
	    	</div> 
	 	</div>
	 	<!-- 分页 -->
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
		
		<!-- 评审详情-->	
		<div class="tip2" style="width: 800px;margin-left: -80px" id = "detailTip">
<!-- 		<div id="detailModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" > -->
			<div class="tiptop">
				<span>教师评审/审核详情</span><a href="javascript:hideMe();"></a>
			</div>
		  	<div class="modal-body" style="margin-bottom: 10px" id="detailContent">
				<h4  style="padding:20px 0 20px 40px; ">教师详情：</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;" >
					<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">教师姓名：</td>
	          			<td width="180">
				         	<div class="vocation">
				         		<label id = "teacherNameDetail"></label>
				          	</div>
		          		</td>  
	          			<td width="80">报名时间：</td>
	          			<td width="180">
	          				<div class="vocation">
				         		<label id="createDate"></label>
				          	</div>
	          			</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">身份证号：</td>
	          			<td width="180">
				         	<div class="vocation">
				         		<label id="idNumber"></label>
				          	</div>
		          		</td>  
	          			<td width="80">提交人：</td>
	          			<td width="180">
	          				<div class="vocation">
				         		<label id="createBy"></label>
				          	</div>
	          			</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">学段：</td>
	          			<td width="180">
				         	<div class="vocation">
				         		<label id="sectionName"></label>
				          	</div>
		          		</td>  
	          			<td width="80">学科：</td>
	          			<td width="180">
	          				<div class="vocation">
				         		<label id="subjectName"></label>
				          	</div>
	          			</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">任教单位：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation">
				         		<label id="schoolName">朱迪</label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">参评备注：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation">
				         		<label id="memo"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">参评附件 ：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation">
				         		<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;width: 500px">
					        		<tbody id="files">

					        		</tbody>
		      					</table>	
				         	</div>
		          		</td>  
	        		</tr>
	      		</table>
<!-- 			</div> -->
<!-- 		  	<div class="modal-body" style="background-color:orange"> -->
				<h4  style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">审核详情：</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;" >
					<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80" >省级审核</td>
	            		<td width="200">&nbsp;</td>
	            		<td width="80">&nbsp;</td>
	            		<td width="180">&nbsp;</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核时间：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="provinceAuditDate"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核意见：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="provinceAuditMemo"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr><td width="80"><td  style="border-top:1px dashed #a7b5bc;" colspan="4"></td></tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80" >市级审核</td>
	            		<td width="200">&nbsp;</td>
	            		<td width="80">&nbsp;</td>
	            		<td width="180">&nbsp;</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核时间：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="cityAuditDate"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核意见：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="cityAuditMemo"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr><td width="80"><td  style="border-top:1px dashed #a7b5bc;" colspan="4"></td></tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80" >区县级审核</td>
	            		<td width="200">&nbsp;</td>
	            		<td width="80">&nbsp;</td>
	            		<td width="180">&nbsp;</td>
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核时间：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="districtAuditDate"></label>
				          	</div>
		          		</td>  
	        		</tr>
	        		<tr>
						<td width="80">&nbsp;</td>
	            		<td width="80">审核意见：</td>
	          			<td width="180" colspan="3">
				         	<div class="vocation" >
				         		<label id="districtAuditMemo"></label>
				          	</div>
		          		</td>  
	        		</tr>
	      		</table>
<!-- 		  	</div> -->
<!-- 		  	<div class="modal-body" style="background-color:gray"> -->
				<h4  style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">评审详情：</h4>
				<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;" id="judgeList" >
						
				</table>
			</div>
		  	<div class="modal-footer" />
</body>
</html>