package common.page;

import java.util.HashMap;
import java.util.List;

/**
 * .
 * User: 王星
 * E-Mail:fwx_love@sina.com
 * DateTime: 13-8-5  下午2:48
 * Description:手动添加
 */
public class Pagination {
        /** 配置首页通用名称 */
        public static final int indexPageState = 1;
        /** 配置上一页通用名称 */
        public static final int previousPageState = 2;
        /** 配置下一页通用名称 */
        public static final int nextPageState = 3;
        /** 配置尾页通用名称 */
        public static final int lastPageState = 4;
        /** 配置跳转页通用名称 */
        public static final int goPageState = 5;

        /** 总记录数 */
        private int rowCount = 0;
        /** 总页数 */
        private int pageCount = 0;
        /** 当前页，初始化第1页 */
        private int pageNow = 1;
        /** 开始行数 */
        private int startRow = 0;
        /** 每页大小，每页初始化100条记录 */
        private int pageSize = 100;
        /** 跳转页 */
        private int goPage = 0;
        /** 记录集 */
        private List<?> list;
        /** 参数集 */
        private HashMap<Integer, Object> hashMap;
        /** 状态 */
        private int state = 0;
        /** 子结果集 */
        private Pagination pageChildren;

        public Pagination(){} // List

        /**
         * 构造分页对象，默认第一页开始
         * @param pageSize 指定多少条记录为一页
         */
        //构造函数
        public Pagination(int pageSize){
            this.pageSize = pageSize;
        }

        /**
         * 构造分页对象，指定当前页
         * @param goPage 跳到第几页
         * @param pageSize 指定多少条记录为一页
         */
        public Pagination(int goPage, int pageSize){
            this.goPage = goPage;
            this.pageSize = pageSize;
            this.state = goPageState;
        }

        /**
         * 获取当前请求页码
         * @param page DaoPage对象
         * @return int 当前请求页码
         */
        public static int getInitPage(Pagination page) {
            if(null == page) {
                page = new Pagination();
            } else {
                page.setPageNow(page.getPageNow() > 1 ? page.getPageNow() : 1);
                page.setPageCount(page.getPageCount() > 1 ? page.getPageCount() : 1);
                if (page.getState() != 0) {
                    if (page.getState() == previousPageState) {
                        if (page.getPageNow() > 1)
                            page.setPageNow(page.getPageNow() - 1);
                    } else if (page.getState() == indexPageState) {
                        page.setPageNow(1);
                    } else if (page.getState() == lastPageState) {
                        page.setPageNow(page.getPageCount());
                    } else if (page.getState() == nextPageState) {
                        if (page.getPageNow() < page.getPageCount())
                            page.setPageNow(page.getPageNow() + 1);
                    } else if (page.getState() == goPageState) {
                        page.setPageNow(page.getGoPage());
                    }
                } else {
                    page.setPageNow(1);
                }
            }
            return page.getPageNow();
        }

        /**
         * 获取每页大小
         * @param page DaoPage对象
         * @return int 每页大小
         */
        public static int getInitPageSize(Pagination page) {
            if(null == page){
                page = new Pagination();
            }
            return page.getPageSize();
        }

        /**
         * 获取数组形式的所有的分页对象
         * @param p 分页对象
         * @param n 分页对象里面总共有多少个分页对象
         * @param size 每个显示多少条记录
         * @return Pagination[]
         */
        public static Pagination[] getPaginations(Pagination p, int n, int size){
            Pagination[] ps = new Pagination[n];
            Pagination tp = p;

            ps[0] = new Pagination(Pagination.getInitPage(tp), size);

            for(int i=1;i<n;i++){
                if(null!=tp.getPageChildren())
                    tp = tp.getPageChildren();
                else
                    tp = new Pagination(1, size);
                ps[i] = new Pagination(Pagination.getInitPage(tp), size);
            }
            return ps;
        }
        /**
         * 获取开始行数
         * @return int 开始行数
         */
        public int getStartRow() {
            return startRow;
        }
        /**
         * 设置开始行数
         * @param startRow 开始行数
         * @return Pagination 分页对象
         */
        public Pagination setStartRow(int startRow) {
            this.startRow = startRow;
            return this;
        }
        /**
         * 获取参数集（存储过程中用到）
         * @return HashMap<Integer, Object> 参数集
         */
        public HashMap<Integer, Object> getHashMap() {
            return hashMap;
        }
        /**
         * 设置参数集（存储过程中用到）
         * @param hashMap 参数集
         * @return Pagination 分页对象
         */
        public Pagination setHashMap(HashMap<Integer, Object> hashMap) {
            this.hashMap = hashMap;
            return this;
        }
        /**
         * 获取总记录数
         * @return int 总记录数
         */
        public int getRowCount() {
            return rowCount;
        }
        /**
         * 设置总记录数
         * @param rowCount 总记录数
         * @return Pagination 分页对象
         */
        public Pagination setRowCount(int rowCount) {
            this.rowCount = rowCount;
            if (getPageSize() != 0)  //如果每页大小设置为0则不进行分页功能
                setPageCount((getRowCount() + getPageSize() - 1) / getPageSize());

            if (getPageNow() > getPageCount()) //设置当前页
                setPageNow(getPageCount());
            if (getPageNow() <= 0)
                setPageNow(1);

            setStartRow((getPageNow() - 1) * getPageSize() + 1); //设置开始行数
            return this;
        }
        /**
         * 获取总页数
         * @return int 总页数
         */
        public int getPageCount() {
            return pageCount;
        }
        /**
         * 设置总页数
         * @param pageCount 总页数
         * @return Pagination 分页对象
         */
        public Pagination setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }
        /**
         * 获取当前页码
         * @return int 页码
         */
        public int getPageNow() {
            return pageNow;
        }
        /**
         * 设置当前页码
         * @param pageNow 页码
         * @return Pagination 分页对象
         */
        public Pagination setPageNow(int pageNow) {
            this.pageNow = pageNow<0?0:pageNow;
            return this;
        }
        /**
         * 获取每页大小
         * @return int 大小
         */
        public int getPageSize() {
            return pageSize;
        }
        /**
         * 设置每页大小
         * @param pageSize 大小
         * @return Pagination
         */
        public Pagination setPageSize(int pageSize) {
            this.pageSize = pageSize<0?0:pageSize;
            return this;
        }
        /**
         * 获取跳转页码
         * @return int 页码
         */
        public int getGoPage() {
            return goPage;
        }
        /**
         * 设置跳转页码（必须还要另外设置状态为跳转状态）
         * @param goPage 页码
         * @return Pagination 分页对象
         */
        public Pagination setGoPage(int goPage) {
            this.goPage = goPage;
            return this;
        }
        /**
         * 获取结果集
         * @return List<?>
         */
        public List<?> getList() {
            return list;
        }
        /**
         * 设置结果集
         * @param list 结果集
         * @return Pagination 分页对象
         */
        public Pagination setList(List<?> list) {
            this.list = list;
            return this;
        }
        /**
         * 获取状态
         * @return int 状态码
         */
        public int getState() {
            return state;
        }
        /**
         * 设置状态
         * @param state 状态
         * @return Pagination 分页对象
         */
        public Pagination setState(int state) {
            this.state = state;
            return this;
        }
        /**
         * 获取子分页对象
         * @return Pagination 分页对象
         */
        public Pagination getPageChildren() {
            return pageChildren;
        }
        /**
         * 设置子分页对象
         * @param pageChildren 子分页对象
         * @return Pagination 分页对象
         */
        public Pagination setPageChildren(Pagination pageChildren) {
            this.pageChildren = pageChildren;
            return this;
        }
        /**
         * 获取上一页页码
         * @return int 上一页页码
         */
        public int getPreviousPage(){
            if(1<this.getPageNow())
                return this.getPageNow()-1;
            else
                return 1;
        }
        /**
         * 获取下一页页码
         * @return int 下一页页码
         */
        public int getNextPage(){
            if(this.getPageCount()>this.getPageNow())
                return this.getPageNow()+1;
            else
                return this.getPageCount();
        }
        /**
         * 是否有上一页页码
         * @return boolean true表示有，false表示无
         */
        public boolean isHasPreviousPage(){
            if(1<this.getPageNow())
                return true;
            else
                return false;
        }
        /**
         * 是否有下一页页码
         * @return boolean true表示有，false表示无
         */
        public boolean isHasNextPage(){
            if(this.getPageCount()>this.getPageNow())
                return true;
            else
                return false;
        }
}
