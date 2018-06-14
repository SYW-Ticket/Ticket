<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    当前是支付页面，订单号${oid}<br>请扫码
    <img src="/payment/test?body=${orderList3.id}">   <%--这个地址用与获取TestServlet中放到session中的图片，指向的是ImgServlet--%>
</body>
</html>
