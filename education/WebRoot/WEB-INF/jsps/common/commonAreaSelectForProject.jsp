<%@ page pageEncoding="UTF-8"%>
<%
	String bacepath = request.getContextPath(); 
%>
<script type="text/javascript" src="<%=bacepath%>/javascript/common/commonAreaSelectForProject.js"></script>
<!-- <script type="text/javascript">
	var areaId = ${areaId};
	var areaType = '${areaType}';
	lastSelect = '${areaType}_${areaId}_${areaName}';
</script> -->
   <div class="tip11" id="XXshow" style="display:none;top:200px">
   <div class="tiptop"><span>选择地区</span><a href="#"></a></div>
  <ol class="xuanDQ">
    <li id="selectedPlace">已选：</li>
    <li style="float:right"><a href="###" onclick="if(validateRole()){lastForSure();}" class="souXX">确 定</a></li>
    <li style="float:right"><a href="###" onclick="hisback();" class="souXX">返回上一级</a></li>
  </ol>
  <div class="XXshowContent">
    <div class="XXshowL" id="provinceId">
     </div>
    <div class="XXshowR">
    <!-- 
    <div class="xuan">
    <ul>
      <li><a href="###" onclick="forSure();">确定</a></li>
      <li><a href="###" onclick="hisback();" >返回上一级</a></li>
    </ul>
    <ol class="xuanDQ" id="childCondition" >
    	<li></li>
    </ol>
    </div> -->
    <div class="yincang">
    <p class="zhuyi" style="display: none"><cite style="float:left;">注意：地区权限不够，无法选中上级地区。</cite><cite style="float:right; margin-top:4px; margin-right:5px;"></cite></p>
    <div class="sanji" style="display: none">
    <!-- 
    <table border="0" cellspacing="0" cellpadding="0">
  <tbody><tr  >
    <td id="querySection" width="60">学段：</td>
    <td width="117"><input id="schoolName" name="input5" type="text" class="scinput" style="width:100px;"/></td>
    <td width="71"><a href="###" title="搜索" onclick="querySchool();" class="sou"><img src="/images/fdj.jpg" width="16" height="16"></a></td>
  </tr>
</tbody>
</table> -->
<table border="0" cellspacing="0" cellpadding="0" width="400" style="margin:0 auto; line-height:32px;">
  <tbody id="schoolId">
</tbody></table>

    </div>
    <dl id="cityId" >
    </dl>
    
    </div>  
    </div>
   <div style="clear:both"></div>
  </div>
  </div>
    <br>