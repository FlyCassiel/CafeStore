//---密码字符字母长度验证---//
$(document).ready(function(){
				
				/*8-32个字符*/
				$("#password").change(function(){
					var str = $("#password").val();
					var regUpper = /[A-Z]/;
		            var regLower = /[a-z]/;
					if(str.length>=8&&str.length<=32){
						$("#pwdLength").css("color","#41CE48");
						$("#pwdLength_1").css("display","block");
					}else{
						$("#pwdLength").css("color","#333333");
						$("#pwdLength_1").css("display","none");
					}
				});
				/*大小写字母*/
				$("#password").change(function(){
					var str = $("#password").val();
					var regUpper = /[A-Z]/;
		            var regLower = /[a-z]/;
					if (regLower.test(str)&&regUpper.test(str)){
						$("#pwdChar").css("color","#41CE48");
						$("#pwdChar_1").css("display","block");
			
				    }else{
						$("#pwdChar").css("color","#333333");
						$("#pwdChar_1").css("display","none");
					}
			  	});
			  	/*数字*/
				$("#password").change(function(){
					var str = $("#password").val();
					var regUpper = /[A-Z]/;
		            var regLower = /[a-z]/;
		            var regNum = /[0-9]/;
					if (regNum.test(str)){
						$("#pwdNumber").css("color","#41CE48");
						$("#pwdNumber_1").css("display","block");
				    }else{
						$("#pwdNumber").css("color","#333333");
						$("#pwdNumber_1").css("display","none");
					}
			    });
			    /*密码强度*/
			   $("#password").change(function(){
					var str = $("#password").val();
					var regUpper = /[A-Z]/;
		            var regLower = /[a-z]/;
		            var regNum = /[0-9]/;
					if(regUpper.test(str) && regNum.test(str) && str.length>=8 && str.length<=32){
						$("#pwd_strong").css("background-color","#41CE48");
						$("#pwdComplexFlag").css("display","inline-block");
					}else{
						$("#pwd_strong").css("background-color","#F5F5F5");
						$("#pwdComplexFlag").css("display","none");
					}
				});	   
});

