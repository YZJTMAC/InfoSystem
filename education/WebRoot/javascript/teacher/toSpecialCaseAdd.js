var projectMap = {};
$(function(){
	initStudyType(projectMap);
	initSelectClass();
})

/**
 * 初始化申请原因
 */
function initStudyType(map){
	$("#specialCase").html("");
	var url = pathHeader + "/teacher/teacherProject/getSpecialProject.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#specialCase").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					map[value.id] = value.projectNo;
					$("#specialCase").append(
							"<option  value=\"" + value.id + "\">"
							+ value.projectName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
}


function showUp(){
	disapear();
	if(projectMap[$("#specialCase").val()] == 1){//退休
		$("#aBox").css("display","block");
	}else if(projectMap[$("#specialCase").val()] == 2){//孕期
		$("#bBox").css("display","block");
	}else if(projectMap[$("#specialCase").val()] == 3){//哺乳期
		$("#cBox").css("display","block");
	}else if(projectMap[$("#specialCase").val()] == 4){//局直事业单位
		$("#dBox").css("display","block");
	}
}

function disapear(){
	$("#aBox").css("display","none");
	$("#bBox").css("display","none");
	$("#cBox").css("display","none");
	$("#dBox").css("display","none");
}



///**
// * 新增
// */
function insert(){
	$("input[name='projectId']").val($("#specialCase").val());//申请类型
	$("input[name='createDate1']").val($("#yearInsert").val());//申请年度

	if(checkout()){
		var url = pathHeader + "/teacher/teacherProject/addSpecialCase.do";
		$("#proForm").ajaxSubmit({
			url:url,
			async:false,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.success){
					urlGo=pathHeader +"/teacher/teacherProject/toSpecialCase.htm?click=33";	
					jQuery.generalAlertAndJump(data.message,urlGo);
				}else{
					jQuery.generalAlert(data.message);
				}
			},
			error:function(){
				jQuery.generalAlert("新增失败");
			}
		});
	}
	
}

/**
 * 校验
 * @param from
 * @returns {Boolean}
 */
function checkout(){
	if($("#specialCase").val() == ""){
		jQuery.generalAlert("请选择申请类型");
		return false;
	}
	return true;
}

function removeMe(o){
	$(o).parent().remove();
}
function addMore(){
	var tr = "<tr><td width='260' colspan='2'><input type='file' name='file'/><a href='###' onclick='removeMe(this)'>删除</a></td></tr>";
	$("#files").append(tr);
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
	$(".select4").uedSelect({
		width : 100
	});
}