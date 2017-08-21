<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师年度证书设置</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/ssYearCertificateList.js"> </script>
		<script type="text/javascript">
			$(document).ready(function(e) {
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
						<a href="###">继教证书</a>
					</li>
					<li>
						<a href="###">年度培训证书设置</a>
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
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="queryYear" id="queryYear">
											<option value="">请选择</option>
										</select>
									</div>
								</li>
								<li>
									<a id="select" href="###" class="dian3">查 询</a>
								</li>
							</ul>
						</div>
						<div class="chauxnJS jsTool">
							<span style="float: left;margin-left: 20px">
								<a onclick="addYearCertificate()">添加</a> 
							</span>
						</div>
						<table class="tablelist">
							<thead>
								<tr>
									<th width="5%" scope="col">年度</th>
									<th width="10%" scope="col">证书标题</th>
					                <th width="9%" scope="col">开始时间</th>
					                <th width="9%" scope="col">结束时间</th>
					                <th width="40%" scope="col">所需学分</th>
					                <th width="17%" scope="col">设置证书</th>
					                <th width="10%" scope="col">操作</th>
								</tr>
							</thead>
							<tbody id="ss_year_cer_list">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
