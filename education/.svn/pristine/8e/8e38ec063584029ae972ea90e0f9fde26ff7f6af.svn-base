
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%
	String path = request.getContextPath();
%>
<script type="text/javascript">
$(function() {
	 
	var click = $("input[name='clicke']").val();
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
})
</script>



<div id="leftH"  class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
	<input type="hidden" name="clicke" type="text" value="<%=request.getAttribute("click")%>">
		<span></span>工具栏
	</div>
	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="<%=path%>/images/leftico01.png" /> </span>培训项目管理
			</div>
			<ul class="menuson" style="display: block;">
			
				<!-- 管理员 -->
				<toolbar:enable uri="project_008"> 
					<li id="0" class="active">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toProjectListPage.htm?click=0">项目管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_003">
					<li id="1">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toSetSignUpWay.htm?click=1">报名方式设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_004">
					<li id="2">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toProjectAllocatePage.htm?click=2">培训机构任务分配</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_013">
					<li id="3">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toAuditPage.htm?click=3">教师报名审核</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_005">
					<li id="5">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toSetClassListPage.htm?click=5">课程设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_006">
					<li id="6">
						<cite></cite><a
							href="<%=path%>/teacher/teacherProject/teacherOverCommentProjectPage.htm?click=6">教师评价</a><i></i>
					</li>
				</toolbar:enable>
				
				<!-- 教师 -->
				<toolbar:enable uri="project_010">
					<li id="8" class="active">
						<cite></cite><a
							href="<%=path%>/teacher/teacherProject/teacherProjectListPage.htm?click=8">项目学习</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_011">
					<li id="9">
						<cite></cite>
						<a href="<%=path%>/teacher/teacherProject/teacherProjectCommon.htm?click=9&flag=6">项目报名</a>
					</li>
				</toolbar:enable>
				
					<toolbar:enable uri="project_041">
					<li id="101">
						<cite></cite><a
							href="<%=path%>/teacher/teacherProject/toTeacherProSummaryList.htm?click=101">培训项目总结</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_040">
					<li id="11">
						<cite></cite><a
							href="<%=path%>/teacher/teacherProject/teacherPaperAndAssessListPage.htm?click=11">项目调查</a><i></i>
					</li>
				</toolbar:enable>
				<%-- <toolbar:enable uri="project_012">
					<li id="10">
						<cite></cite>
						<a href="<%=path%>/teacher/teacherProject/teacherOverProjectPage.htm?click=10">查看培训成绩</a><i></i>
						<a href="<%=path%>/teacher/teacherProject/teacherTrainScorePage.htm?click=10">查看培训成绩</a><i></i>
					</li>
				</toolbar:enable> --%>
		
				<toolbar:enable uri="project_903">
					<li id="903">
						<cite></cite><a
							href="<%=path%>/teacher/teacherProject/teacherOverCommentProjectPage.htm?click=903">教师评价</a><i></i>
					</li>
				</toolbar:enable>
		
				
				<!-- 承培机构开始 -->
				<toolbar:enable uri="project_031">
					<li id="11" >
						<cite></cite><a
							href="<%=path%>/org/orgProjectListPage.htm?click=11">承培项目管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_032">
					<li id="12">
						<cite></cite><a
							href="<%=path%>/org/orgProjectStatusPage.htm?click=12">项目状态设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_036">
					<li id="13">
						<cite></cite><a
							href="<%=path%>/org/toSetClassListPage.htm?click=13">课程设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_033">
					<li id="14">
						<cite></cite><a
							href="<%=path%>/org/orgProjectTeacherListPage.htm?click=14">参训教师管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_034">
					<li id="15">
						<cite></cite><a
							href="<%=path%>/org/orgProTeacherScoreListPage.htm?click=15">查看教师评价</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_035">
					<li id="17">
						<cite></cite><a
							href="<%=path%>/org/orgUploadScoreListPage.htm?click=17">上传培训成绩</a><i></i>
					</li>
				</toolbar:enable>
				<!-- 承培机构结束 -->
				
				<!-- 实施机构 开始  -->
				<toolbar:enable uri="project_014">
					<li id="19">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toModelListPage.htm?click=19">继教信息板块设置</a><i></i>
					</li>
				</toolbar:enable>
				
				
				<toolbar:enable uri="project_016">
					<li id="21">
						<cite></cite><a	href="<%=path%>/edupm/projectmanage/toProjectDeclarePage.htm?click=21&status=10">培训项目创建</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_048">
					<li id="91">
						<cite></cite><a	href="<%=path%>/edupm/projectmanage/toNewProjectDeclarePage.htm?click=91&status=10">培训项目申报</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_047">
				<li id="50">
						<cite></cite><a
							href="<%=path%>/org/ssOrgProjectStatusPage.htm?click=50">承培平台设置</a><i></i>
					</li>
			</toolbar:enable>
			
			<toolbar:enable uri="project_051">
					<li id="109">
						<cite></cite><a
							href="<%=path%>/org/trainingMaterials.htm?click=109">提交培训材料</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_045">
					<li id="105">
						<cite></cite><a
							href="<%=path%>/org/toOrgProProcessListPage.htm?click=105">培训项目过程管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_017">
					<li id="22">
						<cite></cite><a	href="<%=path%>/edupm/projectmanage/toProjectAuditPage.htm?click=22&status=20">培训项目审核</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_015">
					<li id="20" class="active">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toProjectManagePage.htm?click=20&status=10">培训项目查询</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_018">
					<li id="23">
						<cite></cite><a	href="<%=path%>/edupm/projectmanage/toAllocateByAreaPage.htm?click=23&flag=1">培训名额分配</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_019">
					<li id="24">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toProjectListForReportPage.htm?click=24">培训名额上报</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_020">
					<li id="25">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toOrgTaskingPage.htm?click=25">承培机构任务分配</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_021">
					<li id="26">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toAuditPage.htm?click=26">教师报名审核</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_022">
					<li id="27">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toStartProjectPage.htm?click=27">培训项目启动</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_046">
					<li id="106">
						<cite></cite><a
							href="<%=path%>/org/toOrgProProcessListPage.htm?click=106">培训项目过程管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_023">
					<li id="28">
						<cite></cite><a
							href="<%=path%>/edupm/teachermanage/toTeacherProScoreListPage.htm?click=28">培训成绩导入</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_050">
					<li id="108">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toShenHePages.htm?click=108">培训成绩审核</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_028">
					<li id="33">
						<cite></cite><a
							href="<%=path%>/org/orgScorePublishPage.htm?click=33">培训成绩修改</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_049">
					<li id="107">
						<cite></cite><a
							href="<%=path%>/org/orgScorePublishPages.htm?click=107">培训成绩公布</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_052">
					<li id="110">
						<cite></cite>
						<a href="<%=path%>/edupm/projectmanage/toProListAuditTeacher.htm?click=110">培训结果审核</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_009">
					<li id="4">
						<cite></cite><a
							href="<%=path%>/org/toTeacherScoreProjectListPage.htm?click=4">教师成绩查询</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_027">
					<li id="32">
						<cite></cite><a
							href="<%=path%>/edupm/projectmanage/toProjectPaperAndAssessListPage.htm?click=32">项目调查与评估</a><i></i>
					</li>
				</toolbar:enable>
				
				
				<toolbar:enable uri="project_025">
					<li id="30">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/evaluationListPage.htm?click=30">项目评价</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_042">
					<li id="102">
						<cite></cite><a	href="<%=path%>/edupm/toXingZhengSummaryList.htm?click=102">培训项目总结</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_024">
					<li id="29">
						<cite></cite><a
							href="<%=path%>/org/toTeacherSummaryList.htm?click=29">培训项目总结</a><i></i>
					</li>
				</toolbar:enable>
				
				
				
				<toolbar:enable uri="project_026">
					<li id="31">
						<cite></cite><a
							href="<%=path%>/org/orgProSummaryReportList.htm?click=31">项目总结报告</a><i></i>
					</li>
				</toolbar:enable>
				
				<%-- <toolbar:enable uri="project_007">
					<li id="7">
						<cite></cite><a
							href="<%=path%>/sys/toProjectStatisticsPage.htm?click=7">项目汇总统计</a><i></i>
					</li>
				</toolbar:enable> --%>
				
				<toolbar:enable uri="project_029">
					<li id="34">
						<cite></cite><a	href="<%=path%>/edupm/projectmanage/toEndProjectPage.htm?click=34">培训项目关闭</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="project_043">
					<li id="103">
						<cite></cite><a	href="<%=path%>/org/toShiShiSummaryList.htm?click=103">培训项目总结（实施）</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_044">
					<li id="104">
						<cite></cite><a	href="<%=path%>/org/toChengPeiSummaryList.htm?click=104">培训总结（承培）</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="project_053">
					<li id="53">
						<cite></cite><a	href="<%=path%>/edupm/paper/toQuestionSurverSummary.htm?click=53">问卷调查汇总</a><i></i>
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
