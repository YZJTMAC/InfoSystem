<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师年度考核</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
	var queryYear = '${year}';
	var qid= '${provinceId}';
	var qname= '${provinceName}';
	var qperiod = 0;
	var qscore = 0;
	
	var cid= '${cityId}';
	var cname= '${cityName}';
	var cperiod = 0;
	var cscore = 0;
	
	var did= '${districtId}';
	var dname= '${districtName}';
	var dperiod = 0;
	var dscore = 0;
	
	var sid= '${schoolId}';
	var sname= '${schoolName}';
	var speriod = 0;
	var sscore = 0;
	
	$(document).ready(function(e) {
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/eduManageAuditByYear.js"></script>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="furtheredu" name="flag"/>
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
    <li><a href="jixuMegGLY_2.2.html">继教信息</a></li>
    <li>教师考核查询</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    

      
      
      <div class="tabson">   
<!--<ul class="forminfo">
    <li><label>项目性质：</label><cite><input name="" type="radio" value="" checked="checked" />国培&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />省培&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />市培&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />校本</cite></li>
    
    </ul>-->

<ul class="seachform" style="padding-left:23px;">
    
    <li><label>培训年度：</label>  
    <div class="vocation">
    <select id="queryYear" class="select3 yearpicker">
    	<option value="">请选择</option>
    </select>
    </div>
    </li>
    <li><label>地区：</label>  
    <div class="vocation">
	<input id="areaName"　name="" readonly="readonly" type="text"  value="<%=request.getAttribute("areaName") %>" class="scinput areaSelect"/>
	<input type="hidden" id="areaId" type="text" value="<%=request.getAttribute("areaId") %>" />
	<input type="hidden" id="areaType" type="text" value="<%=request.getAttribute("areaType") %>"/>
	<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
							
    </div>
    </li>
    <li><label>教师姓名：</label>
    <div class="vocation">
    	<input type="text" id="queryRealName" class="dfinput"/>
    </select>
    </div></li>
    <li><label>&nbsp;</label><input type="button" class="scbtn" onClick="showInfoList();" value="查 询"/></li>
    
    </ul>      
   </div>
   
    <div class="kuang" style="width:auto;" id="yearTagrt">
	</div>
   <div class="chauxnJS jsTool">
    <span style="float:left;">
   </span>
    <span style="float:right;">
    <div class="pagin" style="margin:0; width:180px;">
    <div class="message">共<i class="blue"  id="totleCount">0</i>条记录</div>
    <div class="vocation paginList" style=" margin:4px 6px 0 6px;right:0px;">
    <select id="pageSize" class="select3">
   		<option value="100">每页显示100条</option>
    	<option value="300">每页显示300条</option>
    	<option value="500">每页显示500条</option>
    </select>
    </div>
    
    </div>
    </span>
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="25%">教师姓名</th>
        <th width="25%">身份证号</th>
        <th width="25%">年度合计</th>
        <th width="25%">达标情况</th>
        </tr>
        </thead>
        <tbody id="targetList">
        </tbody>
    </table>
    
 	<!-- 分页 -->
    <INPUT id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
	<INPUT id="pageIndex" value="1" type="hidden" name="pageIndex" />
	<div id="pagebar" class="pagin">	
	</div>
   <!-- 分页 --> 
    
        </div><br>
    </div> 
     <!-- 区域选择 -->
   <%@include file="../common/commonAreaSelect.jsp"%>  
   			<div class="tip0"
				style="width: 400px; height: 150px; top: 300px; left: 35%">
				<div class="tiptop">
					<span>提示信息</span>
				</div>
				<table style="width: 100%; height: 100%">
					<tr>
						<td align="center">
							<span id="msgHtml">发送成功！</span>
						</td>
					</tr>
					<tr>
						<td align="center" valign="top" style="height: 60%">
							<table style="width: 60%">
								<tr>
									<td align="center" id="toPage"></td>
									<td align="center">
										<input name="" id="toCancel" 
											type="button" onclick="closeTip();" class="cancel1" value="取消" />
									</td>
								</tr>
							</table>

						</td>
					</tr>
				</table>
			</div>
			
   <script type="text/javascript">
		lastSelect='${areaType}_${areaId}_${areaName}';
	</script>
	
</body>

</html>
