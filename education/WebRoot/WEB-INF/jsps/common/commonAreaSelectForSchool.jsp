<%@ page pageEncoding="UTF-8"%>
<%
	String bacepath = request.getContextPath(); 
%>
<script type="text/javascript" src="<%=bacepath%>/javascript/jquery.url.js"></script>
<script type="text/javascript" src="<%=bacepath%>/javascript/common/commonAreaSelectForSchool.js"></script>

   <div class="tip11" id="XXshow" style="display:none;">
   <div class="tiptop"><span>选择地区</span><a href="#"></a></div>
  <ol class="xuanDQ">
    <li id="selectedPlace">已选：</li>
    <li style="float:right"><a href="###" onclick="lastForSure();" class="souXX">确 定</a></li>
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
    <!-- <p class="zhuyi"><cite style="float:left;">注意点击选中，双击进入。</cite><cite style="float:right; margin-top:4px; margin-right:5px;"><a href="#" title="删除"><img src="images/closed2.jpg" width="9" height="9"></a></cite></p> -->
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