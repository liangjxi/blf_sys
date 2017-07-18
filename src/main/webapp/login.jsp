<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
	<meta charset="utf-8" />
	<title>佰乐分 |  登录</title>
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
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<link href="<%=request.getContextPath()%>/plugins/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/plugins/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL STYLES -->
	<link href="<%=request.getContextPath()%>/plugins/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
	<link href="<%=request.getContextPath()%>/plugins/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
	<!-- END THEME GLOBAL STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="<%=request.getContextPath()%>/plugins/pages/css/login-4.min.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL STYLES -->
	<!-- BEGIN THEME LAYOUT STYLES -->
	<!-- END THEME LAYOUT STYLES -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/imges/favicon.ico" /> </head>
<!-- END HEAD -->

<body class=" login">
<!-- BEGIN LOGO -->
<div class="logo">
	<a href="index.html">
		<img src="<%=request.getContextPath()%>/imges/blf.png" alt="" /> </a>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
	<!-- BEGIN LOGIN FORM -->
	<form id ="loginForm" class="login-form" action="<%=request.getContextPath()%>/login" method="post">
		<h3 class="form-title">登录</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span> 用户名和密码不能为空. </span>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">用户名</label>
			<div class="input-icon">
				<i class="fa fa-user"></i>
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="loginName" /> </div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">密码</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="登录密码" name="pwd" /> </div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9"></label>
			<div class="input-icon">
				<i class="fa fa-keyboard-o"></i>
				<input id="codeNo" class="form-control placeholder-no-fix" style="width: 200px;float: left" type="text" autocomplete="off" placeholder="验证码" name="codeNo" />
				<img id="codeImg" style="margin:3px auto;width:90px;float: right" src="<%=request.getContextPath() %>/code/valcode"/>
			</div>
		</div>
	</br>
		</br>
		</br>

		<div class="form-actions">
			<button type="submit" class="btn green pull-right"> 登录 </button>
				</br>
		</div>
	</form>
	<!-- END LOGIN FORM -->
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="copyright"> 2017 &copy; 佰乐分 - 综合平台 </div>
<!-- END COPYRIGHT -->
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
<script src="<%=request.getContextPath()%>/plugins/global/plugins/js.cookie.min.js" type="text/javascript"></script>

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<%=request.getContextPath()%>/plugins/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/pages/scripts/login-4.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- 表单验证 -->
<script src="<%=request.getContextPath() %>/plugins/validVal/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/plugins/validVal/messages_zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function () {
        <!--刷新验证码 -->
        $("#codeImg").click(function(){
            var url = "<%=request.getContextPath() %>/code/valcode?t="+new Date();
            $.ajax({
                type:'get',
                url:url,
                success:function () {
                    $("#codeImg").attr("src",url);
                }
            });
        });
    });
</script>


</body>

</html>