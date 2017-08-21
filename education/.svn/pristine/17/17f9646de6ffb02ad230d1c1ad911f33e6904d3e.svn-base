<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/allocate.js"></script>
<title>培训机构分配</title>
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
    <li><a href="#">培训机构任务分配</a></li>

    </ul>
    </div>
    <div class="formbody">
      <div class="tabson">
<ul class="seachform">
  <li>
            <label>项目名称：</label>
            <input name="name" type="text" class="scinput"  id="projectName"/>
          </li>
         <li>
            <label>项目年度：</label>
            
          </li>
          <li>
          	 <select name="select" class="select2 yearpicker" id="beginDate">
          	</select>  
          </li>
          <li>--</li>
          <li>
           <select name="select" class="select2 yearpicker" id="endDate">
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
            <th width="20%">项目名称</th>
            <th width="10%">范围</th>
            <th width="10%">上报人数</th>
            <th width="10%">操作</th>
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