<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common/commonHead.jsp"%>
<script language="javascript" type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/fjimportHistory.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>导入历史纪录</title>
</head>
<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="system" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/systemLeft.jsp"%>
	</div>
<div class="content">
    
    <div class="formbody">
    
<ul>
    <li><label>&nbsp;</label><input type="button" class="scbtn" value="批量导入" onclick="window.location='<%=basePathHeader%>/sys/fjimport.htm?click=99'"/>
    &nbsp;&nbsp;&nbsp;&nbsp;<label>导入日期:&nbsp;&nbsp;</label><input type="text" id="importDate" class="Wdate scinput" style="height:32px; line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" onClick="WdatePicker()">
    <label>&nbsp;</label><input type="button" class="scbtn" value="查 询" onclick="queryRecords()"/>
    </li>
 

</ul>

   <div class="chauxnJS jsTool" style="display: none"><span style="float:left;"></span><span style="float:right;"></span></div>

    <table class="tablelist">
    	<thead>
    	<tr>
        <th width="10%">操作时间</th>
        <th width="10%">操作人</th>
        <th width="15%">操作人所在地区</th>
        <th width="5%">导入记录数</th>
        <th width="7%">操作</th>
        </tr>
        </thead>
        <tbody id="records">
        </tbody>
    </table>
      <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
</div>  
</div> 
</body>
</html>