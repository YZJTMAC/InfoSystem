<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑教师信息</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/createTeacher.js"></script>
		<script type="text/javascript">
			teacherId = ${teacherId};
		</script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/teacher/commonTeacherEdite.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js"></script>
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
		<script type="text/javascript"	src="<%=basePathHeader%>/javascript/common/commonUploadUserPhoto.js"></script>
		
		<style>
		.dean {
			width: 150px;
		}
		</style>
</head>
	<body>
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
						信息
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							<span id="teacherName"></span>
						</h4><a href="###" onclick="goback();" class="huibtn_a"
						style="float: right; line-height: 18px; margin: 7px 0 0 10px;">返回</a>
					</span>
					<span style="float: right;">
						<!--<a href="#" class="huibtn_a" style="margin-right:8px;">上一个</a><a href="#" class="huibtn_a" style="margin-right:8px;">下一个</a>-->
					</span>
				</div>
				
				<div id="tab10" class="tabson" style="display: block;">
					<DIV style="MARGIN: 0px" class=tabformtitle>
						<SPAN class=r><A href="###" onclick="saveA();"><IMG
									title=修改 src="<%=basePathHeader%>/images/btn_save1.gif">
						</A>&nbsp;&nbsp;</SPAN>
					</DIV>
					<form id="from1">
						<input type="hidden" id="imageSrc" />
						<DL class=teacherdlxinxi>
							<DT>
						<img id="photo" style="height: 99px; width:71px" src="<%=basePathHeader%>/uploadFile/photo/u8_normal.jpg"/>
							<a href="javascript:;" onclick="showUploadPhoto();" class="huibtn_a" style="TEXT-ALIGN: center; MARGIN-TOP: 10px; DISPLAY: block">修改头像</a>
							</DT>
							<DD>
								<SPAN class=titlewidth>用户名：</SPAN><SPAN style="padding-top: 0px"><input
										id="loginAccount" 　name="loginAccount" type="text"
										class="scinput dean" maxlength="40"/><font style="color: red">*</font>
								</SPAN>
							</DD>
							<DD>
								<SPAN class=titlewidth>密码：</SPAN><SPAN style="padding-top: 0px"><input
										id="password" 　name="password" type="text" class="scinput dean" maxlength="20"/>
								</SPAN><font style="color: red">*</font>
							</DD>
							<DD>
								<SPAN class=titlewidth>姓名：</SPAN><SPAN style="padding-top: 0px"><input
										id="realName" 　name="realName" type="text" class="scinput dean" maxlength="20"/>
								</SPAN><font style="color: red">*</font>
							</DD>
							<DD>
								<SPAN class=titlewidth>性别：</SPAN><SPAN style="padding-top: 0px"> <select
										id="gender" 　name="gender" class="selectUser"
										style="width: 10px;">
										<option value="">
											请选择
										</option>
										<option value="1">
											男
										</option>
										<option value="0">
											女
										</option>
									</select> </SPAN><font style="color: red">*</font>
							</DD>
							<DD>
								<SPAN class=titlewidth>用户状态：</SPAN><SPAN style="padding-top: 0px"> <select
										id="status" 　name="status" class="selectUser"
										style="width: 167px;">
									</select> </SPAN><font style="color: red">*</font>
							</DD>
							<DD>
								<SPAN class=titlewidth>身份证号：</SPAN><SPAN style="padding-top: 0px"><input
										id="idNumber" 　name="idNumber" type="text" class="scinput dean" maxlength="18"/>
								</SPAN><font style="color: red">*</font>
							</DD>
							<DD>
								<SPAN class=titlewidth>教师编号：</SPAN><SPAN style="padding-top: 0px"><input
										id="teacherNo" 　name="teacherNo" type="text" class="scinput dean" maxlength="20"/>
								</SPAN><font style="color: red">*</font>
							</DD>
							<DD style="width: 500px">
								<SPAN class=titlewidth >所在学校：</SPAN>
								<SPAN style="padding-top: 0px">
								<input id="schoolName" 　name="teacherNo" type="text" class="scinput dean areaSelect" />
								<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
								</SPAN><font style="color: red">*</font>
								<input type="hidden" id="selectSchoolId" />
							</DD>
						</DL>
					</form>
				</div>

    <div id="toolsli" class="toolsli">
    <ul class="toollist">
    <li><a href="#tab1" class="currentab"><img src="<%=basePathHeader%>/images/i07.png"/></a><h2>教师信息</h2></li>
    <li><a href="#tab2" ><img src="<%=basePathHeader%>/images/i02.png"/></a><h2>审核情况</h2></li>
    <li><a href="#tab3" id="JobtransferHis" ><img src="<%=basePathHeader%>/images/i06.png"/></a><h2>工作记录</h2></li>
    <li><a href="#tab4" id="commentHis" ><img src="<%=basePathHeader%>/images/i05.png"/></a><h2>培训记录</h2></li>
    <li><a href="#tab5" onclick='window.open("<%=basePathHeader%>/teacher/teachermanage/showAndPrintTeacherPage.htm?teahcerId=${teacherId}");'><img src="<%=basePathHeader%>/images/i01.png"/></a><h2>预览打印</h2></li>      
    </ul>
    </div>

				<div id="tab1" class="tabson" style="display: block;">
					<div class="tabformtitle">
						<span class="l">基本信息</span>
						<span class="r"><a href="###" class="saveClick" onclick="saveB();"><img
									src="<%=basePathHeader%>/images/btn_save1.gif" title="保存"/>
						</a>&nbsp;&nbsp;<a id="B" class="click" href="###"><img  src="<%=basePathHeader%>/images/btn_spread.gif"
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
										<select id="teacherPoliticalStatus" name="teacherPoliticalStatus" class="select2" >
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
												name="teacherHealthCondition" type="text" class="scinput" maxlength="30"/>
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
											<INPUT id="postGrade" name="postGrade"
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
											<INPUT id="postBack" name="postBack"
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
											<INPUT id="jobCommentDate" name="jobCommentDate"
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
											<INPUT id="jobRecruitmentDate" name="jobRecruitmentDate"
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
										<INPUT id="jobWorkTime" name="jobWorkTime"
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
											<INPUT id="jobWorkDate" name="jobWorkDate"
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


				<div id="tab2" class="tabson" style="display: block;">
					<div class="tabformtitle">
						<span class="l">审核情况</span>
					</div>

					<div class="contentBox">
						<table width="645" border="0" cellpadding="0" cellspacing="0"
							class="tab1" style="display: block;" id="auditId">
						</table>
					</div>
					<div class="tabformtitle">
						<span class="l">信息变更记录</span>
						<span class="r"> &nbsp;&nbsp;<a href="#"> <img
									src="<%=basePathHeader%>/images/btn_spread.gif" title="收起">
						</a>
						</span>
					</div>

					<div class="contentBox" id='auditHistry'>
					</div>
				</div>
				<div id="tab3" class="tabson" style="display: block;">
					<div class="tabformtitle">
						<span class="l">工作记录</span>
						<span class="r"> &nbsp;&nbsp;</span>
					</div>
					<div class="contentBox" id='jobtransferHistory'>
						<TABLE style="DISPLAY: block" class=tab1 border=0 cellSpacing=0
							cellPadding=0>
							<TBODY id="Jobtransfer">
							</TBODY>
						</table>
					</div>
				</div>
				<div id="tab4" class="tabson" style="display: block;">
					<div class="tabformtitle">
						<span class="l">培训记录</span>
						<span class="r"> &nbsp;&nbsp;</span>
					</div>
					<div class="contentBox">
						<TABLE style="DISPLAY: block" class=tab1 border=0 cellSpacing=0
							cellPadding=0>
							<TBODY id="commonHis">
							</TBODY>
						</table>
					</div>
				</div>
				<div id="showAndPrint" class="tabson" style="display: block;">
				</div>
			</div>
		</div>
		<%@include file="../common/commonSchoolSelect.jsp"%>
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
				$(".idTabs").idTabs(function(id){
					alert(id);
				    switch(id){
				      case "#tab5": alert(1);break;
				    } return true;
				  });
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

$("#showAndPrint").click(function(){
		window.open("<%=basePathHeader%>/teacher/teachermanage/showAndPrintTeacherPage.htm?teahcerId=${teacherId}");
	});
	
$("#toolsli ul").idTabs(function(id){
				    switch(id){
				      case "#tab5":break;
				    } return true;
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
						<IMG id="photoTemp" title="头像" src="<%=basePathHeader%>/uploadFile/photo/u8_normal.jpg"
								style="height: 155px; width: 110px; border: 1px solid #eee; margin-top: 10px;">
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
		
		
		<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<!-- <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">× </button><div>--> </div>
		
	</body>

</html>
