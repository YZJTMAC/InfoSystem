<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>导入专家</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonUploadFile.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/master/toUploadMaster.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
			
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
			
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="comparison" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/comparisonLeft.jsp"%>
		</div>
		<input type="hidden" value="" id="savePath"/>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>评比活动</li>
					<li>评比活动</li>
					<li>专家库</li>
					<li>批量导入</li>
				</ul>
			</div>
			<div class="formbody">

				<!-- 第一步: 准备数据 -->
				<div id="first" style="display: ''">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span>
						<span class="loadx">&nbsp;</span>
						<span>2.上传数据</span>
						<span class="loadx">&nbsp;</span>
						<span>3.校验数据</span>
						<span class="loadx">&nbsp;</span>
						<span>4.提交数据</span>
					</div>
					<form action="" id="fileForm" enctype="multipart/form-data"	method="post">
						<input type="hidden" id="toDBPath" />
						<input type="hidden" id="toExlPath" />
						<div class="Uploadiv">
							<ul class="Uploadinfo">
								<li>
									<img src="<%=path%>/images/tishi.png" />
									&nbsp;首先请下载“数据模板”Excel并按要求准备数据，然后使用“上传附件”按钮进行上传。
									<em class="txtred">为保证上传质量和速度，建议每一万条数据制作成一个数据表文件。</em>
								</li>
								<li style="text-align: center;">
									<label>
										&nbsp;
									</label>
									<input type="button" class="btn" value="数据模板"
										style="float: left; margin-left: 220px;"
										onclick="download();" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<span class="sl-custom-file"> 
										<input name="" type="button" class="btn" value="上传附件" /> 
										<input id="ff" type="file" name="ff" class="ui-input-file" onchange="uploadFile()" /> 
									</span>
								</li>
							</ul>
						</div>
					</form>
				</div>

				<!-- 第二步:上传数据-->
				<div id="second" style="display: none">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span>
						<span class="loadok">&nbsp;</span>
						<span class="txtcolor">2.上传数据</span>
						<span class="loadx">&nbsp;</span>
						<span>3.校验数据</span>
						<span class="loadx">&nbsp;</span>
						<span>4.提交数据</span>
					</div>

					<div class="Uploadiv">
						<ul class="Uploadinfo">
							<li>
								<img src="<%=path%>/images/tishi.png" />
								&nbsp;如不小心上传错误，可点击“取消”终止，或点击“删除”删除错传的文件。
							</li>
							<li>
								<div id="ol" class="filediv"></div>
							</li>
							<li style="text-align: center;">
								<label>
									&nbsp;
								</label>
								<span class="sl-custom-file" style="float: left; margin-left: 220px;"> 
									<input name="" type="button" class="btn" value="继续添加" /> 
									<input id="again" type="file" name="again" class="ui-input-file" onchange="uploadFileAgain()" /> 
								</span> &nbsp;&nbsp;&nbsp;&nbsp;
								<input name="" type="button" class="btn" value="检测数据"	onclick="checkData();" />
							</li>
						</ul>
					</div>
				</div>





				<!-- 第三步: 校验数据 -->
				<div id="third" style="display: none">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">2.上传数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">3.校验数据</span><span class="loadx">&nbsp;</span>
							<span>4.提交数据</span>
					</div>
					<div class="Uploadiv">
						<ul class="Uploadinfo">
							<li>
								<img src="<%=path%>/images/tishi.png" />
								&nbsp;如存在异常数据，点击“查看异常”下载查找原因；多个附件异常可点击“合并下载”查看和编辑，以便下次导入。
								<br />
								&nbsp;&nbsp;&nbsp;&nbsp;已通过校验的数据将会在稍后提交到系统中去，无需再重复提交。
							</li>
							<li>
								<div class="filediv" id="toDB">
									<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile_ok.png" />
										</li>
										<li>

										</li>
										<li>

										</li>
									</ol>

								</div>
								<div id="toExl">
									<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile_x.png" />
										</li>
										<li>

										</li>
										<li class="txtred">

										</li>
										<li>
											<a href="#">查看异常</a>
										</li>
									</ol>

								</div>
							</li>
							<li style="text-align: center;">
								<label>
									&nbsp;
								</label>
								<input id="ff" type="file" value="ff" style="display: none" />
								<a href="javascript:;" class="huibtn_a click"><img
										src="<%=path%>/images/shgbg.png" />数据校验规则</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="" type="button" class="btn" value="合并下载" onclick="downZip();" style="display: none" id="downZip"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="" type="button" class="btn" value="提交" onclick="submitData()" style="display: none" id="submitD" />
							</li>

						</ul>
					</div>



					<div class="tip" style="height: 490px;">
						<div class="tiptop">
							<span>数据校验规则</span><a></a>
						</div>

						<div class="tipinfo" style="height: 340px;">
							<ul class="forminfo" style="padding: 0; margin: 0;">
								<li>
									<label style="width: 60px;">
										专家名：
									</label>
									<label style="width: 320px;">
										专家名不可为空；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										用户名：
									</label>
									<label style="width: 320px;">
										用户名不可为空；且不可重复
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										密码：
									</label>
									<label style="width: 320px;">
										 密码不可为空；
									</label>
								</li>
							</ul>
						</div>

						<div class="tipbtn">
							<input name="" type="button" class="sure" value="确定" />
						</div>

					</div>

				</div>



				<!-- 第四步: 提交数据 -->
				<div id="four" style="display: none">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">2.上传数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">3.校验数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">4.提交数据</span>
					</div>

					<div class="Uploadiv">

						<div class="tipinfo"
							style="height: auto; overflow: hidden; margin: 0 auto; width: 430px; padding-bottom: 30px;">
							<span><img src="<%=path%>/images/ticon.png" /> </span>
							<div class="tipright">
								<p id="total">

								</p>
								<cite>您可以<a href="<%=basePathHeader%>/sys/toUploadPage.htm?click=2">继续导入</a>
								<a href="<%=basePathHeader%>/master/toMasterDatabase.htm">返回</a>
								</cite>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>

		<div class="tip1"
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
						<input name="" id="toPage" type="button" class="sure1" value="关闭" />

					</td>
				</tr>
			</table>
		</div>
<iframe id="downIframe"　src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
	</body>
</html>