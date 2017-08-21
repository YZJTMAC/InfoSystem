<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>
<%@page import="project.person.pojo.EduUserActivty" %>
<%
int roleId = ((EduUserActivty)session.getAttribute("userinfo")).getRoleId();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>实施机构管理</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/organizationManagePage.js"></script>
		<script type="text/javascript">
			var type = 2;
			$(document).ready(function(e) {
				$(".select3").uedSelect({
					width : 100
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
<div class="place">
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">系统管理</a>
					</li>
					<li>
						<a href="#">实施机构管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="formbodyL"
					style="overflow: hidden; padding-bottom: 20px;">
					<div class="tabson">
						 <ul class="seachform" style="padding-left:23px;">
                        
    						<li><label>机构名称:</label>  
    							<div class="vocation">
     							 <input name="input" value="" type="text" class="scinput" id="organizationName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   								</div>
								<input id="select" type="button" class="scbtn" value="查 询" />
							</li>
						</ul>
					</div>

					<div class="chauxnJS jsTool">
					
						<span style="float: left;"> <a href="#" 
							 style="margin-left: 6px" onclick="addInfo(2)">添加</a>
							 <%if(roleId == 1){ %>
							 <a href="#" class="huibtn_a click"
							 style="margin-left: 6px" id="btnAdd2" onclick="importInfo(2)">批量导入</a>
							 <%} %>
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="showList();" id="sizePerPage" class="select3">
										<option value="100">
											每页显示100条
										</option>
							
										<option value="300">
											每页显示300条
										</option>
										<option value="500">
											每页显示500条
										</option>
									</select>
								</div>

							</div> </span>
					</div>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="20%">
									机构名称
								</th>
								<th width="10%">
									联系人
								</th>
								<th width="15%">
									联系方式
								</th>
								<th width="20%">
									所在地区
								</th>
								<th width="10%">
									机构编码
								</th>
								<th width="25%">
									操作
								</th>
							</tr>
						</thead>

						<tbody id="organization_list">

						</tbody>
					</table>

					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
				
	
				<div class="tip2">
    				<div class="tiptop" ><span>编辑机构</span><a></a></div>
       				<div class="tipinfo">
      					<div class="tipright" style="padding:0; margin:0;"></div>
        					<table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto; line-height:42px;">
							    <tr>
							     	<td>机构名称:</td><td>  <input name="input" type="text" class="scinput"  id="organizationName2"/></td>
							    </tr>
								<tr>
							    	<td>联系人:</td><td>  <input name="input" type="text" class="scinput"  id="contacts"/></td>
							    </tr>
								<tr>
							    	<td>联系方式:</td><td>   <input name="input" type="text" class="scinput"  id="contactsType"/></td>
								</tr>
								<tr>
								     <td>机构编码:</td><td>   <input name="input" type="text" class="scinput"  id="orgCode"/></td>
								     <td><input type="hidden" id="oldOrgCode" /></td>
								</tr>
							</table>
     				</div>
			        <div class="tipbtn">
				        <input name="" type="button"  class="sure2" value="保存" />&nbsp;
				        <input name="" type="button"  class="cancel" value="取消" />
			        </div>
   	 			</div>
			</div>
		</div>
	</body>
</html>
