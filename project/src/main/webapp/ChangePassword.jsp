<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2018/6/7
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <%--<link rel="stylesheet" type="text/css" href="http://119.23.42.247:83/css/modify.css" />--%>
    <link rel="stylesheet" type="text/css" href="/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="/css/user.css"/>
    <script src="http://119.23.42.247:83/js/jQuery.3.3.1.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<div class="header">
    <div class="wrap">
        <div class="logo">
            <img src="img/logo.png" />
        </div>
        <div class="h-nav">
            <ul>
                <li>
                    <a href="javascript:;">首页</a>
                </li>
                <li>
                    <a href="javascript:;">影片</a>
                </li>
                <li>
                    <a href="javascript:;">影院</a>
                </li>
            </ul>
        </div>
        <div class="user">
            <ul>
                        <ul>
                            <li><a href="ChangePassword.jsp">欢迎用户${user.tel}</a></li>
                            <li><a href="users/logout">退出登陆</a></li>
                        </ul>
            </ul>
        </div>
    </div>
</div>
<div class="bodyer">
    <div class="wrap">
        <div class="nav">
            <div class="nav-head">
                <img src="http://119.23.42.247:83/img/maizuomoren66.jpg" />
                <p class="grey">手机用户</p>
                <p>余额：<span class="red">0</span></p>
            </div>
            <div class="nav-list">
                <ul>
                    <li>
                        <a href="javascript:;" class="act" onclick="getMyOrder()">我的订单</a>
                    </li>
                    <li>
                        <a href="javascript:;">我的卖座卡</a>
                    </li>
                    <li>
                        <a href="javascript:;">我的现金券</a>
                    </li>
                    <li>
                        <a href="javascript:;">绑定手机</a>
                    </li>
                    <li>
                        <a href="javascript:;">登录密码</a>
                    </li>
                    <li>
                        <a href="javascript:;">安全密码</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main">
            <h1 class="bigTitle">我的订单</h1>
            <div class="mainContent">
                <!--我的订单-->
                <div class="part orderList">
                    <div class="orderPanel">
                        <div class="orderWarp">
                            <img src="img/film.jpg" class="film-pic"/>
                            <div class="filmDetail">
                                <div class="tabList o-tab">
                                    <div class="o-tit">
                                        <span>电影</span>
                                        <span>影院</span>
                                        <span>场次</span>
                                        <span>票数</span>
                                        <span>订单手机号</span>
                                        <span>订单金额</span>
                                    </div>
                                </div>
                                <div class="btns">
                                    <span class="sysj">剩余支付时间:<h3 class="red">12:34</h3></span>
                                    <button class="btn btn-primary zf" id="pay" onclick="pay()">立即支付</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tabList">
                        <div class="t-head">
                            <span>订单列表</span>
                            <p><span class="cany" onclick="currentOrder()">当前订单</span>&nbsp;/&nbsp;<span onclick="historyOrder()">历史订单</span></p>
                        </div>
                        <div class="t-tit">
                            <span>订单号</span>
                            <span>影片</span>
                            <span>影院</span>
                            <span>场次</span>
                            <span>票数/张</span>
                            <span>订单金额</span>
                            <span>状态</span>
                        </div>

                        <table class="t-body">
                        </table>
                        <h1 class="no-order">无订单</h1>
                    </div>
                </div>
                <!--我的卖座卡-->
                <div class="part myCard">
                    <div class="tit addTit" id="cardTit">
                        <img src="img/down.png" />
                        <span>添加新的卖座卡</span>
                    </div>
                    <div class="panel">
                        <ul class="cardList">
                            <li class="cur">卖座卡</li>
                            <li>电子卖座卡</li>
                        </ul>
                        <div class="cardMi">
                            <input type="text" class="cashCode" placeholder="请输入卖座卡号" />
                            <input type="text" class="cashCode" placeholder="请输入卖座卡密码" />
                            <button class="btn btn-primary btn-l">查&nbsp;询</button>
                        </div>
                        <div class="cardMi cardDi">
                            <input type="text" class="cashCode"  placeholder="请输入卡号" />
                            <button class="btn btn-primary btn-l">查&nbsp;询</button>
                        </div>
                    </div>
                </div>
                <!--我的现金券-->
                <div class="part myCash">
                    <div class="tit addTit cashTit">
                        <img src="img/down.png" />
                        <span>添加新的现金券</span>
                    </div>
                    <div class="car cardPanel">
                        <div class="panel">
                            <div class="margin-b-2">
                                <input type="text" class="cashCode" id="" placeholder="请输入现金券码" />
                                <button class="btn btn-primary btn-l">添&nbsp;加</button>
                            </div>
                        </div>
                        <h1 class="no-order">无现金券</h1>
                    </div>
                    <div class="car">
                        <h1 class="no-order">无现金券</h1>
                    </div>

                </div>
                <!--绑定手机-->
                <div class="part bandPhone">
                    <div class="phone">
                        <img src="img/phone.png" class="margin-b-2" />
                        <p class="margin-b-2">绑定的手机号<span class="red">188****2610</span></p>
                        <p>如需更改手机号码，请拨打客服电话：400-1808-400</p>
                    </div>
                </div>
                <!--修改密码-->
                <div class="part count">
                    <div class="tit">
                        <img src="img/phone.png" alt="" />
                        <p>已绑定手机号<span class="red" id="tel">${user.tel}</span></p>
                    </div>
                    <div class="form">
                        <div class="form-group">
                            <div class="form-control code">
                                <input type="text" class="control-input" id="identifyCode" placeholder="请输入验证码" />
                                <span class="red sendCode" onclick="sendCode(${user.tel})">发送验证码</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-control">
                                <input type="password" class="control-input" id="newPws" placeholder="设置新密码8-16位" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-control">
                                <input type="password" class="control-input" id="rePws" placeholder="请再次输入登录密码" />
                            </div>
                        </div>
                        <div class="btns">
                            <button class="btn" onclick="sure(${user.tel})">确认</button>
                        </div>
                    </div>
                </div>
                <!--安全密码-->
                <div class="part safeCount">
                    <div class="tit">
                        <img src="img/phone.png" alt="" />
                        <p>已绑定手机号<span class="red">188****2610</span></p>
                    </div>
                    <div class="form">
                        <div class="form-group">
                            <div class="form-control">
                                <input type="text" class="control-input" id="safeCode" placeholder="请输入验证码" />
                                <span class="red sendCode" onclick="sendCode()">发送验证码</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-control">
                                <input type="text" class="control-input" id="safePws" placeholder="设置安全密码 6位数字" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-control">
                                <input type="text" class="control-input" id="reSafe" placeholder="请再次输入安全密码" />
                            </div>
                        </div>
                        <div class="btns">
                            <button class="btn btn-primary btn-block" onclick="safe()">确&nbsp;认</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="wrap">
        <div class="mark">
            <img src="http://119.23.42.247:83/img/mark.png" />
        </div>
        <div class="f-contact">
            <img src="http://119.23.42.247:83/img/contact.png" />
        </div>
        <div class="f-links">
            <img src="http://119.23.42.247:83/img/links.png" />
        </div>
    </div>
</div>
<div class="botter">
    <div class="a-links">
        <a href="">关于卖座</a>
        <a href="">联系我们</a>
        <a href="">商务合作</a>
        <a href="">合作伙伴</a>
        <a href="">诚聘英才</a>
        <a href="">使用帮助</a>
        <a href="">退票服务</a>
        <a href="">服务条款</a>
        <a href="">社区管理</a>
    </div>
    <p class="copyR">Copyright © 2018 maizuo. All Rights Reserved 卖座网 版权所有 增值业务经营许可证:粤B2-200502318</p>
    <img src="http://119.23.42.247:83/img/cop.png"/>
</div>

<%--<script src="http://119.23.42.247:83/js/modify.js" type="text/javascript" charset="utf-8"></script>--%>
<script src="/js/modify.js" type="text/javascript" charset="utf-8"></script>
<%--
<script>
    function sendCode() {
        $.post("UserInfo/sendMessage",{"tel":"13554244942"},function (data) {
           alert("请查收短信,一分钟之内失效")
        });
    }


</script>--%>
</body>
</html>
