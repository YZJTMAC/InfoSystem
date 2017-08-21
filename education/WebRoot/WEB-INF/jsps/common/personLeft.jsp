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
})
</script>
<script type="text/javascript">
$(function(){
	getRequestParam();
});
// 用于和福建网络研修平台对接实现单点登录,登陆后向对方平台发送请求并携带userid,idno和token
function getRequestParam(){
	var param = "${sessionScope.des_param}";
	var token = "${sessionScope.token}";
	$.ajax({
		type:"get",
		dataType:"JSONP",
		// 向福建网络研修平台发送请求,用于对方在本地进行cookie写操作
		//url:"http://fj.prerighthere.com/ExternalInterface/TeacherEduUserLogin.aspx",
		// 福建网络研修外网正式环境
		url:"http://fj.righthere.com.cn/ExternalInterface/TeacherEduUserLogin.aspx",
		data:{
			"param":param,
			"token":token
		},
		crossDomain:"true",
		success:function(data){
		},
		complete: function (data, status) {
		}
	});
}

</script>


<div id="leftH" class="leftNav" style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>工具栏
	</div>

	<dl class="leftmenu">

		<dd>
			<toolbar:enable uri="person_002">
				<div class="title">
					<span><img src="<%=path%>/images/leftico01.png" /> </span>个人中心设置
				</div>
			</toolbar:enable>
			<ul class="menuson" style="display: block;">
				<toolbar:enable uri="person_003">
					<li id="0">
						<cite></cite><a href="<%=path%>/person/personInfoPage.htm?click=0">个人信息</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="person_004">
					<li id="1">
						<cite></cite><a href="<%=path%>/person/personPsdPage.htm?click=1">修改密码</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="person_005">
					<li id="2">
						<cite></cite><a href="<%=path%>/message/messageManagement/toMessagePage.htm?click=2">短消息</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="person_006">
					<li id="3">
						<cite></cite><a href="<%=path%>/message/messageManagement/messageList.htm?click=3">通知</a><i></i>
					</li>
				</toolbar:enable>
				<toolbar:enable uri="person_007">
					<li id="4">
						<cite></cite><a href="<%=path%>/message/messageManagement/myMessageList.htm?click=4">我的通知</a><i></i>
					</li>
				</toolbar:enable>
				<%-- <toolbar:enable uri="person_005">
					<li id="2">
						<cite></cite><a href="<%=path%>/message/messageManagement/toMessagePageshenghe.htm?click=3">审核未通过通知</a><i></i>
					</li>
				</toolbar:enable> --%>
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




 class="icon1bg"

 class="CFF"