<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/tag/toolbar" prefix="toolbar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目评价</title>
<%@include file="../common/commonHead.jsp"%>
<link href="<%=basePathHeader%>/javascript/jqplot/jquery.jqplot.min.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jqplot/jquery.jqplot.min.js" ></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/jqplot/jqplot.pieRenderer.min.js" ></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/furtheredu/evaluationList.js"></script>
<style type="text/css">
.moreChoose dd {width: 650px;}
table.jqplot-table-legend{width:80px;height:220px;}
</style>
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
	
	$(".click").live("click",function(){
		showChart();
   	    $(".tip").fadeIn(200);
   	    plot2.replot();
	});
	$(".comment").live("click",function(){
   	    $(".tip2").fadeIn(200);
	});
	  
	  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
	});
	 
	  $(".sure").click(function(){
	  $(".tip").fadeOut(100);
	});
	 
	  $(".cancel").click(function(){
	  $(".tip").fadeOut(100);
	});
	$(".tiptop2 a").click(function(){
	  $(".tip2").fadeOut(200);
	});
	 
	  $(".sure").click(function(){
	  $(".tip2").fadeOut(100);
	});
	 
	  $(".cancel").click(function(){
	  $(".tip2").fadeOut(100);
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
    <li><a href="#">项目评价</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    

      <div class="tabson">
    
           <ul class="seachform">
  <li>
            <label>项目名称：</label>
            <input name="input" id="projectName" type="text" class="scinput" />
          </li>
 <li>
            <label>项目年度：</label>
             <div class="vocation"><select id="fromYear" class="select3 yearpicker" name="yearpicker" id="yearpicker"></select> -- 
			 </div>
          </li>
		  <li>--</li>
		   <li>
            <div class="vocation">   <select id="toYear" class="select3 yearpicker" name="yearpicker" id="yearpicker"></select>  
			 </div> 
          </li>
  <li><a href="###" onclick="showInfoList()" class="dian3">查 询</a></li>
           
        </ul>
    
      </div><table class="tablelist">
      <thead>
        <tr>
          <th width="20%">项目名称</th>
          <th width="30%">培训实施机构</th>
          <th width="20%">评价结果</th>
          <th width="30%">操作</th>
        </tr>
      </thead>
      <tbody id="targetList">
      </tbody>
    </table>
     <!-- 分页 -->
    <INPUT id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
	<INPUT id="pageIndex" value="1" type="hidden" name="pageIndex" />
	<div id="pagebar" class="pagin">	
	</div>
   <!-- 分页 --> 
 
    <div class="tip" style="height:350px; width:500px;">
    	<div class="tiptop"><span>查看教师评价</span><a></a></div>  
    	<div id="test"></div>
		<div id="chart2" style="height:300px; width:400px;" ></div>	
    </div>
   
    <div id="tip2" style="display:none; width:500px;" class="star tip2">
   <div class="tiptop2"><span>结项评价</span><a href="#"></a></div>
  <table id="comment" border="0" cellspacing="0" cellpadding="0" style="margin:0; padding:0; width:460px; margin:20px auto;">

    </table>
     </td>
    </tr>
  </table>
  <script type="text/javascript">
  function starChoose(e,oper){
  	var arr = $(e).parent().find("a");
  	for(var i = 0;i<$(e).index()+1;i++){
		arr[i].style.backgroundPosition = 'left top';
  	}
  	for(var i = 0;i<arr.length-$(e).index()-1;i++){
  	    if(arr[$(e).index()+i+1].title!=1){
  	 arr[$(e).index()+i+1].style.backgroundPosition = 'left bottom';
  	 }
  		
  	}
  }
  
  function clearStar(e){
  	var arr = $(e).find("a");
  	for(var i = 0;i<arr.length;i++){
  	 if(arr[i].title!=1){
  	 arr[i].style.backgroundPosition = 'left bottom';
  	 }
  		
  	}
  }
  
  //显示当前第几颗星
	function current(e,i,temp){
	var arr = $("#"+e).find("tr").eq(1+i).find("td").eq(2).find("a");
		for(var j = 0; j < temp; j++){
			arr[j].style.backgroundPosition = 'left top';
		}
	}
	function rateIt(e,i){
	        var temp = 0;
			temp = $(e).index() + 1;
			if(temp==1){
				
				document.getElementById("star"+i).getElementsByTagName("span")[0].innerHTML = "很不满意";
				}
			if(temp==2){
				
				document.getElementById("star"+i).getElementsByTagName("span")[0].innerHTML = "不满意";
				}
			if(temp==3){
				
				document.getElementById("star"+i).getElementsByTagName("span")[0].innerHTML = "一般";
				}
			if(temp==4){
				
				document.getElementById("star"+i).getElementsByTagName("span")[0].innerHTML = "满意";
				}
			if(temp==5){
				
				document.getElementById("star"+i).getElementsByTagName("span")[0].innerHTML = "很满意";
				}
			currentto(e,i,temp);
	}
	function currentto(e,i,temp){
	var arr = $("#comment").find("tr").eq(1+i).find("td").eq(2).find("a");
		for(var j = 0; j < temp; j++){
			arr[j].style.backgroundPosition = 'left top';
			arr[j].title=1;
		}
		for(var i = 0;i<arr.length-$(e).index()-1;i++){
  	     arr[$(e).index()+i+1].style.backgroundPosition = 'left bottom';
  	     arr[$(e).index()+i+1].title=0;
  	     }
	}
</script>
    </div>
</div>
</body>

</html>
