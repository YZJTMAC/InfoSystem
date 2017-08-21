<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<link href="<%=basePathHeader%>/style/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherSummaryProjectList.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>
	<!-- top -->
	<div class="head">
	<jsp:include page="../common/top.jsp">
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
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">已结束的培训项目</a></li>

    </ul>
    </div>
    
    <div class="formbody">
    
    

      <div class="tabson">
       
<ul class="seachform">
  <li>
            <label>项目名称：</label>
            <input name="input" type="text" class="scinput"  id="projectName"/>
          </li>
         <li>
            <label>项目年度：</label>
            
          </li>
          <li>
          	 <select name="select" class="select2 yearpicker" id="beginDate">
          	</select>  
          </li>
          <li>--</li>
          <li>
           <select name="select" class="select2 yearpicker" id="endDate">
          </select>
          </li>
			 <li>
            <input name="input2" type="button" class="dian3" value="查 询" onclick="qryPro();"/>
          </li>
         </ul>
	 
		
      </div>
      
      <div class="chauxnJS jsTool">
					
						<span style="float: left;"> 
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>
								<div class="vocation paginList"
									style="margin: 4px 6px 0 6px; right: 0px;">
									<select onchange="projectList();" id="sizePerPage" class="select3">
										<option value="100">
											每页显示100条
										</option>
									
										<option value="300">
											每页显示300条
										</option>
										<option value="500">
											每页显示500条
										</option>
									</select>
								</div>

							</div> </span>
					</div>
      <table class="tablelist" >
        <thead>
          <tr>
            <th width="20%">项目名称</th>
            <th width="10%">开始时间</th>
            <th width="10%">结束时间</th>
            <th width="10%">培训形式</th>
            <th width="10%">项目性质</th>
            <th width="10%">成绩</th>
            <th width="10%">状态</th>
            <th width="10%">操作</th>
          </tr>
        </thead>
        <tbody id="proOverList">
         
         
        </tbody>
      </table>
      <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
    </div> 
	</div>
	
 
    <div class="tip" style="height:500px;">
    	<div class="tiptop"><span><d class="ctype"></d>我的培训总结</span><span>&nbsp;&nbsp;</span><a></a></div>
        
      <div class="tipinfo" style="width:470px; height:360px;padding:10px; margin:0;">
        <ul class="forminfo" style="padding:0; margin:0;">
		  <li><label>标题：</label><cite><input id="summaryTitle" name="summaryTitle" type="text" class="scinput" value="" /></cite></li>
		<li><label><d class="ctype"></d>总结：</label>
		<div class="vocation" style="padding-right:8px;">
			<textarea id="summaryContent" name="summaryContent" cols="" rows="" class="textinput" style="width:260px; height:270px;"></textarea></div></li>
		  <li><label>附件：</label><cite><a id="download" href="#"></a></cite></li>
		</ul>
      </div>
      <div class="tipbtn">
		<span class="sl-custom-file"> 
			<input id="summaryId" type="hidden" class="btn" value="" />
			<input id="pid" type="hidden" class="btn" value="" />
			<input name="attchment" type="button" class="btn" value="上传附件" />
			<input id="attchmentPath" onchange="check();" type="file" name="attchmentPath" class="ui-input-file"/>&nbsp;&nbsp; 
		</span>
		<input name="" type="button"  class="sure" value="保存" />	
       </div>
    </div>


</body>

</html>
