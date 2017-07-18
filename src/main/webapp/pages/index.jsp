<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>佰乐分 | 控制面板</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout4/css/layout.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout4/css/themes/light.min.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout4/css/custom.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME LAYOUT STYLES -->

    <!-- toastr -->
    <link href="<%=request.getContextPath()%>/plugins/toastr/css/toastr.css" rel="stylesheet" type="text/css" />

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/imges/favicon.ico" />
</head>
<!-- END HEAD -->

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo page-footer-fixed page-sidebar-fixed">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <jsp:include page="common/header.jsp"/>
    <!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<!-- BEGIN HEADER & CONTENT DIVIDER -->
<div class="clearfix"> </div>
<!-- END HEADER & CONTENT DIVIDER -->
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- BEGIN SIDEBAR -->
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <jsp:include page="/pages/common/menu.jsp"/>
            <!-- END SIDEBAR MENU -->
        </div>
        <!-- END SIDEBAR -->
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">
            <!-- BEGIN PAGE HEAD-->
            <div class="page-head">
                <!-- BEGIN PAGE TITLE -->
                <div class="page-title">
                    <h1>空白页
                        <small>空白页布局</small>
                    </h1>
                </div>
            </div>
            <!-- END PAGE HEAD-->
            <!-- BEGIN PAGE BREADCRUMB -->
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="index.html">主页</a>
                    <i class="fa fa-circle"></i>
                </li>
                <li>
                    <a href="#">空白页</a>
                    <i class="fa fa-circle"></i>
                </li>
                <li>
                    <span class="active">内容显示</span>
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <!-- BEGIN PAGE BASE CONTENT -->
            <div class="note note-info">
                <p> 空白页随便你发挥 </p>
            </div>
            <!-- END PAGE BASE CONTENT -->
        </div>
        <!-- END CONTENT BODY -->
    </div>
    <!-- END CONTENT -->
    <!-- BEGIN QUICK SIDEBAR -->
    <%--<jsp:include page="/pages/common/rightPanel.jsp"/>--%>
    <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<jsp:include page="/pages/common/footer.jsp"/>
<!-- END FOOTER -->
<!--[if lt IE 9]>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/respond.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/excanvas.min.js"></script>
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="<%=request.getContextPath()%>/plugins/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/layouts/layout4/scripts/layout.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/layouts/layout4/scripts/demo.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->

<!-- toast Start-->
<script src="<%=request.getContextPath()%>/plugins/toastr/js/toastr.js"></script>
<script src="<%=request.getContextPath()%>/plugins/toastr/js/glimpse.js"></script>
<script src="<%=request.getContextPath()%>/plugins/toastr/js/glimpse.toastr.js"></script>
<!-- toast End -->

<!-- WebScoket Start-->
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<!-- WebScoket End-->

<script type="text/javascript">
    $(function () {
        connect();
    })

    function showToastr(title,msg) {
        //显示类型：success/info/warning/error
        var shortCutFunction = "info";
        //参数设置
        toastr.options = {
            "closeButton": true,
            "debug": true,
            "positionClass": "toast-top-right",
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "10000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };

        //点击事件
        toastr.options.onclick = function () {
//            alert('您点击了Toastr！');
            window.open("http://www.baidu.com","","");
        };

        //设置标题、内容
        toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
    }
    
    
    function connect() {
        if ('WebSocket' in window) {
            ws= new WebSocket("ws://localhost:8080/blf_sys/websck");
        }else {
            ws = new SockJS("http://localhost:8080/blf_sys/sockjs/websck");
        }
        ws.onopen = function () {
            console.log('Info: connection opened.');
            showToastr("推送消息","连接服务器成功");
        };
        ws.onmessage = function (event) {
            console.log('Received: ' + event.data);
            showToastr("推送消息",event.data);
        };
        ws.onclose = function (event) {
            console.log('Info: connection closed.');
            console.log(event);
        };
    }

</script>


</body>

</html>

