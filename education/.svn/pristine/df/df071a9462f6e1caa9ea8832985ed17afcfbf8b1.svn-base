<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师项目培训管理</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<link href="<%=basePathHeader%>/style/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProjectInfo.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  <script type="text/javascript">
	var projectId = '<%=request.getParameter("projectId")%>';
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
    <li><a href="#">项目管理</a></li>

    </ul>
    </div>
    
    <div class="formbody">
    
    
 
      <div class="tabson" id="txtBox">
      <h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目年度：</td>
          <td width="260" id="year"></td>
          <td width="60">&nbsp;</td>
          <td>项目编号：</td>
          <td width="260"  id="projectNo"></td>
        </tr>
        <tr>
          <td>项目名称：</td>
          <td id="projectName"></td>
          <td>&nbsp;</td>
          <td>项目开始时间：</td>
          <td id="startDate"></td>
        </tr>
        <tr>
          <td>项目结束时间：</td>
          <td id="endDate"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目内容：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目范围：</td>
          <td width="260" id="projectScopeName"></td>
          <td width="60">&nbsp;</td>
          <td width="84">培训范围：</td>
          <td width="260" id="trainScopeName"></td>
        </tr>
        <tr>
          <td>项目性质：</td>
          <td id="projectPropertyName"></td>
          <td>&nbsp;</td>
          <td>培训类型：</td>
          <td id="trainTypeName"></td>
        </tr>
      </table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目培训对象：</h4>
      <table border="0" cellpadding="0" cellspacing="0" style="line-height:42px; margin:0 auto;" id="tableId">
        
      </table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目说明：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目说明：</td>
          <td width="400" id="memo"></td>
        </tr>
        <tr>
          <td width="84">附件：</td>
          <td width="260"><a href="#" class="tablelink" id="projectAttchement"></a></td>
        </tr>
      </table>
  </div>
   <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><a class="dian3" onclick="javascript:window.history.back();">返回</a></td>
  </tr>
</table>
    </div> 
 
 <div class="chuang" id="chuang" style="display:none;">
   <span style="text-align:right; padding:10px 10px 0 0;"><a href="#" title="关闭窗口" id="closed"><img src="images/guanbi.gif" width="16" height="16" /></a></span>
   <table border="0" cellspacing="0" cellpadding="0" style="margin:20px auto 0 auto; line-height:42px;">
  <tr>
    <td width="40">&nbsp;</td>
    <td width="138"><input type="checkbox" name="checkbox" id="checkbox" />
      教师网</td>
    <td width="138"><input type="checkbox" name="checkbox2" id="checkbox2" />
      果实网</td>
    <td width="138"><input type="checkbox" name="checkbox3" id="checkbox3" />
      继教网</td>
    <td width="40">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="3"><table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
            <tr>
              <td width="111"><a href="javascript:;" class="dian1" id="baocun">保 存</a></td>
              <td width="40">&nbsp;</td>
              <td width="111"><a href="javascript:;" class="dian2" id="quxiao">取 消</a></td>
            </tr>
          </table></td>
    <td>&nbsp;</td>
  </tr>
</table>
 
 </div>
<div class="black" style="display:none;" id="black"></div>
 
 
</body>
<script> 
  window.onload=function(){
	  var chuang=document.getElementById('chuang')
	  var black=document.getElementById('black')
	  var btn=document.getElementById('xz')
	  var closed=document.getElementById('closed')
	  var txtBox=document.getElementById('txtBox')
	  var baocun=document.getElementById('baocun')
	  var quxiao=document.getElementById('quxiao')
	  
	  btn.onclick=function(){
		  openDiv();
		  }
	  closed.onclick=baocun.onclick=quxiao.onclick=function(){
		  closedDiv();
		  }
		function openDiv(){
			chuang.style.display='block';
			black.style.display='block';
			txtBox.style.display='none';
			}  
		 function closedDiv(){
			chuang.style.display='none';
			black.style.display='none';
			txtBox.style.display='block';
			}  
	  }
</script>
</html>

