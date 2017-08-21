<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>设置兑换规则</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"> </script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/exchangePeriodToCredit.js"> </script>
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
						<label>
							<font style="color: red">*</font>项目名称：
						</label>
						<div class="vocation" >
		        			<input type="text" id="projectName" class="scinput" />
						</div>
					</li>
		       		<li>
						<label>
							<font style="color: red">*</font>项目年度：
						</label>
						<div class="vocation" >
		        			<select name="select" class="select3 yearpicker" id="year" ></select>
						</div>
					</li>
				  	<li><label>继教信息板块：</label>
						<div class="vocation">
							<select id="modelId" name="modelId" class="select3"></select>
						</div>
					</li>
					<li><label>培训形式：</label>
						<div class="vocation">
							<select id="formId" name="formId" class="select3"></select>
						</div>
					</li>
				</ul>
				<ul class="seachform">
					<li><label>项目性质：</label>
						<div class="vocation">
							<select id="scopeId" name="scopeId" class="select3"></select>
						</div>
					</li>
					<li><label>培训类型：</label>
						<div class="vocation">
							<select id="propertyId" name="propertyId" class="select3"></select>
						</div>
					</li>
				  <li><a href="javascript:queryList(1);" class="dian3">查 询</a></li>
		        </ul>
	      	</div>
			<div class="chauxnJS jsTool">
				<span style="float: left;">
					 <a href="javascript:void(0);" class="huibtn_a click" style="margin-left: 6px" id="btnAdd2" onclick="setAllRule(1);">全部设置</a>
					 <a href="javascript:void(0);" class="huibtn_a click" style="margin-left: 6px" id="btnAdd2" onclick="setAllRule(2);">批量设置</a>
					 <a href="javascript:void(0);" class="huibtn_a click" style="margin-left: 6px" id="btnAdd2" onclick="queryList(2);">未设置</a>
				</span>
			</div>
			<table class="tablelist">
					<thead>
						<tr>
							<th>
								<input id="chk_all" type="checkbox"/>
							</th>
							<th  >项目名称</th>
							<th  >继教板块</th>
						 	<th  >培训形式</th>
	                        <th  >项目性质</th>
							<th  >培训类型</th>
							<th  >学时</th>
							<th  >全员兑换规则</th>
							<th  >优秀学员兑换规则</th>
							<th  >操作</th>
							
						</tr>
					</thead>
					<tbody id="proList">
					</tbody>
				</table> 
	
	      		<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="20" name="sizePerPage" />
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
					<span style="width:100px;height:25px;padding-top:5px;"><input type="radio" name="exchangeWay" value="1" onclick="showExchangeRule(3);" checked="checked"/>学时兑换学分</span>
					<span style="width:110px;height:25px;padding-top:5px;"><input type="radio" name="exchangeWay" value="2" onclick="showExchangeRule(4);"/>学分兑换学时</span>
				</li>
				<li>
					<span style="width:100px;height:25px;padding-top:5px;"><input type="radio" name="rule" value="1" checked="checked"/>全员兑换规则</span>
					<span style="width:110px;height:25px;padding-top:5px;"><input type="radio" name="rule" value="2" />优秀学员兑换规则</span>
				</li>
				<li id="periodRule">
					<div class="vocation">
						兑换规则: 1学时=<input name="" type="text" class="scinput period" id="preiodExchangeRule" />学分
					</div>
				</li>
				<li id="creditRule" style="display:none;">
					<div class="vocation">
						兑换规则: 1学分=<input name="" type="text" class="scinput period" id="creditExchangeRule" />学时
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