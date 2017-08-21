<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师信息管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<link href="<%=basePathHeader%>/style/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
  
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
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/teacherLeft.jsp"%>
	</div>
	
 <div class="content">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>教师信息</li>
    <li>教师信息管理</li>
    <li>导入历史记录</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
 
      
      
      <div class="tabson">   
 
<ul class="seachform" style="padding-left:23px;display:none;">
    
    <li><label>操作年度：</label>  
    <div class="vocation">
    <select class="select3">
    <option>2014年</option>
    <option>2013年</option>
    </select>
    </div>
    </li>
    <li><label>操作时间：</label>  
    <div class="vocation">
    <select class="select1">
    <option>2014年2月20日 16点30分</option>
    <option>2014年2月10日 10点30分</option>
    <option>2014年1月20日 12点30分</option>
    <option>2014年1月10日 9点30分</option>
    </select>
    </div>
    </li>
    
    
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="查 询"/></li>
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="返 回"/></li>
    
    </ul>
    
   </div>
   
    
    
    
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="批量导入" onclick="window.location='teacherGLY_1.1.6.html'"/></li>
 
   <div class="chauxnJS jsTool" >
    <span style="float:left;"></span>
    <span style="float:right;">
    <div class="pagin" style="margin:0; width:180px;">
    <div class="message">共<i class="blue">1256</i>条记录</div>
    <div class="vocation paginList" style=" margin:4px 6px 0 6px;right:0px;">
    <select class="select3">
    <option>每页显示10条</option>
    <option>每页显示30条</option>
    <option>每页显示50条</option></select>
    </div>
    
    </div>
    </span>
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="7%">年度</th>
        <th width="10%">操作时间</th>
        <th width="10%">操作人</th>
        <th width="15%">操作人所在地区</th>
        <th width="5%">导入记录数</th>
        <th width="7%">操作</th>
        </tr>
        </thead>
        <tbody>
        
        <tr>
        <td>2014年</td>
        <td>2014-10-11 10:30</td>
        <td>张三</td>
        <td>广东省 广州市 天河区</td>
        <td>&nbsp;1234</td>
        <td>&nbsp;<a href="teacherGLY_1.1.10.html" style="margin-right:8px;">查看导入记录</a></td>
        </tr>
        
        <tr>
        <td>2014年</td>
        <td>2014-10-11 11:30</td>
        <td>李四</td>
        <td>广东省 广州市</td>
        <td>12346</td>
        <td>&nbsp;<a href="teacherGLY_1.1.10.html" style="margin-right:8px;">查看导入记录</a></td>
        </tr>
    
        </tbody>
    </table>
    
    <div class="pagin">
<div class="message">共<i class="blue">296</i>条记录 每页 30 条，当前第&nbsp;<i class="blue">2&nbsp;</i>页 / 共&nbsp;<i class="blue">10</i>&nbsp;页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;">首页</a></li>
        <li class="paginItem"><a href="javascript:;" class="longer">上一页</a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem current"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem"><a href="javascript:;">6</a></li>
        <li class="paginItem"><a href="javascript:;">7</a></li><!--
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>-->
        <li class="paginItem"><a href="javascript:;" class="longer">下一页</a></li>
        <li class="paginItem"><a href="javascript:;">末页</a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>年度考核修改</span><a></a></div>
        
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin:0;">
        <p>2014年度
        <cite>北京市 海淀区 知春路</cite></p>
        </div>
        <ul class="forminfo" style="padding:0; margin:0;">
    <li><label style="width:60px;">国培</label>  
    <input name="" type="text" class="scinput" />
    </li>
    <li><label style="width:60px;">省培</label>  
    <input name="" type="text" class="scinput" />
    </li>
    <li><label style="width:60px;">省培</label>  
    <input name="" type="text" class="scinput" />
    </li>
    <li><label style="width:60px;">校本</label>  
    <input name="" type="text" class="scinput" />
    </li>
    </ul>
        
        
      </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="保存" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    </div> 
 
 </div>
 
</body>
</html>