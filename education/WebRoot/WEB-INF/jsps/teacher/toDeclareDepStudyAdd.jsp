<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>自主研修添加</title>

<%@include file="../common/commonHead.jsp"%>
<link />
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/dateFormat.js"></script> 
<script type="text/javascript" src="<%=basePathHeader%>/javascript/common/pagination.js"></script>
<script type="text/javascript" src="<%=basePathHeader%>/javascript/teacher/toDeclareDepStudyAdd.js"></script>
<style>
	table,table tr th, table tr td { border:1px solid #000000;  text-align: center;}
</style>
</head>

<body>
	<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="furtheredu" name="flag" />
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
		    	<li><a href="#">继教信息</a></li>
		    	<li><a href="#">学分银行</a></li>
		    	<li><a href="#">学分借贷</a></li>
		    	<li><a href="#">借贷学分</a></li>
		    </ul>
    	</div>
    	<div class="formbody">
      		<div >
    			<ul class="seachform" >
		        	<li id="lendYearInsert" >
						<label>
							<font style="color: red">*</font>申请年度：
						</label>
						<div class="vocation" >
		        			<select name="select" class="select2 yearpicker" id="yearInsert" >
							</select>
						</div>
						&nbsp;&nbsp;
						<font color="red">只能选择本年度 </font>
					</li>
	        	</ul>
	        	<ul class="seachform" >
	        		<li id= "lendReasonInsert">
						<label>
							<font style="color: red">*</font>研修类型：
						</label>
						<div class="vocation">
		        			<select name="select" class="select2" id="studyType" onchange="showUp()"></select>
		        		</div>
					</li>
	        	</ul>
	        	<!-- 援教支教 -->
	        	<div style="display: none;" id="vtBox">
	        	<ul class="seachform" >
	        		<li>
	        		教育行政部门安排到民族地区、贫困地区援教，深入农村基层学校全职支教的教师，每半年分别记2学分和1学分。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>支教地区：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="vtArea" >
							<option value="2">民族地区</option>
							<option value="1">贫困地区</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
					<li>
						<label>
							<font style="color: red">*</font>支教时间：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="vtTime" >
							<option value="1">半年</option>
							<option value="2">一年</option>
						</select>
		        		</div>
					</li>
	        	</ul>
	        	</div>
	        	<!-- 学历提升 -->
	        	<div style="display: none;" id="irsBox">
	        	<ul class="seachform" >
	        		<li>
	        		在职教师参加对口学历提高培训，取得学历证书者，本科记3学分，硕士记5分，博士记8分。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>获得学位：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="irsCertificate" >
							<option value="3">学士学位</option>
							<option value="5">硕士学位</option>
							<option value="8">博士学位</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>
				<!-- 论文评选 -->
	        	<div style="display: none;" id="psBox">
	        	<ul class="seachform" style="height: 100px">
	        		<table id="psRules" >
	        			<tr>
	        				<td></td><td>一等</td><td>二等</td><td>三等</td>
	        			</tr>
	        			<tr>
	        				<td>县市级</td><td>1</td><td>0</td><td>0</td>
	        			</tr>
	        			<tr>
	        				<td>省级</td><td>2</td><td>1</td><td>0</td>
	        			</tr>
	        			<tr>
	        				<td>国家级</td><td>3</td><td>2</td><td>1</td>
	        			</tr>
	        		</table>	
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>评选地域：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="psArea" >
							<option value="2">国家级</option>
							<option value="1">省级</option>
							<option value="0">县市级</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>评选等级：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="psLevel" >
							<option value="1">一等</option>
							<option value="0">二等</option>
							<option value="-1">三等</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>	
	        	<!-- 论文发表 -->
	        	<div style="display: none;" id="ppBox">
	        	<ul class="seachform" >
	        		<li>
	        		在国家级、省级、市级正规教育类报纸、期刊发表教育论文，分别记4、3、1学分。非教育类报纸、期刊，或发表非教育类论文，不计分。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>期刊类型：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="ppType" >
							<option value="4">国家级</option>
							<option value="3">省级</option>
							<option value="1">县市级</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>	      
	        	<!-- 教育科研 -->
	        	<div style="display: none;" id="esrBox">
	        	<ul class="seachform" >
	        		<li>
	        		主持或参与国家、省、市、县级教育科研项目，课题结题当年，课题牵头人分别记4、3、2、1学分。课题牵头人不止一人时，学分平分。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>项目类型：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="esrType" >
							<option value="4">国家级</option>
							<option value="3">省级</option>
							<option value="2">市级</option>
							<option value="1">县级</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>参研人数：
						</label>
						<div class="vocation">
		        			<input type="text" id="esrPepleNum"  class="scinput" />
		        		</div>
					</li>
				</ul>
	        	</div>	        	
	        	<!-- 教学竞赛 -->
	        	<div style="display: none;" id="tcBox">
	        	<ul class="seachform" style="height: 150px">
	        		<table id="psRules" >
	        			<tr>
	        				<td>级别</td><td>一等</td><td>二等</td><td>三等</td>
	        			</tr>
	        			<tr>
	        				<td>校级</td><td>1</td><td>0.5</td><td>0</td>
	        			</tr>
	        			<tr>
	        				<td>学区</td><td>1.5</td><td>1</td><td>0.5</td>
	        			</tr>
	        			<tr>
	        				<td>县级</td><td>2</td><td>1.5</td><td>1</td>
	        			</tr>
	        			<tr>
	        				<td>市级</td><td>2.5</td><td>2</td><td>1.5</td>
	        			</tr>
	        			<tr>
	        				<td>省级</td><td>3</td><td>2.5</td><td>2</td>
	        			</tr>
	        			<tr>
	        				<td>国家</td><td>5</td><td>4.5</td><td>4</td>
	        			</tr>
	        		</table>	
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>项目类型：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="tcType" >
							<option value="4">国家级</option>
							<option value="2">省级</option>
							<option value="1.5">市级</option>
							<option value="1">县级</option>
							<option value="0.5">学区级</option>
							<option value="0">校级</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>评选等级：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="tcLevel" >
							<option value="1">一等</option>
							<option value="0.5">二等</option>
							<option value="0">三等</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>	 
	        	<!-- 培训专家 -->
	        	<div style="display: none;" id="teBox">
	        	<ul class="seachform" style="height: 100px">
	        		<table id="psRules" >
	        			<tr>
	        				<td>级别</td><td>首席专家</td><td>一般专家</td><td>辅导教师</td>
	        			</tr>
	        			<tr>
	        				<td>县培项目</td><td>3</td><td>2</td><td>0.5</td>
	        			</tr>
	        			<tr>
	        				<td>省陪项目</td><td>4</td><td>3</td><td>1</td>
	        			</tr>
	        			<tr>
	        				<td>国培项目</td><td>5</td><td>4</td><td>2</td>
	        			</tr>
	        		</table>	
				</ul>
	        	<ul class="seachform" >
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>项目类型：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="teType" >
							<option value="3">首席专家</option>
							<option value="2">一般专家</option>
							<option value="0">辅导教师</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>评选等级：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="teLevel" >
							<option value="2">国培项目</option>
							<option value="1">省培项目</option>
							<option value="0">县培项目</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>	
	        	<!-- 送培送教 -->
	        	<div style="display: none;" id="cctBox">
	        	<ul class="seachform" >
	        		<li>
	        		在各级教师培训机构举办的送教下乡、送培到校培训项目中担任课程专家、辅导员、管理员，名优教师、骨干教师承担送教下乡、专题讲座<br/>
					</li>
				</ul>
				<ul class="seachform" >
					<li>
	        		、示范课教学等，按承担任务的实际学时计算，每半天记1学分。不足半天的，按每节课0.25学分计算。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>参与时长：
						</label>
						<div class="vocation">
		        			<input type="text" id="cctDay"  class="scinput" />/半天（每半天计1）
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>参与课节：
						</label>
						<div class="vocation">
		        			<input type="text" id="cctClass"  class="scinput" value="0"/>/节课（剩余时长不足半天时按课节计算，请输入几节课。）
		        		</div>
					</li>
				</ul>
	        	</div>	 
	        	<!-- 指导教师 -->
	        	<div style="display: none;" id="ttBox">
	        	<ul class="seachform" >
	        		<li>
	        		担任县级或县级以下教师专业竞赛类评委、中小学教师职称评委、大中专院校应届毕业生实习指导教师者，每次计2学分。
					</li>
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
						
							<font style="color: red">*</font>参加次数：
						</label>
						<div class="vocation">
		        			<input type="text" id="ttNum"  class="scinput" />/次
		        		</div>
					</li>
				</ul>
	        	</div>	 
	        	<!-- 名师工作坊 -->
	        	<div style="display: none;" id="twBox">
	        	<ul class="seachform" style="height: 80px">
	        		<table id="psRules" >
	        			<tr>
	        				<td>类别</td><td>省级名师工作室</td><td>市级名师工作室</td><td>县级名师工作室</td><td>网络研修工作坊</td>
	        			</tr>
	        			<tr>
	        				<td>首席/主持人</td><td>6</td><td>4</td><td>3</td><td>2</td>
	        			</tr>
	        			<tr>
	        				<td>成员</td><td>4</td><td>3</td><td>2</td><td>0</td>
	        			</tr>
	        		</table>	
				</ul>
	        	<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>参加身份：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="twType" >
							<option value="2">首席/主持人</option>
							<option value="1">成员</option>
						</select>
		        		</div>
					</li>
				</ul>
				<ul class="seachform" >
	        		<li>
						<label>
							<font style="color: red">*</font>参加类型：
						</label>
						<div class="vocation">
						<select name="select" class="select2" id="twLevel" >
							<option value="4">省级名师工作室</option>
							<option value="2">市级名师工作室</option>
							<option value="1">县级名师工作室</option>
							<option value="0">网络研修工作坊</option>
						</select>
		        		</div>
					</li>
				</ul>
	        	</div>
	        	<!-- 学分专员 -->
	        	<div style="display: none;" id="oBox">
	        	<ul class="seachform" >
	        		<li>
						县、校（园）两级学分专员，任职期间，自主研修项目每年加５分。
					</li>
				</ul>
	        	</div>
	        	<form action="" id="proForm" enctype="multipart/form-data" method="post">
					<input type="hidden" name = "isYear" />	        
					<input type="hidden" name = "isAnnotation"/>	        
					<input type="hidden" name = "isStudyTypeId"/>	        
					<input type="hidden" name = "isStudyTypeName"/>	        
					<input type="hidden" name = "isCredit"/>	        		
					<table border="0" cellspacing="0" cellpadding="0" style="line-height:40px;width: 500px">
		        		<tbody id="files">
							<tr>
								<td width="84" colspan="2" ><b>上传附件：</b>【支持上传图片，文本文件，OFFICE 文档，压缩包等】&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:addMore()">添加</a></td>
							</tr>
		        			<tr>
		          				<td width="260" colspan="2"><input type="file" name="file"/><a href="###" onclick="removeMe(this)">删除</a></td>
		 					</tr>
		        		</tbody>
		      		</table>
	      		</form>
	      		<ul class="seachform" >
		        	<li>
		        	</li>
		        </ul>
	        	<ul class="seachform" >
		        	<li>
		        		<input  id="apply_credit" type="button"  class="sure" value="申请"  onclick="insert()" />&nbsp;
		        	</li>
		        	<li>
		        		<input  type="button"  class="cancel" value="取消" onclick="javascript:window.history.back();"/>
		        	</li>
		        </ul>
		</div>
	</div>
	
</body>
</html>
