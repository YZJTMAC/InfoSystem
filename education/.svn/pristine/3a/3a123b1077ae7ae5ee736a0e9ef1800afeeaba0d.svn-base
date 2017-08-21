<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>教师离退休管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toRetireesAddPage.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select3").uedSelect( {
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
			
			.cancel1 {
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
						<a href="#">教师离退休管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div id="usual1" class="usual">

					<div class="itab">
						<ul>
							<li>
								<a href="###"  class="selected">发起离退休</a>
							</li>
							<li>
								<a id="goto" href="<%=basePathHeader %>/teacher/teachermanage/teacherRetireesPage.htm?click=4">已发起离退休</a>
							</li>
							<li>
								<a href="<%=basePathHeader %>/edupm/teachermanage/toAdutiImportRecordPage.htm?click=4">教师离退休导入</a>
							</li>
						</ul>
					</div>

					<div id="tab2" class="tabson">

						<div class="formtitle">
							<span>查询要离退休的教师</span>
						</div>
						<div class="tabson">


							<ul class="seachform">

								<li>
									<label>
										教师姓名：
									</label>
									<input name="realName" id="realName" type="text" class="scinput" />
								</li>
								<li>
									<label>
										身份证号：
									</label>
									<input name="idNumber" id="idNumber" type="text" class="scinput" />
								</li>

								<li>
									<label>
										&nbsp;
									</label>
									<input type="button" id="select" class="scbtn" value="查 询"/>
								</li>
								<li>
								<span id="msg" style="color:#c00"></span>
								</li>
							</ul>

						</div>

						<div class="formtitle">
							<span>查询结果</span>
						</div>
						<div id="proTeacher_list">

						</div>


				<div class="tip2">
				    <div class="tiptop2">
				    	<span>离退休修改</span><span>&nbsp;&nbsp;带“<b style="color: #F00;"">*</b>”为必填项</span>
				    </div>
				        
				    <div class="tipinfo">
				        <ul class="forminfo" style="padding:0; margin:0;">
				    <li><label>离退休类型</label>  
				    <div class="vocation">
				    <select id="changeType" class="select3">
					    <option value="31">退休</option>
					    <option value="33">离休</option>
				    </select>
				    </div><i></i>
				    </li>
					 <li>
							<label>
								离退休说明
							</label>
							<div class="vocation" style="padding-right: 8px;">
								<textarea name="mobilizeMark" id="mobilizeMark" cols=""
									rows="" class="textinput" 
									style="width: 260px; height: 60px;"></textarea>
							</div>
							<cite style="color: #F00;">*</cite>
						</li>
						<li><label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</label>
										
									<cite id="msgs" style="color: #c00">
										
									</cite>
						</li>
						</ul>
				      </div>
				        
				        <div class="tipbtn">
							<input name="" type="button"  class="sure" value="提交" />&nbsp;
							<input name="" type="button"  class="cancel" value="取消" />
				        </div>
				        
				        <input id="teacherId" type="hidden"  />
				    </div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>