$(function(){
	$("#save").click(function() {
		setTrainingAddress();
	});
});

function setTrainingAddress(){
	var updateDate = $('#updateDate').val();
	var trainingAddress = $('#trainingAddress').val();
	$.ajax({
		url : pathHeader + '/org/orgProjectModify.do?projectId='+projectId+'&updateDate='+updateDate+'&trainingAddress='+trainingAddress,
		type:"POST",
		cache:"false",
		async:"true",
		success:function(data){
			if(data.success) {
				jQuery.generalAlert("设置成功!");
				window.location.href = pathHeader + '/org/orgProjectListPage.htm';
			} else {
				jQuery.generalAlert("设置失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("设置失败!");
		}
	});
}