<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
	<meta charset="utf-8" />
	<title>佰乐分 | 锁屏</title>
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
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="<%=request.getContextPath()%>/plugins/pages/css/lock.min.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL STYLES -->
	<!-- BEGIN THEME LAYOUT STYLES -->
	<!-- END THEME LAYOUT STYLES -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/imges/favicon.ico" /> </head>
<!-- END HEAD -->

<body class="">
<div class="page-lock">
	<div class="page-logo">
		<a class="brand" href="javascript:;">
			<img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/logo-light.png" alt="logo" /> </a>
	</div>

	<div class="page-body">
		<div class="lock-head"> 锁定 </div>
		<div class="lock-body">
			<div class="pull-left lock-avatar-block">
				<img src="<%=request.getContextPath()%>/plugins/pages/media/profile/avatar.png" class="lock-avatar"> </div>
			<form id="unlockForm" class="lock-form pull-left" action="javascript:;" method="post">
				<h4>${userName}</h4>
				<div class="form-group">
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="pwd" /> </div>
				<div class="form-actions">
					<button id="btnSub" type="button" class="btn red uppercase">解锁</button>
				</div>
				<br/>
				<span id="showTips"></span>
			</form>
		</div>
		<div class="lock-bottom">
			<a href=""> &nbsp;</a>
		</div>
	</div>
	<div class="page-footer-custom"> 2017 &copy; 佰乐分版权所有. </div>
</div>
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
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/pages/scripts/lock.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<!-- END THEME LAYOUT SCRIPTS -->

<script type="text/javascript">
    $("#btnSub").click(function(){
        if(null != $("input[name=pwd]").val() && "" != $("input[name=pwd]").val()){
            $("#unlockForm").attr("method","post");
            $("#unlockForm").attr("action","<%=request.getContextPath()%>/unlock");
            $("#unlockForm").submit();
        }else{
            $("#showTips").html("<font style='color:red;font-size:15px;'>密码不能为空</font>");
        }
    });

    //清空错误提示
    $("#pwd").focus(function(){
        $("#showTips").empty();
    });
</script>

</body>

</html>