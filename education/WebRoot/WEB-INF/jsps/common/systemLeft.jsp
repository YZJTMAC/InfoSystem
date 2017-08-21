<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%
	String path = request.getContextPath();
%>
<script type="text/javascript">
$(function() {
	var click = <%=request.getParameter("click")%>;
	//导航切换
	$(".menuson li.active").removeClass("active")
	$(".menuson li").each(function(){
		if(this.id == click){
			$(this).addClass("active");
			return false;
		}
	})

	$('.title').click(function() {
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if ($ul.is(':visible')) {
			$(this).next('ul').slideUp();
		} else {
			$(this).next('ul').slideDown();
		}
	});
	if(click == null || click=="" || click.length == 0) {
		$(".title:first").slideDown(1);
	} else {
		menuActivy(click);
	}
	function menuActivy(click) {
		$(".title").each(function(index){
			$(this).next('ul').slideUp(1);
		});
		$("#" + click).parent().slideDown(1);
	}
});
</script>



<div id="leftH" class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>工具栏
	</div>

	<dl class="leftmenu">
		<dd>
			<toolbar:enable uri="system_002">
				<div class="title">
					<span><img src="<%=path%>/images/leftico03.png" /> </span>系统管理
				</div>
			</toolbar:enable>
			<ul class="menuson">
			<!-- 系统管理员 -->
				<toolbar:enable uri="system_003">
					<li id="0" >
						<cite></cite><a
							href="<%=path%>/sys/toAreaMgrPage.htm?belong=-1&type=1&click=0">地区管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_004">
					<li id="1">
						<cite></cite><a
							href="<%=path%>/sys/toRolePage.htm?click=1">角色管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_005">
					<li id="2" >
						<cite></cite><a
							href="<%=path%>/sys/toSetSchoolPage.htm?click=2">学校管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_013">
					<li id="16">
						<cite></cite><a
							href="<%=path%>/sys/cpOrganizationList.htm?click=16">承培机构管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_008">
					<li id="4">
						<cite></cite><a
							href="<%=path%>/sys/organizationList.htm?click=4">实施机构管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_009">
					<li id="3" >
						<cite></cite><a
							href="<%=path%>/dictionary/dictionaryManages/dictionaryList.htm?click=3">数据字典管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_011">
					<li id="444" >
						<cite></cite><a
							href="<%=path%>/person/toManagesPage.htm?click=444">管理员管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="system_012">
					<li id="555" class="active">
						<cite></cite><a
							href="<%=path%>/person/toCreateManagesPage.htm?click=555">生成管理员帐号</a><i></i>
					</li>
				</toolbar:enable>
				
			
				
				<toolbar:enable uri="system_010">
					<li id="5" >
						<cite></cite><a
							href="<%=path%>/sys/toSysSetupPage.htm?click=5">功能设置</a><i></i>
					</li>
				</toolbar:enable>
				
				
				
				<toolbar:enable uri="system_020">
					<li id="1005" >
						<cite></cite><a
							href="<%=path%>/sys/toSysPlatformSetupPage.htm?click=1005">系统设置</a><i></i>
					</li>
				</toolbar:enable>
					
				<toolbar:enable uri="system_099">
					<li id="99" >
						<cite></cite><a href="<%=path%>/sys/fjimportHistory.htm?click=99">能力提升数据</a><i></i>
						<%-- <cite></cite><a href="<%=path%>/sys/fjimportMgr.htm?click=99">能力提升数据导入</a><i></i> --%>
					</li>
				</toolbar:enable>
				

		<!--		system_011
        <li><cite></cite><a href="###" >学校管理</a><i></i></li>
         <li><cite></cite><a href="###" >生成管理员帐号</a><i></i></li>
         <li><cite></cite><a href="###" >管理员管理</a><i></i></li> 
         <li><cite></cite><a href="###">角色管理</a><i></i></li>
         
				<li><cite></cite><a href="system_6.html" >普通用户管理</a><i></i></li> 
				
         <li><cite></cite><a href="###" >培训实施机构管理</a><i></i></li> 
         <li><cite></cite><a href="###" >数据字典管理</a><i></i></li> 
         <li><cite></cite><a href="###" >系统设置</a><i></i></li> 
       -->
			</ul>
		</dd>
	</dl>
	<dl class="leftmenu">
		<dd>
			<toolbar:enable uri="teacher_900">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>信息统计
				</div>
			</toolbar:enable>
			<ul class="menuson" style="display: none;">
				<toolbar:enable uri="system_021">
					<li id="17" >
						<cite></cite><a href="<%=path%>/stats/schoolStatsPage.htm?click=17">学校信息统计</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_901">
					<li id="901">
						<cite></cite>
						<a href="<%=path%>/teacher/teachermanage/teacherRegionStatsPage.htm?click=901">教师信息统计【地区】</a><i></i>
					</li>
				</toolbar:enable>
					<toolbar:enable uri="teacher_902">
					<li id="902">
						<cite></cite>
						<a href="<%=path%>/teacher/teachermanage/teacherSemesterStatsPage.htm?click=902">教师信息统计【学段】</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_007">
					<li id="7">
						<cite></cite><a
							href="<%=path%>/sys/toProjectStatisticsPage.htm?click=7">项目汇总统计</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_014">
					<li id="10">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/toSearchScore.htm?click=10">学分信息统计</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_021">
					<li id="21">
						<%-- <cite></cite><a href="<%=path%>/sys/queryTeacherTraningScoreInfo.htm?click=21">学分信息汇总</a><i></i> --%>
						<%-- <cite></cite><a href="<%=path%>/sys/eduTeacherTrainScore.htm?click=21">学分信息汇总</a><i></i> --%>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_901">
					<li id="903">
						<cite></cite>
						<a href="<%=path%>/stats/furtherStatsPage.htm?click=903">继教信息统计</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
		</dd>
	</dl>
</div>

<script type="text/javascript">
var winHeight = 0;
$(function() {
	leftHeight();
})
function leftHeight() {
	//获取窗口高度

	if (window.innerHeight)

		winHeight = window.innerHeight;

	else if ((document.body) && (document.body.clientHeight))

		winHeight = document.body.clientHeight;

	//通过深入Document内部对body进行检测，获取窗口大小

	if (document.documentElement && document.documentElement.clientHeight
			&& document.documentElement.clientWidth) {

		winHeight = document.documentElement.clientHeight;

	}
	$("#leftH").css("height", (winHeight-90));
}
//调用函数，获取数值
window.onresize = function() {
	leftHeight();
};
</script>