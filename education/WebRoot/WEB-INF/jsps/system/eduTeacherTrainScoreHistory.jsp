<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/eduTeacherTrainScoreHistory.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>培训信息导入历史纪录</title>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="furtheredu" name="flag"/>
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
			<li><a href="jixuMegGLY_2.2.html">继教信息管理</a></li>
			<li>学分信息汇总</li>
			<li><label>&nbsp;</label>
    		</li>
		</ul>
	</div>    
    <div class="formbody">
	<ul>
	    <li>
	    <label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;
	    </li>
	</ul>

   <div class="chauxnJS jsTool" style="display:block;">
	   <span style="float:left;">
	   		<a href="<%=basePathHeader%>/sys/importTeacherTrain.htm?click=22" class="huibtn_a" style="margin-right:18px;">导入学员</a>&nbsp;
	   		<a href="javascript:void(0);" class="huibtn_a" onclick="toTrainScorePage();" style="margin-right:18px;">培训学员查询</a>
	   </span>
	   <span style="float:right;">
	   </span>
	    	
   </div>

    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="10%">操作时间</th>
        <th width="10%">操作人</th>
        <th width="15%">操作地区</th>
        <th width="5%">导入记录</th>
        <th width="7%">操作</th>
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
</body>
</html>