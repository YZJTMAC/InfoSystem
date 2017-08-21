$(function(){
	getOrganizationInfo();
});


//查看机构 
function getOrganizationInfo(){
	urlGo=pathHeader +"/sys/getOrganizationInfo.do?click=4";
		$.ajax({
		url : urlGo,
		type:"POST",
		async:"true",
		data:{
		organizationId:organizationId
		},
		success:function(data){
			if(data.success) 
			{
				var obj = data.info;
				if(obj.organizationName!=null){
					$("#organizationName").html(obj.organizationName);
				}
					if(obj.contacts!=null){
					$("#contacts").html(obj.contacts);
				}
					if(obj.contactsType!=null){
					$("#contactsType").html(obj.contactsType);
				}
					if(obj.organizationAdderss!=null){
					$("#organizationAdderss").html(obj.organizationAdderss);
				}
					if(obj.organizationProvinceName!=null){
					$("#organizationProvinceName").html(obj.organizationProvinceName);
				}
					if(obj.organizationCityName!=null){
					$("#organizationCityName").html(obj.organizationCityName);
				}
					if(obj.organizationDistrictName!=null){
					$("#organizationDistrictName").html(obj.organizationDistrictName);
				}
					if(obj.memo!=null){
					$("#memo").html(obj.memo);
				}
					
//					if(obj.status!=null){
//						var ifExit = obj.status;
//						if(ifExit == 1){
//							ifExit="有效";
//						}else{
//							ifExit="无效";
//						}
//					$("#status").html(ifExit);
//				}
					if(obj.createBy!=null){
					$("#createBy").html(obj.createBy);
				}
					if(obj.createDate!=null){
					$("#createDate").html(obj.createDate);
				}
				
			}
		},
		error:function(){
			jQuery.generalAlert("查看失败!");
		}
	});
}

