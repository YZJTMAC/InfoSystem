<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师信息</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/createTeacher.js"></script>
		<script type="text/javascript">
			teacherId = ${teacherId};
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/commonTeacherBodyEdite.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/common/commonUploadUserPhoto.js"></script>
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
								{{= flag}}学历:
							</td>
							<td width="102" class="eduInfo" id="{{= eduIdNum}}" >
									<select id="{{= eduIdNum}}_educationExperience" class="select6 eduHis" style="width: 100px;">
									</select>
							</td>
							<td width="75">
								获得学位：
							</td>
							<td width="102">
									<select id="{{= eduIdNum}}_educationDegree"  class="select6" style="width: 100px;">
									</select>
							</td>
							<td width="85">
								毕业时间：
							</td>
							<td>
								<INPUT id="{{= eduIdNum}}_educationGraduationTime" value="{{= time}}" name="jobCommentDate" style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; width: 100px; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc" class="Wdate scinput" onclick=WdatePicker() type=text realValue My97Mark="false"/>
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
						信息
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							<span id="teacherName"></span>
						</h4><a href="###" onclick="javascript:window.history.back();" class="huibtn_a"
						style="float: right; line-height: 18px; margin: 7px 0 0 10px;">返回</a>
					</span>
					<span style="float: right;">
						<!--<a href="#" class="huibtn_a" style="margin-right:8px;">上一个</a><a href="#" class="huibtn_a" style="margin-right:8px;">下一个</a>-->
					</span>
				</div>

				<dl class="teacherdlxinxi">
					<dt style="height: 140px">
						<img id="photo" style="height: 99px; width:71px"  src="<%=basePathHeader%>/uploadFile/photo/u8_normal.jpg" title="头像" />
						<a href="javascript:;" onclick="showUploadPhoto();" class="huibtn_a" style="TEXT-ALIGN: center; MARGIN-TOP: 10px; DISPLAY: block">修改头像</a>
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
					<div class="tabformtitle">
						<span class="l">基本信息</span>
						<span class="r"><a href="###" class="saveClick" onclick="saveB();"><img
									src="<%=basePathHeader%>/images/btn_save1.gif" title="保存"/>
						</a>&nbsp;&nbsp;<a id="B" class="click"　href="###"><img  src="<%=basePathHeader%>/images/btn_spread.gif"
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
										<input id="teacherOldName" name="teacherOldName" type="text" class="scinput" maxlength="20"/>
									</td>
									<td width="27">
										&nbsp;
									</td>
									<td width="73">
										姓名全拼：
									</td>
									<td width="213">
										<input id="teacherNameSpelling" name="teacherNameSpelling" type="text" class="scinput" maxlength="20"/>
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
										<select id="teacherPoliticalStatus" name="teacherPoliticalStatus" class="select2">
										</select>
									</td>
								</tr>
								<tr>
									<td>
										籍 贯：
									</td>
									<td>
										<input id="teacherNativePlace" name="teacherNativePlace" type="text" class="scinput" maxlength="30"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										民 族：
									</td>
									<td>
										<input id="teacherNation" name="teacherNation" type="text" class="scinput" maxlength="20"/>
									</td>
								</tr>
								<tr>
										<td>
											健康状况
										</td>
										<td>
											<input id="teacherHealthCondition"
												name="teacherHealthCondition" type="text" class="scinput"  maxlength="30"/>
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
										<input id="teacherPhoneNum" name="teacherPhoneNum" type="text" class="scinput" maxlength="11"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										联系电话：
									</td>
									<td>
										<input id="teacherCallNum" name="teacherCallNum" type="text" class="scinput" maxlength="20"/>
									</td>
								</tr>
								<tr>
									<td>
										QQ：
									</td>
									<td>
										<input id="teacherQq" name="teacherQq" type="text" class="scinput" maxlength="20"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										Email：
									</td>
									<td>
										<input id="teacherEmail" name="teacherEmail" type="text" class="scinput" maxlength="30"/>
									</td>
								</tr>
								<tr>
									<td>
										家庭住址：
									</td>
									<td>
										<input id="teacherFamilyLocal" name="teacherFamilyLocal" type="text" class="scinput" maxlength="50"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										入党时间:
									</td>
									<td>
										<input id="partyTime" name="partyTime" type="text" 
										style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; 
										width: 169px; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc" 
										class="Wdate scinput" onclick=WdatePicker() type=text realValue My97Mark="false"/>
									</td>
								</tr>
								 <tr>
								 <td>
										婚姻状况：
									</td>
									<td>
										<input type="radio" name="teacherMaritalStatus" value="1"/>
											已婚 <input type="radio" name="teacherMaritalStatus" value="0"/>
												未婚
									</td>
									
									<td>
										&nbsp;
									</td>
									<td>
										
									</td>
									<td>
									
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
						</a>&nbsp;&nbsp;<a id="C" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_spread.gif"
									title="收起"/>
						</a>
						</span>
					</div>

					<div class="contentBox" id="divC"  style="display: none">
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
									src="<%=basePathHeader%>/images/btn_save1.gif" title="修改"/>
						</a>&nbsp;&nbsp;<a id="D" href="###" class="click"><img src="<%=basePathHeader%>/images/btn_spread.gif"
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
											教师资格证种类：
										</td>
										<td>
											<select id="jszgz" name="jszgz"
												class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											教师资格证书号：
										</td>
										<td>
											<input id="jobCertificateNum" name="jobCertificateNum"
												type="text" class="scinput" maxlength="30"/>
										</td>
										
									</tr>
									
									<tr>
										<td>
											荣誉称号：
										</td>
										<td>
											<input id="rych" name="rych"
												type="text" class="scinput" maxlength="500"/>
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
												type="text" class="scinput" maxlength="30"/>
										</td>
									</tr>
									
									<tr>
										<td>
											从教起始时间：
										</td>
										<td>
											<!--<input id="cjqsny" name="cjqsny"
												type="text" class="scinput" />-->
											 <input id="cjqsny" name="cjqsny" type="text" class="Wdate scinput" 
											style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
											class="Wdate scinput" onclick=WdatePicker() realValue My97Mark="false"
											/> 
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											近三年培训情况：
										</td>
										<td>
											<input id="jsnpxqk" name="jsnpxqk"
												type="text" class="scinput" maxlength="500"/>
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
											五险一金：
										</td>
										<td>
											<input id="wxyj" name="wxyj"
												type="text" class="scinput" maxlength="500"/>
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
												type="text" class="scinput" maxlength="100"/>
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
											聘任岗位等级时间:
										</td>
										<td>
											<input id="postGrade" name="postGrade"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick="WdatePicker();" type="text"
												realValue My97Mark="false" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											离岗待退时间：
										</td>
										<td>
											<input id="postBack" name="postBack"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick="WdatePicker();" type="text"
												realValue My97Mark="false" />
										</td>
									</tr>
									<tr>
										<td>
											(评)职称时间：
										</td>
										<td>
											<input id="jobCommentDate" name="jobCommentDate"
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
											(聘)职称时间：
										</td>
										<td>
											<input id="jobRecruitmentDate" name="jobRecruitmentDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick="WdatePicker();" type="text"
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
											是否名校长培养对象：
										</td>
										<td>
											<select id="eliteTraining" name="eliteTraining"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											是否教学名师：
										</td>
										<td>
											<select id="teachingMaster" name="teachingMaster"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											是否学科带头人：
										</td>
										<td>
											<select id="jobSubjectLeader" name="jobSubjectLeader"
												class="select2" style="width: 167px;">
											</select>
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											是否骨干教师:
										</td>
										<td>
											<select id="jobCoreTeacher" name="jobCoreTeacher" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
									<td>
										参加工作时间：
									</td>
									<td>
										<input id="jobWorkTime" name="jobWorkTime"
											style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
											class="Wdate scinput" onclick=WdatePicker() type=text
											realValue My97Mark="false" />
									</td>
										<td>
											&nbsp;
										</td>
										<td>
											本校任教起始时间：
										</td>
										<td>
											<input id="jobWorkDate" name="jobWorkDate"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick=WdatePicker() type=text
												realValue My97Mark="false" />
										</td>
									</tr>
									
									<tr>
										<td>
											借调分流时间:
										</td>
										<td>
											<INPUT id="jdflTime" name="jdflTime"
												style="BORDER-BOTTOM-COLOR: #ced9df; LINE-HEIGHT: 32px; BORDER-TOP-COLOR: #a7b5bc; HEIGHT: 32px; BORDER-RIGHT-COLOR: #ced9df; BORDER-LEFT-COLOR: #a7b5bc"
												class="Wdate scinput" onclick="WdatePicker();" type="text"
												realValue My97Mark="false" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											借调分流单位:
										</td>
										<td>
											<input id="jdfldw" name="jdfldw"
												type="text" class="scinput" maxlength="100"/>
										</td>
									</tr>
									<!-- 添加备注 -->
									<tr>
									<td>
										学校行政职务：
									</td>
									<td>
										<select id="jobSchoolAdministrationOfficeType"
											　name="jobSchoolAdministrationOfficeType" class="select2"
											style="width: 167px;">
										</select>
									</td>
										<td>
											&nbsp;
										</td>
										<td>
											备注:
										</td>
										<td>
											<input id="remark" name="remark" type="text" class="scinput" maxlength="100"/>
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
											是否全日制师范专业毕业：
										</td>
										<td>
												<input type="radio" name="qrzsfzy" value="1" />
											是
											<input type="radio" name="qrzsfzy" value="0"
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
				</div>
				
				<!-- 照片 选择 开始 -->
				<div class="tip14" id="XXshow" style="display: none;">
					<div class="tiptop tiptop17">
						<span>选择头像</span><a href="javascript:;"
							onclick="document.getElementById('XXshow').style.display='none';"></a>
					</div>
					<div class="XXshowContent">
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 40px auto;">
							<tr>
								<td></td>
								<td>
									<input id="photoFile" type="file" name="photoFile"
										onchange="uploadPhotoFile()" />
									支持图片格式：.jpg/.png/.bmp/.gif
								</td>
							</tr>
							<tr>
								<td>
									头像：
								</td>
								<td>
								<IMG id="photoTemp" title="头像" src="<%=basePathHeader%>/uploadFile/photo/u8_normal.jpg" style="height: 155px; width: 110px; border: 1px solid #eee; margin-top: 10px;">
									<p style="width: 200px; text-align: center; margin-top: 10px;">
										最小尺寸：155×110,建议上传证件照片，在项目打印中有可能会使用到。
									</p>
								</td>
							</tr>
						</table>
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto;">
							<tr>
								<td align="center">
									<input type="hidden" id="imageSrcTemp" />
									<input type="button" onclick="savePhoto()" class="btn true2" value="确定" />
								</td>
								<td width="30">
									&nbsp;
								</td>
								<td align="center">
									<input type="button" class="btn cancl" value="取 消" />
								</td>
							</tr>
						</table>
		
					</div>
				</div>
				<!-- 照片 选择 结束 -->			
				
			<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
	</body>
</html>
