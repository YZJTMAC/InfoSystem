$(function(){
	initAutoComplete();
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
}

function showInfoList() {
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectInfo.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId
		},
		success:function(data){
			if(data.success) 
			{
				var obj = data.projectInfo;
				if(obj.year==null||obj.year.length==0||obj.year=="")
					$('#year').html("&nbsp;");
				else
					$('#year').html(obj.year);
			
				if(obj.projectNo==null||obj.projectNo.length==0||obj.projectNo=="")
					$('#projectNo').html("&nbsp;");
				else
					$('#projectNo').html(obj.projectNo);
			
					if(obj.projectName==null||obj.projectName.length==0||obj.projectName=="")
					$('#projectName').html("&nbsp;");
				else
					$('#projectName').html(obj.projectName);
					
					if(obj.startDate!=null){
					var datas = new Date(obj.startDate).format("yyyy-MM-dd");
					strs = datas.split("-");
					startDate = 
									 strs[0]+"年"+strs[1]+"月"+strs[2]+"日";
					$('#startDate').html(startDate);
					}else{
						$('#startDate').html("----");
					}
				if(obj.endDate!=null){
				var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
					strs = datas.split("-");
					endDate = 
									 strs[0]+"年"+strs[1]+"月"+strs[2]+"日";
						$('#endDate').html(endDate);
					}else{
					$('#endDate').html("----");
					}
				
					if(obj.projectScopeName==null||obj.projectScopeName.length==0||obj.projectScopeName=="")
					$('#projectScopeName').html("&nbsp;");
				else
					$('#projectScopeName').html(obj.projectScopeName);
					
					if(obj.trainScopeName==null||obj.trainScopeName.length==0||obj.trainScopeName=="")
					$('#trainScopeName').html("&nbsp;");
				else
					$('#trainScopeName').html(obj.trainScopeName);
					
					if(obj.projectPropertyName==null||obj.projectPropertyName.length==0||obj.projectPropertyName=="")
					$('#projectPropertyName').html("&nbsp;");
				else
					$('#projectPropertyName').html(obj.projectPropertyName);
					
					if(obj.trainTypeName==null||obj.trainTypeName.length==0||obj.trainTypeName=="")
					$('#trainTypeName').html("&nbsp;");
				else
					$('#trainTypeName').html(obj.trainTypeName);
					
					if(obj.memo==null||obj.memo.length==0||obj.memo=="")
					$('#memo').html("&nbsp;");
				else
					$('#memo').html(obj.memo);
					
					if(obj.projectAttchement==null||obj.projectAttchement.length==0||obj.projectAttchement=="")
					$('#projectAttchement').html("&nbsp;");
				else
					$('#projectAttchement').html(obj.projectAttchement);
					
					//项目培训对象
			var objList = data.pojoList;
			 var tableValues ="" ;
			for(var i = 0 ;i<objList.length;i++){
				var values = objList[i];
				var time =new Date(values.educationGraduationTime).format("yyyy-MM-dd");
				var sex = "";
				if(values.sex==1){
					sex="男";
				}else{
					sex="女";
				}
				var nianji = "";
				if(values.gradeName==!null){
					nianji = values.gradeName;
				}
			   tableValues += "<tr>" +
			   "<td width='108'><input  name='checkbox4'/></td>"+
				"<td width='60'>年级：</td>"+"<td width='187'>"+nianji+"</td>"+
				"<td width='60'>性别：</td>"+"<td width='187'>"+sex+"</td>"+
				"<td width='60'>学历：</td>"+"<td width='187'>"+values.educationBackgroundName+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td>&nbsp;</td>"+"<td>职务：</td>"+"<td >"+values.positionName+"</td>"+
				"<td>职称：</td>"+"<td>"+values.professionalTitleName+"</td>"+
				"<td>&nbsp;</td>"+
				"<td>&nbsp;</td>"+
				"</tr>";
			}
			$('#tableId').html(tableValues);
			}
			
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
		
		
	});
}

function showWindow(url) {
	window.location.href = url;
}