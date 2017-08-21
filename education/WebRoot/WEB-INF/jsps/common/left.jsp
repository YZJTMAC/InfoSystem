<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%
	String path = request.getContextPath();
%>
<script type="text/javascript">
$(function() {
	//导航切换
	$(".menuson li").click(function() {
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});

	$('.title').click(function() {
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if ($ul.is(':visible')) {
			$(this).next('ul').slideUp();
		} else {
			$(this).next('ul').slideDown();
		}
	});
})
</script>



<div class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>工具栏
	</div>

	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="<%=path%>/images/leftico01.png" /> </span>培训项目管理
			</div>
			<ul class="menuson" style="display: block;">
				<li class="active">
					<cite></cite><a
						href="<%=path%>/edupm/projectmanage/toProjectListPage.htm">项目管理</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/edupm/projectmanage/toSetSignUpWay.htm">报名方式设置</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/edupm/projectmanage/toProjectAllocatePage.htm">培训机构任务分配</a><i></i>
				</li>
				<%--
        	<li><cite></cite><a href="peixun_3.2.html" >教师报名审核</a><i></i></li>--%>
				<li>
					<cite></cite><a
						href="<%=path%>/edupm/teachermanage/toTeacherProScoreListPage.htm">教师成绩查询</a><i></i>
				</li>

				<li>
					<cite></cite><a
						href="<%=path%>/edupm/projectmanage/toSetClassListPage.htm">课程设置</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/furtheredu/edumanage/evaluationListPage.htm">项目评价</a><i></i>
				</li>
				<%--
        	<li><cite></cite><a href="peixun_4.3.html" >项目汇总统计</a><i></i></li>
        --%>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="<%=path%>/images/leftico01.png" /> </span>教师信息
			</div>
			<ul class="menuson" style="display: block;">
				<li class="active">
					<cite></cite><a
						href="<%=path%>/teacher/teacherProject/teacherInfoPage.htm">教师信息</a><i></i>
				</li>
				<%--<li><cite></cite><a href="peixun_3.1.html" >教师信息导入</a><i></i></li>
	    	--%>
				<li>
					<cite></cite><a
						href="<%=path%>/teacher/teachermanage/teacherManagePage.htm">教师信息管理</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/teacher/teacherProject/teacherProjectListPage.htm">教师正在参加的培训项目</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/teacher/teacherProject/teacherAddProjectPage.htm">教师加入培训项目</a><i></i>
				</li>
			</ul>
		</dd>

		<!-- 机构left -->
		<dd>
			<div class="title">
				<span><img src="<%=path%>/images/leftico01.png" /> </span>培训项目管理
			</div>
			<ul class="menuson" style="display: block;">
				<li class="active">
					<cite></cite><a href="<%=path%>/org/orgProjectListPage.htm">承培项目管理</a><i></i>
				</li>
				<li>
					<cite></cite><a href="<%=path%>/org/orgProjectStatusPage.htm">项目状态设置</a><i></i>
				</li>
				<li>
					<cite></cite><a href="<%=path%>/org/orgProjectTeacherListPage.htm">参训教师管理</a><i></i>
				</li>
				<li>
					<cite></cite><a href="<%=path%>/org/orgProTeacherScoreListPage.htm">查看教师评价</a><i></i>
				</li>
				<li>
					<cite></cite><a href="<%=path%>/org/orgUploadScoreListPage.htm">上传培训成绩</a><i></i>
				</li>
				<li>
					<cite></cite><a href="<%=path%>/sys/toProjectStatisticsPage.htm">项目汇总统计</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<toolbar:enable uri="system_002">
				<div class="title">
					<span><img src="<%=path%>/images/leftico03.png" /> </span>系统管理
				</div>
			</toolbar:enable>
			<ul class="menuson">
				<toolbar:enable uri="system_003">
					<li>
						<cite></cite><a
							href="<%=path%>/sys/toAreaMgrPage.htm?belong=0&type=0"
							target="_self">地区管理</a><i></i>
					</li>
				</toolbar:enable>

				<%--
        <li><cite></cite><a href="system_2.html" >学校管理</a><i></i></li>
         <li><cite></cite><a href="system_5.4.1.html" >生成管理员帐号</a><i></i></li>
         <li><cite></cite><a href="system_5.4.2.html" >管理员管理</a><i></i></li> 
         <li><cite></cite><a href="system_3.html">角色管理</a><i></i></li>
         --%>
				<!--<li><cite></cite><a href="system_6.html" >普通用户管理</a><i></i></li> -->
				<%--
         <li><cite></cite><a href="system_5.5.html" >培训实施机构管理</a><i></i></li> 
         <li><cite></cite><a href="system_4.2.html" >数据字典管理</a><i></i></li> 
         <li><cite></cite><a href="system_4.5.html" >系统设置</a><i></i></li> 
        --%>
			</ul>
		</dd>
		<dd>
			<!-- 继教信息left -->
			<div class="title">
				<span><img src="<%=path%>/images/leftico01.png" /> </span>继教信息
			</div>
			<ul class="menuson" style="display: block;">
				<li>
					<cite></cite><a
						href="<%=path%>/furtheredu/edumanage/eduManagePage.htm">继教信息管理</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/furtheredu/edutarget/targetManagePage.htm">年度考核设置</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/furtheredu/edumanage/eduManageGroupPage.htm">教师年度考核查询</a><i></i>
				</li>
				<li>
					<cite></cite><a
						href="<%=path%>/furtheredu/certificate/certificateListPage.htm">年度证书模板设置</a><i></i>
				</li>
			</ul>
		</dd>

	</dl>

</div>

