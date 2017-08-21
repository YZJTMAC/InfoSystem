<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>问卷调查汇总</title>
		<%@include file="../common/commonHead.jsp"%>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
		<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
		<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/toQuestionSurverSummary.js"></script>
	</head>
<script type="text/javascript">
	lastSelect = '${areaId}_${areaType}_${areaName}';
	$(function(){
		$(".select1").uedSelect({
			width : 200			  
		});
		$(".select2").uedSelect({
			width : 80  
		});
		$(".select3").uedSelect({
			width : 100
		});
		
		$("#hide").click(function(){
	  		$("p").hide();
	    });
	    $("#show").click(function(){
	  		$("p").show();
	    });
	});
</script>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp" >
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
						<a href="#">培训项目</a>
					</li>
					<li>
						问卷调查汇总
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label>
								继教板块：
							</label>
							<div class="vocation">
								<select  class="select1" name="eduModelType" id="eduModelType" onchange="initEduProject()">
								</select>
							</div>
						</li>
						<li>
							<label>
								培训项目：
							</label>
							<div class="vocation">
								<select  class="select1" name="eduProject" id="eduProject">
								
								</select>
							</div>
						</li>
					</ul>
					<ul class="seachform">
						<li>
							<label>
								地区学校：
							</label>
							<div class="vocation">
									<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
									<input type="hidden" id="areaId" />
									<input type="hidden" id="areaType" />
									<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
							</div>
						</li>
<!-- 						<li> -->
<!-- 							<label> -->
<!-- 								学科学段： -->
<!-- 							</label> -->
<!-- 							<div class="vocation"> -->
<!-- 								<input name="subject" class="scinput" readonly="readonly" /> -->
<!-- 	      					    <input name="input2" type="button" value="选 择" class="btnXuan" onclick="showS();"/> -->
<!-- 							</div> -->
<!-- 						</li> -->
						<li>
							<label>
								性别 ：
							</label>
							<div class="vocation">
								<select  class="select2" name="gender" id="gender">
									<option value="">请选择</option>
									<option value="1">男</option>
									<option value="0">女</option>
								</select>
							</div>
						</li>
					</ul>
					<ul class="seachform">
						<li>
							<label>
								年龄段：
							</label>
						</li>
						<li>
								<select  class="select2" name="beginDate" id="beginDate">
									<option value="">请选择</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="50">50</option>
									<option value="60">60</option>
									<option value="70">70</option>
									<option value="80">80</option>
								</select>
						</li>
						<li>--</li>
						<li>	
								<select  class="select2" name="endDate" id="endDate">
									<option value="">请选择</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="50">50</option>
									<option value="60">60</option>
									<option value="70">70</option>
									<option value="80">80</option>
								</select>
						</li>
					</ul>
					
					<ul>
						<li>
							<input type="button" onClick="showInfoList();" class="scbtn"
								value="查 询" />
						</li>
					</ul>
				</div>
				
				<table class="tablelist">
					<div class="chauxnJS jsTool" id="totalNum"><br/>
				    </div>
					<thead>
						<tr>
							<th style="width:40%">
								问题题目
							</th>
							<th style="width:20%">
								答案选项
							</th>
							<th style="width:20%">
								答案汇总
							</th>
							<th style="width:20%">
								占比
							</th>
							
						</tr>
					</thead>

					<tbody id="targetList"></tbody>

				</table>

				<!-- 分页 -->
				<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin">
				</div>
				<!-- 分页 -->
				<!-- 区域选择 -->
   				<%@include file="../common/commonAreaSelect.jsp"%>
			</div>
		</div>   
		
		<!-- 选择学段学科 -->    
		<div class="tip" id="XDXKshow" style="display:none;width: 600px;height: 750px;top:100px">
	    	<div class="tiptop"><span>选择学段/学科</span><a href="javascript:hideMe();"></a></div>
	    	<div style="position: absolute;margin-left: 20px;width: 570px;margin-top: 2%">
	   		 已选：
	    		<ol class="xuanDQ">
				    <li id="hasSelected"></li>
				    <li style="float:right;margin-top: 45%"></li>
				</ol>
	 		</div>
	    
	      	<div style="width: 100px;position: absolute;margin-top: 40%;margin-left: 20px;width: 90%">
	      	学段：
	        	<table style="width:100%;margin-top: 20px">
	        		<tbody id="section">
	      			</tbody>
	        	</table>
	      	</div>
	      
	      	<div style="margin-left: 20px;position: absolute;margin-top: 60%;width: 560px;background-color:#E5E5E5;height: 40%" >
	      		<table  style="width: 100%;margin-top: 10px;" cellpadding="0" cellspacing="0">
	      		<input type="hidden" name="subjectId">
	      		<input type="hidden" name="subjectName">
		      		<tbody id="subject">
			      		<div id="showCheck" style="display:none">
			      			<input type="checkbox" id="isAll" onclick='selectAllSub()'>全选/全不选&nbsp;&nbsp;&nbsp;
		      			</div>
	      			</tbody>
	      			</table>
	      		<div style="position:absolute; left:40%; bottom:-40px;"><input class="sure" type="button" onclick="lastSure();" value="确定"/></div>
			</div>
  		</div>
	</body>
</html>
