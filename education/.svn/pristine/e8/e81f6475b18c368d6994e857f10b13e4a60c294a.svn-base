$(function(){

	
	var projectId= GetURLParameter('projectId');
	 $.post(pathHeader + '/org/orgAreaList.do?projectId='+projectId,function(result){
		 if(result.toString()){
			 var myJsonString = JSON.stringify(result);
			 var zNodes =eval("(" + myJsonString + ")");
			 $.fn.zTree.init($("#treeDemo2"), setting2,zNodes);
		 }
	 });
});

function getAreaList(){
	$.ajax({
		url : pathHeader + '/org/orgAreaList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			 
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				alert("success.")
				 
			} else {
				alert("failure.")
			}
		},
		error:function(){
			alert("error.")
		}
	});
}


function formatProject(projectList) {
	  var template = $('#template').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
	}

function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

 




var setting2 = {
		view: {
			dblClickExpand: false,
			showLine: true,
			showIcon: false
		},
	async: {
		enable: true,
		url:pathHeader + '/org/orgAreaList.do?projectId='+ GetURLParameter('projectId'),
		autoParam:["id","type","isSchool","pId=pid"],
		otherParam:{"otherParam":"zTreeAsyncTest"},
		dataFilter: filter
	},
	callback: {
		onClick: onClick
	}
	
};

function getUserListForArea(){
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var teacherName=$('#txtTeacherName').val();
	var projectId;
	var pageIndex =0;
	var pageSize =20;
	
	
	$.ajax({
		url : pathHeader + '/org/orgScoreModifyList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId: GetURLParameter('projectId'),
			province: province,
			city: city,
			district:district,
			school:school,
			teacherName:teacherName,
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				var myJsonString = JSON.stringify(objList);
				var str = '{"users":'+myJsonString +'}';
				//document.write(str);
					formatProject(str) ;
					pagination(data, function() {
						getUserListForArea();
					});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
					$('#target').html('');
					$('#target').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 

}




function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
//	alert(childNodes);
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}