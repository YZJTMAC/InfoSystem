<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师返聘管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelect.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toMobilizeAddPage.js"></script>
		<style type="text/css">
			.cancel {
				background: url(../../images/btnbg2.png) repeat-x;
				color: #000;
				font-weight: normal;
			}
		</style>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="teacher" name="flag" />
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
						<a href="#">教师信息</a>
					</li>
					<li>
						<a href="#">教师返聘管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="###" class="selected">发起返聘</a>
							</li>
							<li>
								<a id="goto" href="<%=basePathHeader%>/teacher/teachermanage/toReWorkPage.htm?click=15">已发起返聘</a>
							</li>
						</ul>
					</div>

					<div id="tab2" class="tabson">

						<div class="formtitle">
							<span>查询要返聘的教师</span>
						</div>
						<div class="tabson">


							<ul class="seachform">

								<li>
									<label>
										教师姓名：
									</label>
									<input name="realName" id="realName" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										身份证号：
									</label>
									<input name="idNumber" id="idNumber" type="text"
										class="scinput" />
								</li>

								<li>
									<label>
										&nbsp;
									</label>
									<input type="hidden" id="retiress"   value="1"/>
									<input type="button" id="select" class="scbtn" value="查 询" />
								</li>
								<li>
									<span id="msg" style="color: #c00"></span>
								</li>
							</ul>

						</div>

						<div class="formtitle">
							<span>查询结果</span>
						</div>
						<div id="proTeacher_list">

						</div>


						<div class="tip2" style="height: 660px; width: 600px;">
							<div class="tiptop2">
								<span>发起返聘</span><span>&nbsp;&nbsp;带“<b
									style="color: #F00;"">*</b>”为必填项</span><a></a>
							</div>

							<div class="tipinfo"
								style="width: 580px; height: 500px; padding: 10px; margin: 0;">
								<ul class="forminfo forminfo1" style="padding: 0; margin: 0;">
									<li>
										<label>
											目标市县校
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<input name="input" id="tss" value="" type="text"
												style="width: 320px;" onclick="clearPCD();" class="scinput areaSelect" />
											<input name="input2" type="button" value="选 择"
												class="btnXuan areaSelect" />
										</div>

										<cite style="color: #F00;">*</cite>
									</li>
									<li>
										<label>
											(评)教师职称
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<select id="jobCommentPosition" class="select3">
												<option value=''>
													请选择...
												</option>
											</select>
										</div>

									</li>
									<li>
										<label>
											(聘)教师职称
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<select id="jobRecruitmentPosition" class="select3">
												<option value=''>
													请选择...
												</option>
											</select>
										</div>
									</li>
									<li>
										<label>
											学校行政职务
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<select id="jobSchoolAdministrationOffice" class="select3">
												<option value=''>
													请选择...
												</option>
											</select>
										</div>
									</li>
									<li>
										<label>
											任教学段
										</label>
										<cite id="jobFormerTeachingSectionHTML"> </cite>
									</li>
									<li>
										<label>
											任教学科
										</label>
										<cite id="jobFormerTeachingSubjectHTML"> </cite>
									</li>
									<li>
										<label>
											是否骨干教师
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<select id="jobCoreTeacher" class="select3">
												<option value=''>
													请选择...
												</option>
											</select>
										</div>
									</li>
									<li>
										<label>
											是否为班主任
										</label>
										<cite><input name="jobWhetherTeacher" type="radio"
												value="1" id="jobWhetherTeacherYES" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
												name="jobWhetherTeacher" type="radio" value="0"
												id="jobWhetherTeacherNO" />否</cite>
									</li>
									<li>
										<label>
											国培计划农村骨干教师
										</label>
										<cite><input name="jobCountyRuralTeacher" type="radio"
												value="1" id="jobCountyRuralTeacherYES" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
												name="jobCountyRuralTeacher" type="radio" value="0"
												id="jobCountyRuralTeacherNO" />否</cite>
									</li>
									<li>
										<label>
											返聘说明
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<textarea name="mobilizeMark" id="mobilizeMark" cols=""
												rows="" class="textinput"
												style="width: 260px; height: 30px;"></textarea>
										</div>
										<cite style="color: #F00;">*</cite>
									</li>

									<li><label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</label>
										
									<cite id="msgs" style="color: #c00">
										
									</cite>
									</li>
								</ul>


							</div>
							<Br />

							<div class="tipbtn">
								<input name="" type="button" id="setMob" class="sure" value="提交" />
								&nbsp;
								<input name="" type="button" class="cancel" value="取消" />
							</div>

						</div>

					</div>

				</div>

			</div>

		</div>
		<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
			value="" />
		<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
		<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
			value="" />
		<input type="hidden" name="schoolId2" id="schoolId2" value="" />
		<div class="tip1"
			style="width: 400px; height: 150px; top: 40%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span id="msgHtml"></span>
					</td>
				</tr>
				<tr>
					<td align="center" valign="top" style="height: 60%">
						<input type="hidden" id="flag" value="rework" />
						<input name="" id="toPage" type="button" class="sure1" value="确定" />

					</td>
				</tr>
			</table>
		</div>
	</body>

</html>