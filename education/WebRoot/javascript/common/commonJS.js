function getFileName(str){
	var fileName =  str.substring(str.lastIndexOf("/")+1,str.length);
	return fileName;
}

function LogisticToString(str)
{	
	var monyer = new Array(); 
	var i, s;
	str = 'logistic.' + str + '.baoogu';

	for (i = 0; i < str.length; i++) 
	{ 
   		monyer += str.charCodeAt(i)^0x10086  
   		monyer+="."; 
	}
	return monyer; 
} 

function LogisticToMyDecode(str) 
{ 
	var i,k,str2=""; 
	
	k=str.split("."); 
	
	for(i=0;i<k.length;i++) 
	{ 
		str2+=String.fromCharCode(k[i]^0x10086); 
	} 
	var arr = str2.split(".");
	str2 = arr[1];
	return str2; 
} 

//根据QueryString参数名称获取值
function getQueryStringByName(name) {

    var result = location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));

    if (result == null || result.length < 1) {

        return "";

    }

    return result[1];
}

//获取QueryString的数组

function getQueryString() {

    var result = location.search.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]+", "g"));

    if (result == null) {

        return "";

    }

    for (var i = 0; i < result.length; i++) {

        result[i] = result[i].substring(1);

    }

    return result;

}

//自定义Jquery Easy UI验证函数
$.extend($.fn.validatebox.defaults.rules, {
    //验证是否是整数或小数
    DecimalInt: {
        validator: function (value) {
            return /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)|(0))$/.test(value);
        },
        message: '请输入整数或小数.'
    }
});

var winWidth = 0;
var winHeight = 0;
/**
 * 自定义列表高度
 * @param {Object} listId 列表ID
 * @param {Object} cutWidth 需要减去的有效宽度
 * @param {Object} cutHeight 需要减去的有效高度
 * createBy:chenlei
 * createDate:2014-1-12
 */
function findListWOrH(listId,cutWidth,cutHeight)
{
    //获取窗口宽度
    if (window.innerWidth)

        winWidth = window.innerWidth;

    else if ((document.body) && (document.body.clientWidth))

        winWidth = document.body.clientWidth;

    //获取窗口高度

    if (window.innerHeight)

        winHeight = window.innerHeight;

    else if ((document.body) && (document.body.clientHeight))

        winHeight = document.body.clientHeight;

    //通过深入Document内部对body进行检测，获取窗口大小

    if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {

        winHeight = document.documentElement.clientHeight;

        winWidth = document.documentElement.clientWidth;

    }
    $("#"+listId).css("height",(winHeight-cutHeight));
    $("#"+listId).css("width",(winWidth-cutWidth));
   
}

/**
 * 非空验证
 * @param {Object} id
 * @param {Object} elmType
 * @return {TypeName} 
 */
function notEmpty(id,type){
	var val;
	if(type == "val"){
		val = Trim($("#"+id).val());
	}else if(type == "html"){
		val = Trim($("#"+id).html());
	}else if(type == "text"){
		val = Trim($("#"+id).html());
	}
	if(val == null || val.length == 0){
		return false;
	}
	return true;
}

/**
 * checkbox 是否选中
 * @param {Object} id
 * @return {TypeName} 
 */
function isChecked(id){
	return $("#"+id).attr("checked") == "checked";
}

/**
 * checkbox 至少选中一个
 * @param {Object} chbAry checkbox数组
 * @return {TypeName} 
 */
function leastOne(chbAry){
	var flag = false;
	if(chbAry != undefined && chbAry.length > 0){
		for(var i = 0;i<chbAry.length;i++){
			if(chbAry[i].checked){
				flag = true;
				break;
			}
		}
	}
	return flag;
}

/**
 * 验证所给值的长度
 * @param {Object} val
 * @param {Object} max
 * @param {Object} min
 * @return {TypeName} 
 */
function validateLength(val,min,max){
	var length = Trim(val).length;
	if(length >=min && length <=max){
		return true;
	}
	return false;
}

/**
 * 大于0
 * @param {Object} val
 * @return {TypeName} 
 */
function isGtZero(val){
	var reg = /^([0-9]\d*)(\.{0,1}\d*[0-9])?$/;
	return  reg.test(val);
}
/**
 * 选择了省市 返回true，没选择 返回false
 * @param {Object} text
 * @return {TypeName} 
 */
function validateLocation(text){
	var sProvince = "请选择省";
	var sCity = "请选择市";
	var sDistrict = "请选择区";
	if(text == sProvince || text == sCity || text == sDistrict ){
		return false;
	}
	return true;
}
/**
 * 设置span内容
 * @param {Object} id
 * @param {Object} text
 */
function setSpanText(id,text){
	$("#"+id).html(text);
}

/**
 * 长度1-10的正数
 * @param {Object} val
 * @return {TypeName} 
 */
function validateNum(val){
	if(val.length>0 && val.length<=10&&isGtZero(val)){
		return true;
	}
	return false;
}

// 检查是否是Email
// sValue：输入值，合法格式为a@b.c.d此类形式
function isEmail( sValue )
{
	var iFirstIndex = 0;
	var iSecondIndex = sValue.indexOf( '@' );
	if( iSecondIndex == -1 )
	{
		return false;
	}

	var sTemp = sValue.substring( iFirstIndex, iSecondIndex );
	// Modified by Zhenghao: 01-03-22 To eliminate treat number and Chinese Character as invalid character
	//if( isNameCharacter( sTemp ) == false )
	//{
	//	return false;
	//}
	// Modified end

	iSecondIndex = sValue.indexOf( '.' );
	if( iSecondIndex == -1 || sValue.substring( sValue.length-1, sValue.length ) == '.' )
	{
		return false;
	}
	else if(  sTemp.length == sValue.length - 2 )	// The last two characters are '@' and '.'
	{
		return false;
	}
	else
	{
		var sTempValue = sValue;
		iSecondIndex = sValue.indexOf( '@' );
		while( iSecondIndex != -1 )
		{
			iFirstIndex = iSecondIndex + 1;
			sTempValue = sTempValue.substring( iFirstIndex, sTempValue.length );	// The right section of value
			iSecondIndex = sTempValue.indexOf( '.' );
			// document.write( "sTempValue=" + sTempValue + "<br>" );
			sTemp = sTempValue.substring( 0, iSecondIndex );
			// document.write( "sTemp=" + sTemp + "<br>" );
			for( i = 0; i < sTemp.length; i ++ )
			{
				var cCharacter = sTemp.charAt( i );
				if( isCharacter( cCharacter ) == false && isOtherNameCharacter( cCharacter ) == false && isDigitalCharacter( cCharacter ) == false )
				{
					return false;
				}
			}
		}

		for( i = 0; i < sTempValue.length; i ++ )
		{
			var cCharacter = sTempValue.charAt( i );
			if( isCharacter( cCharacter ) == false && isOtherNameCharacter( cCharacter ) == false	&& isDigitalCharacter( cCharacter ) == false )
			{
				return false;
			}
		}
	}

	return true;
}


// 检查是否是邮编
// sValue：输入值，合法格式为六位整数

function isZIP( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	if( sValue.length != 6 )
	{
		return false;
	}
	else
	{
		for( i = 0; i < 6; i ++ )
		{
			if( isDigital( sValue.charAt( i ) ) == false )
			{
				return false;
			}
		}
	}

	return true;
}

//IsFloat函数判断一个字符串是否由数字(int or long or float)组成
function IsFloat(str)
{
  flag_Dec = 0
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) == '.')
    {
       flag_Dec++;
	   if(flag_Dec > 1)
          return false;
       else
          continue;
    }
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
       return false;
    }
  }
  return true;
}

//IsTelephone函数判断一个字符串是否由数字或'-','*'组成
function IsTelephone(str)
{
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
	if((str.charAt(ilen)!='-')&&(str.charAt(ilen)!='*')&&(str.charAt(ilen)!='(')&&(str.charAt(ilen)!=')'))
        return false;
    }
  }
  return true;
}

/**
 * 验证中文
 * @param {Object} str
 * @return {TypeName}  
 */
function isChinese(str){  
	var reg =  /^[\u4e00-\u9faf]+$/;
	if(reg.test(str)){
		return true;  
	} else {
 		return false;  
	}
}


//检查输入框中是否有特殊字符
function isRegulaChar(sChar)
{
    //var sFormat = "\"&'()<>^`%";
    var sFormat = "&\"'<>%";
    var iLocation = sFormat.indexOf(sChar);
    return( iLocation != -1 );
}
//如果输入框中包含上述特殊字符返回False,否则返回True
function isRegulaInput(strValue)
{
    for(var i=0;i<strValue.length;i++)
    {
		c=strValue.charAt(i);
		if(isRegulaChar(c))
        {
			return false;
		}
	}
	return true;
}

//开始时间是否大于结束时间
//开始时间>结束时间，return false
function checkBeginDateEndDate(beginDate,endDate)
{
	if(!IsThisDate(beginDate))
		return false;
	if(!IsThisDate(endDate))
		return false;
	if(dateParseInt(beginDate,"-")>dateParseInt(endDate,"-"))
    {
        return false;
    }
	return true;
	
}

function dateParseInt(str,compart){
	var tempstartDate = str;
	var todayIndex = tempstartDate.indexOf(compart);
	var tempDate1 = tempstartDate.substring(0,todayIndex);
	todayIndex1 = tempstartDate.indexOf(compart,todayIndex+1);
	if (todayIndex1 - todayIndex == 2){
		tempDate1 = tempDate1 + "0" + tempstartDate.substring(todayIndex+1,todayIndex1);
		}else{
			tempDate1 += tempstartDate.substring(todayIndex+1,todayIndex1);
		}
	if (tempstartDate.length - todayIndex1 ==2){
		tempDate1 = tempDate1 + "0" + tempstartDate.substring(todayIndex1+1);
		}else{
			tempDate1 += tempstartDate.substring(todayIndex1+1);
		}
	return parseInt(tempDate1);
}
//判断是否是日期格式  2001-10-11
function IsThisDate(theDate)
{
	var iFirstIndex = theDate.indexOf('-');
		if( iFirstIndex == -1 )
		{
			return false;
		}
		var iSecondIndex = theDate.lastIndexOf('-');

		var iYear = theDate.substring( 0, iFirstIndex );
		
		if( isDigitalString( iYear ) == false )
		{
			return false;
		}
		var iMonth = theDate.substring( iFirstIndex + 1, iSecondIndex );
		if( isDigitalString( iMonth ) == false )
		{
			return false;
		}
		var iDate = theDate.substring( iSecondIndex + 1, theDate.length );
		if( isDigitalString( iDate ) == false )
		{
			return false;
		}
		var vGivenDate = new Date( iYear, iMonth - 1, iDate );
		var iGivenYear = vGivenDate.getFullYear();
		if( iGivenYear < 100 )
		{
			iGivenYear += 1900;
		}
		
		var iGivenMonth = vGivenDate.getMonth() + 1;
		var iGivenDate = vGivenDate.getDate();
		if( iGivenYear != iYear || iGivenMonth != iMonth || iGivenDate != iDate )
		{
			return false;
		}
		return true;
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

/**
 * 非空验证 
 * @param {Object} str
 * @return {TypeName} 
 */
function notEmptyOfStr(str){
	str = Trim(str);
	if(str == null || str.length ==0){
		return false;
	}
	return true;
}

//IsDigital函数判断一个字符串是否由数字(int or long)组成
function isDigital(str)
{
  for(ilen=0;ilen<str.length;ilen++)
  {
    if(str.charAt(ilen) < '0' || str.charAt(ilen) > '9' )
    {
       return false;
    }
  }
  return true;
}

// 检查是否是数字字符串

// sValue：输入值

function isDigitalString( sValue )
{
	if( sValue == null )
	{
		return false;
	}

	for( i = 0; i < sValue.length; i ++ )
	{
		if( isDigital( sValue.charAt( i ) ) == false )
		{
			return false;
		}
	}
}



function is_date(theDate){
	var Ret = false;
	var mark1;
	var mark2;
    
	if(theDate=="")
		return true;
	cd=new Date();

	if ( (mark1 = theDate.indexOf('-'))==-1)
		mark1=theDate.indexOf('-')
	if (mark1>-1)
	{
		if ( (mark2 = theDate.indexOf('-',mark1+1)) ==-1)
			mark2=theDate.indexOf('-',mark1+1);
		if ((mark2>-1)&&(mark2+1<theDate.length) )
		{
			var year = new var_to_obj(theDate.substring(0,mark1));
			var month = new var_to_obj(theDate.substring(mark1+1,mark2));
			var day = new var_to_obj(theDate.substring(mark2+1,theDate.length));
			var yy=year.value
            var mm=month.value
            var dd=day.value
			var Ret1=true

			if((mm==4 || mm==6 || mm==9 || mm==11) && dd==31){
		             Ret1=false
	         }
	         else if( mm==2 ){
	             if((yy%4==0 && dd>29) || (yy%4!=0 && dd>28))
	               Ret1=false
	         }
			 if (
				(is_greater(day,0))&&(is_less(day,32))&&
				(is_greater(month,0))&&(is_less(month,13))&&
				(is_greater(year,1900))&&(is_less(year,2500))&&
				(Ret1==true)
				)

				Ret=true;
		}
	}
	return(Ret);
}
///-----------
// 将一个变量转换为对象
function var_to_obj(val)
{
	this.value=val;
}
// 判断是否大于某个数

function is_greater(field,limit)
{
	var Ret = (is_numeric(field,-1) ) ? (field.value > limit )  : false;
	return(Ret);
}
// 判断是否小于某个数

function is_less(field,limit)
{
	var Ret = (is_numeric(field,-1) ) ? (field.value < limit )  : false;
	return(Ret);
}

function is_numeric(field)
{
	var Ret = true;
	var NumStr="0123456789";
	var decUsed=false;
	var chr;
	if(field.value.length<1)
		return false;
	for (var i=0;i<field.value.length;++i)
	{
		chr=field.value.charAt(i);
		if (NumStr.indexOf(chr,0)==-1)
		{
			if ( (!decUsed) && chr==".")
			{
				decUsed=true;
			}
			else
			{
				Ret=false;
			}
		}
	}
	return(Ret);
}


/**
 * 验证起止时间  add by zhangxiaoqi
 * @param {String} spanId
 * @param {Object} beginDate
 * @param {Object} endDate
 * @return {TypeName} 
 */
function isBeginEndDate(spanId, beginDate, endDate){
	if(!notEmptyOfStr(beginDate)){
		setSpanText(spanId, "&nbsp;&nbsp;请选择开始日期！");
		return false;
	}
	if(!IsThisDate(beginDate)){
		setSpanText(spanId, "&nbsp;&nbsp;请输入正确的开始日期！格式为'xxxx-xx-xx'");
		return false;
	}
	if(!notEmptyOfStr(endDate)){
		setSpanText(spanId, "&nbsp;&nbsp;请选择结束日期！");
		return false;
	} 
	if(!IsThisDate(endDate)){
		setSpanText(spanId, "&nbsp;&nbsp;请输入正确的结束日期！格式为'xxxx-xx-xx'");
		return false;
	}
	if(!checkBeginDateEndDate(beginDate,endDate)){
		setSpanText(spanId, "&nbsp;&nbsp;开始时间不能大于结束时间！");
		return false;
	} 
	return true;
}

/**
 * 获取当前星期
 * @return {TypeName} 
 */
function currentyWeekDay(){
	var d = new Date();
	var weekday=new Array(7);
	weekday[0]="星期日";
	weekday[1]="星期一";
	weekday[2]="星期二";
	weekday[3]="星期三";
	weekday[4]="星期四";
	weekday[5]="星期五";
	weekday[6]="星期六";
	return weekday[d.getDay()];
}

