var http = function(config) {
	var dtd = $.Deferred();
	$.ajax(config).then(function(data) {
		dtd.resolve(data);
	}, function() {
		alert("请求失败");
		dtd.reject();
	});
	return dtd.promise();
};

var Ajax = {
	get: function(url) {
		return http({
			url: url,
			type: 'GET'
		});
	},
	post: function(url, content) {
		return http({
			url: url,
			type: 'POST',
			data: content,
			headers: {
				'Content-type': 'application/json'
			}
		});
	},
	update: function(url, content) {
		return http({
			url: url,
			type: 'PUT',
			data: content,
			headers: {
				'Content-type': 'application/json'
			}
		});
	},
	delete: function(url) {
		return http({
			url: url,
			type: 'DELETE'
		});
	}
};

//左侧导航栏点击跳转
$(".nav-list ul").on('click', 'a', function() {
	$(this).addClass('active').parent().siblings().find('a').removeClass('active');
	var regName = $(this).text();
	if(regName == '我的订单') {
		$(".bigTitle").text(regName);
		$(".orderList").show().siblings('.part').hide();
	}else if (regName == '我的卖座卡'){
		$(".bigTitle").text(regName);
		$(".myCard").show().siblings('.part').hide();
	}else if (regName == '我的现金券'){
		$(".bigTitle").text(regName);
		$(".myCash").show().siblings('.part').hide();
	} else if(regName == '绑定手机') {
		$(".bigTitle").text(regName);
		$(".bandPhone").show().siblings('.part').hide();
	} else if(regName == '登录密码') {
		$(".count").show().siblings('.part').hide();
		$(".bigTitle").text("设置" + regName);
		$("#newPws").attr("placeholder", "设置新密码8-16位");
		$("#rePws").attr("placeholder", "请再次输入登录密码");
	} else if(regName == '安全密码') {
		$(".count").show().siblings('.part').hide();
		$(".bigTitle").text("设置" + regName);
		$("#newPws").attr("placeholder", "设置安全密码 6位数字");
		$("#rePws").attr("placeholder", "请再次输入安全密码");
	}
})

//发送验证码
function sendCode() {
	$.post("UserInfo/sendMessage",{"tel": 13554244942}).then(function(data){
		console.log(data)
	});

}

//验证 验证码 
$("#identifyCode").blur(function(){
	var identifyCode = $("#identifyCode").val();
	var content = {
		ShortMessage: identifyCode,
		tel: '13554244942'
	};
	$.post("UserInfo/CheckShortmessage",content).then(function(data){
		console.log(data)
	})
})

//确认提交
function sure() {
//	var identifyCode = $("#identifyCode").val();
	var newPws = $("#newPws").val();
	var rePws = $("#rePws").val();
	if(identifyCode != '' && newPws != '' && rePws != '') {
		if(rePws == newPws) {
			var os=newPws;
			var content = {
				/*之后此处需要修改为 user.tel*/
				tel: 123456789,
				pws: newPws
			};
			$.post("UserInfo/ModeifyPassword", {"tel": 123456789,pws:os}).then(function(data) {
				console.log(data)
			})
		} else {
			alert("两次密码不一致")
		}
	}
}