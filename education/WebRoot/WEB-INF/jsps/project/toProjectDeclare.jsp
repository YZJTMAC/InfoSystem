<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>项目管理</title>

		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript">
			var status= <%=request.getParameter("status")%>
		</script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" 	src="<%=basePathHeader%>/javascript/project/new_projectDeclare.js"></script>
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
						<a href="ssadmin.html">培训项目</a>
					</li>

					<li>
						培训项目创建
					</li>
					<li>
						操作提示： 点击添加按钮可以创建新的培训项目，标红色*字符的选项为必填项。
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div id="usual1" class="usual">

					<%--<div class="itab">
						<ul>
							<li>
								<a onclick="change(1);" id="tab_1" href="#tab1" class="selected">待申报项目
								</a>
							</li>
							<li>
								<a onclick="change(2);" id="tab_2" href="#tab2">审批通过
								</a>
							</li>
							<li>
								<a onclick="change(3);" id="tab_3" href="#tab2">审批未通过
								</a>
							</li>
						</ul>
					</div>

					--%><div id="tab1" class="tabson">

						<div class="tabson">
							<ul class="seachform">
								<li>
									<label>
										项目名称：
									</label>
									<input name="input" type="text" class="scinput"
										id="projectName" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="beginDate">
											<option value="">请选择</option>
										</select>
										--
									</div>
								</li>
								<li>
									--
								</li>
								<li>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="endDate">
											<option value="">请选择</option>
										</select>
									</div>
								</li>


								<li>
									<a href="javascript:qryPro()" class="dian3" >查 询</a>
								</li>

							</ul>


						</div>

						<div class="chauxnJS jsTool">
							<span style="float: left;"> <a
								href="<%=basePathHeader%>/edupm/projectmanage/toAddProPage.htm?click=0"
								class="huibtn_a  " style="margin-left: 6px">添加</a>&nbsp; </span>
						</div>


						<table class="tablelist">
							<thead>
								<tr>
									<th width="20%">
										项目名称
									</th>
									<th width="8%">
										开始时间
									</th>
									<th width="8%">
										结束时间
									</th>
									<th width="8%">
										培训形式
									</th>
									<th width="8%">
										项目性质
									</th>

									<th width="5%">
										培训人数
									</th>
									<th width="8%">
										创建人
									</th>
									<th width="8%">
										实施机构
									</th>
									<th width="5%">
										继教信息
									</th>
									<th width="5%">
										项目状态
									</th>
									<th width="17%">
										操作
									</th>
								</tr>
							</thead>
							<tbody id="proList1">

							</tbody>
						</table>
						<!-- 分页 -->
					<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			        <input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			       <div id="pagebar" class="pagin">
						<!-- 分页 -->
					</div>
 <div id="tab2" class="tabson" style="display: none;">  
      <div class="tabson">
        <ul class="seachform">
       <li>
									<label>
										项目名称：
									</label>
									<input name="input" type="text" class="scinput"
										id="projectName2" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="beginDate2"></select>
										--
									</div>
								</li>
		  <li>--</li>
		   <li>
            <div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate2"></select>  
			 </div> 
          </li>
			
		 
           <li><a href="#" class="dian3" id="select_2">查 询</a></li>
           
        </ul>
		
	   
      </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>项目名称</th>
        <th>项目性质</th>
        <th>计划人数</th>
        <th>培训形式</th>
<th>申报人</th>
<th>申报时间</th>
        <th>审核状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="table_list_2">
        
    
        </tbody>
    </table>
    <!-- 分页 -->
	<div id="page_2"></div>
		<!-- 分页 -->
	</div>

<div id="tab3" class="tabson" style="display: none;">  
      <div class="tabson">
        <ul class="seachform">
       <li>
									<label>
										项目名称：
									</label>
									<input name="input" type="text" class="scinput"
										id="projectName3" />
								</li>
								<li>
									<label>
										项目年度：
									</label>
									<div class="vocation">
										<select class="select3 yearpicker" name="yearpicker" id="beginDate3"></select>
										--
									</div>
								</li>
		  <li>--</li>
		   <li>
            <div class="vocation">   <select  class="select3 yearpicker" name="yearpicker" id="endDate3"></select>  
			 </div> 
          </li>
			
		 
           <li><a href="#" class="dian3" id="select_3">查 询</a></li>
           
        </ul>
		
	   
      </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>项目名称</th>
        <th>项目性质</th>
        <th>计划人数</th>
        <th>培训形式</th>
<th>申报人</th>
<th>申报时间</th>
        <th>审核状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="table_list_3">
        
    
        </tbody>
    </table>
    <!-- 分页 -->
	<div id="page_3"></div>
		<!-- 分页 -->
	</div>



					<!--1.3.2 end-->
				</div>
			</div>
		</div>
<div id="confirm" class="tip"  style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li >
			  		<h4 style="margin-left: 120px;" id="confirmInfo">确定要申报此项目？</h4>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn"  style="margin-top: -130px;">
        	<input name="" type="button"  class="sure" value="确定" onclick="declare()"/>&nbsp;
        	<input style="margin-left: 60px;" name="" type="button"  class="sure" value="取消" onclick="hideConfirm()"/>&nbsp;
        </div>
</div>


<div id="alertDiv" class="tip"  style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li >
			  		<h4 style="margin-left: 120px;" id="alertInfo">申报成功，请等待审核</h4>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn"  style="margin-top: -130px;"> 
        	<input style="margin-left: 70px;"  type="button"  class="sure" value="确定" onclick="hideAlert();"/>&nbsp;
        </div>
</div>

<!-- 项目附件上传模态框 -->	
<div id="myModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="projectName2"></h3><label>培训项目申报模板上传</label>
  </div>
  <div class="modal-body">
    <form id="declareForm" enctype="multipart/form-data" method="post">
		<input id="projectId" name="projectId" type="hidden" value="" />
		<input id="projectName3" name="projectName" type="hidden" value="" />
		<input id="type" name="type" type="hidden" value="declareTemplate" />
		<table id="hasUpload" class="table table-hover table-condensed">
		</table>
		<table id="noUpload" class="table">
		</table>
	</form>
  </div>
  <div class="modal-footer">
  	<button class="btn btn-primary"  id="addFile" onclick="addMore()">增加文件</button>
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
  </div>
</div>
<!-- 项目附件上传模态框结束 -->	

	</body>

</html>

