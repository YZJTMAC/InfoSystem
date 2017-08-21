<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectValidate.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/setSignUpWay.js"></script>
  
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
    <li><a href="#">培训项目管理</a></li>
    <li><a href="#">报名方式设置</a></li>

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
      <table class="tablelist" >
        <thead>
          <tr>
            <th width="20%">项目名称</th>
            <th width="10%">培训人数</th>
            <th width="10%">报名方式</th>
            <th width="10%">操作</th>
          </tr>
        </thead>
        <tbody id="proList">
         
         
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
    	<div class="tiptop"><span>设置报名模式</span><a></a></div>
        
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin:0;">
       </div>
        <ul class="forminfo" style="padding:0; margin:0;">
		 <li>
		<div class="vocation">
			 <input type="radio" name="radio"  value="1" checked="checked"/>
    组织报名
		</div>
    </li>
     <li>
		<div class="vocation">
			 <input type="radio" name="radio" value="2" />
    自由报名
		</div>
    </li>
  
        </ul>
        
      </div>
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="保存" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
 
 


</body>

</html>
