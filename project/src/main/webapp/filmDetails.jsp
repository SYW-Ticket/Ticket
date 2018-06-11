<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0044)https://www.maizuo.com/#/film/4206?_k=ehejf2 -->
<html class=" ">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${filmDetail.filmName}</title>
    <base href="<%=request.getContextPath()%>/"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta content="maizuo" name="author">
    <meta name="copyright" content="Copyright (c) 2016 maizuo.">
    <meta content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <meta content="telephone=no" name="format-detection">
    <style type="text/css">
        .field {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            width: 100%;
            height: 34px;
            line-height: 34px;
            font-size: 16px;
            color: #333;
            margin-bottom: 10px;
            border: 1px solid #e5e5e5;
            border-radius: 4px;
            -webkit-box-pack: justify;
            -ms-flex-pack: justify;
            justify-content: space-between;
            -webkit-box-align: center;
            -ms-flex-align: center;
            align-items: center;
            overflow: hidden;
            transition: all 200ms ease;
        }

        .field.focus {
            border: 1px solid #ff6640;
        }

        .field.error {
            border: 1px solid #ff6640;
            margin-bottom: 2px;
        }

        .field .input {
            padding: 0 20px;
            width: 100%;
            line-height: 2em;
            background: none;
            border: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            outline: none;
            height: 24px;
        }

        .field .addon {
            padding: 0 14px;
            color: #e5e5e5;
        }

        .field .addon img {
            vertical-align: text-top;
            cursor: pointer;
        }

        .field .addonActive {
            color: #0bbe06;
        }

        .field .addonHide {
            opacity: 0;
        }
    </style>
    <style type="text/css">
        .throttle {
            color: #65d065;
        }

        .throttle.disabled {
            color: #999;
        }
    </style>
    <style type="text/css">
        .mz-modal-mask {
            position: fixed;
            top: 0;
            right: 0;
            left: 0;
            bottom: 0;
            background-color: rgba(55, 55, 55, 0.6);
            height: 100%;
            z-index: 1000;
        }

        .mz-modal-mask.mz-modal-mask-hidden {
            display: none;
        }

        .mz-modal-wrap {
            position: fixed;
            overflow: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            z-index: 1000;
        }

        .mz-modal-wrap.mz-modal-wrap-hidden {
            display: none;
        }

        .mz-modal {
            width: 520px;
            -webkit-transform-origin: -46.5px 92px 0px;
            transform-origin: -46.5px 92px 0px;
            position: relative;
            margin: 0 auto;
            background-color: #fff;
            top: 100px;
            margin-bottom: 24px;
        }

        .mz-modal-content {
            position: relative;
            border: 0;
            border-radius: 6px;
        }

        .mz-modal-content .mz-modal-close {
            position: absolute;
            right: 18px;
            background-color: transparent;
            border: none;
            cursor: pointer;
            color: #999;
            font-size: 24px;
        }

        .mz-modal-content .mz-modal-header,
        .mz-modal-content .mz-modal-body {
            padding: 15px;
        }

        .mz-modal-content .hidden {
            display: none;
        }
    </style>
    <style type="text/css">
        .login-view {
            height: 500px;
        }

        .login-view .login-form-view {
            float: right;
            margin: 55px auto 0;
        }

        .login-form-view {
            width: 310px;
            padding: 20px 20px 0;
            background: #fff;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            text-align: center;
            height: 350px;
        }

        .login-form-view .hidden {
            display: none;
        }

        .login-form-view .togglePanel {
            padding-bottom: 10px;
            border-bottom: 1px solid #ccc;
            margin-bottom: 20px;
        }

        .login-form-view .togglePanel span {
            display: inline-block;
            font-size: 18px;
            color: #b2b2b2;
            width: 49%;
            cursor: pointer;
        }

        .login-form-view .togglePanel span.active {
            color: #ff6640;
        }

        .login-form-view .login-form {
            height: 202px;
        }

        .login-form-view .login-form button {
            font-size: 16px;
            border: none;
            background-color: #ff6640;
            line-height: 46px;
            border-radius: 5px;
            color: #fff;
            width: 100%;
            height: 46px;
            outline: none;
            cursor: pointer;
        }

        .login-form-view .login-form button:hover {
            background-color: #ff5000;
        }

        .login-form-view .login-form .sms-code-btn {
            color: #ff6640;
            cursor: pointer;
            display: inline-block;
            line-height: normal;
            width: 100px;
            font-size: 12px;
            text-align: right;
        }

        .login-form-view .login-form .message-error,
        .login-form-view .login-form .message {
            color: #ff6640;
            text-align: left;
            padding: 0 0 5px 20px;
            margin: 0;
        }

        .login-form-view .login-form .message {
            margin-top: -10px;
            transition: all 200ms ease;
        }

        .login-form-view .service {
            padding-top: 10px;
        }

        .login-form-view .service ul {
            display: inline-block;
        }

        .login-form-view .service li {
            float: left;
            color: #ff6640;
            margin-right: 10px;
        }

        .login-form-view .service li a {
            text-decoration: none;
            color: #ff6640;
            cursor: pointer;
        }

        .login-form-view .service li a:hover,
        .login-form-view .service li a:focus {
            text-decoration: underline;
        }

        .login-popup-view .mz-modal {
            width: 390px;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
        }

        .login-popup-view .login-form-view {
            border: none;
            width: auto;
            padding: 0 20px;
        }

        .third-login-view {
            font-size: 14px;
            text-align: center;
            color: #b2b2b2;
            padding-top: 100px;
        }
    </style>
    <style type="text/css">
        .bind-mobile-popup-view .mz-modal-header {
            padding: 0;
        }

        .bind-mobile-popup-view .mz-modal {
            width: 390px;
            height: 410px;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
        }

        .bind-mobile-popup-view form {
            border: none;
            width: auto;
            padding: 0 20px;
            background: #fff;
            border-radius: 20px;
            text-align: center;
            height: 200px;
        }

        .bind-mobile-popup-view .togglePanel {
            padding: 10px 0;
            border-bottom: 1px solid #ccc;
            margin-bottom: 20px;
            font-size: 18px;
            color: #ff6640;
            text-align: center;
        }

        .bind-mobile-popup-view button {
            font-size: 16px;
            border: none;
            background-color: #ff6640;
            line-height: 46px;
            border-radius: 5px;
            color: #fff;
            width: 100%;
            height: 46px;
            outline: none;
            cursor: pointer;
        }

        .bind-mobile-popup-view button:hover {
            background-color: #ff5000;
        }

        .bind-mobile-popup-view .sms-code-btn {
            color: #ff6640;
            cursor: pointer;
            display: inline-block;
            line-height: normal;
            width: 100px;
            font-size: 12px;
            text-align: right;
        }

        .bind-mobile-popup-view .message-error,
        .bind-mobile-popup-view .message {
            color: #ff6640;
            text-align: left;
            padding: 0 0 5px 20px;
            margin: 0;
        }

        .bind-mobile-popup-view .message {
            margin-top: -10px;
            transition: all 200ms ease;
        }

        .bind-mobile-popup-view .tip {
            padding: 20px;
            color: #808080;
        }

        .bind-mobile-popup-view .tip li {
            margin-bottom: 5px;
        }
    </style>
    <style type="text/css">
        .city-view-wrap {
            position: relative;
            top: -60px;
        }

        .city-view-wrap .hidden {
            display: none;
        }

        .city-view {
            position: absolute;
            display: inline-block;
            width: 506px;
            background-color: #fff;
            z-index: 2;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            padding: 20px;
            top: 60px;
            left: 0;
        }

        .city-view .icon-caret-up {
            position: absolute;
            top: -18px;
            left: 150px;
            color: #e5e5e5;
        }

        .city-view .content {
            max-height: 207px;
            overflow-y: scroll;
            color: #808080;
            /*定义滚动条高宽及背景 高宽分别对应横竖滚动条的尺寸*/
            /*定义滚动条轨道*/
            /*定义滑块*/
        }

        .city-view .content span {
            color: #ff6640;
            float: left;
            width: 28px;
        }

        .city-view .content li {
            float: left;
            padding: 0 5px;
            cursor: pointer;
        }

        .city-view .content li:hover {
            color: #ff5000;
            text-decoration: underline;
        }

        .city-view .content .hot {
            padding-bottom: 20px;
            border-bottom: 1px solid #ccc;
            color: #333;
            margin-right: 20px;
        }

        .city-view .content .hot span {
            color: #b2b2b2;
        }

        .city-view .content .city-list {
            padding-top: 20px;
            margin-right: 20px;
        }

        .city-view .content .city-list span {
            text-align: right;
        }

        .city-view .content .city-list div,
        .city-view .content .hot div {
            vertical-align: top;
            padding-left: 40px;
        }

        .city-view .content::-webkit-scrollbar {
            width: 16px;
            height: 16px;
            border-radius: 10px;
            background-color: #f5f5f5;
        }

        .city-view .content::-webkit-scrollbar-track {
            border-radius: 10px;
            background-color: #f5f5f5;
        }

        .city-view .content::-webkit-scrollbar-thumb {
            border-radius: 10px;
            background-color: #d2d2d2;
        }
    </style>
    <style type="text/css">
        .footer {
            background-color: #1a1a1a;
            color: #b2b2b2;
        }

        .footer li {
            float: left;
        }

        .footer .content {
            height: 150px;
            line-height: 150px;
        }

        .footer .content h2 {
            margin: 0;
            float: left;
            font-size: 18px;
            font-weight: normal;
        }

        .footer .content h2 img {
            vertical-align: middle;
            margin-right: 10px;
        }

        .footer .content .service {
            float: left;
            margin-left: 140px;
            height: 150px;
        }

        .footer .content .service img {
            vertical-align: middle;
            margin-right: 15px;
        }

        .footer .content .service span {
            vertical-align: middle;
        }

        .footer .content .service .moblie {
            font-size: 20px;
            margin: 0 10px 0 2px;
        }

        .footer .side-warp {
            background-color: #000;
            padding: 30px;
            text-align: center;
        }

        .footer .side-warp li a {
            color: #b2b2b2;
            font-size: 14px;
            text-decoration: none;
            padding: 0 10px;
            border-left: 1px solid #b2b2b2;
        }

        .footer .side-warp li a:hover,
        .footer .side-warp li a:focus {
            color: #ff5000;
            text-decoration: underline;
        }

        .footer .side-warp li:first-child a {
            border: none;
        }

        .footer .side-warp .subnav {
            display: inline-block;
        }

        .footer .side-warp .copyright {
            margin: 30px 0;
        }

        .footer .follow {
            float: right;
        }

        .footer .follow .item {
            position: relative;
            display: inline-block;
            margin-left: 10px;
            cursor: pointer;
        }

        .footer .follow .item .icon-caret-down {
            position: absolute;
            bottom: -23px;
            font-size: 18px;
            color: #e5e5e5;
        }

        .footer .follow .item img {
            vertical-align: middle;
        }

        .footer .follow .item .tip {
            display: none;
            position: absolute;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            padding: 20px 30px;
            top: -220px;
            background-color: #fff;
            left: -105px;
            text-align: center;
        }

        .footer .follow .item .tip p {
            line-height: normal;
            color: #333;
        }

        .footer .follow .item:hover .tip {
            display: inline-block;
        }
    </style>
    <style type="text/css">
        .inner {
            width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .navbar-wrap {
            background-color: #262626;
            position: fixed;
            top: 0;
            z-index: 999;
            width: 100%;
        }

        .navbar {
            position: relative;
            font-size: 14px;
            height: 60px;
            line-height: 60px;
            color: #b2b2b2;
        }

        .navbar h1 {
            float: left;
            margin: 0;
        }

        .navbar h1 a {
            text-indent: -9999px;
            width: 95px;
            display: block;
            background: url(//static.maizuo.com/pc/v1/static/asset/11f1b0360055749ed478c45446e2a240.png) no-repeat 0;
        }

        .navbar .menu li {
            float: left;
            margin: 0 40px 0 0;
            font-size: 16px;
            cursor: pointer;
            line-height: 58px;
            border-bottom: 2px solid #262626;
            padding: 0 5px;
        }

        .navbar .menu li.active {
            border-bottom: 2px solid #ff6640;
            color: #ff6640;
        }

        .navbar .city {
            display: inline-block;
            float: left;
            margin: 0 333px 0 40px;
            cursor: pointer;
        }

        .navbar .city i[class*='icon-'] {
            font-size: 10px;
            margin-left: 3px;
        }

        .navbar .city.active {
            color: #ff6640;
        }

        .navbar .app {
            float: right;
            cursor: pointer;
            position: relative;
        }

        .navbar .app i[class*='icon-'] {
            font-size: 10px;
            margin-left: 3px;
        }

        .navbar .app.active {
            color: #ff6640;
        }

        .navbar .app .tip {
            position: absolute;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            padding: 20px 30px;
            top: 60px;
            background-color: #fff;
            left: -105px;
            text-align: center;
            line-height: normal;
            z-index: 2;
        }

        .navbar .app .tip p {
            line-height: normal;
            color: #333;
        }

        .navbar .app .tip .icon-caret-up {
            position: absolute;
            top: -20px;
            right: 80px;
            font-size: 18px;
            color: #e5e5e5;
        }

        .navbar .sign {
            float: right;
            margin-right: 38px;
            cursor: pointer;
        }

        .navbar .sign li {
            float: left;
            margin-right: 20px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            max-width: 100px;
        }

        .application-main {
            margin-top: 60px;
            min-height: 500px;
        }
    </style>
    <style type="text/css">
        /*! normalize.css v4.1.1 | MIT License | github.com/necolas/normalize.css */
        /**
 * 1. Change the default font family in all browsers (opinionated).
 * 2. Correct the line height in all browsers.
 * 3. Prevent adjustments of font size after orientation changes in IE and iOS.
 */

        html {
            font-family: sans-serif;
            /* 1 */
            line-height: 1.15;
            /* 2 */
            -ms-text-size-adjust: 100%;
            /* 3 */
            -webkit-text-size-adjust: 100%;
            /* 3 */
        }
        /**
 * Remove the margin in all browsers (opinionated).
 */

        body {
            margin: 0;
        }
        /* HTML5 display definitions
   ========================================================================== */
        /**
 * Add the correct display in IE 9-.
 * 1. Add the correct display in Edge, IE, and Firefox.
 * 2. Add the correct display in IE.
 */

        article,
        aside,
        details,
            /* 1 */

        figcaption,
        figure,
        footer,
        header,
        main,
            /* 2 */

        menu,
        nav,
        section,
        summary {
            /* 1 */
            display: block;
        }
        /**
 * Add the correct display in IE 9-.
 */

        audio,
        canvas,
        progress,
        video {
            display: inline-block;
        }
        /**
 * Add the correct display in iOS 4-7.
 */

        audio:not([controls]) {
            display: none;
            height: 0;
        }
        /**
 * Add the correct vertical alignment in Chrome, Firefox, and Opera.
 */

        progress {
            vertical-align: baseline;
        }
        /**
 * Add the correct display in IE 10-.
 * 1. Add the correct display in IE.
 */

        template,
            /* 1 */

        [hidden] {
            display: none;
        }
        /* Links
   ========================================================================== */
        /**
 * 1. Remove the gray background on active links in IE 10.
 * 2. Remove gaps in links underline in iOS 8+ and Safari 8+.
 */

        a {
            background-color: transparent;
            /* 1 */
            -webkit-text-decoration-skip: objects;
            /* 2 */
        }
        /**
 * Remove the outline on focused links when they are also active or hovered
 * in all browsers (opinionated).
 */

        a:active,
        a:hover {
            outline-width: 0;
        }
        /* Text-level semantics
   ========================================================================== */
        /**
 * 1. Remove the bottom border in Firefox 39-.
 * 2. Add the correct text decoration in Chrome, Edge, IE, Opera, and Safari.
 */

        abbr[title] {
            border-bottom: none;
            /* 1 */
            text-decoration: underline;
            /* 2 */
            text-decoration: underline dotted;
            /* 2 */
        }
        /**
 * Prevent the duplicate application of `bolder` by the next rule in Safari 6.
 */

        b,
        strong {
            font-weight: inherit;
        }
        /**
 * Add the correct font weight in Chrome, Edge, and Safari.
 */

        b,
        strong {
            font-weight: bolder;
        }
        /**
 * Add the correct font style in Android 4.3-.
 */

        dfn {
            font-style: italic;
        }
        /**
 * Correct the font size and margin on `h1` elements within `section` and
 * `article` contexts in Chrome, Firefox, and Safari.
 */

        h1 {
            font-size: 2em;
            margin: 0.67em 0;
        }
        /**
 * Add the correct background and color in IE 9-.
 */

        mark {
            background-color: #ff0;
            color: #000;
        }
        /**
 * Add the correct font size in all browsers.
 */

        small {
            font-size: 80%;
        }
        /**
 * Prevent `sub` and `sup` elements from affecting the line height in
 * all browsers.
 */

        sub,
        sup {
            font-size: 75%;
            line-height: 0;
            position: relative;
            vertical-align: baseline;
        }

        sub {
            bottom: -0.25em;
        }

        sup {
            top: -0.5em;
        }
        /* Embedded content
   ========================================================================== */
        /**
 * Remove the border on images inside links in IE 10-.
 */

        img {
            border-style: none;
        }
        /**
 * Hide the overflow in IE.
 */

        svg:not(:root) {
            overflow: hidden;
        }
        /* Grouping content
   ========================================================================== */
        /**
 * 1. Correct the inheritance and scaling of font size in all browsers.
 * 2. Correct the odd `em` font sizing in all browsers.
 */

        code,
        kbd,
        pre,
        samp {
            font-family: monospace, monospace;
            /* 1 */
            font-size: 1em;
            /* 2 */
        }
        /**
 * Add the correct margin in IE 8.
 */

        figure {
            margin: 1em 40px;
        }
        /**
 * 1. Add the correct box sizing in Firefox.
 * 2. Show the overflow in Edge and IE.
 */

        hr {
            box-sizing: content-box;
            /* 1 */
            height: 0;
            /* 1 */
            overflow: visible;
            /* 2 */
        }
        /* Forms
   ========================================================================== */
        /**
 * 1. Change font properties to `inherit` in all browsers (opinionated).
 * 2. Remove the margin in Firefox and Safari.
 */

        button,
        input,
        optgroup,
        select,
        textarea {
            font: inherit;
            /* 1 */
            margin: 0;
            /* 2 */
        }
        /**
 * Restore the font weight unset by the previous rule.
 */

        optgroup {
            font-weight: bold;
        }
        /**
 * Show the overflow in IE.
 * 1. Show the overflow in Edge.
 */

        button,
        input {
            /* 1 */
            overflow: visible;
        }
        /**
 * Remove the inheritance of text transform in Edge, Firefox, and IE.
 * 1. Remove the inheritance of text transform in Firefox.
 */

        button,
        select {
            /* 1 */
            text-transform: none;
        }
        /**
 * 1. Prevent a WebKit bug where (2) destroys native `audio` and `video`
 *    controls in Android 4.
 * 2. Correct the inability to style clickable types in iOS and Safari.
 */

        button,
        html [type="button"],
            /* 1 */

        [type="reset"],
        [type="submit"] {
            -webkit-appearance: button;
            /* 2 */
        }
        /**
 * Remove the inner border and padding in Firefox.
 */

        button::-moz-focus-inner,
        [type="button"]::-moz-focus-inner,
        [type="reset"]::-moz-focus-inner,
        [type="submit"]::-moz-focus-inner {
            border-style: none;
            padding: 0;
        }
        /**
 * Restore the focus styles unset by the previous rule.
 */

        button:-moz-focusring,
        [type="button"]:-moz-focusring,
        [type="reset"]:-moz-focusring,
        [type="submit"]:-moz-focusring {
            outline: 1px dotted ButtonText;
        }
        /**
 * Change the border, margin, and padding in all browsers (opinionated).
 */

        fieldset {
            border: 1px solid #c0c0c0;
            margin: 0 2px;
            padding: 0.35em 0.625em 0.75em;
        }
        /**
 * 1. Correct the text wrapping in Edge and IE.
 * 2. Correct the color inheritance from `fieldset` elements in IE.
 * 3. Remove the padding so developers are not caught out when they zero out
 *    `fieldset` elements in all browsers.
 */

        legend {
            box-sizing: border-box;
            /* 1 */
            color: inherit;
            /* 2 */
            display: table;
            /* 1 */
            max-width: 100%;
            /* 1 */
            padding: 0;
            /* 3 */
            white-space: normal;
            /* 1 */
        }
        /**
 * Remove the default vertical scrollbar in IE.
 */

        textarea {
            overflow: auto;
        }
        /**
 * 1. Add the correct box sizing in IE 10-.
 * 2. Remove the padding in IE 10-.
 */

        [type="checkbox"],
        [type="radio"] {
            box-sizing: border-box;
            /* 1 */
            padding: 0;
            /* 2 */
        }
        /**
 * Correct the cursor style of increment and decrement buttons in Chrome.
 */

        [type="number"]::-webkit-inner-spin-button,
        [type="number"]::-webkit-outer-spin-button {
            height: auto;
        }
        /**
 * 1. Correct the odd appearance in Chrome and Safari.
 * 2. Correct the outline style in Safari.
 */

        [type="search"] {
            -webkit-appearance: textfield;
            /* 1 */
            outline-offset: -2px;
            /* 2 */
        }
        /**
 * Remove the inner padding and cancel buttons in Chrome and Safari on OS X.
 */

        [type="search"]::-webkit-search-cancel-button,
        [type="search"]::-webkit-search-decoration {
            -webkit-appearance: none;
        }
        /**
 * Correct the text style of placeholders in Chrome, Edge, and Safari.
 */

        ::-webkit-input-placeholder {
            color: inherit;
            opacity: 0.54;
        }
        /**
 * 1. Correct the inability to style clickable types in iOS and Safari.
 * 2. Change font properties to `inherit` in Safari.
 */

        ::-webkit-file-upload-button {
            -webkit-appearance: button;
            /* 1 */
            font: inherit;
            /* 2 */
        }
    </style>
    <style type="text/css">
        @font-face {
            font-family: 'icomoon';
            src: url(//static.maizuo.com/pc/v1/static/asset/62e9204cbb017aba6a1958d039d1e9e5.eot);
            src: url(//static.maizuo.com/pc/v1/static/asset/62e9204cbb017aba6a1958d039d1e9e5.eot#iefix) format('embedded-opentype'), url(//static.maizuo.com/pc/v1/static/asset/2ac0acbc528a55a4a817d4aeea4e83b0.ttf) format('truetype'), url(//static.maizuo.com/pc/v1/static/asset/b41074ffb3306864933b21f355566531.woff) format('woff'), url(//static.maizuo.com/pc/v1/static/asset/0127bcc835c854239a444015d33ab812.svg#icomoon) format('svg');
            font-weight: normal;
            font-style: normal;
        }

        [class^="icon-"],
        [class*=" icon-"] {
            /* use !important to prevent issues with browser extensions that change fonts */
            font-family: 'icomoon' !important;
            speak: none;
            font-style: normal;
            font-weight: normal;
            font-variant: normal;
            text-transform: none;
            line-height: 1;
            /* Better Font Rendering =========== */
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .icon-clock:before {
            content: "\E909";
        }

        .icon-add:before {
            content: "\E90A";
        }

        .icon-reduce:before {
            content: "\E90B";
        }

        .icon-show:before {
            content: "\E90C";
        }

        .icon-hide:before {
            content: "\E90D";
        }

        .icon-check:before {
            content: "\E90E";
        }

        .icon-people:before {
            content: "\E90F";
        }

        .icon-double-people:before {
            content: "\E910";
        }

        .icon-big-check:before {
            content: "\E911";
        }

        .icon-double-lover:before {
            content: "\E912";
        }

        .icon-caret-down:before {
            content: "\E907";
        }

        .icon-caret-up:before {
            content: "\E908";
        }

        .icon-search:before {
            content: "\E901";
        }

        .icon-next:before {
            content: "\E902";
        }

        .icon-pre:before {
            content: "\E903";
        }

        .icon-play:before {
            content: "\E904";
        }

        .icon-refresh:before {
            content: "\E905";
        }

        .icon-close:before {
            content: "\E900";
        }

        .icon-warn:before {
            content: "\E906";
        }
    </style>
    <style type="text/css">
        body,
        input,
        button,
        select,
        textarea,
        table {
            font: 12px/1.5 Tahoma, Helvetica, Arial, sans-serif;
            font-family: 'Microsoft YaHei', Tahoma, Helvetica, Arial, sans-serif;
        }

        ul,
        li {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        body {
            width: 100%;
        }

        .clearfix:before,
        .clearfix:after {
            display: table;
            content: " ";
        }

        .clearfix:after {
            clear: both;
        }

        a {
            background-color: transparent;
        }

        a:active,
        a:hover {
            outline: 0;
        }

        button,
        input {
            outline: none;
        }

        :-moz-placeholder {
            /* Mozilla Firefox 4 to 18 */
            color: #b6b6b6;
            font-size: 14px;
        }

        ::-moz-placeholder {
            /* Mozilla Firefox 19+ */
            color: #b6b6b6;
            font-size: 14px;
        }

        input:-ms-input-placeholder {
            color: #b6b6b6;
            font-size: 14px;
        }

        input::-webkit-input-placeholder {
            color: #b6b6b6;
            font-size: 14px;
        }

        #main {
            min-width: 1300px;
        }

        body #nprogress .bar {
            background-color: #ff6640;
            height: 4px;
        }

        body #nprogress .peg {
            box-shadow: 0 0 10px #ff6640, 0 0 10px #ff6640;
        }
    </style>
    <style type="text/css">
        /* Slider */

        .slick-slider {
            position: relative;
            display: block;
            box-sizing: border-box;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            -webkit-touch-callout: none;
            -khtml-user-select: none;
            -ms-touch-action: pan-y;
            touch-action: pan-y;
            -webkit-tap-highlight-color: transparent;
        }

        .slick-list {
            position: relative;
            display: block;
            overflow: hidden;
            margin: 0;
            padding: 0;
        }

        .slick-list:focus {
            outline: none;
        }

        .slick-list.dragging {
            cursor: pointer;
            cursor: hand;
        }

        .slick-slider .slick-track,
        .slick-slider .slick-list {
            -webkit-transform: translate3d(0, 0, 0);
            -moz-transform: translate3d(0, 0, 0);
            -ms-transform: translate3d(0, 0, 0);
            -o-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
        }

        .slick-track {
            position: relative;
            top: 0;
            left: 0;
            display: block;
        }

        .slick-track:before,
        .slick-track:after {
            display: table;
            content: '';
        }

        .slick-track:after {
            clear: both;
        }

        .slick-loading .slick-track {
            visibility: hidden;
        }

        .slick-slide {
            display: none;
            float: left;
            height: 100%;
            min-height: 1px;
        }

        [dir='rtl'] .slick-slide {
            float: right;
        }

        .slick-slide img {
            display: block;
        }

        .slick-slide.slick-loading img {
            display: none;
        }

        .slick-slide.dragging img {
            pointer-events: none;
        }

        .slick-initialized .slick-slide {
            display: block;
        }

        .slick-loading .slick-slide {
            visibility: hidden;
        }

        .slick-vertical .slick-slide {
            display: block;
            height: auto;
            border: 1px solid transparent;
        }

        .slick-arrow.slick-hidden {
            display: none;
        }
    </style>
    <style type="text/css">
        @charset 'UTF-8';
        /* Slider */

        .slick-loading .slick-list {
            background: #fff url(//static.maizuo.com/pc/v1/static/asset/c5cd7f5300576ab4c88202b42f6ded62.gif) center center no-repeat;
        }
        /* Icons */

        @font-face {
            font-family: 'slick';
            font-weight: normal;
            font-style: normal;
            src: url(//static.maizuo.com/pc/v1/static/asset/ced611daf7709cc778da928fec876475.eot);
            src: url(//static.maizuo.com/pc/v1/static/asset/ced611daf7709cc778da928fec876475.eot?#iefix) format('embedded-opentype'), url(//static.maizuo.com/pc/v1/static/asset/b7c9e1e479de3b53f1e4e30ebac2403a.woff) format('woff'), url(//static.maizuo.com/pc/v1/static/asset/d41f55a78e6f49a5512878df1737e58a.ttf) format('truetype'), url(//static.maizuo.com/pc/v1/static/asset/f97e3bbf73254b0112091d0192f17aec.svg#slick) format('svg');
        }
        /* Arrows */

        .slick-prev,
        .slick-next {
            font-size: 0;
            line-height: 0;
            position: absolute;
            top: 50%;
            display: block;
            width: 20px;
            height: 20px;
            padding: 0;
            -webkit-transform: translate(0, -50%);
            -ms-transform: translate(0, -50%);
            transform: translate(0, -50%);
            cursor: pointer;
            color: transparent;
            border: none;
            outline: none;
            background: transparent;
        }

        .slick-prev:hover,
        .slick-prev:focus,
        .slick-next:hover,
        .slick-next:focus {
            color: transparent;
            outline: none;
            background: transparent;
        }

        .slick-prev:hover:before,
        .slick-prev:focus:before,
        .slick-next:hover:before,
        .slick-next:focus:before {
            opacity: 1;
        }

        .slick-prev.slick-disabled:before,
        .slick-next.slick-disabled:before {
            opacity: .25;
        }

        .slick-prev:before,
        .slick-next:before {
            font-family: 'slick';
            font-size: 20px;
            line-height: 1;
            opacity: .75;
            color: white;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .slick-prev {
            left: -25px;
        }

        [dir='rtl'] .slick-prev {
            right: -25px;
            left: auto;
        }

        .slick-prev:before {
            content: '\2190';
        }

        [dir='rtl'] .slick-prev:before {
            content: '\2192';
        }

        .slick-next {
            right: -25px;
        }

        [dir='rtl'] .slick-next {
            right: auto;
            left: -25px;
        }

        .slick-next:before {
            content: '\2192';
        }

        [dir='rtl'] .slick-next:before {
            content: '\2190';
        }
        /* Dots */

        .slick-dotted.slick-slider {
            margin-bottom: 30px;
        }

        .slick-dots {
            position: absolute;
            bottom: -25px;
            display: block;
            width: 100%;
            padding: 0;
            margin: 0;
            list-style: none;
            text-align: center;
        }

        .slick-dots li {
            position: relative;
            display: inline-block;
            width: 20px;
            height: 20px;
            margin: 0 5px;
            padding: 0;
            cursor: pointer;
        }

        .slick-dots li button {
            font-size: 0;
            line-height: 0;
            display: block;
            width: 20px;
            height: 20px;
            padding: 5px;
            cursor: pointer;
            color: transparent;
            border: 0;
            outline: none;
            background: transparent;
        }

        .slick-dots li button:hover,
        .slick-dots li button:focus {
            outline: none;
        }

        .slick-dots li button:hover:before,
        .slick-dots li button:focus:before {
            opacity: 1;
        }

        .slick-dots li button:before {
            font-family: 'slick';
            font-size: 6px;
            line-height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            width: 20px;
            height: 20px;
            content: '\2022';
            text-align: center;
            opacity: .25;
            color: black;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .slick-dots li.slick-active button:before {
            opacity: .75;
            color: black;
        }
    </style>
    <style type="text/css">
        /* Make clicks pass-through */

        #nprogress {
            pointer-events: none;
        }

        #nprogress .bar {
            background: #29d;
            position: fixed;
            z-index: 1031;
            top: 0;
            left: 0;
            width: 100%;
            height: 2px;
        }
        /* Fancy blur effect */

        #nprogress .peg {
            display: block;
            position: absolute;
            right: 0px;
            width: 100px;
            height: 100%;
            box-shadow: 0 0 10px #29d, 0 0 5px #29d;
            opacity: 1.0;
            -webkit-transform: rotate(3deg) translate(0px, -4px);
            -ms-transform: rotate(3deg) translate(0px, -4px);
            transform: rotate(3deg) translate(0px, -4px);
        }
        /* Remove these to get rid of the spinner */

        #nprogress .spinner {
            display: block;
            position: fixed;
            z-index: 1031;
            top: 15px;
            right: 15px;
        }

        #nprogress .spinner-icon {
            width: 18px;
            height: 18px;
            box-sizing: border-box;
            border: solid 2px transparent;
            border-top-color: #29d;
            border-left-color: #29d;
            border-radius: 50%;
            -webkit-animation: nprogress-spinner 400ms linear infinite;
            animation: nprogress-spinner 400ms linear infinite;
        }

        .nprogress-custom-parent {
            overflow: hidden;
            position: relative;
        }

        .nprogress-custom-parent #nprogress .spinner,
        .nprogress-custom-parent #nprogress .bar {
            position: absolute;
        }

        @-webkit-keyframes nprogress-spinner {
            0% {
                -webkit-transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
            }
        }

        @keyframes nprogress-spinner {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }
    </style>
    <style type="text/css">
        @-webkit-keyframes turn-around {
            0% {
                opacity: 1;
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            50% {
                opacity: 0.5;
                -webkit-transform: rotate(180deg);
                transform: rotate(180deg);
            }
            100% {
                opacity: 1;
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }

        .loading-circle {
            margin: 10px auto;
            border: 4px solid #3bb4c4;
            width: 80px;
            height: 80px;
            border-radius: 100%;
            -webkit-animation: turn-around 1s linear infinite;
            animation: turn-around 1s linear infinite;
        }

        .loading-circle i {
            display: -webkit-inline-box;
            display: -ms-inline-flexbox;
            display: inline-flex;
            width: 20px;
            height: 20px;
            margin: 10px;
            background-color: #3bb4c4;
            border-radius: 50%;
        }

        @-moz-keyframes turn-around {
            0% {
                opacity: 1;
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            50% {
                opacity: 0.5;
                -webkit-transform: rotate(180deg);
                transform: rotate(180deg);
            }
            100% {
                opacity: 1;
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }

        @-webkit-keyframes turn-around {
            0% {
                opacity: 1;
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            50% {
                opacity: 0.5;
                -webkit-transform: rotate(180deg);
                transform: rotate(180deg);
            }
            100% {
                opacity: 1;
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }

        @-o-keyframes turn-around {
            0% {
                opacity: 1;
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            50% {
                opacity: 0.5;
                -webkit-transform: rotate(180deg);
                transform: rotate(180deg);
            }
            100% {
                opacity: 1;
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }

        @keyframes turn-around {
            0% {
                opacity: 1;
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            50% {
                opacity: 0.5;
                -webkit-transform: rotate(180deg);
                transform: rotate(180deg);
            }
            100% {
                opacity: 1;
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
    </style>
    <style type="text/css">
        .home-view {
            padding-bottom: 80px;
        }

        .home-view .banner {
            background-color: #000;
            position: relative;
        }

        .home-view .banner:after {
            content: '';
            background: url(//static.maizuo.com/pc/v1/static/asset/4d9e3b9410fe7639b79832f1b272236a.png) repeat;
            height: 28px;
            display: block;
            top: 390px;
            position: absolute;
            width: 100%;
        }

        .home-view .banner .slick-dots {
            bottom: 20px;
            width: 1170px;
            left: 50%;
            margin-left: -600px;
            text-align: right;
            padding: 0 15px;
        }

        .home-view .banner .slick-dots li button:before {
            color: #e5e5e5;
            opacity: 0.2;
            font-size: 15px;
        }

        .home-view .banner .slick-dots li button:hover:before {
            color: #36bfd1;
            opacity: 0.5;
        }

        .home-view .banner .slick-dots li button:focus:before {
            color: transition;
        }

        .home-view .banner .slick-dots li.slick-active button:before {
            color: #36bfd1;
            opacity: 0.8;
        }

        .home-view .banner .slick-slide {
            cursor: pointer;
        }

        .home-view .film .header {
            border-bottom: 1px solid #ccc;
            color: #b2b2b2;
            padding-top: 35px;
        }

        .home-view .film .header h3 {
            margin: 0 0 5px 0;
            font-size: 24px;
            font-weight: normal;
            display: inline-block;
        }

        .home-view .film .header h3 span {
            cursor: pointer;
        }

        .home-view .film .header h3 span:first-child {
            margin-right: 5px;
        }

        .home-view .film .header h3 span:last-child {
            margin-left: 5px;
        }

        .home-view .film .header h3 .active {
            color: #333;
        }

        .home-view .film .header p {
            display: inline-block;
            float: right;
            font-size: 14px;
            color: #b2b2b2;
        }

        .home-view .film .header p span {
            color: #ff6640;
            margin: 0 2px;
        }

        .home-view .film .header p a {
            text-decoration: none;
            color: #ff6640;
        }

        .home-view .film .content {
            padding-top: 22px;
            color: #333;
            width: 1222px;
        }

        .home-view .film .content p {
            text-align: center;
            font-size: 16px;
            padding: 0 20px 0 0;
        }

        .home-view .film .content img {
            max-height: 249px;
        }

        .home-view .film .content .item {
            width: 181px;
        }

        .home-view .film .content .slick-list {
            width: 1200px;
        }

        .home-view .film .content .slick-slide {
            cursor: pointer;
        }

        .home-view .film .content .slick-prev,
        .home-view .film .content .slick-next {
            top: 130px;
            width: 55px;
            height: 55px;
        }

        .home-view .film .content .slick-prev {
            left: -70px;
        }

        .home-view .film .content .slick-next {
            right: -50px;
        }

        .home-view .film .content .slick-prev:before,
        .home-view .film .content .slick-next:before {
            font-size: 55px;
            color: #ccc;
        }

        .home-view .film .content .grade {
            color: #ff6640;
            font-size: 20px;
        }

        .home-view .film .content .name {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            display: inline-block;
            max-width: 80%;
            font-size: 16px;
            color: #333;
            padding: 0 5px;
            vertical-align: text-bottom;
        }

        .home-view .film .content .name a:hover,
        .home-view .film .content .name a:focus {
            color: #ff6640;
            text-decoration: underline;
        }

        .home-view .film .content i {
            color: #ff6640;
            font-style: normal;
            font-size: 12px;
            display: inline-block;
            position: relative;
            top: -6px;
        }

        .home-view .third-banner {
            margin: 40px 0 35px;
        }

        .home-view .third-banner img:hover {
            opacity: 0.6;
        }

        .home-view .third-banner .slick-dots {
            top: 100px;
            right: 15px;
            text-align: right;
            width: 150px;
        }

        .home-view .third-banner .slick-dots li {
            margin: 0;
        }

        .home-view .third-banner .slick-dots li button:before {
            color: #e5e5e5;
            opacity: 0.2;
            font-size: 15px;
        }

        .home-view .third-banner .slick-dots li button:hover:before {
            color: #36bfd1;
            opacity: 0.5;
        }

        .home-view .third-banner .slick-dots li button:focus:before {
            color: transition;
        }

        .home-view .third-banner .slick-dots li.slick-active button:before {
            color: #36bfd1;
            opacity: 0.8;
        }

        .home-view .popular-active {
            width: 876px;
            border: 1px solid #fff;
        }

        .home-view .popular-active .active-header {
            border-bottom: 1px solid #ccc;
            margin-bottom: 27px;
        }

        .home-view .popular-active .active-header h3 {
            color: #333;
            font-size: 24px;
            font-weight: normal;
            margin: 5px 0;
        }

        .home-view .popular-active .active-img {
            height: 224px;
        }

        .home-view .popular-active .active-img li {
            background-color: #e5e5e5;
            float: left;
            width: 284px;
            height: 224px;
            margin-right: 12px;
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/6e41fda5b1006c3e10b98e7ea27e6e90.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/6e41fda5b1006c3e10b98e7ea27e6e90.png);
        }

        .home-view .popular-active .active-img li:last-child {
            margin: 0;
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/80f69dd2620a413fbef788711c728e05.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/80f69dd2620a413fbef788711c728e05.png);
        }

        .home-view .popular-active .active-img li:first-child {
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/09a5305502dd1fb92fc57dd2bcca8419.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/09a5305502dd1fb92fc57dd2bcca8419.png);
        }

        .home-view .popular-active .active-img li a {
            text-decoration: none;
        }

        .home-view .popular-active .active-img li img {
            width: 100%;
            height: 180px;
        }

        .home-view .popular-active .active-img li .item {
            height: 180px;
        }

        .home-view .popular-active .active-img li .imageTitle {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            color: #808080;
            font-size: 14px;
            text-align: center;
            padding: 0 25px;
            line-height: 36px;
        }

        .home-view .popular-active .active-img li:hover img {
            opacity: 0.5;
        }

        .home-view .popular-active .active-img li:hover .imageTitle {
            text-decoration: underline;
            color: #ff5000;
        }

        .home-view .comment-view {
            width: 876px;
            margin: 25px 0 0;
            display: inline-block;
            height: 397px;
        }

        .home-view .comment-view .loading-circle {
            margin-top: 100px;
        }

        .home-view .comment-view .comment-scroll-enter {
            top: 320px;
        }

        .home-view .comment-view .comment-scroll-enter.comment-scroll-enter-active {
            top: 0;
            transition: top 5000ms linear;
        }

        .home-view .comment-view .comment-scroll-leave {
            top: 0px;
        }

        .home-view .comment-view .comment-scroll-leave.comment-scroll-leave-active {
            top: -320px;
            transition: top 5000ms linear;
        }

        .home-view .comment-view .comment-header {
            border-bottom: 1px solid #ccc;
            position: relative;
        }

        .home-view .comment-view .comment-header .icon-refresh {
            position: absolute;
            right: 0px;
            top: 10px;
            font-size: 25px;
            color: #e5e5e5;
            cursor: pointer;
        }

        .home-view .comment-view .comment-header .icon-refresh:hover {
            color: #ff6640;
        }

        .home-view .comment-view .comment-header h3 {
            color: #333;
            font-size: 24px;
            font-weight: normal;
            margin: 5px 0;
        }

        .home-view .comment-view .comment-content {
            position: relative;
            overflow: hidden;
            height: 350px;
        }

        .home-view .comment-view .comment-content .item {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
        }

        .home-view .comment-view .comment-content li {
            height: 112px;
            border-bottom: 1px solid #e5e5e5;
        }

        .home-view .comment-view .comment-content li img {
            width: 58px;
            height: 58px;
            margin-top: 27px;
            border-radius: 56px;
            float: left;
        }

        .home-view .comment-view .comment-content li .contents {
            font-size: 14px;
            color: #808080;
            width: 700px;
            height: 42px;
            margin-top: 37px;
            float: left;
            text-align: left;
            margin-left: 14px;
        }

        .home-view .comment-view .comment-content li .contents h5 {
            display: inline-block;
            margin: 0 10px 0 0;
            font-weight: normal;
            font-size: 14px;
        }

        .home-view .comment-view .comment-content li .contents span {
            color: #b2b2b2;
            margin-right: 10px;
        }

        .home-view .comment-view .comment-content li .contents i {
            color: #ff6640;
            font-style: normal;
            cursor: pointer;
        }

        .home-view .comment-view .comment-content li .contents i:hover {
            text-decoration: underline;
            color: #ff5000;
        }

        .home-view .comment-view .comment-content li .contents p {
            margin: 0;
            max-width: 700px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            color: #b2b2b2;
        }

        .home-view .maizuo-card {
            width: 284px;
            float: right;
        }

        .home-view .maizuo-card .card-header {
            margin-bottom: 27px;
            border-bottom: 1px solid #ccc;
        }

        .home-view .maizuo-card .card-header h3 {
            color: #333;
            font-size: 24px;
            font-weight: normal;
            margin: 5px 0;
        }

        .home-view .maizuo-card .card-img {
            height: 224px;
            cursor: pointer;
        }

        .home-view .maizuo-card .card-img li {
            background-color: #e5e5e5;
            width: 284px;
            height: 224px;
            margin-right: 6px;
        }

        .home-view .maizuo-card .card-img li img {
            width: 100%;
            height: 180px;
        }

        .home-view .maizuo-card .card-img li .imageTitle {
            color: #808080;
            font-size: 14px;
            text-align: center;
            line-height: 36px;
        }

        .home-view .maizuo-card .card-img li a {
            text-decoration: none;
        }

        .home-view .maizuo-card .card-img li a:hover img {
            opacity: 0.5;
        }

        .home-view .maizuo-card .card-img li a:hover .imageTitle {
            text-decoration: underline;
            color: #ff5000;
        }

        .home-view .phone-ticket {
            width: 284px;
            float: right;
            margin-top: 25px;
        }

        .home-view .phone-ticket .ticket-header {
            border-bottom: 1px solid #ccc;
        }

        .home-view .phone-ticket .ticket-header h3 {
            color: #333;
            font-size: 24px;
            font-weight: normal;
            margin: 5px 0;
        }

        .home-view .phone-ticket .ticket-code li {
            height: 177px;
            border-bottom: 1px solid #e5e5e5;
        }

        .home-view .phone-ticket .ticket-code li .code-content {
            display: inline-block;
            margin: 70px 0 0 12px;
            color: #808080;
            font-size: 14px;
        }

        .home-view .phone-ticket .ticket-code li img {
            width: 151px;
            height: 147px;
            margin-top: 17px;
            float: left;
        }

        .home-view .phone-ticket .ticket-code li h4 {
            display: inline-block;
        }
    </style>
    <!--<script type="text/javascript" charset="utf8" async="" src="./影片详情页+在线购票页_files/vds.js.下载"></script>-->
    <!--<script type="text/javascript" charset="utf-8" async="" src="./影片详情页+在线购票页_files/14-9d4191.js.下载"></script>-->
    <style type="text/css">
        .mz-pagination {
            font-size: 14px;
            color: #808080;
            text-align: center;
            padding-top: 30px;
        }

        .mz-pagination li {
            float: left;
            background: #b2b2b2;
            width: 26px;
            height: 26px;
            border-radius: 100%;
            line-height: 26px;
            margin: 0 5px;
            color: #fff;
            cursor: pointer;
        }

        .mz-pagination li.active {
            background-color: #36bfd1;
        }

        .mz-pagination li:hover {
            background-color: #36bfd1;
        }

        .mz-pagination .pagination-pages {
            display: inline-block;
            vertical-align: top;
            padding: 0 20px;
        }

        .mz-pagination .pagination-pages .current {
            color: #36bfd1;
        }

        .mz-pagination .pre,
        .mz-pagination .next {
            cursor: pointer;
            font-style: normal;
        }

        .mz-pagination .pre:hover,
        .mz-pagination .next:hover {
            color: #36bfd1;
        }

        .mz-pagination .icon-pre,
        .mz-pagination .icon-next {
            font-size: 20px;
            color: #d4d1d1;
        }

        .mz-pagination .icon-pre:hover,
        .mz-pagination .icon-next:hover {
            color: #36bfd1;
        }
    </style>
    <style type="text/css">
        .active-view {
            width: 284px;
            display: inline-block;
            text-align: center;
        }

        .active-view .header {
            padding: 5px 0;
            border-bottom: 1px solid #ccc;
            margin-bottom: 22px;
            text-align: left;
        }

        .active-view .header h3 {
            font-size: 24px;
            font-weight: normal;
            color: #333;
            margin: 0;
        }

        .active-view ul li {
            position: relative;
            margin-top: 10px;
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/fd7b71498ea100f7527dc0ec6650ef7d.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/fd7b71498ea100f7527dc0ec6650ef7d.png);
        }

        .active-view ul li:first-child {
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/464c8c7e2b7f5d5a756232ce4c347cea.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/464c8c7e2b7f5d5a756232ce4c347cea.png);
        }

        .active-view ul li:last-child {
            -webkit-mask-image: url(//static.maizuo.com/pc/v1/static/asset/ceceade793db71bbfa9b6893eade8d61.png);
            mask-image: url(//static.maizuo.com/pc/v1/static/asset/ceceade793db71bbfa9b6893eade8d61.png);
        }

        .active-view ul li p {
            display: none;
            position: absolute;
            width: 234px;
            bottom: 4px;
            line-height: 50px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            color: #fff;
            background: #36bfd1;
            margin: 0;
            padding: 0 25px;
            font-size: 14px;
        }

        .active-view ul li a:hover img {
            opacity: 0.6;
        }

        .active-view ul li a:hover p {
            display: block;
        }
    </style>
    <style type="text/css">
        .film-inner {
            width: 1200px;
            margin: 0 auto;
            padding: 23px 0 85px;
        }

        .film-inner .left-view {
            width: 838px;
            display: inline-block;
        }

        .film-inner .left-view .header {
            width: 838px;
            border-bottom: 1px solid #ccc;
            color: #b2b2b2;
            display: inline-block;
            padding: 5px 0;
        }

        .film-inner .left-view .header h3 {
            margin: 0;
            font-size: 24px;
            font-weight: normal;
            display: inline-block;
        }

        .film-inner .left-view .header h3 span {
            cursor: pointer;
        }

        .film-inner .left-view .header h3 span:first-child {
            margin-right: 5px;
        }

        .film-inner .left-view .header h3 span:last-child {
            margin-left: 5px;
        }

        .film-inner .left-view .header h3 .active {
            color: #333;
        }

        .film-inner .left-view .header .sort-order {
            font-size: 12px;
            color: #808080;
            float: right;
            margin-top: 10px;
            z-index: 99;
        }

        .film-inner .left-view .header .sort-order li {
            float: left;
            margin-left: 12px;
            cursor: pointer;
        }

        .film-inner .left-view .header .sort-order .active {
            color: #36bfd1;
        }

        .film-inner .left-view .content {
            width: 838px;
            display: inline-block;
        }

        .film-inner .left-view .content .film-list .film-item {
            border-bottom: 1px solid #e5e5e5;
            width: 838px;
            padding: 22px 0;
            display: table-cell;
        }

        .film-inner .left-view .content .film-list .film-item .film-img {
            width: 181px;
            display: inline-block;
            float: left;
            cursor: pointer;
        }

        .film-inner .left-view .content .film-list .film-item .film-img img {
            width: 100%;
            display: block;
        }

        .film-inner .left-view .content .film-list .film-item .intro {
            float: left;
            margin-left: 22px;
            width: 500px;
            color: #ff6640;
            padding-top: 20px;
        }

        .film-inner .left-view .content .film-list .film-item .intro p {
            display: inline-block;
            font-size: 20px;
        }

        .film-inner .left-view .content .film-list .film-item .intro i {
            font-style: normal;
            font-size: 12px;
            display: inline-block;
            position: relative;
            top: -6px;
        }

        .film-inner .left-view .content .film-list .film-item .intro h4 {
            cursor: pointer;
            font-size: 20px;
            color: #333;
            margin: 0;
            display: inline-block;
            max-width: 180px;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
            vertical-align: top;
        }

        .film-inner .left-view .content .film-list .film-item .intro .grade {
            margin: 0 0 0 15px;
        }

        .film-inner .left-view .content .film-list .film-item .intro .film-intro {
            font-size: 14px;
            color: #808080;
            margin-left: 15px;
            display: inline-block;
        }

        .film-inner .left-view .content .film-list .film-item .intro .film-intro span {
            display: inline-block;
            max-width: 250px;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
            vertical-align: bottom;
        }

        .film-inner .left-view .content .film-list .film-item .intro ul {
            margin-top: 28px;
            font-size: 12px;
            line-height: 1.8em;
        }

        .film-inner .left-view .content .film-list .film-item .intro ul label {
            color: #333;
        }

        .film-inner .left-view .content .film-list .film-item .intro ul span {
            color: #808080;
            display: inline-block;
            width: 85%;
            vertical-align: top;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
        }

        .film-inner .left-view .content .film-list .film-item .intro .tags {
            float: left;
            height: 36px;
            margin-top: 28px;
        }

        .film-inner .left-view .content .film-list .film-item .intro .tags span {
            border: 1px solid #36bfd1;
            border-radius: 20px;
            padding: 0 20px 0 20px;
            height: 34px;
            display: inline-block;
            text-align: center;
            line-height: 34px;
            color: #36bfd1;
            margin-right: 9px;
        }

        .film-inner .left-view .content .film-list .film-item .chooseBtn {
            outline: none;
            border: 0;
            background: #ff6640;
            border-radius: 20px;
            margin-top: 100px;
            width: 118px;
            height: 46px;
            text-align: center;
            line-height: 44px;
            float: right;
            right: 0;
            font-size: 16px;
            color: #fff;
            cursor: pointer;
        }

        .film-inner .left-view .content .film-list .film-item .chooseBtn:hover {
            background-color: #ff5000;
        }

        .film-inner .right-view {
            width: 284px;
            float: right;
        }
    </style>
    <style type="text/css">
        .browser-blocker-view {
            width: 1200px;
            margin: 0 auto;
            text-align: center;
            font-size: 14px;
            color: #333;
            padding: 113px 0;
        }

        .browser-blocker-view img {
            border: none;
        }

        .browser-blocker-view h3 {
            font-size: 28px;
            color: #36bfd1;
        }

        .browser-blocker-view .tip {
            color: #808080;
        }

        .browser-blocker-view ul {
            padding: 0;
            margin: 0;
            width: 300px;
            margin: 0 auto;
            height: 100px;
        }

        .browser-blocker-view li {
            float: left;
            width: 60px;
            margin: 12px 18px 0;
            list-style: none;
            font-size: 12px;
        }

        .browser-blocker-view li a,
        .browser-blocker-view li a:hover,
        .browser-blocker-view li a:focus {
            color: #808080;
            text-decoration: none;
        }

        .browser-blocker-view .button-wrap a {
            width: 89px;
            height: 33px;
            color: #ff6640;
            border: 1px solid #ff6640;
            text-align: center;
            border-radius: 20px;
            background-color: #fff;
            margin-top: 40px;
            outline: none;
            cursor: pointer;
            line-height: 33px;
            font-size: 12px;
            display: inline-block;
            text-decoration: none;
        }
    </style>
    <!--<script type="text/javascript" charset="utf-8" async="" src="./影片详情页+在线购票页_files/11-54fadc.js.下载"></script>-->
    <style type="text/css">
        .cinema-list-view {
            padding: 23px 0 80px;
        }

        .cinema-list-view .cinema-list {
            width: 840px;
            display: inline-block;
        }

        .cinema-list-view .cinema-header {
            border-bottom: 1px solid #ccc;
            padding: 5px 0 17px 0;
            width: 838px;
        }

        .cinema-list-view .cinema-header h3 {
            font-size: 24px;
            color: #333;
            margin: 0;
            font-weight: normal;
            display: inline;
        }

        .cinema-list-view .cinema-header .search {
            float: right;
            border: 1px solid #ccc;
            border-radius: 10px;
            width: 318px;
            height: 32px;
            position: relative;
            text-align: center;
            margin: 5px 0 0 20px;
            display: inline-block;
            vertical-align: middle;
        }

        .cinema-list-view .cinema-header .search.icon-search:before {
            position: absolute;
            right: 12px;
            top: 3px;
            font-size: 20px;
            padding: 6px;
            cursor: pointer;
        }

        .cinema-list-view .cinema-header .search input {
            border: none;
            line-height: 30px;
            padding: 0 10px;
            width: 80%;
            border-radius: 20px;
            vertical-align: top;
            color: #808080;
            font-size: 14px;
        }

        .cinema-list-view .cinema-header .search .icon-search {
            position: absolute;
            padding: 6px;
            right: 12px;
            cursor: pointer;
            color: #ff6640;
            font-size: 20px;
        }

        .cinema-list-view .result {
            font-size: 16px;
            color: #333;
            margin-top: 20px;
        }

        .cinema-list-view .result span {
            color: #f00;
        }

        .cinema-list-view .nothing {
            width: 430px;
            height: 280px;
            margin: 0 auto;
            text-align: center;
        }

        .cinema-list-view .nothing img {
            width: 100%;
        }

        .cinema-list-view .nothing p {
            font-size: 16px;
            margin-top: 15px;
        }

        .cinema-list-view .item {
            padding: 20px 0;
            border-bottom: 1px solid #e5e5e5;
            width: 838px;
            font-size: 12px;
            letter-spacing: 0;
        }

        .cinema-list-view .item span {
            margin-right: 10px;
            margin-top: 8px;
            display: inline-block;
        }

        .cinema-list-view .item div {
            color: #333;
            display: inline-block;
            vertical-align: top;
            width: 790px;
        }

        .cinema-list-view .item div .active {
            color: #fff;
            background: #36bfd1;
            border-radius: 20px;
        }

        .cinema-list-view .item div li {
            padding: 8px 13px;
            font-family: MicrosoftYaHei;
            color: #808080;
            text-align: center;
            float: left;
            cursor: pointer;
        }

        .cinema-list-view .cinema-item {
            border-bottom: 1px solid #e5e5e5;
            padding: 22px 0;
            width: 838px;
            display: table-cell;
        }

        .cinema-list-view .cinema-item .cinema-img {
            border: 1px solid #e5e5e5;
            display: inline-block;
            width: 146px;
            height: 146px;
            float: left;
            cursor: pointer;
        }

        .cinema-list-view .cinema-item .cinema-img img {
            width: 100%;
            height: 100%;
        }

        .cinema-list-view .cinema-item .detail {
            width: 500px;
            height: 146px;
            display: inline-block;
            float: left;
            margin-left: 22px;
        }

        .cinema-list-view .cinema-item .detail h3 {
            cursor: pointer;
            margin: 0;
            padding: 0;
            margin-top: 15px;
            display: inline-block;
            font-size: 18px;
            color: #333;
            letter-spacing: 0px;
        }

        .cinema-list-view .cinema-item .detail .information {
            display: inline-block;
            width: 100%;
            margin-top: 40px;
            font-size: 12px;
        }

        .cinema-list-view .cinema-item .detail .information li {
            margin-top: 5px;
        }

        .cinema-list-view .cinema-item .detail .information li label {
            color: #333;
            margin-right: 5px;
        }

        .cinema-list-view .cinema-item .detail .information li span {
            color: #808080;
        }

        .cinema-list-view .cinema-item button {
            width: 118px;
            height: 46px;
            border-radius: 20px;
            background-color: #ff6640;
            float: right;
            color: #fff;
            font-size: 16px;
            border: none;
            margin-top: 50px;
            cursor: pointer;
            outline: none;
        }

        .cinema-list-view .cinema-item button:hover {
            background-color: #ff5000;
        }

        .cinema-list-view .content-right {
            width: 284px;
            float: right;
        }

        .cinema-list-view .content-right .active-view .header {
            padding-bottom: 17px;
        }

        .cinema-list-view .content-right .cinema-rank {
            float: right;
            width: 284px;
        }

        .cinema-list-view .content-right .cinema-rank .cinema-header {
            border-bottom: 1px solid #ccc;
            padding: 0 0 12px 0;
            margin-top: 0;
            width: 100%;
        }

        .cinema-list-view .content-right .cinema-rank .cinema-header h3 {
            font-size: 24px;
            color: #333;
            margin: 0;
            font-weight: normal;
        }

        .cinema-list-view .content-right .cinema-rank .rank li {
            height: 70px;
            width: 100%;
            border-bottom: 1px solid #e5e5e5;
            font-size: 14px;
        }

        .cinema-list-view .content-right .cinema-rank .rank li i {
            color: #fff;
            display: inline-block;
            width: 26px;
            height: 26px;
            text-align: center;
            line-height: 22px;
            background-color: #36bfd1;
            border-radius: 13px;
            margin-top: 22px;
            font-style: normal;
        }

        .cinema-list-view .content-right .cinema-rank .rank li .order {
            background-color: #b2b2b2;
        }

        .cinema-list-view .content-right .cinema-rank .rank li span {
            color: #333;
            margin-left: 10px;
        }

        .cinema-list-view .content-right .cinema-rank .rank li p {
            display: inline-block;
            float: right;
            font-size: 12px;
            margin-top: 22px;
            color: #b2b2b2;
        }
    </style>
    <!--<script type="text/javascript" charset="utf-8" async="" src="./影片详情页+在线购票页_files/4-94c1ee.js.下载"></script>-->
    <style type="text/css">
        .mini-seating-chart {
            padding: 20px 12px;
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            position: absolute;
            background-color: #fff;
            bottom: 55px;
            left: -22px;
            min-width: 150px;
        }

        .mini-seating-chart .icon-caret-down {
            position: absolute;
            bottom: -23px;
            left: 25px;
            font-size: 22px;
            color: #e5e5e5;
        }

        .mini-seating-chart .map {
            position: relative;
        }

        .mini-seating-chart .seat {
            position: absolute;
            background-color: #e5e5e5;
            display: inline-block;
            border-radius: 2px;
            width: 8px;
            height: 8px;
        }

        .mini-seating-chart .seat.occupied {
            background-color: #ff6640;
        }

        .mini-seating-chart .seat.occupied.broken {
            background-color: #ff6640;
        }

        .mini-seating-chart .seat.broken {
            background-color: #ff6640;
        }

        .mini-seating-chart .seat.selected {
            background-color: #ff6640;
        }
    </style>
    <style type="text/css">
        .film-detail-view .banner {
            text-align: center;
            background-color: #e5e5e5;
            min-height: 100px;
            position: relative;
        }

        .film-detail-view .banner:after {
            content: '';
            background: url(//static.maizuo.com/pc/v1/static/asset/b1deea6fbf220b5354be7535b101b510.png) repeat;
            height: 100%;
            display: block;
            top: 0;
            position: absolute;
            width: 100%;
        }

        .film-detail-view .banner .video-popup-view .mz-modal {
            width: 70%;
            border: none;
            background-color: #000;
        }

        .film-detail-view .banner .video-popup-view .mz-modal-body {
            padding: 50px 0 0 0;
        }

        .film-detail-view .banner .video-popup-view .mz-modal-close {
            font-weight: bold;
            font-size: 50px;
            z-index: 99;
            height: 50px;
            line-height: 50px;
        }

        .film-detail-view .banner .video-popup-view .mz-modal-header {
            padding: 0;
        }

        .film-detail-view .banner .cover-play {
            color: #fff;
            font-size: 115px;
            cursor: pointer;
            opacity: 0.4;
            position: absolute;
            z-index: 99;
            top: 200px;
            display: inline-block;
        }

        .film-detail-view .banner .cover-play:hover {
            opacity: 1;
        }

        .film-detail-view .banner .play-button {
            color: #808080;
            display: inline-block;
            line-height: 145px;
            left: 50%;
            position: absolute;
            margin-left: 520px;
        }

        .film-detail-view .banner .play-button .play {
            font-size: 40px;
            cursor: pointer;
            z-index: 99;
            position: relative;
        }

        .film-detail-view .banner .play-button .play:hover {
            opacity: 1;
        }

        .film-detail-view .banner .play-button span {
            display: inline-block;
            position: relative;
            font-size: 14px;
            top: -10px;
            right: 10px;
        }

        .film-detail-view .banner img {
            margin: 0 auto;
            display: block;
            height: 520px;
            width: 100%;
        }

        .film-detail-view .banner #youkuplayer {
            width: 100%;
            height: 520px;
            margin-bottom: 60px;
            margin: 0;
        }

        .film-detail-view .banner #youkuplayer .icon-play {
            color: #fff;
            font-size: 115px;
            line-height: 600px;
            cursor: pointer;
            opacity: 0.4;
        }

        .film-detail-view .banner #youkuplayer .icon-play:hover {
            opacity: 1;
        }

        .film-detail-view .information {
            margin-top: -50px;
            position: relative;
        }

        .film-detail-view .information img {
            border: 10px solid #fff;
            float: left;
        }

        .film-detail-view .outline {
            margin-left: 300px;
            color: #808080;
        }

        .film-detail-view .outline .title {
            font-size: 36px;
            margin-top: 40px;
            border-bottom: 1px dotted #ccc;
            padding-bottom: 25px;
        }

        .film-detail-view .outline .title h3 {
            display: inline-block;
            padding: 0;
            margin: 0;
            font-size: 32px;
            font-weight: normal;
            color: #333;
        }

        .film-detail-view .outline .title .grade {
            color: #ff6640;
            margin: 0 30px;
            vertical-align: middle;
        }

        .film-detail-view .outline .title .grade i {
            font-size: 18px;
            vertical-align: super;
            font-style: normal;
        }

        .film-detail-view .outline .title .intro {
            font-size: 18px;
        }

        .film-detail-view .label {
            color: #fff;
        }

        .film-detail-view .label i {
            font-style: normal;
            border: 1px solid #fff;
            border-radius: 30px;
            padding: 6px 20px;
            margin-right: 15px;
            display: inline-block;
        }

        .film-detail-view .cover-label {
            color: #36bfd1;
        }

        .film-detail-view .cover-label i {
            font-style: normal;
            border: 1px solid #36bfd1;
            border-radius: 30px;
            padding: 6px 20px;
            margin-right: 15px;
            display: inline-block;
        }

        .film-detail-view .film-intro {
            padding-top: 20px;
        }

        .film-detail-view .film-intro label {
            color: #333;
            float: left;
        }

        .film-detail-view .film-intro li {
            margin-right: 30px;
        }

        .film-detail-view .film-intro li label {
            margin-right: 5px;
        }

        .film-detail-view .film-intro .film-intro-one {
            height: 20px;
            margin-bottom: 10px;
        }

        .film-detail-view .film-intro .film-intro-one li,
        .film-detail-view .film-intro .film-intro-three li {
            float: left;
            display: inline;
        }

        .film-detail-view .film-intro .film-intro-two li {
            margin: 0 0 10px;
        }

        .film-detail-view .film-intro .synopsis {
            vertical-align: top;
            padding-left: 40px;
            line-height: 22px;
        }

        .film-detail-view .film-intro .synopsis span {
            color: #ff6640;
            margin-left: 10px;
            cursor: pointer;
        }

        .film-detail-view .film-intro .avatar label {
            margin-top: 20px;
        }

        .film-detail-view .film-intro .avatar-wrap {
            display: inline-block;
        }

        .film-detail-view .film-intro .film-intro-three img {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            border: none;
            float: none;
        }

        .film-detail-view .film-intro .film-intro-three li {
            width: 60px;
            padding: 0 10px;
        }

        .film-detail-view .film-intro .film-intro-three li span {
            text-align: center;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            display: block;
        }

        .film-detail-view .poster {
            padding: 32px 0;
            width: 1220px;
            margin: 0 auto;
        }

        .film-detail-view .poster .slick-list {
            width: 1200px;
        }

        .film-detail-view .poster .item {
            cursor: pointer;
        }

        .film-detail-view .poster .slick-arrow {
            z-index: 1;
            width: 50px;
            height: 50px;
            top: 50%;
            margin-top: 5px;
        }

        .film-detail-view .poster .slick-prev {
            left: 20px;
        }

        .film-detail-view .poster .slick-next {
            right: 60px;
        }

        .film-detail-view .poster .slick-prev:before,
        .film-detail-view .poster .slick-next:before {
            font-size: 50px;
        }

        .film-detail-view .poster .popup-poster .mz-modal-header {
            padding: 0px;
        }

        .film-detail-view .poster .popup-poster .mz-modal-body {
            padding: 0;
            height: 650px;
            line-height: 650px;
        }

        .film-detail-view .poster .popup-poster .mz-modal-body img {
            max-width: 600px;
            max-height: 560px;
            vertical-align: middle;
        }

        .film-detail-view .poster .popup-poster .icon-close {
            position: absolute;
            right: 20px;
            top: 20px;
            border: none;
            background: transparent;
            color: #fff;
            opacity: 0.3;
            font-size: 45px;
            cursor: pointer;
        }

        .film-detail-view .poster .popup-poster .icon-pre,
        .film-detail-view .poster .popup-poster .icon-next {
            font-size: 55px;
            position: absolute;
            color: #fff;
            opacity: 0.3;
            top: 250px;
            cursor: pointer;
            top: 50%;
            margin-top: -30px;
        }

        .film-detail-view .poster .popup-poster .icon-pre {
            left: 20px;
        }

        .film-detail-view .poster .popup-poster .icon-next {
            right: 20px;
        }

        .film-detail-view .poster .popup-poster .mz-modal-mask {
            background-color: #333;
            opacity: 0.94;
        }

        .film-detail-view .poster .popup-poster .mz-modal {
            border-radius: 20px;
            width: 980px;
            height: 650px;
            border: 10px solid rgba(229, 229, 229, 0.21);
            background: initial;
        }

        .film-detail-view .poster .popup-poster .mz-modal-content {
            text-align: center;
            position: relative;
            background: rgba(255, 255, 255, 0.3);
            border-radius: 10px;
        }

        .film-detail-view .online {
            width: 850px;
            display: inline-block;
            color: #808080;
            float: left;
        }

        .film-detail-view .active-view {
            float: right;
        }

        .film-detail-view .cinema-select .header {
            padding: 5px 0;
            border-bottom: 1px solid #ccc;
        }

        .film-detail-view .cinema-select .header h3 {
            font-size: 24px;
            font-weight: normal;
            color: #333;
            margin: 0;
        }

        .film-detail-view .cinema-select span {
            color: #333;
            margin-right: 10px;
            margin-top: 8px;
            display: inline-block;
        }

        .film-detail-view .cinema-select .item {
            padding: 20px 0;
            border-bottom: 1px solid #e5e5e5;
        }

        .film-detail-view .cinema-select .item .item-inner {
            display: inline-block;
            vertical-align: top;
            width: 93%;
        }

        .film-detail-view .cinema-select .item li {
            float: left;
            padding: 8px 13px;
            cursor: pointer;
            margin-right: 10px;
        }

        .film-detail-view .cinema-select .item .mz-pagination {
            padding-top: 20px;
        }

        .film-detail-view .cinema-select .item .mz-pagination li {
            padding: 0;
        }

        .film-detail-view .cinema-select .item .mz-pagination span {
            color: #808080;
            margin: 0px;
        }

        .film-detail-view .cinema-select .item .mz-pagination span.current {
            color: #36bfd1;
        }

        .film-detail-view .cinema-select .item .cineme-panel li {
            width: 20%;
            text-align: center;
            margin: 0 12px 10px 0;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .film-detail-view .cinema-select .item .active {
            color: #fff;
            background: #36bfd1;
            border-radius: 20px;
        }

        .film-detail-view .foretell {
            margin-bottom: 80px;
            position: relative;
        }

        .film-detail-view .foretell .icon-caret-up {
            position: absolute;
            top: 69px;
            left: 100px;
            color: #e5e5e5;
        }

        .film-detail-view .foretell .header {
            padding: 25px 0 25px 50px;
            color: #ccc;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .film-detail-view .foretell .header h4 {
            display: inline-block;
            margin: 0px 20px 0 0;
            font-size: 18px;
            font-weight: normal;
            color: #333;
        }

        .film-detail-view .foretell .header span {
            color: #ccc;
            vertical-align: text-bottom;
            margin-right: 10px;
        }

        .film-detail-view .foretell .header .address {
            margin: 0px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .film-detail-view .foretell .content {
            border: 10px solid #e5e5e5;
            border-radius: 20px;
            padding: 0 38px;
            min-height: 300px;
        }

        .film-detail-view .foretell .content .search {
            position: relative;
            width: 50px;
        }

        .film-detail-view .foretell .content .title {
            font-size: 12px;
            margin-top: 0;
            border-bottom: 3px solid #e5e5e5;
            color: #ccc;
        }

        .film-detail-view .foretell .content .title .time {
            width: 70px;
            margin-right: 30px;
        }

        .film-detail-view .foretell .content .title .buy {
            width: 89px;
            padding-right: 0;
        }

        .film-detail-view .foretell .content li {
            float: left;
            padding: 20px 15px 20px 0;
            width: 14%;
            text-align: center;
        }

        .film-detail-view .foretell .content .item {
            border-bottom: 1px solid #e5e5e5;
            color: #808080;
        }

        .film-detail-view .foretell .content .item:last-child {
            border-bottom: 0;
        }

        .film-detail-view .foretell .content .item .time {
            font-size: 24px;
            color: #333;
            width: 70px;
            text-align: left;
            margin-right: 30px;
        }

        .film-detail-view .foretell .content .item .icon-search {
            font-size: 15px;
            cursor: pointer;
            padding: 15px;
        }

        .film-detail-view .foretell .content .item li {
            height: 36px;
            line-height: 36px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .film-detail-view .foretell .content .item li.search {
            overflow: initial;
            text-overflow: initial;
            white-space: initial;
        }

        .film-detail-view .foretell .content .item .price {
            font-size: 24px;
            color: #ff6640;
        }

        .film-detail-view .foretell .content .item .buy {
            width: 89px;
            padding-right: 0;
        }

        .film-detail-view .foretell .content .item button {
            background: #ff6640;
            border-radius: 20px;
            border: none;
            width: 89px;
            height: 35px;
            color: #fff;
            cursor: pointer;
        }

        .film-detail-view .foretell .content .item button.disable {
            background: #ccc;
        }

        .film-detail-view .foretell .content .item button.disable:hover {
            background-color: #ccc;
        }

        .film-detail-view .foretell .content .item button:hover {
            background-color: #ff5000;
        }

        .film-detail-view .foretell .loading-circle {
            margin-top: 120px;
            zoom: 0.8;
        }

        .film-detail-view .curtain {
            color: #e5e5e5;
            font-size: 35px;
            text-align: center;
            padding: 100px 0;
        }

        .film-detail-view .hidden {
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
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
                            <li class="active">影片</li>
                            <li class="">影院</li>
                        </ul>
                    </div>
                    <div class="app"><span><!-- react-text: 18 -->APP下载<!-- /react-text --><i class="icon-caret-down"></i></span></div>
                    <div class="sign">
                        <ul>
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
                        </ul>
                    </div>
                </div>
                <div class="city-view-wrap inner">
                    <div class="city-view hidden"><i class="icon-caret-up"></i>
                        <div class="content">
                            <div class="clearfix hot"><span>热 门</span>
                                <div>
                                    <ul>
                                        <li>北京</li>
                                        <li>上海</li>
                                        <li>广州</li>
                                        <li>深圳</li>
                                        <li>杭州</li>
                                        <li>成都</li>
                                        <li>重庆</li>
                                        <li>武汉</li>
                                        <li>长沙</li>
                                        <li>东莞</li>
                                        <li>佛山</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>A</span>
                                <div>
                                    <ul>
                                        <li>安顺</li>
                                        <li>阿拉善盟</li>
                                        <li>安宁</li>
                                        <li>安康</li>
                                        <li>安庆</li>
                                        <li>安阳</li>
                                        <li>鞍山</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>B</span>
                                <div>
                                    <ul>
                                        <li>毕节</li>
                                        <li>北海</li>
                                        <li>北京</li>
                                        <li>本溪</li>
                                        <li>巴中</li>
                                        <li>百色</li>
                                        <li>滨州</li>
                                        <li>亳州</li>
                                        <li>白城</li>
                                        <li>白山</li>
                                        <li>保定</li>
                                        <li>宝鸡</li>
                                        <li>蚌埠</li>
                                        <li>巴彦淖尔</li>
                                        <li>保山</li>
                                        <li>包头</li>
                                        <li>白银</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>C</span>
                                <div>
                                    <ul>
                                        <li>朝阳</li>
                                        <li>常州</li>
                                        <li>滁州</li>
                                        <li>承德</li>
                                        <li>成都</li>
                                        <li>昌江</li>
                                        <li>沧州</li>
                                        <li>长春</li>
                                        <li>重庆</li>
                                        <li>长沙</li>
                                        <li>潮州</li>
                                        <li>澄迈</li>
                                        <li>楚雄</li>
                                        <li>赤峰</li>
                                        <li>常德</li>
                                        <li>郴州</li>
                                        <li>长治</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>D</span>
                                <div>
                                    <ul>
                                        <li>都江堰</li>
                                        <li>大理</li>
                                        <li>东莞</li>
                                        <li>德阳</li>
                                        <li>儋州</li>
                                        <li>东营</li>
                                        <li>德州</li>
                                        <li>定西市</li>
                                        <li>大同</li>
                                        <li>定州</li>
                                        <li>大连</li>
                                        <li>大庆</li>
                                        <li>丹东</li>
                                        <li>达州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>E</span>
                                <div>
                                    <ul>
                                        <li>鄂尔多斯</li>
                                        <li>恩施</li>
                                        <li>鄂州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>F</span>
                                <div>
                                    <ul>
                                        <li>防城港</li>
                                        <li>抚顺</li>
                                        <li>阜阳</li>
                                        <li>抚州</li>
                                        <li>丰城</li>
                                        <li>佛山</li>
                                        <li>阜新</li>
                                        <li>富阳</li>
                                        <li>福州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>G</span>
                                <div>
                                    <ul>
                                        <li>广安</li>
                                        <li>桂林</li>
                                        <li>广元</li>
                                        <li>广州</li>
                                        <li>公主岭市</li>
                                        <li>固始县</li>
                                        <li>贵港</li>
                                        <li>固原</li>
                                        <li>甘孜州</li>
                                        <li>贵阳</li>
                                        <li>赣州</li>
                                        <li>高邮</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>H</span>
                                <div>
                                    <ul>
                                        <li>惠州</li>
                                        <li>合作</li>
                                        <li>海东</li>
                                        <li>黄山</li>
                                        <li>黑河</li>
                                        <li>河池</li>
                                        <li>呼伦贝尔</li>
                                        <li>鹤岗</li>
                                        <li>葫芦岛</li>
                                        <li>海北州</li>
                                        <li>怀化</li>
                                        <li>和龙市</li>
                                        <li>桦甸市</li>
                                        <li>菏泽</li>
                                        <li>淮安</li>
                                        <li>邯郸</li>
                                        <li>哈密市</li>
                                        <li>汉中</li>
                                        <li>杭州</li>
                                        <li>淮南</li>
                                        <li>黄冈</li>
                                        <li>呼和浩特</li>
                                        <li>合肥</li>
                                        <li>洪湖</li>
                                        <li>贺州</li>
                                        <li>黄石</li>
                                        <li>红河州</li>
                                        <li>哈尔滨</li>
                                        <li>衡阳</li>
                                        <li>海口</li>
                                        <li>衡水</li>
                                        <li>湖州</li>
                                        <li>河源</li>
                                        <li>淮北</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>J</span>
                                <div>
                                    <ul>
                                        <li>晋中</li>
                                        <li>焦作</li>
                                        <li>荆州</li>
                                        <li>吉安</li>
                                        <li>冀州市</li>
                                        <li>济宁</li>
                                        <li>荆门</li>
                                        <li>济源</li>
                                        <li>揭阳</li>
                                        <li>嘉峪关</li>
                                        <li>锦州</li>
                                        <li>景德镇</li>
                                        <li>酒泉</li>
                                        <li>济南</li>
                                        <li>晋城</li>
                                        <li>吉林</li>
                                        <li>靖江</li>
                                        <li>江门</li>
                                        <li>九江</li>
                                        <li>金华</li>
                                        <li>嘉兴</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>K</span>
                                <div>
                                    <ul>
                                        <li>昆明</li>
                                        <li>开原</li>
                                        <li>开封</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>L</span>
                                <div>
                                    <ul>
                                        <li>临汾</li>
                                        <li>临夏州</li>
                                        <li>乐山</li>
                                        <li>陇南</li>
                                        <li>漯河</li>
                                        <li>聊城</li>
                                        <li>莱芜</li>
                                        <li>六安</li>
                                        <li>连云港</li>
                                        <li>辽源</li>
                                        <li>临高</li>
                                        <li>乐东</li>
                                        <li>辽阳</li>
                                        <li>廊坊</li>
                                        <li>洛阳</li>
                                        <li>兰州</li>
                                        <li>娄底</li>
                                        <li>临沧</li>
                                        <li>柳州</li>
                                        <li>临沂</li>
                                        <li>丽水</li>
                                        <li>六盘水</li>
                                        <li>吕梁</li>
                                        <li>泸州</li>
                                        <li>临海</li>
                                        <li>龙岩</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>M</span>
                                <div>
                                    <ul>
                                        <li>牡丹江</li>
                                        <li>绵阳</li>
                                        <li>茂名</li>
                                        <li>马鞍山</li>
                                        <li>眉山</li>
                                        <li>梅州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>N</span>
                                <div>
                                    <ul>
                                        <li>南通</li>
                                        <li>南阳</li>
                                        <li>南宁</li>
                                        <li>南充</li>
                                        <li>南京</li>
                                        <li>宁德</li>
                                        <li>内江</li>
                                        <li>南平</li>
                                        <li>南昌</li>
                                        <li>宁波</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>P</span>
                                <div>
                                    <ul>
                                        <li>萍乡</li>
                                        <li>濮阳</li>
                                        <li>平顶山</li>
                                        <li>普洱</li>
                                        <li>攀枝花</li>
                                        <li>莆田</li>
                                        <li>盘锦</li>
                                        <li>邳州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>Q</span>
                                <div>
                                    <ul>
                                        <li>七台河</li>
                                        <li>黔南州</li>
                                        <li>黔西南州</li>
                                        <li>潜江</li>
                                        <li>齐齐哈尔</li>
                                        <li>黔东南州</li>
                                        <li>钦州</li>
                                        <li>曲靖</li>
                                        <li>青岛</li>
                                        <li>庆阳</li>
                                        <li>秦皇岛</li>
                                        <li>泉州</li>
                                        <li>琼海</li>
                                        <li>清远</li>
                                        <li>衢州</li>
                                        <li>启东</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>R</span>
                                <div>
                                    <ul>
                                        <li>日照</li>
                                        <li>瑞安</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>S</span>
                                <div>
                                    <ul>
                                        <li>遂宁</li>
                                        <li>沈阳</li>
                                        <li>绥化</li>
                                        <li>朔州</li>
                                        <li>上海</li>
                                        <li>三明</li>
                                        <li>商洛</li>
                                        <li>深圳</li>
                                        <li>上饶</li>
                                        <li>商丘</li>
                                        <li>随州</li>
                                        <li>宿迁</li>
                                        <li>石家庄</li>
                                        <li>三亚</li>
                                        <li>十堰</li>
                                        <li>宿州</li>
                                        <li>汕尾</li>
                                        <li>松原</li>
                                        <li>双鸭山</li>
                                        <li>邵阳</li>
                                        <li>绍兴</li>
                                        <li>四平</li>
                                        <li>石嘴山</li>
                                        <li>苏州</li>
                                        <li>汕头</li>
                                        <li>韶关</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>T</span>
                                <div>
                                    <ul>
                                        <li>铜陵</li>
                                        <li>铜仁</li>
                                        <li>泰安</li>
                                        <li>铁岭</li>
                                        <li>太原</li>
                                        <li>屯昌</li>
                                        <li>唐山</li>
                                        <li>天津</li>
                                        <li>泰州</li>
                                        <li>天水</li>
                                        <li>通化</li>
                                        <li>天门</li>
                                        <li>台州</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>W</span>
                                <div>
                                    <ul>
                                        <li>芜湖</li>
                                        <li>潍坊</li>
                                        <li>威海</li>
                                        <li>文山</li>
                                        <li>文昌</li>
                                        <li>五指山</li>
                                        <li>武汉</li>
                                        <li>梧州</li>
                                        <li>武威</li>
                                        <li>乌鲁木齐</li>
                                        <li>乌兰察布</li>
                                        <li>温州</li>
                                        <li>五家渠</li>
                                        <li>渭南</li>
                                        <li>涡阳</li>
                                        <li>无锡</li>
                                        <li>吴忠</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>X</span>
                                <div>
                                    <ul>
                                        <li>信阳</li>
                                        <li>许昌</li>
                                        <li>西双版纳</li>
                                        <li>邢台</li>
                                        <li>咸宁</li>
                                        <li>兴义</li>
                                        <li>湘江市</li>
                                        <li>新乡</li>
                                        <li>忻州</li>
                                        <li>孝感</li>
                                        <li>湘西州</li>
                                        <li>兴安盟</li>
                                        <li>锡林郭勒盟</li>
                                        <li>仙桃</li>
                                        <li>西宁</li>
                                        <li>锡林浩特</li>
                                        <li>湘潭</li>
                                        <li>新余</li>
                                        <li>宣城</li>
                                        <li>咸阳</li>
                                        <li>西安</li>
                                        <li>襄阳</li>
                                        <li>徐州</li>
                                        <li>厦门</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>Y</span>
                                <div>
                                    <ul>
                                        <li>玉溪</li>
                                        <li>盐城</li>
                                        <li>岳阳</li>
                                        <li>宜昌</li>
                                        <li>雅安</li>
                                        <li>宜宾</li>
                                        <li>阳泉</li>
                                        <li>玉林</li>
                                        <li>伊春</li>
                                        <li>营口</li>
                                        <li>延边</li>
                                        <li>运城</li>
                                        <li>鹰潭</li>
                                        <li>银川</li>
                                        <li>榆林</li>
                                        <li>宜春</li>
                                        <li>阳江</li>
                                        <li>扬州</li>
                                        <li>益阳</li>
                                        <li>永州</li>
                                        <li>延安</li>
                                        <li>烟台</li>
                                        <li>延吉</li>
                                        <li>云浮</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix city-list"><span>Z</span>
                                <div>
                                    <ul>
                                        <li>肇庆</li>
                                        <li>漳州</li>
                                        <li>周口</li>
                                        <li>镇江</li>
                                        <li>驻马店</li>
                                        <li>资阳</li>
                                        <li>自贡</li>
                                        <li>中山</li>
                                        <li>遵义</li>
                                        <li>株洲</li>
                                        <li>湛江</li>
                                        <li>昭通</li>
                                        <li>张家界</li>
                                        <li>张家口</li>
                                        <li>枣庄</li>
                                        <li>中卫</li>
                                        <li>淄博</li>
                                        <li>珠海</li>
                                        <li>郑州</li>
                                        <li>舟山</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- react-empty: 43 -->
                <!-- react-empty: 44 -->
            </div>
            <div class="application-main">
                <div class="film-detail-view">
                    <div class="banner"><span class="hidden"></span>
                        <div class="play-button"><span>预告片</span><i class="icon-play play"></i></div>
                        <div class="video-popup-view">
                            <div class="mz-modal-mask mz-modal-mask-hidden"></div>
                            <div class="mz-modal-wrap mz-modal-wrap-hidden">
                                <div class="mz-modal">
                                    <div class="mz-modal-content"><button class="mz-modal-close">×</button>
                                        <div class="mz-modal-header"></div>
                                        <div class="mz-modal-body">
                                            <div id="youkuplayer"><iframe width="100%" height="100%" allow="autoplay" src="./影片详情页+在线购票页_files/XMzU2NDIxODA1Mg==.html" id="iframeId" frameborder="0" allowfullscreen="true" scrolling="no"></iframe></div>
                                            <!-- react-text: 1859 -->}
                                            <!-- /react-text -->
                                        </div>
                                        <div class="mz-modal-footer"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="inner clearfix">
                        <div class="information clearfix"><img src="http://119.23.42.247:83/img/${filmDetail.filmImg}" width="254">
                            <div class="outline">
                                <div class="cover-label"><i>${filmDetail.threeDLV}</i><i>${filmDetail.language}</i><i>${filmDetail.filmLength}分钟</i></div>
                                <div class="title">
                                    <h3>${filmDetail.filmName}</h3><span class="grade"><!-- react-text: 1872 -->${filmDetail.filmScore}<!-- /react-text --></span><span class="intro"><!-- react-text: 1875 -->[&nbsp;&nbsp;<!-- /react-text --><!-- react-text: 1876 -->${filmDetail.details}<!-- /react-text --><!-- react-text: 1877 -->&nbsp;&nbsp;]<!-- /react-text --></span></div>
                                <div class="film-intro">
                                    <ul class="film-intro-one">
                                        <p id="filmID" style="display: none">${filmDetail.id}</p>
                                        <li><label>上映：</label><span><fmt:formatDate value="${filmDetail.filmStartDate}" pattern="yyyy-MM-dd"/> </span></li>
                                        <li><label>类型：</label><span><c:forEach var="type" items="${filmDetail.types}">${type} /</c:forEach> </span></li>
                                        <li><label>导演：</label><span>${filmDetail.director}</span></li>
                                    </ul>
                                    <ul class="film-intro-two">
                                        <li><label>剧情：</label>
                                            <div class="synopsis">
                                                <!-- react-text: 1893 -->${filmDetail.synopsis}
                                                <!-- /react-text --><span>更多</span></div>
                                        </li>
                                        <li class="avatar"><label>主演：</label>
                                            <div class="avatar-wrap">
                                                <ul class="film-intro-three">
                                                    <c:forEach items="${filmDetail.actors}" var="actor">
                                                    <li><img src="http://119.23.42.247:83/img/${actor.actorPhoto}"><span>${actor.actorName}</span></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="poster">
                            <div class="slick-initialized slick-slider"><button type="button" data-role="none" class="slick-arrow slick-prev" style="display: block;"> Previous</button>
                                <div class="slick-list">
                                    <div class="slick-track" style="opacity: 1; width: 2400px; transform: translate3d(0px, 0px, 0px);"></div>
                                </div><button type="button" data-role="none" class="slick-arrow slick-next" style="display: block;"> Next</button></div>
                            <div class="popup-poster">
                                <div class="mz-modal-mask mz-modal-mask-hidden"></div>
                                <div class="mz-modal-wrap mz-modal-wrap-hidden">
                                    <div class="mz-modal">
                                        <div class="mz-modal-content"><button class="mz-modal-close hidden">×</button>
                                            <div class="mz-modal-header"></div>
                                            <div class="mz-modal-body"><button class="icon-close"></button><span class="icon-pre"></span><img><span class="icon-next"></span></div>
                                            <div class="mz-modal-footer"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="online">
                            <div class="cinema-select">
                                <div class="header">
                                    <h3>在线购票</h3></div>
                                <div class="content">
                                    <div class="item date"><span>日期：</span>
                                        <div class="clearfix item-inner">
                                            <ul>
                                                <%--<li class="active">2018-06-05 (今天)</li>--%>
                                                <c:forEach items="${dates}" var="date">
                                                    <li class="" onclick="event2('${date}')">${date}</li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="item"><span>区域：</span>
                                        <div class="clearfix item-inner">
                                            <ul>
                                                <c:forEach items="${areas}" var="area">
                                                <li class="" onclick="findCinema(${area.id})">${area.area_name}</li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="item"><span>影院：</span>
                                        <div class="item-inner">
                                            <ul class="cineme-panel clearfix" id="cinemas">

                                            </ul>
                                        </div>
                                        <div class="mz-pagination"><i class="icon-pre pre"></i>
                                            <div class="pagination-pages"><span class="current">1</span><span>/10</span></div><i class="icon-next next"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="foretell">
                                <div class="header">
                                   <div id="one"><h4>武汉博影时代影城</h4><span>027-83806099</span><span class="address">武汉市硚口区航空路13号</span></div><i class="icon-caret-up"></i>
                                <div class="content clearfix" id="two">
                                    <ul class="title clearfix">
                                        <li class="time">放映时间</li>
                                        <li>语言/版本</li>
                                        <li>放映厅</li>
                                        <li>票价</li>
                                        <li class="buy">立即订票</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- react-empty: 1972 -->
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="content inner">
                    <h2><img src="./影片详情页+在线购票页_files/97d132d70ddef38021064aae67963766.png" alt="卖座"><!-- react-text: 67 -->电影订座&nbsp;&nbsp;就上卖座<!-- /react-text --></h2>
                    <div class="service"><img src="./影片详情页+在线购票页_files/cceb956981ce7ae563401d65b3e6421f.png" alt="卖座客服"><span>电话：</span><span class="moblie">400-1808-400</span><span>周日-周四：9:00-22:00&nbsp;&nbsp;周五-周六：9:00-22:30</span></div>
                    <div class="follow">
                        <div class="item"><img src="./影片详情页+在线购票页_files/b9e924f8e417675ce2e125649d7530ce.png">
                            <div class="tip"><img src="./影片详情页+在线购票页_files/ec5f0f45fc548050c5e613a416294452.png" width="151">
                                <p>扫码下载卖座电影APP</p><span class="icon-caret-down"></span></div>
                        </div>
                        <div class="item"><img src="./影片详情页+在线购票页_files/d4af003a3ca8ad39fb8715440c15b17c.png">
                            <div class="tip"><img src="./影片详情页+在线购票页_files/500b205c9fbf141e4b3c2824d4e8d7fe.png" width="151">
                                <p>扫码关注卖座官方微信</p><span class="icon-caret-down"></span></div>
                        </div>
                        <div class="item">
                            <a href="http://www.weibo.com/maizuo" target="_blank"><img src="./影片详情页+在线购票页_files/ce402ffd0ccd2499f976e53db87ecf90.png"></a>
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
                            <!-- react-text: 112 -->Copyright ©
                            <!-- /react-text -->
                            <!-- react-text: 113 -->2018
                            <!-- /react-text -->
                            <!-- react-text: 114 -->maizuo. All Rights Reserved 卖座网 版权所有 增值业务经营许可证:粤B2-200502318
                            <!-- /react-text -->
                        </p><img src="./影片详情页+在线购票页_files/1c40acb236a22bea60e5889ad57cdd7c.png"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    var strdate;

    function event2(str) {
        strdate = str;
    }
    
    function findPlatoon(cinema_id) {
        $("#one").html("");
        $("#three").html("");
        $("#two").html("");
        var film_id = $("#filmID").html();
        $.get("cinema/findCinemaByid",{"id":cinema_id},function (data) {
            $("#one").html("<h4>"+data.cinema_name+"</h4><span>"+data.cinema_tel+"</span><span class=\"address\">"+data.cinema_adress+"</span>")
        });

        $.get("cinema/findPlatoon",{"film_id":film_id,"cinema_id":cinema_id,"show_start_date":strdate},function (data) {
                 console.log(data);
                $.each(data,function (index,obj) {
                    $("#two").append("<ul id=\"three\" class=\"item clearfix\"><li class=\"time\">"+ obj.show_start_time+"</li><li>"+obj.film.language+"/"+obj.film.threeDLV+"</li><li>"+obj.hallBean.hall_name+"</li><li class=\"price\">￥"+obj.film_price+"</li><li class=\"buy\"><button type=\"button\" class=\"\">选座购票</button></li></ul>")
                });
        });

    }


    function findCinema(areaid) {
        $("#cinemas").html("");
        $.get("cinema/findCinema",{"areaid":areaid},function (data) {

          $.each(data,function (index,obj) {
              $("#cinemas").append("<li onclick='findPlatoon("+obj.id+")'>"+obj.cinema_name+"</li>");
          });
        });
    }
    
</script>


<!--<script src="./影片详情页+在线购票页_files/app-92cd8fd4df.js.下载"></script>-->
<!--<script type="text/javascript" src="./影片详情页+在线购票页_files/browser-blocker-43804fd688.js.下载" charset="utf-8" data-ie-minimum="8"></script>-->
</body>

</html>
