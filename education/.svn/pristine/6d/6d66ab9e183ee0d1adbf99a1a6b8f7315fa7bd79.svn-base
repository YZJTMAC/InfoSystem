<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>证书模板设置</title>
		<%@include file="../common/commonHead.jsp"%>
		<style type="text/css">
			.tip15, .tip16, .tip17 {
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
			var id = '${id}';
			var projectId = '${projectId}';
			var click = '${click}';
			var type = '${type}';
			
			var projectPrefix = '${projectPrefix}';
			var areaCode = '${areaCode}';
			var yearCode = '${yearCode}';
			var projectScopeCode = '${projectScopeCode}';
			var projectTrainTypeCode = '${projectTrainTypeCode}';
			var orgCode = '${orgCode}';
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
					width : 100
				});
			
				if(type==1){
					$('#daohang').html("年度证书模板设置");
				} else if(type==2){
					$('#daohang').html("项目证书模板设置");
				}else if(type==3){
					$('#daohang').html("学时证书模板设置");
					$('#certificateTemp').attr("src","<%=basePathHeader%>/images/imgTemplate/period.jpg");
					$('#certificateTemp_back').attr("src","<%=basePathHeader%>/images/imgTemplate/period.jpg");
					$('#QRCodeTemp_back').attr("src","<%=basePathHeader%>/images/qrbg.jpg");
				}
			});
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/certificateAdd.js"></script>
		<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="<%=basePathHeader%>/kindeditor/lang/zh_CN.js"></script>
		
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
					<li id="daohang">
						
					</li>
				</ul>
			</div>
			<div class="formbody">



				<div class="tabson" id="txtBox">

					<table border="0" cellspacing="0" cellpadding="0" style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td>
								模板名称：
							</td>
							<td colspan="4">
								<input style="width: 650px" id="title" name="input" value=""
									type="text" class="scinput" />
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td>
								模板背景：
							</td>
							<td colspan="2">
								<input name="" onclick="queryCertificateBackground()" type="button" class="sure" value="已上传模板"/>
								<input name="" onclick="showUpload();" type="button" class="sure" value="上传模板"/>
							</td>
							<td><span style="color: red;">可不设置，系统将使用默认模板</span></td>
							<td>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<input name="backgroundImg" id="backgroundImg" type="hidden" value="-1"/>
								<input name="QRbackgroundImg" id="QRbackgroundImg" type="hidden" value="-1"/>
								<input name="id" id="id" value="" type="hidden"/>
								<input name="oldProjectCode" id="oldProjectCode" value="" type="hidden"/>
							</td>
						</tr>						
						<tr>
							<td>
								证书年度：
							</td>
							<td colspan="4">
								<select id="year" class="select3 yearpicker"></select>
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td>
								证书正文：
							</td>
							<td colspan="12">
								<textarea id="content" name="textarea"></textarea>
							</td>
							<td>
								
							</td>
						</tr>
						<tr style="height: 5px">
							<td style="height: 5px">
								设置说明：
							</td>
							<td colspan="4">
							<span style="color: red;">在编辑时， 显示证书编号规则请使用下面设置证书编号规则组成，编号后六位会自动生成， 注意大小写！<br/>
								如: 项目名称：使用{projectName}代替，&nbsp; 开始时间使用 {startDate}代替，&nbsp; 结束时间使用{endDate}代替<br/>
								  证书编号：YN20140716230300要写成证书编号：$YN$， 后面数字系统会自动生成前缀需手动设定， 
								 <br/>显示学员姓名处请用{name}字符代替， 注意大小写！  如: XXX同志要写成{name}同志<br/>
								 
								        学时用{period}字符代替，&nbsp; 学分用{score}字符代替， 成绩用{grade}字符代替												
							</span>
							</td>
						</tr>
						<tr>
							<td style="height: 5px">
								&nbsp;
							</td>
						</tr>						
						<tr>
							<td>设置证书编号：</td>
						
							<td colspan="4">
								<input id="isprojectPrefix" name="certificate" type="checkbox"/>
								项目前缀： <input id="projectPrefixCode"  maxlength="20" type="text" class="scinput" onblur="checkProjectCode($(this))" value="${projectPrefix}"/>
								<input id="isareaCode" name="certificate" type="checkbox"/> 
								地区代码：<input id="areaCode"  style="width: 98px;" type="text" class="scinput" value="${areaCode}" readonly="true" />
							
								<input id="isyearCode" name="certificate" type="checkbox"/> 
								年份代码：<input id="yearCode"  style="width: 98px;" type="text" class="scinput"  value="${yearCode}" readonly="true"/>
							</td>
							
						</tr>
						<tr>
						<td></td>
						<td colspan="4">
							<input id="isProjectScopeCode" name="isProjectScopeCode" type="checkbox" value=""/>
							项目性质代码：<input id="projectScopeCode"  style="width: 98px;" type="text" class="scinput" value="${projectScopeCode}" readonly="true"/>
						
								<input id="isProjectTrainTypeCode" name="isProjectTrainTypeCode" type="checkbox"/> 
								培训类型代码：<input id="projectTrainTypeCode"  style="width: 98px;" type="text" class="scinput" value="${projectTrainTypeCode}" readonly="true"/>
							
								 <input id="isOrgCode" name="isOrgCode" type="checkbox"/>
								 院校(机构)代码：<input id="orgCode"  style="width: 98px;" type="text" class="scinput"  value="${orgCode}" readonly="true"/>
							</td>
						</tr>
						
						<tr>
							<td>
								电子印章：
							</td>
							<td colspan="4">
								距左：
								<input id="positionRight" name="" type="text" class="scinput"
									style="width: 65px;" />
									px 距顶： <input id="positionTop" name="" type="text"
										class="scinput" style="width: 65px;" />
										px 宽度： <input id="positionWidth" name="" type="text"
											class="scinput" style="width: 65px;" />
											px 高度： <input id="positionHeight" name="" type="text"
												class="scinput" style="width: 65px;" />
												px 
							</td>
							<td>
								<input type="checkbox" id="isDisplay" />
									是否显示
							</td>
						</tr>

						<tr>
							<td>
								选择电子印章：
							</td>
							<td colspan="4">
								<div id="panelimage"
									style="border-color: buttonshadow; border-width: 1px; border-style: Solid; width: 640px; overflow: auto;">

									<table id="rblImageList" border="0" style="width: 90%;">
										<tr>
											<td id="signetHtml" >
												<span style="">没有查询到任何电子印章</span>
											</td>
										</tr>
									</table>
									<span id="lblImage" style="color: Red; display: none"></span>

								</div>
							</td>							
						</tr>

						
						<tr>
							<td>
								二维码：
							</td>
							<td colspan="4">
								距左：
								<input id="QRCodeRight" name="" type="text" class="scinput"
									style="width: 65px;" />
									px 距顶： <input id="QRCodeTop" name="" type="text"
										class="scinput" style="width: 65px;"/>
										px 宽度： <input id="QRCodeWidth" name="" type="text"
											class="scinput" style="width: 65px;"/>
											px 高度： <input id="QRCodeHeight" name="" type="text"
												class="scinput" style="width: 65px;"/>
												px 
							</td>
							<td>
								<input type="checkbox" id="isDisplayQRCode" />
									是否显示
							</td>
						</tr>
						
						<tr>
							<td>
								选择二维码：
							</td>
							<td colspan="4">
								<div id="panelimage" style="border-color: buttonshadow; border-width: 1px; border-style: Solid; width: 640px; overflow: auto;">

									<table border="0" style="width: 90%;">
										<tr>
											<td id="QRCodeImg" >
											</td>
										</tr>
									</table>
								</div>
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td>
								二维码验证背景标题：
							</td>
							<td colspan="3">
								<input id="periodCertificateTitle" name="periodCertificateTitle" style="width: 640px;" type="text" class="scinput" />
							</td>
							
						</tr>
						<tr>
							<td>
								二维码背景设置：
							</td>
							<td colspan="2">
								<input name="" onclick="queryQRCodeBackground()" type="button" class="sure" value="已上传背景" />
								<input name="QRCodeTemp_back" onclick="showQRCodeUpload();" type="button" class="sure" value="上传背景" />
							</td>
							<td><span style="color: red;">不设置，系统将使用默认背景</span></td>
						</tr>
					</table>
					<br />
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 0 auto;">
						<tr>
							<td>
								<a href="###" onclick="saveCertificate();" class="dian3">保 存</a>
							</td>
							<td style="width: 30px;">
								&nbsp;
							</td>
							<td>
								<a href="###" onclick="cancel();" class="dian3">取 消</a>
							</td>
						</tr>
					</table>

				</div>

				<div class="black" style="display: none;" id="black"></div>
			</div>
			
			<!-- 上传证书模板 -->
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
								<!-- 支持图片格式：.jpg/.png，建议尺寸：1300*919 -->
								支持图片格式：.jpg/.png，建议尺寸：920*690
							</td>
						</tr>
						<tr>
							<td>
								模板：
							</td>
							<td>
								<img id="certificateTemp_back" title="模板"
									src="<%=basePathHeader%>/images/imgTemplate/code_back.jpg"
									style="height: 400px; width: 400px; border: 1px solid #eee; margin-top: 10px;"/>
							</td>
	
						</tr>
						<tr>
							<td style="line-height: 60px">
								模板名称：
							</td>
							<td>
								<input id="certificateName" style="" name="certificateName" type="text"
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
		
			<!-- 已上传证书模板 -->
			<div class="tip15 tipbox" id="certificateBox" style="display: none;">
				<div class="tiptop tiptop17">
					<span>已上传证书模板</span><a href="javascript:;"
						onclick="document.getElementById('certificateBox').style.display='none';"></a>
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
									src="<%=basePathHeader%>/images/imgTemplate/code_back.jpg"
									style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;"/>
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

			<!-- 上传二维码验证信息背景 -->
			<div class="tip16" id="XXshow16" style="display: none;">
				<div class="tiptop tiptop17">
					<span>上传二维码验证背景 </span><a href="javascript:;"
						onclick="document.getElementById('XXshow16').style.display='none';"></a>
				</div>
				<div class="XXshowContent">
					<table border="0" cellspacing="0" cellpadding="0"
						style="margin: 40px auto;">
						<tr>
							<td>说明：</td>
							<td>如不上传,系统将使用默认背景
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input id="QRCodeFile" type="file" name="QRCodeFile"
									onchange="uploadQRCodeFile()" />
								支持图片格式：.jpg/.png，建议尺寸：100*100
							</td>
						</tr>
						<tr>
							<td>
								背景：
							</td>
							<td>
								<img id="QRCodeTemp_back" title="二维码验证背景"
									src="<%=basePathHeader%>/images/qrbg.jpg"
									style="height: 400px; width: 400px; border: 1px solid #eee; margin-top: 10px;" />
									<input type="radio" checked="checked" name="QRCodeBackgroundImg"  value="-1"/>
							</td>
	
						</tr>
						<tr>
							<td style="line-height: 60px">
								二维码背景名称：
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
								<input type="hidden" id="imageQRCodeSrcTemp" value="" />
								<input type="button" onclick="saveQRUp();" class="btn true2"
									value="确定" />
							</td>
							<td width="30">
								&nbsp;
							</td>
							<td align="center">
								<input type="button" class="btn" value="取 消"
									onclick="closeUploadQRCode();" />
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
										<input name="" id="toCancel" style="display: none"
											type="button" class="cancel1" value="取消" />
									</td>
								</tr>
							</table>

						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- 已上传二维码背景 -->
		<div class="tip17 tipbox" id="qrcodeBox" style="display: none;">
			<div class="tiptop tiptop17">
				<span>已上传二维码背景</span><a href="javascript:;"
					onclick="document.getElementById('qrcodeBox').style.display='none';"></a>
			</div>
			<div class="XXshowContent">
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 40px auto;">
					<tr>
						<td>说明：</td>
						<td>可不选择，如果不选择，则使用系统提供的默认背景
						</td>
					</tr>
					<tr>
						<td>
							默认背景：
						</td>
						<td>
							<img id="QRCodeTemp_back" title="二维码背景"
								src="<%=basePathHeader%>/images/qrbg.jpg"
								style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;" />
							<input type="radio" checked="checked" name="QRCodeBackgroundImg"  value="-1"/>
						</td>

					</tr>
					<tr >
						<td>
							已上传背景:
						</td>
						<td id="QRCodeFiles">
							
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
							<input type="button" onclick="saveUpQRImg();" class="btn true2"
								value="确定" />
						</td>
						<td width="30">
							&nbsp;
						</td>
						<td align="center">
							<input type="button" class="btn" value="取 消"
								onclick="closeUpload3();" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>