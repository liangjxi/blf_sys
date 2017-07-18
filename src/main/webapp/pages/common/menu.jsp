<%--
  User: Tennyson
  E-Mail:wangxing@bailefen.com
  DateTime: 2016/12/3  01:57
  Description:菜单组件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
    <li class="nav-item start active open">
        <a href="javascript:void(0);" class="nav-link nav-toggle">
            <i class="icon-layers"></i>
            <span class="title">首页</span>
            <span class="selected"></span>
        </a>
    </li>

    <li class="nav-item">
        <a href="javascript:void(0);" class="nav-link nav-toggle">
            <i class="icon-home"></i>
            <span class="title">信贷审批</span>
            <span class="arrow"></span>
        </a>
        <ul class="sub-menu">
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-info"></i>
                    <span class="title">审查管理</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item active open">
                        <a href="javascript:void(0);" class="nav-link ">资料审查</a>
                    </li>
                    <li class="nav-item ">
                        <a href="javascript:void(0);" class="nav-link ">贷款审查</a>
                    </li>
                    <li class="nav-item ">
                        <a href="javascript:void(0);" class="nav-link ">审查复核</a>
                    </li>
                    <li class="nav-item ">
                        <a href="javascript:void(0);" class="nav-link ">复核条件管理</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-call-end"></i>
                    <span class="title">审批管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="javascript:void(0);" class="nav-link nav-toggle">
                    <i class="icon-notebook"></i>
                    <span class="title">贷后管理</span>
                    <span class="selected"></span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item">
                        <a href="javascript:void(0);" class="nav-link ">客户服务</a>
                    </li>
                    <li class="nav-item ">
                        <a href="javascript:void(0);" class="nav-link ">贷后受理</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link nav-toggle">
                    <i class="fa fa-bank"></i>
                    <span class="title">&nbsp;机构管理</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">机构管理</span>
                        </a>
                    </li>

                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">网点管理</span>
                        </a>
                    </li>

                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">产品管理</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    产品管理
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    申请条件管理
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    要求资料管理
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    变更规则管理
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    产品用途
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="nav-item  " name="business">
                <a href="javascript:void(0);" class="nav-link nav-toggle">
                    <i class="fa fa-building-o"></i>
                    <span class="title">&nbsp;商户管理</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item  " name="business_management">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">商户管理</span>
                        </a>
                    </li>

                    <li class="nav-item  " name="store_management">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">门店管理</span>
                        </a>
                    </li>

                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">商品管理</span>
                        </a>
                    </li>

                    <li class="nav-item  " name="agent">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">经纪人管理</span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">

                            <li class="nav-item " name="agent_show">
                                <a href="javascript:void(0);" class="nav-link ">
                                    经纪人
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    认证管理
                                </a>
                            </li>

                            <li class="nav-item ">
                                <a href="javascript:void(0);" class="nav-link ">
                                    提现管理
                                </a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </li>

    <li class="nav-item">
        <a href="javascript:void(0);" class="nav-link nav-toggle">
            <i class="icon-home"></i>
            <span class="title">系统管理</span>
            <span class="arrow"></span>
        </a>
        <ul class="sub-menu">
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-info"></i>
                    <span class="title">用户管理</span>
                </a>
            </li>
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-call-end"></i>
                    <span class="title">角色管理</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="javascript:void(0);" class="nav-link nav-toggle">
                    <i class="icon-notebook"></i>
                    <span class="title">组织架构</span>
                    <%--<span class="selected"></span>--%>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item">
                        <a href="javascript:void(0);" class="nav-link ">部门管理</a>
                    </li>
                    <li class="nav-item ">
                        <a href="javascript:void(0);" class="nav-link ">职位管理</a>
                    </li>
                </ul>
            </li>
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-call-end"></i>
                    <span class="title">日志管理</span>
                </a>
            </li>
            <li class="nav-item  ">
                <a href="javascript:void(0);" class="nav-link ">
                    <i class="icon-call-end"></i>
                    <span class="title">数据爬取</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">规则管理</span>
                        </a>
                    </li>
                    <li class="nav-item  ">
                        <a href="javascript:void(0);" class="nav-link ">
                            <span class="title">任务管理</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </li>

    <!-- 系统管理 END -->
</ul>
