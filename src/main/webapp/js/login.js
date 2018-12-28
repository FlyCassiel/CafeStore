/*验证码验证*/
$(document).ready(function() {
	var verifyCode = new GVerify("v_container");
	$("#checkcode").blur(function() {
		var res = verifyCode.validate($("#checkcode").val());
		if (res) {
			$("#checkcodespan").html("验证码正确");
			$("#checkcodespan").css("color", "green");

		} else {
			$("#checkcodespan").html("验证码错误");
			$("#checkcodespan").css("color", "red");
		}
	})
})

$(document).ready(
		function() {
			/* 密码不为空 */
			$("#password").blur(function() {
				if ($("#password").val() == false) {
					$("#passwordspan").html("请输入您的密码");
					$("#passwordspan").css("color","red");
				} 
			});
			$("#password").focus(function() {
				$("#passwordspan").html("");
			});
			
			/* 验证码不为空 */
			$("#checkcode").blur(function() {
				
				if ($("#checkcode").val() == false) {
					$("#checkcodespan").html(" 请输入验证码");
				} 
			});
		})
