<%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看项目</title>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/editor/kindeditor.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherAddProjectInfo.js"></script>
<script type="text/javascript">
	var projectId = '<%=request.getParameter("projectId")%>';
</script>
<script type="text/javascript">
	var typeVal = '<%=request.getParameter("type")%>';
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
    <li>加入培训项目</li>
		<li>报名</li>
    </ul>
    </div>
    
<div class="formbody">
    
      <div class="tabson" id="txtBox">
        <h4 style="padding:0 0 20px 40px;">项目基本信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
      <tr>
		  <td>项目名称：</td>
		  <td colspan="4">${info.projectName }</td>
	    </tr>
		<tr>
            <td width="84">项目年度：</td>
          <td width="260"> ${info.year}
		  </td>
          <td width="60">&nbsp;</td>
          <td>项目编号：</td>
          <td width="260"  > ${info.projectNo } </td>
        </tr>
		
		
		<tr>
          <td>项目开始时间：</td>
          <td>${info.startDate } </td>
          <td>&nbsp;</td>
          <td>项目结束时间：</td>
          <td>${info.endDate } </td>
        </tr>
       
      </table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目内容：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
	  	<tr>
            <td width="84">培训人数</td>
          <td width="260"><div class="vocation">
          ${info.planNum }
          </div></td>
          <td width="60">&nbsp;</td>
          <td width="84"> </td>
          <td width="260"  >
          </td>
        </tr>
        <tr>
          <td width="84">项目范围：</td>
          <td width="260">${info.projectScopeName }</td>
          <td width="60">&nbsp;</td>
          <td width="84">培训范围：</td>
          <td width="260">${info.trainScopeName }</td>
        </tr>
        <tr>
          <td>项目性质：</td>
          <td>${info.projectPropertyName }</td>
          <td>&nbsp;</td>
          <td>培训类型：</td>
          <td>${info.trainTypeName}</td>
        </tr>
      </table>
        <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目培训对象：</h4>
     <table border="0" cellpadding="0" cellspacing="0" style="line-height:42px; margin:0 auto;">
        <tr> 
          <td width="60">学科：</td>
          <td width="187">${info.subjectName }</td>
          <td width="60">学段: </td>
         <td width="187"></td>
          <td width="90">学历：</td>
          <td width="181"> ${info.educationBackgroundName }</td>
        </tr>
        <tr>
           
          <td>职务：</td>
          <td>  ${info.positionName }</td>
          <td>职称：</td>
          <td>   ${info.professionalTitleName }</td>
          <td>是否为班主任：</td>
          <td><div class="vocation">
            <c:if test="${info.isClassCharger == 1}">
          	是 
          </c:if>
          <c:if test="${info.isClassCharger == 0}">
          	 否 
          </c:if>
          </div></td>
        </tr><%--
        <tr>
           
          <td>是否审核&nbsp;</td>
          <c:if test="${info.mustAudit == 1}">
	          <td> 是 </td>
          </c:if>
          <c:if test="${info.mustAudit == 0}">
	          <td> 否 </td>
          </c:if>
            <td>是否收费：</td>
           <c:if test="${info.isFree == 1}">
          <td> 是 </td>
          </c:if>
          <c:if test="${info.isFree == 0}">
          	<td> 否 </td>
          </c:if>
          <td>收费标准：</td>
          <td>${info.chargingStandard }</td>
        </tr>
        
        
        
      --%></table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目说明：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目范围：</td>
          <td width="400">${info.memo }</td>
        </tr>
        <tr>
          <td width="84">附件：</td>
          <td width="260"><a href="#" class="tablelink">${info.projectAttchement }</a></td>
        </tr>
      </table>
	  
	    <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">培训实施机构：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;" id="orgsNames">
       
      </table>
	  
	    <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">继教信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">学时:${info.classPeriod}</td>
          <td width="400">学分:${info.classScore}</td>
        </tr>
       
      </table>
	     <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目状态：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84"> 
          <c:if test="${info.status == 1}">
          <h4  >准备中</h4>
          </c:if>
          <c:if test="${info.status == 2}">
           <h4  >正在进行中</h4>
          </c:if>
          <c:if test="${info.status == 4}">
           <h4  >创建中</h4>
          </c:if>
          </td>
          <td width="400"> </td>
        </tr>
       
      </table>
      
     
      </div>

      
	  
	      <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><input id="disable" type = "button" class="dian3" onclick="teacherAdd(projectId,typeVal)" value="我要报名" /></td>
    
    <td style="width:30px;">&nbsp;</td>
    <td><a onclick="javascript:window.history.back();" class="dian3">取 消</a></td>
  </tr>
</table>

    </div> 
 
 
 </div>
<div class="black" style="display:none;" id="black"></div>
</body>
</html>
