/*
    alertWindow by taozhi
    消息框
 */
jQuery.extend({
	confirmWindow:function(title,content, callback){
		var url = url;
        var title = title; //标题
        var content = content; //内容
        var result = false;
        var color1; //背景颜色
        color1 = "#4399ca";
        //查找body中是否存在该消息框
        if($("body").find(".alertWindow1").length===0){
        //不存在
        	var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background-image: url(images/tm.png);position: fixed; left:0px; top: 0px; z-index: 111112; ">'+
            //var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background:rgba(0,0,0,0.5);position: fixed; left:0px; top: 0px; z-index: 9999;">'+
                                '<div  style="width: 400px; height: 200px;background: #FFF;margin: 180px auto;box-shadow: 1px 8px 10px 1px #9B9B9B;  ">'+
                                    '<div  style="width: inherit;height: 35px; line-height:35px; background-image:url('+pathHeader+'/images/btnbg1.png);display:block;">'+'<span class="alertWindowTitle" style="font-family:\'微软雅黑\';font-size: 14px;font-weight: bold;color:#fff;padding-left:10px; ">'+title+'</span>'+
                                        '<div class="alertWindowCloseButton1" style="float: right; width: 10px; height: 20px;margin-right:5px;font-family:\'microsoft yahei\';color:#fff;cursor: pointer;"></div>'+
                                    '</div>'+'<div class="alertWindowContent" style="width:360px;px;height: 60px;padding-left:20px;padding-right:20px;text-align:center;font-size: 9pt;color: black; padding-top:20px;">'+content+'</div>'+
                                    '<p style="text-align: center;font-size: 18px;font-weight: bolder;">' +
                                    '<input class="alertWindowCloseSure1" id="ok" type="button" value="确定" style="width: 100px;height:30px;background:'+color1+';border:none;float:left;margin-left:90px;position: relative;bottom: 18px;font-size:14px;font-family:\'微软雅黑\';color:#FFFFFF;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;cursor: pointer;"></p>'+
                                	'<input class="alertWindowCloseSure1" id="cancl" type="button" value="取消" style="width: 100px;height:30px;background:'+color1+';border:none;float:left;margin-left:20px;position: relative;bottom: 18px;font-size:14px;font-family:\'微软雅黑\';color:#FFFFFF;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;cursor: pointer;"></p>'+
                                    '</div>'+
                           '</div>';
            $("body").append(alertHtml);
            /*
             绑定事件
             */
            var $alertWindow = $(".alertWindow1"); //窗口对象
            //右上角关闭按钮
            $(".alertWindowCloseButton1").click(function(){
                $alertWindow.remove();
            });
            //确定按钮
            $(".alertWindowCloseSure1").click(function(){
            	
                if($(this).attr("id") == "ok"){
                	callback();
        		}else{
            		
        		}
                $alertWindow.remove();
            })
            //设置标题
            $(".alertWindowTitle").text(title);
            //设置内容
            $(".alertWindowContent").text(content);
            //显示
            $(".alertWindow1").show();
        }
    },
    alertWindow:function(title,content,bgcolor, url){
		var url = url;
        var title = title; //标题
        var content = content; //内容
        var color1; //背景颜色
        if(bgcolor===undefined){
            color1 = "#4399ca";
        }else{
            color1 = bgcolor;
        }
        //查找body中是否存在该消息框
        if($("body").find(".alertWindow1").length===0){
        //不存在
        	var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background-image: url(images/tm.png);position: fixed; left:0px; top: 0px; z-index:99999999; ">'+
            //var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background:rgba(0,0,0,0.5);position: fixed; left:0px; top: 0px; z-index: 9999;">'+
                                '<div  style="width: 400px; height: 200px;background: #FFF;margin: 180px auto;box-shadow: 1px 8px 10px 1px #9B9B9B;  ">'+
                                    '<div  style="width: inherit;height: 35px; line-height:35px; background-image:url('+pathHeader+'/images/btnbg1.png);display:block;">'+'<span class="alertWindowTitle" style="font-family:\'微软雅黑\';font-size: 14px;font-weight: bold;color:#fff;padding-left:10px; ">'+title+'</span>'+
                                        '<div class="alertWindowCloseButton1" style="float: right; width: 10px; height: 20px;margin-right:5px;font-family:\'microsoft yahei\';color:#fff;cursor: pointer;"></div>'+
                                    '</div>'+'<div class="alertWindowContent" style="width:360px;px;height: 60px;padding-left:20px;padding-right:20px;text-align:center;font-size: 9pt;color: black; padding-top:20px;">'+content+'</div>'+
                                    '<p style="text-align: center;font-size: 18px;font-weight: bolder;"><input class="alertWindowCloseSure1" type="button" value="确定" style="width: 100px;height:30px;background:'+color1+';border:none;position: relative;bottom: 18px;font-size:14px;font-family:\'微软雅黑\';color:#FFFFFF;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;cursor: pointer;"></p>'+
                                '</div>'+
                           '</div>';
            $("body").append(alertHtml);
            /*
             绑定事件
             */
            var $alertWindow = $(".alertWindow1"); //窗口对象
            //右上角关闭按钮
            $(".alertWindowCloseButton1").click(function(){
                $alertWindow.remove();
            });
            //确定按钮
            $(".alertWindowCloseSure1").click(function(){
            	
                $alertWindow.remove();
                if(url===undefined){
        		}else{
            		openWindow(url);
        		}
            })
            //设置标题
            $(".alertWindowTitle").text(title);
            //设置内容
            $(".alertWindowContent").text(content);
            //显示
            $(".alertWindow1").show();
        }
    },
    alertWindowReloadCurrent:function(title,content,bgcolor, url){
		var url = url;
        var title = title; //标题
        var content = content; //内容
        var color1; //背景颜色
        if(bgcolor===undefined){
            color1 = "#4399ca";
        }else{
            color1 = bgcolor;
        }
        //查找body中是否存在该消息框
        if($("body").find(".alertWindow1").length===0){
        //不存在
        	var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background-image: url(images/tm.png);position: fixed; left:0px; top: 0px; z-index: 9999; ">'+
            //var alertHtml = '<div  class="alertWindow1" style="width: 100%;height: 100%; background:rgba(0,0,0,0.5);position: fixed; left:0px; top: 0px; z-index: 9999;">'+
                                '<div  style="width: 400px; height: 200px;background: #FFF;margin: 180px auto;box-shadow: 1px 8px 10px 1px #9B9B9B;  ">'+
                                    '<div  style="width: inherit;height: 35px; line-height:35px; background-image:url('+pathHeader+'/images/btnbg1.png);display:block;">'+'<span class="alertWindowTitle" style="font-family:\'微软雅黑\';font-size: 14px;font-weight: bold;color:#fff;padding-left:10px; ">'+title+'</span>'+
                                        '<div class="alertWindowCloseButton1" style="float: right; width: 10px; height: 20px;margin-right:5px;font-family:\'microsoft yahei\';color:#fff;cursor: pointer;"></div>'+
                                    '</div>'+'<div class="alertWindowContent" style="width:360px;px;height: 60px;padding-left:20px;padding-right:20px;text-align:center;font-size: 9pt;color: black; padding-top:20px;">'+content+'</div>'+
                                    '<p style="text-align: center;font-size: 18px;font-weight: bolder;"><input class="alertWindowCloseSure1" type="button" value="确定" style="width: 100px;height:30px;background:'+color1+';border:none;position: relative;bottom: 18px;font-size:14px;font-family:\'微软雅黑\';color:#FFFFFF;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;cursor: pointer;"></p>'+
                                '</div>'+
                           '</div>';
            $("body").append(alertHtml);
            /*
             绑定事件
             */
            var $alertWindow = $(".alertWindow1"); //窗口对象
            //右上角关闭按钮
            $(".alertWindowCloseButton1").click(function(){
                $alertWindow.remove();
            });
            //确定按钮
            $(".alertWindowCloseSure1").click(function(){
            	 location.reload();
            })
            //设置标题
            $(".alertWindowTitle").text(title);
            //设置内容
            $(".alertWindowContent").text(content);
            //显示
            $(".alertWindow1").show();
        }
    },
    generalAlertAndJump:function(content, url){
    	jQuery.alertWindow("提示信息",content, "#4399ca", url);
    },
    generalAlert:function(content){
    	jQuery.alertWindow("提示信息",content);
    }
});