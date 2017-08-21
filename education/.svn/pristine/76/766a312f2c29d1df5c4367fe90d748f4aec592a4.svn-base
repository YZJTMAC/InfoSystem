<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<script type="text/javascript">
var registerMenuArray = [];

$(function() {
	var click = <%=request.getParameter("click")%>;
	var ulc = <%=request.getParameter("ul")%>;
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
			//menuActivy($(this).attr("id"));
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
			<toolbar:enable uri="teacher_002">
				<div id="teacher_002" class="title">
					<span style="float:left;"><img src="<%=path%>/images/leftico01.png" /> </span>教师信息
				</div>
			</toolbar:enable>
			<ul id="002" class="menuson" style="display: block;">
				<toolbar:enable uri="teacher_003">
					<li id="0">
						<cite></cite>
					    <c:choose>
							<c:when test="${sessionScope.userinfo.status lt 30}">
								<a href="<%=path%>/teacher/teacherProject/updateTeacherPage.htm?teacherId=${sessionScope.userinfo.userId}">教师信息</a><i></i>
							</c:when>
							<c:otherwise>
								<a href="<%=path%>/teacher/teacherProject/teacherInfoPage.htm?click=0">教师信息</a><i></i>
							</c:otherwise>
						</c:choose>
					</li>
				</toolbar:enable>
				<!-- 管理员 -->
				<toolbar:enable uri="teacher_005">
					<li id="0" class="active">
						<cite></cite><a
							href="<%=path%>/edupm/teachermanage/toImportRecordPage.htm?click=0">教师信息导入</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_021">
				<li id="11" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/teacherManageQueryPage.htm?click=11">教师信息查询</a><i></i>
				</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_004">
					<li id="1" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/teacherManagePage.htm?click=1">教师信息管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_007">
					<li id="3" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toMobilizeAddPage.htm?click=3">教师调动管理</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="teacher_010">
					<li id="333" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toAdjustAddPage.htm?click=333">编制调整管理</a><i></i>
					</li>
				</toolbar:enable>
 
 				<toolbar:enable uri="teacher_012">
					<li id="12" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toSickAddPage.htm?click=12">教师病休管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_013">
					<li id="13" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toDimissionAddPage.htm?click=13">教师离岗管理</a><i></i>
					</li>
				</toolbar:enable>
					
				<toolbar:enable uri="teacher_014">
					<li id="14" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toDeadAddPage.htm?click=14">教师死亡登记管理</a><i></i>
					</li>
				</toolbar:enable>	
				
				<toolbar:enable uri="teacher_009">
					<li id="4" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toRetireesAddPage.htm?click=4">教师离退休管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_015">
					<li id="15" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toReWorkAddPage.htm?click=15">教师返聘管理</a><i></i>
					</li>
				</toolbar:enable>
				<!-- 教师角色 -->
				<toolbar:enable uri="teacher_006">
					<li id="100" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/teacherInfoChangePage.htm?click=100">信息变更记录</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="teacher_011">
					<li id="1900" class="">
						<cite></cite><a
							href="<%=path%>/teacher/teachermanage/teacherMobilizeList.htm?click=1900">我的调动记录</a><i></i>
					</li>
				</toolbar:enable>
				
				 
			</ul>

		</dd>

	</dl>

	<dl class="leftmenu">
		<dd>
			<toolbar:enable uri="teacher_002_1">
				<div id="teacher_002_1" class="title" >
					<span><img src="<%=path%>/images/leftico01.png" /> </span>教师信息审核
				</div>
			</toolbar:enable>
			
			<ul id="0021" class="menuson" style="display: none">
				<toolbar:enable uri="teacher_008">
					<li id="2" class="">
						<cite></cite><a
							href="<%=path%>/edupm/teachermanage/toTeacherInfoChangeAuditPage.htm?click=2">信息变更审核</a><i></i>
					</li>
				</toolbar:enable>
				
				<toolbar:enable uri="teacher_007_through">
				<li id="1000">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=N">教师调动审核</a><i></i>
				</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_010_through">
				<li id="1001">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toAdjustAuditListPage.htm?click=1001&flag=N">编制调整审核</a><i></i>
				</li>
				</toolbar:enable>
				
				
				
				
				
				<toolbar:enable uri="teacher_016">
				<li id="1002">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toSickAuditListPage.htm?click=1002&flag=N">教师病休审核</a><i></i>
				</li>
				</toolbar:enable>
				
				<toolbar:enable uri="teacher_017">
				<li id="1003">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toDimissionAuditListPage.htm?click=1003&flag=N">教师离岗审核</a><i></i>
				</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_018">
				<li id="1004">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toRetireesAuditListPage.htm?click=1004&flag=N">教师离退休审核</a><i></i>
				</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_019">
				<li id="1005">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toDeadAuditListPage.htm?click=1005&flag=N">教师死亡登记审核</a><i></i>
				</li>
				</toolbar:enable>
				<toolbar:enable uri="teacher_020">
				<li id="1006">
					<cite></cite><a
							href="<%=path%>/teacher/teachermanage/toReworkAuditListPage.htm?click=1006&flag=N">教师返聘审核</a><i></i>
				</li>
				</toolbar:enable>
				
			</ul>
		</dd>
	</dl>
	<dl class="leftmenu">
 
				
		<%-- <dd>
			<toolbar:enable uri="teacher_900">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>教师信息统计
				</div>
			</toolbar:enable>

			<ul class="menuson" style="display: none;">
				<toolbar:enable uri="teacher_901">
					<li id="901">
						<cite></cite>
						<a
							href="<%=path%>/teacher/teachermanage/teacherRegionStatsPage.htm?click=901">按地区统计</a><i></i>
					</li>
				</toolbar:enable>
				
					<toolbar:enable uri="teacher_902">
					<li id="902">
						<cite></cite>
						<a
							href="<%=path%>/teacher/teachermanage/teacherSemesterStatsPage.htm?click=902">按学段统计</a><i></i>
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
