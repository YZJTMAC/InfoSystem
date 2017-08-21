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
			<toolbar:enable uri="comparison_110">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>活动评比
				</div>
			</toolbar:enable>

			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="comparison_111">
					<li id="111">
						<cite></cite>
						<a
							href="<%=path%>/master/toManageComparison.htm?click=111">评比活动管理</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="comparison_112">
					<li id="112">
						<cite></cite>
						<a
							href="<%=path%>/master/toReceiveComparison.htm?click=112">评比活动报名</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="comparison_113">
					<li id="113">
						<cite></cite>
						<a
							href="<%=path%>/master/toExpertScoreList.htm?click=113">评比活动评分</a><i></i>
					</li>
				</toolbar:enable>
			</ul>
			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="comparison_114">
					<li id="114">
						<cite></cite>
						<a
							href="<%=path%>/master/toComparisonList.htm?click=114">评比活动审核</a><i></i>
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
	$("#leftH").css("height", (winHeight - 90));
}
//调用函数，获取数值
window.onresize = function() {
	leftHeight();
};
</script>
