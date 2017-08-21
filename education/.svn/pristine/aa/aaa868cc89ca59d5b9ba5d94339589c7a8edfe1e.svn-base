<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息变更审核</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherInfoChangeAudit.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
	</div>
	
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/teacherLeft.jsp"%>
	</div>

	<div class="content">	
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="teacherGLY_1.1.html">教师信息</a></li>
			    <li>信息变更审核</li>
		    </ul>
	    </div>
    
    <div class="formbody">
		<div class="tabson">   
			<ul class="seachform" >
		    	<li>
		    		<label>审核状态：</label>
			    	<div class="vocation">
						<select class="select3" id="status">
						<option value="">请选择</option>
						<option value="11">未审核</option>
						<option value="13">审核通过</option>
						<option value="12">审核不通过</option>
						</select>
					</div>
				</li>
			    <li><label>身份证号：</label><input  type="text" class="scinput" id="idNo"/></li>
			    <li><label>姓名：</label><input type="text" class="scinput" id="name"/></li>
	        </ul>
	        <ul class="seachform">
	    		<li>
		    		<label>所在地区：</label>  
		    		<div class="vocation">
			   			<input readonly="readonly" id="area" class="scinput areaSelect" >
			   			<input type="hidden" id="areaId">
						<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
		    		</div>
	    		</li>
	
	    		<li><label>&nbsp;</label><input type="button" class="scbtn" value="查 询" onclick="qryChangeInfoList()"/></li>
	       </ul>
	   </div>   
      <div class="chauxnJS jsTool">
    	<span style="float:left;">
		    <a href="#" class="huibtn_a audit">批量审核</a>
			<%--<a href="#" class="huibtn_a">批量删除</a>--%>
		</span>
	
	
	<span style="float:right;">
    <div class="pagin" style="margin:0; width:180px;">
    <div class="message">共<i class="blue" id="totleCount">0</i>条记录</div> 
    <div class="vocation paginList" style=" margin:4px 6px 0 6px;right:0px;">
    <select id="pageSize" class="select3" style="width: 100px;">
	    <option value="100">每页显示100条</option>
	    <option value="300">每页显示300条</option>
	    <option value="500">每页显示500条</option>
    </select>
    </div>
    
    </div>
    </span>
	
    </div>
      <table class="tablelist">
    <thead>
    <tr>
    <th><input id="chk_all" type="checkbox" value=""/></th>
    <th>身份证号</th>
    <th>教师姓名</th>
    <th>性别</th>
    <th>所在地区</th>
    <th>申请人</th>
    <th>申请时间</th>
    <th>审核状态<i class="sort"><img src="<%=basePathHeader%>/images/px.gif" /></i></th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody id="records">
    
  
    </tbody>
    
    </table>
    
    <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
    </div> 
</div>
<%@include file="../common/commonAreaSelectForProject.jsp" %>


<div class="tip" style="width: 600px; height: 350px">
    	<div class="tiptop"><span>审核</span><a></a></div>
        
      <div class="tipinfo">
				<ul class="forminfo">

					<li>
						<label>
							是否通过：
						</label>
						<cite>
							<input name="status" class="no" type="radio" value="13" checked="checked" />审核通过&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="status" class="no" type="radio" value="12" />审核不通过
						</cite>
					</li>

					<li>
						<label>
							审核意见：
						</label>
						<textarea id="memo" name="" cols="" rows="" class="textinput" style="width: 300px"></textarea>
					</li>
				</ul>
			</div>
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="提交审核" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    <div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
</body>
</html>