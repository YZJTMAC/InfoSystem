<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>	
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>首页</title>
		<link  href="<%=basePathHeader%>/style/kefu.css" rel="stylesheet" type="text/css" />		
	</head>
	<body>
		<!-- 通知弹窗显示控制标识 -->
		<input type="hidden" id="windowShow" value="1" />
		
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="person" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div style="display:block; ">
		<div class="leftNav">
			<%@include file="../common/personLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="###">个人中心</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
      			<div style="width:366px; margin:0 auto; padding-top:40px;"><img src="<%=basePathHeader%>/images/welcome.jpg" width="366" height="288" /></div> 
    		</div>
			<c:if test="${sessionScope.userinfo.roleTypeId=='5'}">
			<div class="kefu" id="one_close_b">
				<h4>
					<span class="l">在线客服</span><span class="r" title="关闭"
						onclick="jQuery('#one_close_b').hide(); return false;"></span>
				</h4>
				<h5>
					<img src="<%=basePathHeader%>/images/kefuImg.jpg" />
				</h5>
				
					<span class="l" style="text-align: center;">如不能发送消息,加3549880298好友</span>
				
				<div align="center" style = "margin-top: 10px;">
					<a target="_blank"
						href="http://wpa.qq.com/msgrd?v=3&uin=3549880298&site=qq&menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:3549880298:9"
						alt="点击这里给我发消息" title="点击这里给我发消息" /> </a>
				</div>
			</div>
			
			</c:if>
			
			

		</div>
		</div>
		<script type="text/javascript"><%--
			var openUrl = $(".menuson li a").attr('href');
			if(openUrl!=null && openUrl!='null' && openUrl.length!=0){
				window.location.href = openUrl;
			}
			<iframe style="width:100%" src="../common/buttom.jsp"/> 
		--%></script>
		
		<div class="loginbm">
			<%@include file="../common/buttom.jsp"%>
		</div>
	</body>
</html>
