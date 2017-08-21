$(function(){
	SysCode.createSelect("AREA_TYPE", "areaTypeId", "<option value=''>请选择</option>");
	SysCode.createSelect("SCHOOL_TYPE", "schoolTypeId", "<option value=''>请选择</option>");
	SysCode.createSelect("SCHOOL_NATURE", "schoolNatureId", "<option value=''>请选择</option>");
	SysCode.createSelect("SCHOOL_ESTABLIST_TYPE", "schoolEstablishId", "<option value=''>请选择</option>");
})

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}

function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	scontent={
		value:value,
		text:text
	};
	return scontent;
}

function chk() {
	if ($('#schoolProvinceId').val() == "" || $('#schoolCityId').val() == ""
			|| $('#schoolDistrictId').val() == "" || $('#tss').val() == "") {
		$('#msg').html("所在地区不能为空，请选择完整地区信息！");
		return false;
	} else {
		$('#msg').html("")
	}
	if ($('#schoolName').val()=="") {
		$('#msg').html("学校名称不能为空！");
		return false;
	} else {
		$('#msg').html("")
	}
	if ($('#schoolEstablishId').val()=="") {
		$('#msg').html("请选择学校办别！");
		return false;
	} else {
		$('#msg').html("")
	}
	if ($('#schoolTypeId').val()=="") {
		$('#msg').html("请选择学校类型！");
		return false;
	} else {
		$('#msg').html("")
	}
	if ($('#schoolNatureId').val()=="") {
		$('#msg').html("请选择学校性质！");
		return false;
	} else {
		$('#msg').html("")
	}
	if ($('#schoolCode').val()=="") {
		$('#msg').html("学校编码不能为空！");
		return false;
	} else {
		$('#msg').html("")
	}
	return true;
}

function addSchool() {
	if (chk()) {
		var arr_tss = $('#tss').val().split('—');
		var schoolProvinceName = "";
		var schoolCityName = "";
		var schoolDistrictName = "";
		for ( var i = 0; i < arr_tss.length; i++) {
			if (i == 0) {
				schoolProvinceName = arr_tss[0];
			} else if (i == 1) {
				schoolCityName = arr_tss[1];
			} else if (i == 2) {
				schoolDistrictName = arr_tss[2];
			}
		}
		$("#btn").attr('disabled', true);
		$.ajax( {
			url : pathHeader + '/sys/addSchool.do',
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				schoolName : $('#schoolName').val(),
				schoolTypeId : $('#schoolTypeId').val(),
				schoolProvinceId : $('#schoolProvinceId').val(),
				schoolCityId : $('#schoolCityId').val(),
				schoolDistrictId : $('#schoolDistrictId').val(),
				schoolContacts : $('#schoolContacts').val(),
				schoolContactsType : $('#schoolContactsType').val(),
				schoolContactsAddress : $('#schoolContactsAddress').val(),
				schoolProvinceName : schoolProvinceName,
				schoolCityName : schoolCityName,
				schoolDistrictName : schoolDistrictName,
				schoolTypeName:getSelected("schoolTypeId").text,
				schoolEstablishTypeId: $('#schoolEstablishId').val(),
				schoolEstablishName:getSelected("schoolEstablishId").text,
				schoolMemo:$('#schoolMemo').html(),
				schoolNatureId:$('#schoolNatureId').val(),
				schoolNatureName:getSelected("schoolNatureId").text.replace("请选择...",""),
				areaTypeId:$('#areaTypeId').val(),
				areaTypeName:getSelected("areaTypeId").text.replace("请选择...",""),
				schoolCode : $.trim($('#schoolCode').val())
			},
			success : function(data) {
				if (data.success) {
					
					$('#msgHtml').html("保存成功！");
					
					$("#toPage").click(function() {
						 toPage();
					});
	
					$(".tip").fadeIn(200);
				} else {
					if(data.error=="-1" || data.error=="-2"){
						$('#msgHtml').html("学校编码应全部为4-16位数字！");
					}else if(data.error=="-3"){
						$('#msgHtml').html("已经存在该学校编码！");
					}else{
						$('#msgHtml').html("保存失败！");
					}
					$("#btn").attr('disabled', false);
					
					$("#toPage").click(function() {
						 close();
					});
					$(".tip").fadeIn(200);
				}
			},
			error : function() {
				$('#msgHtml').html("保存失败！");
				$("#btn").attr('disabled', false);
				$("#toPage").click(function() {
						 close();
					});
				$(".tip").fadeIn(200);
			}
		});
	}
}

function toPage() {
	window.location.href = pathHeader + "/sys/toSetSchoolPage.htm?click=2";
}

function close() {
	$(".tip").fadeOut(200);
}
