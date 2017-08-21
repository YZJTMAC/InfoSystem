var getId;

var codeFlag = true;
var dictionNameFlag = true;
var dictionaryTypeNames = "";
var oldNames = "";
var oldCodes = "";
$(function() {
	showList();
	// 条件查询
	$("#select").click(function() {
		showList();
	});
	$(".sure2").click(function() {
		var ifGo = false;
		var dictionName = $("#dictionName").val();
		var dictionCode = $("#dictionCode").val();
		//		var dictionnaryLeixin = $("#dictionnaryLeixin").val;
			/**
			 * 编辑验证编码、名称是否重复
			 * @param {Object} data
			 */
			var urlGo = pathHeader
					+ "/dictionary/dictionaryManages/verifyDictionary.do";
			$.ajax( {
				url : urlGo,
				type : "post",
				data : {
					dictionnaryTypeName : dictionaryTypeNames,
					dictionName : dictionName,
					dictionCode : dictionCode,
					oldName : oldNames,
					oldCode : oldCodes
				},
				async : false,
				success : function(data) {
					if (data.success) {}
					else{
						$('#dictionCode2Error').html("");
						$('#dictionName2Error').html("")
						if (data.codeOk) {
							$('#dictionCode2Error').html("编码已存在！");
							ifGo = true;
							return;
						}
						if(data.statusOk){
							$('#dictionName2Error').html("该字典名称已禁用，请启用！")
							ifGo = true;
							return;
						}
						if (data.nameOk) {
							$('#dictionName2Error').html("名称已存在！")
							ifGo = true;
							return;
						}
					}
				},
				error : function() {
					jQuery.generalAlert("url error!");
				}
			});
			if (ifGo) {
				return false;
			}
			var url = pathHeader
					+ "/dictionary/dictionaryManages/editDictionary.do";
			$.ajax( {
				url : url,
				type : "post",
				data : {
					id : getId,
					dictionName : dictionName,
					dictionCode : dictionCode
				},
				async : true,
				success : function(data) {
					if (data.success) {
						window.location.reload();
						//				  showList();
				$(".tip2").fadeOut(100);
			}
		},
		error : function() {
			jQuery.generalAlert("url error!");
		}
			});
	});
	
	$(".select2").uedSelect( {
		width : 167
	});
	$(".select3").uedSelect( {
		width : 100
	});
	$(".btn_add").click(function() {
		$(".tip").fadeIn(200);
	});
	
	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});
	
	$(".tiptop2 a").click(function() {
		$(".tip2").fadeOut(200);
	});
	
	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	
	$(".cancel2").click(function() {
		$(".tip2").fadeOut(100);
	});
});

function showList() {
	$('#dictionary_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax( {
				url : pathHeader + '/dictionary/dictionaryManages/dictionaryList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					dictionaryTypeId : $('#dictionaryTypeId').val(),
					status: $('#status').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$("#counts").html(data.total);
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});

						$('#dictionary_list').append(gridHtml);
						pagination(data, function() {
							showList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
						$('#dictionary_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
					$('#dictionary_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.dictionaryTypeName + "</td>";
	gridHtml += "<td>" + obj.dictionaryName + "</td>";
	gridHtml += "<td>" + (obj.dictionaryCode != null ? obj.dictionaryCode : "")
			+ "</td>";
	gridHtml += "<td>";

	gridHtml += "<a class='tablelink' href=\"javascript:editInfo('" + obj.id
			+ "','" + obj.dictionaryType + "','" + obj.dictionaryName + "','"
			+ obj.dictionaryCode + "','" + obj.dictionaryTypeName
			+ "');\">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	gridHtml += statusFormat(obj);
	
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function statusFormat(obj) {
		var htmlStr = "";
		
		if(obj.status == 1) {
			htmlStr += "<a href='#' class='tablelink' onclick=\"deleteInfo('" + obj.id
				+ "', '" + obj.dictionaryId+ "', '" + obj.dictionaryType+ "')\">禁用</a>";
		} else {
			htmlStr += "<a href='#' class='tablelink' onclick=\"enableInfo('" + obj.id
				+ "', '" + obj.dictionaryId+ "', '" + obj.dictionaryType+ "')\">启用</a>";
		}
		return htmlStr;
	}
}
function editInfo(id, dictionaryType, dictionaryName, dictionaryCode,
		dictionaryTypeName) {
	dictionaryTypeNames = dictionaryType;
	oldNames = dictionaryName;
	oldCodes = dictionaryCode;
	getId = id;
	$(".tip2").fadeIn(200);
	$("#dictionnaryLeixin").html(dictionaryTypeName);
	$("#dictionCode").val(dictionaryCode);
	$("#dictionName").val(dictionaryName);
}

function realEnableInfo(id, dictionaryCode, dictionaryType) {
		var url = pathHeader
				+ "/dictionary/dictionaryManages/deleteDictionary.do";
		$.ajax( {
			url : url,
			type : "post",
			data : {
				id : id,
				dictionaryCode:dictionaryCode,
				enableFlag:1,
				dictionaryType:dictionaryType
			},
			async : true,
			success : function(data) {
				if (data.success) {
					showList();
				} else {
				}
			},
			error : function() {
				jQuery.generalAlert("启用失败!");
			}
		});
}

function realDeleteInfo(id, dictionaryCode, dictionaryType) {
		var url = pathHeader
				+ "/dictionary/dictionaryManages/deleteDictionary.do";
		$.ajax( {
			url : url,
			type : "post",
			data : {
				id : id,
				dictionaryCode:dictionaryCode,
				dictionaryType:dictionaryType
			},
			async : true,
			success : function(data) {
				if (data.success) {
					showList();
				} else {
					jQuery.generalAlert("无法禁用，该字典已被占用!");
				}
			},
			error : function() {
				jQuery.generalAlert("删除失败!");
			}
		});
}

function enableInfo(id, dictionaryCode, dictionaryType) {
	jQuery.confirmWindow("提示信息", "确认启用该字典？", function(){realEnableInfo(id, dictionaryCode, dictionaryType); });
}

function deleteInfo(id, dictionaryCode, dictionaryType) {
	jQuery.confirmWindow("提示信息", "确认禁用该字典？", function(){realDeleteInfo(id, dictionaryCode, dictionaryType); });
}

//增加数据字典
function saveInfo() {
	codeFlag = false;
	dictionNameFlag = false;
	//字典编码是否存在
	var codeExitFlag = false;
	//字典名称是否存在
	var dictionaryNameExitFlag = false;
	//字典的状态启用还是禁用
	var dictionaryNameStatus = false;
	//查询数据的状态
	var queryStatus = false;
	var dictionaryTypeName = Trim($('#dictionaryType').find("option:selected").text().replace(/(^\s+)|(\s+$)/g, ""));
	
	if ($('#dictionaryType').val() == "") {
		$('#selectedError').html("请选择字典类型!");
		return false;
	} else {
		$('#selectedError').html("");
	}

	if ($('#insertDictionCode').val() == "") {
		$('#CodeError').html("编码不能为空!");
		return false;
	} else {
		$('#CodeError').html("");
	}
	if ($('#insertDictionName').val() == "") {
		$('#dictionNameError').html("名称不能为空!");
		return false;
	} else {
		$('#dictionNameError').html("");
	}
	var dictionaryType = $('#dictionaryType').val();
	var insertDictionCode = $('#insertDictionCode').val();
	var insertDictionName = $('#insertDictionName').val();
	
	//	getAllDictionaryInfo.do验证重复的url
	var urlYan = pathHeader
			+ "/dictionary/dictionaryManages/getAllDictionaryInfo.do";
	$.ajax( {
		url : urlYan,
		type : "POST",
		async : false,
		data : {
			dictionaryType : dictionaryType,
			dictionaryCode : insertDictionCode,
			dictionaryName : insertDictionName,
			dictionaryTypeName : dictionaryTypeName
		},
		success : function(data) {
			if (data.success) {	
			}
			else{
				if(data.errorCode){
					codeExitFlag = true;
					return;
				}
				else if(data.errorStatus){
					dictionaryNameStatus = true;
					return;
				}				
				else if(data.errorName){
					dictionaryNameExitFlag = true;
					return;
				}
				else {
					queryStatus = true;
					return;
				}
			}
		},
		error : function() {
			jQuery.generalAlert("增加失败");
		}
	});
	if (codeExitFlag) {
		$('#CodeError').html("编码不能重复!");
		return false;
	} else {
		$('#CodeError').html("");
	}
	if (dictionaryNameStatus) {
		$('#dictionNameError').html("该字典名称被禁用，请启用!");
		return false;
	} else {
		$('#dictionNameError').html("");
	}
	if (dictionaryNameExitFlag) {
		$('#dictionNameError').html("名称不能重复!");
		return false;
	} else {
		$('#dictionNameError').html("");
	}
	if(queryStatus){
		$('#dictionNameError').html("添加失败!");
		return false;
	}

	// 按钮置灰
	$("#submit").attr( {
		"disabled" : "disabled"
	});
	var url = pathHeader
			+ "/dictionary/dictionaryManages/saveDictionaryInfo.do";
	$.ajax( {
		url : url,
		type : "POST",
		async : "true",
		data : {
			dictionaryType : dictionaryType,
			dictionaryCode : insertDictionCode,
			dictionaryName : insertDictionName,
			dictionaryTypeName : dictionaryTypeName
		},
		success : function(data) {
			if (data.success) {
				$(".tip").fadeOut(100);
				$("#submit").attr( {
					"disabled" : false
				});
				showList();
			}
		},
		error : function() {
			jQuery.generalAlert("增加失败");
		}
	});
}

/**
 * js验证
 */
$(function() {
	$("#insertDictionCode").blur(
			function() {
				$("#CodeError").html("");
				if (Trim($("#insertDictionCode").val()) == null
						|| Trim($("#insertDictionCode").val()) == "") {
					$("#CodeError").html("编码不能为空!");
				} else {
					codeFlag = false;
				}
			});

	$("#insertDictionName").blur(
			function() {
				$("#dictionNameError").html("");
				if (Trim($("#insertDictionName").val()) == null
						|| Trim($("#insertDictionName").val()) == "") {
					$("#dictionNameError").html("名称不能为空!");
				} else {
					dictionNameFlag = false;
				}
			});
});