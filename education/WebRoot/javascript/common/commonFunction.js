//系统静态数据查询
var SysCode = {
	cache:[],
	baseUrl: pathHeader + "/sys/config",
	getJsonArray:function(codeId,option){
		var data = this.get(codeId);
		var jsonArray = [];
		if(option){
			jsonArray.push(option);
		}
		for(var i in data){
			var obj = {
				id : i,
				text : data[i]
			};
			jsonArray.push(obj);
		}
		return jsonArray;
	},
	get:function(codeId){
		if(SysCode.cache[codeId]){
			return SysCode.cache[codeId];
		}
		var data = null;
		$.ajax({
			url:SysCode.baseUrl+'/qryCodes.do',
			type:'GET',
			async:false,
			data:{codeId:codeId},
			dataType:'json',
			success:function(resp){
				data = resp;
				SysCode.cache[codeId] = data;
			}
		});
		return data;
	},
	getValue:function(paramkey, codeId){
		var data = SysCode.get(codeId);
		var result = "";
		$.each(data, function(key, value) {
			if(key == paramkey) {
				result = value;
				return false;
			}
		});
		return result;
	},
	createSelect:function(codeId, selectId, optionHtml){
		var objList = SysCode.getJsonArray(codeId, "");
		if(optionHtml != "" && optionHtml != null && optionHtml != "null" && optionHtml.length > 0) {
			$("#"+selectId).append(optionHtml);
		}
		$.each(objList, function(key, value) {
			$("#"+selectId).append(
							"<option  value=\"" + value.id + "\">"
									+ value.text + "</option>");
		});
		
	},
	createSelectByClass:function(codeId, classId, optionHtml){
		var objList = SysCode.getJsonArray(codeId, "");
		if(optionHtml != "" && optionHtml != null && optionHtml != "null" && optionHtml.length > 0) {
			$("."+classId).append(optionHtml);
		}
		$.each(objList, function(key, value) {
			$("."+classId).append(
							"<option  value=\"" + value.id + "\">"
									+ value.text + "</option>");
		});
		
	}
};

function openWindow(url){
	window.location.href = url;
}

function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	if(text == '请选择') {
		text = "";
	}
	scontent={
		value:value,
		text:text
	};
	return scontent;
}

//Trim函数去掉一字符串两边的空格
function Trim(his)
{
   //找到字符串开始位置

   Pos_Start = -1;
   for(var i=0;i<his.length;i++)
   {
     if(his.charAt(i)!=" ")
      {
         Pos_Start = i;
         break;
      }
   }
   //找到字符串结束位置

   Pos_End = -1;
   for(var i=his.length-1;i>=0;i--)
   {
     if(his.charAt(i)!=" ")
      {
         Pos_End = i;
         break;
      }
   }
   //返回的字符串
   Str_Return = ""
   if(Pos_Start!=-1 && Pos_End!=-1)
   {
		for(var i=Pos_Start;i<=Pos_End;i++)
		{
			   Str_Return = Str_Return + his.charAt(i);
		}
   }
   return Str_Return;
}

//取url参数
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