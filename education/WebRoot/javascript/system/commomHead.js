$(function(){
	var platformSetup = SysCode.getJsonArray("SYS_PLATFORM_SETUP","")[0].text;
	var style = platformSetup.sysStyle;
	if(style == 0){
		$('link[id=style]').attr('href', pathHeader+'/style/sblue/style.css');
	} else if(style == 1){
		$('link[id=style]').attr('href', pathHeader+'/style/style.css');
	} else if(style == 2){
		$('link[id=style]').attr('href', pathHeader+'/style/green/style.css');
	} else if(style == 3){
		$('link[id=style]').attr('href', pathHeader+'/style/red/style.css');
	}
});