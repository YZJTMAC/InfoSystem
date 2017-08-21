<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>系统管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<%-- <%@include file="../common/commonAreaSelectAll.jsp"%> --%>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/system/sysSetup_new.js"></script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="system" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/systemLeft.jsp"%>
		</div>

		<div class="content">
			<div id="jqDiv1" >
				<div class="place">
					<span>位置：</span>
					<ul class="placeul">
						<li>
							<a href="#">系统管理</a>
						</li>
						<li>
							<a href="#">系统设置</a>
						</li>
					</ul>
				</div>
				<div class="formbody">
					<div class="chauxnJS jsTool">
						<span style="float: left;">
							<h4 style="float: left;"></h4> <a href="javascript:;" class="jq"
							style="float: left; line-height: 18px; margin: 7px 0 0 10px;"
							id="btn1">功能设置</a> </span>
						<span style="float: right;"></span>
					</div>
					<div>
						<div class="choose" style="display: ; padding-top: 0px;">
							<table border="0" cellspacing="0" cellpadding="0"
								style="line-height: 42px; margin: 0 auto; width: 100%;">
								<tr>
									<td width="140"
										style="background-color: #EDF6FA; text-align: right;">
										可用登录方式：
									</td>
									<td>
										<input id="zxq_1" name="accountType" type="checkbox"
											class="dfinput-" value="1" />
										<label for="zxq_1">
											身份证号
										</label>
										<input id="zxq_2" name="accountType" type="checkbox"
											class="dfinput-" value="2" />
										<label for="zxq_2">
											用户名
										</label>
										<input id="zxq_3" name="accountType" type="checkbox"
											class="dfinput-" value="3" />
										<label for="zxq_3">
											教师编号
										</label>
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										是否关闭教师登录：
									</td>
									<td>
										<input id="zxq_4" name="useTeacherRole" type="radio"
											class="dfinput-" value="1" />
										<label for="zxq_4">
											不关闭
										</label>
										<input id="zxq_5" name="useTeacherRole" type="radio"
											class="dfinput-" value="0" />
										<label for="zxq_5">
											关闭
										</label>
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										是否开放注册教师：
									</td>
									<td>
										<input id="zxq_6" name="openRegisterTeacher" type="radio"
											class="dfinput-" value="1" />
										<label for="zxq_6">
											开放
										</label>
										<input id="zxq_7" name="openRegisterTeacher" type="radio"
											class="dfinput-" value="0" />
										<label for="zxq_7">
											关闭
										</label>
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										教师信息变动审核：
									</td>
									<td>
										<input id="zxq_8" name="teacherInfoChangeAudit"
											type="checkbox" class="dfinput-" />
										<label for="zxq_8">
											允许同级审核 （包括：教师信息审核、调动审核、离退休审核等等）
										</label>
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										教师信息导出安全：
									</td>
									<td>
										<input id="zxq_9" name="teacherInfoSafe" type="radio"
											class="dfinput-" value="1" />
										<label for="zxq_9">
											允许查看/导出身份证号和手机号
										</label>
										<input id="zxq_10" name="teacherInfoSafe" type="radio"
											class="dfinput-" value="0" />
										<label for="zxq_10">
											不允许查看/导出身份证号和手机号
										</label>
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										是否启用承培机构：
									</td>
									<td>
										<input id="zxq_11" name="enableOrg" type="radio"
											class="dfinput-" value="1" />
										<label for="zxq_11">
											是
										</label>
										<input id="zxq_12" name="enableOrg" type="radio"
											class="dfinput-" value="0" />
										<label for="zxq_12">
											否
										</label>
									</td>
								</tr>
								<%--<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										教师信息模块管理授权：
									</td>
									<td>
										<span style="float: left;" id="teacherModuleAutherName"></span>
										<input name="" type="button"
											style="float: left; margin-left: 20px" class="sure"
											value="选择" onclick="showAddMgr(1);" />
									</td>
									<td>
										<input id="teacherModuleAutherId" type="hidden" />
									</td>
								</tr>
								<tr>
									<td style="background-color: #EDF6FA; text-align: right;">
										继教信息模块管理授权：
									</td>
									<td>
										<span style="float: left;" id="furthereduModuleAutherName"></span>
										<input name="" type="button"
											style="float: left; margin-left: 20px" class="sure"
											value="选择" onclick="showAddMgr(2);" />
									</td>
									<td>
										<input id="furthereduModuleAutherId" type="hidden" />
									</td>
								</tr>
								--%><tr>
									<td width="90">
										&nbsp;
									</td>
									<td>
										<a href="###" class="dian3" onclick="modifySysSetup();">保存</a>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>

			<!-- 教师信息模块管理授权, 继教信息模块管理授权 选择管理员页面 -->
			<!-- <div id="jqDiv2" style="display: none;">
				<div class="place">
					<span>位置：</span>
					<ul class="placeul">
						<li>
							<a href="###">系统管理</a>
						</li>
						<li>
							管理员管理
						</li>
					</ul>
				</div>

				<div class="formbody"
					style="overflow: hidden; padding-bottom: 20px;">
					<div class="formbodyL">
						<div class="tabson">
							<ul class="seachform" style="padding-left: 23px;">
								<li>
									<label>
										角色：
									</label>
									<div class="vocation">
										<select id="role" name="select" class="select2">
											<option value="">
												请选择...
											</option>
											<option value="0">
												系统管理员
											</option>
											<option value="1">
												省管理员
											</option>
											<option value="2">
												市管理员
											</option>
											<option value="3">
												区管理员
											</option>
											<option value="4">
												校管理员
											</option>
		
											<option value="6">
												承培机构管理员
											</option>
											<option value="7">
												实施机构管理员
											</option>
										</select>
									</div>
								</li>
								<li>
									<label>
										用户名：
									</label>
									<div class="vocation">
										<input id="loginAccount" name="input" value="" type="text" class="scinput" />
									</div>
								</li>
								<li>
									<label>
										所属地区：
									</label>
									<div class="vocation">
										<input name="input" id="tss" value="" type="text" style="width: 260px;" onclick="clearPCD();" class="scinput areaSelect" />
									<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
									</div>
								</li>
								<li>
									<label>
										&nbsp;
									</label>
									<input id="select" type="button" class="scbtn" value="查 询" />
								</li>
							</ul>
						</div>
						<div class="chauxnJS jsTool">
							<span style="float: left;"><a href="javascript:;" onclick="hideAddMgr();"
								class="huibtn_a" style="margin-left: 6px">返回</a>&nbsp; </span>
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th>姓名</th>
									<th>用户名</th>
									<th>密码</th>
									<th>角色</th>
									<th>地区</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="mgr_list">
							</tbody>
						</table>
						分页
						<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
						<div id="pagebar" class="pagin"></div>
						分页
					</div>
				</div>
			</div> -->
		</div>
		<!-- <input id="roleId" type="hidden"/>
		<input type="hidden" name="schoolProvinceId" id="schoolProvinceId" value="" />
		<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
		<input type="hidden" name="schoolDistrictId" id="schoolDistrictId" value="" /> -->
	</body>
</html>
