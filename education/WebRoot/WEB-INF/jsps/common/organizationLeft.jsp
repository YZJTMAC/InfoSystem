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



<div id="leftH"  class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>工具栏
	</div>
	<dl class="leftmenu">
		<dd>
			<toolbar:enable uri="organization_002">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>培训项目管理
				</div>
			</toolbar:enable>
			<ul class="menuson">
				<toolbar:enable uri="organization_003">
					<li class="active">
						<cite></cite><a href="<%=path%>/org/orgProjectListPage.htm">承培项目管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="organization_004">
					<li>
						<cite></cite><a href="<%=path%>/org/orgProjectStatusPage.htm">项目状态设置</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="organization_005">
					<li>
						<cite></cite><a href="<%=path%>/org/orgProjectTeacherListPage.htm">参训教师管理</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="organization_006">
					<li>
						<cite></cite><a href="<%=path%>/org/orgProTeacherScoreListPage.htm">查看教师评价</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="organization_007">
					<li>
						<cite></cite><a href="<%=path%>/org/orgUploadScoreListPage.htm">上传培训成绩</a><i></i>
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
