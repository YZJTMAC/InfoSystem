<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自主研修添加</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toSpecialCaseAdd.js"></script>
<style>
	table,table tr th, table tr td { border:1px solid #000000;  text-align: center;}
</style>
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
		    	<li><a href="#">特殊研修申报</a></li>
		    	<li><a href="#">特殊申请</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div >
    			<ul class="seachform" >
		        	<li id="lendYearInsert" >
						<label>
							<font style="color: red">*</font>申请年度：
						</label>
						<div class="vocation" >
		        			<select name="select" class="select2 yearpicker" id="yearInsert" >
							</select>
						</div>
						&nbsp;&nbsp;
						<font color="red">只能选择本年度 </font>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li id= "lendReasonInsert">
						<label>
							<font style="color: red">*</font>申请类型：
						</label>
						<div class="vocation">
		        			<select name="select" class="select2" id="specialCase" onchange="showUp()"></select>
		        		</div>
					</li>
	        	</ul>
	        	<!-- 周期内退休 -->
	        	<div style="display: none;" id="aBox">
	        	<ul class="seachform" >
	        		<li>
	        		在本周期内法定退休人员，“网络研修”可以免修，并按每年６分记录。
					</li>
				</ul>
	        	</div>
	        	<!-- 孕期 -->
	        	<div style="display: none;" id="bBox">
	        	<ul class="seachform" >
	        		<li>
	        		孕期女教师，当年的“集中研修”可以免修，并按6分记录；孕期跨年度的，可由教师本人任选一年记录。
					</li>
				</ul>
	        	</div>
	        	<!-- 哺乳期 -->
	        	<div style="display: none;" id="cBox">
	        	<ul class="seachform" >
	        		<li>
	        		哺乳期女教师，当年的“集中研修”，另加3分记录。哺乳期跨年度的，可由教师本人任选一年记录。
					</li>
				</ul>
	        	</div>
	        	<!-- 局直事业单位 -->
	        	<div style="display: none;" id="dBox">
	        	<ul class="seachform" >
	        		<li>
	        		局直事业单位人员，“校本研修”可以免修，并按每年８学分记录。
					</li>
				</ul>
	        	</div>
	        	<form action="" id="proForm" enctype="multipart/form-data" method="post">
					<input type="hidden" name = "projectId"/>	        
					<input type="hidden" name = "trainFormName"/>	        
					<input type="hidden" name = "teacherClassScore"/>	    
					<input type="hidden" name = "createDate1"/>	        		
					<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;width: 500px">
		        		<tbody id="files">
							<tr>
								<td width="84" colspan="2" ><b>上传附件：</b>【支持上传图片，文本文件，OFFICE 文档，压缩包等】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:addMore()">添加</a></td>
							</tr>
		        			<tr>
		          				<td width="260" colspan="2"><input type="file" name="file"/><a href="###" onclick="removeMe(this)">删除</a></td>
		 					</tr>
		        		</tbody>
		      		</table>
	      		</form>
	      		<ul class="seachform" >
		        	<li>
		        	</li>
		        </ul>
	        	<ul class="seachform" >
		        	<li>
		        		<input  id="apply_credit" type="button"  class="sure" value="申请"  onclick="insert()" />&nbsp;
		        	</li>
		        	<li>
		        		<input  type="button"  class="cancel" value="取消" onclick="javascript:window.history.back();"/>
		        	</li>
		        </ul>
		</div>
	</div>
	
</body>
</html>
