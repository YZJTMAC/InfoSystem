<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>学校管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<%@include file="../common/commonAreaSelectAll.jsp" %>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/toSchoolPage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 127
				});
				$(".select3").uedSelect( {
					width : 120
				});
			});
		</script>
		<style type="text/css">
			.cancel {
				background: url(../images/btnbg2.png) repeat-x;
				color: #000;
				font-weight: normal;
			}
		</style>
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
						<a href="#">学校管理</a>
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
									学校类型:
								</label>
								<div class="vocation">
									<select id="schoolTypeId" name="select" class="select2">
									
									</select>
								</div>
							</li>

							<li>
								<label>
									学校名称:
								</label>
								<div class="vocation">
									<input id="schoolName" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
						</ul>
						<ul class="seachform" style="padding-left: 23px;">
							
								<li>
								<label>
									学校编码:
								</label>
								<div class="vocation">
									<input id="schoolCode" name="input" value="" type="text" class="scinput" />
								</div>
							</li>
							
							<li>
								<label>
									所属地区:
								</label>
								<div class="vocation">
									<input name="input" id="tss" value="" type="text" onclick="clearPCD();" class="scinput areaSelect" style="width:260px;" />
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
						<span style="float: left;"> 
						<a href="<%=basePathHeader %>/sys/toAddSchoolPage.htm?click=2"
							class="huibtn_a" style="margin-left: 6px">添加</a>&nbsp;
							
							
						<a
							href="<%=basePathHeader %>/sys/toUploadPage.htm?click=2" class="huibtn_a " style="margin-left: 6px">批量导入</a>
							
							<a
							href="#" class="huibtn_a " onclick="exportSysSchoolToExcel();" style="margin-left: 6px">导出</a>
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="showSchoolList();" id="sizePerPage" class="select3">
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
								<th width="4%">
									学校名称
								</th>
								<th width="7%">
									学校类型
								</th>
								<th width="7%">
									学校编码
								</th>
								<th width="7%">
									所属地区
								</th>
								<th width="7%">
									操作
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
					<input type="hidden" name="schoolProvinceId" id="schoolProvinceId" value=""/>
					<input type="hidden" name="schoolCityId" id="schoolCityId" value=""/>
					<input type="hidden" name="schoolDistrictId" id="schoolDistrictId" value=""/>
				</div>
			</div>
		</div>
		
		<div class="tip"
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
						<input name="" id="cancel" type="button" class="cancel" value="取消" />
						
					</td>
				</tr>
			</table>
		</div>
		<iframe id="downIframe"　src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
	</body>
</html>
