<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%@include file="../common/commonHead.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>培训总结</title>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select1").uedSelect( {
				width : 345
			});
			$(".select2").uedSelect( {
				width : 167
			});
			$(".select3").uedSelect( {
				width : 100
			});
		});
	</script>
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
			<li><a href="#">培训项目</a></li>
			<li>培训项目总结</li>
            <li>查看承培机构培训总结</li>
		</ul>
</div>
		<div class="formbody">
			<div class="tabson">
<ul class="seachform">
           <li><a href="javascript:history.go(-1);" class="dian3">返 回</a></li>
		</ul>    
      </div>
			<table class="tablelist">
				<thead>
					<tr>
					 	<th width="15%"  >承培机构</th>
						<th width="30%"  >总结标题</th>
						<th width="10%"  >查看</th>
					</tr>
				</thead>
                
				<tbody>
					<c:forEach items="${pageObject.objects}" var="obj">
						<tr>
							<td>${obj.orgName}</td>
							<td><a href="#" class="tablelink click">${obj.title}</a>&nbsp;&nbsp;</td>
							<td>&nbsp;
								<a href="#" onclick="viewSummary(${obj.id})" class="tablelink click">查看</a>
							</td>
						</tr>
					</c:forEach>
			</tbody>
			</table>
     <!-- 分页 -->
    <input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
	<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
	<div id="pagebar" class="pagin">	
	</div>
   <!-- 分页 --> 
		</div>
		
		
		<div class="tip" style="height:500px;">
    	<div class="tiptop"><span><d class="ctype"></d>承培机构培训总结</span><span>&nbsp;&nbsp;</span><a></a></div>
        
      <div class="tipinfo" style="width:470px; height:360px;padding:10px; margin:0;">
        <ul class="forminfo" style="padding:0; margin:0;">
		  <li><label>标题：</label><cite><input id="summaryTitle" name="summaryTitle" type="text" class="scinput" value="" /></cite></li>
		<li><label><d class="ctype"></d>总结：</label>
		<div class="vocation" style="padding-right:8px;">
			<textarea id="summaryContent" name="summaryContent" cols="" rows="" class="textinput" style="width:260px; height:270px;"></textarea></div></li>
		  <li><label>附件：</label><cite id="cite"><a id="download" href="#"></a><a id="delete" href="#"></a></cite></li>
		</ul>
      </div>
      <div class="tipbtn">
		<span class="sl-custom-file"> 
			<input id="summaryId" type="hidden" class="btn" value="" />
			<input id="pid" type="hidden" class="btn" value="${pid}" />
			<input id="attchmentPath" type="file" name="attchmentPath" class="ui-input-file"/>&nbsp;&nbsp; 
		</span>
       </div>
    </div>
	</div>
	<iframe id="downIframe" src="" frameborder=0 scrolling=no marginheight=0 marginwidth=0 height=60 width="100%"></iframe>
<script type="text/javascript">
function viewSummary(id){
	var url = "<%=basePathHeader%>/edupm/summary/viewSummary.do";
	$.ajax({
  		dataType: 'json',  
  		url:url,
  		data:{summaryId:id},
  		success:function(data){
  			if(data.eps!=null){
  				$("#summaryTitle").val(data.eps.title);
 				$("#summaryId").val(data.eps.id);
  	  			$("#pid").val(data.eps.projectId);
  				$("#summaryContent").val(data.eps.content);
  				$("#summaryId").val(data.eps.id);
  				if(data.eps.attchementTitle!=null){
  					$("#download").html(data.eps.attchementTitle+"&nbsp;&nbsp;下载");
  				}
  				$("#download").attr("href","<%=basePathHeader%>/"+data.eps.attchementUrl+data.eps.attchementTitle);
  			}else{
  	  			$("#summaryTitle").val("");
  	  			$("#summaryContent").val(""); 
  	  			$("#download").html("");
				$("#download").attr("href","#");
  			}
  			$(".tip").fadeIn(200);
  		},
  		error:function(XMLHttpRequest, textStatus, errorThrown){
			$(".tip").fadeIn(200);
			alert("查询数据出错！请联系管理员");
		}
  	});
}


$(document).ready(function(){
  	$(".tiptop a").click(function(){
		$(".tip").fadeOut(200);
	});
});
</script>
</body>
</html>
