<%--
  User: Tennyson
  E-Mail:wangxing@bailefen.com
  DateTime: 2016/12/3  01:57
  Description:头部组件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="page-header-inner ">
    <!-- BEGIN LOGO -->
    <div class="page-logo">
        <a href="javascript:;">
            <img src="<%=request.getContextPath()%>/imges/logo-light.png" style="width: 110px;height: 50px;margin-top: 10px;" alt="logo" class="logo-default" /> </a>
        <div class="menu-toggler sidebar-toggler">
            <!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
        </div>
    </div>
    <!-- END LOGO -->
    <!-- BEGIN RESPONSIVE MENU TOGGLER -->
    <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
    <!-- END RESPONSIVE MENU TOGGLER -->
    <!-- BEGIN PAGE TOP -->
    <div class="page-top">
        <!-- BEGIN TOP NAVIGATION MENU -->
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <li class="separator hide"> </li>
                <!-- BEGIN NOTIFICATION DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-notification dropdown-dark" id="header_notification_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <i class="icon-bell"></i>
                        <span class="badge badge-success"> 1 </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="external">
                            <h3>
                                <span class="bold">1条</span>通知</h3>
                            <a href="#">查看全部</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">刚刚</span>
                                        <span class="details">
                                            <span class="label label-sm label-icon label-success">
                                                <i class="fa fa-plus"></i>
                                            </span>
                                            新用户注册
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END NOTIFICATION DROPDOWN -->
                <li class="separator hide"> </li>
                <!-- BEGIN INBOX DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-inbox dropdown-dark" id="header_inbox_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <i class="icon-envelope-open"></i>
                        <span class="badge badge-danger"> 1 </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="external">
                            <h3>你有
                                <span class="bold">1条</span>新消息</h3>
                            <a href="javascript:;">查看全部</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
                                        <span class="photo">
                                            <img src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" class="img-circle" alt="">
                                        </span>
                                        <span class="subject">
                                            <span class="from">姓名</span>
                                            <span class="time">时间</span>
                                        </span>
                                        <span class="message"> 内容... </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END INBOX DROPDOWN -->
                <li class="separator hide"> </li>
                <!-- BEGIN TODO DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-extended dropdown-tasks dropdown-dark" id="header_task_bar">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <i class="icon-calendar"></i>
                        <span class="badge badge-primary"> 1 </span>
                    </a>
                    <ul class="dropdown-menu extended tasks">
                        <li class="external">
                            <h3>
                                你有
                                <span class="bold">1个</span>新任务</h3>
                            <a href="?p=page_todo_2">查看全部</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
                                        <span class="task">
                                            <span class="desc">新发布 v1.2 </span>
                                            <span class="percent">40%</span>
                                        </span>
                                        <span class="progress">
                                            <span style="width: 40%;" class="progress-bar progress-bar-success" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">编译40%</span>
                                            </span>
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- END TODO DROPDOWN -->
                <!-- BEGIN USER LOGIN DROPDOWN -->
                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                <li class="dropdown dropdown-user dropdown-dark">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <span class="username username-hide-on-mobile"> ${userName} </span>
                        <!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
                        <img alt="" class="img-circle" src="<%=request.getContextPath()%>/plugins/layouts/layout/img/avatar.png" /> </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="javascript:;">
                                <i class="icon-user"></i> 我的设置 </a>
                        </li>
                        <li>
                            <a href="javascript:;">
                                <i class="icon-calendar"></i> 我的日历 </a>
                        </li>
                        <li>
                            <a href="javascript:;">
                                <i class="icon-rocket"></i> 我的待办
                                <span class="badge badge-success"> 1 </span>
                            </a>
                        </li>
                        <li class="divider"> </li>
                        <li>
                            <a href="javascript:;">
                                <i class="icon-lock"></i> 锁屏 </a>
                        </li>
                        <li>
                            <a href="javascript:loginOut();">
                                <i class="icon-key"></i> 登出 </a>
                        </li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
                <!-- BEGIN QUICK SIDEBAR TOGGLER -->


                <!-- 弹出侧边栏按钮 -->
                <%--<li class="dropdown dropdown-extended quick-sidebar-toggler">--%>
                    <%--<span class="sr-only">Toggle Quick Sidebar</span>--%>
                    <%--<i class="icon-logout"></i>--%>
                <%--</li>--%>
                <!-- END QUICK SIDEBAR TOGGLER -->
            </ul>
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END PAGE TOP -->
</div>

<form id="headForm" method="post">

</form>

<script type="text/javascript">
    function loginOut() {
        console.log("======");
        $("#headForm").attr("action","<%=request.getContextPath()%>/loginout");
        $("#headForm").submit();
    }
</script>