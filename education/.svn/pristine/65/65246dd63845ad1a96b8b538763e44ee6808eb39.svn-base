<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>培训成绩公布</title> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/organization/orgScorePublishRule.js"></script>
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
				<li><a href="#">培训成绩发布</a></li>
				<li><a href="#">操作提示:成绩确定公布后标志项目真正结束. 公布规则:1.公布分数及学时2.按合格不合格公布,设置合格分数.3.按等级公布,优良中差,设置各级分数.</a></li>
			</ul>
		</div>
    
    <div class="formbody">
    
    

      <div class="tabson" id="txtBox">
      
      
      
      
      <h4 style="padding:20px 0 0 40px; border-top:1px dashed #a7b5bc;">公布规则:</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:38px; margin:0 auto; width:700px" >
	 
	 <tr>
          <td  >
            <table border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td width="140"><input name="mygroup" checked value="0" type="radio" style="margin-right:6px;"><strong>直接公布</strong></td>
				 
			  </tr>
			</table>

			</td>
         
        </tr>
        
		<tr>
          <td  >
            <table border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td width="140"><input name="mygroup"   value="1" type="radio" style="margin-right:6px;"><strong>直接公布分数</strong></td>
				<td>获得学时最低分数：
				  <input id="txtLow"   type="text" class="scinput"   value="0" style="width:60px;margin:0 6px;"/></td>
			  </tr>
			</table>

			</td>
         
        </tr>
		<tr>
            <td  >
            <table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="140"><input type="radio" name="mygroup" value="2"  style="margin-right:6px;"><strong>按是否合格公布</strong></td>
    <td>合格分：
      <input id="txtPass"  type="text" class="scinput"   value="0" style="width:60px;margin:0 6px;"/></td>
  </tr>
</table>

			
			
			
			 
			</td>
         
        </tr>
		<tr>
            <td  >
            <table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="140"><input type="radio" name="mygroup" value="3" style="margin-right:6px;" />
      <strong>按四等级公布</strong></td>
    <td>
      <input id="txtBest" name="input" type="text" class="scinput"  value="0" style="width:60px;margin:0 6px;"/>分以上优秀&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input id="txtBetter" name="input" type="text" class="scinput"   value="0" style="width:60px;margin:0 6px;"/>分以上良好&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input id="txtGood" name="input" type="text" class="scinput"   value="0" style="width:60px;margin:0 6px;"/>分以上及格&nbsp;&nbsp;&nbsp;&nbsp;
		 其他为不及格</td>
  </tr>
</table></td>
         
        </tr>
</table>

<div style="padding-left:80px;"></div>
			 
		  </td>
         
        </tr>
		 
      
      </table>
      
	  
	  
	  <!-- <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">学员查看成绩规则:</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:36px; margin:0 auto; width:700px;">
	 
	 <tr>
          <td  >
			<input value="1" id="ckb1" type="checkbox" style="margin-right:6px;">
			<strong>提交项目总结</strong></td>
         
        </tr>
		 
		 	<tr>
          <td  >
			<input value="2" id="ckb2" type="checkbox" style="margin-right:6px;">
			<strong>完成对承培机构评价</strong></td>
         
        </tr>
		
			<tr>
          <td  >
			<input value="3" id="ckb3" type="checkbox" style="margin-right:6px;">
			<strong>完成项目调查与评估</strong></td>
         
        </tr> -->
		 
	  
	 
	 
		 
      
      </table>
	  
       
      </div>
      <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><a id="btnSave" href="#" class="dian3">保 存</a></td>
    <td style="width:30px;">&nbsp;</td>
    <td><a id="btnCancel" href="javascript:history.back()" class="dian3">取 消</a></td>
  </tr>
</table>

    </div> 
	 <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div style="width: 280px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:160px">
			<div class="progress progress-striped active" style="margin-bottom: 0;">
				<!-- <div class="progress-bar" style="width: 100%;"></div> -->
				<span style="font-size:22px;">成绩发布中，请稍后. . .</span>
			</div>
		</div>
	 </div>   


</body><!-- 
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
</script> -->
</html>
