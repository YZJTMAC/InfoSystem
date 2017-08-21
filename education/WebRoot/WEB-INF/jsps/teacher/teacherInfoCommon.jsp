<%@ page pageEncoding="UTF-8"%>
<%@include file="../common/pathHead.jsp"%>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js" ></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherJobChangeInfo.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherInfo.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script id="addEduPartC" type="text/x-jquery-tmpl">
		<div class="contentBox">
					<table border="0" cellspacing="0" cellpadding="0"
						style="display: block; width: 100%" class="tab1">
						<tr>
							<td width="150"></td>
							<td width="247">
								<b>调动前信息：<b>
							</td>
							<td width="247">
								<b>调动后信息：<b>
							</td>
						</tr>
						<tr>
							<td width="150">
								(评)教师职称：
							</td>
							<td width="247" id="jobCommentPosition_old">
							</td>
							<td width="247" id="jobCommentPosition_new">
							</td>
						</tr>
						<tr>
							<td>
								(聘)教师职称：
							</td>
							<td id="jobRecruitmentPosition_old">
							</td>
							<td id="jobRecruitmentPosition_new">
							</td>
						</tr>
						<tr>
							<td>
								学校行政职务：
							</td>
							<td id="jobSchoolAdministrationOffice_old">
							</td>
							<td id="jobSchoolAdministrationOffice_new">
							</td>
						</tr>
						<tr>
							<td>
								当前任教学段/学科：
							</td>
							<td id="jobFormerTeachingSubject_old">

							</td>
							<td id="jobFormerTeachingSubject_new">

							</td>
						</tr>
						<tr>
							<td>
								是否骨干教师：
							</td>
							<td id="jobCoreTeacher_old">

							</td>
							<td id="jobCoreTeacher_new">

							</td>
						</tr>
						<tr>
							<td>
								是否为班主任：
							</td>
							<td id="jobWhetherTeacher_old">

							</td>
							<td id="jobWhetherTeacher_new">

							</td>
						</tr>
						<tr>
							<td>
								国培计划农村骨干教师：
							</td>
							<td id="jobCountyRuralTeacher_old">

							</td>
							<td id="jobCountyRuralTeacher_new">

							</td>
						</tr>

						<tr>
							<td>
								调动说明：
							</td>
							<td id="mobilizeMark">
							</td>
						</tr>
						<tr id="auditHtml">
							<td>
								审核说明：
							</td>
							<td id="auditOption">
							</td>
						</tr>
					</table>
				</div>
	</script>
<script type="text/javascript">
	var teacherId = ${teacherId};
</script>
     <div class="chauxnJS jsTool">
     <span style="float:left;"><h4 style="float:left;"><span id="teacherName"></span> </h4>老师的资料信息</span>
     <span style="float:right;"><!--<a href="#" class="huibtn_a" style="margin-right:8px;">上一个</a><a href="#" class="huibtn_a" style="margin-right:8px;">下一个</a>--></span>
     </div>
    
    
    <dl class="teacherdlxinxi">
    <dt style="height: 140px"><img id="photo" src="<%=basePathHeader%>/images/u8_normal.jpg"  title="头像" /></dt>
    <dd><span class="titlewidth">用户名：</span><span id="loginAccount"></span></dd>
    <dd><span class="titlewidth">密码：</span><span id="password"></span></dd>
    <dd><span class="titlewidth">姓名：</span><span id="realName"></span></dd>
    <dd><span class="titlewidth">性别：</span><span id="gender"></span></dd>
    
    <dd><span class="titlewidth">身份证号：</span><span id="idNumber"></span></dd>
    <dd><span class="titlewidth">教师编号：</span><span id="teacherNo"></span></dd>
    <dd><span class="titlewidth">所在学校：</span><span id="schoolName"></span></dd>
    <dd><span class="titlewidth">用户状态：</span><span id="status"></span></dd>
    </dl>
    <div id="toolsli" class="toolsli">
    <ul class="toollist">
    <li><a href="#tab1" class="currentab"><img src="<%=basePathHeader%>/images/i07.png"></a><h2>教师信息</h2></li>
    <li><a href="#tab2" ><img src="<%=basePathHeader%>/images/i02.png"></a><h2>审核情况</h2></li>
    <li><a href="#tab3" id="JobtransferHis" ><img src="<%=basePathHeader%>/images/i06.png"></a><h2>工作记录</h2></li>
    <li><a href="#tab4" id="commentHis" ><img src="<%=basePathHeader%>/images/i05.png"></a><h2>培训记录</h2></li>
    <li><a href="#tab5" onclick='window.open("<%=basePathHeader%>/teacher/teachermanage/showAndPrintTeacherPage.htm?teahcerId=${teacherId}");'><img src="<%=basePathHeader%>/images/i01.png"></a><h2>预览打印</h2></li>
    </ul>
    </div>
    
    <div id="tab1" class="tabson" style="display: block;">
    <div class="tabformtitle">
						<span class="l">基本信息</span>
						<span class="r">&nbsp;&nbsp;<a id="B" class="click"　href="###"><img  src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
					</div>
    <div class="contentBox" id="divB">
    <table border="0" cellspacing="0" cellpadding="0" style="display:block;" class="tab1">
      <tr>
        <td width="85">曾用名：</td>
        <td width="202"><span id="teacherOldName"></span></td>
        <td width="27">&nbsp;</td>
        <td width="73">姓名全拼：</td>
        <td width="213"><span id="teacherNameSpelling"></span></td>
      </tr>
      <tr>
        <td>出生日期：</td>
        <td><span id="teacherBornDate"></span></td>
        <td>&nbsp;</td>
        <td>政治面貌：</td>
        <td><span id="teacherPoliticalStatus"></span></td>
      </tr>
      <tr>
        <td>籍 贯：</td>
        <td><span id="teacherNativePlace"></span></td>
        <td>&nbsp;</td>
        <td>民 族：</td>
        <td><span id="teacherNation"></span></td>
      </tr>
       <tr>
		<td>
			健康状况：
		</td>
		<td>
		<span id="teacherHealthCondition"></span>
		</td>
		<td>
			&nbsp;
		</td>
		<td>
			国籍：
		</td>
		<td><span id="country"></span>
		</td>
	</tr>
      <tr>
        <td>手机号码：</td>
        <td><span id="teacherPhoneNum"></span></td>
        <td>&nbsp;</td>
        <td>联系电话：</td>
        <td><span id="teacherCallNum"></span></td>
      </tr>
      <tr>
        <td>QQ：</td>
        <td><span id="teacherQq"></span></td>
        <td>&nbsp;</td>
        <td>Email：</td>
        <td><span id="teacherEmail"></span></td>
      </tr>
      <tr>
        <td>家庭住址：</td>
        <td><span id="teacherFamilyLocal"></span></td>
        <td>&nbsp;</td>
        <td>婚姻状况：</td>
        <td><span id="teacherMaritalStatus"></span></td>
      </tr>
      
    </table>
    </div>
    
    
    
    <div class="tabformtitle">
						<span class="l">教育经历</span>
						<span class="r">&nbsp;&nbsp;<a id="C" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
					</div>
    <div class="contentBox" id="divC">
    <table border="0" cellspacing="0" cellpadding="0" style="display:block;" class="tab1" id="educationId">
      <tr>
        <td colspan="7" align="center"><input type="button" name="" value="+添加一次教育经历" /></td>
      </tr>
	</table>
    </div>
    
    
    <div class="tabformtitle" >
						<span class="l">工作信息</span>
						<span class="r">&nbsp;&nbsp;<a id="D" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
	</div>
    <div class="contentBox" id="divD">
    <table width="645" border="0" cellpadding="0" cellspacing="0" class="tab1" style="display:block;" id="jobInfos">
      <tr>
        <td width="96">教师资格种类：</td>
        <td width="212" id="jobQualificationType"></td>
        <td width="10">&nbsp;</td>
        <td width="113" >获教师资格证时间：</td>
        <td width="169" id="jobCertificateDate"></td>
      </tr>
      <tr>
        <td>教师资格证书号：</td>
        <td id="jobCertificateNum"></td>
        <td>&nbsp;</td>
        <td>参加工作时间：</td>
        <td id="jobWorkTime"></td>
      </tr>
       <!-- 补充 工作属性 begin -->
      <tr>
										<td>
											荣誉称号：
										</td>
										<td id="rych">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											特岗教师类别
										</td>
										<td id="tgjs">
										</td>
									</tr>
									
									<tr>
										<td>
											免费师范生类别：
										</td>
										<td id="mfsfs">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											继续教育编号：
										</td>
										<td id="jxjybh">
										</td>
									</tr>
									
									<tr>
										<td>
											是否全日制师范专业毕业：
										</td>
										<td id="qrzsfzy">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											近三年培训情况：
										</td>
										<td id="jsnpxqk">
										</td>
									</tr>
									
									
									<tr>
										<td>
											普通话等级：
										</td>
										<td id="pthdj">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											从教起始时间：
										</td>
										<td id="cjqsny">
										</td>
									</tr>
									
									<tr>
										<td>
											五险一金：
										</td>
										<td id="wxyj">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											教师资格证种类：
										</td>
										<td id="jszgz">
										</td>
									</tr>
									
									<tr>
										<td>
											合同签订情况：
										</td>
										<td id="contract">
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											月平均工资：
										</td>
										<td id="salary">
										</td>
									</tr>
									<tr>
										<td>
											是否在编：
										</td>
										<td id="sfzb">
										</td>
										 
										<td>
											&nbsp;
										</td>
										<td>
											教师编制：
										</td>
										<td id="adjustId">
										</td>
									</tr>
									<tr>
										<td>
											岗位类别：
										</td>
										<td id="gwlb">
										</td>
										 
										<td>
											&nbsp;
										</td>
										<td>
											岗位等级：
										</td>
										<td id="gwdj">
										</td>
									</tr>
									
									<!-- 补充工作属性 end -->
      <tr>
        <td>本校任教起始时间：</td>
        <td id="jobWorkDate"></td>
        <td>&nbsp;</td>
        <td>(评)教师职称：</td>
        <td id="jobCommentPosition"></td>
      </tr>
      <tr>
        <td>(评)职称时间：</td>
        <td id="jobCommentDate"></td>
        <td>&nbsp;</td>
        <td>(聘)教师职称：</td>
        <td id="jobRecruitmentPosition"></td>
      </tr>
      <tr>
        <td>(聘)职称时间：</td>
        <td id="jobRecruitmentDate"></td>
        <td>&nbsp;</td>
        <td>学校行政职务：</td>
        <td id="jobSchoolAdministrationOffice"></td>
      </tr>
      <tr>
        <td>离岗待退时间：</td>
        <td id="postBack"></td>
        <td>&nbsp;</td>
        <td>聘任岗位等级时间:</td>
        <td id="postGrade"></td>
      </tr>
      <tr>
        <td>是否名校长培养对象：</td>
        <td id="eliteTraining"></td>
        <td>&nbsp;</td>
        <td>是否教学名师：</td>
        <td id="teachingMaster"></td>
      </tr>
      <tr>
        <td>借调分流时间:</td>
        <td id="jdflTime"></td>
        <td>&nbsp;</td>
        <td>借调分流单位:</td>
        <td id="jdfldw"></td>
      </tr>
      <tr>
        <td>当前任教学段：</td>
        <td id="jobFormerTeachingSection"></td>
        <td>&nbsp;</td>
        <td>当前任教学科：</td>
        <td id="jobFormerTeachingSubject"> </td>
      </tr>
      <tr>
        <td>学科带头人：</td>
        <td id="jobSubjectLeader"></td>
        <td>&nbsp;</td>
        <td>骨干教师：</td>
        <td id="jobCoreTeacher"></td>
      </tr>
      <tr>
        <td>是否为班主任：</td>
        <td id="jobWhetherTeacher">  </td>
        <td>&nbsp;</td>
        <td>是否为特级教师：</td>
        <td id="jobWhetherGradeTeacher"></td>
      </tr>
      <tr>
        <td>国培计划农村骨干教师：</td>
        <td id="jobCountyRuralTeacher">  </td>
        <td>&nbsp;</td>
        <td>民办学校专职教师：</td>
        <td id="jobPrivateSchoolTeacher"></td>
      </tr>
      <tr>
        <td>特岗教师：</td>
        <td id="jobSpecialTeacher"></td>
        <td>&nbsp;</td>
        <td>备注: </td>
        <td id="remark"></td>
      </tr>
    </table>
    </div> 
    </div>
    <div id="tab2" class="tabson" style="display: block;">
    	  <div class="tabformtitle"><span class="l">审核情况</span></div>
    
    <div class="contentBox">
    <table width="645" border="0" cellpadding="0" cellspacing="0" class="tab1" style="display:block;" id ="auditId">
    </table>
    </div>
    <div class="tabformtitle"><span class="l">信息变更记录</span> <span class="r">
    &nbsp;&nbsp;</span></div>
    
    <div class="contentBox" id ='auditHistry'>
    </div>
    </div>
    <div id="tab3" class="tabson" style="display: block;">
    <div class="tabformtitle"><span class="l">工作记录</span> <span class="r">
    &nbsp;&nbsp;</span></div>
    <div class="contentBox" id ='jobtransferHistory'>
    	<TABLE style="DISPLAY: block" class=tab1 border=0 cellSpacing=0 cellPadding=0 >
    	<TBODY id ="Jobtransfer">
    	</TBODY>
    	</table>
    </div>
    </div>
    <div id="tab4" class="tabson" style="display: block;">
    <div class="tabformtitle"><span class="l">培训记录</span> <span class="r">
    &nbsp;&nbsp;</span></div>
     <div class="contentBox"  >
    	<TABLE style="DISPLAY: block" class=tab1 border=0 cellSpacing=0 cellPadding=0 >
    	<TBODY id ="commonHis">
    	</TBODY>
    	</table>
    </div>
    </div>
    <div id="tab5" class="tabson" style="display: block;">
    </div>
    
    
 <!-- 
    
    <div class="tabformtitle"><span class="l">我的历次学校记录</span></div>
    
    <div class="contentBox">
    <table width="645" border="0" cellpadding="0" cellspacing="0" class="tab1" style="display:block;">
       <thead>
    	<tr>
        
       
        <th width="226" >学校</th>
		<th width="96" >入职时间</th>
		<th width="96" >离职时间</th>
        <th width="96" >操作人</th>
        <th width="96" >操作时间</th>
         
        </tr>
        </thead>
        <tbody id="schoolId">
        
       
    
        </tbody>
 
    </table>
    </div> 
    
	
    -->

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


$("#toolsli ul").idTabs(function(id){
				    //switch(id){
				     // case "#tab5": window.open("<%=basePathHeader%>/teacher/teachermanage/showAndPrintTeacherPage.htm?teahcerId=${teacherId}");break;
				    //} return true;
				  });
</script>
<div class="tip1" style="height: 600px; width: 600px;">
							<div class="tiptop2">
								<span>调动详情</span><span></span><a></a>
							</div>

							<div class="tipinfo"
								style="width: 530px; height: 440px; padding: 10px; margin: 0;">

							</div>
							<Br />
							<div class="tipbtn">
								&nbsp;
								<input name="" type="button" class="cancel" value="取消" />
							</div>

</div>