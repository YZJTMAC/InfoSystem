<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>特殊情况查询与申报</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toSpecialCase.js"></script>
</head>

<body>
	<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="furtheredu" name="flag" />
			</jsp:include>
		</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/furthereduLeft.jsp"%>
	</div>
	
	<div class="content"> 
		<div class="place">
    		<span>位置：</span>
		    <ul class="placeul">
		    	<li><a href="#">继教信息</a></li>
		    	<li><a href="#">学分银行</a></li>
		    	<li><a href="#">特殊研修申报</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div class="tabson">
				<ul class="seachform">
		         	<li>
		            	<label>申请年度：</label>
		          	</li>
          			<li>
          	 			<select name="select" class="select3 yearpicker" id="queryYear" >
          	 				<option value="">请选择</option>
          				</select>  
          			</li>
			 		<li>
	            		<input name="input2" type="button" class="dian3" value="查 询" onclick="queryList();"/>
	          		</li>
         		</ul>
      		</div>
	      	<div class="chauxnJS jsTool">
				<span style="float: left;margin-left: 20px">
					<a onclick="depStudyAdd()">申报特殊情况</a> 
				</span>
			</div>
			<table class="tablelist" >
				<thead>
	          		<tr>
			            <th width="10%">年份</th>
			            <th width="30%">申报类型</th>
			            <th width="20%">培训类型</th>
			            <th width="10%">获得学分</th>
			            <th width="10%">审核状态</th>
			            <th width="10%">附件</th>
			            <th width="10%">操作</th>
	          		</tr>
	        	</thead>
	        	<tbody id="qrList">
	         		<!-- 显示数据 -->
	        	</tbody>
	      	</table>
	    </div> 
	</div>
	
	
	<!-- 查看借贷 -->
	<div class="tip">
		<div class="tiptop"><span>学分借贷</span><a href="javascript:disappear()"></a></div>
		<div class="tipinfo">
      		<div class="tipright"></div>
        	<ul class="seachform" >
				<li>
					<label>
						<font style="color: red">*</font>借贷年度：
					</label>
					<div class="vocation">
						<input type="text" id="yearView" class="scinput" readonly="readonly"/>
					</div>
				</li>
        	</ul>
        	<ul class="seachform" >
				<li>
					<label>
						<font style="color: red">*</font>借贷原因：
					</label>
					<div class="vocation">
						<input type="text" id="reasonView" class="scinput" readonly="readonly"/>
	        		</div>
				</li>
        	</ul>
        	<ul class="seachform" >
				<li>
					<label>
						<font style="color: red">*</font>培训类型：
					</label>
					<div class="vocation">
						<input type="hidden" id="trainFormId"/>
						<input type="text" id="trainFormName" class="scinput" readonly="readonly"/>
	        		</div>
				</li>
        	</ul>
        	<ul class="seachform" >
        		<li>
					<label>
						<font style="color: red">*</font>借贷学分：
					</label>
					<div class="vocation">
	        			<input type="text" class="scinput"  id="lendCredit" readonly="readonly"/>
	        		</div>
					<a id="lendCreditError" style="color: red"></a>
				</li>
        	</ul>
        	<ul class="seachform" >
        		<li style="display: none" id = "lendCreditRepay">
					<label>
						<font style="color: red">*</font>偿还学分：
					</label>
					<div class="vocation">
	        			<input type="text" class="scinput"  id="repayCredit" readonly="readonly"/>
	        		</div>
					<a id="trainTypeError" style="color: red"></a>
				</li>
        	</ul>
      	</div>
    </div>
    
	<!-- 项目附件上传模态框 -->	
	<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  		<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3 id="projectName2"></h3><label>自主研修申报附件</label>
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
<!-- 项目附件上传模态框结束 -->	
	<!-- 审核意见对话框开始-->	
	<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    	<h3 id="projectName9">审核意见</h3>
	  	</div>
	  	<div class="modal-body">
			<div id="reason"></div>
	  	</div>
	  	<div class="modal-footer">
	 		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  	</div>
	</div>
	<!-- 审核意见对话框结束-->	
</body>
</html>
