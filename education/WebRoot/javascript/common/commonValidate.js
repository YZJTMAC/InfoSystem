var BasicValidate = function() {
		return {
			/**
			 * 字符长度验证
			 * @param {Object} c 待验证字符
			 * @param {Object} b 最小长度
			 * @param {Object} a 最大长度
			 * @return {TypeName} 
			 */
			isLengthBetween: function(c, b, a) {
				if (!c || !c instanceof String) {
					return false
				}
				return c.length >= b && c.length <= a
			}, 
			/**
			 * 
			 * @param {Object} b
			 * @param {Object} a
			 * @return {TypeName} 
			 */
			testReg: function(b, a) {
				return a.test(b)
			},
			/**
			 * 字符不为空验证
			 * @param {Object} a
			 * @return {TypeName} 
			 */
			isNotEmpty: function(a) {
				if (!a || !a instanceof String) {
					return false
				}
				return jQuery.trim(a).length > 0
			},
			isEmpty: function(a) {
				if (!a || jQuery.trim(a).length == 0) {
					return true
				}
				return false
			},
			/**
			 * 验证手机号码
			 * @return {TypeName} 
			 */
			checkReceiverMobile: function(c) {
				return BasicValidate.testReg(c, /^[0-9]{8,11}$/) ;
			},
			/**
			 * 验证是否为全部数字
			 * @param {Object} a
			 * @return {TypeName} 
			 */
			isFullNumber: function(a) {
				var b = /^\d+$/;
				return BasicValidate.testReg(a, b)
			},
			/**
			 * 验证 15~18位的身份证，18未最后可能是X
			 * @param {Object} a
			 * @return {TypeName} 
			 */
			isIdNumber: function(a) {
				var b = /(^\d{15}$)|(^\d{17}([0-9]|[x|X])$)/;
				return BasicValidate.testReg(a, b)
			},
			/**
			 * 验证 1~10位的数字，可保留两位小数
			 * @param {Object} a
			 * @return {TypeName} 
			 */
			isNumber: function(a) {
				var b = /^(([1-9]{1}\d{0,9})|([0]{1}))(\.(\d){1,2})?$/;
				return BasicValidate.testReg(a, b)
			},
			/**
			 * 验证邮箱
			 * 
			 */
			checkMail :　function verifyAddress(obj) {  
				 var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;  
				 return pattern.test(obj);  
			}
			
		}
}();

/**
 * 验证并提示
 * @return {TypeName}  
 * 返回 true or false
 */
var validateAndShowTip = function() {
		return {
			showTipB: function(divName, id, str, foucs) {
				$("div[name='"+divName+"']").show();
				$("div[name='"+divName+"']").text(str)
				if(foucs) 
				$("#"+ id).focus();
			},
			showTip: function(divName, str, foucs) {
				$("div[name='"+divName+"']").show();
				$("div[name='"+divName+"']").text(str)
				if(foucs) 
				$("#"+ divName).focus();
			},
			hideTip: function(divName) {
				$("div[name='"+divName+"']").hide();
			},
			validateAccount: function(a,b,c) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					jQuery.generalAlert("请填写登录账号，且不超过"+ c + "个字符");
					return false
				}
				return true;
			},
			validatePaswd: function(a,b,c) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					jQuery.generalAlert("请填写登录密码，且不超过"+ c + "个字符");
					return false
				}
				return true;
			},
			validateRealName: function(a,b,c) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					jQuery.generalAlert("请填写真实姓名，且不超过"+ c + "个字符");
					return false
				}
				return true;
			},
			validateIdNumb: function(a,b,c) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					jQuery.generalAlert("身份证填写错误，且不超过"+ c + "个字符");
					return false
				} else if(!BasicValidate.isFullNumber(a)) {
					jQuery.generalAlert("身份证填写错误，请填写18位数字");
					return false
				} 
				return true;
			},
			validateTeacherNo: function(a,b,c) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					jQuery.generalAlert("请填写教师编号，且不超过"+ c + "个字符");
					return false
				}
				return true;
			},
			validateCharAndNumber: function(a,b,c, divName, id, focus) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					validateAndShowTip.showTipB(divName, id, "请填写，且不超过"+ c + "个字符", focus );
					return false
				} else if(!BasicValidate.isNumber(a)) {
					validateAndShowTip.showTipB(divName, id, "请填写1~10位的数字，可保留两位小数", focus);
					return false
				} else {
					validateAndShowTip.hideTip(divName);
				}
				return true;
			},
			validateCharB: function(a,b,c, divName, focus) {
				if(!BasicValidate.isEmpty(a)) {
					if(!BasicValidate.isLengthBetween(a, b, c)) {
						validateAndShowTip.showTip(divName, "请填写，且不超过"+ c + "个字符", focus);
						return false
					} else {
						validateAndShowTip.hideTip(divName);
						return true;
					}
				}
				return true;
			},
			validateChar: function(a,b,c, divName, focus) {
				if(!BasicValidate.isNotEmpty(a) || !BasicValidate.isLengthBetween(a, b, c)) {
					validateAndShowTip.showTip(divName, "请填写，且不超过"+ c + "个字符", focus);
					return false
				} else {
					validateAndShowTip.hideTip(divName);
				}
				return true;
			},
			validateMobile: function(a,divName, focus) {
				if(!BasicValidate.checkReceiverMobile(a)) {
					validateAndShowTip.showTip(divName, "请填写正确的手机号码", focus);
					return false
				} else {
					validateAndShowTip.hideTip(divName);
				}
				return true;
			},
			validateNumber: function(a, divName, id, focus) {
				if(!BasicValidate.isNumber(a)) {
					validateAndShowTip.showTipB(divName, id, "请填写1~10位的数字，可保留两位小数", focus);
					return false
				} else {
					validateAndShowTip.hideTip(divName);
				}
				return true;
			}
		}
}();



