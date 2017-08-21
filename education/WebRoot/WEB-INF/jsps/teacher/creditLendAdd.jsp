<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学分借贷添加</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/creditLendAdd.js"></script>
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
		    	<li><a href="#">学分借贷</a></li>
		    	<li><a href="#">借贷学分</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div class="tabson">
    			<ul class="seachform" >
		        	<li id="lendYearInsert" >
						<label>
							<font style="color: red">*</font>借贷年度：
						</label>
						<div class="vocation" >
		        			<select name="select" class="select2 yearpicker" id="yearInsert" >
<!-- 		        			<select name="select" class="select2 yearpicker" id="yearInsert" disabled="disabled"> -->
							</select>
						</div>
						&nbsp;&nbsp;
						<font color="red">只能选择本年度 </font>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li id= "lendReasonInsert">
						<label>
							<font style="color: red">*</font>借贷原因：
						</label>
						<div class="vocation">
		        			<select name="select" class="select2" id="reasonInsert"></select>
		        		</div>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li id= "lendFormInsert">
						<label>
							<font style="color: red">*</font>培训形式：
						</label>
						<div class="vocation">
		        			<select name="select" class="select2" id="lendForm" ></select>
		        		</div>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>借贷学分：
						</label>
						<div class="vocation">
		        			<input name="input" type="text" class="scinput"  id="lendCredit" />
		        		</div>
						<a id="lendCreditError" style="color: red"></a>
					</li>
	        	</ul>
	        	<ul class="seachform" ></ul>
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
	</div>
</body>
</html>
