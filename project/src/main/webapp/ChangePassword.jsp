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
    <link rel="stylesheet" type="text/css" href="css/modify.css" />
    <script src="js/jQuery.3.3.1.js" type="text/javascript" charset="utf-8"></script>
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
                    <a href="home">首页</a>
                </li>
                <li>
                    <a href="film">影片</a>
                </li>
                <li>
                    <a href="cinema">影院</a>
                </li>
            </ul>
        </div>
        <div class="user">
            <ul>
                <li>
                    <a href="uesr">手机用户</a>
                </li>
                <li>
                    <a href="logout">退出</a>
                </li>
                <li>
                    <a href="javascript:;">APP下载</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="bodyer">
    <div class="wrap">
        <div class="nav">
            <div class="nav-head">
                <img src="img/maizuomoren66.jpg" />
                <p class="grey">手机用户</p>
                <p>余额：<span class="red">0</span></p>
            </div>
            <div class="nav-list">
                <ul>
                    <li>
                        <a href="myOrder">我的订单</a>
                    </li>
                    <li>
                        <a href="myCard">我的卖座卡</a>
                    </li>
                    <li>
                        <a href="myCoupon">我的现金券</a>
                    </li>
                    <li>
                        <a href="myPhone">绑定手机</a>
                    </li>
                    <li>
                        <a href="loginPws" class="active">登录密码</a>
                    </li>
                    <li>
                        <a href="safePws">安全密码</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main">
            <h1 class="bigTitle">设置登录密码</h1>
            <div class="mainContent">
                <div class="count">
                    <div class="tit">
                        <img src="img/phone.png" alt="" />
                        <p>已绑定手机号<span class="red">188****2610</span></p>
                    </div>
                    <div class="form">
                        <div class="form-group">
                            <div class="form-control code">
                                <input type="text" class="control-input" id="identifyCode" placeholder="请输入验证码" />
                                <span class="red sendCode" onclick="sendCode()">发送验证码</span>
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
                            <button class="btn" onclick="sure()">确认</button>
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
            <img src="img/mark.png" />
        </div>
        <div class="f-contact">
            <img src="img/contact.png" />
        </div>
        <div class="f-links">
            <img src="img/links.png" />
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
    <img src="img/cop.png"/>
</div>

<script src="js/modify.js" type="text/javascript" charset="utf-8"></script>
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
