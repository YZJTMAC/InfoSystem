$score = [];


$(function(){
	queryImportScoreInfo();
});


/**
 * 查询项目成绩导入
 */
function queryImportScoreInfo(){
	$('#score_list').html('');
	
	$.ajax({
		url : pathHeader + '/edupm/teachermanage/queryImportScoreInfo.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId : projectId
		},
		success:function(data){
			if(data.success) {
				$score.length = 0;
				
				var obj = data.obj;
				var gridHtml = "";
				$.each(obj, function(index,element) {
					gridHtml += getTdHtml(index, element);
				});
				$('#score_list').append(gridHtml);
				
				createShowChart();
				
			} else {
				gridHtml = "<tr><td align='center'colspan='5'>暂无查询结果！</td></tr>";
				$('#score_list').append(gridHtml);
			}
		},
		error:function(){
			jQuery.generalAlert('查询失败!');
		}
	});
}


function getTdHtml(index, obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.orgName+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.applyNum)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.studyNum)+"</td>";
	gridHtml += "<td><div id='td_"+index+"' style='	width:400px; height:300px;'>"+scoreFormatter(index, obj)+"</div></td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	/**
	 * 保存每个机构各个分数段成绩数据
	 * @param {Object} index
	 * @param {Object} obj
	 */
	function scoreFormatter(index, obj){
		var scores = new Object();
		scores.index = index;
		scores.scoreA = obj.scoreA;
		scores.scoreB = obj.scoreB;
		scores.scoreC = obj.scoreC;
		scores.scoreD = obj.scoreD;
		scores.scoreE = obj.scoreE;
		
		$score.push(scores);
	}
}


/**
 * 获取每个机构各个分数段成绩统计数据
 */
function createShowChart(){
	for(var i=0; i<$score.length; i++){
		var obj = $score[i];
		
		var index = obj.index;
		var a = obj.scoreA;
		var b = obj.scoreB;
		var c = obj.scoreC;
		var d = obj.scoreD;
		var e = obj.scoreE;
		
		$('#td_'+i).html('');
		
		showChart(a, b, c, d, e, index);
	}
}


/**
 * 将机构成绩数据写入控件动态创建饼状图并显示在相对应位置
 * @param {Object} a
 * @param {Object} b
 * @param {Object} c
 * @param {Object} d
 * @param {Object} e
 * @param {Object} index
 */
function showChart(a, b, c, d, e, index) {
	s1 = [['90分以上人数',a], ['80~89人数',b], ['70~79人数',c], ['60~69人数',d], ['60分以下人数',e]];
    plot2 = $.jqplot('td_'+index, [s1], {
  		title: '成绩导入结果',
        seriesDefaults:{
    		shadow: false,  //去掉阴影
            renderer:$.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true,
                dataLabelFormatString: '%.1f%%'
            }
        },
        legend: {
        	shadow:true,
            show: true,//设置是否出现分类名称框（即所有分类的名称出现在图的某个位置）
         	location: 'ne',     // 分类名称框出现位置, nw, n, ne, e, se, s, sw, w.
         	xoffset: 12,        // 分类名称框距图表区域上边框的距离（单位px）
         	yoffset: 12
        }
    });
}
