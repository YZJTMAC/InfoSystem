<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>上传培训成绩</title>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/editor/kindeditor.js">
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js">
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/ajaxfileupload.js">
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/commonUploadFile.js">
		</script>
		<style>
			.forminfo li {margin-bottom: -1px;}
			.forminfo li label {line-height: 22px;}
		</style>
		
		<script type="text/javascript">
			KE.show( {
				id : 'content7',
				cssPath : './index.css'
			});
		</script>

		<script type="text/javascript">
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

			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
			
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
			
				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});
			
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			
			});
			
			/**
			 * 模版下载
			 */
			function downTemplate(){
				$("#downIframe",document.body).attr("src",pathHeader + "/template/upload_score.xls");
			}
		</script>
		<script type="text/javascript">
			var projectId = '<%=request.getParameter("projectId")%>';
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/organization/importTeachersScore.js">
		</script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/projectLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						导入数据
					</li>
				</ul>
			</div>
			<div class="formbody">

				<input type="hidden" value="<%=request.getParameter("projectId")%>"
					name="projectId" />
				<input type="hidden" value="" id="savePath" />
				<input type="hidden" id="toDBPath" />

				<!-- 第一步: 准备数据 -->
				<div id="first" style="display: ''">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span><span class="loadx">&nbsp;</span><span>2.上传数据</span><span
							class="loadx">&nbsp;</span><span>3.校验数据</span><span class="loadx">&nbsp;</span><span>4.提交数据</span>
					</div>
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

								<input name="" type="button" class="btn" value="数据模板" onclick="downTemplate();"
									style="float: left; margin-left: 220px;" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<span class="sl-custom-file"> <input name=""
										type="button" class="btn" value="上传附件" /> <input id="ff"
										type="file" name="ff" class="ui-input-file"
										onchange="uploadFile()" /> </span>
							</li>
						</ul>
					</div>
				</div>



				<!-- 第二步:上传数据-->
				<div id="second" style="display: none">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">2.上传数据</span><span class="loadx">&nbsp;</span><span>3.校验数据</span><span
							class="loadx">&nbsp;</span><span>4.提交数据</span>
					</div>

					<div class="Uploadiv">

						<ul class="Uploadinfo">
							<li>
								<img src="<%=path%>/images/tishi.png" />
								&nbsp;如不小心上传错误，可点击“取消”终止，或点击“删除”删除错传的文件。
							</li>
							<li>
								<div id="ol" class="filediv">
									<%--<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile.png" />
										</li>
										<li>
											iconsweets1.zip
										</li>
										<li>
											<div style="border: 1px solid #657b90; margin-top: 3px; width: 100px;">
												<span id="progress"
													style="background-color: #5c7e9a; height: 10px; width: 10px;"></span>
											</div>
										</li>
										<li>
											<a href="#">取消</a>
										</li>
									</ol>
									<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile_ok.png" />
										</li>
										<li>
											培训管理系统-系统管理员菜单及页面.xls
										</li>
										<li>
											<a href="#">删除</a>
										</li>
									</ol>
									<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile_x.png" />
										</li>
										<li>
											培训管理系统-系统管理员菜单及页面.xls
										</li>
										<li>
											<a href="#">重新上传</a>
										</li>
									</ol>
									--%>
								</div>
							</li>
							<li style="text-align: center;">
								<label>
									&nbsp;
								</label>
								<span class="sl-custom-file"
									style="float: left; margin-left: 220px;"> <input name=""
										type="button" class="btn" value="继续添加" /> <input id="again"
										type="file" name="again" class="ui-input-file"
										onchange="uploadFileAgain()" /> </span> &nbsp;&nbsp;&nbsp;&nbsp;
								<input name="" type="button" class="btn" value="检测数据"
									onclick="testData();" style="float: left; margin-left: 10px;" />
							</li>

						</ul>
					</div>
				</div>





				<!-- 第三步: 校验数据 -->
				<div id="third" style="display: none">
					<div class="Uploadxu">
						<span class="txtcolor">1.准备数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">2.上传数据</span><span class="loadok">&nbsp;</span><span
							class="txtcolor">3.校验数据</span><span class="loadx">&nbsp;</span><span>4.提交数据</span>
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
											培训管理系统-系统管理员菜单及页面.xls
										</li>
										<li>
											数据正常
										</li>
									</ol>
								</div>
								<div class="filediv" id="toExl">
									<ol class="fileol">
										<li>
											<img src="<%=path%>/images/iconfile_x.png" />
										</li>
										<li>
											培训管理系统-系统管理员菜单及页面.xls
										</li>
										<li class="txtred">
											300条数据异常
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
								<input name="" type="button" class="btn" value="合并下载"
									onclick="downZip();" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="" type="button" class="btn" value="提交"
									onclick="submitData();" />
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
										省市县：
									</label>
									<label style="width: 320px;">
										选填，请从数据模板中的“政治面貌”字典中选择；
									</label>
								</li>
								<!--
						<li><label style="width: 60px;">市：</label><label style="width: 320px;">选填，同上；</label></li>
						<li><label style="width: 60px;">区县：</label><label style="width: 320px;">选填，同上；</label></li>-->
								<li>
									<label style="width: 60px;">
										学校名称：
									</label>
									<label style="width: 320px;">
										必填，如果学校可能存在重名，请填好该学校所在省市县；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										教师姓名：
									</label>
									<label style="width: 320px;">
										必填，6个汉字以内；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										身份证号：
									</label>
									<label style="width: 320px;">
										必填，不可重复，必须是合格的18位数字；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										用户名：
									</label>
									<label style="width: 320px;">
										必填，不可重复，4-20位英文、数字或下划线组合，第1位必须为字母；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										密码：
									</label>
									<label style="width: 320px;">
										选填，不填时，使用随机6位字符；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										教师编号：
									</label>
									<label style="width: 320px;">
										选填，不可重复，无格式要求；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										性别：
									</label>
									<label style="width: 320px;">
										必填，只能是“男”或“女”；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										政治面貌：
									</label>
									<label style="width: 320px;">
										必填，请从数据模板中的“政治面貌”字典中选择；
									</label>
								</li>
								<li>
									<label style="width: 110px;">
										教师资格证书号：
									</label>
									<label style="width: 110px;">
										选填，无格式要求；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										手机号码：
									</label>
									<label style="width: 320px;">
										选填，必须为11位数字；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										邮箱：
									</label>
									<label style="width: 320px;">
										选填，必须为标准邮箱格式；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										学段：
									</label>
									<label style="width: 320px;">
										必填，请从数据模板中的“学段”字典中选择；
									</label>
								</li>
								<li>
									<label style="width: 60px;">
										学科：
									</label>
									<label style="width: 320px;">
										必填，请从数据模板中的“学科”字典中选择，支持多选，用“,”分开；
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
								<cite>您可以<a href="###" onclick="importAgain()">继续导入</a></cite>
							</div>
						</div>

					</div>

				</div>




				<iframe id="downIframe"　src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>



			</div>
		</div>
	</body>
</html>
