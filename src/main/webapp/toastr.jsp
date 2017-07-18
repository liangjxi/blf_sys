<%--
  User: Tennyson
  E-Mail:wangxing@bailefen.com
  DateTime: 2017/7/7  16:22
  Description:自己修改描述
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8" />

    <title>toastr examples</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%=request.getContextPath()%>/plugins/toastr/css/toastr.css" rel="stylesheet" type="text/css" />
</head>



<body class="container">

<button type="button" class="btn btn-primary" id="showtoast">Show Toast</button>


<script src="http://www.jq22.com/jquery/1.9.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/toastr/js/toastr.js"></script>
<script src="<%=request.getContextPath()%>/plugins/toastr/js/glimpse.js"></script>
<script src="<%=request.getContextPath()%>/plugins/toastr/js/glimpse.toastr.js"></script>

<script type="text/javascript">
    $(function () {
        $('#showtoast').click(function () {
            //显示类型：success/info/warning/error
            var shortCutFunction = "info";
            //标题 可为空
            var title = "UUUU";
            //内容
            var msg = "hhhhhhhhhhhhhhhhhhhh";

            //参数设置
            toastr.options = {
                "closeButton": true,
                "debug": true,
                "positionClass": "toast-top-right",
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };

            //点击事件
            toastr.options.onclick = function () {
                alert('You can perform some custom action after a toast goes away');
            };

            $("#toastrOptions").text("toastr:"
                + JSON.stringify(toastr.options, null, 2)
            );
            //设置标题、内容
            toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
        });
    })

</script>

</body>

</html>

