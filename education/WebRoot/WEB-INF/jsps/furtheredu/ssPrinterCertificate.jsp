<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=8; IE=9;" />
		<title>教师证书打印</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var proId = '<%=request.getParameter("proId")%>';
			var type = '<%=request.getParameter("type")%>';
		</script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 120
				});
			});
		</script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/IEBrowserCheck.js"></script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/ssPrinterCertificate.js"></script>
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
						<a href="###">证书打印</a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson">
					<ul class="forminfo">
						<li>
							<p class="xmTool">
								培训项目：
								<b id="proName"></b>
							</p>
						</li>
						<li>
							<label>
								教师姓名：
							</label>
							<div class="vocation">
								<input id="teacherName" name="input" type="text" class="dfinput" style="width: 200px; margin-right: 20px;"/>
							</div>
							<input id="select" name="input3" type="button" class="dian3" value="查 询" />
						</li>
					</ul>
				</div>
				<div class="chauxnJS jsTool">
					<span style="float: left;">
						<!-- <a href="###" class="huibtn_a batchModify" onclick="batchPrintCertificate();" style="margin-right:8px;">批量打印项目证书</a> -->
						<a href="javascript:void(0);" class="huibtn_a batchModify" onclick="batchProductCertificate();" style="margin-right:8px;">批量下载项目证书</a>
					</span>
					<span style="float: right;">
						<div class="pagin" style="margin: 0;width: 230px;">
						<a href="javascript:void(0);" class="huibtn_a" onclick="downLoadPDFReader();" style="margin-right:18px;">PDF阅读器下载</a>
							<div class="message">
								共 <i class="blue" id="counts">0</i>条记录
							</div>
							<div class="vocation paginList" style="margin: 4px 6px 0 6px; right: 0px;">
								<select onchange="queryProList();" id="sizePerPage" class="select3">
									<option value="20">
										每页显示20条
									</option>
									<option value="50">
										每页显示50条
									</option>
									<option value="100">
										每页显示100条
									</option>
								</select>
							</div>
						</div> 
						</span>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th>
								<input id="chk_all" type="checkbox" />
							</th>
							<th scope="col">
								教师姓名
							</th>
							<th scope="col">
								性别
							</th>
							<th scope="col">
								学校
							</th>
							<th scope="col">
								培训学时
							</th>
							<th scope="col">
								审核评价
							</th>
							<th scope="col">
								所获学分
							</th>
							<th scope="col">
								操作
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
			</div>
		</div>
		
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
				<div class="progress progress-striped active" style="margin-bottom: 0;">
					<!-- <div class="progress-bar" style="width: 100%;"></div> -->
					<span style="font-size:24px;">证书下载中，请稍后  . . .</span>
				</div>
			</div>
		</div>
		
	</body>
</html>
