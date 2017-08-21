<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_projectAudit.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".click").click(function(){
  		$(".tip").fadeIn(200);
  	});
  	$(".tiptop a").click(function(){
  		$(".tip").fadeOut(200);
  	});
	$(".cancel").click(function(){
 		$(".tip").fadeOut(100);
 	});
 	
 	$(".select1").uedSelect( {
		width : 345
 	});
	$(".select2").uedSelect( {
		width : 167
	});
	$(".select3").uedSelect( {
		width : 100
	});
});
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目审核</title>
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
    <li><a href="#">培训项目</a></li>
    <li><a href="#">培训项目审核</a></li>
    <li>操作提示：项目申报成功后是待审核；审核通过之后，可以在培训项目申报-审批通过列表中查看该项目及项目附件，并可以往下分配培训名额。</li>
    </ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual">

		<div class="itab">
			<ul>
				<li>
					<a onclick="projectList1();" id="tab_1" href="#tab1" class="selected">待审核
					</a>
				</li>
				<li>
					<a onclick="projectList2();" id="tab_2" href="#tab2">审核通过
					</a>
				</li>
				<li>
					<a onclick="projectList3();" id="tab_3" href="#tab3">审核未通过
					</a>
				</li>
			</ul>
		</div>
					
        <div id="tab1" class="tabson">
       	<ul class="seachform">
			<li>
		            <label>项目名称：</label>
		            <input id="projectName1" type="text" class="scinput" />
		    </li>
		  	<li>
    			<label>
				项目年度：
					</label>
						<div class="vocation">
							<select class="select3 yearpicker" name="yearpicker" id="beginDate1">
								<option value="">请选择</option>
							</select>
							--
						</div>
			</li>
			<li>
						--
			</li>
			<li>
				<div class="vocation">
						<select class="select3 yearpicker" name="yearpicker" id="endDate1">
							<option value="">请选择</option>
						</select>
					</div>
					</li>
  			<li><a onclick="projectList1()" href="#" class="dian3">查 询</a></li>
        </ul>
      
      <table class="tablelist">
      <thead>
        <tr>
          <th width="30%">项目名称</th>
          <th width="5%">培训人数</th>
          <th width="15%">申报机构</th>
          <th width="10%">申报人</th>
          <th width="15%">申报时间</th>
		  <th width="10%">状态</th>
		  
          <th width="25%">操作</th>
        </tr>
      </thead>
      <tbody id="proList1">
		
      </tbody>
    </table>
    </div>
    
    
    <div id="tab2" class="tabson" style="display: none;">
       <ul class="seachform">
  			<li>
            <label>项目名称：</label>
            <input id="projectName2" type="text" class="scinput" />
            </li>
  			<li>
    			<label>
				项目年度：
					</label>
						<div class="vocation">
							<select class="select3 yearpicker" name="yearpicker" id="beginDate2">
								<option value="">请选择</option>
							</select>
							--
						</div>
				</li>
			<li>
						--
			</li>
			<li>
				<div class="vocation">
						<select class="select3 yearpicker" name="yearpicker" id="endDate2">
							<option value="">请选择</option>
						</select>
					</div>
			</li>
  			<li><a onclick="projectList2()" href="#" class="dian3">查 询</a></li>
           
        </ul>
      
      <table class="tablelist">
      <thead>
        <tr>
          <th width="35%">项目名称</th>
          <th width="5%">培训人数</th>
          <th width="15%">申报机构</th>
          <th width="10%">申报人</th>
          <th width="15%">申报时间</th>
		  <th width="10%">状态</th>
		  
          <th width="20%">操作</th>
        </tr>
      </thead>
      <tbody id="proList2">
		
      </tbody>
    </table>
    </div>
    
    
    <div id="tab3" class="tabson" style="display: none;">
    	<ul class="seachform">
  			<li>
	            <label>项目名称：</label>
	            <input id="projectName3" type="text" class="scinput" />
          	</li>
  			<li>
    			<label>
				项目年度：
					</label>
						<div class="vocation">
					<select class="select3 yearpicker" name="yearpicker" id="beginDate3">
						<option value="">请选择</option>
					</select>
							--
						</div>
			</li>
			<li>
						--
			</li>
			<li>
				<div class="vocation">
						<select class="select3 yearpicker" name="yearpicker" id="endDate3">
							<option value="">请选择</option>
						</select>
					</div>
					</li>
			<li><a onclick="projectList3()" href="#" class="dian3">查 询</a></li>
           
        </ul>
      
      <table class="tablelist">
      <thead>
        <tr>
          <th width="35%">项目名称</th>
          <th width="5%">培训人数</th>
          <th width="15%">申报机构</th>
          <th width="10%">申报人</th>
          <th width="15%">申报时间</th>
		  <th width="10%">状态</th>
		  
          <th width="20%">操作</th>
        </tr>
      </thead>
      <tbody id="proList3">
		
      </tbody>
    </table>
    </div>
    <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	</div>
	
<!-- 	<div class="tip" id="tip">
    <div class="tiptop"><span id="showProjectName">培训项目审核</span><a href= "javascript:$('#tip').hidde()"></a></div>
        
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin:0;">
       </div>
        <ul class="forminfo" style="padding:0; margin:0;">
		 <li>
		<div class="vocation">
			审核状态: 
			<input type="radio" name="radio"  value="1" checked="checked"/>审核通过  
    		<input type="radio" name="radio"  value="0" />审核失败
		</div>
    </li>
     <li>
		<div class="vocation">
			审核意见: <textarea id="memo" cols="" rows="" class="textinput" style="width:260px; height:30px;"></textarea>
		</div>
    </li>
    
        </ul>
        
      </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="保存" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
     -->
    
    <!-- 培训项目审核模态对话框开始-->	
	<div id="auditModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="projectName10"></h3>
	  </div>
	  <div class="modal-body">
			<ul class="forminfo" style="padding:0; margin:0;">
			 <li>
			<div class="vocation">
				审核状态: 
				<input type="radio" name="radio"  value="1" checked="checked"/>审核通过  
	    		<input type="radio" name="radio"  value="0" />审核不通过
			</div>
	    </li>
	     <li>
			<div class="vocation">
				审核意见: <textarea id="memo" cols="" rows="" class="textinput" style="width:260px; height:30px;"></textarea>
			</div>
	    </li>
	    
	        </ul>
	  </div>
	  <div class="modal-footer">
	 	<input  type="button"  class="sure" value="保存" />&nbsp;
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	 <!-- 培训项目审核模态对话框结束 -->	
 
    </div>
    
	<!-- 审核意见对话框开始-->	
	<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="projectName9">培训项目审核</h3>
	  </div>
	  <div class="modal-body">
			<div id="reason"></div>
	  </div>
	  <div class="modal-footer">
	 	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	<!-- 审核意见模态对话框结束 -->
    
   
    <!-- 查看项目申报书的模态对话框开始-->	
	<div id="viewFiles" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="projectName11"></h3>
	  </div>
	  <div class="modal-body">
			<table id="viewTable" class="table table-hover table-condensed"></table>
	  </div>
	  <div class="modal-footer">
	  	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	<!-- 查看项目申报书的模态对话框结束 -->	
    
    
    <script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
</body>
</html>