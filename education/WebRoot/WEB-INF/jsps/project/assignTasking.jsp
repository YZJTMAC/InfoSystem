<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>承培机构任务分配</title>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"> </script>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"> </script>
		<script type="text/javascript">
			var proId = '<%=request.getParameter("projectId")%>';
			var proPlanNum = '<%=request.getParameter("planNum")%>';
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/assignTasking.js"></script>
		<script type="text/javascript">
			KE.show( {
				id : 'content7',
				cssPath : './index.css'
			});
		
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
						<a href="#none">培训项目管理</a>
					</li>
					<li>
						<a href="#none">承培机构任务分配</a>
					</li>
					<li>
						<a href="#none">指定承培机构</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson">
					<div>
						<table class="tablelist" style="margin-top: 12px;">
							<thead>
								<tr>
									<th  > 承培机构 </th>
									<th  > 计划培训人数 </th>
									<th  > 地区 </th>
									<th > 学科 </th>
									<th  > 操作 </th>
								</tr>
							</thead>
							<tbody id="org_list">
								<%--<tr id="tr1">
									<td>
										果实网&nbsp;
									</td>
									<td>
										0&nbsp;
									</td>
									<td>
										广州市&nbsp;
									</td>
									<td>
										语文,数学&nbsp;
									</td>
									<td>
										<a href="#" id="btn_fp" class="tablelink  ">分配任务</a>&nbsp;&nbsp;
									</td>
								</tr>
								<tr id="tr2">
									<td>
										果实网&nbsp;
									</td>
									<td>
										<input name="input" value="1000" type="text" class="scinput" />
										&nbsp;
									</td>
									<td>
										<div class="vocation">
											<input name="input2" type="text" class="scinput" colspan="4"
												value="广州市" />
											<input name="input2" type="button" value="选 择"
												class="btnXuan" />
										</div>
										&nbsp;
									</td>
									<td>
										<div class="vocation">
											<input name="input2" type="text" class="scinput" colspan="4"
												value="语文,数学" />
											<input name="input2" type="button" value="选 择"
												class="btnXuan" />
										</div>
										&nbsp;
									</td>
									<td>
										<a href="#" class="tablelink" id="btn_save">保存</a>&nbsp;&nbsp;
										<a href="#" class="tablelink" id="btn_cancel">取消</a>
									</td>
								</tr>
							--%></tbody>
						</table>
					</div>
				</div>
			</div>
			<table border="0" cellspacing="0" cellpadding="0" style="margin: 0 auto;">
				<tr>
					<td><a href="###" onclick="goBack();" class="dian3">返回</a></td>
				</tr>
			</table>
		</div>
		
		<input id="areaCode" type="hidden"/>
		<input id="subjectId" type="hidden"/>
		<input id="subjectName" type="hidden"/>
		<input id="subjectIds" type="hidden"/>
		<input id="subjectNames" type="hidden"/>
		<!-- 选择学科层 -->
		<div class="tips_zb_1" id="selectSubject">
			<div class="tiptop"><span>选择学科</span></div>
		    <div class="tipinfo">
		   		<div class="tipright" style="padding:0; margin-left:20;"> </div>
		        <ul class="forminfo" style="padding:0; margin:0;" id="selectS">
		        </ul>
		    </div>
	      	<div class="clear"></div>  
	        <ul class="seachform" style="padding-top:80px;">
	        	<li style="padding-left:120px;"><label>&nbsp;</label></li>
	        	<li><input name="" type="button"  class="dian3" value="确定" onclick="setSubject()"/></li>
	        	<li><input name="" type="button"  class="dian3" value="取消"  onclick="hideMe()"/></li>
	        </ul>
		</div>
		<%@include file="../common/commonAreaSelectByProject.jsp" %>
	</body>
</html>
