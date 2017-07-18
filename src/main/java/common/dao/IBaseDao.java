package common.dao;

import common.page.Pagination;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * .
 * User: 王星
 * E-Mail:xing_wang@cxsoft.com.cn
 * DateTime: 13-8-5  下午2:46
 * Description:DAO基类接口
 */
public interface IBaseDao {
	/**
	 * 保存
	 * @param obj 要保存的对象
	 */
    public void save(Object obj);
    
    /**
     * 修改
     * @param obj 要修改的对象
     */
    public void update(Object obj);
    
    /**
     * 删除
     * @param obj 要删除的对象
     */
    public void delete(Object obj);
    
    /**
     * 删除全部
     * @param entities 要删除的实体集合
     */
    public void deleteAll(Collection<?> entities);
    
    /**
     * 根据ID查找对象
     * @param c 要查找的对象对应的实体
     * @param id 对象ID
     * @return
     */
    public Object findById(Class<?> c, Serializable id);
    
    /**
     * 通过HQL查询
     * @param hql
     * @return List<?>
     */
    public List<?> find(String hql);
    
    /**
     * 执行插入、删除、和更新SQL语句
     * @param sql
     * @throws SQLException
     */
    public void executeSQL(String sql) throws SQLException;
    
    /**
     * 执行插入、删除、和更新HQL语句
     * @param hql 
     * @throws SQLException
     */
    public void executeHQL(String hql) throws SQLException;
    
    /**
     * 执行SQL语句查询
     * @param sql 查询语句
     * @return List<HashMap<String, Object>>
     */
    public List<HashMap<String, Object>> executeQuerySQL(String sql) throws SQLException;
    
    /**
     * hql分页查询
     * @param hql  查询语句
     * @param startPage 起始页
     * @param pageSize 每页大小
     * @return 当前页数据集合
     */
    public Pagination find(String hql, int startPage, int pageSize) throws Exception;
    
    /**
     * sql分页查询
     * @param sql  查询语句
     * @param inPage  起始页
     * @param inPageSize 每页大小
     * @return 当前页数据集合
     * @throws SQLException
     */
    public Pagination executeQuerySQL(String sql, int inPage, int inPageSize) throws SQLException;
    
    /**
     * 存储方法分页查询
     * @param sql 查询sql
     * @param param 参数
     * @return  当前页数据集合
     * @throws SQLException
     */
    public Pagination findProcedure(String sql, List<String[]> param) throws SQLException;
    
    /**
     * 解决"同一个session里面有了两个相同标识但是是不同实体" 在执行update报错的问题
     * @param obj	处理对象
     */
    public void updateForMerge(Object obj) throws Exception;
}
