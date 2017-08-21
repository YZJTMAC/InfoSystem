<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程设置</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
var projectId = <%=request.getParameter("proId")%>;
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectCommon.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectClassMgr.js"></script>

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
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">课程设置</a></li>
 
    </ul>
    </div>
     
    <div class="formbody">
      <div class="tabson">
        <p class="xmTool">项目名称：<b>${name}</b>计划培训人数：<b>${planNum}</b> </p>
        
         <ul class="seachform">
         <li>培训学科：</li>
  <li>
            
		<select  class="select8" style="z-index:1;" id="subject">
			<option value="0">请选择</option>
		</select>
          </li>
    <li>
            <label>课程名称：</label>
            <input id="className" type="text" class="scinput" />
          </li>
  <li><a href="javascript:qryClassList()" class="dian3">查 询</a></li>
           <li></li>
        </ul>
         <a href="javascript:showTip('addClass')" class="huibtn_a">添加新课程</a>
        <div> 
         <table class="tablelist" style="margin-top:12px;">
        <thead>
          <tr>
            <th width="20%">培训学科</th>
			<th width="20%">课程名称</th>
			<th width="20%">课程类型</th>
			<th width="20%">操作</th>
            <!-- <th width="20%">操作</th>-->
          </tr>
        </thead>
        <tbody id="classList"></tbody>
      </table>
       <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
		 </div>
      </div>
</div>  
</div>  
<!-- 添加课程 -->
<div class="tips_zb"  id="addClass">
	 <div class="tabson">
        <p class="xmTool" style="margin-left: 10px">项目名称：<b>${name}</b>计划培训人数：<b>${planNum}</b> </p>
    <ul class="seachform">
    	 <li><label>课程名称：</label></li>
            <li><input name="className" type="text" class="scinput"  style=" width:432px;"/></li>
    </ul>
    <ul class="seachform">
        <li><label>培训学科：</label></li>
 	 <li>
 	 <select  class="select2" name="subject" id="sub">
  	</select>
  	</li>
           <li> <label>课程类型：</label></li>
    <li> <select  class="select2" id="classTypeId">
    		<option value="0">必修</option>
    		<option value="1">选修</option>
    	</select>
    	</li>
        </ul>
   <ul class="seachform">
         
    <li><label>课程地址：</label></li>
            <li><input id="classUrl" type="text" class="scinput"  style=" width:432px;"/></li>
        </ul>
            <ul class="seachform" style="overflow: inherit">
         <li style="height:100%;"><label>课程介绍：</label></li>
            <li><textarea id="memo" name="memo" style="border:1px solid #ccc;-moz-border-radius: 5px; -webkit-border-radius: 5px;border-radius: 5px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc; width:432px;max-width:432px;height:260px; max-height:260px;"></textarea></li>
       </ul>
      <div class="clear"></div>  
     <ul class="seachform" style="padding-top:12px;">
         <li style="padding-left:150px;"><label>&nbsp;</label></li>
            <li></li>
         <li>
           <a href="javascript:createClass();" class="dian3">确定</a>  
          </li>
   <li>
         <a href="javascript:hideTip('addClass')" class="dian3">取消</a>
          </li>
    </ul>
  </div>
</div>
<!-- 添加课程 结束-->

<!-- 课程详情 -->
<div class="tips_zb" id="classInfo">
	 <div class="tabson">
	  <ul class="seachform">
    	 <li><label>课程名称：</label></li>
            <li><span id="className_info"></span></li>
    </ul>
    <ul class="seachform">
        <li><label>培训学科：</label></li>
 	 <li>
 	 <span id="classSubjectName_info"></span>
  	</li>
           <li> <label>课程类型：</label></li>
    	<li>
    	<span id="classType_info"></span>
    	</li>
        </ul>
           <ul class="seachform">
         
    <li><label>课程地址：</label></li>
            <li><span id="classUrl_info"></span></li>
        </ul>
            <ul class="seachform" style="overflow: inherit">
         <li style="height:100%;"><label>课程介绍：</label></li>
            <li><span id="memo_info"  style="border:1px solid #ccc;-moz-border-radius: 5px; -webkit-border-radius: 5px;border-radius: 5px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc; width:432px;max-width:432px;height:260px; max-height:260px;"></span></li>
       </ul>
      <div class="clear"></div>  
     <ul class="seachform" style="padding-top:12px;">
         <li style="padding-left:200px;"><label>&nbsp;</label></li>
            <li></li>
  		 <li>
         	<a href="javascript:hideTip('classInfo')" class="dian3">返回</a>
          </li>
    </ul>
  </div>
</div>
<!-- 课程详情 结束-->
</body>
</html>