<%--
  User: Tennyson
  E-Mail:wangxing@bailefen.com
  DateTime: 2016/12/3  02:17
  Description:工作面板页面
--%>
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
    <title>佰乐分 | 个人面板</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <!-- 网页加载进度条 start -->
    <script src="<%=request.getContextPath()%>/plugins/global/plugins/pace/pace.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/pace/themes/pace-theme-flash.css" rel="stylesheet" type="text/css" />
    <!-- 网页加载进度条 End -->

    <link href="<%=request.getContextPath()%>/plugins/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <!-- END GLOBAL MANDATORY STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css" />

    <link href="<%=request.getContextPath()%>/plugins/pages/css/profile.min.css" rel="stylesheet" type="text/css" />
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout/css/themes/light.min.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="<%=request.getContextPath()%>/plugins/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME LAYOUT STYLES -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/imges/favicon.ico" /> </head>



<!-- END HEAD -->




<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo page-sidebar-fixed">
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
                    <h1>大标题
                        <small>副标题</small>
                    </h1>
                </div>
                <!-- END PAGE TITLE -->
            </div>
            <!-- END PAGE HEAD-->
            <!-- BEGIN PAGE BREADCRUMB -->
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="javascript:;">主页</a>
                    <i class="fa fa-circle"></i>
                </li>
                <li>
                    <span class="active">当前页面位置</span>
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <!-- BEGIN PAGE BASE CONTENT
            <div class="note note-info">
                <p> 内容 </p>
            </div>-->



            <div class="row">
                <div class="col-md-3 ">
                    <div class="portlet box white">
                        <div class="portlet light profile-sidebar-portlet ">
                            <!-- SIDEBAR USERPIC -->
                            <div class="profile-userpic">
                                <img style="height: 16%;" src="<%=request.getContextPath()%>/plugins/pages/media/profile/avatar.png" class="img-responsive" alt=""> </div>
                            <!-- END SIDEBAR USERPIC -->
                            <!-- SIDEBAR USER TITLE -->
                            <div class="profile-usertitle">
                                <div class="profile-usertitle-name"> ${userName} </div>
                                <div class="profile-usertitle-job"> 系统管理员 </div>
                            </div>
                            <!-- END SIDEBAR USER TITLE -->
                            <!-- SIDEBAR BUTTONS -->
                            <div class="profile-userbuttons">
                                <button type="button" class="btn btn-circle green btn-sm">Follow</button>
                                <button type="button" class="btn btn-circle red btn-sm">Message</button>
                            </div>
                            <!-- END SIDEBAR BUTTONS -->
                            <!-- SIDEBAR MENU -->
                            <div class="profile-usermenu">
                                <ul class="nav">
                                    <li class="active">
                                        <a href="page_user_profile_1.html">
                                            <i class="icon-home"></i> Overview </a>
                                    </li>
                                    <li>
                                        <a href="page_user_profile_1_account.html">
                                            <i class="icon-settings"></i> Account Settings </a>
                                    </li>
                                    <li>
                                        <a href="page_user_profile_1_help.html">
                                            <i class="icon-info"></i> Help </a>
                                    </li>
                                </ul>
                            </div>
                            <!-- END MENU -->
                        </div>
                    </div>
                </div>

                <div class="col-md-3 ">
                    <div class="portlet box white">
                        <div class="portlet light profile-sidebar-portlet ">
                            <div class="profile-usertitle">
                                <div class="profile-usertitle-name"> 考勤 </div>
                                <%--<div class="profile-usertitle-job"> 系统管理员 </div>--%>
                            </div>
                            <div class="profile-usermenu">
                                <ul class="nav">
                                    <li class="">
                                        <a href="javascript:;">
                                            出勤天数
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            正常
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            迟到
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            早退
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            请假
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            外勤
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            旷工
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <!-- END MENU -->
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-sm-6">
                    <div class="portlet light portlet-fit bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="icon-directions font-green hide"></i>
                                <span class="caption-subject bold font-dark uppercase "> 通告</span>
                                <span class="caption-helper">通知 & 公告</span>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="cd-horizontal-timeline mt-timeline-horizontal">
                                <div class="timeline">
                                    <div class="events-wrapper">
                                        <div class="events">
                                            <ol>
                                                <li>
                                                    <a href="#0" data-date="16/01/2014" class="border-after-red bg-after-red ">16/01/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="28/02/2014" class="border-after-red bg-after-red">28/02/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="20/04/2014" class="border-after-red bg-after-red">20/04/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="20/05/2014" class="border-after-red bg-after-red">20/05/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="09/07/2014" class="border-after-red bg-after-red">09/07/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="30/08/2014" class="border-after-red bg-after-red selected">30/08/2014</a>
                                                </li>
                                            </ol>
                                            <span class="filling-line bg-red" aria-hidden="true"></span>
                                        </div>
                                        <!-- .events -->
                                    </div>
                                    <!-- .events-wrapper -->
                                    <ul class="cd-timeline-navigation mt-ht-nav-icon">
                                        <li>
                                            <a href="#0" class="prev inactive btn btn-outline red md-skip">
                                                <i class="fa fa-chevron-left"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#0" class="next btn btn-outline red md-skip">
                                                <i class="fa fa-chevron-right"></i>
                                            </a>
                                        </li>
                                    </ul>
                                    <!-- .cd-timeline-navigation -->
                                </div>
                                <!-- .timeline -->
                                <div class="events-content">
                                    <ol>
                                        <li class="" data-date="16/01/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">新用户</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">测试用户</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">2014/01/16  7:45</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="28/02/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">28 February 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">28 February 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">28 February 2014 : 10:15 AM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="20/04/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">20 April 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue">20 April 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">20 April 2014 : 10:45 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="20/05/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">9 July 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">20 May 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">20 May 2014 : 12:20 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="09/07/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">9 July 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">9 July 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">9 July 2014 : 8:15 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>
                                            </div>
                                        </li>
                                        <li class="selected" data-date="30/08/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">测试标题2</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">测试用户2</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">30/08/2014  5:45 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>
                                            </div>
                                        </li>
                                    </ol>
                                </div>
                                <!-- .events-content -->
                            </div>
                        </div>
                    </div>
                </div>

            </div>




            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="portlet light portlet-fit bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="icon-directions font-green hide"></i>
                                <span class="caption-subject bold font-dark uppercase "> 通告</span>
                                <span class="caption-helper">通知 & 公告</span>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="cd-horizontal-timeline mt-timeline-horizontal">
                                <div class="timeline">
                                    <div class="events-wrapper">
                                        <div class="events">
                                            <ol>
                                                <li>
                                                    <a href="#0" data-date="16/01/2014" class="border-after-red bg-after-red ">16/01/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="28/02/2014" class="border-after-red bg-after-red">28/02/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="20/04/2014" class="border-after-red bg-after-red">20/04/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="20/05/2014" class="border-after-red bg-after-red">20/05/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="09/07/2014" class="border-after-red bg-after-red">09/07/2014</a>
                                                </li>
                                                <li>
                                                    <a href="#0" data-date="30/08/2014" class="border-after-red bg-after-red selected">30/08/2014</a>
                                                </li>
                                            </ol>
                                            <span class="filling-line bg-red" aria-hidden="true"></span>
                                        </div>
                                        <!-- .events -->
                                    </div>
                                    <!-- .events-wrapper -->
                                    <ul class="cd-timeline-navigation mt-ht-nav-icon">
                                        <li>
                                            <a href="#0" class="prev inactive btn btn-outline red md-skip">
                                                <i class="fa fa-chevron-left"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#0" class="next btn btn-outline red md-skip">
                                                <i class="fa fa-chevron-right"></i>
                                            </a>
                                        </li>
                                    </ul>
                                    <!-- .cd-timeline-navigation -->
                                </div>
                                <!-- .timeline -->
                                <div class="events-content">
                                    <ol>
                                        <li class="" data-date="16/01/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">新用户</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">测试用户</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">2014/01/16  7:45</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                                这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="28/02/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">28 February 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">28 February 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">28 February 2014 : 10:15 AM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="20/04/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">20 April 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue">20 April 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">20 April 2014 : 10:45 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="20/05/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">9 July 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">20 May 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">20 May 2014 : 12:20 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>这里是内容<br/>
                                            </div>
                                        </li>
                                        <li data-date="09/07/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">9 July 2014</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">9 July 2014</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">9 July 2014 : 8:15 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>
                                            </div>
                                        </li>
                                        <li class="selected" data-date="30/08/2014">
                                            <div class="mt-title">
                                                <h2 class="mt-content-title">测试标题2</h2>
                                            </div>
                                            <div class="mt-author">
                                                <div class="mt-avatar">
                                                    <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" />
                                                </div>
                                                <div class="mt-author-name">
                                                    <a href="javascript:;" class="font-blue-madison">测试用户2</a>
                                                </div>
                                                <div class="mt-author-datetime font-grey-mint">30/08/2014  5:45 PM</div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="mt-content border-grey-steel">
                                                测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>测试内容<br/>
                                            </div>
                                        </li>
                                    </ol>
                                </div>
                                <!-- .events-content -->
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-sm-6">
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <span class="caption-subject bold uppercase font-dark">报表</span>
                                <span class="caption-helper">计划 & 业务</span>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div id="dashboard_amchart_1" class="CSSAnimationChart"></div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- END PAGE BASE CONTENT -->

        </div>
        <!-- END CONTENT BODY -->
    </div>
    <!-- END CONTENT -->
    <!-- BEGIN QUICK SIDEBAR -->
    <jsp:include page="/pages/common/rightPanel.jsp"/>
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
<script src="<%=request.getContextPath()%>/plugins/global/plugins/horizontal-timeline/horozontal-timeline.min.js" type="text/javascript"></script>

<!-- 报表 -->
<script src="<%=request.getContextPath()%>/plugins/global/plugins/morris/morris.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>

<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="<%=request.getContextPath()%>/plugins/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/plugins/global/scripts/app.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/plugins/pages/scripts/dashboard.min.js" type="text/javascript"></script>
</body>

</html>