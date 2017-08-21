<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherPaperAndAssessList.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select2").uedSelect({
		width : 167  
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
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">项目调查</a></li>
    </ul>
    </div>
    
    <div class="formbody" >
<div class="tabson" id="starting">
<ul class="seachform">
  <li>
            <label>项目名称：</label>
            <input name="input" type="text" class="scinput"  id="projectName"/>
          </li>
         <li>
            <label>项目年度：</label>
            
          </li>
          <li>
          	 <select name="select" class="select2 yearpicker" id="beginDate" width="100px;">
          	 	<option value="">请选择</option>
          	</select>  
          </li>
          <li>--</li>
          <li>
           <select name="select" class="select2 yearpicker" id="endDate" width="100px;">
           		<option value="">请选择</option>
          </select>
          </li>
			 <li>
            	<input name="input2" type="button" class="dian3" value="查 询" onclick="qryPro();"/>
          	</li>
        </ul>
      </div>
      <table class="tablelist" >
        <thead>
          <tr>
            <th>项目名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>培训形式</th>
            <th>培训类型</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody id="proList">
         
         
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
