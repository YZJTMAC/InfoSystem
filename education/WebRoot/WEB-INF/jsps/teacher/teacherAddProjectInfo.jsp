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
    <li>我的培训项目</li>
		<li>查看</li>
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
            <td width="84">学历：</td>
          <td width="260"><div class="vocation">
          ${info.educationBackgroundName }
          </div></td>

          <td width="60">&nbsp;</td>
          <td width="84">职务：</td>
          <td width="260">${info.positionName }</td>
          </td>
        </tr>
        <tr>
          <td width="84">职称：</td>
          <td width="260">${info.professionalTitleName }</td>
          <td >&nbsp;</td>
          <td >是否为班主任：</td>
	<c:if test="${info.isClassCharger == 1}">
          <td> 是 </td>
          </c:if>
          <c:if test="${info.isClassCharger == 0}">
          	<td> 否 </td>
          </c:if></td>
        </tr>
        <tr>
          <td>学科：</td>
          <td>${info.subjectName }</td>
          <td>&nbsp;</td>
          <td>学段：</td>
          <td> ${info.stdutySection }</td>
        </tr>
<tr>
          <td>是否收费：</td>
          <<c:if test="${info.isFree == 1}">
          <td> 是 </td>
          </c:if>
          <c:if test="${info.isFree == 0}">
          	<td> 否 </td>
          </c:if>
          <td>&nbsp;</td>
          <td>是否审核：</td>
          <c:if test="${info.mustAudit == 1}">
	          <td> 是 </td>
          </c:if>
          <c:if test="${info.mustAudit == 0}">
	          <td> 否 </td>
          </c:if>
        </tr>

        
        
      </table>
      <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">项目说明：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
        <tr>
          <td width="84">项目范围：</td>
          <td width="400">${info.memo }</td>
        </tr>
        
      </table>
      <h4  style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						
						项目申报书：
			           </h4>

					   <table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<c:forEach items="${files}" var="at" varStatus="ss">
							<tr>
								<td width="300" >
								${names[ss.index]}
									<a href="<%=basePathHeader%>/dowload/download.do?proId=${info.id}&&index=${ss.index}"
										class="tablelink">下载申报书 </a>
								</td>
								<td width="440"></td>
							</tr>
						</c:forEach>
												
						
					</table>
<div id="shenhe" style="display:block;">
	     <h4 style="padding:20px 0 20px 40px; margin-top:30px;border-top:1px dashed #a7b5bc;">审核信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
       <tr>
          <td width="84">审核人：</td>
          <td width="260" id="updateBy"></td>
        </tr>
         <tr>
          <td width="84">审核时间：</td>
          <td width="260" id="updateDate"> </td>
        </tr>
         <tr>
          <td width="84">审核结果：</td>
          <td width="260" id="status">  </td>
        </tr>
         <tr>
          <td width="84">审核说明：</td>
          <td width="260" id="auditMemo"> </td>
        </tr>
        
      </table>
</div>
	  
  </div>
  <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><a class="dian3" onclick="javascript:window.history.back();">关闭</a></td>
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
 </div>
<div class="black" style="display:none;" id="black"></div>
</body>
</html>
