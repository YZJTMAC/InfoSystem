<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>生成管理员帐号</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelect.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/person/toCreateManagesPage.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonValidate.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 157
				});
				$(".select1").uedSelect( {
					width : 107
				});
				$(".select3").uedSelect( {
					width : 100
				});
			});
		</script>
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
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">系统管理</a>
					</li>
					<li>
						<a href="#">生成管理员帐号</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="formbodyL"
					style="overflow: hidden; padding-bottom: 20px;">
					<div class="tabson">
						<ul class="seachform" style="padding-left: 23px;">

							<li>

								<label>
									用户角色:
								</label>
								<div class="vocation">
									<select id="roleId" name="select" class="select2">
									</select>
								</div>

							</li>
							<li>
								<label>
									用户名:
								</label>
								<div class="vocation">
									<input id="loginAccount" name="input" value="" type="text"
										class="scinput" />
								</div>
							</li>
						</ul>
						<ul class="seachform" style="padding-left: 23px;">

							<!-- <li>
								<label>
									学科:
								</label>
								<div class="vocation">
									<select id="subjectId" name="select" class="select1">
										<option value="">
											请选择...
										</option>
									</select>
								</div>
							</li> -->
							<li>
								<label>
									所属地区:
								</label>
								<div class="vocation">
									<input name="input" id="tss" value="" type="text"
										style="width: 260px;" onclick="clearPCD();" class="scinput areaSelect" />
									<input name="input2" type="button" value="选 择"
										class="btnXuan areaSelect" />
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
						<span style="float: left;" id="action"> </span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="showManagesList();" id="sizePerPage"
										class="select3">
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

									姓名

								</th>
								<th>

									用户名

								</th>
								<th>

									密码

								</th>
								<th>

									角色名称

								</th>
								<th>

									身份证号

								</th>
								<th>
									省
								</th>
								<th>
									市
								</th>
								<th>
									县
								</th>
								<th>
									学校
								</th>
								<th>
									生成时间
								</th>
							</tr>
						</thead>

						<tbody id="proTeacher_list">

						</tbody>
					</table>

					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin">
					</div>
					<!-- 分页 -->
					<input type="hidden" name="schoolProvinceId" id="schoolProvinceId"
						value="" />
					<input type="hidden" name="schoolCityId" id="schoolCityId" value="" />
					<input type="hidden" name="schoolDistrictId" id="schoolDistrictId"
						value="" />
					<input type="hidden" name="schoolId2" id="schoolId2" value="" />
					<!-- 标识选择地区的时候是生成帐号选择地区还是查询列表选择地区 -->
					<input type="hidden" name="flag" id="flag" value="0" />
				</div>
			</div>
		</div>

		<div class="tip0"
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
						<input name="" id="toPage" type="button" class="sure" value="确定" />
					</td>
				</tr>
			</table>
		</div>


		<div class="tip1" style="height: 460px">
			<div class="tiptop">
				<span>生成管理员</span><a></a>
			</div>
			<div class="kuang" style="width: auto;">
				用户名生成规则：
				<br />
				1、行政管理员角色：前缀+地区CODE+4位随机码
				<!-- <br />
				2、其他角色：前缀+4位随机码 -->
			</div>
			<div class="tipinfo">
				<div class="tipright" style="padding: 0; margin: 0;"></div>
				<ul class="forminfo" style="padding: 0; margin: 0;">
					<li>
						<label style="width: 80px;">
							角色类型:
						</label>
						<div class="vocation">
							<select id="createRoleId" onchange="changeRoleId();"
								name="select" class="select2">
  <option value="" selected>
									请选择...
								</option>
	 						<option value="1">
									行政管理员
								</option>
							
								<!--	<option value="6">
									承培机构管理员
								</option>
								<option value="7">
									实施机构管理员（省）
								</option>
								<option value="20">
									专家
								</option>
							 <option value="8">
									实施机构管理员（市）
								</option>
								<option value="9">
									实施机构管理员（区）
								</option>
								<option value="10">
									实施机构管理员（校）
								</option>
								<option value="0">
									系统管理员
								</option> -->

							</select>

						</div>
					</li>

				</ul>
				<!-- 管理员 -->
				<div style="padding: 0; margin: 0; display: none" id="adminrole">
					<ul class="forminfo" style="padding: 0; margin: 0;">
						<li>
							<label style="width: 80px;">
								所属地区：
							</label>
							<div class="vocation">
								<input name="input" id="tss1" value="" type="text"
									style="width: 260px;" onclick="clearPCD();" class="scinput areaSelect" />
								<input name="input2" type="button" value="选 择"
									class="btnXuan areaSelect" />
							</div>
						</li>

						<li>
							<label style="width: 80px;">
								生成范围:
							</label>
							<div class="vocation">
								<input id="fw0" name="input" value="" type="checkbox" />
								生成当前所属地区的管理员1个
								<br />
								<input id="fw1" name="input" value="" type="checkbox" />
								生成所有下级地区的管理员各1个
							</div>
						</li>
					</ul>
				</div>

				<!-- 专家 -->
				<div style="padding: 0; margin: 0; display: none" id="expertrole">
					<ul class="forminfo" style="padding: 0; margin: 0;">
						<li>
							<label style="width: 80px;">
								学科：
							</label>
							<div class="vocation">
								<select id="createSubjectId" name="createSubjectId"
									class="select2">
									<option value="">
										请选择...
									</option>

								</select>
							</div>
						</li>
					</ul>
				</div>

				<!-- 系统管理员、承培机构管理员、实施机构管理员 -->
				<div style="padding: 0; margin: 0; display: none" id="sysrole">
					<ul class="forminfo" style="padding: 0; margin: 0;">
						<li>
							<label style="width: 80px;">
								用户名前辍:
							</label>
							<div class="vocation">
								<input id="topStr" maxlength="4" name="topStr" value=""
									type="text" class="scinput" />
							</div>

						</li>
						<li id="sl">
							<label style="width: 80px;">
								生成数量:
							</label>
							<div class="vocation">
								<input id="createNum" maxlength="4" name="createNum" value=""
									type="text" class="scinput" />
							</div>
						</li>


					</ul>
				</div>
				<div id="msgHtmlC" style="color: #c00"></div>
			</div>

			<div class="tipbtn" style="padding: 0; margin-top: 5%">
				<table style="width: 100%; height: 100%">
					<tr>
						<td align="left" valign="top"
							style="height: 60%; padding-left: 30px;">
							<input name="" id="btn" type="button" class="sure1" value="保存" />
							&nbsp;
							<input name="" type="button" class="cancel1" value="取消" />
						</td>
					</tr>
				</table>

			</div>

		</div>

	</body>

</html>
