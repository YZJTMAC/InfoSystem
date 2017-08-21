
$(document).ready(function(e) {
	$('input[name=mygroup]').change(function(){
		var rule= $(this).val();
		if(rule ==1){
			 $("#txtGood").val('');
			 $("#txtBetter").val('');
			 $("#txtBest").val('');
			 $("#txtPass").val('');
			 $("#txtLow").val('');
			 
			 $("#txtGood").attr("disabled",true );
			 $("#txtBetter").attr("disabled",true );
			 $("#txtBest").attr("disabled",true );
			 $("#txtPass").attr("disabled",true );
			 $( "#txtLow" ).removeAttr("disabled");
			 $( "#txtLow" ).focus();
			 
			 
		}else if(rule ==2){
			 $("#txtGood").val('');
			 $("#txtBetter").val('');
			 $("#txtBest").val('');
			 $("#txtPass").val('');
			 $("#txtLow").val('');
			 
			 $("#txtGood").attr("disabled",true );
			 $("#txtBetter").attr("disabled",true );
			 $("#txtBest").attr("disabled",true );
			 $("#txtLow").attr("disabled",true );
			 $( "#txtPass" ).removeAttr("disabled");
			 $( "#txtPass" ).focus();
			 
		}else if (rule ==3){
			 $("#txtLow").val(0);
			 $("#txtPass").val(0);
			 
			 $("#txtGood").val('');
			 $("#txtBetter").val('');
			 $("#txtBest").val('');
			 $("#txtPass").val('');
			 $("#txtLow").val('');
			 
			 $("#txtGood").removeAttr("disabled");
			 $("#txtBetter").removeAttr("disabled");
			 $("#txtBest").removeAttr("disabled");
			 $("#txtLow").attr("disabled",true );
			 $( "#txtPass" ).attr("disabled",true );
			 $( "#txtBest" ).focus();
			 
		}
	});
	
	
		// 条件查询
		$("#btnSave").click(function() {
			var low=$("#txtLow").val();
			var good =$("#txtGood").val();
			var better = $("#txtBetter").val();
			var best = $("#txtBest").val();
			var pass = $("#txtPass").val();
		 
			
			var pubRule=$('input[name=mygroup]:checked' ).val();
			 
			var publishRuleScore="";
			if(pubRule==1){
				publishRuleScore=low;
			}
			
			if(pubRule==2){
				publishRuleScore=pass;
			}
			if(pubRule==3){
				publishRuleScore=good+','+better+','+best;
			}
			
		 
			
			var vr="";
			 
			if($('#ckb1').attr('checked')) {
				vr +="1";
			} else {
				vr+="0";
			}
			
			if($('#ckb2').attr('checked')) {
				vr +="1";
			} else {
				vr+="0";
			}
			
			if($('#ckb3').attr('checked')) {
				vr +="1";
			} else {
				vr+="0";
			}
			
			$('#myModal').modal('show');
			 
			 $.ajax({
					url : pathHeader + '/org/orgScorePublishRuleSave.do',
					type:"POST",
					cache:"false",
					async:"true",
					dataType:"json",
					data:{
						pubRule : pubRule,
						publishRuleScore : publishRuleScore,
						viewRule :vr,
						projectId:  GetURLParameter('projectId')
 
					},
					success:function(data){
						if(data.success) {
							jQuery.generalAlert("成绩发布成功!");
							setInterval(function() {
								window.location.href =pathHeader + "/org/orgScorePublishPages.htm";
							}, 2000);
						} else if(data.msg == '-1'){
							jQuery.generalAlert("成绩发布失败，学员编号超出范围！");
						} else {
							jQuery.generalAlert("成绩发布失败!");
						}
						$('#myModal').modal('hide');
					},
					error:function(){
						jQuery.generalAlert("报错.成绩发布失败!");
					}
				}); 
			 
		});
	 
	});

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
