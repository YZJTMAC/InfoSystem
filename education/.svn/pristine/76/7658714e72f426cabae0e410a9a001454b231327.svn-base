<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=8; IE=9;" />
		<title>教师信息管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 100
				});
				$(".select2").uedSelect( {
					width : 160
				});
				$(".moreChoose dd div").mouseleave(function() {
					$(this).hide();
				});
			});
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherManage.js"></script>
		<style>
			.moreChoose dd {
				width: 980px;
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
						教师信息管理
					</li>
					<li>操作说明：搜索结果根据按需筛选和精确查询的条件组合查询出</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="chauxnJS jsTool">
					<span style="float: left;"><h4 style="float: left;">
							教师信息：
						</h4> <a href="javascript:;"
						style="float: left; line-height: 18px; margin: 7px 0 0 10px;"
						class="jq" id="btn2">按需筛选</a><a href="javascript:;"
						style="float: left; line-height: 18px; margin: 7px 0 0 10px;"
						id="btn1">精确查询</a> </span>
					<span style="float: right;"><a
						href="<%=basePathHeader%>/teacher/teachermanage/createTeacherPage.htm?click=1"
						style="margin-right: 8px;">添加教师</a> <!-- <a href="teacherGLY_1.1.10.html" style="margin-right:8px;">历史导入记录</a> -->
					</span>
				</div>
				
				<div>
					<div class="condition">
					  	<dl>
					      <dt id="addQueryCOndition" style="background-color:#fff;"><strong>已选条件：</strong></dt>
					      <dd><a href="#" class="tablelink" title="清空已选条件">清空选项</a></dd>
					    </dl>
					</div>
					
					<div class="choose" id="jqDiv1" style="display: none;">

						<table border="0" cellspacing="0" cellpadding="0"
							style="line-height: 42px; margin: 0 auto;">
							<tbody>
								<tr>
									<td width="110">
										教师姓名：
									</td>
									<td>
										<input id="queryRealName" name="input13" type="text" class="dfinput" style="width: 170px;" />
									</td>
									<td width="60">
										&nbsp;
									</td>
									<td width="110">
										教师编号：
									</td>
									<td>
										<input id="queryTeacherNo" name="input3" type="text" class="dfinput" style="width: 170px;" />
									</td>
									<td width="60">
										&nbsp;
									</td>
									<td width="110">身份证号码：</td>
    								<td><input id="queryIdNumber" name="input4" type="text" class="dfinput" style="width: 170px;" /></td>
								</tr>
								<tr>
									<td>借调分流单位：</td>
    								<td><input id="queryJdfldw" type="text" class="dfinput" style="width:170px;"/></td>
    								<td>&nbsp;</td>
								    <td>(评)职称时间：</td>
								    <td><input id="21" type="text" name="jobCommentDate" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
								    <td>&nbsp;</td>
								    <td>(聘)职称时间：</td>
								    <td><input id="22" type="text" name="jobRecruitmentDate" readonly="readonly"  class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
								</tr>
								<tr>
									<td>聘任岗位等级时间：</td>
								    <td><input id="23" type="text" name="postGrade" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" /></td>
								    <td>&nbsp;</td>
								    <td>本校任教起始时间：</td>
								    <td><input id="24" type="text" name="jobWorkDate" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" /></td>
								    <td>&nbsp;</td>
								    <td>借调分流时间：</td>
								    <td><input id="25" type="text" name="jdflTime" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" /></td>
								</tr>
								<tr>
								  	<td>离岗待退时间：</td>
								    <td colspan="7">
								    <input id="26" type="text" name="postBack" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" /"></td>
								</tr>
								<tr>
								    <td colspan="8" align="center"><a href="###" onclick="showInfoList();" class="dian3">查 询</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="choose" id="jqDiv2">
						<dl>
							<dt>
								地区：
							</dt>
							<dd>
								<input id="areaName" 　name="" readonly="readonly" type="text"
									value="${areaName}" class="scinput areaSelect" />
								<input type="hidden" id="areaId" />
								<input name="input2" class="btnXuan areaSelect" type="button"
									value="选 择" />
							</dd>
							<dd>
							</dd>
							<dd>

							</dd>
							<dd>
								<div id="divSchool" style="display: none;"></div>
							</dd>
							<dd>
								<div class="chauxnJS jsTool" style="display: none;">
									<span style="float: left;"> <a href="javascript:;"
										class="huibtn_a click" id="btnSchool">打开学校选择弹出层</a> </span>
								</div>

							</dd>
						</dl>
						
						
						<div style="background: #fff url(<%=basePathHeader%>/style/images/tbg.jpg) left repeat-y; overflow: hidden; border-bottom: 1px dashed #ccc;">
							<dl class="weizhi" style="border-bottom: 0px;">
								<div  style="float: left; vertical-align: middle; width: 70px; line-height: 40px; background-color: #edf6fa; padding-left: 10px;">
									学段：
								</div>
								<div style="width:600px; float:left;">
						    		<!-- dd><input name="" type="checkbox" value="" />语文</dd-->
						    		<dd id="stdutySection"></dd>
						   	 	</div>
						    </dl>
						</div>
						<div style="background: #fff url(<%=basePathHeader%>/style/images/tbg.jpg) left repeat-y; overflow: hidden; border-bottom: 1px dashed #ccc;">
							<dl class="weizhi" style="border-bottom: 0px;">
								<div  style="float: left; vertical-align: middle; width: 70px; line-height: 40px; background-color: #edf6fa; padding-left: 10px;">
									学科：
								</div>
								<div style="width:530px; float:left;">
						    		<dt id="stdutySubject"></dt>
										<dd class='deleteSubject'> 请先选择学段 </dd>
									
						   	 	</div>
						    	<a href="###" class="more">更多</a>
						    </dl>
						</div>
						

						<dl class="moreChoose" style="height:70px;display: none;">
							<dt style="line-height:70px;">
								更多选项：
							</dt>
							<dd id="xuanze">
								<ul id="xuanzeTool">
									<li>
										<a id="queryTitle_0" href="javascript:;">性别</a>
									</li>
									<li>
										<a id="queryTitle_11" href="javascript:;">年龄段</a>
									</li>
									<li>
										<a id="queryTitle_12" href="javascript:;">婚姻状况</a>
									</li>
									<li>
										<a id="queryTitle_13" href="javascript:;">参加工作年限</a>
									</li>
									<li>
										<a id="queryTitle_10" href="javascript:;">最低学历</a>
									</li>
									<li>
										<a id="queryTitle_16" href="javascript:;">最高学历</a>
									</li>
									<li>
										<a id="queryTitle_14" href="javascript:;">学科带头人</a>
									</li>
									<li>
										<a id="queryTitle_15" href="javascript:;">骨干教师</a>
									</li>
									<li>
										<a id="queryTitle_3" href="javascript:;">特级教师</a>
									</li>
									<!-- 
        <li><a id="queryTitle_4" href="javascript:;">特岗教师</a></li>
        <li><a id="queryTitle_5" href="javascript:;">农村骨干教师</a></li> -->
									<li>
										<a id="queryTitle_6" href="javascript:;">在职状态</a>
									</li>
									<li><a id="queryTitle_17" href="javascript:;">岗位类别</a></li>
							        <li><a id="queryTitle_18" href="javascript:;">(评)教师职称</a></li>
							        <li><a id="queryTitle_19" href="javascript:;">(聘)教师职称</a></li>
							        <li><a id="queryTitle_20" href="javascript:;">岗位等级</a></li>
							        <li><a id="queryTitle_27" href="javascript:;">班主任</a></li>
								</ul>
								
								<!-- 性别 --> 
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input id="0" type="radio" name="gender" value="1" />
												</td>
												<td>
													男
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="0" type="radio" name="gender" value="0" />
												</td>
												<td>
													女
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								
								<!-- 年龄段 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input id="11" type="radio" name="ageA" value="24" />
												</td>
												<td id="age_24">
													24岁及以下
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="25" />
												</td>
												<td id="age_25">
													25-29岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="30" />
												</td>
												<td id="age_30">
													30-34岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="35" />
												</td>
												<td id="age_35">
													35-39岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="40" />
												</td>
												<td id="age_40">
													40-44岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="45" />
												</td>
												<td id="age_45">
													45-49岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="50" />
												</td>
												<td id="age_50">
													50-54岁
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="11" type="radio" name="ageA" value="60" />
												</td>
												<td id="age_60">
													60岁及以上
												</td>
											</tr>
										</tbody>
									</table>

								</div>

								<!-- 婚姻状况 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input id="12" type="radio" name="marry" value="1" />
												</td>
												<td>
													已婚
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="12" type="radio" name="marry" value="0" />
												</td>
												<td>
													未婚
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
										</tbody>
									</table>

								</div>

								<!-- 参加工作年限 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input id="13" type="radio" name="workAge" value="0-2" />
												</td>
												<td id="work_0-2">
													0-2年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="3-5" />
												</td>
												<td id="work_3-5">
													3-5年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="6-10" />
												</td>
												<td id="work_6-10">
													6-10年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="11-15" />
												</td>
												<td id="work_11-15">
													11-15年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="16-20" />
												</td>
												<td id="work_16-20">
													16-20年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="21-25" />
												</td>
												<td id="work_21-25">
													21-25年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="26-30" />
												</td>
												<td id="work_26-30">
													26-30年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="31-39" />
												</td>
												<td id="work_31-39">
													31-39年
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input id="13" type="radio" name="workAge" value="40" />
												</td>
												<td id="work_40">
													40年及以上
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
										</tbody>
									</table>

								</div>

								<!-- 最低学历 --> 
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody id="lowEducationExperience" >
										</tbody>
									</table>
								</div>
								
								<!-- 最高学历 --> 
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody id="topEducationExperience" >
										</tbody>
									</table>
								</div>
								
								<!-- 学科带头人 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody id="subjectLeader">
										</tbody>
									</table>

								</div>
								
								<!-- 骨干教师 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody id="coreTeacher">
										</tbody>
									</table>
								</div>
								
								<!-- 特级教师  -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input type="radio" name="gradeTeacher" id="3" value="1" />
												</td>
												<td>
													是
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="gradeTeacher" id="3" value="0" />
												</td>
												<td>
													否
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
										</tbody>
									</table>

								</div>
								<!-- 
       <div style="display:none;">
         <table border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
     <td><input type="radio" name="specialTeacher" id="4" value="1"/></td>
    <td>是</td>
    <td width="40">&nbsp;</td>
    <td><input type="radio" name="specialTeacher" id="4" value="0"/></td>
    <td>否</td>
    <td>&nbsp;</td>
  </tr>
</tbody></table>

       </div><div style="display:none;">
         <table border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
      <td><input type="radio" name="countyRuralTeacher" id="5" value="1"/></td>
    <td>是</td>
    <td width="40">&nbsp;</td>
    <td><input type="radio" name="countyRuralTeacher" id="5" value="0"/></td>
    <td>否</td>
    <td>&nbsp;</td>
  </tr>
</tbody></table>

       </div>
        -->
        						<!-- 在职状态 -->
								<div style="display: none;">
									<table border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td>
													<input type="radio" name="userStatus" id="6" value="6" />
												</td>
												<td>
													未审核
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="7" />
												</td>
												<td>
													审核未通过
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="8" />
												</td>
												<td>
													在职
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="35" />
												</td>
												<td>
													已病休
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="34" />
												</td>
												<td>
													已离岗
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="32" />
												</td>
												<td>
													已死亡登记
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="31" />
												</td>
												<td>
													已退休
												</td>
												<td width="40">
													&nbsp;
												</td>
												<td>
													<input type="radio" name="userStatus" id="6" value="33" />
												</td>
												<td>
													已离休
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								
								<!-- 岗位类别 -->
								<div style="display:none;" class="divmore">
							         <table border="0" cellspacing="0" cellpadding="0">
							  			<tbody id="gwlb"></tbody>
									</table>
								</div>
							       
							    <!-- (评)教师职称 -->
								<div style="display:none;" class="divmore">
							         <table border="0" cellspacing="0" cellpadding="0">
							  			<tbody id="jobCommentPosition"></tbody>
									</table>
								</div>
								
								<!-- (聘)教师职称 -->
								<div style="display:none;" class="divmore">
							         <table border="0" cellspacing="0" cellpadding="0">
							  			<tbody id="jobRecruitmentPosition"></tbody>
									</table>
								</div>
								
								<!-- 岗位等级 -->
								<div style="display:none;" class="divmore">
							         <table border="0" cellspacing="0" cellpadding="0">
							  			<tbody id="gwdj"></tbody>
									</table>
								</div>
								
								<!-- 班主任 -->
								<div style="display:none;" class="divmore">
							       <table border="0" cellspacing="0" cellpadding="0">
										 <tbody>
										 	<tr>
										    <td><input id="27"  type="radio" name="jobWhetherTeacher"  value="1"/></td>
										    <td>是</td>
										    <td width="40">&nbsp;</td>
										    <td><input id="27" type="radio" name="jobWhetherTeacher"  value="0"/></td>
										    <td>否</td>
										    <td>&nbsp;</td>
										  </tr>
										</tbody>
									</table>
								</div>
							</dd>
						</dl>
					</div>
				</div>
				<script>

window.onload = function() {
	var oList = document.getElementById('xuanzeTool').getElementsByTagName('a')
	var oDiv = document.getElementById('xuanze').getElementsByTagName('div')
	var btn1 = document.getElementById('btn1')
	var btn2 = document.getElementById('btn2')
	var jqDiv1 = document.getElementById('jqDiv1')
	var jqDiv2 = document.getElementById('jqDiv2')
	for (var i = 0; i < oList.length; i++) {
		oList[i].index = i;
		oList[i].onclick = function() {

			if (oDiv[this.index].style.display == 'block') {
				for (var i = 0; i < oList.length; i++) {
					oList[i].className = '';
					oDiv[i].style.display = 'none';
				}
			} else {
				for (var i = 0; i < oList.length; i++) {
					oList[i].className = '';
					oDiv[i].style.display = 'none';
				}

				this.className = 'onthis';

				oDiv[this.index].style.display = 'block';

			}

		}
	}
	btn1.onclick = function() {
		btn1.className = 'jq';
		btn2.className = '';
		jqDiv1.style.display = 'block';
		jqDiv2.style.display = 'none';
	}
	btn2.onclick = function() {
		btn2.className = 'jq';
		btn1.className = '';
		jqDiv2.style.display = 'block';
		jqDiv1.style.display = 'none';
	}
}
</script>

				<div class="chauxnJS jsTool">
					<span style="float: left;">
						<div class="vocation" style="margin: 4px 6px 0 6px;">
							<!--<select class="select3">
						    <option>批量选择</option>
						    <option>批量审核</option>
						    <option>批量删除</option></select>-->
						</div>
						<a href="###" class="huibtn_a no"
						style="margin-right: 8px;">未审核</a>
						
						<a href="###" class="huibtn_a yes"
						style="margin-right: 8px;">已审核</a>
						
						<a href="###" class="huibtn_a batchAudit"
						style="margin-right: 8px;">批量审核</a>
						<!-- <a href="###" class="huibtn_a batchModify" style="margin-right:8px;">批量修改</a> -->
						 <%--<a href="###" class="huibtn_a batchDelete" style="margin-right:8px;">批量删除</a>--%>
						<!-- <a href="###" onclick="downTeacherExcl();" class="huibtn_a">导出教师花名册</a> -->
						<a href="###" onclick="exportTeacherExcl();" class="huibtn_a">导出教师花名册</a>
					</span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0; width: 180px;">
							<div class="message">
								共
								<i class="blue" id="totleCount">0</i>条记录
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
							<th>
								照片
							</th>
							<th>
								姓名
							</th>
							<th>
								身份证号
							</th>
							<th>
								所属学校
							</th>
							<th>
								任教学段
							</th>
							<th>
								任教学科
							</th>
							<th>
								用户状态
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>
					<tbody id="teacherList">
					</tbody>
				</table>
				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<input id="auditStatus" type="hidden" />
				<div id="pagebar" class="pagin">
				</div>
				<!-- 分页 -->
				<!-- 区域选择 -->
				<%@include file="../common/commonAreaSelect.jsp"%>
				<script type="text/javascript">
					lastSelect = '${areaType}_${areaId}_${areaName}';
				</script>
			</div>
		</div>
	
		<!-- 教师批量修改模态框开始 -->
		<div class="tip2" style="height: 600px; width: 680px;">
					<div class="tiptop2" align="center">
						<span>教师信息批量修改</span><a></a>
					</div>
					<div class="tipinfo" style="width: 530px; height: 360px; padding: 30px; margin: 0;">
						<form id="form4">
							<table width="700" border="0" cellpadding="0" cellspacing="0" class="tab1"
							style="display: block;">
								<tbody>
									<tr>
										<td>
											教师资格种类：
										</td>
										<td width="212">
											<select id="jobQualificationType" 　name="jobQualificationType" class="select2"
											style="width: 167px;">
											</select>
										</td>
										<td width="10">
											&nbsp;
										</td>
										<td>
											教师资格证种类：
										</td>
										<td>
											<select id="jszgz" name="jszgz" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											免费师范生类别：
										</td>
										<td>
											<select id="mfsfs" name="mfsfs" class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											特岗教师类别
										</td>
										<td>
											<select id="tgjs" name="tgjs" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											普通话等级：
										</td>
										<td>
											<select id="pthdj" name="pthdj" class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											合同签订情况：
										</td>
										<td>
											<select id="contract" name="contract" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											岗位类别：
										</td>
										<td>
											<select id="gwlb" name="gwlb" class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											岗位等级：
										</td>
										<td>
											<select id="gwdj" name="gwdj" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											(评)教师职称：
										</td>
										<td>
											<select id="jobCommentPosition" name="jobCommentPosition" class="select2"
											style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											(聘)教师职称：
										</td>
										<td>
											<select id="jobRecruitmentPosition" name="jobRecruitmentPosition" class="select2"
											style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											是否学科带头人：
										</td>
										<td>
											<select id="jobSubjectLeader" name="jobSubjectLeader" class="select2"
											style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											学校行政职务：
										</td>
										<td>
											<select id="jobSchoolAdministrationOfficeType" 　name="jobSchoolAdministrationOfficeType"
											class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									<tr>
										<td>
											是否名校长培养对象：
										</td>
										<td>
											<select id="eliteTraining" name="eliteTraining" class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											是否教学名师：
										</td>
										<td>
											<select id="teachingMaster" name="teachingMaster" class="select2" style="width: 167px;">
											</select>
										</td>
									</tr>
									
									<tr>
										
										<td>
											教师编制：
										</td>
										<td>
											<select id="adjustId" name="adjustId" class="select2" style="width: 167px;">
											</select>
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											是否骨干教师：
										</td>
										<td>
											<!-- <select id="jobCoreTeacher" name="jobCoreTeacher" class="select2" style="width: 167px;">
											</select> -->
										</td>
									</tr>
									<tr>
										<td>
											是否为班主任：
										</td>
										<td>
											<input type="radio" name="jobWhetherTeacher" value="1" />
											是
											<input type="radio" name="jobWhetherTeacher" value="0"/>
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
											<input type="radio" name="jobWhetherGradeTeacher" value="0"/>
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
											<input type="radio" name="jobCountyRuralTeacher" value="0" />
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
											<input type="radio" name="jobPrivateSchoolTeacher" value="0"/>
											否
										</td>
									</tr>
									<tr>
										<td>
											是否全日制师范专业毕业：
										</td>
										<td>
											<input type="radio" name="qrzsfzy" value="1" />
											是
											<input type="radio" name="qrzsfzy" value="0"  />
											否
										</td>
										
										<td>
											&nbsp;
										</td>
										<td>
											是否在编：
										</td>
										<td>
											<input type="radio" name="sfzb" value="1" />
											是
											<input type="radio" name="sfzb" value="0"/>
											否
										</td>
									</tr>
									<tr>
										<td>
											特岗教师：
										</td>
										<td>
											<input type="radio" name="jobSpecialTeacher" value="1" />
											是
											<input type="radio" name="jobSpecialTeacher" value="0"/>
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
					
					<Br />
					<div class="tipbtn" style="width: 225px; padding: 40px; margin: 0 auto">
						<input name="" type="button" id="modifyTeacher" class="sure1" value="批量修改" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="" type="button" class="cancel1" value="取消" />
					</div>
				</div>
				<!-- 教师批量修改模态框结束 -->		
						
						


		<div class="tip" style="width: 600px; height: 350px">
			<div class="tiptop">
				<span>审核</span><a></a>
			</div>

			<div class="tipinfo">
				<ul class="forminfo">

					<li>
						<label>
							是否通过：
						</label>
						<cite> <input name="auditTeacher" class="no" type="radio"
								value="true" checked="checked" />审核通过&nbsp;&nbsp;&nbsp;&nbsp; <input
								name="auditTeacher" class="no" type="radio" value="false" />审核不通过
						</cite>
					</li>

					<li>
						<label>
							审核意见：
						</label>
						<textarea id="memo" name="" cols="" rows="" class="textinput"
							style="width: 300px"></textarea>
					</li>
				</ul>


			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" id="sureAudit" value="提交审核" />
				&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
		
		<div class="tip_vp" id="tip_msg">
    	<div class="tiptop">&nbsp;&nbsp;&nbsp;&nbsp;提示信息<a></a></div><!-- javascript:hideMe(); -->
        <p class="xmTool">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>以下教师不符合批量修改条件,请先进行审核,审核完成后方可进行批量修改 !</b> </p>  
      <table class="tablelist" style=" width:455px;margin:20px;">
				<thead>
					<tr>
						<th>教师姓名</th>
						<th>身份证号码</th>
						<th>审核状态提示信息</th>
					</tr>
				</thead>
				<tbody id="teacherInfo">
			</tbody>
			</table>
        <table width="130" style="margin:0 auto;">
	        <tr>
			 <td width="130"><a class="sure dian3"/>确定</a></td>
			</tr>
        </table>
     </div>
	
	<!-- 提示信息 -->
	<div class="tips_zb"
			style="width: 400px; height: 220px; top: 30%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span>您确定批量教师信息吗?</span>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input id="submitData" type="button" class="sure" value="确定" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="cancel2" value="取消" />
					</td>
				</tr>
			</table>
		</div>
		
		<!-- 报表导出字段组合模态框 -->
		<div class="tip1" style="height: 580px; width: 700px;align:center;">
					<div class="tiptop2" align="center">
						<span>报表导出字段选择</span><a></a>
					</div>
						<span style="padding:12px; margin: -10px;">
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkAll">&nbsp;&nbsp;全选/全不选</input>
							<input type="checkbox" id="default">&nbsp;&nbsp;默认导出选项</input>
						</span>
					<div class="tipinfo" style="width:650px; height: 280px; padding: 25px; margin: 0;">
						<form id="form4">
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="teacherNo" name="checkbox" value="教师编号"></input>&nbsp;&nbsp;教师编号
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="realName" name="checkbox" value="教师姓名"></input>&nbsp;&nbsp;教师姓名
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="idNumber" name="checkbox" value="身份证号"></input>&nbsp;&nbsp;身份证号码
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="sex" name="checkbox" value="性别"></input>&nbsp;&nbsp;性别
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="mobile" name="checkbox" value="手机号码"></input>&nbsp;&nbsp;手机号码
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="mail" name="checkbox" value="邮箱"></input>&nbsp;&nbsp;邮箱
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="userProvinceName" name="checkbox" value="省"></input>&nbsp;&nbsp;省
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="userCityName" name="checkbox" value="市"></input>&nbsp;&nbsp;市
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="userDistrictName" name="checkbox" value="区县"></input>&nbsp;&nbsp;区县
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="schoolCode" name="checkbox" value="学校编号"></input>&nbsp;&nbsp;学校编号
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="schoolName" name="checkbox" value=""></input>&nbsp;&nbsp;学校名称
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
									<input type="checkbox" id="jobCertificateNum" name="checkbox" value="教师资格证书号"></input>&nbsp;&nbsp;教师资格证书号
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobRecruitmentPosition" name="checkbox" value="(聘)教师职称"></input>&nbsp;&nbsp;(聘)教师职称
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobCommentPosition" name="checkbox" value="(评)教师职称"></input>&nbsp;&nbsp;(评)教师职称
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobSchoolAdministrationOffice" name="checkbox" value="学校行政职务"></input>&nbsp;&nbsp;学校行政职务
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobCoreTeacher" name="checkbox" value="是否骨干教师"></input>&nbsp;&nbsp;是否骨干教师
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobWhetherTeacher" name="checkbox" value="是否班主任"></input>&nbsp;&nbsp;是否班主任
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobCountyRuralTeacher" name="checkbox" value="国家计划农村骨干教师"></input>&nbsp;&nbsp;国家计划农村骨干教师
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobSpecialTeacher" name="checkbox" value="特岗教师"></input>&nbsp;&nbsp;是否特岗教师
								</span>
							</div>
							
							<!-- 追加导出字段 -->
							
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="teacherNativePlace" name="checkbox" value="籍贯"></input>&nbsp;&nbsp;籍贯
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jszgz" name="checkbox" value="教师资格证种类"></input>&nbsp;&nbsp;教师资格证种类
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="educationExperience" name="checkbox" value="第一学历"></input>&nbsp;&nbsp;第一学历
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="educationDegree" name="checkbox" value="第一学位"></input>&nbsp;&nbsp;第一学位
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="educationGraduationTime" name="checkbox" value="毕业时间(第一学位)"></input>&nbsp;&nbsp;毕业时间(第一学位)
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="educationGraduationSchool" name="checkbox" value="毕业院校(第一学位)"></input>&nbsp;&nbsp;毕业院校(第一学位)
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="educationGraduationProfession" name="checkbox" value="毕业专业(第一学位)"></input>&nbsp;&nbsp;毕业专业(第一学位)
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="topEducationExperience" name="checkbox" value="最高学历"></input>&nbsp;&nbsp;最高学历
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="topEducationDegree" name="checkbox" value="最高学位"></input>&nbsp;&nbsp;最高学位
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="topEducationGraduationTime" name="checkbox" value="毕业时间(最高学位)"></input>&nbsp;&nbsp;毕业时间(最高学位)
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="topEducationGraduationSchool" name="checkbox" value="毕业院校(最高学位)"></input>&nbsp;&nbsp;毕业院校(最高学位)
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="topEducationGraduationProfession" name="checkbox" value="毕业专业(最高学位)"></input>&nbsp;&nbsp;毕业专业(最高学位)
								</span>
							</div>
							
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="qrzsfzy" name="checkbox" value="全日制师范专业毕业"></input>&nbsp;&nbsp;是否全日制师范专业毕业
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="mfsfs" name="checkbox" value="属于免费师范生"></input>&nbsp;&nbsp;是否属于免费师范生
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="teacherPoliticalStatus" name="checkbox" value="政治面貌"></input>&nbsp;&nbsp;政治面貌
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="partyTime" name="checkbox" value="入党时间"></input>&nbsp;&nbsp;入党时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="teacherNation" name="checkbox" value="民族"></input>&nbsp;&nbsp;民族
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="eliteTraining" name="checkbox" value="名校长培养对象"></input>&nbsp;&nbsp;名校长培养对象
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="teachingMaster" name="checkbox" value="教学名师"></input>&nbsp;&nbsp;教学名师
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobSubjectLeaderName" name="checkbox" value="学科带头人"></input>&nbsp;&nbsp;学科带头人
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="contract" name="checkbox" value="签订合同情况"></input>&nbsp;&nbsp;签订合同情况
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="adjustName" name="checkbox" value="编制类别"></input>&nbsp;&nbsp;编制类别
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="rych" name="checkbox" value="荣誉称号"></input>&nbsp;&nbsp;荣誉称号
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jxjybh" name="checkbox" value="继续教育编号"></input>&nbsp;&nbsp;继续教育编号
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jsnpxqk" name="checkbox" value="专任教师培训情况"></input>&nbsp;&nbsp;专任教师接受培训情况
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="salary" name="checkbox" value="月平均工资"></input>&nbsp;&nbsp;月平均工资
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="pthdj" name="checkbox" value="普通话等级"></input>&nbsp;&nbsp;普通话等级
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobCommentDate" name="checkbox" value="(评)职称时间"></input>&nbsp;&nbsp;(评)职称时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobRecruitmentDate" name="checkbox" value="(聘)职称时间"></input>&nbsp;&nbsp;(聘)职称时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="sfzb" name="checkbox" value="是否在编"></input>&nbsp;&nbsp;是否在编
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="gwlb" name="checkbox" value="岗位类别"></input>&nbsp;&nbsp;岗位类别
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="gwdj" name="checkbox" value="岗位等级"></input>&nbsp;&nbsp;岗位等级
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="postGrade" name="checkbox" value="聘任岗位等级时间"></input>&nbsp;&nbsp;聘任岗位等级时间
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobWorkTime" name="checkbox" value="参加工作时间"></input>&nbsp;&nbsp;参加工作时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jobWorkDate" name="checkbox" value="本校任教起始时间"></input>&nbsp;&nbsp;本校任教起始时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="cjqsny" name="checkbox" value="从教起始时间"></input>&nbsp;&nbsp;从教起始时间
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="postBack" name="checkbox" value="离岗待退时间"></input>&nbsp;&nbsp;离岗待退时间
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jdfldw" name="checkbox" value="借调分流单位"></input>&nbsp;&nbsp;借调分流单位
								</span>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="jdflTime" name="checkbox" value="借调分流时间"></input>&nbsp;&nbsp;借调分流时间
								</span>
							</div>
							<div>
								<span style="width:160px; height: 25px;">
									<input type="checkbox" id="remark" name="checkbox" value="备注"></input>&nbsp;&nbsp;备注
								</span>
							</div>
									
						</form>
					</div>
					
					<Br />
					<div class="tipbtn" style="width: 245px; padding: 100px; margin: 0 auto">
						<input name="" type="button" id="exportTeacherInfo" class="sure" value="导出报表" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="" type="button" class="cancel1" value="取消" />
					</div>
				</div>
		<!-- 报表导出字段组合模态框 -->
		
		<IFRAME id="downIframe" 　src="" frameborder=0 scrolling=no vspace=0
			hspace=0 marginheight=0 marginwidth=0 height=60 width="100%">
			</IFRAME>
	
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
			<div class="progress progress-striped active" style="margin-bottom: 0;">
				<!-- <div class="progress-bar" style="width: 100%;"></div> -->
				<span style="font-size:24px;">数据导出中，请稍后  . . .</span>
			</div>
		</div>
	</div>
	</body>

</html>
