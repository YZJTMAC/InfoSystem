<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>角色管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/toRolePage.js"></script>
		<script type="text/javascript">
			var roleTypeId = '${sessionScope.userinfo.roleTypeId}';
		</script>
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select2").uedSelect( {
					width : 167
				});
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});
			
				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});
			
				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});
			});
		</script>
	</head>

	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="system" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/systemLeft.jsp"%>
		</div>

		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">系统管理</a>
					</li>
					<li>
						<a href="#">角色管理</a>
					</li>
				</ul>
			</div>
		
	       <div class="tip">
					<div class="tiptop">
						<span>添加角色</span><a></a>
					</div>

					<div class="tipinfo">
						<div class="tipright" style="padding: 0; margin: 0;"></div>
						<table border="0" cellspacing="0" cellpadding="0"
							style="margin: 0 auto; line-height: 42px;">
							<tr>

								<td width="64">
									<b style="color: red">*</b>角色类型:
								</td>
								<td width="170">
									<li>
										<div class="vocation">
											<select id="roleType" name="select" class="select2"
												width="180">
												<option value="">
													--请选择--
												</option>
												
											</select>
										</div>
									</li>
									<a style="color: red" id="selectedError"></a>
								</td>

							</tr>
							<tr>
								<td>
									<b style="color: red">*</b>角色名称:
								</td>
								<td>
									<input maxlength="100" name="input" type="text" class="scinput"
										id="roleName" style="width: 180px;" maxlength="100"/>
									<a style="color: red" id="CodeError"></a>
								</td>

							</tr>
							
						</table>
						<br/>
						<!-- <span style="width: 280px;" maxlength="400"> -->
						<p>1：此功能是为了角色定制开发。</p>
							<p>2：分为角色类型和角色名称，一个角色类型下可以创建多个角色名称。</p>
							<p>3：角色名称有系统默认的，是整个系统中使用的，只有省级管理员可以编辑。</p>
							<p>4：行政管理员可以添加新的角色名称，可以在所管辖的区域使用。</p>
							<p>5：对于系统批量生成的管理员，都是使用系统默认的角色类型和角色名称。</p>
							<!-- </span> -->
						
					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure" onclick="addRole()"
							id="submit" value="保 存" />
						&nbsp;
						<input name="" type="button" class="cancel" value="取 消" />
					</div>

				</div>


			<div class="formbody">
   			<div class="chauxnJS jsTool">

						<span style="float: left;"> 
							<a id="btnAdd" style="margin-left: 6px" class="huibtn_a click" href="#">添加</a>
						</span>
						<!-- <span style="float: right"> 
							<a style="margin-right: 6px" class="click1" href="#">角色管理操作说明</a>
						</span> -->
			</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th>
								角色名称
							</th>
							<th>
								角色类型
							</th>
							<th>
								创建者
							</th>
							<th>
								创建者地区
							</th>
							<th>
								状态
							</th>
							<th>
								操作
							</th>
						</tr>
					</thead>

					<tbody id="proTeacher_list">

					</tbody>

				</table>


			</div>
		</div>
	</body>

</html>
