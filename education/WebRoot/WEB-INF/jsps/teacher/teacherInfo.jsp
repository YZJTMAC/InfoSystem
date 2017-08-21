<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师项目培训管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherInfo.js"></script> 
<script type="text/javascript">
    var teacherId = "";
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>
	<!-- top -->
	<div class="head">
	<jsp:include page="../common/top.jsp">
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
    <li><a href="teacherMegT_1.5.2.html">我的教师信息</a></li>
    <li>查看</li>
    </ul>
    </div>
    
    <div class="formbody">
    
     <div class="chauxnJS jsTool">
     <span style="float:left;"><h4 style="float:left;"><span id="teacherName"></span> </h4>老师的资料信息</span>
     <span style="float:right;"><!--<a href="#" class="huibtn_a" style="margin-right:8px;">上一个</a><a href="#" class="huibtn_a" style="margin-right:8px;">下一个</a>--></span>
     </div>
    
    
    <dl class="teacherdlxinxi">
    <dt>
		<img src="<%=basePathHeader%>/images/u8_normal.jpg" title="头像" />
	</dt>
    <dd><span class="titlewidth">用户名：</span><span id="loginAccount"></span></dd>
    <dd><span class="titlewidth">密码：</span><span id="password"></span></dd>
    <dd><span class="titlewidth">姓名：</span><span id="realName"></span></dd>
    <dd><span class="titlewidth">性别：</span><span id="gender"></span></dd>
    
    <dd><span class="titlewidth">身份证号：</span><span id="idNumber"></span></dd>
    <dd><span class="titlewidth">教师编号：</span><span id="teacherNo"></span></dd>
    <dd><span class="titlewidth">所在学校：</span><span id="schoolName"></span></dd>
    <dd><span class="titlewidth">用户状态：</span><span id="status"></span></dd>
    </dl>
    
    
    
    
    <div class="tabformtitle" id="basicTitl"><span class="l">基本信息</span> <span class="r">
    <c:if test="${user.status lt 30}">
    	&nbsp;&nbsp;
    </c:if>
    <a onclick="packUp()"><img src="../../style/images/btn_shrink.gif" title="收起" /></a></span></div>
    <div class="tabformtitle" id="basicTitl1" style="display: none"><span class="l">基本信息</span> <span class="r">&nbsp;&nbsp;<a onclick="backUp()"><img src="../../style/images/btn_spread.gif" title="展开" /></a></span></div>
    <div class="contentBox" id="basicDiv">
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
    
    
    
    
    <div class="tabformtitle" id="basicTitlTwo"><span class="l">教育经历</span> 
    <span class="r">
    <a href="###" onclick="packUpTwo()"><img src="../../style/images/btn_shrink.gif" title="收起" /></a></span></div>
    <div class="tabformtitle" id="basicTitl2" style="display: none"><span class="l">教育经历</span> <span class="r">&nbsp;&nbsp;<a onclick="backUpTwo()"><img src="../../style/images/btn_spread.gif" title="展开" /></a></span></div>
    
    
    <div class="contentBox" id="divC">
						<table border="0" cellspacing="0" cellpadding="0" style="display: block;" class="tab1">
							<tbody id="educationId">
								   
								
							</tbody>
						</table>
					</div>
    
    
    
    
    
   <div class="tabformtitle" id="basicTitlThree"><span class="l">工作信息</span> <span class="r">
    <c:if test="${user.status lt 30}">
   	<a href="" id="info5">&nbsp;&nbsp;
   </c:if>
   <a href="###" onclick="packUpThree()"><img src="../../style/images/btn_shrink.gif" title="收起" /></a></span></div>
    <div class="tabformtitle" id="basicTitl3" style="display: none"><span class="l">工作信息</span> <span class="r">&nbsp;&nbsp;<a onclick="backUpThree()"><img src="../../style/images/btn_spread.gif" title="展开" /></a></span></div>
    <div class="contentBox" id="jodMessage">
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
											从教起始年月：
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
        <td>任教时间：</td>
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
        <td id="jobSchoolAdministrationOffice">XXX</td>
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
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
    </div> 
    
 
    
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
    
	  <div class="tabformtitle"><span class="l">审核情况</span></div>
    
    <div class="contentBox">
    <table width="645" border="0" cellpadding="0" cellspacing="0" class="tab1" style="display:block;" id = "auditId">
      
    </table>
    </div> 
	</div>
   
    
    
    
    
    </div> 
 <script>
  
     
  </script>
 
 
 
</body>
 
</html>
