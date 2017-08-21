<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="project.person.pojo.EduUserActivty" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int roleId = ((EduUserActivty)session.getAttribute("userinfo")).getRoleId();
%>
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
var old = -1;
	var upId = ${areaId};
	var projectId = <%=request.getParameter("projectId")%>
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/new_reportByArea.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名额上报</title>
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
    <li><a href="#">培训名额上报</a></li>
	 
    </ul>
    </div>
     
    <div class="formbody">
    
    

      <div class="tabson">
        <p class="xmTool">项目名称：<b>${name }</b>计划培训人数：<b>${planNum }</b>   地区:<b id="area">${area }</b>    当前地区名额:<b id="num">${num }</b></p>  
        </div> 
		<div class="chauxnJS jsTool" >
		
				<%if(roleId != 4){ %>
				<span style="float: left;">  
				<a href="javascript:reportByUpLvId();" class="huibtn_a" id="Report">上报</a>
				</span>
				<%} %>
				 <span style="float: right;">

				</span>
			</div>

         <table class="tablelist" style="margin-top:0px;">
        <thead>
          <tr>
            <th width="20%">地区</th>
			<th width="20%">培训名额</th>
			<th >已上报人数</th>
			<th width="20%">上报状态</th>
            <th width="250px">操作</th>
          </tr>
        </thead>
        <tbody id="proList1">
          <tr>
           	<td>天河区&nbsp;</td>
			<td>2000&nbsp;</td>
				<td>0&nbsp;</td>
				<td>未上报</td>
				
				
             <td><a href="#" class="huibtn_a  " >导入</a>&nbsp;&nbsp;
			 
			 <a href="xz5.1.2.html"
					class="huibtn_a" style="margin-left: 6px">选择教师</a> 
					 </a>&nbsp;&nbsp;

<a href="#" class="huibtn_a  " >上报</a>&nbsp;&nbsp;					</td>
          </tr>
           <tr>
           	<td><a href="xz5.1.1.html" class="tablelink">白云区</a>&nbsp;</td>
			<td>1000&nbsp;</td>
				
				<td><a href="xz5.1.3.html" class="tablelink">850</a></td>
				<td>已上报&nbsp;</td>
				 
            <td>--&nbsp; </td> 
          </tr>
		   
        </tbody>
      </table>
		 </div>
      </div>
  <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex"  />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
    </div> 
</div>		
</body>
</html>