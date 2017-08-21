$(function(){
	trainingList();
	$("#select").click(function(){
		trainingList();
	});
})

function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#tss').val("");
}

function trainingList(){
	$('#areaList').html("");
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	var url = pathHeader + "/sys/fjimportList.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id,
			schoolName : $('#schoolName').val(),
			startIndex : pageIndex,
			pageSize :sizePerPage,
			schoolProvinceId : $('#schoolProvinceId').val(),
			schoolCityId : $('#schoolCityId').val(),
			schoolDistrictId : $('#schoolDistrictId').val()
		},
		success:function(data){
			if(data.success){
				
				var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += createTdHtml(element);
				});
				$('#areaList').html(gridHtml);
				if(gridHtml==""){
					gridHtml = "<tr><td align='center' colspan='16'>暂无查询结果！</td></tr>";
					$('#areaList').html(gridHtml);
				}
				//pagination(data, function(){areaList(belong,type);});
				pagination(data, function(){trainingList();});
			}else{
				var str = "<tr><td colspan='3'>无查询数据</td></tr>";
				$('#areaList').html(str);
			}
				
			}
		},
		error:function(){
			jQuery.generalAlert("url error");
		}
	});
}

function createTdHtml(obj){
	var createTime = new Date(obj.createTime).format("yyyy-MM-dd HH:mm:ss");
	var updateTime = new Date(obj.updateTime).format("yyyy-MM-dd HH:mm:ss");
	var rowStr = "<tr>";
	rowStr += "<td>"+ obj.cityName+"</td>" + 
			  "<td>"+ obj.districtName+"</td>" +
			  "<td>"+ obj.schoolName+"</td>" +
			  "<td>"+ obj.shangbaoNum+"</td>" +
			  "<td>"+ obj.dengluNum+"</td>" +
			  "<td>"+ obj.canxunlv+"</td>" +
			  "<td width='9%'>"+ obj.youxiaoxuexiNum+"</td>" +
			  "<td>"+ obj.xuexilv+"</td>" +
			  "<td>"+ obj.hegenum+"</td>" +
			  "<td>"+ obj.hegelv+"</td>" +
			  "<td>"+ obj.kechengzuoyeNum+"</td>" +
			  "<td>"+ obj.gongzuofangNum+"</td>" +
			  "<td>"+ obj.yanxiuhuodongNum+"</td>" +
			  "<td>"+ obj.yanxiuhuodongcanyuNum+"</td>" +
			  "<td>"+ obj.shijianyanxiuNum+"</td>" +
			  "<td>"+ obj.xiaomujianbaoNum+"</td>"
			  /*"<td >"+ obj.createBy+"</td>" +
			  "<td >"+ createTime+"</td>" +
			  "<td >"+ obj.updateBy+"</td>" +
			  "<td >"+ updateTime+"</td>"*/
			  ;
	
	rowStr += "</tr>";
	
	return rowStr;
	
}








