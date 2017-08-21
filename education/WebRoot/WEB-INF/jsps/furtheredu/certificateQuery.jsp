<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>项目证书查询</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var proId = '<%=request.getParameter("proId")%>';
			var type = '<%=request.getParameter("type")%>';
		</script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/certificateQuery.js"></script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="furtheredu" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/furthereduLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="###">继教信息</a>
					</li>
					<li>
						<a href="###">证书查询</a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label>
								项目名称：
							</label>
							<div class="vocation">
								<input name="input" id="queryProjectName" type="text" value="" class="scinput" />
							</div>
						</li>
						
						<li>
							<label>
								培训年度：
							</label>
							<div class="vocation">
								<select id="queryYearStart" class="select1 yearpicker"
									name="yearpicker" id="yearpicker">
									<option value="">请选择</option>	
								</select>
							</div>
						</li>
						<li>
							至
						</li>
						<li>
							<div class="vocation">
								<select id="queryYearEnd" class="select1 yearpicker"
									name="yearpicker" id="yearpicker">
								<option value="">请选择</option>	
								</select>
							</div>
						</li>
						
						<li>
							<label>
								继教板块：
							</label>
							<div class="vocation">
								<select class="select3" id="eduModelType">
						      		<option value="">请选择</option>
						      	</select>
							</div>
						</li>

						<li>
							<label>
								项目性质：
							</label>
							<div class="vocation">
								<select class="select3" id="projectScope">
						      		<option value="">请选择</option>
						      	</select>
							</div>
						</li>
					</ul>
				
					<ul class="seachform">
						<li>
							<label>
								教师姓名：
							</label>
							<div class="vocation">
								<input id="teacherName" name="input" type="text" class="scinput" />
							</div>	
						</li>
						
						<li>
							<label>
								身份证号：
							</label>
							<div class="vocation">
								<input id="idcard" name="input" type="text" class="scinput" style="width:180px;"/>
							</div>
						</li>
						
						<li>
							<label>
								审核状态：
							</label>
							<div class="vocation">
								<select class="select3" id="queryStatus">
									<option value="">
										请选择
									</option>
									<option value="13">
										审核通过
									</option>
									<option value="12">
										审核不通过
									</option>
									<option value="11">
										未审核
									</option>
								</select>
							</div>
						</li>
					</ul>
					
					<ul class="seachform">
						<li>
							<label>
								参培地区：
							</label>
							<input id="areaName"　name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
							<input type="hidden" id="areaId"/>
							<input type="hidden" id="areaType"/>
							<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
						</li>

						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<label style="width: 45px;">
								&nbsp;
							</label>
						</li>
						<li>
							<input id="select" name="input3" type="button" class="dian3" value="查 询" />
						</li>
					</ul>
				</div>
				
				<div class="chauxnJS jsTool">
					<span style="float: left;">
						<div class="vocation" style="margin: 4px 6px 0 6px;">
						</div>
						<a href="###" onclick="showTeacherInfoBox();" class="huibtn_a">导出教师证书</a>
					</span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0; width: 190px;">
							<div class="message">
								共
								<i class="blue" id="totalCount">0</i>条记录
							</div>
							<div class="vocation paginList"
								style="margin: 4px 6px 0 6px; right: 0px;">
								<select id="pageSize" class="select3" style="width: 100px;">
									<option value="100">
										每页显示100条
									</option>
									<option value="300">
										每页显示300条
									</option>
									<option value="500">
										每页显示500条
									</option>
								</select>
							</div>

						</div> </span>
				</div>
				
				<table class="tablelist">
					<thead>
						<tr>
							<th>
								<input id="chk_all" type="checkbox" value="" />
							</th>
							<th scope="col" width="10%">
								教师姓名
							</th>
							<th scope="col" width="5%">
								性别
							</th>
							<th scope="col" width="15%">
								学校
							</th>
							<th scope="col" width="5%">
								项目学时
							</th>
							<th scope="col" width="5%">
								所获学时
							</th>
							
							<th scope="col" width="5%">
								所获成绩
							</th>
							<th scope="col" width="5%">
								成绩等级
							</th>
							<th scope="col" width="10%">
								学时证书编号
							</th>
							<th scope="col" width="5%">
								所获学分
							</th>
							
							<th scope="col" width="5%">
								审核评价
							</th>
							<th scope="col" width="10%">
								项目证书编号
							</th>
							<th scope="col" width="20%">
								项目名称
							</th>
						</tr>
					</thead>
					<tbody id="teacher_list">
					</tbody>
				</table>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
				
				<%@include file="../common/commonAreaSelect.jsp"%>
				<script type="text/javascript">
					lastSelect='${areaId}_${areaType}_${areaName}';
				</script>
			</div>
		</div>
		
		<!-- 教师证书导出弹框 -->
		<div class="tip1" style="height: 370px; width: 560px;align:center;">
			<div class="tiptop2" align="center">
				<span>导出字段选择</span><a></a>
			</div>
			<span style="padding:12px; margin: -10px;">
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="certificate_chk">&nbsp;&nbsp;全选/全不选</input>
			</span>
			<div class="tipinfo" style="width:500px; height: 80px; padding: 25px; margin: 0;">
				<form id="certificateForm" method="post">
					<input type="hidden" name="areaType" />
					<input type="hidden" name="areaId" />
					<input type="hidden" name="teacherArray" />
					<input type="hidden" name="fieldArray" />
					<input type="hidden" name="queryConditionArray" />
					
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="realName" name="checkbox" value="教师姓名"></input>&nbsp;&nbsp;教师姓名
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="idNumber" name="checkbox" value="身份证号"></input>&nbsp;&nbsp;身份证号
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="gender" name="checkbox" value="性别"></input>&nbsp;&nbsp;性别
						</span>
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="mobile" name="checkbox" value="手机号码"></input>&nbsp;&nbsp;手机号码
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="email" name="checkbox" value="邮箱"></input>&nbsp;&nbsp;邮箱
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="jobFormerTeachingSection" name="checkbox" value="学段"></input>&nbsp;&nbsp;学段
						</span>
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="jobFormerTeachingSubject" name="checkbox" value="学科"></input>&nbsp;&nbsp;学科
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="jobRecruitmentPosition" name="checkbox" value="(聘)教师职称"></input>&nbsp;&nbsp;(聘)教师职称
						</span>	
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="jobSchoolAdministrationOffice" name="checkbox" value="学校行政职务"></input>&nbsp;&nbsp;学校行政职务
						</span>	
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="userProvinceName" name="checkbox" value="省份"></input>&nbsp;&nbsp;省份
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="userCityName" name="checkbox" value="地市"></input>&nbsp;&nbsp;地市
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="userDistrictName" name="checkbox" value="区县"></input>&nbsp;&nbsp;区县
						</span>
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="school" name="checkbox" value="学校名称"></input>&nbsp;&nbsp;学校名称
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="projectName" name="checkbox" value="项目名称"></input>&nbsp;&nbsp;项目名称
						</span>	
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="modelName" name="checkbox" value="所属继教版块"></input>&nbsp;&nbsp;所属继教版块
						</span>	
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="organizationName" name="checkbox" value="院校(机构)"></input>&nbsp;&nbsp;院校(机构)
						</span>	
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="teacherClassPeriod" name="checkbox" value="所获学时"></input>&nbsp;&nbsp;所获学时
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="teacherClassScore" name="checkbox" value="所获学分"></input>&nbsp;&nbsp;所获学分
						</span>
					</div>
					<div>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="periodCertificateCode" name="checkbox" value="学时证书编号"></input>&nbsp;&nbsp;学时证书编号
						</span>
						<span style="width:160px; height: 25px;">
							<input type="checkbox" id="projectCertificateCode" name="checkbox" value="项目证书编号"></input>&nbsp;&nbsp;项目证书编号
						</span>
					</div>
				</form>
			</div>
			<br />
			<div class="tipbtn" style="width: 245px; padding: 100px; margin: 0 auto">
				<input type="button"  class="sure" value="导出" onclick="downTeacherCertificateExcl();"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="cancel" value="取消" />
			</div>
		</div>
		<!-- 教师证书导出弹框 -->
				
		<IFRAME id="downIframe" 　src="" frameborder=0 scrolling=no vspace=0 hspace=0 marginheight=0 marginwidth=0 height=60 width="100%"></IFRAME>
		
		<!-- 模态框 -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
				<div class="progress progress-striped active" style="margin-bottom: 0;">
					<span style="font-size:24px;">数据导出中，请稍后  . . .</span>
				</div>
			</div>
		</div>
	</body>
</html>
