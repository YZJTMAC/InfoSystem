<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训结果审核</title> 
<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />	
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/teacherTrainModify.js"></script>
<style type="text/css">
	.tipbox{margin:0 auto;width:225px;line-height:35px;}
</style>
</head>
<body>

	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="project" name="flag" />
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
				<li><a href="#">培训项目</a>
				</li>
				<li><a href="#">培训结果审核</a>
				</li>
				<li><a href="#">审核</a>
				</li>
			</ul>
		</div>
		<div class="formbody" style="overflow:hidden;">
			<ul class="seachform">
				<li>
					<p class="xmTool">
						项目名称：<b id="pname"> </b>
					</p>
				</li>

				<li>
					<label>教师姓名：</label> <input id="txtTeacherName" name="input" type="text" class="scinput" />
				</li>
				<li><input id="select" name="input2" type="button" class="dian3" value="查 询" />
				</li>
			</ul>

			<div style="width:30%; float:left;">
				<div style="width:180px; float:left;">
				 <ul id="treeDemo2" class="ztree"></ul>
				  
				   <ul id="treeDemo" class="ztree"></ul>
				   
					<span class="tabson">
						<div id="using_json"></div> </span>
				</div>
			</div>

			<div style="width:70%; float:left;">
				<div class="tabson">
					<!-- <div class="chauxnJS jsTool">
						<span style="float:left;"> 
							<a href="javascript:history.back();" class="huibtn_a" style=" margin-left:6px">返回</a>
						</span> 
						<span style="float:right;"></span>
					</div> -->

					<div class="chauxnJS jsTool">
				          <span style="float:left;">
					          <a href="javascript:showBatchAuditBox(1);" class="huibtn_a" style="margin-left:6px">批量审核</a>&nbsp;  
					          <a href="javascript:showBatchAuditBox(2);" class="huibtn_a" style="margin-left:6px">全部审核</a>&nbsp; 
				          </span>
				  	</div>
				  	
					<table class="tablelist">
						<thead>
							<tr>
								<th width="5%"><input type="checkbox" id="all"/></th>
								<th width="15%">姓名</th>
								<th width="30%">学校</th>
								<th width="10%">成绩</th>
								<th width="10%">学时</th>
								<th width="10%">培训等级</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody id="target">
						</tbody>
					</table>
				
					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<input id="sizePerPage" type="hidden" value="20" name="sizePerPage" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>
			
			<!-- 审核框 -->
			<div class="tip" style="margin-top:10px;">
				<input type="hidden" id="projectId" value="" />
				<input type="hidden" id="procommentId" value="" />
    			<div class="tiptop"><span>审核</span></div>
		    	<div class="tipbox">
		    		<span>
		    			<input type="radio" value="2" name="trainStatus"/> 优秀 
		    		</span>
		    		<span>
		    			<input type="radio" value="3" name="trainStatus" /> 良好 
		    		</span>
		    		<span>
		    			<input type="radio" value="1" name="trainStatus" checked="checked"/> 合格
		    		</span>
		    		<span>
		    			<input type="radio" value="0" name="trainStatus"/> 不合格 
		    		</span>
		    	</div>
				
		        <table width="230" style="margin:15px auto 10px auto;">
		        	<tr>
					  <td width="130"><a id="save" href="#" class="sure dian3"/>保存</a></td>
		              <td width="15">&nbsp;</td>
					  <td width="130"><a href="#" id="cancel" class="sure dian3"/>取消</a></td>
					</tr>
		        </table>
        	</div>
			<!-- 审核框 -->
		</div>
	</div>

	<!-- 页面隐藏域 -->
	<input id="txtProvinceId" type="hidden"  />
	<input id="txtCityId" type="hidden"  />
	<input id="txtDistrictId" type="hidden"  />
	<input id="txtSchoolId" type="hidden"  />
	
	<input id="txtSchoolType"  type="hidden"  />
	
	<input id="txtAreaLevel" type="hidden"  />
	<input id="txtAreaId" type="hidden"  />
	<!-- 页面隐藏域 -->
</body>
</html>
