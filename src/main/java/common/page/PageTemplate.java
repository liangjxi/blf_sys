package common.page;


import javax.servlet.http.HttpServletRequest;

/**
 * .
 * User: 王星
 * E-Mail:fwx_love@sina.com
 * DateTime: 13-8-5  下午3:20
 * Description:分页模板
 */
public class PageTemplate extends Pagination {
	
	/**
     * request中分页对象的KEY
     */
    public static final String PAGINATION_KEY = "pagination";
    /**
     * 控制中间显示的左右页码范围
     */
    static int sLeng = 4;
    /**
     * A标签样式
     */
    static String aStyle = "cursor: pointer;text-decoration: none;";
    /**
     * STRONG标签样式
     */
    static String strongStyle = "float: none;color:#00A600;margin:0px 0px 0px 0px;padding-left:0px;padding-right:0px;font-size:12px;";

    /**
     * STRONG标签样式黑色
     */
    static String strongStyle2 = "float: none;color:#000;margin:0px 0px 0px 0px;padding-left:0px;padding-right:0px;font-size:12px;";


    /**
     * 获得子集合的文本框名
     * @param n
     * @return
     */
    public static String getChildrenName(Integer n){
        String s = "";
        if(null!=n && n>0){
            for(int i=0;i<n;i++){
                s = s + ".pageChildren";
            }
        }
        return s;
    }
    /**
     * 设置初始化参数HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setInitHTML(StringBuffer str, Pagination pagination, Integer n){
        str.append("<input id='pageCount' type='hidden' name='pageCount' value=").append(pagination.getPageCount()).append(">")
            .append("<input id= 'pageNow' type='hidden' name='pageNow' value=").append(pagination.getPageNow()).append(">")
            .append("<input id= 'state' type='hidden' name='state' value=0>");
    }
    /**
     * 设置初始化参数HTML代码，包含'pagination.goPage'
     * @param str 字符串
     * @param pagination 分页对象类AA
     */
    public static void setInitHTML2(StringBuffer str, Pagination pagination, Integer n){
        str.append("<input id='pageCount' type='hidden' name='pageCount' value=").append(pagination.getPageCount()).append(">")
	        .append("<input id='pageNow' type='hidden' name='pageNow' value=").append(pagination.getPageNow()).append(">")
	        .append("<input id='state' type='hidden' name='state' value=0>")
	        .append("<input id='goPage' type='hidden' name='goPage' value=").append(pagination.getPageNow()).append(">");
    }
    /**
     * 设置总页数HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setPageCountHTML(StringBuffer str, Pagination pagination){
        str.append("&nbsp;共&nbsp;").append(pagination.getPageCount()).append("&nbsp;页，&nbsp;");
    }
    /**
     * 设置总记录数HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setRowCountHTML(StringBuffer str, Pagination pagination){
        str.append("&nbsp;共&nbsp;").append(pagination.getRowCount()).append("&nbsp;条&nbsp;&nbsp;&nbsp;&nbsp;");
    }
    /**
     * 设置首页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     * @param function 执行查询的js函数名
     */
    public static void setIndexPageHTML(StringBuffer str, Pagination pagination, String function, Integer n){
        if ((pagination.getPageCount()<=1) || (pagination.getPageNow()==1)){
            str.append("首页&nbsp;");
        }else{
            str.append("<A onclick=\"$('#state').val(").append(indexPageState).append(");").append(function).append(";\" ")
                    .append("style=\"").append(aStyle).append("\">")
                    .append("<strong style=\"").append(strongStyle).append("\">首页</strong>")
                    .append("</A>")
                    .append("&nbsp;");
        }
    }
    /**
     * 设置上一页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     * @param function 执行查询的js函数名
     */
    public static void setPreviousPageHTML(StringBuffer str, Pagination pagination, String function, Integer n){
        if ((pagination.getPageCount()<=1) || (pagination.getPageNow()==1)){
            str.append("上一页&nbsp;");
        }else{
            str.append("<A onclick=\"$('#state').val(").append(previousPageState).append(");").append(function).append(";\" ")
                    .append("style=\"").append(aStyle).append("\">")
                    .append("<strong style=\"").append(strongStyle).append("\">上一页</strong>")
                    .append("</A>&nbsp;");
        }
    }
    /**
     * 设置快捷页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     * @param function 执行查询的js函数名
     */
    public static void setShortcutPageHTML(StringBuffer str, Pagination pagination, String function, Integer m){
        int n;
        if(pagination.getPageCount()!=0){

            str.append("<strong style=\"").append(strongStyle2).append("\">|</strong>&nbsp;");
            for(int i=sLeng;i>0;i--){
                n = pagination.getPageNow()-i;
                if(n>0){
                    str.append("<A onclick=\"$('#state').val(").append(goPageState)
                    .append(");$('#goPage').val(").append(n).append(");")
                    .append(function).append(";\" ")
                    .append("style=\"").append(aStyle).append("\">")
                    .append("<strong style=\"").append(strongStyle).append("\">").append(n).append("</strong>")
                    .append("</A>")
                    .append("&nbsp;");
                }
            }
            str.append(pagination.getPageNow()).append("&nbsp;");
            for(int i=1;i<=sLeng;i++){
                n = pagination.getPageNow()+i;
                if(n<=pagination.getPageCount()){
                    str.append("<A onclick=\"$('#state').val(").append(goPageState)
                    .append(");$('#goPage').val(").append(n)
                    .append(");").append(function).append(";\" ")
                    .append("style=\"").append(aStyle).append("\">")
                    .append("<strong style=\"").append(strongStyle).append("\">").append(n).append("</strong>")
                    .append("</A>")
                    .append("&nbsp;");
                }
            }
            str.append("<strong style=\"").append(strongStyle2).append("\">|</strong>&nbsp;");
        }
    }
    /**
     * 设置下一页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     * @param function 执行查询的js函数名
     */
    public static void setNextPageHTML(StringBuffer str, Pagination pagination, String function, Integer n){
        if ((pagination.getPageCount()<=1) || (pagination.getPageCount()==pagination.getPageNow())){
            str.append("下一页&nbsp;");
        }else{
            str.append("<A onclick=\"$('#state').val(").append(nextPageState).append(");")
            .append(function).append(";\" ")
            .append("style=\"").append(aStyle).append("\">")
            .append("<strong style=\"").append(strongStyle).append("\">下一页</strong>")
            .append("</A>")
            .append("&nbsp;");
        }
    }
    /**
     * 设置下一页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     * @param function 执行查询的js函数名
     */
    public static void setLastPageHTML(StringBuffer str, Pagination pagination, String function, Integer n){
        if ((pagination.getPageCount()<=1) || (pagination.getPageCount()==pagination.getPageNow())){
            str.append("尾页&nbsp;");
        }else{
            str.append("<a onclick=\"$('#state').val(").append(lastPageState).append(");")
            .append(function).append(";\" ")
            .append("style=\"").append(aStyle).append("\">")
            .append("<strong style=\"").append(strongStyle).append("\">尾页</strong>")
            .append("</a>")
            .append("&nbsp;");
        }
    }
    /**
     * 设置当前页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setPageNowHTML(StringBuffer str, Pagination pagination){
        str.append("&nbsp;").append(pagination.getPageNow()).append("/").append(pagination.getPageCount()).append("页&nbsp;");
    }
    /**
     * 设置每页大小HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setPageSizeHTML(StringBuffer str, Pagination pagination){
        str.append("&nbsp;每页&nbsp;").append(pagination.getPageSize()).append("&nbsp;条&nbsp;");
    }
    /**
     * 设置跳转页HTML代码
     * @param str 字符串
     * @param pagination 分页对象类
     */
    public static void setGoPageHTML(StringBuffer str, Pagination pagination, String function, Integer n){
        str.append("&nbsp;&nbsp;转到<select style='width:35px;' name=\"page").append(getChildrenName(n)).
        append("GoPage\" onclick=\"document.getElementByName('state').value=").append(goPageState).append(";\" ")
        .append("onchange=\"document.getElementByName('goPage').value=this.value;").append(function).append(";\">");
        for(int i=1;i<=pagination.getPageCount();i++){
            if(i==pagination.getPageNow())
                str.append("<option value=").append(i).append(" selected>").append(i).append("</option>");
            else
                str.append("<option value=").append(i).append(">").append(i).append("</option>");
        }
        str.append("</select>页");
    }
    /**
     * 分页模板
     * @param request 请求对象
     * @param function
     * 第0位：执行查询的js函数名
     * @return String 分页HTML代码
     * @throws Exception 异常
     */
    public static String getPageHTML(HttpServletRequest request, String... function) throws Exception {
        Integer n = null;
        if(null!=function && function.length>1 && null!=function[1] && !"".equals(function[1])){
            n = Integer.valueOf(function[1].trim());
        }
        Pagination pagination = getPagination(request, n);

        pagination = (pagination==null)?new Pagination():pagination;//排除空对象
        StringBuffer str = new StringBuffer();
        setInitHTML2(str, pagination, n);
        str.append("<table style=\"text-align: center !important;\" id='tbltotal' height='18' border='0' width='99%' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolordark='#FFFFFF' bordercolor='#FFFFFF'>");
        str.append("<tbody>");
        str.append("<tr noWrap='nowrap'>");
        str.append("<td align='center' width='99%' style=\"text-align: center !important;\">");

        setPageCountHTML(str, pagination);//设置总页数HTML代码
        setRowCountHTML(str, pagination);//设置总记录数HTML代码
        setIndexPageHTML(str, pagination, function[0], n);//设置首页HTML代码
        setPreviousPageHTML(str, pagination, function[0], n);//设置上一页HTML代码
        setShortcutPageHTML(str, pagination, function[0], n);//设置快捷页HTML代码
        setNextPageHTML(str, pagination, function[0], n);//设置下一页HTML代码
        setLastPageHTML(str, pagination, function[0], n);//设置尾页HTML代码
        setPageNowHTML(str, pagination);//设置当前页HTML代码
        setPageSizeHTML(str, pagination);//设置每页大小HTML代码

//        setGoPageHTML(str, pagination, function[0], n);//设置跳转页HTML代码
        
        str.append("</td>");
        str.append("</tr>");
        str.append("</tbody>");
        str.append("</table>");

        return new String( (str.toString()) );
    }

    /**
     * 获取结果集
     * @param request
     * @param n
     * @return Pagination
     */
    public static Pagination getPagination(HttpServletRequest request, Integer n){
        Pagination pagination = (Pagination)request.getAttribute(PAGINATION_KEY);//分页对象

        if(null!=n && n>0){
            for(int i=0;i<n;i++){
                if(null!=pagination)
                    pagination = pagination.getPageChildren();
            }
        }
        return pagination;
    }

    /**
     * 获取结果集
     * @param pagination 分页对象
     * @param n
     * @return Pagination
     */
    public static Pagination getPagination(Pagination pagination, Integer n){
        Pagination p = pagination;

        if(null!=n && n>0){
            for(int i=0;i<n;i++){
                if(null!=p)
                    p = p.getPageChildren();
            }
        }
        return p;
    }


    /**
     * 获取当前页
     * @param request
     * @return
     */
    public static int getPageNow(HttpServletRequest request){
        return((Pagination)request.getAttribute(PAGINATION_KEY)).getPageNow();
    }
}
