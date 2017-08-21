<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="../../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训总结</title>
<link href="<%=basePathHeader%>/style/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet" type="text/css" />
<link href="<%=basePathHeader%>/javascript/jqplot/jquery.jqplot.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePathHeader%>/style/jquery.treeview.css" />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/chengPeiSummaryList.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.js"></script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.json-2.4.min.js" ></script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.alertWindow.min.js" ></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/select-ui.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/page.commons.js"></script>
<script language="javascript" type="text/javascript"src="<%=basePathHeader%>/javascript/common/ajaxfileupload.js"></script>
<script language="javascript" type="text/javascript"src="<%=basePathHeader%>/javascript/common/commonUploadFile.js"></script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>

</head>

<body>
<!-- top -->
	<div class="head">
		<jsp:include page="../../common/top.jsp" >
			<jsp:param value="project" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../../common/projectLeft.jsp"%>
	</div>
	
	<div class="content">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">项目总结</a></li>
    </ul>
    </div>
    
    <div class="formbody"style="width: 97%">
    
    

      <div class="tabson">
    
           <ul class="seachform">
  <li>
            <label>项目名称：</label>
            <input name="input" id="projectName" name="projectName"  type="text" class="scinput" />
          </li>
 <li>
            <label>项目年度：</label>
             <div class="vocation"><select class="select3 yearpicker" name="startTime" id="startTime"></select> -- 
			 </div>
          </li>
		  <li>--</li>
		   <li>
            <div class="vocation">   <select class="select3 yearpicker" name="endTime" id="endTime"></select>  
			 </div> 
          </li>
  <li><a href="#" onclick="selectCloseProjectList()" class="dian3">查 询</a></li>
           
        </ul>
    
      </div><table class="tablelist">
      <thead>
        <tr>
          <th width="20%">项目名称</th>
          <th width="30%">开始时间</th>
          <th width="20%">结束时间</th>
          <th width="30%">操作</th>
        </tr>
      </thead>
      <tbody id="summaryList">
      </tbody>
    </table>
     <!-- 分页 -->
    <INPUT id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
	<INPUT id="pageIndex" value="1" type="hidden" name="pageIndex" />
	<div id="pagebar" class="pagin">	
	</div>
   <!-- 分页 --> 
    <div class="tip" style="height:500px;z-index: 1">
    	<div class="tiptop"><span><d class="ctype"></d>我的培训总结</span><span>&nbsp;&nbsp;</span><a></a></div>
        
      <div class="tipinfo" style="width:470px; height:360px;padding:10px; margin:0;">
        <ul class="forminfo" style="padding:0; margin:0;">
		  <li><label>标题：</label><cite><input id="summaryTitle" name="summaryTitle" type="text" class="scinput" value="" /></cite></li>
		<li><label><d class="ctype"></d>总结：</label>
		<div class="vocation" style="padding-right:8px;">
			<textarea id="summaryContent" name="summaryContent" cols="" rows="" class="textinput" style="width:260px; height:270px;overflow-y:auto"></textarea></div></li>
		  <li><label>附件：</label><cite id="cite"><a id="download" href="#"></a><a id="delete" href="#"></a></cite></li>
		</ul>
      </div>
      <div class="tipbtn">
		<span class="sl-custom-file"> 
			<input id="summaryId" type="hidden" class="btn" value="" />
			<input id="pid" type="hidden" class="btn" value="" />
			<input id="isChange" type="hidden" class="btn" value="" />
			<input name="attchment" type="button" class="btn" value="上传附件" />
			<input id="attchmentPath" type="file" onchange="check()" name="attchmentPath" class="ui-input-file"/>&nbsp;&nbsp; 
		</span>
		<input name="" type="button"  class="sure" value="保存" />	
       </div>
    </div>
    </div>
</div>
</body>
</html>
