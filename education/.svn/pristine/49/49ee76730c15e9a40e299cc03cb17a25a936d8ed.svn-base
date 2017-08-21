<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>地区管理</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
	var belong = <%=request.getParameter("belong")%>;
	var uu = <%=request.getAttribute("belong")%>
	var type = '<%=request.getParameter("type")%>';
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/areaMgr.js"></script>
</head>
<body>
<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="system" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/systemLeft.jsp"%>
	</div>
<div class="content">
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="jixuMegGLY_2.2.html">系统管理</a></li>

			<li>地区管理</li>
		</ul>
	</div>

	<div class="formbody" style="overflow: hidden; padding-bottom: 20px;">
	<span id="lv">当前地区：${relation}</span>
		<div class="formbodyL">
			<div class="chauxnJS jsTool">
				<span style="float: left;"> 
				<a href="javascript:createAddTr();" class="huibtn_a  " id="btnAdd" style="margin-left: 6px">添加</a>&nbsp; 
					<c:if test="${param.belong == -1}">
						<a 	href="javascript:toImportPage();" class="huibtn_a click" style="margin-left: 6px">批量导入</a>
					</c:if>
				</span> <span style="float: right;" id="back">
						<a href="javascript:window.history.back();"	class="huibtn_a  "  style="margin-right: 16px">上一级</a>
				</span>
			</div>
			<table class="tablelist">
				<thead>
					<tr>
						<th  width="30%">地区编码</th>
						<th  width="40%">地区名称</th>
						<th  >操作</th>
					</tr>
				</thead>
				<tbody id="areaList">
				</tbody>
			</table>

	<!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	
			<div class="tip">
				<div class="tiptop">
					<span>修改地区</span><a href="javascript:hideMe();"></a>
				</div>
			<input id="mId" type="hidden"/>
				<div class="tipinfo">
					<div class="tipright" style="padding: 0; margin: 0;"></div>
					<ul class="forminfo" style="padding: 0; margin: 0;">
					<li><label style="width: 60px;">地区编码:</label>
							<div class="vocation">
								<input id="mCode" value="" type="text" class="scinput" />
							</div></li>

						<li><label style="width: 60px;">地区名称:</label>
							<div class="vocation">
								<input id="mName" value="" type="text" class="scinput" />
							</div></li>
					</ul>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="保存" onclick="modifyA();"/>&nbsp; <input
						name="" type="button" class="cancel" value="取消" onclick="javascript:hideMe();" />
				</div>

			</div>

		</div>
	</div>
</div>
</body>
</html>