<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>培训项目启动</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_startProject.js"></script>

<script type="text/javascript">
$(document).ready(function(e) {
	$(".select3").uedSelect({
		width : 100
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
				<li>培训项目</li>
				<li><a href="ssadmin.html">培训项目启动</a></li>
				<li>操作说明：启动之后说明项目在实施进行中。</li>
			</ul>
	</div>
	
	<div class="formbody">
	
		<div class="itab">
			<ul>
				<li><a href="#tab1" id="tabPage0" class="selected">未启动项目<span class="ctype"></span></a></li>
				<li><a href="#tab2" id="tabPage1">已启动项目<span class="ctype"></span> </a></li>
			</ul>
		</div>	
		<div class="tabson">
	        <ul class="seachform">
	        <li>
	            <label>项目名称：</label>
	            <input name="input" type="text" class="scinput" id="projectName"/>
	          </li>
	         <li>
	            <label>项目年度：</label>
	             <div class="vocation"><select  class="select3 yearpicker" name="yearpicker" id="beginDate">
	             	<option value = "">请选择</option>
	             </select> -- 
				 </div>
	          </li>
			  <li>--</li>
			   <li>
	            <div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate">
	             	<option value = "">请选择</option>
	             </select>  
				 </div> 
	          </li>
				
			 
	           <li><a href="javascript:projectList();" class="dian3">查 询</a></li>
	           
	        </ul>
	    </div>
	
		<table class="tablelist">
			<thead>
				<tr>
					<th  width="30%">项目名称</th>
					<th >开始时间</th>
				 	<th >结束时间</th>
                    <th >项目性质</th>
                    <th >创建人</th>
                    <th >实施机构</th>
                    <th >申报人</th>
                    <th >计划人数</th>
                    <th >报名人数 </th>
                    <th >审核人</th>
                    <th >审核通过人数</th>
					<th >操作</th>
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
	
	<div class="tip" id="tip">
			<input type="hidden" name="roleId" type="text" value="${userinfo.roleId }" >
	    	<div class="tiptop"><span id="proName">项目名称：XXXXX培训项目</span><a href="javascript:hideMe();"></a></div>
	        <p class="xmTool">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>提示：远程培训或混合培训项目启动前可先设置对接地址</b> </p>  
	      	<table class="tablelist" style=" width:440px;margin:20px;">
					<thead>
						<tr>
							<th>实施机构</th>
							<th>准备状态</th>
						</tr>
					</thead>
	                
					<tbody id="orgStatus">
					</tbody>
			</table>
	        <table width="230" style="margin:0 auto;">
	        	<tr>
				  <td width="130"><a href="javascript:start();" class="sure dian3"/>启动项目</a></td>
                     <td width="15">&nbsp;</td>
				  <td width="130"><a href="javascript:hideMe();" class="sure dian3"/>取消</a></td>
				</tr>
	        </table>
	     </div>
	</div>	
</body>
</html>