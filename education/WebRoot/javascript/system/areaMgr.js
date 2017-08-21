$(function(){
	/*$("#btnAdd").click(function(){
		if($(".hideme").length<1){
			createAddTr();
		}
	});*/
	belong = belong == -1?uu:belong;
	areaList(belong,type);
})

function createArea(){
	
	var url = pathHeader +"/sys/createArea.do";
	var belongCid,belongPid;
	var  areaCo=$("input[name='areaCode']").val();
	var  name=$("input[name='name']").val();
	if(areaCo <=0){
		jQuery.generalAlert("地区编码不能为空");
		return;}
	
	if(name <=0){
		jQuery.generalAlert("地区名称不能为空");
		return;}
//	if(type == "p"){//添加省
//		belongPid = 0;
//		belongCid = 0;
//	}else if(type =="c"){//添加市
//		belongCid = 0;
//		belongPid = belong;
//	}else{//添加区
//		belongCid = belong;
//		belongPid = 0;
//	}
	var $area = {
		areaCode:$("input[name='areaCode']").val(),
		name:$("input[name='name']").val(),
//		belongCityId:belongCid,
//		belongProvinceId:belongPid
		upLvCode:belong,
		type:type
	}
	$.ajax({
		url:url,
		data:{area:$.toJSON($area)},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
			window.location.href = pathHeader + "/sys/toAreaMgrPage.htm?belong="+belong+"&type="+type
			}
			else{
				jQuery.generalAlert("请检查地区编码和地区名称是否已经存在！");
			}
		},
		error:function(){
			
		}
	});
}
function hideAddTr(){
	/*$(".hideme").empty();
	$(".hideme").hide();*/
	$(".hideme").remove();
}
function hideModifyTr(){
	$(".modifyme").empty();
	$(".modifyme").hide();
}

function areaList(belong,type){
	$('#areaList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/sys/areaMgr.do";
	$.ajax({
		url:url,
		data:{
		belong:belong,
		type:type,
		startIndex : pageIndex
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				if(data.areaId == belong){
					$("#back").hide();
				}else{
					$("#back").show();
				}
				var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += createTdHtml(element);
				});
				$('#areaList').append(gridHtml);
				pagination(data, function(){areaList(belong,type);});
			}else{
				var str = "<tr><td colspan='3'>无查询数据</td></tr>";
				$('#areaList').append(str);
			}
			}
		},
		error:function(){
			jQuery.generalAlert("url error");
		}
	});
}

function createTdHtml(obj){
	t = type - 0 +1;
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.areaCode+"</td>";
	if(obj.type == 2){
			gridHtml += "<td>"+obj.name+"</td>";
	}else{
			gridHtml += "<td><a href="+"\"javascript:toAreaPage("+obj.id+","+t+",\'"+obj.name+"\')\">"+obj.name+"</a></td>";
	}
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='modify(\"" + row.id + "\");'>编 辑</a>&nbsp;&nbsp;&nbsp;";
		//returnStr += "<a href='###' class='tablelink' onclick='del(\"" + row.id + "\");'>删 除</a>";
		return returnStr;
	}
}

function toAreaPage(id,t,name){
	window.location.href = pathHeader + "/sys/toAreaMgrPage.htm?belong="+id+"&type="+t
}


function createAddTr(){
	if($(".hideme").length>=1){
		jQuery.generalAlert("请先保存，再次点击添加，谢谢！");
		$(".hideme").length=0;
		return;
	}
	var str = "";
	str += "<tr class='hideme'>";
	str += "<td> <input name='areaCode' type='text' class='scinput' /></td>";
	str += "<td><input name='name' type='text' class='scinput' /></td>";
	str += "<td><a href='javascript:createArea()' class='tablelink click' >保存</a>&nbsp;&nbsp;";
	str+="<a	 href='javascript:hideAddTr()' class='tablelink' id='btnAddCance'>取消</a></td>";
	str += "</tr>";
	$('#areaList').append(str);
}


function createModifyTr(id){
	var str = "";
	str += "<tr class='modifyme'>";
	str += "<td> <input  type='text' class='scinput' id='mCode'/></td>";
	str += "<td><input  type='text' class='scinput' id='mName'/></td>";
	str += "<td><a href='javascript:modifyArea("+id+")' class='tablelink click' >修改</a>&nbsp;&nbsp;";
	str+="<a	 href='javascript:hideModifyTr()' class='tablelink' id='btnAddCance'>取消</a></td>";
	str += "</tr>";
	$('#areaList').append(str);
}
function del(id){
	if(confirm("确认删除该地区？")){
		var url = pathHeader + "/sys/delArea.do"
	$.ajax({
		url:url,
		data:{id:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				areaList(belong,type);
			}else{
				jQuery.generalAlert("地区删除失败！请确认该地区没有被使用！");
			}
		},
		error:function(){
			jQuery.generalAlert("地区删除失败！");
		}
		
	});
	}
}


function modify(id){
	hideModifyTr();
	$("#mId").val(id);
	$(".tip").show();
	//createModifyTr(id);
	var url = pathHeader + "/sys/areaInfo.do";
	$.ajax({
		url:url,
		data:{id:id},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var obj = data.obj;
				$("#mCode").val(obj.areaCode);
				$("#mName").val(obj.name);
			}
		},
		error:function(){
			
		}
		
	});
}

function modifyArea(id){
	var url = pathHeader + "/sys/modifyArea.do";
	if(BasicValidate.isEmpty($("#mCode").val())){
		jQuery.generalAlert("地区编码不能为空！");
		return false;
	}
	
	if(BasicValidate.isEmpty($("#mName").val())){
		jQuery.generalAlert("地区名称不能为空！");
		return false;
	}
	
	$.ajax({
		url:url,
		data:{areaCode:$("#mCode").val(),name:$("#mName").val(),id:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert("修改成功！");
				areaList(belong,type);
				hideMe();
			}
		},
		error:function(){
			
		}
		
		
	});
}

function toImportPage(){
	window.location.href = pathHeader+ "/sys/toImprotAreaPage.htm";
}

function hideMe(){
	$("#mCode").val("");
	$("#mName").val("");
	$(".tip").hide();
}

function modifyA(){
	modifyArea($("#mId").val());
}