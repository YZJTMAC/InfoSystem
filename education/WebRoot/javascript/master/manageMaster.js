$(function(){
	queryList();
	initSelectClass();
});

/**
 * 批量创建专家账号
 */
function createMaster(){
	var masterNum = $("#masterNum").val();
	var url = pathHeader + "/master/createMaster.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			comparisonId:comparisonId,
			masterNum:masterNum,
			roleId:40
		},
		success:function(data){
			if(data.success){
				hideMe();
				queryList();
			}
			jQuery.generalAlert(data.message);	
		},
		error:function(){
			jQuery.generalAlert("删除错误");	
		}
	});
}

/**
 * 查询列表
 */
function queryList(){
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	var url = pathHeader + "/master/queryComparisonMaster.do";
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			comparisonId:comparisonId,
			roleId:41,
			startIndex:startIndex,
			pageSize:pageSize
		},
		beforeSend: function(){
			$('#queryList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#queryList').html(gridHtml);
				pagination(data, function(){queryList()});
				initSelectClass();
			}else{
				$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
				pagination(data, function(){queryList()});
			}
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
	});
}

/**
 * 添加数据
 */
function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.masterName+"</td>";
		gridHtml += "<td>"+obj.loginAccount+"</td>";
		gridHtml += "<td>"+obj.password+"</td>";
		gridHtml += "<td>"+obj.comparisonName+"</td>";
		gridHtml += "<td><a class='huibtn_a' onclick='toJudgeDetail(\"" + obj.id + "\");'>查看评分</a>&nbsp;</td>";
		gridHtml+= "</tr>";
	return gridHtml;
}

function toJudgeDetail(masterId){

	var url =  pathHeader + "/master/toJudgeDetail.htm?click=111&masterId="+masterId+"&comparisonId="+comparisonId;
	window.location.href=url;

}

/**
 * 对项目设置专家
 */
function toSetMaster(){
//	$("#showCheck").css("display","block");
	var url = pathHeader + "/master/queryMaster.do";
	$.ajax({
		url:url,
		data:{
			comparisonId: comparisonId
		},
		type:"post",
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var girdHtml = "<tr >";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					if(obj.isCheck != null){
						girdHtml +="<td><input style='margin-left:10px' id='checkMaster' type='checkbox' value='"+obj.id+"' checked='checked'>&nbsp"+obj.masterName+"</td>";
					}else{
						girdHtml +="<td><input style='margin-left:10px' id='checkMaster' type='checkbox' value='"+obj.id+"' >&nbsp"+obj.masterName+"</td>";
					}
					if( i != 0 && ((i+1)%5) == 0){
						girdHtml +="</tr><tr>"
					}
				}
				girdHtml +="</tr>";
				$("#showCheck").html(girdHtml);
			}
			isChecked();
		},
		error:function(){
			
		}
	});

	$(".tip2").show();
}

/**
 * 获取选中的活动
 * @returns {Array}
 */
function getValues(){
	var ids = $("input[id='checkMaster']:checked");
	var comparisonIds = new Array();
	for(var i = 0 ; i < ids.length ; i++){
		comparisonIds.push(ids[i].value);
	}
	return comparisonIds;
}

/**
 * 位活动分配教师
 */
function saveMasterToComparison(){
	var ids = getValues().join(",");
	var url = pathHeader + "/master/saveMasterToComparison.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			comparisonId:comparisonId,
			masterIds:ids
		},
		success:function(data){
			hideMe();
			jQuery.generalAlert(data.message);
			queryList();
		},
		error:function(){
		}
	});
}

/**
 * 显示添加专家界面（逐个）
 */
function toCreateMaster(){
	$(".tip").show();
}

/**
 * 隐藏添加专家界面（逐个）
 */
function hideMe(){
	$(".tip").hide();
	$(".tip2").hide();
}

function initSelectClass(){
	$(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
}