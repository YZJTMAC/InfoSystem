<%@ page pageEncoding="UTF-8"%>
<!-- 该页面已经不需要
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加模板</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var id = '${id}';
			var projectId = '${projectId}';
			var click = '${click}';
			var type = '${type}';
			$(document).ready(function(e) {
				$(".select1").uedSelect( {
					width : 345
				});
				$(".select2").uedSelect( {
					width : 167
				});
				$(".select3").uedSelect( {
					width : 100
				});
			
			});
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.json-2.4.min.js"> </script>
		<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/kindeditor.js"> </script>
		<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/lang/zh_CN.js"> </script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/certificateAdd.js"> </script>
		<style>
			.moreChoose dd {
				width: 650px;
			}
			
		   #XXshow2 {
width: 760px;
left: 50%;
position: absolute;
top: 10%;
z-index: 999;
border: 1px solid #CCC;
margin-left: -330px;
background-color: #FFF;
box-shadow: 1px 8px 10px 1px #9b9b9b;
}
		</style>

		<script type="text/javascript">
			//var html1;
			var html2;
			//var html3;
			$(function() {
			//	html1 = kedit("head");
				html2 = kedit("content");
			//	html3 = kedit("foot");
			});
			
			
			function kedit(keid){ 
				//	KindEditor.ready(function(K) {
					var html1 = KindEditor.create('#'+keid, {
						urlType : 'relative',
						height:'500px',
						afterBlur: function(){this.sync();}
					});
				//	html2 = K.create('#content', {
				//		urlType : 'relative'
				//	});
				//	html3 = K.create('#foot', {
				//		urlType : 'relative'
				//	});
				//});
			}
		</script>
	</head>

	<body>
	 -->
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
						<a href="#none">继教信息</a>
					</li>
					<li>
						学时证书模板设置
					</li>
					<li>
						<a href="#none">添加模板 </a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson" id="txtBox">
					<table border="0" cellspacing="0" cellpadding="0" style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td> 模板名称： </td>
							<td colspan="4">
								<input style="width: 650px" id="title" name="input" value="" type="text" class="scinput" />
							</td>
							<td> </td>
						</tr>
						<tr>
							<td style="height: 5px"> &nbsp; </td>
						</tr>
						<tr>
							<td>
								模板背景：
							</td>
							<td colspan="3">
								<input name="" onclick="queryCertificateBackground()" type="button" class="sure" value="已上传模板">
								<input name="" onclick="showUpload();" type="button" class="sure" value="上传模板">
							</td>
							<td><span style="color: red;">可不设置，系统将使用默认模板</span></td>
							<td>
							</td>
						</tr>
						<tr>
							<td style="height: 5px"> &nbsp; </td>
						</tr>
						<tr>
							<td> 证书年度： </td>
							<td colspan="4">
								<select id="year" class="select3 yearpicker"></select>
							</td>
							<td> </td>
						</tr>
						<tr>
							<td style="height: 5px"> &nbsp; </td>
						</tr>
						<tr>
							<td> 证书正文： </td>
							<td colspan="4">
								<textarea id="content" name="textarea"></textarea>
							</td>
							<td> </td>
						</tr>
						<tr style="height: 5px">
							<td style="height: 5px"> &nbsp; </td>
							<td colspan="4">
								<span style="color: red;">在编辑时， 显示证书编号处请用{code}字符代替， 注意大小写！<br/>
								 如: 证书编号：YN20140716230300要写成证书编号：YN{code}， 后面数字系统会自动生成前缀需手动设定， 
								 <br/>显示学员姓名处请用{name}字符代替， 注意大小写！  如: XXX同志要写成{name}同志<br/>
								        学时用{period}字符代替，&nbsp; 学分用{score}字符代替， 成绩用{grade}字符代替												
							</span>
							</td>
						</tr>
						<tr>
							<td style="height: 5px"> &nbsp; </td>
						</tr>
						<tr>
							<td> 电子印章：
							</td>
							<td colspan="4">
								距左：
								<input id="positionRight" name="" type="text" class="scinput" style="width: 65px;"/>
								px 距顶：
								<input id="positionTop" name="" type="text" class="scinput" style="width: 65px;"/>
								px 宽度：
								<input id="positionWidth" name="" type="text" class="scinput" style="width: 65px;"/>
								px 高度：
								<input id="positionHeight" name="" type="text" class="scinput" style="width: 65px;"/>
								px
							</td>
							<td>
								<input type="checkbox" id="isDisplay"/> 是否显示
							</td>
						</tr>
						<tr>
							<td> 选择电子印章： </td>
							<td colspan="4">
								<div id="panelimage" style="border-color: buttonshadow; border-width: 1px; border-style: Solid; width: 640px; overflow: auto;">
									<table id="rblImageList" border="0" style="width: 90%;">
										<tr>
											<td id="signetHtml"> <span style="">没有查询到任何电子印章</span> </td>
										</tr>
									</table>
									<span id="lblImage" style="color: Red; display: none"></span>
								</div>
							</td>
							<td> </td>
						</tr>
					</table>
					<br />
					<table border="0" cellspacing="0" cellpadding="0" style="margin: 0 auto;">
						<tr>
							<td> <a href="###" onclick="saveCertificate();" class="dian3">保 存</a> </td>
							<td style="width: 30px;"> &nbsp; </td>
							<td> <a href="###" onclick="cancel();" class="dian3">取 消</a> </td>
						</tr>
					</table>
				</div>
				<div class="black" style="display: none;" id="black"></div>
			</div>
			
			<div class="tip14" id="XXshow" style="display: none;">
			<div class="tiptop tiptop17">
				<span>上传证书模板</span><a href="javascript:;"
					onclick="document.getElementById('XXshow').style.display='none';"></a>
			</div>
			<div class="XXshowContent">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 40px auto;">
					<tr>
						<td>说明：</td>
						<td>可不上传，如果不上传，则使用系统提供的默认模板
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input id="certificateFile" type="file" name="certificateFile"
								onchange="uploadFile()" />
							支持图片格式：.jpg/.png，建议尺寸：1300*919
						</td>
					</tr>
					<tr>
						<td>
							模板：
						</td>
						<td>
							<img id="certificateTemp" title="模板"
								src="<%=basePathHeader%>/images/imgTemplate/code.jpg"
								style="height: 400px; width: 400px; border: 1px solid #eee; margin-top: 10px;">
						</td>

					</tr>
					<tr>
						<td style="line-height: 60px">
							模板名称：
						</td>
						<td>
							<input id="certificateName" style="" 　name="certificateName" type="text"
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
		
		<div class="tip15" id="XXshow2" style="display: none;">
			<div class="tiptop tiptop17">
				<span>已上传证书模板</span><a href="javascript:;"
					onclick="document.getElementById('XXshow2').style.display='none';"></a>
			</div>
			<div class="XXshowContent">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 40px auto;">
					<tr>
						<td>说明：</td>
						<td>可不选择，如果不选择，则使用系统提供的默认模板
						</td>
					</tr>
					<tr>
						<td>
							默认模板：
						</td>
						<td>
							<img id="certificateTemp" title="模板"
								src="<%=basePathHeader%>/images/imgTemplate/code.jpg"
								style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;">
							<input type="radio" checked="checked" name="certificateBackgroundImg"  value="-1"/>
						</td>

					</tr>
					<tr >
						<td>
							已上传模板：
						</td>
						<td id="certificateFiles">
							
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
							<input type="button" onclick="saveUpImg();" class="btn true2"
								value="确定" />
						</td>
						<td width="30">
							&nbsp;
						</td>
						<td align="center">
							<input type="button" class="btn" value="取 消"
								onclick="closeUpload2();" />
						</td>
					</tr>
				</table>

			</div>
		</div>
		
			<div class="tip0" style="width: 400px; height: 150px; top: 800px; left: 35%">
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
									<td align="center" id="toPage"></td>
									<td align="center">
										<input name="" id="toCancel" style="display: none" type="button" class="cancel1" value="取消" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>