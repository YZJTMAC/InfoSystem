<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%
	String basePath = request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath%>/javascript/system/loginCommon.js"></script>
<script type="text/javascript"
			src="<%=basePath%>/javascript/message/messageCountsShenhe.js">
		</script>
<script type="text/javascript">
$(function() {
	//顶部导航切换
	$(".nav li a").click(function() {
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	var flag="<%=request.getParameter("flag")%>";
	if(flag=="project"){
		$("#project").addClass("selected");
	}else if(flag=="person"){
		$("#person").addClass("selected");
	}else if(flag=="teacher"){
		$("#teacher").addClass("selected");
	}else if(flag=="system"){
		$("#system").addClass("selected");
	}else if(flag=="furtheredu"){
		$("#furtheredu").addClass("selected");
	}
	
})

$(function(){
	var platformSetup = SysCode.getJsonArray("SYS_PLATFORM_SETUP","")[0].text;
	if(platformSetup.sysName.length>0){
		$('#sysName').html('');
		$('#sysName').html(platformSetup.sysName);
	}
});
</script>

<div class="topleft">
	<h1>
		<a id="sysName" href="###" target="_parent"></a>
	</h1>
</div>

<ul class="nav">
	<toolbar:enable uri="person_001">
		<li>
			<a id="person" href="<%=basePath%>/person/index.htm"><img
					src="<%=basePath%>/images/icon01.png" title="个人中心" />
				<h2>
					个人中心
				</h2> </a>
		</li>
	</toolbar:enable>
	<toolbar:enable uri="system_001">
		<li>
			<a id="system" href="<%=basePath%>/person/index1.htm"><img
					src="<%=basePath%>/images/icon06.png" title="系统管理" />
				<h2>
					系统管理
				</h2> </a>
		</li>
	</toolbar:enable>
	<toolbar:enable uri="teacher_001">
		<li>
			<a id="teacher" href="<%=basePath%>/person/index2.htm"><img
					src="<%=basePath%>/images/icon02.png" title="教师信息" />
				<h2>
					教师信息
				</h2> </a>
		</li>
	</toolbar:enable>
	<toolbar:enable uri="project_001">
		<li>
			<a href="<%=basePath%>/person/index3.htm" id="project"><img
					src="<%=basePath%>/images/icon03.png" title="培训项目" />
				<h2>
					培训项目
				</h2> </a>
		</li>
	</toolbar:enable>
	<toolbar:enable uri="furtheredu_001">
		<li>
			<a id="furtheredu" href="<%=basePath%>/person/index4.htm" ><img
					src="<%=basePath%>/images/icon05.png" title="继教信息" />
				<h2>
					继教信息
				</h2> </a>
		</li>
	</toolbar:enable>
</ul>

<div class="topright">
	<ul>
		<li>
			<span><img src="<%=basePath%>/images/help.png" title="帮助"
					class="helpimg" /> </span><a href="#">帮助</a>
		</li>
		<li>
			<a href="#">关于</a>
		</li>
		<li>
			<a href="#none" onclick="outLogin();" target="_parent">退出</a>
		</li>
	</ul>

	<div class="user">
		<a href="###" id="userInfo" class="a1" title=""></a>
		<i><a href="<%=basePath%>/message/messageManagement/toMessagePageshenghe.htm?click=2" style="color: #FFF;">通知</a> </i>
		<b id="messageCounts">0</b>
	</div>

</div>
