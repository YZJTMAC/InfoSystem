<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>字典管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/dictionaryManagePage.js"></script>
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
						<a href="#">字典管理</a>
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
									字典类型:
								</label>
								<div class="vocation">
									<select id="dictionaryTypeId" name="select" class="select2">
										<option value="">
											--请选择--
										</option>
										<option value="stduty_section">
											学段
										</option>
										<option value="project_subject">
											学科
										</option>
										<option value="study_grade">
											年级
										</option>
										<option value="educational_user">
											学历
										</option>
										<option value="academic_degree">
											学位
										</option>
										<option value="teacher_seniority">
											教师资格种类
										</option>
										<option value="teacher_professional">
											教师职称
										</option>
										<option value="project_scope">
											项目范围
										</option>
										<option value="project_nature">
											项目性质
										</option>
										<option value="training_type">
											培训类型
										</option>
										<option value="training_from">
											培训形式
										</option>
										<!-- 
										<option value="teacher_osition">
											教师职务
										</option>
										 -->
										<option value="teacher_staff">
											教师编制
										</option>
										<option value="school_type">
											学校类型
										</option>
										<option value="school_nature">
											学校性质
										</option>
										<option value="school_establish_type">
											学校办别
										</option>
										<option value="office_type">
											学校行政职务
										</option>
										<option value="political_status">
											政治面貌
										</option>
										<option value="area_type">
											所在区划
										</option>
										<option value="tgjs_type">
											特岗教师类别
										</option>
 										<option value="mfsfs_type">
											免费师范生
										</option>
										<option value="pthdj_type">
											普通话等级
										</option>
										<option value="jszgz_type">
											教师资格证种类
										</option>
										<option value="contract_type">
											合同签订情况
										</option>
										<option value="gwlb_type">
											岗位类别
										</option>
										<option value="gwdj_type">
											岗位等级
										</option>
										<option value="country_type">
											国籍
										</option>
										<option value="comment_type">
											结项评价维度
										</option>
										<option value="mspydx_type">
											是否名校长培养对象
										</option>
										<option value="jxms_type">
											是否教学名师
										</option>
										<option value="xkdtr_type">
											是否学科带头人
										</option>
										<option value="ggjs_type">
											是否骨干教师
										</option>
									</select>
								</div>
							</li>

						<li>
								<label>
									字典状态:
								</label>
								<div class="vocation">
								<select id="status" name="status" class="select2">
									<option value="1">
										启用
									</option>
									<option value="0">
										禁用
									</option>
								</select>
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

						<span style="float: left;"> <a href="#"
							class="huibtn_a btn_add" style="margin-left: 6px" id="btnAdd">添加</a>
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="showList();" id="sizePerPage" class="select3">
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
								<th width="7%">
									字典类型
								</th>
								<th width="7%">
									字典名称
								</th>
								<th width="7%">
									字典编码
								</th>
								<th width="7%">
									操作
								</th>
							</tr>
						</thead>

						<tbody id="dictionary_list">

						</tbody>
					</table>

					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
				<div class="tip">
					<div class="tiptop">
						<span>增加字典</span><a></a>
					</div>

					<div class="tipinfo">
						<div class="tipright" style="padding: 0; margin: 0;"></div>
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto; line-height: 42px;">
							<tr>

								<td width="64">
									字典类型:
								</td>
								<td width="170">
									<li>

										<div class="vocation">
											<select id="dictionaryType" name="select" class="select2"
												width="180">
												<option value="">
													--请选择--
												</option>
												<option value="stduty_section">
													学段
												</option>
												<option value="project_subject">
													学科
												</option>
												<option value="study_grade">
													年级
												</option>
												<option value="educational_user">
													学历
												</option>
												<option value="academic_degree">
													学位
												</option>
												<option value="teacher_seniority">
													教师资格种类
												</option>
												<option value="teacher_professional">
													教师职称
												</option>
												<option value="project_scope">
													项目范围
												</option>
												<option value="project_nature">
													项目性质
												</option>
												<option value="training_type">
													培训类型
												</option>
												
												<option value="training_from">
													培训形式
												</option>
												<!-- 
													<option value="teacher_osition">
														教师职务
													</option>
												 -->
												<option value="teacher_staff">
													教师编制
												</option>
												<option value="school_type">
													学校类型
												</option>
												<option value="school_nature">
													学校性质
												</option>
												<option value="school_establish_type">
													学校办别
												</option>
												<option value="office_type">
													学校行政职务
												</option>
												<option value="political_status">
													政治面貌
												</option>
												<option value="area_type">
													所在区划
												</option>
												<option value="tgjs_type">
													特岗教师类别
												</option>
		 										<option value="mfsfs_type">
													免费师范生
												</option>
												<option value="pthdj_type">
													普通话等级
												</option>
												<option value="jszgz_type">
													教师资格证种类
												</option>
												<option value="contract_type">
													合同签订情况
												</option>
												<option value="gwlb_type">
													岗位类别
												</option>
												<option value="gwdj_type">
													岗位等级
												</option>
												<option value="country_type">
													国籍
												</option>
												<option value="comment_type">
													结项评价维度
												</option>
												<option value="mspydx_type">
													是否名校长培养对象
												</option>
												<option value="jxms_type">
													是否教学名师
												</option>
												<option value="xkdtr_type">
													是否学科带头人
												</option>
												<option value="ggjs_type">
													是否骨干教师
												</option>
											</select>
										</div>
									</li>
									<a style="color: red" id="selectedError"></a>
								</td>

							</tr>
							<tr>
								<td>
									字典编码:
								</td>
								<td>
									<input name="input" type="text" class="scinput"
										id="insertDictionCode" style="width: 180px;" />
									<a style="color: red" id="CodeError"></a>
								</td>

							</tr>
							<tr>
								<td>
									字典名称:
								</td>
								<td>
									<input name="input" type="text" class="scinput"
										id="insertDictionName" style="width: 180px;" />
									<a style="color: red" id="dictionNameError"></a>
								</td>
							</tr>
						</table>

					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure" onclick="saveInfo()"
							id="submit" value="保 存" />
						&nbsp;
						<input name="" type="button" class="cancel" value="取 消" />
					</div>

				</div>

				<div class="tip2">
					<div class="tiptop2">
						<span>编辑字典</span><a></a>
					</div>
					<div class="tipinfo">
						<div class="tipright" style="padding: 0; margin: 0;"></div>
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto; line-height: 42px;">
							<tr>

								<td width="64">
									字典类型:
								</td>
								<td width="170">
										<div class="vocation" id="dictionnaryLeixin">
										</div>
									<a style="color: red" id="dictionnaryLeixinError"></a>
								</td>
							</tr>
							<tr>
								<td>
									字典编码:
								</td>
								<td>
									<input name="input" type="text" class="scinput"
										id="dictionCode" style="width: 180px;" />
									<a style="color: red" id="dictionCode2Error"></a>
								</td>
							</tr>
							<tr>
								<td>
									字典名称:
								</td>
								<td>
									<input name="input" type="text" class="scinput"
										id="dictionName" style="width: 180px;" />
									<a style="color: red" id="dictionName2Error"></a>
								</td>
							</tr>
						</table>


					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure2" value="保存" />
						&nbsp;
						<input name="" type="button" class="cancel2" value="取消" />
					</div>

				</div>
			</div>
		</div>
	</body>

</html>
