<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息查询</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/teacher/createTeacher.js">
		</script>
		<script type="text/javascript">
			teacherId = ${teacherId};
			//var eduBaseId = 0;
			//var eduJobId = 0;
		</script>
		<!--<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/teacher/commonTeacher.js">
		</script>
		--><script type="text/javascript"
			src="<%=basePathHeader%>/javascript/teacher/editeTeacher.js">
		</script>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.json-2.4.min.js" /></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js" /></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/common/commonValidate.js" /></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
		
<style>
.moreChoose dd {
	width: 650px;
}
</style>
		<link type="text/css" rel="stylesheet"
			href="file:///D:/1.%E9%9C%80%E6%B1%82-%E6%95%99%E5%B8%88%E7%BB%A7%E7%BB%AD%E6%95%99%E8%82%B2%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9Fmockup/teacherMIS_%E5%8E%9F%E5%9E%8BV2.0/editor/skins/default.css" />

<script type="text/javascript">
$(document).ready(function(e) {
	$(".select1").uedSelect( {
		width : 345
	});
	$(".select2").uedSelect( {
		width : 167
	});
	$(".select3").uedSelect( {
		width : 100
	});

	$("#area_v3").hide();
	$("#area_v2").hide();
	$("#divSchool").hide();

	$("#area1").change(function() {
		$("#area_v3").hide();
		$("#area_v2").hide();
		$("#divSchool").hide();

		var str = "";
		$("#area1 option:selected").each(function() {
			str += $(this).text() + "";
		});

		if (str == "广东省") {

			$("#area_v2").show();
		} else {

			$("#area_v2").hide();
		}

	});

	$("#area2").change(function() {
		$("#area_v3").hide();
		$("#divSchool").hide();
		var str = "";
		$("#area2 option:selected").each(function() {
			str += $(this).text() + "";
		});

		if (str == "广州市") {

			$("#area_v3").show();
		} else {

			$("#area_v3").hide();
		}

	});

	$("#area3").change(function() {
		$("#divSchool").hide();
		var str = "";
		$("#area3 option:selected").each(function() {
			str += $(this).text() + "";
		});

		if (str == "白云区") {
			$("#divSchool").show();
			$("#btnSchool").click();
		}

	});
	
	 $(".click").click(function(){
	  	$(".tip").fadeIn(200);
	  });
	  
	  $(".tiptop a").click(function(){
	  	$(".tip").fadeOut(200);
	  });
	
	  $(".sure").click(function(){
	  	$(".tip").fadeOut(100);
	  });
	
	  $(".cancel").click(function(){
	  	$(".tip").fadeOut(100);
	  });

});
</script>
</head>
	<body>
	<script id="addEduPartB" type="text/x-jquery-tmpl">
		<tr>
							<td>
								毕业院校：
							</td>
							<td colspan="2">
								<input id="{{= eduIdNum}}_educationGraduationSchool"  value="{{= educationGraduationSchool}}" type="text" class="scinput">
							</td>
							<td>
								毕业专业：
							</td>
							<td colspan="2">
								<input id="{{= eduIdNum}}_educationGraduationProfession"  value="{{= educationGraduationProfession}}" type="text" class="scinput">
							</td>
							<td>
								&nbsp;
							</td>
		</tr>
	</script>
	<script id="addEduPartA" type="text/x-jquery-tmpl">
					  <tr>
							<td width="75">
								第{{= flag}}学历{{= aa}}:
							</td>
							<td width="102" class="eduInfo" id="{{= eduIdNum}}" >
									<select id="{{= eduIdNum}}_educationExperience" class="select6" style="width: 100px;">
										<option value="1">
											未取得
										</option>
										<option value="1">
											初中
										</option>
										<option value="1">
											高中
										</option>
										<option value="1">
											中专
										</option>
										<option value="1">
											大专
										</option>
										<option value="1">
											本科
										</option>
										<option value="1">
											硕士研究生
										</option>
										<option value="1">
											博士研究生
										</option>
										<option value="1">
											博士后
										</option>
									</select>
							</td>
							<td width="75">
								获得学位：
							</td>
							<td width="102">
								<div class="uew-select">
									<select id="{{= eduIdNum}}_educationDegree"  class="select6" style="width: 100px;">
										<option value="1">
											未取得
										</option>
										<option value="1">
											学士
										</option>
										<option value="1">
											硕士
										</option>
										<option value="1">
											博士
										</option>
									</select>
								</div>
							</td>
							<td width="85">
								毕业时间：
							</td>
							<td>
								<INPUT id="{{= eduIdNum}}_educationGraduationTime" name="jobCommentDate" value="{{= time}}" style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; width: 100px; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc" class="Wdate scinput" onclick=WdatePicker() type=text realValue My97Mark="false"/>
							</td>
							<td>&nbsp;—<a href='###' class='deleteEdu'>删除</a></td>
						</tr>
						
	</script>
	
		<!-- top -->
		<div class="head">
			<%@include file="../common/top.jsp"%>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/left.jsp"%>
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
						信息
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							<span id="teacherName"></span>
						</h4><a class="huibtn_a"
						style="float: right; line-height: 18px; margin: 7px 0 0 10px;" onclick="javascript:window.history.back();">返回</a>
					</span>
					<span style="float: right;">
						<!--<a href="#" class="huibtn_a" style="margin-right:8px;">上一个</a><a href="#" class="huibtn_a" style="margin-right:8px;">下一个</a>-->
					</span>
				</div>

				<dl class="teacherdlxinxi">
					<dt>
						<img src="<%=basePathHeader%>/images/u8_normal.jpg" title="头像" />
					</dt>
					<dd>
						<span class="titlewidth">用户名：</span><span id="loginAccount"></span>
					</dd>
					<dd>
						<span class="titlewidth">密码：</span><span id="password"></span>
					</dd>
					<dd>
						<span class="titlewidth">姓名：</span><span id="realName"></span>
					</dd>
					<dd>
						<span class="titlewidth">性别：</span><span id="gender"></span>
					</dd>

					<dd>
						<span class="titlewidth">用户状态：</span><span id="status"></span>
					</dd>
					<dd>
						<span class="titlewidth">身份证号：</span><span id="idNumber"></span>
					</dd>
					<dd>
						<span class="titlewidth">教师编号：</span><span id="teacherNo"></span>
					</dd>
					<dd>
						<span class="titlewidth">所在学校：</span><span id="schoolName"></span>
					</dd>
				</dl>


				<div id="tab1" class="tabson" style="display: block;">

<!-- 
					<div class="tabformtitle">
						<span class="l">登录信息</span>
						<span class="r"><a href="###" onclick="saveA();"><img
									src="<%=basePathHeader%>/images/btn_save1.gif" title="保存"/>
						</a>&nbsp;&nbsp;
						</span>
					</div>
					<div class="contentBox" id="divA"　style="display: none">
						<form id="from1">
						<table border="0" cellspacing="0" cellpadding="0"
							style="display: block;" class="tab1">
							<tbody>
								<tr>
									<td width="85">
										用户名：
									</td>
									<td width="202">
										<input id="loginAccount"　name="loginAccount" type="text" class="scinput"/>
									</td>
									<td width="27">
										&nbsp;
									</td>
									<td width="73">
										密码：
									</td>
									<td width="213">
										<input id="password"　name="password" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										姓名：
									</td>
									<td>
										<input id="realName"　name="realName" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										性别：
									</td>
									<td>
										<select id="gender"　name="gender" class="select2" style="width: 167px;">
											<option value="0">请选择</option>
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										用户状态：
									</td>
									<td>
										<select id="status"　name="status" class="select2" style="width: 167px;">
											<option value="0">请选择</option>
											<option value="1">在职</option>
											<option value="2">离职</option>
										</select>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										身份证号：
									</td>
									<td>
										<input id="idNumber"　name="idNumber" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										教师编号：
									</td>
									<td>
										<input id="teacherNo"　name="teacherNo" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										&nbsp;
									</td>
									
								</tr>
								<tr>
									<td>
										所在学校：
									</td>
									<td >
										<select id="schoolId" name="schoolId" class="select2" style="width: 167px;">
												<option value="0">请选择</option>
												<option value="1">在职</option>
												<option value="2">离职</option>
											</select>
									</td>
								</tr>
								</tbody>
								</table>
								</form>
							</div>
			 -->		
					<div class="tabformtitle">
						<span class="l">基本信息</span>
						<span class="r"><a href="###" class="saveClick" onclick="saveB();"><img
									src="<%=basePathHeader%>/images/btn_save1.gif" title="保存"/>
						</a>&nbsp;&nbsp;<a id="B" class="click"　href="###"><img  src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
					</div>
					
					<div class="contentBox" id="divB" style="display: none">
					<form id="from2">
						<table border="0" cellspacing="0" cellpadding="0"
							style="display: block;" class="tab1">
							<tbody>
								<tr>
									<td width="85">
										曾用名：
									</td>
									<td width="202">
										<input id="teacherOldName" name="teacherOldName" type="text" class="scinput"/>
									</td>
									<td width="27">
										&nbsp;
									</td>
									<td width="73">
										姓名全拼：
									</td>
									<td width="213">
										<input id="teacherNameSpelling" name="teacherNameSpelling" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										出生日期：
									</td>
									<td>
										<input id="teacherBornDate" name="teacherBornDate" type="text" style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; width: 100px; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc" class="Wdate scinput" onclick=WdatePicker() type=text realValue My97Mark="false"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										政治面貌：
									</td>
									<td>
										<div class="uew-select">
											<select id="teacherPoliticalStatus" name="teacherPoliticalStatus" class="select2" style="width: 167px;">
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										籍 贯：
									</td>
									<td>
										<input id="teacherNativePlace" name="teacherNativePlace" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										民 族：
									</td>
									<td>
										<input id="teacherNation" name="teacherNation" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
										<td>
											健康状况
										</td>
										<td>
											<input id="teacherHealthCondition"
												name="teacherHealthCondition" type="text" class="scinput" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											国籍
										</td>
										<td>
											<select id="country"
												name="country" class="select2"
												style="width: 167px;">
											</select>
										</td>
									</tr>
								<tr>
									<td>
										手机号码：
									</td>
									<td>
										<input id="teacherPhoneNum" name="teacherPhoneNum" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										联系电话：
									</td>
									<td>
										<input id="teacherCallNum" name="teacherCallNum" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										QQ：
									</td>
									<td>
										<input id="teacherQq" name="teacherQq" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										Email：
									</td>
									<td>
										<input id="teacherEmail" name="teacherEmail" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										家庭住址：
									</td>
									<td>
										<input id="teacherFamilyLocal" name="teacherFamilyLocal" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										婚姻状况：
									</td>
									<td>
										<input type="radio" name="teacherMaritalStatus" value="1"/>
											已婚 <input type="radio" name="teacherMaritalStatus" value="0"/>
												未婚
									</td>
								</tr>
								 
							</tbody>
						</table>
						</form>
					</div>




					<div class="tabformtitle">
						<span class="l">教育经历</span>
						<span class="r"><a href="###" class="saveClick" onclick="saveC();"><img
									src="<%=basePathHeader%>/images/btn_save1.gif" title="修改"/>
						</a>&nbsp;&nbsp;<a id="C" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
					</div>

					<div class="contentBox" id="divC" style="display: none">
						<table border="0" cellspacing="0" cellpadding="0"
							style="display: block;" class="tab1">
							<tbody>
								   
								<tr id="flag">
									<td colspan="7" align="center">
										<input type="button" id="addBranchArea" name="" value="+添加一次教育经历"/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>



					<div class="tabformtitle" >
						<span class="l">工作信息</span>
						<span class="r"><a href="###" class="saveClick" onclick="saveD();"><img
									src="<%=basePathHeader%>/images/btn_modify.gif" title="修改"/>
						</a>&nbsp;&nbsp;<a id="D" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_shrink.gif"
									title="收起"/>
						</a>
						</span>
					</div>

					<div class="contentBox" id="divD" style="display: none">
						<form id="form4">
							<table width="645" border="0" cellpadding="0" cellspacing="0"
								class="tab1" style="display: block;">
								<tbody>
									<tr>
										<td width="96">
											教师资格种类：
										</td>
										<td width="212">
											<select id="jobQualificationType"
												　name="jobQualificationType" class="select2"
												style="width: 167px;">
											</select>
										</td>
										<td width="10">
											&nbsp;
										</td>
										<td width="113">
											获教师资格证时间：
										</td>
										<td width="169">
											<INPUT id="jobCertificateDate" name="jobCertificateDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick=WdatePicker() type=text
												realValue My97Mark="false" />
										</td>
									</tr>
									
									<tr>
										<td>
											教师资格证书号：
										</td>
										<td>
											<input id="jobCertificateNum" name="jobCertificateNum"
												type="text" class="scinput" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											参加工作时间：
										</td>
										<td>
											<INPUT id="jobWorkTime" name="jobWorkTime"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick=WdatePicker() type=text
												realValue My97Mark="false" />
										</td>
									</tr>
									
									<tr>
										<td>
											荣誉称号：
										</td>
										<td>
											<input id="rych" name="rych"
												type="text" class="scinput" />
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											特岗教师类别
										</td>
										<td>
											<select id="tgjs" name="tgjs"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											免费师范生类别：
										</td>
										<td>
										<select id="mfsfs" name="mfsfs"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											继续教育编号：
										</td>
										<td>
											<input id="jxjybh" name="jxjybh"
												type="text" class="scinput" />
										</td>
									</tr>
									
									<tr>
										<td>
											是否全日制师范专业毕业：
										</td>
										<td>
												<input type="radio" name="qrzsfzy" value="1" />
											是
											<input type="radio" name="qrzsfzy" value="0"
												checked="checked" />
											否
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											近三年培训情况：
										</td>
										<td>
											<input id="jsnpxqk" name="jsnpxqk"
												type="text" class="scinput" />
										</td>
									</tr>
									
									
									<tr>
										<td>
											普通话等级：
										</td>
										<td>
											<select id="pthdj" name="pthdj"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											从教起始年月：
										</td>
										<td>
											<input id="cjqsny" name="cjqsny"
												type="text" class="scinput" />
										</td>
									</tr>
									
									<tr>
										<td>
											五险一金：
										</td>
										<td>
											<input id="wxyj" name="wxyj"
												type="text" class="scinput" />
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											教师资格证种类：
										</td>
										<td>
											<select id="jszgz" name="jszgz"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											合同签订情况：
										</td>
										<td>
											<select id="contract" name="contract"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											月平均工资：
										</td>
										<td>
											<input id="salary" name="salary"
												type="text" class="scinput" />
										</td>
									</tr>
									<tr>
										<td>
											是否在编：
										</td>
										<td>
											<input type="radio" name="sfzb" value="1" />
											是
											<input type="radio" name="sfzb" value="0"
												checked="checked" />
											否
										</td>
										 
										<td>
											&nbsp;
										</td>
										<td>
											教师编制：
										</td>
										<td>
											<select id="adjustId" name="adjustId"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											岗位类别：
										</td>
										<td>
											<select id="gwlb" name="gwlb"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 
										<td>
											&nbsp;
										</td>
										<td>
											岗位等级：
										</td>
										<td>
											<select id="gwdj" name="gwdj"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											任教时间：
										</td>
										<td>
											<INPUT id="jobWorkDate" name="jobWorkDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick=WdatePicker() type=text
												realValue My97Mark="false" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											(评)教师职称：
										</td>
										<td>
											<select id="jobCommentPosition" name="jobCommentPosition"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											(评)职称时间：
										</td>
										<td>
											<INPUT id="jobCommentDate" name="jobCommentDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick=WdatePicker() type=text
												realValue My97Mark="false" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											(聘)教师职称：
										</td>
										<td>
											<select id="jobRecruitmentPosition"
												name="jobRecruitmentPosition" class="select2"
												style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											(聘)职称时间：
										</td>
										<td>
											<INPUT id="jobRecruitmentDate" name="jobRecruitmentDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick="WdatePicker();" type="text"
												realValue My97Mark="false" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											学校行政职务：
										</td>
										<td>
											<select id="jobSchoolAdministrationOfficeType"
												　name="jobSchoolAdministrationOfficeType" class="select2"
												style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											当前任教学段：
										</td>
										<td id="sectionList">
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											当前任教学科：
										</td>
										<td id="subjectList">
											请先选择学段
										</td>
									</tr>
									<tr>
										<td>
											是否学科带头人：
										</td>
										<td>
											<input type="radio" name="jobSubjectLeader" value="1" />
											是
											<input type="radio" name="jobSubjectLeader" value="0"
												checked="checked" />
											否
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											是否骨干教师：
										</td>
										<td>
											<input type="radio" name="jobCoreTeacher" value="1" />
											是
											<input type="radio" name="jobCoreTeacher" value="0"
												checked="checked" />
											否
										</td>
									</tr>
									<tr>
										<td>
											是否为班主任：
										</td>
										<td>
											<input type="radio" name="jobWhetherTeacher" value="1" />
											是
											<input type="radio" name="jobWhetherTeacher" value="0"
												checked="checked" />
											否
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											是否为特级教师：
										</td>
										<td>
											<input type="radio" name="jobWhetherGradeTeacher" value="1" />
											是
											<input type="radio" name="jobWhetherGradeTeacher" value="0"
												checked="checked" />
											否
										</td>
									</tr>
									<tr>
										<td>
											国培计划农村骨干教师：
										</td>
										<td>
											<input type="radio" name="jobCountyRuralTeacher" value="1" />
											是
											<input type="radio" name="jobCountyRuralTeacher" value="0"
												checked="checked" />
											否
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											民办学校专职教师：
										</td>
										<td>
											<input type="radio" name="jobPrivateSchoolTeacher" value="1" />
											是
											<input type="radio" name="jobPrivateSchoolTeacher" value="0"
												checked="checked" />
											否
										</td>
									</tr>
									<tr>
										<td>
											特岗教师：
										</td>
										<td>
											<input type="radio" name="jobSpecialTeacher" value="1" />
											是
											<input type="radio" name="jobSpecialTeacher" value="0"
												checked="checked" />
											否
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>


				</div>


				<div id="tab2" class="tabson" style="display: none;">
					45ws
				</div>


				<div id="tab3" class="tabson" style="display: none;">
					86fd
				</div>


				<div id="tab4" class="tabson" style="display: none;">
					0-oiuy
				</div>

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
