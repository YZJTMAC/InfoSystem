<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指定培训机构</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript">
	var proId = <%=request.getParameter("proId")%>
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/project/orgListByArea.js"></script>
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
    <li><a href="#">培训实施机构任务分配</a></li>
	 <li><a href="#">指定培训实施机构</a></li> 
    </ul>
    </div>
     
    <div class="formbody">
    
    

      <div class="tabson">
        <p class="xmTool">项目名称：<b id="projectName2"></b>计划培训人数：<b id="planNum2"></b> </p> <a href="#" class="dian3" id="setSignup">指定培训机构</a>
        <div> 
         <table class="tablelist" style="margin-top:12px;">
        <thead>
          <tr>
            <th width="20%">培训实施机构</th>
			<th width="10%">计划培训人数</th>
			<th width="20%">学科</th>
			<th width="20%">地区</th>
			<th width="10%">项目状态</th>
            <th width="20%">操作</th>
          </tr>
        </thead>
        <tbody id="orgList">
          <tr>
            <td>教师网&nbsp;</td>
			<td>0&nbsp;</td>
				<td>语文&nbsp;</td>
					<td>广东省&nbsp;</td>
             <td><a href="#" class="tablelink click" >分配任务</a>&nbsp;&nbsp; </td>
          </tr>
           <tr>
            <td>果实网&nbsp;</td>
			<td>1000&nbsp;</td>
				<td>数学&nbsp;</td>
					<td>广东省&nbsp;</td>
            <td><a href="peixun_2.1.1.1.html" class="tablelink">分配任务</a>&nbsp;&nbsp; </td> 
          </tr>
		   
        </tbody>
      </table>
   <!-- 分页 -->
			<input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
			<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
			<div id="pagebar" class="pagin"></div>
	<!-- 分页 -->
		 </div>
      </div>
    </div> 
 
 
 <div id="tanqi" style="width:660px;padding:20px; margin:-130px 0 0 -340px;">
     <div class="tabson">
	  
	   
     <ul class="seachform">
 
     <li> <p class="xmTool">项目名称：<b id="projectName"></b>计划培训人数：<b id="planNum"></b> </p></li>    
       </ul>
	
<ul class="seachform">
 
            <li>
            <label>培训实施机构：</label>
       
          </li>
          <li>
             <select name="select" class="select2" id="orgs">
             </select> 
            
          </li>
       </ul>
     </div>
     <table border="0" cellspacing="0" cellpadding="0" style="margin:0 auto;">
  <tr>
    <td width="111"><input name="input" type="button" class="dian3" value="确 定" id="btnOK"/></td>
    <td width="100px">&nbsp;</td>
    <td width="111"><input name="input3" type="button" class="dian3" value="取 消" id="btnQX"/></td>
  </tr>
</table>

</div>
		
    <div class="tip">
    	<div class="tiptop"><span>培训机构任务分配</span><a id="close"></a></div>
        
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin:0;">
        
       
        </div>
		     <ul class="seachform">
 
     <li> <p class="xmTool">项目名称：<b id="projectName3"></b> </p></li>    
	          
       </ul>
	   
	      <ul class="seachform">
      <li> <p class="xmTool">培训实施机构：<b id="orgName2"></b> </p></li>    
           
       </ul>
        <ul class="forminfo" style="padding:0; margin:0;">
    	<li>
    		<label style="width:100px;">地区：</label>  
			<div class="vocation">
		   		<input name="input2" type="text" class="scinput areaSelect" id="area" readonly="readonly"/>
		   		<input id="areaCode" type="hidden">
          		<input name="input2" type="button" value="选 择" class="btnXuan areaSelect" />
			</div>
    	</li>
    <li><label style="width:100px;">学科:</label>  
		<div class="vocation">
		   <input name="input2" type="text" class="scinput"  id="subjectName"readonly="readonly"/>
		   <input id="subjectId" type="hidden">
          <input name="input2" type="button" value="选 择" class="btnXuan" onclick="toSelectSubject()" id="toSelectS"/>
		</div>
    </li>
   <li>
			<label style="width:100px;">计划分配人数:</label>  
			<div class="vocation">
		   	<input name="input" id="pnToOrg" type="text" class="scinput" />
		</div>
   	 	</li>
    </ul>
      </div>
        <div class="tipbtn">
        <input type="hidden" id="opId">
        <input type="hidden" id="areaCode" >
        <input type="hidden" id="subjectId" >
        <input name="" type="button"  class="sure" value="确定"  onclick="setOrg()"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
    </div>
<!-- 选择区域层 -->
    <div class="tips_zb_1" id="selectArea">
    <%--
    	<div class="tiptop"><span>选择区域</span></div>
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin-left:20;"> </div>
        <ul class="forminfo" style="padding:0; margin:0;" id="selectA">
        </ul>
      </div>
      <div class="clear"></div>  
        <ul class="seachform" style="padding-top:80px;">
        <li style="padding-left:120px;"><label>&nbsp;</label></li>
        <li><input name="" type="button"  class="dian3" value="保存" onclick="setArea()"/></li>
        <li><input name="" type="button"  class="dian3" value="取消" onclick="hideMe()"/></li>
        </ul>
--%>

</div>
<!-- 选择学科层 -->
<div class="tips_zb_1" id="selectSubject">
    	<div class="tiptop"><span>选择学科</span></div>
      <div class="tipinfo">
      <div class="tipright" style="padding:0; margin-left:20;"> </div>
        <ul class="forminfo" style="padding:0; margin:0;" id="selectS">
        </ul>
      </div>
      <div class="clear"></div>  
        <ul class="seachform" style="padding-top:80px;">
        <li style="padding-left:120px;"><label>&nbsp;</label></li>
        <li><input name="" type="button"  class="dian3" value="保存" onclick="setSubject()"/></li>
        <li><input name="" type="button"  class="dian3" value="取消"  onclick="hideMe()"/></li>
        </ul>
</div>
<%@include file="../common/commonAreaSelectByProject.jsp" %>
</body>
</html>