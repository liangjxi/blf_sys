package common.service;

import common.page.Pagination;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * .
 * User: 王星
 * E-Mail:xing_wang@cxsoft.com.cn
 * DateTime: 13-8-5  下午3:10
 * Description:业务层基接口，其他业务层的接口继承此接口
 */
public interface IBaseService {
	/**
	 * 保存
	 * @param obj
	 * @throws Exception
	 */
    public void save(Object obj) throws Exception;
    
    
    /**
     * 修改
     * @param obj
     * @throws Exception
     */
    public void update(Object obj) throws Exception;
    /**
     * 删除
     * @param obj
     * @throws Exception
     */
    public void delete(Object obj) throws Exception;
    /**
     * 删除
     * @param ID 要删除的实体的ID数组
     * @throws Exception
     */
    public void delete(String[] ID) throws Exception;

    /**
     * 删除集合内实体
     * @param entities
     * @throws Exception
     */
    public void deleteAll(Collection entities)throws Exception;

    /**
     * 根据ID删除
     * @param id
     * @throws Exception
     */
    public void deleteById(Integer id) throws Exception;
    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws Exception
     */
    public Object findById(Integer id) throws Exception;
    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws Exception
     */
    public Object findById(String id) throws Exception;
    /**
     * 分页查找
     * @param formMap 查询参数 
     * @param pagination 分页对象
     * @return
     * @throws Exception
     */
    public Pagination find(Map<String, String> formMap, Pagination pagination) throws Exception;
    /**
     * 查找用户相关数据分页
     * @param formMap 查询参数
     * @param pagination 分页对象
     * @param userId  用户ID
     * @return
     * @throws Exception
     */
    public Pagination find(Map<String, String> formMap, Pagination pagination, Integer userId) throws Exception;
    /**
     * 根据条件查找
     * @param formMap 查询参数
     * @return
     * @throws Exception
     */
    public List<?> find(Map<String, String> formMap) throws Exception;
    /**
     * 查找所有
     * @return
     * @throws Exception
     */
    public List<?> findAll() throws Exception;
}
