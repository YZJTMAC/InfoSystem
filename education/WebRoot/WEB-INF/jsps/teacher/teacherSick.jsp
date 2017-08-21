<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师病休管理</title>
<%@include file="../common/commonHead.jsp"%>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
<script type="text/javascript"	src="<%=basePathHeader%>/javascript/jquery.tmpl.min.js" ></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script>
<script type=text/javascript src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/teacherRetirees.js"></script>
</head>

<body>
<script id="addEduPartB" type="text/x-jquery-tmpl">
	<ul>
		<ul class="forminfo forminfo1" style="padding: 0; margin: 0;">
									 
									<li>
										<label>
											病休说明
										</label>
										<div class="vocation" style="padding-right: 8px;">
											<textarea name="mobilizeMark" id="mobilizeMark" cols=""
												rows="" class="textinput" disabled="disabled"
												style="width: 260px; height: 30px;"></textarea>
										</div>
										<cite style="color: #F00;"></cite>
									</li>

									<li><label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</label>
										
									<cite id="msgs" style="color: #c00">
										
									</cite>
									</li>
									<li><label>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</label>
										
									<cite id="msgs" style="color: #c00">
										
									</cite>
									</li>
								</ul>
</ul>
</script>
	
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
    <li><a href="teacherGLY_1.1.html">教师信息</a></li>
    <li>教师病休管理</li>
    </ul>
    </div>
    
      <div class="formbody">
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
   <li>
		<a href="<%=basePathHeader %>/teacher/teachermanage/toSickAddPage.htm?click=12"  >发起病休</a>
	</li>
	<li>
		<a class="selected" href="###">已发起病休</a>
	</li>
	 <li>
		<!-- <a href="###">教师病休导入</a> -->
	</li>
  	</ul>
    </div> 
    <div id="tab1" class="tabson">
	  <input type="hidden" id="changeType" value="35" /> 
      <div class="tabson"  style="padding-left:23px;">
       <ul class="seachform" style="overflow:hidden">
       <!-- 
    <li>
            <label>离退休类型：</label>
            <div class="vocation">
		    <select id="changeType" class="select3">
		    <option value="">请选择</option>
		    <option value="31">退休</option>
		    <option value="32">死亡</option>
		    <option value="33">离休</option>
		    <option value="34">离岗</option>
		    <option value="35">病休</option>
		    <option value="36">其他</option>
    		</select>
            </div>
          </li>
           -->
          <li>
            <label>姓名：</label>
            <input id="realName" style="width: 80px;" name="input" type="text" class="scinput" value="" />
          </li>
  <li>
            <label>身份证：</label>
            <input id="idNumber" style="width: 160px" name="input" type="text" class="scinput" value="" />
         </li>
    <!--   
        </ul>
        <ul class="seachform">
    
		   <li>
            <label>离退休年份：</label>
            <div class="vocation">
    <select id="auditCreateDate" class="select3">
    <option value="">请选择</option>
    <option value="2014">2014年</option>
    <option value="2013">2013年</option>
    <option value="2012">2012年</option>
    </select>
            </div>
          </li>
             -->
    <li><label>所在地区：</label>  
    <div class="vocation">
    <input id="areaName"　name="" readonly="readonly" type="text"  value="${areaName}" class="scinput areaSelect"/>
	<input type="hidden" id="areaId" />
	<input type="hidden" id="areaType" />
	<input name="input2" class="btnXuan areaSelect" type="button" value="选 择"/>
    </div>
    </li>
    
    <li>  
    
    </li>
    
    <li>  
    
    </li>
    
    <li>
    <input name="" type="button" onclick="showInfoList();" class="scbtn" value="搜索"/></li>
    
    </ul>      
      </div>
      
      
      <div class="chauxnJS jsTool">
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
        <th width="10%">教师姓名</th>
        <th width="10%">身份证号</th>
        <th width="5%" >性别</th>
        <th width="20%">所在地区</th>
         <th width="8%">操作人</th>
        <th width="10%" >病休时间</th>
        <th width="7%" >状态</th>
		<th width="10%">病休详情</th>
		
        </tr>
        </thead>
        <tbody id="teacherList">
        </tbody>
    </table>
	<!-- 分页 -->
	    <input id="sizePerPage" type="hidden" value="10" name="sizePerPage" />
		<input id="pageIndex" value="1" type="hidden" name="pageIndex" />
		<div id="pagebar" class="pagin">	
		</div>
   <!-- 分页 --> 
   <br>

	<div class="tip2" style="height: 300px; width: 530px;">
							<div class="tiptop2">
								<span>病休详情</span><span>&nbsp;&nbsp;<b
									style="color: #F00;"></b></span><a></a>
							</div>

							<div class="tipinfo"
								style="width: 530px; height: 100px; padding: 10px; margin: 0;">

							</div>
							<Br />

							<div class="tipbtn">
								<input type="hidden" id="teacherId"  />
								<input type="hidden" id="pastProvinceId"  />
								<input type="hidden" id="pastPovinceName"  />
								<input type="hidden" id="pastCityId"  />
								<input type="hidden" id="pastCityName"  />
								<input type="hidden" id="pastDistrictId"  />
								<input type="hidden" id="pastDistrictName"  />
								<input type="hidden" id="pastSchoolId"  />
								<input type="hidden" id="pastSchoolName"  />
								<input type="hidden" id="newProvinceId"  />
								<input type="hidden" id="newProvinceName"  />
								<input type="hidden" id="newCityId"  />
								<input type="hidden" id="newCityName"  />
								<input type="hidden" id="newDistrictId"  />
								<input type="hidden" id="newDistrictName"  />
								<input type="hidden" id="newSchoolId"  />
								<input type="hidden" id="newSchoolName"  />
								<input name="" type="button" class="cancel" value="取消" />
							</div>

						</div>

					</div>

				</div>

			</div>

		</div>

    
    
    
	
<!-- 区域选择 -->
   <%@include file="../common/commonAreaSelect.jsp"%> 
   <script type="text/javascript">
		lastSelect = '${areaType}_${areaId}_${areaName}';
	</script>
	<div class="tip1"
			style="width: 400px; height: 150px; top: 40%; left: 35%">
			<div class="tiptop">
				<span>提示信息</span>
			</div>
			<table style="width: 100%; height: 100%">
				<tr>
					<td align="center">
						<span id="msgHtml"></span>
					</td>
				</tr>
				<tr>
					<td align="center" valign="top" style="height: 60%">
						<input name="" id="toPage" type="button" class="sure1" value="关闭" />

					</td>
				</tr>
			</table>
		</div>
</body>

</html>
