<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>导入教师记录</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript">
	var historyId = <%=request.getParameter("id") %>
	var historyType = '<%=request.getParameter("historyType") %>';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/importTeacherList.js"></script>
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
    <li>教师信息</li>
    <li>教师信息管理</li>
    <li>导入历史记录</li>
    </ul>
    </div>
    
    <div class="formbody">
      <div class="tabson">   

<ul class="seachform" style="padding-left:23px;">
    
    <li><label>操作年度：</label>  
    <div class="vocation">
    <select class="select3" id="year" onchange="qryDate()">
    </select>
    </div>
    </li>
    <li><label>操作时间：</label>  
    <div class="vocation">
    <select class="select1" id="optDate">
    </select>
    </div>
    </li>
    
    
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="查 询" onclick="queryRecordsByDate();"/></li>
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="返 回" onclick="javascript:history.go(-1);"/></li>
    
    </ul>
    
   </div>
   
    
    
    <div class="kuang" style="width:auto;">本次导入情况：
	<span id="fileNames"></span>
	<p id="okCount"></p>
	<span id="failCount" style="float:left;"></span><span style="float:left;" id="url"></span>
	<div style="clear:both"></div>
	</div>
    <div class="" style="width:auto;"><b>以下是已成功导入记录：</b></div>

    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="7%">教师姓名</th>
        <th width="10%">身份证号</th>
        <th width="15%">省市县校</th>
        <th width="9%">教师编号</th>
        <th width="4%">性别</th>
        <th width="7%">政治面貌</th>
        <th width="7%">学段</th>
        <th width="7%">学科</th>
        </tr>
        </thead>
        <tbody id="records">
        
       <!--  <tr>
        <td>李四</td>
        <td>372523190001011099</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;语文</td>
        </tr> -->
    
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