<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		 <link rel="stylesheet" href="<%=basePathHeader%>/javascript/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>参训教师管理</title>
		<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>

		<script type="text/javascript">
			var projectId = '<%=request.getParameter("projectId")%>';
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/paginationChaxunbming.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ztree/js/jquery.ztree.all-3.5.min.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/auditChaxunbaomingtongguo.js"></script>
	</head>
	<body>
		<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="project" name="flag"/>
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
						<a href="#">项目管理</a>
					</li>
					<li>
						<a href="#">教师报名审核</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label id="projectName">项目名称：</label>
						</li>
					</ul>
        	 <div style="width:30%; float:left;">
				<div style="width:180px; float:left;">
				 <ul id="treeDemo2" class="ztree"></ul>
				  
				   <ul id="treeDemo" class="ztree"></ul>
				   
					<span class="tabson">
						<div id="using_json"></div> </span>
				</div>

		</div>
<div style="width:100%; float:left;">	
<div class="chauxnJS jsTool">
          <span style="float:left;">
              <a href='###' class='huibtn_a' onclick='auditChaxunbaoming(projectId);'>全部</a>
              <a href='###' class='huibtn_a' onclick='auditChaxunbaomingtongguo(projectId)'>未通过</a>
              <a href='###' class='huibtn_a' onclick='auditChaxunbaomingtongguogeqiu( projectId)'>通过</a>
  </div>
					<table class="tablelist">
						<thead>
							<tr>
								<th >姓名</th>
								<%--<th width="12%">身份证号</th>--%>
								<th >学科</th>
								<th >省</th>
								<th >市</th>
								<th  >县</th>
								<th >校</th>
								<th  >手机</th>
								<th >审核状态</th>
							</tr>
						</thead>
						<tbody id="teacher_list">
						</tbody>
					</table>
					<!-- 分页 -->
					<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
					<div id="pagebar" class="pagin"></div>
					<!-- 分页 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 	
<input id="commentId" type="hidden"/>	

			 <input type="radio" name="radio"  value="13" checked="checked"/>
    审核通过
		</div>
    </li>
     <li>
		<div class="vocation">
			 <input type="radio" name="radio" value="12" />
    审核不通过
		</div>
    </li>
    <li style="height:100%;"><label>审核意见：</label></li>
            <li><textarea id="auditMemo"  style="border:1px solid #ccc;-moz-border-radius: 5px; -webkit-border-radius: 5px;border-radius: 5px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc; width:452px;max-width:452px;height:160px; max-height:160px;"></textarea></li>
        </ul>
      </div>
      <div class="clear"></div>  
        <ul class="seachform" style="padding-top:80px;">
        <li style="padding-left:120px;"><label>&nbsp;</label></li>
        <li><input name="" type="button"  class="dian3 sure" value="保存" /></li>
        <li><input name="" type="button"  class="dian3 cancel" value="取消" /></li>
        </ul>
</div>
<div id="reasonMemo" class="tip">
<div class="tiptop"><span>审核意见</span></div>
      <div class="tipinfo">
			<span id="reason"></span>
      </div>
       <ul class="seachform" >
        <li style="padding-left:120px;"><label>&nbsp;</label></li>
        <li><input name="" type="button"  class="dian3 cancel" value="返回"  /></li>
        </ul>
</div>
 -->
<!-- 页面隐藏域 -->
<input id="txtSchoolType"  type="hidden"  />
<input id="txtAreaLevel" type="hidden"  />
<input id="txtAreaId" type="hidden"  />
<input id="areaId" type="hidden"/>
<!-- 页面隐藏域 -->
<%@include file="../common/commonAreaSelectForSchool.jsp" %>
	</body>
</html>
