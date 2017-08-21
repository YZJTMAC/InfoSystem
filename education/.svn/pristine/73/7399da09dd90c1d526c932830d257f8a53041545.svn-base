<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/commonHead.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>承培平台设置</title>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select2").uedSelect( {
				width : 167
			});
			$(".select3").uedSelect( {
				width : 100
			});
		});
	</script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
	<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/ssOrgProjectStatusList.js"></script>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp">
			<jsp:param value="project" name="flag"/>
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
					<a href="#">培训项目</a>
				</li>
				<li>
					<a href="#">承培平台设置</a>
				</li>
			</ul>
		</div>
		<div class="place"><p style="padding:0 20px;color:#39C">操作提示:项目状态设置: 暂停,继续 <br/>&nbsp;&nbsp;&nbsp;&nbsp;</p></div>
		
		<div class="formbody">
			<div class="tabson">
				<ul class="seachform">
					<li>
						<label>项目名称：</label>
						<input id="projectName" name="input" type="text" class="scinput" />
					</li>
					<li>
						<label>项目年度：</label>
					</li>
					<li>
						<select width="100px" id="beginDate" name="select" class="select2 yearpicker">
							<option value="">请选择</option>
						</select>
					</li>
					<li>
						--
					</li>
					<li>
						<select width="100px" id="endDate" name="select" class="select2 yearpicker">
							<option value="">请选择</option>
						</select>
					</li>
					<li>
						<input id="select" name="input2" type="button" class="dian3" value="查 询" />
					</li>
				</ul>
			</div>
			<table class="tablelist">
				<thead>
					<tr>
						<th width="20%">项目名称</th>
			            <th width="8%">开始时间</th>
			            <th width="8%">结束时间</th>
			            <th width="7%">培训形式</th>
			            <th width="7%">培训类型</th>
			            <th width="5%">承培人数</th>
			            <!-- <th width="5%">创建人</th> -->
			            <th width="5%">申报人</th>
			            <th width="10%">实施机构</th>
			            <th width="5%">审核人</th>
						<th width="5%">项目状态</th>
						<th width="5%">我的状态</th>
			            <th width="10%">操作</th>
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
	
	<!-- 提示信息 -->
	<div id="tishi1" class="tip" style="height: 200px; margin-top: 200px;">
    	<div class="tiptop"><span>提示信息</span></div>
		<div class="tipinfo">
      	<div class="tipright" style="padding:0; margin:0;"></div>
        	<ul class="forminfo" style="padding:0; margin:0;">
				<li>
					<center>
			  		<label style="width:200px;"><h4>是否变更项目状态？</h4></label>
			  		</center>
			  	</li>
		    </ul>
		</div>
		<div class="tipbtn" style="margin-top: -130px;">
        	<input name="" type="button"  class="sure" value="确定" onclick="surew()"/>&nbsp;
        	<input name="" type="button"  class="cancel" value="取消" onclick="cancel()"/>
        </div>
        <input id="projectId" type="hidden"/>
		<input id="oldStatus" type="hidden"/>
		<input id="statu" type="hidden"/>
     </div>
     
     <!-- 培训平台对接地址设置 -->
     <div id="tishi" class="tip" style="height:300px; margin-top: 150px;">
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
       <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td colspan="2"><font color="red">培训平台接口示例：http://www.xxxxx/xxxx?PID=155</font></td>
        </tr>
         <tr>
          <td colspan="2"><font color="red">PID：是培训学习平台中项目的ID</font></td>
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
   		<!-- <input id="updateDate" type="hidden"/>
   		<input id="optionFlag" type="hidden"/> -->
   		
     </div>
</body>
</html>
