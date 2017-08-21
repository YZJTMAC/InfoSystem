var getId ;
$(function() {
	showList();
	// 条件查询
	$("#select").click(function() {
		showList();
	});
	
	$(".sure2").click(function(){
		var organizationName = $("#organizationName2").val();
		var contacts = $("#contacts").val();
		var contactsType = $("#contactsType").val();
		var orgCode = $("#orgCode").val();
		var oldOrgCode = $("#oldOrgCode").val();
		var url = pathHeader +"/sys/editOrganizationInfo.do";
	  $.ajax({
		  url:url,
		  type:"post",
		  data:{
		  organizationId:getId,
		  organizationName:organizationName,
		  contacts:contacts,contactsType:contactsType,
		  orgCode:orgCode,
	      oldOrgCode:oldOrgCode
		  },
		  async:true,
		  success:function(data){
			  if(data.success){
				  showList();
				  $(".tip2").fadeOut(100);
			  }
			  else{
				  jQuery.generalAlert("添加失败,"+data.resultReason);
			  }
		  },
		  error:function(){
			  alert("error!");
		  }
	 	  });
	});
	
	
	$(".cancel").click(function(){
  			$(".tip2").fadeOut(100);
		});
	$(".tiptop").click(function(){
  		$(".tip2").fadeOut(100);
	});
});

function showList() {
	$('#organization_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax( {
				url : pathHeader + '/sys/organizationList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					type:type,
					organizationName : $('#organizationName').val(),
					sizePerPage :sizePerPage,
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
						
						$('#organization_list').append(gridHtml);
						pagination(data, function(){showList();});
					} else {
						gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
						$('#organization_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
					$('#organization_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var addr = (obj.organizationProvinceName==null?'':obj.organizationProvinceName)+" "+
	(obj.organizationCityName==null?'':obj.organizationCityName)+
	                              " "+(obj.organizationDistrictName==null?'':obj.organizationDistrictName);
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.organizationName + "</td>";
	gridHtml += "<td>" + obj.contacts + "</td>";
	gridHtml += "<td>" + obj.contactsType + "</td>";
	gridHtml += "<td>"+addr+"</td>";
	gridHtml += "<td>"+obj.orgCode+"</td>";
	gridHtml += "<td>";
	if(true){
		gridHtml +="<a href='###' class='tablelink' onclick='info("+obj.organizationId+")'>查看</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	if(true){
		gridHtml += "<a href='###' class='tablelink' onclick='editInfo(" + obj.organizationId + ",\"" + obj.organizationName + "\",\"" + obj.contacts + "\",\"" + obj.contactsType + "\",\"" + obj.orgCode + "\");'>编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	if(true){
		gridHtml +="<a href='###' class='tablelink' onclick='deleteInfo("+obj.organizationId+")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	gridHtml +="<a href='###' class='tablelink' onclick='addAdmin("+obj.organizationId+")'>设置管理员</a>&nbsp;&nbsp;";
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}
//增加机构管理员
function addAdmin(organizationId){
	var url;
	if(type==1){
		url= pathHeader +"/sys/toOrgAdminsList.htm?click=16&organizationId="+organizationId+"&type="+type;
	}else{
		url= pathHeader +"/sys/toOrgAdminsList.htm?click=4&organizationId="+organizationId+"&type="+type;
	}
	window.location.href=url;
}
function info(organizationId){
	var url;
	if(type==1){
		url = pathHeader +"/sys/organizationInfo.htm?click=16&organizationId="+organizationId;
	}else{
	 url = pathHeader +"/sys/organizationInfo.htm?click=4&organizationId="+organizationId;
	}
	window.location.href=url;
}

function addInfo(type){
	var url;
	if(type==2){
	 url = pathHeader +"/sys/addOrganizationInfo.htm?click=4&type="+type;
	}else{
	 url = pathHeader +"/sys/addCpOrganizationInfo.htm?click=16&type="+type;
	}
	window.location.href=url;
}

function editInfo(organizationId,organizationName,contacts,contactsType,orgCode){
	$(".tip2").fadeIn(200);
	getId = organizationId;
	$("#organizationName2").val(organizationName);
	$("#contacts").val(contacts);
	$("#contactsType").val(contactsType);
	$("#orgCode").val(orgCode);
	$("#oldOrgCode").attr("value",orgCode);
}

function deleteInfo(id){
	if(confirm("确认删除该机构？")){
		var url = pathHeader +"/sys/deleteOrganizationInfo.do";
	$.ajax({
		  url:url,
		  type:"post",
		  data:{organizationId:id},
		  async:true,
		  success:function(data){
			  if(data.info=='删除成功'){
				  showList();
			  }else{
				  alert(data.info);
			  }
		  },
		  error:function(){
			  jQuery.generalAlert("删除失败!");
		  }
	 	  });
	}
}
function importInfo(type){
	var url = pathHeader +"/sys/importOrganizationsPage.htm?click=4&type="+type;
	window.location.href=url;
}

