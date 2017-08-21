<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目学习</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherProject.js"></script> 
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
    <li><a href="#">项目学习</a></li>
    <!-- <li><a href="#">正在参加的培训项目</a></li> -->
	<li>
		培训项目申报通过后,教师查看资料可自行下载实施管理员和行政管理员上传的项目培训材料附件
	</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
 
      <div class="tabson" style="overflow:hidden;height:auto;" id="teacherProjectList">
        
	 
      
      </div>
      
    </div> 

	</div>
 
 

<div class="tip" id="choose1">
    	<div class="tiptop"><span>选择培训项目</span><a></a></div>
        
      <div class="tipinfo">
      <div class="tipright" >
       </div>
        <ul class="forminfo" >
    <li> 
		<div class="vocation">
			   项目名称:<a id="projectName"></a>
		</div>
    </li>
        <li> 
		<div class="vocation" id="organizationName">
			   <a id="url"></a>
		</div>
    	</li>
  
        </ul>
        
      </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="保存" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    		
    		 <div class="tip" id="choose2" style="height:500px;">
    			<div class="tiptop"><span><d class="ctype"></d>培训材料</span><span>&nbsp;&nbsp;</span><a></a></div>

				<div class="tipinfo"
					style="width:470px; height:360px;padding:10px; margin:0;">
					<div class="forminfo" style="padding:0; margin:0;">
						<table  id="download"></table>
					</div>
				</div>
			</div>
			
			<!-- 培训总结上传模态框 -->	
<div id="trainingViewModal" class="modal hide fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="projectName2"></h3><label></label>
  </div>
  <div class="modal-body">
		<table id="viewTable" class="table table-hover table-condensed">
		</table>
	</form>
  </div>
  <div class="modal-footer">
   <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
  </div>

</body>

</html>
