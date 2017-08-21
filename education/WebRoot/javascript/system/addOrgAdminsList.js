$(function(){
	adminsList();
});

function adminsList(){
	$('#admin_List').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader+ "/sys/getOrgAdminsList.do";
	$.ajax({
		url:url,
		type:"post",
		cache : "false",
		async : "true",
		dataType : "json",
		data:{
			organizationId : organizationId,
			sizePerPage :sizePerPage,
			pageIndex :pageIndex
		},
		success:function(data){
			$("#counts").html(data.total);
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#admin_List').append(gridHtml);
				pagination(data, function(){adminsList();});
			}else {
				$('#modelManageList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td>"+obj.loginAccount+"</td>";
	gridHtml += "<td>"+obj.roleName+"</td>";
	gridHtml += "<td>"+obj.password+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
}

function optionFormatter(obj){
	var returnStr = "";
	returnStr += 	 "<a href='###' class='tablelink' onclick='editAdminInfo(\"" + obj.id + "\");'>编辑</a>&nbsp;&nbsp;&nbsp;";
	returnStr += 	 "<a href='###' class='tablelink' onclick='deleteAdminInfo(\"" + obj.id + "\");'>删除</a>&nbsp;&nbsp;&nbsp;";
	return returnStr;
}
//编辑
function editAdminInfo(id){
	var url;
	if(type==1){
		url = pathHeader+"/person/getAdminInfo.htm?click=16&id="+id+"&type="+type;
	}else{
		url = pathHeader+"/person/getAdminInfo.htm?click=4&id="+id+"&type="+type;
	}
	window.location.href=url;
}
//删除
function deleteAdminInfo(id){
	var url = pathHeader+"/person/org/deleteOrgAdmin.do";
	$.ajax({
		url:url,
		type:"post",
		async : "true",
		dataType : "json",
		data:{
			id:id
		},
		success:function(data){
			if(data.success){
				window.location.reload();
			}
		},
		error:function(){
			
		}
		
	});
}


function addAdminInfo(){
	var url;
	if(type==1){
	 url = pathHeader+ "/sys/addOrgAdminsPage.htm?click=16&type="+type+"&organizationId="+organizationId;
	}else{
	url = pathHeader+ "/sys/addOrgAdminsPage.htm?click=4&type="+type+"&organizationId="+organizationId;
	}
	window.location.href=url;
}
