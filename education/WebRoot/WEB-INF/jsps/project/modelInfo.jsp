<%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看继教信息版块</title>
<script type="text/javascript">
	var id = '<%=request.getParameter("id")%>';

      // 	var val =  new Date(${info.trainHour}).format("yyyy-MM-dd");
//       $(document).ready(function(){
//       	queryPxxsList();
//       });
      
//       function queryPxxsList(){
// 		var url = pathHeader+ "/org/queryPxxsList.do";
// 		$.ajax({
// 			url:url,
// 			data:{},
// 			type:"post",
// 			async:false,
// 			success:function(data){
// 				if(data.rows.length > 0){
// 					$("#projectTrainType").append("<option  value=''>请选择</option>");
// 					$.each(data.rows, function(key, value) {
// 						$("#projectTrainType").append(
// 								"<option  value=\"" + value.dictionaryName + "\">"
// 								+ value.dictionaryName + "</option>");
// 					});
// 				}
// 			},
// 			error:function(){
				
// 			}
// 		});
	
// }
      // 	$("#type").html(val);
</script>
</head>
<body>
	<!-- top -->
	<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="system" name="flag" />
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
			<li><a href="ssadmin.html">培训项目</a></li>
			<li>继教信息板块</li>
		<li>查看</li>
    </ul>
    </div>
    
<div class="formbody">
    
      <div class="tabson" id="txtBox">
        <h4 style="padding:0 0 20px 40px;">继教信息板块信息：</h4>
      <table border="0" cellspacing="0" cellpadding="0" style="line-height:40px; margin:0 auto;">
      <tr>
		  <td width="260">继教信息版块名称：</td>
		  <td colspan="4">${info.modelName }</td>
	    </tr>
		<tr>
            <td width="84">继教信息版块编码：</td>
          <td width="160"> ${info.modelCode}
		  </td>
          <td width="60">&nbsp;</td>
          <td>培训类型：</td>
          <td id="projectTrainType" width="260" > 
           ${info.trainType}
          </td>
        </tr>
		
		
		<tr>
         
          <td>学分：</td>
          <td>${info.trainScore} </td>
           <td>&nbsp;</td>
          <td>&nbsp; </td>
          <td>&nbsp;</td>
        </tr>
       <tr>
      
          <td>计划开始日期：</td>
          <td id="val">${info.startDate}</td>
          <td>&nbsp;</td>
          <td>计划结束日期：</td>
          <td>${info.endDate } </td>
        </tr>
        <tr>
        <td> 备注：</td>
        <td>${info.memo } </td>
        </tr>
      </table>
	  
  </div>
  <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td><a class="dian3" onclick="javascript:window.history.back();">返回</a></td>
  </tr>
</table>

    </div> 
 </div>
<div class="black" style="display:none;" id="black"></div>
</body>
</html>
