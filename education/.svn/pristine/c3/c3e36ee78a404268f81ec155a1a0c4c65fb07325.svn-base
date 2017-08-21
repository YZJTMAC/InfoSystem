<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑项目</title>
<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
  
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonAreaSelect.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectAdd.js"></script>
<script type="text/javascript">
	var proId = <%=request.getParameter("proId")%>
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectDeclareModify.js"></script>
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
    <li><a href="#">项目管理</a></li>
		<li><a href="#">创建新项目 	</a></li>
    </ul>
    </div>
    <div class="formbody">
<form action="" id="proForm" enctype="multipart/form-data" method="post">
	<input type="hidden" name="id">
      <input type="hidden" name="projectScopeId">
      <input type="hidden" name="projectScopeName">
      <input type="hidden" name="projectPropertyId">
      <input type="hidden" name="projectPropertyName"><%--
      <input type="hidden" name="trainScopeId">
      <input type="hidden" name="trainScopeName">
      --%><input type="hidden" name="trainTypeId">
      <input type="hidden" name="trainTypeName">
      <input type="hidden" name="gradeId">
      <input type="hidden" name="gradeName">
      <input type="hidden" name="positionId">
       <input type="hidden" name="positionName">
       <input type="hidden" name="subjectId">
        <input type="hidden" name="subjectName">
       <input type="hidden" name="stdutySectionId">
       <input type="hidden" name="stdutySection">
       <input type="hidden" name="professionalTitleId">
       <input type="hidden" name="professionalTitleName">
        <input type="hidden" name="educationBackgroundId">
       <input type="hidden" name="educationBackgroundName">
       <input type="hidden" name="isFree">
       <input type="hidden" name="signUpWay">
      <div class="tabson" id="txtBox">
      <h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
      <tr>
      	<td>继教信息板块:</td>
      	<td width="260">
      	<select  class="select2" name="eduModelType">
      		<option value="1">2014教师培训计划</option>
      		<option value="2">2015教师培训计划</option>
      	</select> 
      	</td>
      </tr>
      <tr>
		  <td>项目名称：</td>
		  <td colspan="4"><input name="projectName" type="text" class="scinput" style="width:571px;"/></td>
	    </tr>
		<tr>
            <td width="84">项目年度：</td>
          <td width="260"> <select  class="select2 yearpicker" name="year"> </select>
		  </td>
          <td width="60">&nbsp;</td>
          <td>项目编号：</td>
          <td width="260"  ><input name="projectNo" type="text" class="scinput" /></td>
        </tr>
		
		
		<tr>
          <td>项目开始时间：</td>
          <td><input type="text" name="startDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onClick="WdatePicker()"></td>
          <td>&nbsp;</td>
          <td>项目结束时间：</td>
          <td><input type="text" name="endDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onclick="WdatePicker()" /></td>
        </tr>
        
        <tr>
          <td >是否收费： </td>
          <td id="isFree">	
          <input type="radio" value="0" name="if" >否
          <input type="radio" value="1" name="if">是
          </td>
          	<td width="60"></td>
           <td>收费标准：</td>
          <td width="160" name='shezhi'>
          	<input name="chargingStandard" type="text" class="scinput" value="0"/>
          </td>
        </tr>
        
         <!--
           
          <td>是否收费：</td>
          <td><select name="isFree"  class="select2">
          <option value='-1'>请选择</option>
          <option value="1">是</option>
          <option value="0">否</option>
          </select></td>
           -->
        
        
        
        <tr>
          <td>报名方式设置：</td>
           
          <td colspan="4" >
	          <input type="radio" name="t1" value="1">组织报名&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="radio" name="t1" value="2">自由报名 
	          <input type="radio" name="t1" value="3" >层级分配/报名 &nbsp;&nbsp;&nbsp;&nbsp;
	      </td>
        </tr>
       
      </table>
      
      
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目内容：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
     <tr>

    <td width="84">
        培训人数
    </td>
    <td width="260">
        <div class="vocation">
            <input class="scinput" type="text" colspan="4" name="planNum"></input>
        </div>
    </td>
    <td width="60"></td>
    <td width="84"></td>
    <td width="260"></td>

</tr>
		<tr>
            <td width="84">项目范围：</td>
          <td width="260"><div class="vocation">
            <select  class="select2"  id = "projectScope">
            </select>
          </div></td>
          <td width="60">&nbsp;</td>
          <td width="84">培训范围：</td>
          <td width="260"  >
          <input name="trainScopeName" type="text" class="scinput areaSelect" colspan="4" id="ts"/>
          <input name="trainScopeId" type="hidden">
          <input name="input2" type="button" value="选 择" class="btnXuan areaSelect"/></td>
        </tr>
		<tr>
		  <td>项目性质：</td>
		  <td>
		  <div class="vocation">
		    <select name="select" class="select2" id="projectProperty">
	        </select>
		    </div></td>
		  <td>&nbsp;</td>
		  <td>培训类型：</td>
		  <td><div class="vocation">
		    <select name="select"  class="select2" id="projectTrainType">
	        </select>
		    </div></td>
	    </tr>
      
      </table>
      
      
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">
      		项目培训对象：
      </h4>
      <table border="0" cellpadding="0" cellspacing="0" style="line-height:42px; margin:0 auto;">
        <tr>
          <td width="90">学历：</td>
          <td width="181"><select name="select5"  class="select2" id="projectEduBg">
          </select></td>
           <td>学段/学科</td>
          <td>
          <input name="subject" class="scinput" readonly="readonly"/>
           <input name="input2" type="button" value="选 择" class="btnXuan" onclick="showS();"/>
          </td>
        </tr>
        <tr>
          <td>职务：</td>
          <td><select name="select3"  class="select2" id="projectPos">
          </select></td>
           
          <td>职称：</td>
          <td><select name="select3"  class="select2" id="projectProTit">
          </select></td>
          <td>是否为班主任：</td>
          <td><div class="vocation">
            <select name="isClassCharger" class="select2">
              <option value="-1">请选择</option>
			  <option value ="1">是</option>
              <option value="0">否</option>
            </select>
          </div></td>
        </tr>
        <tr>
        <!--
           
          <td>是否收费：</td>
          <td><select name="isFree"  class="select2">
          <option value='-1'>请选择</option>
          <option value="1">是</option>
          <option value="0">否</option>
          </select></td>
           -->
           <!--<td>收费标准：</td>
          <td><input name="chargingStandard" type="text" class="scinput" /></td>
        -->
        </tr>
      </table>
	   <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目继教信息:</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
		<tr>
            <td width="84">学时：</td>
          <td width="260"> <input name="classPeriod" type="text" class="scinput" colspan="4"/></td>
          <td width="60">&nbsp;</td>
          <td width="84"></td>
          <td width="260"  ></td>
        </tr>
		 
      
      </table>
	  
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目说明：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目范围：</td>
          <td width="260"><textarea name="memo" style="width:600px; height:100px; max-width:600px; border:1px solid #ccc;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"></textarea></td>
        </tr>
        
       <!--  <tr>
          <td width="84" colspan="2">附件：</td>
        </tr>
        <tbody id="files">
        
        </tbody>
         <tr><td colspan="2" align="center"><a href="javascript:addMore()">再次添加</a></td></tr> -->
      </table>
      </div>
      <input id="deleted" name="deleted" type="hidden">
      </form>
      <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><a href="javascript:updatePro();" class="dian3" >保 存</a></td>
    <td style="width:30px;">&nbsp;</td>
    <td><a href="#" class="dian3" onclick="cancel();">取 消</a></td>
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
              <td width="111"><a href="##" class="dian2" id="quxiao" onclick="cancel()">取 消</a></td>
            </tr>
          </table></td>
    <td>&nbsp;</td>
  </tr>
</table>

 </div>
</div>

<script>

</script>

<%@include file="../common/commonAreaSelectForProject.jsp" %>
    <br>
    
    
    
    <!-- 选择学段学科 -->    
<div class="tip" id="XDshow" style="display:none;width: 600px;height: 600px">
    <div class="tiptop"><span>选择学段/学科</span><a href="javascript:hideMe();"></a></div>
    <div style="position: absolute;margin-left: 20px;width: 560px;margin-top: 2%">
    已选：
    	  <ol class="xuanDQ">
		    <li id="hasSelected"></li>
		    <li style="float:right"><a href="###" onclick="lastSure();" class="souXX">确 定</a></li>
	  </ol>
    </div>
    
      <div style="width: 100px;position: absolute;margin-top: 12%;margin-left: 20px;width: 100%">
      学段：
        <table style="width:100%;margin-top: 5px">
        	<tbody id="section">
      		</tbody>
        </table>
      </div>
      
      <div style="margin-left: 20px;position: absolute;margin-top: 20%;width: 560px;background-color:#E5E5E5;height: 65%" >
      
      	<table  style="width: 100%;margin-top: 10px">
      		<tbody id="subject">
      			<tr>
      				
      			</tr>
      		</tbody>
      	</table>
      </div>
  </div>
</body>
</html>