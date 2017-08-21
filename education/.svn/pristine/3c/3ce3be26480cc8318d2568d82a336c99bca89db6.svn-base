<%@ page pageEncoding="UTF-8"%>
<%
	String bacepath = request.getContextPath();
	/**
	*	只能选择到 三级
	*	无法选择 学校 
	**/
%>
<script type="text/javascript"
	src="<%=bacepath%>/javascript/common/commonAreaSelectAll.js">
</script>
<script type="text/javascript">
	var areaId = '${areaId}';
	var areaType = '${areaType}';
	var areaName = '${areaName}';
	lastSelect = '${areaType}_${areaId}_${areaName}';
</script>
<div class="tip11" id="XXshow" style="display: none;">
	<div class="tiptop">
		<span>选择地区</span><a href="#"></a>
	</div>
	<ol class="xuanDQ">
		<li id="selectedPlace">
			已选：
		</li>
		<li style="float: right">
			<a href="###" onclick="lastForSureCl();" class="souXX">确 定</a>
		</li>
		<li style="float: right">
			<a href="###" onclick="hisback();" class="souXX">返回上一级</a>
		</li>
	</ol>
	<div class="XXshowContent">
		<div class="XXshowL" id="provinceId">
		</div>
		<div class="XXshowR">

			<div class="yincang">
				<div class="sanji" style="display: none">
					<table border="0" cellspacing="0" cellpadding="0" width="400"
						style="margin: 0 auto; line-height: 32px;">
						<tbody id="schoolId">
						</tbody>
					</table>

				</div>
				<dl id="cityId">
				</dl>

			</div>
		</div>
		<div style="clear: both"></div>
	</div>
</div>