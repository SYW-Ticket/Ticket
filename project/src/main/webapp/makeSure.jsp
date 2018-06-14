<%@page contentType="text/html" isELIgnored="false" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>确认订单</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta content="maizuo" name="author">
		<meta name="copyright" content="Copyright (c) 2016 maizuo.">
		<meta content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<meta content="telephone=no" name="format-detection">
		<link rel="stylesheet" type="text/css" href="/css/payPage.css"/>
		<script type="text/javascript" src="/js/jquery-1.10.1.min.js" ></script>
	</head>
	
	<body>
		<div id="main">
			<div data-reactroot="">
				<div class="application">
					<div class="navbar-wrap">
						<div class="navbar inner">
							<h1><a href="https://www.maizuo.com/#/">maizuo</a></h1>
							<div class="city">
								<!-- react-text: 9 -->武汉
								<!-- /react-text --><i class="icon-caret-down"></i></div>
							<div class="menu">
								<ul>
									<li class="">首页</li>
									<li class="">影片</li>
									<li class="">影院</li>
								</ul>
							</div>
							<div class="app"><span><!-- react-text: 18 -->APP下载<!-- /react-text --><i class="icon-caret-down"></i></span></div>
							<div class="sign">
								<ul>
									<li>手机用户4942</li>
									<li>退出</li>
								</ul>
							</div>
						</div>
						<div class="city-view-wrap inner">
							<div class="city-view hidden"><i class="icon-caret-up"></i>
								<div class="content">
									<div class="clearfix hot"><span>热 门</span>
										<div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- react-empty: 43 -->
						<!-- react-empty: 44 -->
					</div>
					<div class="application-main">
						<div class="preorder-inner clearfix">
							<div class="breadcrumb">
								<ul class="breadcrumb-list">
									<li class="breadcrumb-item"><i class="breadcrumb-num">1</i>
										<!-- react-text: 2500 -->选择影院，电影
										<!-- /react-text -->
									</li>
									<li class="breadcrumb-item"><i class="breadcrumb-num">2</i>
										<!-- react-text: 2503 -->在线选座
										<!-- /react-text -->
									</li>
									<li class="breadcrumb-item active"><i class="breadcrumb-num">3</i>
										<!-- react-text: 2506 -->确认订单并支付
										<!-- /react-text -->
									</li>
									<li class="breadcrumb-item"><i class="breadcrumb-num">4</i>
										<!-- react-text: 2509 -->到店自助取票观影
										<!-- /react-text -->
									</li>
								</ul>
							</div>
							<p class="title">
	<!-- react-text: 2511 -->订单信息
	<!-- /react-text -->
			<span class="order-tips">请您确认订单，并在  15 分钟内付款，如超时系统将自动释放您的订票</span>
			<span class="time-count">
				<span class="remain-time">
					<i class="icon-clock"></i>剩余支付时间：
				</span><span class="counter">13 : 58</span>
			</span>
						</p>
							<div class="ticket-detail">
								<div class="poster"><img class="seat" src="./img/6735bd2213bf4978ddcf70a85f07668f.jpg"></div>
								<div class="info" style="float: right;">
									<table class="seat-detail">
										<tbody>
											<tr class="head">
												<th>电影</th>
												<th>场次</th>
												<th>数量/座位</th>
												<th>单价</th>
												<th>订单手机号</th>
												<th class="total">小计</th>
											</tr>
											<tr>
												<td>
													<p>${order.getPlatoon().getFilm().getFilmName()}</p>
													<p>${order.getPlatoon().getFilm().getThreeDLV()}</p>
													<p>${order.getPlatoon().getFilm().getFilmLength()}</p>
												</td>
												<td class="schedule">
													<p>${order.getPlatoon().getHallBean().getCinemaBean().getCinema_name()}</p>
													<p>${order.getPlatoon().getHallBean().getHall_name()}</p>
													<p>${order.getPlatoon().getShow_start_time()}</p>
												</td>
												<td>
													<p>${order.getTicketNum()}</p>
													<p><span class="seat">${order.getSeats()}</span></p>
												</td>
												<td class="price">${order.getPlatoon().getFilm_price()}</td>
												<td class="mobile">${order.getUser().getTel()}</td>
												<td class="total">${order.getTotalPrice()}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<p>选择优惠抵扣方式</p>
							<div class="mobile-ipt hide">
								<p class="mobile-tips">购买成功后，取票验证码将发送到此手机号</p><input type="tel" placeholder="输入手机号" maxlength="11" value=${user.tel}></div>
							<div class="redeem">
								<div class="">
									<p class="redeem-nav"><span class="active">我有卖座卡</span><span class="">我有现金券</span></p>
									<div class="card-view">
										<p class="card-operation"><i>＋</i>
											<!-- react-text: 2562 -->添加新的卖座卡
											<!-- /react-text -->
										</p>
									</div>
								</div>
								<div class="coin">
									<div class="checkbox disabled"></div><span><!-- react-text: 2569 -->可使用余额：<!-- /react-text --><i>${user.money}</i></span></div>
							</div>
							<div class="summation">
								<table>
									<tbody>
										<tr>
											<td>订单总额：</td>
											<td class="value">
												<!-- react-text: 2577 -->¥
												<!-- /react-text -->
												<!-- react-text: 2578 -->35
												<!-- /react-text -->
											</td>
										</tr>
										<tr>
											<td>优惠抵扣：</td>
											<td class="value">
												<!-- react-text: 2582 -->¥
												<!-- /react-text -->
												<!-- react-text: 2583 -->0
												<!-- /react-text -->
											</td>
										</tr>
										<tr>
											<td>待付金额：</td>
											<td class="value pay">
												<!-- react-text: 2587 -->¥
												<!-- /react-text -->
												<!-- react-text: 2588 -->35
												<!-- /react-text -->
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="security-code hide"><span>为保障您的账户安全，使用卖座卡/余额，需输入安全密码</span><input type="password" class="security-ipt" maxlength="6" placeholder="请输入安全密码">
						
							<span class="fogetten">忘记密码</span></div><button id="makeSure" class="confirm-btn" onclick="test(${user.id})">确认</button></div>
</div>
					<div class="footer">
						<div class="content inner">
							<h2><img src="./img/97d132d70ddef38021064aae67963766.png" alt="卖座"><!-- react-text: 96 -->电影订座&nbsp;&nbsp;就上卖座<!-- /react-text --></h2>
							<div class="service"><img src="./img/cceb956981ce7ae563401d65b3e6421f.png" alt="卖座客服"><span>电话：</span><span class="moblie">400-1808-400</span><span>周日-周四：9:00-22:00&nbsp;&nbsp;周五-周六：9:00-22:30</span></div>
							<div class="follow">
								<div class="item"><img src="./img/b9e924f8e417675ce2e125649d7530ce.png">
									<div class="tip"><img src="./img/ec5f0f45fc548050c5e613a416294452.png" width="151">
										<p>扫码下载卖座电影APP</p><span class="icon-caret-down"></span></div>
								</div>
								<div class="item"><img src="./img/d4af003a3ca8ad39fb8715440c15b17c.png">
									<div class="tip"><img src="./img/500b205c9fbf141e4b3c2824d4e8d7fe.png" width="151">
										<p>扫码关注卖座官方微信</p><span class="icon-caret-down"></span></div>
								</div>
								<div class="item">
									<a href="http://www.weibo.com/maizuo" target="_blank"><img src="./img/ce402ffd0ccd2499f976e53db87ecf90.png"></a>
								</div>
							</div>
						</div>
						<div class="side-warp">
							<div class="inner">
								<div class="clearfix subnav">
									<ul>
										<li>
											<a href="https://www.maizuo.com/#/maizuo">关于卖座</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/contact">联系我们</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/cooperation">商务合作</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/partner">合作伙伴</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/recruit">诚聘英才</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/help">使用帮助</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/refund">退票服务</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/service">服务条款</a>
										</li>
										<li>
											<a href="https://www.maizuo.com/#/community">社区管理</a>
										</li>
									</ul>
								</div>
								<p class="copyright">
									<!-- react-text: 141 -->Copyright ©
									<!-- /react-text -->
									<!-- react-text: 142 -->2018
									<!-- /react-text -->
									<!-- react-text: 143 -->maizuo. All Rights Reserved 卖座网 版权所有 增值业务经营许可证:粤B2-200502318
									<!-- /react-text -->
								</p><img src="img/1c40acb236a22bea60e5889ad57cdd7c.png"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<script type="text/javascript">
		function test(date){
			var UserId=date;
			console.log()
			window.location.href="Order/allSeatsByPId/"+UserId;
		}
		</script>
	</body>
</html>