<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>项目证书打印</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/IEBrowserCheck.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"> </script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/teacherProPrinterCertificate.js"> </script>
		<script type="text/javascript">
			$(document).ready(function(e) {
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
						项目证书打印
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div id="usual1" class="usual">
					<div id="tab1" class="tabson">
						<div class="tabson">
							<ul class="seachform">
								<li>
									<label>
										项目名称：
									</label>
									<input id="projectName" name="input" type="text" class="scinput" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="yearpicker">
											<option value="">
												请选择...
											</option>
										</select>
									</div>
								</li>
								<li>
									<label>
										培训形式：
									</label>
									<div class="vocation">
										<select id="trainType" class="select3" name="trainType">
											<option value="">
												请选择...
											</option>
											<option value="1">
												远程培训
											</option>
											<option value="2">
												集中培训
											</option>
											<option value="3">
												混合式培训（集中+远程）
											</option>
										</select>
									</div>
								</li>
								<li>
									<a id="select" href="###" class="dian3">查 询</a>
								</li>
							</ul>
						</div>
						<div class="chauxnJS jsTool">
							<span style="float: right;">
								<div class="pagin" style="margin: 0;width: 120px;">
									<a href="javascript:void(0);" class="huibtn_a" onclick="downLoadPDFReader();" style="margin-right:10px;">PDF阅读器下载</a>
								</div> 
							</span>
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th width="20%">
										项目名称
									</th>
									<th width="5%">
										开始时间
									</th>
									<th width="5%">
										结束时间
									</th>
									<th width="5%">
										培训形式
									</th>
									<th width="5%">
										项目性质
									</th><%--
									<th width="5%">
										达标情况
									</th>
									--%><th width="20%">
										操作
									</th>
								</tr>
							</thead>
							<tbody id="teacher_pro_list">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
