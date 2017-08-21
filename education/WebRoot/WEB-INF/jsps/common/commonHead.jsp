<%@ page pageEncoding="UTF-8"%>
<%@include file="pathHead.jsp"%>


<link  href="<%=basePathHeader%>/style/style.css" rel="stylesheet" type="text/css" />

<link href="<%=basePathHeader%>/style/select.css" rel="stylesheet" type="text/css" />
<!-- jQuery库 -->
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/select-ui.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/page.commons.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/commonFunction.js"></script>
<script type="text/javascript" src="<%=basePathHeader %>/javascript/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/projectCommon.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jquery.alertWindow.min.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/fileUpload.js"></script>

<script type="text/javascript"	src="<%=basePathHeader%>/bootstrap/js/bootstrap.js"></script>
<link  href="<%=basePathHeader%>/bootstrap/css/need.css" rel="stylesheet" type="text/css" />

<%@include file="ajaxRedirectPage.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/commomHead.js">
</script>
<style type="text/css">
.alertWindowContent input{width: 100px; height: 50px;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; border-radius}
</style>
<script type="text/javascript">
	var click = '${click}';
	function toUrlById(click) {
		return $("#" + click).children("a").attr("href");
	}
</script>
<script type="text/javascript">
	var progress= <%=request.getSession().getAttribute("progress")%>
</script>