<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师信息审核</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/auditTeacher.js"></script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp" >
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/teacherLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="teacherGLY_1.1.html">教师信息</a>
					</li>
					<li>
						<a href="teacherGLY_1.1.html">教师信息管理</a>
					</li>
					<li>
						审核
					</li>
				</ul>
			</div>
			<div class="formbody">
				<jsp:include page="teacherInfoCommon.jsp">
					<jsp:param name="teacherId" value="${teacherId}" />
				</jsp:include>
				<div class="formtitle"><span>审核</span></div>
			    <ul class="forminfo">
			    <li><label>是否通过：</label><cite><input name="auditTeacher" type="radio" value="true" checked="checked" />审核通过&nbsp;&nbsp;&nbsp;&nbsp;<input name="auditTeacher" type="radio" value="false" />审核不通过</cite></li>
			    
			    <li><label>审核意见：</label><textarea id="memo" name="" cols="" rows="" class="textinput"></textarea></li>
			    <li><label>&nbsp;</label><input name="" type="button" onclick="teacherAudit(${teacherId});" class="btn" value="提交审核"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="btn goback" value="取消"/></li>
			    </ul>
			</div>
		</div>
	<script type="text/javascript">
	(function() {
		var dep = {
			"jQuery" : "js/jquery.js"
		};
		var init = function() {
			(function($) {
				$.fn.idTabs = function() {
					var s = {};
					for ( var i = 0; i < arguments.length; ++i) {
						var a = arguments[i];
						switch (a.constructor) {
						case Object:
							$.extend(s, a);
							break;
						case Boolean:
							s.change = a;
							break;
						case Number:
							s.start = a;
							break;
						case Function:
							s.click = a;
							break;
						case String:
							if (a.charAt(0) == '.')
								s.currentab = a;
							else if (a.charAt(0) == '!')
								s.event = a;
							else
								s.start = a;
							break;
						}
					}
					if (typeof s['return'] == "function")
						s.change = s['return'];
					return this.each(function() {
						$.idTabs(this, s);
					});
				}
				$.idTabs = function(tabs, options) {
					var meta = ($.metadata) ? $(tabs).metadata() : {};
					var s = $.extend( {}, $.idTabs.settings, meta, options);
					if (s.currentab.charAt(0) == '.')
						s.currentab = s.currentab.substr(1);
					if (s.event.charAt(0) == '!')
						s.event = s.event.substr(1);
					if (s.start == null)
						s.start = -1;
					var showId = function() {
						if ($(this).is('.' + s.currentab))
							return s.change;
						var id = "#" + this.href.split('#')[1];
						var aList = [];
						var idList = [];
						$("a", tabs).each(function() {
							if (this.href.match(/#/)) {
								aList.push(this);
								idList.push("#" + this.href.split('#')[1]);
							}
						});
						if (s.click
								&& !s.click.apply(this, [ id, idList, tabs, s ]))
							return s.change;
						for (i in aList)
							$(aList[i]).removeClass(s.currentab);
						for (i in idList)
							$(idList[i]).hide();
						$(this).addClass(s.currentab);
						$(id).show();
						return s.change;
					}
					var list = $("a[href*='#']", tabs).unbind(s.event, showId)
							.bind(s.event, showId);
					list.each(function() {
						$("#" + this.href.split('#')[1]).hide();
					});
					var test = false;
					if ((test = list.filter('.' + s.currentab)).length)
						;
					else if (typeof s.start == "number"
							&& (test = list.eq(s.start)).length)
						;
					else if (typeof s.start == "string"
							&& (test = list.filter("[href*='#" + s.start + "']")).length)
						;
					if (test) {
						test.removeClass(s.currentab);
						test.trigger(s.event);
					}
					return s;
				}
				$.idTabs.settings = {
					start : 0,
					change : false,
					click : null,
					currentab : ".currentab",
					event : "!click"
				};
				$.idTabs.version = "2.2";
				$(function() {
					$(".idTabs").idTabs();
				});
			})(jQuery);
		}
		var check = function(o, s) {
			s = s.split('.');
			while (o && s.length)
				o = o[s.shift()];
			return o;
		}
		var head = document.getElementsByTagName("head")[0];
		var add = function(url) {
			var s = document.createElement("script");
			s.type = "text/javascript";
			s.src = url;
			head.appendChild(s);
		}
		var s = document.getElementsByTagName('script');
		var src = s[s.length - 1].src;
		var ok = true;
		for (d in dep) {
			if (check(this, d))
				continue;
			ok = false;
			add(dep[d]);
		}
		if (ok)
			return init();
		add(src);
	})();
	
	$("#toolsli ul").idTabs();
	</script>
	</body>
</html>
