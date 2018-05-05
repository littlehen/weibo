$(document).ready(function(){
	 
	var login = $('#loginform');
	var recover = $('#recoverform');
	var speed = 400;

	$('#to-recover').click(function(){
		
		$("#loginform").slideUp();
		$("#recoverform").fadeIn();
	});
	$('#to-login').click(function(){
		
		$("#recoverform").hide();
		$("#loginform").fadeIn();
	});
	
	
	$('#login').click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url : SERVERURL + "wb_admin/login",
			type : "post",
			data : {
				username : username,
				password : password,
				drive : 'web'				
			},
			dataType : 'json',
			success : function(msg){
				if (msg != null && typeof (msg) != "undefined") {
					if (msg.isSuccess == true) {
						if (msg.data == '-1') {
							$.alert("用户名或密码错误",3);
						} else {
							sessionStorage.userInfo = JSON.stringify(msg.data);
							window.location.href = "./index.html";
						}
					}
					else
					{
						$.alert("对不起，请与系统管理员联系！",4);
						$("#password").attr('placeholder','Password');
					}
				} else {
					$.alert("系统错误",4);
				}
			},
			error : function(msg) {
				$.alert("系统错误！",4);
			}
		});
	});
    
});


//自定义信息提示框
//content:内容
//alertType: 1绿色(成功) 2蓝色(信息) 3黄色(警告) 4红色(失败)
$.alert = function(content, alertType) {
	if (alertType == 1) {
		swal(content, "", "success");
	} else if (alertType == 2) {
		swal(content, "", "info");
	} else if (alertType == 3) {
		swal(content, "", "warning");
	} else {
		swal(content, "", "error");
	}
};