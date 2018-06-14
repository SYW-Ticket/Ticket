<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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

    <link rel="stylesheet" type="text/css" href="http://119.23.42.247:83/css/payPage2.css"/>
    <script type="text/javascript" src="http://119.23.42.247:83/js/jquery-1.10.1.min.js" ></script>
    <base href="<%=request.getContextPath()%>/"/>
</head>

<body>
<div id="main">
    <div data-reactroot="">
        <div class="application">
            <div class="navbar-wrap">
                <div class="navbar inner">
                    <h1><a href="https://www.maizuo.com/#/">maizuo</a></h1>
                    <div class="city">
                        <!-- react-text: 9 -->深圳
                        <!-- /react-text --><i class="icon-caret-down"></i></div>
                    <div class="menu">
                        <ul>
                            <li class="">首页</li>
                            <li class="active"><a href="film/LoadingByPage/1">影片</a></li>
                            <li class="">影院</li>
                        </ul>
                    </div>
                    <div class="app"><span><!-- react-text: 18 -->APP下载<!-- /react-text --><i class="icon-caret-down"></i></span></div>
                    <div class="sign">
                        <c:choose>
                            <c:when test="${user==null}">
                                <ul>
                                    <li><a href="login.jsp">快速登陆</a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul>
                                    <li><a href="ChangePassword.jsp">欢迎用户${user.tel}</a></li>
                                    <li><a href="users/logout">退出登陆</a></li>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="city-view-wrap inner">
                    <div class="city-view hidden"><i class="icon-caret-up"></i>
                        <div class="content">
                            <div class="clearfix hot"><span>热 门</span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- react-empty: 43 -->
                <!-- react-empty: 44 -->
            </div>
            <div class="application-main">
                <div class="pay-inner clearfix">
                    <div class="breadcrumb">
                        <ul class="breadcrumb-list">
                            <li class="breadcrumb-item"><i class="breadcrumb-num">1</i>
                                <!-- react-text: 1417 -->选择影院，电影
                                <!-- /react-text -->
                            </li>
                            <li class="breadcrumb-item"><i class="breadcrumb-num">2</i>
                                <!-- react-text: 1420 -->在线选座
                                <!-- /react-text -->
                            </li>
                            <li class="breadcrumb-item active"><i class="breadcrumb-num">3</i>
                                <!-- react-text: 1423 -->确认订单并支付
                                <!-- /react-text -->
                            </li>
                            <li class="breadcrumb-item"><i class="breadcrumb-num">4</i>
                                <!-- react-text: 1426 -->到店自助取票观影
                                <!-- /react-text -->
                            </li>
                        </ul>
                    </div>
                    <p>订单信息</p>
                    <div class="ticket-info">
                        <div><span class="time-count"><span class="remain-time"><i class="icon-clock"></i><!-- react-text: 1433 -->剩余支付时间：<!-- /react-text --></span><span class="counter">13 : 54</span></span>
                        </div>
                        <div class="last-child">
                            <div class="ticket-detail">
                                <!-- react-text: 1437 -->${orderList2.getPlatoon().getFilm().getFilmName()}/${orderList2.getPlatoon().getFilm().getThreeDLV()}
                                <!-- /react-text --><span class="count"><!-- react-text: 1439 -->${orderList2.getTicketNum()}<!-- /react-text --><!-- react-text: 1440 --> 张<!-- /react-text --></span></div>
                            <div class="summation"><span class="pay-tips">等付金额：</span><span class="cny">￥${orderList2.getTotalPrice()}</span></div>
                        </div>
                    </div>
                    <p>选择支付方式</p>
                    <div class="payment-list">
                        <div class="suggestion">
                            <p>推荐支付：</p>
                            <ul>
                                <li>
                                    <!--<div class="checkbox"></div>-->
                                    <div class="payment"><img src="http://119.23.42.247:83/img/c97797cca23f6fae15710b43ee3bcb46.png" alt="微信二维码"></div>
                                </li>
                            </ul>
                        </div>
                    </div><form action="/Order/allSeatsByPId2"><input type="hidden" value="2" name="UserId"><input class="disabled" type="submit" <%--onclick="pay(1)"--%>>确认支付</form></div>












            </div>
            <div class="footer">
                <div class="content inner">
                    <h2><img src="/img/97d132d70ddef38021064aae67963766.png" alt="卖座"><!-- react-text: 77 -->电影订座&nbsp;&nbsp;就上卖座<!-- /react-text --></h2>
                    <div class="service"><img src="/img/cceb956981ce7ae563401d65b3e6421f.png" alt="卖座客服"><span>电话：</span><span class="moblie">400-1808-400</span><span>周日-周四：9:00-22:00&nbsp;&nbsp;周五-周六：9:00-22:30</span></div>
                    <div class="follow">
                        <div class="item"><img src="/img/b9e924f8e417675ce2e125649d7530ce.png">
                            <div class="tip"><img src="/img/ec5f0f45fc548050c5e613a416294452.png" width="151">
                                <p>扫码下载卖座电影APP</p><span class="icon-caret-down"></span></div>
                        </div>
                        <div class="item"><img src="/img/d4af003a3ca8ad39fb8715440c15b17c.png">
                            <div class="tip"><img src="/img/500b205c9fbf141e4b3c2824d4e8d7fe.png" width="151">
                                <p>扫码关注卖座官方微信</p><span class="icon-caret-down"></span></div>
                        </div>
                        <div class="item">
                            <a href="http://www.weibo.com/maizuo" target="_blank"><img src="http://119.23.42.247:83/img/ce402ffd0ccd2499f976e53db87ecf90.png"></a>
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
                            <!-- react-text: 122 -->Copyright ©
                            <!-- /react-text -->
                            <!-- react-text: 123 -->2018
                            <!-- /react-text -->
                            <!-- react-text: 124 -->maizuo. All Rights Reserved 卖座网 版权所有 增值业务经营许可证:粤B2-200502318
                            <!-- /react-text -->
                        </p><img src="http://119.23.42.247:83/img/1c40acb236a22bea60e5889ad57cdd7c.png"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function pay(date){
        var body=date;
        console.log()
        window.location.href="/payment/test/"+body;
    }
</script>


</body>
</html>
