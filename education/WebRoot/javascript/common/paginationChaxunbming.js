var callback = ""
/**
 * 翻页 请求处理
 * @return {TypeName} 
 */
var Page = function() {
		return {
			goNext: function(callback) {
				var pageIndex = Number($("#pageIndex").val());
				$("#pageIndex").val(pageIndex + 0 + 1);
				callback();
			},
			goPre: function(callback) {
				var pageIndex = Number($("#pageIndex").val());
				$("#pageIndex").val(pageIndex + 0 -1);
				callback();
			},
			go: function(a, callback) {
				$("#pageIndex").val(a);
				callback();
			},
			goTo: function(callback) {
				$("#pageIndex").val($('#pnum').val());
				callback();
			}
		}
}();
			
/**
 * 生成分页样式
 * @param {Object} pageObject
 */
function pagination(pageObject, callback) {
	var showCount = 8;
	var PageCount = pageObject.pageSize;
	var htmlStr = "<div class='message'>共<i class='blue'>"+pageObject.total+"</i>条记录 每页 "+PageCount+" 条，当前第&nbsp;<i class='blue'>"+pageObject.currentPage+"&nbsp;</i>页 / 共&nbsp;<i class='blue'>"+pageObject.pages+"</i>&nbsp;页</div>";
	htmlStr += "<ul class='paginList'>";
	htmlStr += "<li class='paginItem'><a href='javascript:Page.go(1, "+callback+");' >首页</a></li>";
	
	if($("#pageIndex").val() == 1) {
		
		htmlStr +="<li class='paginItem'><a href='###' class='longer'>上一页</a></li>";
	} else {
		htmlStr +="<li class='paginItem'><a href='###' onclick='javascript:Page.goPre("+callback+");' class='longer'>上一页</a></li>";
	}
	var numbers = pageObject.pageNumbers;
	$.each(numbers, function(index,element) {
		if(pageObject.currentPage == element) {
			htmlStr +="<li class='paginItem current'><a href='###'>"+element+"</a></li>";
		}else {
			htmlStr +="<li class='paginItem'><a href='javascript:Page.go("+element+", "+callback+");'>"+element+"</a></li>";
		}
		if( numbers.length-1 == index && pageObject.pages != numbers[numbers.length-1] ){
			htmlStr +=" <li class='paginItem more'><a href='###'>...</a></li>";
		}
		if(numbers.length-1 == index  && pageObject.currentPage != pageObject.pages) {
			if(pageObject.currentPage == pageObject.pages) {
				htmlStr +="<li class='paginItem'><a href='###' class='longer disabled'>下一页</a></li>";
			} else {
				htmlStr +="<li class='paginItem'><a href='###' onclick='javascript:Page.goNext("+callback+");' class='longer disabled'>下一页</a></li>";
			}
		}
	});
	htmlStr += "<li class='paginItem'><a href='javascript:Page.go("+pageObject.pages+", "+callback+");' >末页</a></li>";
	htmlStr +="</ul>";
	$("#pagebar").html(htmlStr);
}