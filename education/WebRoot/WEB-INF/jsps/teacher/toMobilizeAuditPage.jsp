<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><c:choose>
				<c:when test="${click eq 1006}">
				返聘管理-审核
			</c:when>
				<c:otherwise>
				调动管理-审核
			</c:otherwise>
			</c:choose></title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toMobilizeAuditPage.js"></script>
		<style type="text/css">
			.cancel {
				background: url(../../images/btnbg2.png) repeat-x;
				color: #000;
				font-weight: normal;
			}
		</style>

		<script type="text/javascript">
			var click = ${click};
			var backUrl = "";
			if(click == 1006) {
				backUrl = "/teacher/teachermanage/toReworkAuditListPage.htm?click=${click}&flag=N";
			} else {
				backUrl = "/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=Y";
			}
			$(document).ready(function() {
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
			
				$(".sure").click(function() {
					$(".tip").fadeIn(200);
				});
			
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
	
			$(function(){
				var tx="${info.userImageUrl}";
				if(tx==null || tx=="" || tx==undefined){
					$("#ptx").html("<img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:100px;height:100px' title='头像'>");
				}
			});
	</script>
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
						<a href="#"> <c:choose>
								<c:when test="${click eq 1006}">
								返聘管理-审核
							</c:when>
								<c:otherwise>
								调动管理-审核
							</c:otherwise>
							</c:choose> </a>
					</li>
				</ul>
			</div>
			<div class="formbody">

				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							${info.realName}老师
						</h4> <c:choose>
							<c:when test="${click eq 1006}">
								<a
									href="<%=basePathHeader%>/teacher/teachermanage/toReworkAuditListPage.htm?click=${click}&flag=N"
									class="huibtn_a"
									style="float: right; line-height: 18px; margin: 7px 0 0 10px;">返回</a>
							</c:when>
							<c:otherwise>
								<a
									href="<%=basePathHeader%>/teacher/teachermanage/toMobilizeAuditListPage.htm?click=${click}&flag=N"
									class="huibtn_a"
									style="float: right; line-height: 18px; margin: 7px 0 0 10px;">返回</a>
							</c:otherwise>
						</c:choose> </span>
					<span style="float: right;"></span>
				</div>


				<dl class="teacherdlxinxi">
					<dt>
						<span id="ptx"> <img
								src="<%=imageServer%>/${info.userImageUrl}" title="头像" /> </span>

					</dt>
					<dd>
						<span class="titlewidth">姓名：</span><span>${info.realName}</span>
					</dd>
					<dd>
						<span class="titlewidth">性别：</span><span>${info.sex}</span>
					</dd>
					<dd>
						<span class="titlewidth">用户状态：</span><span>${info.teacherStauts}</span>
					</dd>

					<dd>
						<span class="titlewidth">身份证号：</span><span>${info.idNumber}</span>
					</dd>
					<dd>
						<span class="titlewidth">教师编号：</span><span>${info.teacherNo}</span>
					</dd>
					<dd>
						<br />
						<input name="" id="toPage" type="button" class="sure" value="审核" />
					</dd>
				</dl>

				<div class="tabformtitle">
					<span class="l"> <c:choose>
							<c:when test="${click eq 1006}">
				返聘详情
			</c:when>
							<c:otherwise>
				调动详情
			</c:otherwise>
						</c:choose> </span>
					<span class="r"></span>
				</div>

				<div class="contentBox">
					<table border="0" cellspacing="0" cellpadding="0"
						style="display: block; width: 100%" class="tab1">
						<tr>
							<td width="150"></td>
							<c:choose>
								<c:when test="${click eq 1006}">
									<td width="247">
										<b>返聘前信息：<b>
									</td>
									<td width="247">
										<b>返聘后信息：<b>
									</td>
								</c:when>
								<c:otherwise>
									<td width="247">
										<b>调动前信息：<b>
									</td>
									<td width="247">
										<b>调动后信息：<b>
									</td>
								</c:otherwise>
							</c:choose>


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
							<td>
								${audit.mobilizeMark}
							</td>
						</tr>
						<tr id="auditHtml" style="display: none">
							<td>
								审核说明：
							</td>
							<td>
								${audit.auditOption}
							</td>
						</tr>
					</table>
				</div>


			</div>

		</div>

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
						<input name="" id="toPage" type="button" class="sure1" value="确定" />
					</td>
				</tr>
			</table>
		</div>

		<div class="tip">
			<div class="tiptop">
				<span> <c:choose>
						<c:when test="${click eq 1006}">
								返聘审核
			</c:when>
						<c:otherwise>
								 调动审核
			</c:otherwise>
					</c:choose> </span><a></a>
			</div>
			<div class="tipinfo">
				<table width="100%" height="80%">
					<tr>
						<td>
							是否审核通过
						</td>
						<td>
							<input type="radio" checked="checked" name="audit" value="1"
								id="audityes" />
							是 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="audit" value="0" id="auditno" />
							否
						</td>

					</tr>
					<tr>
						<td>
							审核意见
						</td>
						<td>
							<textarea name="auditOption" id="auditOption" cols="" rows=""
								class="textinput" style="width: 260px; height: 80px;"></textarea>
						</td>
					</tr>
				</table>
			</div>

			<div class="tipbtn">
				<input name="postPage" id="postPage" type="button" class="sure2"
					value="提交" />
				&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
	</body>
	<script>
var status = '${info.status}';//新旧数据
var jobCommentPosition = '${info.jobCommentPosition}';//(评)教师职称
var jobRecruitmentPosition = '${info.jobRecruitmentPosition}';//(聘)教师职称
var jobSchoolAdministrationOffice = '${info.jobSchoolAdministrationOffice}';//学校行政职务
var jobFormerTeachingSubject = '${info.jobFormerTeachingSubject}';//当前任教学段/学科
var jobCoreTeacher = '${info.jobCoreTeacher}';//是否骨干教师
var jobWhetherTeacher = '${info.jobWhetherTeacher}';//是否为班主任
var jobCountyRuralTeacher = '${info.jobCountyRuralTeacher}';//国培计划农村骨干教师

var arrStatus = status.split(',');
var arrJobCommentPosition = jobCommentPosition.split(',');
var arrJobRecruitmentPosition = jobRecruitmentPosition.split(',');
var arrJobSchoolAdministrationOffice = jobSchoolAdministrationOffice.split(',');
var arrJobFormerTeachingSubject = jobFormerTeachingSubject.split(',');
var arrJobCoreTeacher = jobCoreTeacher.split(',');
var arrJobWhetherTeacher = jobWhetherTeacher.split(',');
var arrJobCountyRuralTeacher = jobCountyRuralTeacher.split(',');

if (arrStatus.length == 2) {
	if (arrData(arrJobCommentPosition, 0) == arrData(arrJobCommentPosition, 1)) {
		$('#jobCommentPosition_old').html(arrJobCommentPosition[0]);
		$('#jobCommentPosition_new').html(arrJobCommentPosition[0]);
	} else {
		$('#jobCommentPosition_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobCommentPosition[0] + "</i>");
		$('#jobCommentPosition_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobCommentPosition[1] + "</em>");
	}

	if (arrData(arrJobRecruitmentPosition, 0) == arrData(
			arrJobRecruitmentPosition, 1)) {
		$('#jobRecruitmentPosition_old').html(arrJobRecruitmentPosition[0]);
		$('#jobRecruitmentPosition_new').html(arrJobRecruitmentPosition[0]);
	} else {
		$('#jobRecruitmentPosition_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobRecruitmentPosition[0] + "</i>");
		$('#jobRecruitmentPosition_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobRecruitmentPosition[1] + "</em>");
	}

	if (arrData(arrJobSchoolAdministrationOffice, 0) == arrData(
			arrJobSchoolAdministrationOffice, 1)) {
		$('#jobSchoolAdministrationOffice_old').html(
				arrJobSchoolAdministrationOffice[0]);
		$('#jobSchoolAdministrationOffice_new').html(
				arrJobSchoolAdministrationOffice[0]);
	} else {
		$('#jobSchoolAdministrationOffice_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobSchoolAdministrationOffice[0] + "</i>");
		$('#jobSchoolAdministrationOffice_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobSchoolAdministrationOffice[1] + "</em>");
	}

	if (arrData(arrJobFormerTeachingSubject, 0) == arrData(
			arrJobFormerTeachingSubject, 1)) {
		$('#jobFormerTeachingSubject_old').html(arrJobFormerTeachingSubject[0]);
		$('#jobFormerTeachingSubject_new').html(arrJobFormerTeachingSubject[0]);
	} else {
		$('#jobFormerTeachingSubject_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobFormerTeachingSubject[0] + "</i>");
		$('#jobFormerTeachingSubject_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobFormerTeachingSubject[1] + "</em>");
	}

	/* if (arrData(arrJobCoreTeacher, 0) == arrData(arrJobCoreTeacher, 1)) {
		$('#jobCoreTeacher_old').html(arrJobCoreTeacher[0]);
		$('#jobCoreTeacher_new').html(arrJobCoreTeacher[0]);
	} else {
		$('#jobCoreTeacher_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobCoreTeacher[0] + "</i>");
		$('#jobCoreTeacher_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobCoreTeacher[1] + "</em>");
	} */

	//骨干教师
	if (arrData(arrJobCoreTeacher, 0) == arrData(
			arrJobCoreTeacher, 1)) {
		$('#jobCoreTeacher_old').html(arrJobCoreTeacher[0]);
		$('#jobCoreTeacher_new').html(arrJobCoreTeacher[0]);
	} else {
		$('#jobCoreTeacher_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobCoreTeacher[0] + "</i>");
		$('#jobCoreTeacher_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobCoreTeacher[1] + "</em>");
	}

	if (arrData(arrJobWhetherTeacher, 0) == arrData(arrJobWhetherTeacher, 1)) {
		$('#jobWhetherTeacher_old').html(arrJobWhetherTeacher[0]);
		$('#jobWhetherTeacher_new').html(arrJobWhetherTeacher[0]);
	} else {
		$('#jobWhetherTeacher_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobWhetherTeacher[0] + "</i>");
		$('#jobWhetherTeacher_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobWhetherTeacher[1] + "</em>");
	}

	if (arrData(arrJobCountyRuralTeacher, 0) == arrData(
			arrJobCountyRuralTeacher, 1)) {
		$('#jobCountyRuralTeacher_old').html(arrJobCountyRuralTeacher[0]);
		$('#jobCountyRuralTeacher_new').html(arrJobCountyRuralTeacher[0]);
	} else {
		$('#jobCountyRuralTeacher_old').html(
				"<i style=\"text-decoration: line-through; color: #999\">"
						+ arrJobCountyRuralTeacher[0] + "</i>");
		$('#jobCountyRuralTeacher_new').html(
				"<em style=\"font-style: normal; color: red\">"
						+ arrJobCountyRuralTeacher[1] + "</em>");
	}
}

var auditStatus = ${audit.auditStatus};
if(auditStatus==13 ||auditStatus==12){
$("#auditHtml").css("display","");
}

function arrData(arr, index) {
	if (arr.length == 2) {
		return arr[index];
	}
}

var teacherId="<%=request.getParameter("teacherId")%>";
var id="<%=request.getParameter("id")%>";
var newProvinceId="<%=request.getParameter("newProvinceId")%>";
var newProvinceName=decodeURIComponent(decodeURI("<%=request.getParameter("newProvinceName")%>"));
var newCityId="<%=request.getParameter("newCityId")%>";
var newCityName=decodeURIComponent(decodeURI("<%=request.getParameter("newCityName")%>"));
var newDistrictId="<%=request.getParameter("newDistrictId")%>";
var newDistrictName=decodeURIComponent(decodeURI("<%=request.getParameter("newDistrictName")%>"));
var newSchoolId="<%=request.getParameter("newSchoolId")%>";
var newSchoolName=decodeURIComponent(decodeURI("<%=request.getParameter("newSchoolName")%>"));
</script>
</html>