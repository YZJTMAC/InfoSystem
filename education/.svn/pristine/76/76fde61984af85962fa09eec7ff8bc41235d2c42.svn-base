//IE浏览器版本控制
var IEVersion = (function(){
	
	//方法一：若考虑IE浏览器版本可采用此方法，仅支持到IE11
	var result = {
	    isIE: false, //是否ie
	    version: -1   //版本号
	}
	
	//#region ie4_9
	var _version = 3;//ie版本号 临时的
	var ie4_9 = false;
	
	var odiv = document.createElement('div');
	
	 //目标元素
	//这个元素不需要append
	//在这个元素内插入ie条件注释 注释内包含一个标签 inner_element
	var inner_element = odiv.getElementsByTagName('i');
	while (odiv.innerHTML = '<!--[if gt IE ' + (++_version) + ']><i></i><![endif]-->', inner_element[0]) {
	    ie4_9 = true;
	}
	//#endregion
	
	if (ie4_9 && (_version > 3 && _version <= 9)) {
	    result = { isIE: true, version: _version };
	} else if (document.all) {
	    result = { isIE: true, version: 10 };
	} else if ("ActiveXObject" in window) {
	    result = { isIE: true, version: 11 };
	}
	
	//方法二：目前仅考虑是否支持IE浏览器内核
	/*var result = {
	    isIE: false //是否ie
	}
	
	if(!!window.ActiveXObject || "ActiveXObject" in window){
		result = { isIE: true};
	}*/
	
	return result;
})();