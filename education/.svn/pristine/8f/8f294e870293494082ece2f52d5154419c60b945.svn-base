<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>分配名额</title>
	<%@include file="../common/commonHead.jsp"%>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/allocateByArea.js"></script>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select2").uedSelect( {
				width : 127
			});
		});
		var allocateTotal = <%=request.getAttribute("num")%>;
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
	<!-- left END -->
	
	<div class="content">
		<div class="place">
			<input type="hidden" name="old" type="text" value="<%=request.getAttribute("areaId")%>">
		    <input type="hidden" name="upId" id="upId" type="text" value="<%=request.getAttribute("areaId") %>" >
		    <input type="hidden" name="projectId" type="text" value="<%=request.getAttribute("projectId") %>" >
		    <input type="hidden" name="flag" type="text" value="<%=request.getAttribute("flag") %>" >
		    <input type="hidden" name="roleId" type="text" value="<%=request.getAttribute("roleId") %>" >
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">培训项目</a></li>
			    <li><a href="#">培训名额分配</a></li>
		    </ul>
	    </div>
	     
	    <div class="formbody">
	    	<div class="tabson">
	        <p class="xmTool">项目名称：<b><%=request.getAttribute("name")%></b>计划培训人数：<b><%=request.getAttribute("planNum")%></b>  地区:<b id="area"><%=request.getAttribute("area")%></b>  当前地区名额:<b id="num"><%=request.getAttribute("num")%></b>    </p>
	        
	        <ul class="seachform" id="seachform">
	        
				<li>
					<label>
						学校名称：
					</label>
					<input name="input" type="text" class="scinput" id="schoolName" />
				</li>
				
				<li>
									<label>
										学校类型:
									</label>
									<div class="vocation">
										<select id="schoolTypeId" name="select" class="select2">
										
										</select>
									</div>
								</li>
	
								
				<li>
					<input name="" id="toPage" onclick="qryPro();" type="button" class="sure1" value="查 询" />
				</li>
				
			</ul>
	        <%-- <a href="<%=basePathHeader %>/edupm/projectmanage/toAllocateByAreaPage.htm?click=<%=request.getParameter("click") %>&flag=<%=request.getParameter("flag") %>" class="dian3" id="bb">返回</a> --%>
	        
	        <!--  	<a href="<%=basePathHeader %>/edupm/projectmanage/toAllocateByAreaPage.htm?click=<%=request.getParameter("click") %>&flag=<%=request.getParameter("flag") %>" 
	        	  class="dian3" >返回项目列表</a>
	        	  -->
	        <ul>
	        <li>
	           <input type="button"  class="sure1" onclick="returnProjList('<%=basePathHeader %>/edupm/projectmanage/toAllocateByAreaPage.htm?click=<%=request.getParameter("click") %>&flag=<%=request.getParameter("flag") %>')" value="返回项目列表" ></input>
	            <label>剩余名额</label>
	            <input type="text"  id="avertotal" value = "<%=request.getAttribute("num")%>" class="scinput" name="input"></input>
	           <input type="button"  class="sure1" onclick="allocateAverage()" value="平均分配" ></input>
	        </li>
	        </ul>
	        <div> 
	       
	        <%--
	        <p class="xmTool">项目名称：<b>${name }</b>计划培训人数：<b>${num }</b>  地区:<b id="area">${area }</b>  当前地区名额:<b id="num">${num }</b>    </p> 
	        <a href="<%=basePathHeader%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=<%=request.getParameter("flag") %>" class="dian3">返回</a>
	        --%>
	         <table class="tablelist" style="margin-top:12px;">
	        <thead>
	          <tr>
	            <th width="5%"><input type='checkbox'  
	              id='allCheck' onclick="allCheck(this)"/> </th>
	            <th width="20%">地区</th>
				<th width="20%">计划分配名额</th>
	            <th width="20%">操作</th>
	          </tr>
	        </thead>
	        <tbody id="list">
			  
	        </tbody>
	      </table>
			 </div>
	      </div>
	
	    </div> 
		
	 </div>   
</body>
</html>