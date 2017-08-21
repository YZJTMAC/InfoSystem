$(function(){
	queryList();
	initSelectClass();
});

/**
 * 打开添加专家窗口（逐条）
 */
function toCreateMaster(){

	$("#saveBtn").css('display','block');
	$("#updateBtn").css('display','none');
	$("#imageSrcTemp").val("");
	$("#masterName").val("");
	$("#loginAccount").val("");
	$("#password").val("");
	$("#photoTemp").attr("src", ""+pathHeader+"/static/photo/teacher_default.png");
	var top = $(window).height()  ;
	setPosition("masterTip");	
	$(".tip2").show();
}

/**
 * 隐藏功能页
 */
function hideMe(){
	$(".tip").hide();
	$(".tip2").hide();
}

/**
 * 查询列表
 */
function queryList(){
	var loginAccount = $("#loginAccountQuery").val();
	var masterName = $("#masterNameQuery").val();
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	
	var url = pathHeader + "/master/queryComparisonMaster.do";
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			roleId:41,
			masterName:masterName,
			loginAccount:loginAccount,
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
 * 显示数据
 */
function getObjHtml(obj){
	var gridHtml = "<tr>";
	if(obj.masterImg != null && obj.masterImg != ""){
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;' src='"+pathHeader+"/uploadFile/"+obj.masterImg+"' title='头像' /></td>";
	}else{
		gridHtml += "<td><img id='masterPhoto'  style='height: 99px; width:71px;' src='"+pathHeader+"/static/photo/teacher_default.png' title='头像' /></td>";
	}
	gridHtml += "<td>"+obj.masterName+"</td>";
	gridHtml += "<td>"+obj.loginAccount+"</td>";
	gridHtml += "<td>"+obj.password+"</td>";
	gridHtml += "<td>"+obj.comparisonName+"</td>";
	gridHtml += "<td>"+getOperate(obj.id, obj.status)+"</td>";
	gridHtml+= "</tr>";
	return gridHtml;
}

/**
 * 操作数据
 */
function getOperate(id, status){
	var op = "";
	if(status == 44){//创建完未开始
		op += "<a class='huibtn_a' onclick='setMasterStatus(\"" + id + "\",8);'>启 用</a>&nbsp;";
	}else if(status == 8){
		op += "<a  class='huibtn_a' onclick='setMasterStatus(\"" + id + "\",44);'>禁 用</a>&nbsp;";
		op += "<a class='huibtn_a' onclick='setComparison(\"" + id + "\");'>设 置</a>&nbsp;";
	}
	op += "<a class='huibtn_a' onclick='toUpdateMaster(\"" + id + "\");'>编 辑</a>&nbsp;";
	op += "<a class='huibtn_a' onclick='setMasterStatus(\"" + id + "\",0);'>删 除</a>&nbsp;";
	return op;
}

/**
 * 保存逐条添加的专家
 */
function saveMaster(){
	initCheck();
	var imageSrcTemp = $("#imageSrcTemp").val();
	var masterName = $("#masterName").val();
	var loginAccount = $("#loginAccount").val();
	var password = $("#password").val();
	//数据检测
	if(checkNull(masterName)){
		$("#masterNameError").html("专家名不能为空");
		return;
	}
	if(checkNull(loginAccount)){
		$("#loginAccountError").html("用户名不能为空");
		return ;
	}
	if(checkNull(password)){
		$("#passwordError").html("密码不能为空");
		return ;
	}
	var url = pathHeader + "/master/createMasterOne.do";
	$.ajax({
		url:url,
		data:{
			masterImg:imageSrcTemp,
			masterName:masterName,
			loginAccount:loginAccount,
			password:password,
			roleId:41
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				hideMe();
				queryList();
				jQuery.generalAlert(data.message);
			}else{
				$("#loginAccountError").html(data.message);
			}
		},
		error:function(){
		}
	});
}

/**
 * 初始化错误框
 */
function initCheck(){
	$("#masterNameError").html("");
	$("#loginAccountError").html("");
	$("#passwordError").html("");
}

/**
 * 检测是否为空
 */
function checkNull(obj){
	if(obj  == null || obj == ""){
		return true;
	}
	return false;
}

/**
 * 打开对专家设置评审活动页
 */
var mId;
function setComparison(id){
	setPosition("setTip");
	mId = id;
	queryComparison();
	$(".tip").show();
}

/**
 * 查找专家可以评审的活动
 */
function queryComparison(){
	$("#showCheck").css("display","block");
	var url = pathHeader + "/master/queryComparisonCheck.do";
	$.ajax({
		url:url,
		data:{
			status: 1,
			masterId:mId
		},
		type:"post",
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var girdHtml = "<tr >";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					if(obj.isCheck){
						girdHtml +="<td><input style='margin-left:10px' id='checkComparison' type='checkbox' value='"+obj.id+"' checked='checked'>&nbsp"+obj.comparisonName+"</td>";
					}else{
						girdHtml +="<td><input style='margin-left:10px' id='checkComparison' type='checkbox' value='"+obj.id+"' >&nbsp"+obj.comparisonName+"</td>";
					}
					if( i != 0 && ((i+1)%3) == 0){
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
}

/**
 * 获取选中的活动
 * @returns {Array}
 */
function getValues(){
	var ids = $("input[id='checkComparison']:checked");
	var comparisonIds = new Array();
	for(var i = 0 ; i < ids.length ; i++){
		comparisonIds.push(ids[i].value);
	}
	return comparisonIds;
}

/**
 * 将活动分配给教师
 */
function saveComparisonToMaster(){
	var ids = getValues().join(",");
	var url = pathHeader + "/master/saveComparisonToMaster.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			masterId:mId,
			comparisonIds:ids
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
 * 用户上传图片
 */
function uploadPhotoFile(){
	// 获取上传文件名
	var filePath = $('#photoFile').val();
	var ext = filePath.substring(filePath.lastIndexOf('.') + 1, filePath.length).toLowerCase();
	if (ext !="png" && ext !="jpg" && ext !="bmp" && ext !="gif") {
		jQuery.generalAlert("上传头像不支持该格式!");
		return;
	}
	$.ajaxFileUpload({
		//需要链接到服务器地址
        url:pathHeader + '/sys/uploadUserPhoto.do',
        secureuri:false,
        fileElementId:'photoFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        data : {'upload': 'first', 'savePath':''},
		success:function(data){
			if(data.success){
				var src = data.filePath;
				$("#photoTemp").attr("src", imageServer + src);
				$("#imageSrcTemp").val(src);
			} else {
				jQuery.generalAlert("上传失败");
			}
		},
		error:function(){
		}
	});
}

/**
 * 设置专家状态
 */
function setMasterStatus(id,status){
	var url = pathHeader + "/master/setMasterStatus.do";
	$.ajax({
		url:url,
		data:{
			id:id,
			status:status
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				queryList();
			}
			jQuery.generalAlert(data.message);
		},
		error:function(){
		}
	});

}

/**
 * 到修改专家界面
 */
function toUpdateMaster(id){
	setPosition("masterTip");
	$("#saveBtn").css('display','none');
	$("#updateBtn").css('display','block');
	var url = pathHeader + "/master/queryComparisonMaster.do";
	$.ajax({
		url:url,
		data:{
			masterId: id,
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = data.rows[0];
				$("#masterName").val(obj.masterName);
				$("#loginAccount").val(obj.loginAccount);
				$("#password").val(obj.password);
				if(obj.masterImg == "" || obj.masterImg == null){
					$("#photoTemp").attr("src", pathHeader+"/static/photo/teacher_default.png");
				}else{
					$("#photoTemp").attr("src", pathHeader+"/uploadFile/"+obj.masterImg);
				}
				
				mId = obj.id;
			}
			$(".tip2").show();
		},
		error:function(){
		}
	});
}

/**
 * 修改专家
 */
function updateMaster(){
	$("#saveBtn").css('display','none');
	$("#updateBtn").css('display','block');
	initCheck();
	var imageSrcTemp = $("#imageSrcTemp").val();
	var masterName = $("#masterName").val();
	var loginAccount = $("#loginAccount").val();
	var password = $("#password").val();
	//数据检测
	if(checkNull(masterName)){
		$("#masterNameError").html("专家名不能为空");
		return false;
	}
	if(checkNull(loginAccount)){
		$("#loginAccountError").html("用户名不能为空");
		return false;
	}
	if(checkNull(password)){
		$("#passwordError").html("密码不能为空");
		return false;
	}
	var url = pathHeader + "/master/updateMasterOne.do";
	$.ajax({
		url:url,
		data:{
			masterId:mId,
			masterImg:imageSrcTemp,
			masterName:masterName,
			loginAccount:loginAccount,
			password:password
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				hideMe();
				queryList();
				jQuery.generalAlert(data.message);
			}else{
				$("#loginAccountError").html(data.message);
			}
		},
		error:function(){
		}
	});
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

function setPosition(tipName){
	var firstDiv=document.getElementById(tipName);
	var top = document.documentElement.scrollTop + "px";
	firstDiv.style.marginTop = top;
}