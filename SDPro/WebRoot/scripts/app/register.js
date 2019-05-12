define(["jquery","validate"],function($,v){
	$("#zhuce_validate").validate({
		rules:{
			username:{required: true},
			pwd:{
				required: true,
				minlength:6,
				maxlength:20
			},
			pwd2:{
				required:true,
				minlength:6,
				maxlength:20,
				equalTo:"#pwd"
			},
			phone:{
				required:true,
				digits:true
			}
		},
		messages: {
		      username: {
		        required: "请输入用户名"
		      },
		      pwd: {
		        required: "请输入密码",
		        minlength: "密码长度不能小于 5个字母"
		      },
		      pwd2: {
		        required: "请再次输入密码",
		        minlength: "密码长度不能小于 5 个字母",
		        equalTo: "两次密码输入不一致"
		      },
		      phone: "手机号只能为数字"
		    },
		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('error');
			$(element).parents('.control-group').addClass('success');
		}
	});
});