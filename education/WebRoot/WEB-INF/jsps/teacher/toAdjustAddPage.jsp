<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编制调整管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toAdjustAddPage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 127
				});
			
			});
		</script>

		<style type="text/css">
			.cancel {
				background: url(../../images/btnbg2.png) repeat-x;
				color: #000;
				font-weight: normal;
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
						<a href="#">编制调整管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a
									href="<%=basePathHeader%>/teacher/teachermanage/toAdjustAddPage.htm?click=333"
									class="selected">发起编制调整</a>
							</li>
							<li>
								<a
									href="<%=basePathHeader%>/teacher/teachermanage/toAdjustPage.htm?click=333">已发起编制调整</a>
							</li>
						</ul>
					</div>

					<div id="tab2" class="tabson">

						<div class="formtitle">
							<span>查询要编制调整的教师</span>
						</div>
						<div class="tabson">


							<ul class="seachform">

								<li>
									<label>
										教师姓名：
									</label>
									<input name="realName" id="realName" type="text"
										class="scinput" />
								</li>
								<li>
									<label>
										身份证号：
									</label>
									<input name="idNumber" id="idNumber" type="text"
										class="scinput" />
								</li>

								<li>
									<label>
										&nbsp;
									</label>
									<input type="button" id="select" class="scbtn" value="查 询" />
								</li>
								<li>
									<span id="msg" style="color: #c00"></span>
								</li>
							</ul>

						</div>

						<div class="formtitle">
							<span>查询结果</span>
						</div>
						<div id="proTeacher_list">

						</div>


						<div class="tip0">
							<div class="tiptop2">
								<span>发起编制调整</span><span>&nbsp;&nbsp;带“<b
									style="color: #F00;">*</b>”为必填项</span><a></a>
							</div>

							<div class="tipinfo"
								style="padding: 10px; margin: 0;">
								<ul class="forminfo forminfo1" style="padding: 0; margin: 0;">

									<li>
										<label>
											当前编制
										</label>
										
										<div class="vocation" style="padding-right: 8px;" id="oldAdjustName">

										</div>

									</li>
									<li>
										<label>
											目标编制
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<select id="adjustId" class="select2">
											</select>
										</div><cite style="color: #F00;">*</cite>
									</li>
									<li>
										<label>
											编制调整说明
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<textarea name="mobilizeMark" id="mobilizeMark" cols=""
												rows="" class="textinput"
												style="width: 260px; height: 60px;"></textarea>
										</div>
										<cite style="color: #F00;">*</cite>
									</li>

									<li>
										<label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</label>

										<cite id="msgs" style="color: #c00"> </cite>
									</li>
								</ul>


							</div>
							<Br />

							<div class="tipbtn">
								<input name="" type="button" id="setMob" class="sure" value="提交" />
								&nbsp;
								<input name="" type="button" class="cancel" value="取消" />
							</div>

						</div>

					</div>

				</div>

			</div>

		</div>
		<div class="tip01"
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
						<input name="" id="toPage" type="button" class="sure1" value="确定" />

					</td>
				</tr>
			</table>
		</div>
		<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" ></div>
		
	</body>

</html>