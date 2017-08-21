
function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#schoolId2').val("");
	$('#schoolName2').val("");
	$('#tss').val("");
}

function getSelected(sid) {
	var value, text;
	text = $("#" + sid + " option:selected").text();
	value = $("#" + sid).val();
	scontent = {
		value : value,
		text : text
	};
	return scontent;
}


function selectRole() {
	var roleId = $("#roleId option:selected").attr("id");
	if (roleId != "" && roleId != "0") {
		$("#sel").attr('disabled', false);
	} else {
		$("#sel").attr('disabled', true);
	}
	if (roleId == "4") {
		$("#schoolName2").attr('disabled', false);
	} else {
		$("#schoolName2").attr('disabled', true);
	}
	if(roleId=="0"){
		clearPCD();
	}
}


function chk() {
	//var roleId = $("#roleId option:selected").attr("id");
	var roleId = $("#roleId").val();
	if (roleId == "") {
		$('#msg').html("请选择角色！");
		return false;
	} else {
		$('#msg').html("")
	}
	if (roleId != "0" && $('#schoolProvinceId').val() == ""
			&& $('#schoolCityId').val() == ""
			&& $('#schoolDistrictId').val() == "" && $('#tss').val() == "") {
		$('#msg').html("所在地区不能为空！");
		return false;
	} else {
		$('#msg').html("")
	}
	//如果是校管理员。必须选学校
	if (roleId == "4" && $('#schoolId2').val() == "") {
		$('#msg').html("学校不能为空！");
		return false;
	} else {
		$('#msg').html("");
	}
	if ($('#loginAccount').val() == "") {
		$('#msg').html("用户名不能为空！");
		return false;
	} else {
		$('#msg').html("");
	}
	if ($('#password').val() == "") {
		$('#msg').html("密码不能为空！");
		return false;
	} else {
		$('#msg').html("");
	}
	
	return true;
}

function modifyManages() {
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
			url : pathHeader + '/person/modifyManages.do',
			type : "POST",
			cache : "false",
			async : "true",
			dataType : "json",
			data : {
				id : id,
				roleId : $('#roleId').val(),
				loginAccount : $('#loginAccount').val(),
				password : $('#password').val(),
				realName : $('#realName').val(),
				gender : $('#gender').val(),
				idNumber : $('#idNumber').val(),
				mobile : $('#mobile').val(),
				status : $('#status').val(),
				userProvinceId : $('#schoolProvinceId').val(),
				userCityId : $('#schoolCityId').val(),
				userDistrictId : $('#schoolDistrictId').val(),
				userProvinceName : schoolProvinceName,
				userCityName : schoolCityName,
				userDistrictName : schoolDistrictName,
				mail : $('#mail').val(),
				userAddress : $('#userAddress').val(),
				schoolId : $("#schoolId2").val(),
				isPassword : $("#isPassword").val(),
				oldLoginAccount : $("#oldLoginAccount").val()
			},
			success : function(data) {
				if (data.success) {

					$('#msgHtml').html("保存成功！");

					$("#toPage").click(function() {
						toPage();
					});

					$(".tip").fadeIn(200);
				} else if (data.flag == "-4") {
					$('#msgHtml').html(
							"帐号【" + $('#loginAccount').val() + "】已存在！");
					$("#btn").attr('disabled', false);
					$("#toPage").click(function() {
						close();
					});
					$(".tip").fadeIn(200);
				} else {
					$('#msgHtml').html("保存失败！");
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
	window.location.href = pathHeader + "/person/toManagesPage.htm?click=444";
}

function close() {
	$(".tip").fadeOut(200);
}

function lastForSure() {
	var roleId = $("#roleId option:selected").attr("id");
	var str = "";
	var tempArray = chilkQueryConditionArray;
	$(tempArray).each(function(index, element) {
		if (element != null && element.length > 0) {
			var temp = element.split("_");
			if (temp[1] == "provinceId") {
				$("#schoolProvinceId").val(temp[0]);
				str = temp[2];
			} else if (temp[1] == "cityId") {
				$("#schoolCityId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "districtId") {
				$("#schoolDistrictId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "schoolId") {
				if (roleId == "4") {
					if (temp[0] != undefined) {
						$("#schoolId2").val(temp[0]);
					}
					$("#schoolName2").val(temp[2]);
				}
			}

		}
	})

	$('#tss').val(str);

	clear();
}

//验证是否具有显示权限
function xianshi(roleId) {
		if(roleId == 1) {
				$('#glyuan').hide();
		}
		if(roleId == 2) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#shengssjggly').hide();
		}
		if(roleId == 3) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();
		}
			
			
		if(roleId == 4) {
			$('#glyuan').hide();
			$('#sgly').hide();
			$('#gly').hide();
			$('#qgly').hide();
			$('#cpjggly').hide();
			$('#shengssjggly').hide();
			$('#shissjggly').hide();
			$('#qussjggly').hide();
		
		}

		if(roleId == 6) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();

  		}
		
		if(roleId == 7) {
			$(document).ready(function(){
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
		});

  		}
		
		
		if(roleId == 8) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();

  		}
		if(roleId == 9) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();

  		}
		if(roleId == 10) {
				$('#glyuan').hide();
				$('#sgly').hide();
				$('#gly').hide();
				$('#qgly').hide();
				$('#xgly').hide();
				$('#shengssjggly').hide();
				$('#shissjggly').hide();
				$('#qussjggly').hide();

  		}
	
	return true;
}

