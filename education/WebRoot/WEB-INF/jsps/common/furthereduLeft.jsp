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
})
</script>



<div id="leftH" class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>工具栏
	</div>
	<dl class="leftmenu">
		<dd>
			<toolbar:enable uri="furtheredu_002">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>继教信息
				</div>
			</toolbar:enable>

			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="furtheredu_020">
					<li id="11">
						<cite></cite>
						<a
							href="<%=path%>/edupm/projectmanage/toSetExchangeRolePage.htm?click=11">学分兑换规则设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_004">
					<li id="0">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/eduManagePage.htm?click=0">继教信息管理</a><i></i>
					</li>
				</toolbar:enable>
			

				<toolbar:enable uri="furtheredu_006">
					<li id="2">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/eduManageGroupPage.htm?click=2">教师年度考核查询</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="furtheredu_010">
					<li id="6">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/notrainListPage.htm?click=6">校本培训项目</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_011">
					<li id="7">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/mnotrainListPage.htm?click=7">非培训类项目</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_012">
					<li id="8">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/creditEnterListPage.htm?click=8">学分登记</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_013">
					<li id="9">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/creditAudtitListPage.htm?click=9">学分审核</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_022">
					<li id="22">
						<cite></cite><a href="<%=path%>/sys/eduTeacherTrainScore.htm?click=22">学分汇总</a><i></i>
					</li>
				</toolbar:enable>
				<%-- <toolbar:enable uri="furtheredu_014">
					<li id="10">
						<cite></cite><a
							href="<%=path%>/furtheredu/certificate/toSearchScore.htm?click=10">学分查询</a><i></i>
					</li>
				</toolbar:enable> --%>

				<!-- 教师角色 -->
				<toolbar:enable uri="furtheredu_008">
					<li id="4">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/teacherAssessWithYear.htm?click=4">继教学分查询</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_009">
					<li id="5">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/toTeacherPrinterCertificatePage.htm?click=5">年度证书打印</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_023">
					<li id="23">
						<cite></cite>
						<a href="<%=path%>/teacher/teacherProject/teacherTrainScorePage.htm?click=23">教师培训学分</a><i></i>
					</li>
				</toolbar:enable>
				<!-- 教师 -->
				<toolbar:enable uri="furtheredu_015">
					<li id="12">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/toTeacherProPrinterCertificatePage.htm?click=12">项目证书打印</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_026">
					<li id="26">
						<cite></cite><a href="<%=path%>/furtheredu/edumanage/toSearchCredit.htm?click=26">学分查询</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_028">
					<li id="28">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toScoreQuery.htm?click=28">教师培训学分</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
		</dd>
	</dl>



	<dl class="leftmenu">
		<dd>
			<div class="title" id="third" >
				<span><img src="<%=path%>/images/leftico01.png" /> </span>学分银行
			</div>
			<ul class="menuson" style="display: none">
				<toolbar:enable uri="furtheredu_027">
					<li id="27">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toCreditLend.htm?click=27">学分借贷</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_029">
					<li id="29">
						<cite></cite><a href="<%=path%>/edupm/projectmanage/toAuditCreditLend.htm?click=29">学分借贷审核</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_030">
					<li id="30">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/searchTeacherCreditLend.htm?click=30">学分借贷查询</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_031">
					<li id="31">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toDeclareIndependentStudy.htm?click=31">自主研修申报</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_032">
					<li id="32">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toAuditIndeptStudy.htm?click=32">自主研修审批</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_033">
					<li id="33">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toSpecialCase.htm?click=33">特殊情况申报</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_034">
					<li id="34">
						<cite></cite><a href="<%=path%>/teacher/teacherProject/toAuditSpecialCase.htm?click=34">特殊情况审批</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
		</dd>
	</dl>













<script type="text/javascript">
	var isDis = false;
</script>
	<dl class="leftmenu">
		<dd>
			
				<div class="title" id="second" >
					<span><img src="<%=path%>/images/leftico01.png" /> </span>继教证书
				</div>
		
			<ul class="menuson" style="display: none">
				<toolbar:enable uri="furtheredu_005">
				<script type="text/javascript"> isDis = true;</script>
					<li id="1">
						<cite></cite><a
							href="<%=path%>/furtheredu/edutarget/targetManagePage.htm?click=1">年度考核设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_007">
				<script type="text/javascript"> isDis = true;</script>
					<li id="3">
						<cite></cite>
						<a
							href="<%=path%>/furtheredu/certificate/certificateListPage.htm?click=3">年度证书模板设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_018">
				<script type="text/javascript"> isDis = true;</script>
					<li id="13">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/toProPrinterCertificateSetPage.htm?click=13">项目证书设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_017">
				<script type="text/javascript"> isDis = true;</script>
					<li id="19872">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/toSignet.htm?click=19872">电子印章管理</a><i></i>
					</li>
				</toolbar:enable>
				<!-- 实施/管理 -->
				<toolbar:enable uri="furtheredu_019">
				<script type="text/javascript"> isDis = true;</script>
					<li id="1005">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/tossPrinterCertificatePage.htm?click=1005">项目证书打印</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_021">
				<script type="text/javascript"> isDis = true;</script>
					<li id="1021">
						<cite></cite><a
							href="<%=path%>/furtheredu/edumanage/certificateQuery.htm?click=1021">证书信息查询</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_024">
					<li id="24">
						<cite></cite><a href="<%=path%>/furtheredu/edumanage/toYearPrinterCertificateSetPage.htm?click=24">年度证书设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="furtheredu_025">
					<li id="25">
						<cite></cite><a href="<%=path%>/furtheredu/certificate/yearCertificatePrint.htm?click=25">继续教育证书打印</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
		</dd>
	</dl>
<script type="text/javascript">
	if(isDis){
		$("#second").show();
	}
</script>
 
 <dl class="leftmenu">
 
				
		<%-- <dd>
			<toolbar:enable uri="furtheredu_900">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>继教统计 
				</div>
			</toolbar:enable>

			<ul class="menuson" style="display: none;">
				<toolbar:enable uri="furtheredu_901">
					<li id="901">
						<cite></cite>
						<a href="<%=path%>/stats/furtherStatsPage.htm?click=901">继教统计</a><i></i>
					</li>
				</toolbar:enable>
				 
			</ul>
		</dd> --%>
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
	$("#leftH").css("height", (winHeight - 90));
}
//调用函数，获取数值
window.onresize = function() {
	leftHeight();
};
</script>
