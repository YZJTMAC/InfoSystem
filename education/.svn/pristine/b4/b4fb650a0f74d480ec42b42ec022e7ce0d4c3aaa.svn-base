<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师信息</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			teacherId = ${teacherId};
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/commonTeacher.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/showAndPrintTeacher.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
	</head>
	<body>
	<script id="addEduPartB" type="text/x-jquery-tmpl">
		<tr>
							<td>
								毕业院校：
							</td>
							<td colspan="2">
								<input disabled="disabled" id="{{= eduIdNum}}_educationGraduationSchool"  value="{{= educationGraduationSchool}}" type="text" class="scinput">
							</td>
							<td>
								毕业专业：
							</td>
							<td colspan="2">
								<input disabled="disabled" id="{{= eduIdNum}}_educationGraduationProfession"  value="{{= educationGraduationProfession}}" type="text" class="scinput">
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
									<select disabled="disabled"  id="{{= eduIdNum}}_educationExperience" class="select6 eduHis" style="width: 100px;">
									</select>
							</td>
							<td width="75">
								获得学位：
							</td>
							<td width="102">
									<select disabled="disabled"  id="{{= eduIdNum}}_educationDegree"  class="select6" style="width: 100px;">
									</select>
							</td>
							<td width="85">
								毕业时间：
							</td>
							<td>
								<INPUT disabled="disabled" id="{{= eduIdNum}}_educationGraduationTime" value="{{= time}}" name="jobCommentDate" type="text" class="scinput"/>
							</td>
							<td>&nbsp;</td>
						</tr>
						
	</script>
	
		 


				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							<span id="teacherName"></span>
						</h4> 
					</span>
					<span style="float: right;">
					</span>
				</div>

				<dl class="teacherdlxinxi">
					<dt style="height: 140px">
						<img id="photo" src="<%=basePathHeader%>/images/u8_normal.jpg" title="头像" />
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
						<span class="r">
						</span>
					</div>
					
					<div class="contentBox" id="divB" >
					<form id="from2">
						<table border="0" cellspacing="0" cellpadding="0"
							style="display: block;" class="tab1">
							<tbody>
								<tr>
									<td width="85">
										曾用名：
									</td>
									<td width="202">
										<input disabled="disabled"  id="teacherOldName" name="teacherOldName" type="text" class="scinput"/>
									</td>
									<td width="27">
										&nbsp;
									</td>
									<td width="73">
										姓名全拼：
									</td>
									<td width="213">
										<input disabled="disabled"  id="teacherNameSpelling" name="teacherNameSpelling" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										出生日期：
									</td>
									<td>
										<input disabled="disabled"  id="teacherBornDate" name="teacherBornDate" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										政治面貌：
									</td>
									<td>
										<select disabled="disabled"  id="teacherPoliticalStatus" name="teacherPoliticalStatus" class="select2">
											<option value="1">团员</option>
											<option value="2">党员</option>
											
										</select>
									</td>
								</tr>
								<tr>
									<td>
										籍 贯：
									</td>
									<td>
										<input disabled="disabled"  id="teacherNativePlace" name="teacherNativePlace" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										民 族：
									</td>
									<td>
										<input disabled="disabled"  id="teacherNation" name="teacherNation" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
										<td>
											健康状况
										</td>
										<td>
											<input disabled="disabled" id="teacherHealthCondition"
												name="teacherHealthCondition" type="text" class="scinput" />
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											国籍
										</td>
										<td>
											<select disabled="disabled" id="country"
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
										<input disabled="disabled"  id="teacherPhoneNum" name="teacherPhoneNum" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										联系电话：
									</td>
									<td>
										<input disabled="disabled"  id="teacherCallNum" name="teacherCallNum" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										QQ：
									</td>
									<td>
										<input disabled="disabled"  id="teacherQq" name="teacherQq" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										Email：
									</td>
									<td>
										<input disabled="disabled"  id="teacherEmail" name="teacherEmail" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										家庭住址：
									</td>
									<td>
										<input disabled="disabled"  id="teacherFamilyLocal" name="teacherFamilyLocal" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										婚姻状况：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="teacherMaritalStatus" value="1"/>
											已婚 <input disabled="disabled"  type="radio" name="teacherMaritalStatus" value="0"/>
												未婚
									</td>
								</tr>
								 
							</tbody>
						</table>
						</form>
					</div>




					<div class="tabformtitle">
						<span class="l">教育经历</span>
						<span class="r"> 
						</span>
					</div>

					<div class="contentBox" id="divC" >
						<table border="0" cellspacing="0" cellpadding="0"
							style="display: block;" class="tab1">
							<tbody>
								   
								<tr id="flag">
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tabformtitle" >
						<span class="l">工作信息</span>
						<span class="r"> 
						</span>
					</div>

					<div class="contentBox" id="divD">
						<form id="form4">
						<table width="645" border="0" cellpadding="0" cellspacing="0"
							class="tab1" style="display: block;">
							<tbody>
								<tr>
									<td width="96">
										教师资格种类：
									</td>
									<td width="212">
										<select disabled="disabled"  id="jobQualificationType"　name="jobQualificationType" class="select2" style="width: 167px;">
										</select>
									</td>
									<td width="10">
										&nbsp;
									</td>
									<td width="113">
										获教师资格证时间：
									</td>
									<td width="169">
										<input disabled="disabled"  id="jobCertificateDate" name="jobCertificateDate" type="text" class="scinput"/>
									</td>
								</tr>
								<tr>
									<td>
										教师资格证书号：
									</td>
									<td>
										<input disabled="disabled"  id="jobCertificateNum" name="jobCertificateNum" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										参加工作时间：
									</td>
									<td>
										<input disabled="disabled"  id="jobWorkTime" name="jobWorkTime" type="text" class="scinput"/>
									</td>
								</tr>
								
								<tr>
										<td>
											荣誉称号：
										</td>
										<td>
											<input disabled="disabled" id="rych" name="rych"
												type="text" class="scinput" />
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											特岗教师类别
										</td>
										<td>
											<select disabled="disabled" id="tgjs" name="tgjs"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											免费师范生类别：
										</td>
										<td>
										<select disabled="disabled" id="mfsfs" name="mfsfs"
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
											<input disabled="disabled" id="jxjybh" name="jxjybh"
												type="text" class="scinput" />
										</td>
									</tr>
									
									<tr>
										<td>
											是否全日制师范专业毕业：
										</td>
										<td>
												<input disabled="disabled" type="radio" name="qrzsfzy" value="1" />
											是
											<input disabled="disabled" type="radio" name="qrzsfzy" value="0"
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
											<input disabled="disabled" id="jsnpxqk" name="jsnpxqk"
												type="text" class="scinput" />
										</td>
									</tr>
									
									
									<tr>
										<td>
											普通话等级：
										</td>
										<td>
											<select disabled="disabled" id="pthdj" name="pthdj"
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
											<input disabled="disabled" id="cjqsny" name="cjqsny"
												type="text" class="scinput" />
										</td>
									</tr>
									
									<tr>
										<td>
											五险一金：
										</td>
										<td>
											<input disabled="disabled" id="wxyj" name="wxyj"
												type="text" class="scinput" />
										</td>
										 <td>
											&nbsp;
										</td>
										<td>
											教师资格证种类：
										</td>
										<td>
											<select disabled="disabled" id="jszgz" name="jszgz"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											合同签订情况：
										</td>
										<td>
											<select  disabled="disabled" id="contract" name="contract"
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
											<input disabled="disabled" id="salary" name="salary"
												type="text" class="scinput" />
										</td>
									</tr>
									<tr>
										<td>
											是否在编：
										</td>
										<td>
											<input disabled="disabled" type="radio" name="sfzb" value="1" />
											是
											<input disabled="disabled" type="radio" name="sfzb" value="0"
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
											<select disabled="disabled" id="adjustId" name="adjustId"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											岗位类别：
										</td>
										<td>
											<select disabled="disabled" id="gwlb" name="gwlb"
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
											<select disabled="disabled" id="gwdj" name="gwdj"
												class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
								
								
								<tr>
									<td>
										任教时间：
									</td>
									<td>
										<input disabled="disabled"  id="jobWorkDate" name="jobWorkDate" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										(评)教师职称：
									</td>
									<td>
										<select disabled="disabled"  id="jobCommentPosition" name="jobCommentPosition" class="select2" style="width: 167px;">
										</select>
									</td>
								</tr>
								<tr>
									<td>
										(评)职称时间：
									</td>
									<td>
										<input disabled="disabled"  id="jobCommentDate" name="jobCommentDate" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										(聘)教师职称：
									</td>
									<td>
										<select disabled="disabled"  id="jobRecruitmentPosition" name="jobRecruitmentPosition" class="select2" style="width: 167px;">
										</select>
									</td>
								</tr>
								<tr>
									<td>
										(聘)职称时间：
									</td>
									<td>
										<input disabled="disabled"  id="jobRecruitmentDate" name="jobRecruitmentDate" type="text" class="scinput"/>
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										学校行政职务：
									</td>
									<td>
									<select disabled="disabled" id="jobSchoolAdministrationOfficeType"
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
									<td id="subjectList" >
									</td>
								</tr>
								<tr>
									<td>
										是否学科带头人：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobSubjectLeader" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobSubjectLeader" value="0" checked="checked"/>
												否 
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										是否骨干教师：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobCoreTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobCoreTeacher" value="0" checked="checked"/>
												否 
									</td>
								</tr>
								<tr>
									<td>
										是否为班主任：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobWhetherTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobWhetherTeacher" value="0" checked="checked"/>
												否 
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										是否为特级教师：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobWhetherGradeTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobWhetherGradeTeacher" value="0" checked="checked"/>
												否 
									</td>
								</tr>
								<tr>
									<td>
										国培计划农村骨干教师：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobCountyRuralTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobCountyRuralTeacher" value="0" checked="checked"/>
												否 
									</td>
									<td>
										&nbsp;
									</td>
									<td>
										民办学校专职教师：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobPrivateSchoolTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobPrivateSchoolTeacher" value="0" checked="checked"/>
												否 
									</td>
								</tr>
								<tr>
									<td>
										特岗教师：
									</td>
									<td>
										<input disabled="disabled"  type="radio" name="jobSpecialTeacher" value="1"/>
											是 <input disabled="disabled"  type="radio" name="jobSpecialTeacher" value="0" checked="checked"/>
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
	</body>
</html>
