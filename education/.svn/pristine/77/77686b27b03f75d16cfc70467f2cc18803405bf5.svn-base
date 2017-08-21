<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>承培项目管理</title>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/editor/kindeditor.js">
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js">
		</script>
		<script type="text/javascript">
KE.show( {
	id : 'content7',
	cssPath : './index.css'
});
</script>

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
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/pagination.js">
		</script>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/common/dateFormat.js">
		</script>
		<script type="text/javascript"
			src="<%=basePathHeader%>/javascript/organization/orgProjectList.js">
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
		<div class="leftNav" style="background: #f0f9fd;">
			<%@include file="../common/projectLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">培训项目管理</a>
					</li>
					<li>
						<a href="#">项目管理</a>
					</li>
				</ul>
			</div>
			<div class="formbody">
				<div class="tabson">
					<ul class="seachform">
						<li>
							<label>
								项目名称：
							</label>
							<input id="projectName" name="input" type="text" class="scinput" />
						</li>
						<li>
							<label>
								项目年度：
							</label>
						</li>
						<li>
							<select  width="100px" id="beginDate" name="select" class="select2 yearpicker"></select>
						</li>
						<li>
							--
						</li>
						<li>
							<select width="100px" id="endDate" name="select" class="select2 yearpicker"></select>
						</li>
						<li>
							<input id="select" name="input2" type="button" class="dian3"
								value="查 询" />
						</li>
					</ul>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th width="20%">
								项目名称
							</th>
							<th width="10%">
								开始时间
							</th>
							<th width="10%">
								结束时间
							</th>
							<th width="10%">
								培训形式
							</th>
							<th width="10%">
								项目性质
							</th>
							<th width="10%">
								承培人数
							</th>
							<th width="10%">
								操作
							</th>
						</tr>
					</thead>
					<tbody id="orgProject_list">
					</tbody>
				</table>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
			</div>
		</div>
		
		
		
		<div id="tishi" class="tip" style="height:200px; margin-top: 150px;">
    	<div class="tiptop"><span id="orgName"></span><a></a></div>
			 <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td >培训平台首页地址：</td>
          <td  > <input id="trainingHomeAddress" name="input4" type="text" class="scinput" style="width:171px;"/></td>
        </tr>
        <tr>
          <td  >培训平台接口地址：</td>
          <td  > <input id="trainingAddress" name="input4" type="text" class="scinput" style="width:171px;"/></td>
        </tr>
      </table>
        <table width="230" style="margin:0 auto;">
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
        <tr>
		  <td width="130"><a id="sure" href="#none" class="sure dian3"/>确定</a></td>
          <td width="15">&nbsp;</td>
		  <td width="130"><a id="cancel" href="#none" class="sure dian3"/>取消</a></td>
		</tr>
        </table>
        <input id="projectId" type="hidden"/>
   		<input id="updateDate" type="hidden"/>
     </div>

		
	<div id="tishi_2" class="tip"  style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li>
					<center>
			  		<h4 id="label"></h4>
			  		</center>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn"  style="margin-top: -130px;">
        	<input name="" type="button"  class="sure" value="确定" onclick="ok()"/>&nbsp;
        </div>
     </div>	
		
		
	<div id="tishi_3" class="tip"  style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li >
			  		<h4 style="margin-left: 150px;">更改成功!</h4>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn"  style="margin-top: -130px;">
        	<input style="margin-left: 70px;" name="" type="button"  class="sure" value="确定" onclick="queding()"/>&nbsp;
        </div>
     </div>	
		
		
		
		
		
		
		
		
		
		
		<!-- 设置培训平台地址 --><%--
		<div class="tip" style="height: 200px; margin-top: 130px" >
		<div class="tiptop"><span>设置培训平台地址</span><a></a></div>
		<div class="tipinfo">
  		<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
     		<tr>
       			<td>培训地址：</td>
       			<td> <input id="trainingAddress" name="input4" type="text" class="scinput" style="width:300px;"/></td>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
     		</tr>
     		<tr>
       			<td>培训地址：</td>
       			<td> <input id="trainingAddress" name="input4" type="text" class="scinput" style="width:300px;"/></td>
     			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
     		</tr>
   		</table>
   		<input id="projectId" type="hidden"/>
   		<input id="updateDate" type="hidden"/>
   		</div>
   		<div class="tipbtn" style="margin-top: -120px">
        	<input id="sure" type="button" class="sure" value="确定" />&nbsp;&nbsp;
        	<input id="cancel" type="button"  class="cancel" value="取消" />
        </div>
	</div>
--%></body>
</html>
