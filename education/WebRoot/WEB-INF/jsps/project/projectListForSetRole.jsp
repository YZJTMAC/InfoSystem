<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>设置兑换规则</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"> </script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/modelListForSetExchangeRole.js"> </script>
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
			    <li><a href="#">学分兑换规则设置</a></li>
		    </ul>
	    </div>
	    
	    <div class="formbody">
	    	<div class="tabson">
		       	<ul class="seachform">
				  <li>
				            <label>继教板块名称：</label>
				            <input name="input" type="text" class="scinput" id="modelName"/>
				          </li>
				  <li><a href="javascript:queryModel();" class="dian3">查 询</a></li>
		        </ul>
	      	</div>
	
			<table class="tablelist">
					<thead>
						<tr>
							<th  >继教信息板块名称</th>
						 
							<th  >计划周期</th>
						 	<th  >开始日期</th>
	                        <th  >结束日期</th>
							<th  >计划学分</th>
							<th  >全员兑换规则</th>
							<th  >优秀学员兑换规则</th>
							<th  >操作</th>
							
						</tr>
					</thead>
					<tbody id="modelList">
					</tbody>
				</table> 
	
	      		<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
		</div>
	</div>
	
	<div class="tip">
		<div class="tiptop">
			<span>学分兑换规则设置</span><a href="javascript:hideMe();"></a>
		</div>

		<div class="tipinfo" style="height:100px;">
			<div class="tipright" style="padding:0; margin:0;"></div>
			<ul class="forminfo" style="padding:0; margin:0;">
				<li>
					<div class="vocation" id="tss"></div>
				</li>
				<li>
					<span style="width:100px;height:25px;padding-top:5px;"><input type="radio" name="rule" value="1" onclick="showExchangeRule(1);" checked="checked"/>全员兑换规则</span>
					<span style="width:110px;height:25px;padding-top:5px;"><input type="radio" name="rule" value="2" onclick="showExchangeRule(2);"/>优秀学员兑换规则</span>
				</li>
				<li id="commonRule">
					<div class="vocation">
						兑换规则: 1学分=<input name="" type="text" class="scinput period" id="commonPeriod" />学时
					</div>
				</li>
				<li id="excellentRule" style="display:none;">
					<div class="vocation">
						兑换规则: 1学分=<input name="" type="text" class="scinput period" id="excellentPeriod" />学时
					</div>
				</li>
				<li><b id="msg"></b></li>
			</ul>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="保存" onclick="setRole();" />&nbsp; 
			<input name="" type="button" class="cancel" value="取消" onclick="hideMe();" />
		</div>
	</div> 
	
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
			<div class="progress progress-striped active" style="margin-bottom: 0;">
				<span style="font-size:22px;">规则设置中，请稍后. . .</span>
			</div>
		</div>
	 </div>   
</body>
</html>