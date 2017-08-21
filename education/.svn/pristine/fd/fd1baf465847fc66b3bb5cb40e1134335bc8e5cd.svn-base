<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师成绩审核</title> 
<link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />	
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/teacherListForAudites.js"></script>
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
				<li><a href="#">成绩审核</a>
				</li>
				<li><a href="#">成绩审核</a>
				</li>
				<li><a href="#">审核</a>
				</li>
			</ul>
		</div>
		<div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:</p>
		</div>

<!-- <div class="content_wrap">
	<div class="zTreeDemoBackground left">
		  <ul id="treeDemo2" class="ztree"></ul>
	</div>
	<div class="right">
		 
	</div>
</div> -->
		<div class="formbody" style="overflow:hidden;">

			<ul class="seachform">
				<li>

					<p class="xmTool">
						项目名称：<b id="pname"> </b>
					</p></li>

				<li><label>教师姓名：</label> <input id="txtTeacherName"
					name="input" type="text" class="scinput" /></li>
				<li><input id="select" name="input2" type="button"
					class="dian3" value="查 询" /></li>


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
					<div class="chauxnJS jsTool">
						<span style="float:left;"> <a
							href="javascript:history.back();" class="huibtn_a  "
							style=" margin-left:6px">返回</a> </span> <span style="float:right;">
							  </span>
					</div>
					
					<div class="chauxnJS jsTool">
				          <span style="float:left;">
				          <a href="javascript:showForBatch(1);" class="huibtn_a  " style=" margin-left:6px">批量审核</a>&nbsp;  
				          <a href="javascript:showForBatch(2);" class="huibtn_a  " style=" margin-left:6px">全部审核</a>&nbsp; 
				          <a href="javascript:batchCancelAudit(3);" class="huibtn_a  " style=" margin-left:6px">批量取消审核</a>&nbsp;  
				          <a href="javascript:cancelAuditAll();" class="huibtn_a  " style=" margin-left:6px">全部取消审核</a>&nbsp; 	</span>
				  	</div>

					<table class="tablelist">
						<thead>
							<tr>
                                <th width="10%"><input type="checkbox"   id="all"/></th>
								<th width="10%">姓名</th>
								<th width="4%">性别</th>
								<th width="20%">学校</th>

								<th width="6%">成绩</th>
								<th width="6%">学时</th>
								<th width="6%">审核状态</th>
								<th width="6%">操作</th>
							</tr>
						</thead>
						<tbody id="target">
						</tbody>
					</table>			
                    <!-- 分页 -->
						<input id="sizePerPage" type="hidden" value="20" name="sizePerPage" />
						<input id="pageIndex" value="0" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>




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
				
				<input id="commentId" type="hidden"/>
				<input id="pid" type="hidden"/>	
				
				<!-- 审核框 -->
				<div class="tips_zb_1"  >
				    	<div class="tiptop"><span>审核</span></div>
				      <div class="tipinfo">
				      <div class="tipright" style="padding:0; margin-left:20;"> </div>
				        <ul class="forminfo" style="padding:0; margin:0;">
						 <li>
						<div class="vocation">
							 <input type="radio" name="radio"  value="1" checked="checked"/>
				    		审核通过
						</div>
				    </li>
				     <li>
						<div class="vocation">
							 <input type="radio" name="radio" value="2" />
				    		审核不通过
						</div>
				    </li>
				    <li style="height:100%;"><label>审核意见：</label></li>
				            <li><textarea id="opinion"  style="border:1px solid #ccc;-moz-border-radius: 5px; -webkit-border-radius: 5px;border-radius: 5px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc; width:452px;max-width:452px;height:160px; max-height:160px;"></textarea></li>
				        </ul>
				      </div>
				      <div class="clear"></div>  
				        <ul class="seachform" style="padding-top:80px;">
				        <li style="padding-left:120px;"><label>&nbsp;</label></li>
				        <li><input name="" type="button"  class="dian3 sure" value="保存" /></li>
				        <li><input name="" type="button"  class="dian3 cancel" value="取消"  /></li>
				        </ul>
				</div>

</body>
</html>
