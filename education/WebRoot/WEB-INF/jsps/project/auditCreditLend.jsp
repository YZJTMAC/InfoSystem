<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学分借贷审核</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/auditCreditLend.js"></script>
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
		    	<li><a href="#">继教信息</a></li>
		    	<li><a href="#">学分银行</a></li>
		    	<li><a href="#">学分借贷审核</a></li>
    		</ul>
    	</div>
    <div class="formbody">
    	<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li>
						<a onclick="projectList1();" id="tab_1" href="#tab1" class="selected">待审核
						</a>
					</li>
					<li>
						<a onclick="projectList2();" id="tab_2" href="#tab2">审核通过
						</a>
					</li>
					<li>
						<a onclick="projectList3();" id="tab_3" href="#tab3">审核未通过
						</a>
					</li>
					<li>
						<a onclick="projectList4();" id="tab_4" href="#tab4">已偿还
						</a>
					</li>
				</ul>
			</div>
					
        	<div id="tab1" class="tabson">
		       	<ul class="seachform">
					<li>
						<label>教师姓名：</label>
				        <input id="teacherName1" type="text" class="scinput" />
				    </li>
		  			<li><a onclick="projectList1()" href="#" class="dian3">查 询</a></li>
		        </ul>
      
      			<table class="tablelist">
      				<thead>
        				<tr>
			          		<th width="5%">教师姓名</th>
			          		<th width="20%">学校</th>
			          		<th width="20%">身份证</th>
			          		<th width="10%">借贷年份</th>
			          		<th width="10%">培训形式</th>
			          		<th width="10%">借贷原因</th>
			          		<th width="10%">借贷日期</th>
			          		<th width="5%">借贷学分</th>
			          		<th width="10%">操作</th>
        				</tr>
      				</thead>
      				<tbody id="proList1">
		
      				</tbody>
    			</table>
    		</div>
    		<!-- tab2 -->
    		<div id="tab2" class="tabson" style="display: none;">
		       	<ul class="seachform">
					<li>
						<label>教师姓名：</label>
				        <input id="teacherName2" type="text" class="scinput" />
				    </li>
		  			<li><a onclick="projectList2()" href="#" class="dian3">查 询</a></li>
		        </ul>
      
      			<table class="tablelist">
      				<thead>
        				<tr>
			          		<th width="5%">教师姓名</th>
			          		<th width="20%">学校</th>
			          		<th width="20%">身份证</th>
			          		<th width="10%">借贷年份</th>
			          		<th width="10%">培训形式</th>
			          		<th width="10%">借贷原因</th>
			          		<th width="10%">借贷日期</th>
			          		<th width="5%">借贷学分</th>
			          		<th width="10%">操作</th>
        				</tr>
      				</thead>
      				<tbody id="proList2">
		
      				</tbody>
    			</table>
    		</div>
    		<!-- tab3 -->
    		<div id="tab3" class="tabson" style="display: none;">
		       	<ul class="seachform">
					<li>
						<label>教师姓名：</label>
				        <input id="teacherName3" type="text" class="scinput" />
				    </li>
		  			<li><a onclick="projectList3()" href="#" class="dian3">查 询</a></li>
		        </ul>
      
      			<table class="tablelist">
      				<thead>
        				<tr>
			          		<th width="5%">教师姓名</th>
			          		<th width="20%">学校</th>
			          		<th width="20%">身份证</th>
			          		<th width="10%">借贷年份</th>
			          		<th width="10%">培训形式</th>
			          		<th width="10%">借贷原因</th>
			          		<th width="10%">借贷日期</th>
			          		<th width="5%">借贷学分</th>
			          		<th width="10%">操作</th>
        				</tr>
      				</thead>
      				<tbody id="proList3">
		
      				</tbody>
    			</table>
    		</div>
    		<!-- tab4 -->
    		<div id="tab4" class="tabson" style="display: none;">
		       	<ul class="seachform">
					<li>
						<label>教师姓名：</label>
				        <input id="teacherName4" type="text" class="scinput" />
				    </li>
		  			<li><a onclick="projectList4()" href="#" class="dian3">查 询</a></li>
		        </ul>
      
      			<table class="tablelist">
      				<thead>
        				<tr>
			          		<th width="5%">教师姓名</th>
			          		<th width="20%">学校</th>
			          		<th width="20%">身份证</th>
			          		<th width="10%">借贷年份</th>
			          		<th width="10%">培训形式</th>
			          		<th width="10%">借贷原因</th>
			          		<th width="10%">借贷日期</th>
			          		<th width="5%">借贷学分</th>
			          		<th width="10%">操作</th>
        				</tr>
      				</thead>
      				<tbody id="proList4">
		
      				</tbody>
    			</table>
    		</div>
    
    
    <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
	</div>
	
    <!-- 培训项目审核模态对话框开始-->	
	<div id="auditModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    	<h3 id="projectName10"></h3>
	  	</div>
	  	<div class="modal-body">
			<ul class="forminfo" style="padding:0; margin:0;">
				<li>
					<div class="vocation">
						审核状态: 
						<input type="radio" name="radio"  value="1" checked="checked"/>审核通过  
			    		<input type="radio" name="radio"  value="0" />审核不通过
					</div>
	    		</li>
	    		<li>
					<div class="vocation">
						审核意见: <textarea id="memo" cols="" rows="" class="textinput" style="width:260px; height:30px;"></textarea>
					</div>
		    	</li>
	        </ul>
	  	</div>
		<div class="modal-footer">
			<input  type="button"  class="sure" value="保存" onclick="audit()"/>&nbsp;
	    	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  	</div>
	</div>
	 <!-- 培训项目审核模态对话框结束 -->	
	 <!-- 审核意见对话框开始-->	
	<div id="auditReasonModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    	<h3 id="projectName9">审核意见</h3>
	  	</div>
	  	<div class="modal-body">
			<div id="reason"></div>
	  	</div>
	  	<div class="modal-footer">
	 		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  	</div>
	</div>
</div>
    <script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
</body>
</html>