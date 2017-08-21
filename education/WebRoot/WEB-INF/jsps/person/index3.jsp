<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页</title>
		

	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
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
					<li>
						<a href="###">培训项目</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
      			<%-- <div style="width:366px; margin:0 auto; padding-top:40px;"><img src="<%=basePathHeader%>/images/welcome.jpg" width="366" height="288" /></div> --%> 
    		</div>
		</div>
		<script type="text/javascript">
		/* 当点击培训项目的时候，跳转到培训项目查询 */
			var openUrl = "<%=basePathHeader%>" +"/edupm/projectmanage/toProjectManagePage.htm?click=20";
			var urls ='<%=session.getAttribute("roleUrl")%>';
			urls = urls.substring(1, urls.length - 1).replace(" ", "").split(",");
			$(function() {
				for ( var i = 0; i < urls.length; i++) {
					var url = trim(urls[i]);
					if (url == "project_015") {
						window.location.href = openUrl;
					}
				}
			})
			function trim(url) {
				return url.replace(/(^\s*)|(\s*$)/g, "");
			}
		</script>
		
		<%-- <div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div> --%>
	</body>
</html>
