$(function() {
	// alert(0);
	if($(".orderList").show()) {
		getMyOrder();
	}
})

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
$(".nav-list ul li").click(function() {
	$(this).find('a').addClass('act').parent().siblings().find('a').removeClass('act');
	var regName = $(this).text();
	var p = $(this).index();
	if(regName != '登录密码' && regName != '安全密码') {
		$(".bigTitle").text(regName);
		$('.part').hide().eq(p).show();
	} else {
		$(".bigTitle").text("设置" + regName);
	}
})

//发送验证码
function sendCode(date) {
	$.post("UserInfo/sendMessage",{"tel": date}).then(function(data){
		console.log(data)
	});

}

//验证 验证码 
$("#identifyCode").blur(function(){
	var identifyCode = $("#identifyCode").val();
	var tel = $("#tel").val();
	var content = {
		ShortMessage: identifyCode,
		tel: tel
	};
	$.post("UserInfo/CheckShortmessage",content).then(function(data){
		console.log(data)
	})
})

//确认提交
function sure(teltoken) {
	var identifyCode = $("#identifyCode").val();
	var newPws = $("#newPws").val();
	var rePws = $("#rePws").val();
	if(identifyCode != '' && newPws != '' && rePws != '') {
		if(rePws == newPws) {
			var os=newPws;
			var content = {
				/*之后此处需要修改为 user.tel*/
				tel: teltoken,
				pws: newPws
			};
			$.post("UserInfo/ModeifyPassword", {"tel": teltoken,pws:os}).then(function(data) {
				console.log(data)
				alert(data.msg);
			})
		} else {
			alert("两次密码不一致")
		}
	}
}

//卖座卡 选项卡效果
$(".cardList li").click(function() {
	var i = $(this).index();
	$(this).addClass('cur').siblings().removeClass('cur');
	$(".cardMi").hide().eq(i).show()
})

//我的订单
function getMyOrder() {
	$(".o-tab .o-det").remove();
	/*var url = "/js/orderDetail.json";*/
	var url = "/Order/unpay";
	/*Ajax.get("/Order/unpay",{"userId": 1}).then(function(data) {*/
	$.post("/Order/unpay",{"userId": 2}).then(function(data) {
		console.log(typeof data);
		if(data){
			$(".orderPanel").show();
			var sp1 = "<span>"+data.platoon.film.filmName+"</span>";
			var sp2 = "<span>"+data.platoon.hallBean.hall_name+"</span>";
			var sp3 = "<span>"+data.platoon.show_start_date+"</span>";
			var sp4 = "<span>"+data.ticketNum+"</span>";
			var sp5 = "<span>"+data.user.tel+"</span>";
			var sp6 = "<span>"+data.totalPrice+"</span>";
			var orderDetailHtml = "<div class='o-det'>"+sp1+sp2+sp3+sp4+sp5+sp6+"</div>";
			$(".o-tab").append(orderDetailHtml);
		}
	})
}

//当前订单
function currentOrder(){
	getMyOrder();
}

//历史订单
function historyOrder(){
	$(".o-tab .o-det").remove();
	$.get("Order/History",{id:"1"},function(date){
		$.each(date,function (index,obj) {

			if(obj){
				$(".orderPanel").show();
				var sp1 = "<span>"+obj.platoon.film.filmName+"</span>";
				var sp2 = "<span>"+obj.platoon.hall.hallName+"</span>";
				var sp3 = "<span>"+obj.platoon.showStartDate+"</span>";
				var sp4 = "<span>"+obj.ticketNum+"</span>";
				var sp5 = "<span>"+obj.userId+"</span>";
				var sp6 = "<span>"+obj.totalPrice+"</span>";
				var orderDetailHtml = "<div class='o-det'>"+sp1+sp2+sp3+sp4+sp5+sp6+"</div>";
				$(".o-tab").append(orderDetailHtml);
			}
		});

		})


}