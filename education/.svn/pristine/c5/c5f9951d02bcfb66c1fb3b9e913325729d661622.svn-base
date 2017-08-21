<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训成绩修改</title>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select2").uedSelect({
			width : 167
		});
	});
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgScorePublish.js"></script>
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
				<li><a href="#">培训项目</a></li>
				<li><a href="#">培训成绩修改</a></li>
			</ul>
		</div>
		<!-- <div class="place">
			<p style="padding:0 20px;color:#39C">操作提示:成绩确定公布后标志项目真正结束.1.查看导入的成绩.2.成绩修改,可批量可单个修改.3.公布成绩
			</p>
			<p style="padding:0 20px;color:#39C">公布规则:1.公布分数2.按合格不合格公布,设置合格分数.3.按等级公布,优良中差,设置各级分数.4.获得学时的最低学分设置</p>
		</div> -->


		<div class="formbody">

			<div id="usual1" class="usual">

				<!-- <div class="itab">
					<ul>
						<li><a href="#tab1" id="tabPage0" class="selected">未公布成绩<span
								class="ctype"></span> </a></li>
						<li><a href="#tab2" id="tabPage1">已公布成绩<span class="ctype"></span> </a></li>

					</ul>
				</div> -->
				<div class="tabson">
					<ul class="seachform">
						<li><label>项目名称：</label> <input id="projectName" name="input"
							type="text" class="scinput" /></li>
						<li><label>项目年度：</label></li>
						<li><select id="projectYear" name="select"
							class="select2 yearpicker" width="110px;">
								<option value="">请选择...</option> 
							</select></li>
						<!-- <li><label>培训类型：</label></li>
						<li><select id="trainType" name="select" class="select2" width="110px;"><option  value="1">远程</option><option value="2">面授</option><option value="3">混合（集中面授+远程）</option>
						</select></li> -->

						<li><input id="select" name="input2" type="button"
							class="dian3" value="查 询"  style="width:80px;"/></li>
					</ul>
				</div>
				<div id="tab1" class="tabson">
					<table class="tablelist">
						<thead>
							<tr>
								<th>项目名称</th>
								<!-- <th>项目状态</th> -->
								<th>培训形式</th>
								<th>创建人</th>
								<th>实施机构</th>
								<th>申报人</th>
								<th>计划人数</th>
								<th>报名人数</th>
								<th>学习人数</th>
								<th>审核人</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="target">

						</tbody>
					</table>
				</div>
				</div>
				<!-- 分页 -->
				<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
				<div id="pagebar" class="pagin"></div>
				<!-- 分页 -->
				
	<div class="tip">
    	<div class="tiptop"><span>项目名称：<label id="lblProjectName"></label></span></div>
    	<div style="text-align:center;width: 186px;height: 26px;padding-left:150px;padding-top:25px;">
	    	<p><!-- xmTool -->
	    		<input id="modifyScore" type="radio" name="modifyGroup" onclick="showScoreModifyInfo();"/>修改培训成绩&nbsp;&nbsp;
		    	<input id="modifyPeriod" type="radio" name="modifyGroup" onclick="showPeriodModifyInfo();"/>修改培训学时
	    	</p>
    	</div>
    	<div class="scoreTip" style="display:block;">  
		 <p><b>&nbsp;&nbsp;&nbsp;&nbsp; 指定范围内的成绩统一修改： 在原成绩上加多少分、减多少分、修改为多少分。</b> </p>  
	     <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
	 		<tr>
	          <td>
				 成绩范围：<input id="txtScoreStart" type="text" class="scinput"   value="" style="width:60px;margin:0 6px;"/>到<input id="txtScoreEnd" type="text" class="scinput"   value="" style="width:60px;margin:0 6px;"/>分 
	         </td>
	        </tr>
			<tr>
		       <td>
					<input id="rdoAdd" type="radio" value="add" name="scoreGroup" style="margin-right:6px;"/>
					<strong>加</strong>
					<input id="txtAdd" type="text" class="scinput"   value="" style="width:60px;margin:0 6px;"/>分 
				</td>
		     </tr> 
		<tr>
          <td  >
			<input id="rdoSub" value="sub" type="radio" name="scoreGroup" style="margin-right:6px;"/>
			<strong>减</strong>
			<input id="txtSub" type="text" class="scinput"   value="" style="width:60px;margin:0 6px;"/>分 
			</td>
        </tr> 
		<tr>
          <td  >
			<input id="rdoGive" value="give" type="radio" name="scoreGroup" style="margin-right:6px;"/>
			<strong>设为</strong>
			<input id="txtGive" type="text" class="scinput"   value="" style="width:60px;margin:0 6px;"/>分 
			</td>
        </tr> 
		</table>
	</div>
	<div class="periodTip" style="display:none; padding-left:150px;margin-bottom: 15px;">  
		<p style="margin-bottom: 6px;"><b><font color='red'>对成绩公布规则：直接公布方式有效！</font></b></p>
		培训学时修改为:<input type='text' id="givePeriod" class='scinput' style='margin-left:10px;width: 80px;'/> 学时
	</div>
        <table width="230" style="margin:0 auto;margin-bottom: 15px;">
        	<tr>
			  <td width="130"><a id="batchModify" href="#" class="sure dian3"/>批量修改</a></td>
                    <td width="15">&nbsp;</td>
			  <td width="130"><a href="#" id="cancelModify" class="sure dian3"/>取消</a></td>
			</tr>
        </table>
        </div>
     </div>
				<!-- 页面隐藏域 -->
				<input id="isScorePublished" value="0" type="hidden" name="isScorePublished" />
				<input id="txtProjectId"  type="hidden"  />
				<!-- 页面隐藏域 -->

				<script type="text/javascript">
					$('.tablelist tbody tr:odd').addClass('odd');
				</script>
			</div>

		</div>
	</div>

	<iframe id="downIframe" 　src="" frameborder=0 scrolling=no
		marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
</body>
</html>
