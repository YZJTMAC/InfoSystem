<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看培训成绩</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/system/teacherProjectTrainScore.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
var teacherId = '${teacherId}';
</script>
</head>

<body>
	<!-- top -->
	<div class="head">
		<jsp:include page="../common/top.jsp" >
			<jsp:param value="furtheredu" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/furthereduLeft.jsp"%>
	</div>
	
	<div class="content">
		<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <!-- <li><a href="#">培训项目管理</a></li>
    <li><a href="#">已结束的培训项目</a></li> -->
    <li><a href="#">查看培训成绩</a></li>

    </ul>
    </div>
    
    <div class="formbody">
      <div class="tabson">
      </div>
      
      <!-- <div class="chauxnJS jsTool">
					
						<span style="float: left;"> 
						</span>
						<span style="float: right;">
							<div class="pagin" style="margin: 0; width: 180px;">
								<div class="message">
									共
									<i class="blue" id="counts">0</i>条记录
								</div>

							</div> </span>
	 </div> -->
      <table class="tablelist" >
        <thead>
          <tr>
            <th>项目名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>培训形式</th>
            <th>培训类型</th>
            <!-- <th>培训成绩</th> -->
            <th>培训学分</th>
            <th>培训状态</th>
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

</body>

</html>
