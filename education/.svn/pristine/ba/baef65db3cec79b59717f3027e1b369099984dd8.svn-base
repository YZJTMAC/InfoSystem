<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>电子印章管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonUploadUserPhoto.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/toSignet.js"></script>
		<style type="text/css">
			.xm {
				overflow: hidden;
			}
			
			.xm .go {
				background-color: #078ACE;
				height: 20px;
				width: 71px;
				border: 1px solid #0A7AAA;
				color: #FFF;
				text-align: center;
			}
			
			.go:hover {
				color: #FFF;
				text-decoration: none;
				background-color: #0BA4F7;
			}
		</style>
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
						继教证书
					</li>
					<li>
						电子印章管理
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div style="margin-left: 20px;">
					<input name="" onclick="showUploadSignet();" type="button"
						class="sure" value="上传电子印章" />
				</div>
				<div id="targetList" style="margin-top: 30px;">


				</div>

			</div>

		</div>

		<!-- 上传电子印章 -->
		<div class="tip14" id="XXshow" style="display: none;">
			<div class="tiptop tiptop17">
				<span>上传电子印章</span><a href="javascript:;"
					onclick="document.getElementById('XXshow').style.display='none';"></a>
			</div>
			<div class="XXshowContent">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 40px auto;">
					<tr>
						<td></td>
						<td>
							<input id="photoFile" type="file" name="photoFile"
								onchange="uploadFile()" />
							只支持图片格式：.png，建议尺寸：200×200
						</td>
					</tr>
					<tr>
						<td>
							电子印章：
						</td>
						<td>
							<img id="photoTemp" title="电子印章"
								src="<%=basePathHeader%>/images/signet.jpg"
								style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;" />
						</td>

					</tr>
					<tr>
						<td style="line-height: 60px">
							印章名称：
						</td>
						<td>
							<input id="signetName" style="" name="signetName" type="text"
								class="scinput" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td style="color: #c00" id="error"></td>
					</tr>
				</table>
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 0 auto;">
					<tr>
						<td align="center">
							<input type="hidden" id="imageSrcTemp" value="" />
							<input type="button" onclick="saveUp();" class="btn true2"
								value="确定" />
						</td>
						<td width="30">
							&nbsp;
						</td>
						<td align="center">
							<input type="button" class="btn" value="取 消"
								onclick="closeUpload();" />
						</td>
					</tr>
				</table>

			</div>
		</div>

		<!-- 删除消息框提示 -->
		<div class="tip0" style="width: 400px; height: 150px; top: 40%; left: 35%">
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
						<table style="width: 60%">
							<tr>
								<td align="center"  id="toPage"></td>
								<td  align="center">
									<input name="" id="toCancel" style="display: none"
										type="button" class="cancel1" value="取消" />
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</div>
	</body>

</html>
