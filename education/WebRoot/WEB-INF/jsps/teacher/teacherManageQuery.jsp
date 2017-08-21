<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8; IE=9;" />
<title>教师信息查询</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".select3").uedSelect({
		width : 100
	});

	$(".divmore").mouseleave(function() {
		 $(this).hide();
	});
});
</script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/My97DatePicker/WdatePicker.js"></script>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherManageQuery.js"></script>
<style>
.moreChoose dd {width: 980px;}
</style>
 </head>

<body>
	<!-- top -->
	<div class="head">
			<jsp:include page="../common/top.jsp" >
			<jsp:param value="teacher" name="flag"/>
		</jsp:include>
	</div>
	<!-- left -->
	<div class="leftNav">
		<%@include file="../common/teacherLeft.jsp"%>
	</div>
	
	<div class="content">
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">教师信息</a></li>
			    <li>教师信息查询</li>
			    <li>操作说明：搜索结果根据按需筛选和精确查询的条件组合查询出</li>
		    </ul>
    	</div>
    
    <div class="formbody">
    	<div class="chauxnJS jsTool">
     		<span style="float:left;"><h4 style="float:left;">教师信息：</h4><a href="javascript:;" style=" float:left; line-height:18px; margin:7px 0 0 10px;" class="jq" id="btn2">按需筛选</a><a href="javascript:;" style=" float:left; line-height:18px; margin:7px 0 0 10px;" id="btn1">精确查询</a></span>
     		<span style="float:right;"><!-- <a href="teacherGLY_1.1.10.html" style="margin-right:8px;">历史导入记录</a> --></span>
     	</div>
     	
  		<div>
		  <div class="condition">
		  	<dl>
		      <dt id="addQueryCOndition" style="background-color:#fff;"><strong>已选条件：</strong></dt>
		      <dd><a href="#" class="tablelink" title="清空已选条件">清空选项</a></dd>
		    </dl>
		  </div>
  
		  <div class="choose" id="jqDiv1" style="display:none;">
		  	<table border="0" cellspacing="0" cellpadding="0" style="line-height:42px; margin:0 auto;">
			  <tbody>
				  <tr>
				    <td width="110">教师姓名：</td>
				    <td><input id="queryRealName" name="input13" type="text" class="dfinput" style="width:170px;"/></td>
				    <td width="60">&nbsp;</td>
				    <td width="110">教师编号：</td>
				    <td><input id="queryTeacherNo" name="input3" type="text" class="dfinput" style="width:170px;"/></td>
				    <td width="60">&nbsp;</td>
				    <td width="110">身份证号码：</td>
				    <td><input id="queryIdNumber" name="input4" type="text" class="dfinput" style="width:170px;"/></td>
				  </tr>
				  <tr>
				  	<td>借调分流单位：</td>
				    <td><input id="queryJdfldw" type="text" class="dfinput" style="width:170px;"/></td>
				    <td>&nbsp;</td>
				    <td>(评)职称时间：</td>
				    <td><input id="21" type="text" name="jobCommentDate" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;" /></td>
				    <td>&nbsp;</td>
				    <td>(聘)职称时间：</td>
				    <td><input id="22" type="text" name="jobRecruitmentDate" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
				  </tr>
				  <tr>
				  	<td>聘任岗位等级时间：</td>
				    <td><input id="23" type="text" name="postGrade" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
				    <td>&nbsp;</td>
				    <td>本校任教起始时间：</td>
				    <td><input id="24" type="text" name="jobWorkDate" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
				    <td>&nbsp;</td>
				    <td>借调分流时间：</td>
				    <td><input id="25" type="text" name="jdflTime" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
				  </tr>
				  <tr>
				  	<td>离岗待退时间：</td>
				    <td colspan="7">
				    <input id="26" type="text" name="postBack" readonly="readonly" class="Wdate scinput" style="height:32px; width:170px;line-height:32px;border-color:#a7b5bc #ced9df #ced9df #a7b5bc;"/></td>
				  </tr>
				  <tr>
				    <td colspan="8" align="center"><a href="###" onclick="showInfoList();" class="dian3">查 询</a></td>
				  </tr>
				</tbody>
			</table>
			</div>
	
    <div class="choose" id="jqDiv2">
    <dl>
      <dt>地区：</dt><dd>
      		<input id="areaName" name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
			<input type="hidden" id="areaId" />
			<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
            </dd>
      <dd>
      </dd>
      <dd>
		
      </dd>
	  <dd>
		<div id="divSchool" style="display: none;"></div>
	  </dd>
	  <dd> 
	  <div class="chauxnJS jsTool" style="display:none;">
				<span style="float: left;">  <a href="javascript:;" class="huibtn_a click" id="btnSchool">打开学校选择弹出层</a>
				</span> 
			</div>

	  </dd>
    </dl>
						<!-- dl>
							<dt id="stdutySection" >
								学段：
							</dt>
							 
						</dl>
						<dl class="weizhi">
							<dt id="stdutySubject">
								学科：
								<dd class='deleteSubject'>请先选择学段</dd>
							</dt>
							 
							<a href="###"  class="more">更多</a>
						</dl-->
						<div style="background: #fff url(<%=basePathHeader%>/style/images/tbg.jpg) left repeat-y; overflow: hidden; border-bottom: 1px dashed #ccc;">
							<dl class="weizhi" style="border-bottom: 0px;">
								<div  style="float: left; vertical-align: middle; width: 70px; line-height: 40px; background-color: #edf6fa; padding-left: 10px;">
									学段：
								</div>
								<div style="width:600px; float:left;">
						    		<!-- dd><input name="" type="checkbox" value="" />语文</dd-->
						    		<dd id="stdutySection"></dd>
						   	 	</div>
						    </dl>
						</div>
						<div style="background: #fff url(<%=basePathHeader%>/style/images/tbg.jpg) left repeat-y; overflow: hidden; border-bottom: 1px dashed #ccc;">
							<dl class="weizhi" style="border-bottom: 0px;">
								<div  style="float: left; vertical-align: middle; width: 70px; line-height: 40px; background-color: #edf6fa; padding-left: 10px;">
									学科：
								</div>
								<div style="width:530px; float:left;">
						    		<dt id="stdutySubject"></dt>
										<dd class='deleteSubject'>请先选择学段</dd>
						   	 	</div>
						    	<a href="###" class="more">更多</a>
						    </dl>
						</div>
	
	<dl class="moreChoose" style="height:70px;display:none;">
    <dt style="line-height:70px;">更多选项：</dt>
    <dd id="xuanze" >
		<ul id="xuanzeTool">
	        <li><a id="queryTitle_0" href="javascript:;">性别</a></li>
	        <li><a id="queryTitle_11" href="javascript:;">年龄段</a></li>
	        <li><a id="queryTitle_12" href="javascript:;">婚姻状况</a></li>
	        <li><a id="queryTitle_13" href="javascript:;">参加工作年限</a></li>
	        <li><a id="queryTitle_10" href="javascript:;">最低学历</a></li>
	        <li><a id="queryTitle_16" href="javascript:;">最高学历</a></li>
	        <li><a id="queryTitle_14" href="javascript:;">学科带头人</a></li>
	        <li><a id="queryTitle_15" href="javascript:;">骨干教师</a></li>
	        <li><a id="queryTitle_3" href="javascript:;">特级教师</a></li><!-- 
	        <li><a id="queryTitle_4" href="javascript:;">特岗教师</a></li>
	        <li><a id="queryTitle_5" href="javascript:;">农村骨干教师</a></li> -->
	        <li><a id="queryTitle_6" href="javascript:;">在职状态</a></li>
	        <li><a id="queryTitle_17" href="javascript:;">岗位类别</a></li>
	        <li><a id="queryTitle_18" href="javascript:;">(评)教师职称</a></li>
	        <li><a id="queryTitle_19" href="javascript:;">(聘)教师职称</a></li>
	        <li><a id="queryTitle_20" href="javascript:;">岗位等级</a></li>
	        <li><a id="queryTitle_27" href="javascript:;">班主任</a></li>
       	</ul>
      
	    <!-- 性别 --> 
		<div style="display:none;"  class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				 <tbody>
				 	<tr>
				    <td><input id="0"  type="radio" name="gender"  value="1"/></td>
				    <td>男</td>
				    <td width="40">&nbsp;</td>
				    <td><input id="0" type="radio" name="gender"  value="0"/></td>
				    <td>女</td>
				    <td>&nbsp;</td>
				  </tr>
				</tbody>
			</table>
		</div>

		<!-- 年龄段 -->
		<div style="display:none;" class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td><input id="11" type="radio" name="ageA" value="24" />
						</td>
						<td id="age_24">24岁及以下</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="25" />
						</td>
						<td id="age_25">25-29岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="30" />
						</td>
						<td id="age_30">30-34岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="35" />
						</td>
						<td id="age_35">35-39岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="40" />
						</td>
						<td id="age_40">40-44岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="45" />
						</td>
						<td id="age_45">45-49岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="50" />
						</td>
						<td id="age_50">50-54岁</td>
						<td width="40">&nbsp;</td>
						<td><input id="11" type="radio" name="ageA" value="60" />
						</td>
						<td id="age_60">60岁及以上</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 婚姻状况 -->
		<div style="display:none;" class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td><input id="12" type="radio" name="marry" value="1" />
						</td>
						<td>已婚</td>
						<td width="40">&nbsp;</td>
						<td><input id="12" type="radio" name="marry" value="0" />
						</td>
						<td>未婚</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 参加工作年限 -->
		<div style="display:none;"  class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td>
							<input id="13" type="radio" name="workAge" value="0-2" />
						</td>
						<td id="work_0-2">0-2年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="3-5" />
						</td>
						<td id="work_3-5">3-5年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="6-10" />
						</td>
						<td id="work_6-10">6-10年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="11-15" />
						</td>
						<td id="work_11-15">11-15年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="16-20" />
						</td>
						<td id="work_16-20">16-20年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="21-25" />
						</td>
						<td id="work_21-25">21-25年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="26-30" />
						</td>
						<td id="work_26-30">26-30年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="31-39" />
						</td>
						<td id="work_31-39">31-39年</td>
						<td width="40">&nbsp;</td>
						<td>
							<input id="13" type="radio" name="workAge" value="40" />
						</td>
						<td id="work_40">40年及以上</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
       
		<!-- 最低学历 -->       
		<div style="display:none;"  class="divmore" >
	        <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="lowEducationExperience" ></tbody>
	  		</table>
		</div>
	
		<!-- 最高学历 -->       
		<div style="display:none;"  class="divmore" >
	        <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="topEducationExperience" ></tbody>
	  		</table>
		</div>
	
		<!-- 学科带头人 -->
		<div style="display:none;"  class="divmore">
	   		<table border="0" cellspacing="0" cellpadding="0">
				<tbody id="subjectLeader"></tbody>
			</table>
		</div>
   
		<!-- 骨干教师 -->
		<div style="display:none;"  class="divmore">
		    <table border="0" cellspacing="0" cellpadding="0">
					<tbody id="coreTeacher"></tbody>
			</table>
		</div>

		<!-- 特级教师  -->
		<div style="display:none;" class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td><input type="radio" name="gradeTeacher" id="3" value="1" />
						</td>
						<td>是</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="gradeTeacher" id="3" value="0" />
						</td>
						<td>否</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
							<!-- 
       <div style="display:none;">
         <table border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
     <td><input type="radio" name="specialTeacher" id="4" value="1"/></td>
    <td>是</td>
    <td width="40">&nbsp;</td>
    <td><input type="radio" name="specialTeacher" id="4" value="0"/></td>
    <td>否</td>
    <td>&nbsp;</td>
  </tr>
</tbody></table>

       </div>
       
       <div style="display:none;">
         <table border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
      <td><input type="radio" name="countyRuralTeacher" id="5" value="1"/></td>
    <td>是</td>
    <td width="40">&nbsp;</td>
    <td><input type="radio" name="countyRuralTeacher" id="5" value="0"/></td>
    <td>否</td>
    <td>&nbsp;</td>
  </tr>
</tbody></table>

       </div>
       -->
	    <!-- 在职状态 -->
		<div style="display:none;" class="divmore">
			<table border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td>
							<input type="radio" name="userStatus" id="6" value="6" />
						</td>
						<td>未审核</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="7" />
						</td>
						<td>审核未通过</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="8" />
						</td>
						<td>在职</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="35" />
						</td>
						<td>已病休</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="34" />
						</td>
						<td>已离岗</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="32" />
						</td>
						<td>已死亡登记</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="31" />
						</td>
						<td>已退休</td>
						<td width="40">&nbsp;</td>
						<td><input type="radio" name="userStatus" id="6" value="33" />
						</td>
						<td>已离休</td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- 岗位类别 -->
		<div style="display:none;" class="divmore">
	         <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="gwlb"></tbody>
			</table>
		</div>
	       
	    <!-- (评)教师职称 -->
		<div style="display:none;" class="divmore">
	         <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="jobCommentPosition"></tbody>
			</table>
		</div>
		
		<!-- (聘)教师职称 -->
		<div style="display:none;" class="divmore">
	         <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="jobRecruitmentPosition"></tbody>
			</table>
		</div>
		
		<!-- 岗位等级 -->
		<div style="display:none;" class="divmore">
	         <table border="0" cellspacing="0" cellpadding="0">
	  			<tbody id="gwdj"></tbody>
			</table>
		</div>
	    
	    <!-- 班主任 -->
		<div style="display:none;" class="divmore">
	       <table border="0" cellspacing="0" cellpadding="0">
				 <tbody>
				 	<tr>
				    <td><input id="27"  type="radio" name="jobWhetherTeacher"  value="1"/></td>
				    <td>是</td>
				    <td width="40">&nbsp;</td>
				    <td><input id="27" type="radio" name="jobWhetherTeacher"  value="0"/></td>
				    <td>否</td>
				    <td>&nbsp;</td>
				  </tr>
				</tbody>
			</table>
		</div>
	</dd>
    </dl>
  </div> 
</div>
   <script>
  
    window.onload=function(){
		var oList=document.getElementById('xuanzeTool').getElementsByTagName('a')
        var oDiv=document.getElementById('xuanze').getElementsByTagName('div')
		var btn1=document.getElementById('btn1')
		var btn2=document.getElementById('btn2')
		var jqDiv1=document.getElementById('jqDiv1')
		var jqDiv2=document.getElementById('jqDiv2')
		for(i=0;i<oList.length;i++){
		oList[i].index=i;
		oList[i].onclick=function(){
		
		if(	  oDiv[this.index].style.display=='block'){
			for(i=0;i<oList.length;i++){
			 oList[i].className='';
			 oDiv[i].style.display='none';
		         }
		} else{
		  for(i=0;i<oList.length;i++){
			 oList[i].className='';
			 oDiv[i].style.display='none';
		         }
				 
				 
			  this.className='onthis'; 
		 
			  oDiv[this.index].style.display='block';
							 

		}
		
		     }
		   }
		   btn1.onclick=function(){
			   btn1.className='jq';
			   btn2.className='';
			   jqDiv1.style.display='block';
			   jqDiv2.style.display='none';
			   }
		   btn2.onclick=function(){
			   btn2.className='jq';
			   btn1.className='';
			   jqDiv2.style.display='block';
			   jqDiv1.style.display='none';
			   }
		 }
  </script>
    
    <div class="chauxnJS jsTool">
    <span style="float:left;">
    <div class="vocation" style="margin:4px 6px 0 6px;">
    <!--<select class="select3">
    <option>批量选择</option>
    <option>批量审核</option>
    <option>批量删除</option></select>-->
    </div><!-- <a href="###" class="huibtn_a batchAudit" style="margin-right:8px;">批量审核</a>
	<a href="###" class="huibtn_a batchDelete" style="margin-right:8px;">批量删除</a>
	<a href="###" onclick="downTeacherExcl();" class="huibtn_a">导出教师花名册</a> --></span>
    <span style="float:right;">
    <div class="pagin" style="margin:0; width:180px;">
    <div class="message">共<i class="blue" id="totleCount">0</i>条记录</div> 
    <div class="vocation paginList" style=" margin:4px 6px 0 6px;right:0px;">
    <select id="pageSize" class="select3" style="width: 100px;">
	    <option value="100">每页显示100条</option>
	    <option value="300">每页显示300条</option>
	    <option value="500">每页显示500条</option>
    </select>
    </div>
    
    </div>
    </span>
    </div>
        <table class="tablelist">
    	<thead>
    	<tr>
        <!-- <th><input id="chk_all" type="checkbox" value="" /></th> -->
        <th>照片</th>
        <th>姓名</th>
        <th>身份证号</th>
        <th>所属学校</th>
        <th>任教学段</th>
        <th>任教学科</th>
        <th>用户状态</th>
        </tr>
        </thead>
        <tbody id="teacherList" >
        </tbody>
    </table>
    
    <!-- 分页 -->
    <INPUT id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
	<INPUT id="pageIndex" value="1" type="hidden" name="pageIndex" />
	<div id="pagebar" class="pagin">	
	</div>
   <!-- 分页 --> 
   <!-- 区域选择 -->
   <%@include file="../common/commonAreaSelect.jsp"%>  
   <script type="text/javascript">
		lastSelect='${areaType}_${areaId}_${areaName}';
	</script>
    </div> 
	</div>
	
 
 
<div class="tip" style="width: 600px; height: 350px">
    	<div class="tiptop"><span>审核</span><a></a></div>
        
      <div class="tipinfo">
				<ul class="forminfo">

					<li>
						<label>
							是否通过：
						</label>
						<cite>
							<input name="auditTeacher" class="no" type="radio" value="true" checked="checked" />审核通过&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="auditTeacher" class="no" type="radio" value="false" />审核不通过
						</cite>
					</li>

					<li>
						<label>
							审核意见：
						</label>
						<textarea id="memo" name="" cols="" rows="" class="textinput" style="width: 300px"></textarea>
					</li>
				</ul>


			</div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="提交审核" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
<IFRAME id="downIframe" src="" frameborder=0 scrolling=no vspace=0 hspace=0   marginheight=0 marginwidth=0 height=60 width="100%"></IFRAME>


</body>

</html>
