package common.service.impl;

import common.page.Pagination;
import common.service.IBaseService;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * .
 * User: 王星
 * E-Mail:xing_wang@cxsoft.com.cn
 * DateTime: 13-8-5  下午3:12
 * Description:业务层基接口实现
 */
public class BaseServiceImpl implements IBaseService {
    public void delete(Object obj) throws Exception {
       
    }

    public void deleteById(Integer id) throws Exception {
       
    }

    public Pagination find(Map<String, String> formMap, Pagination page)throws Exception {
        return null;
    }

    public Object findById(Integer id) throws Exception {
        return null;
    }

    public Object findById(String id) throws Exception {
       
        return null;
    }

    public void save(Object obj) throws Exception {
        
    }

    public void update(Object obj) throws Exception {
        
    }

    public void delete(String[] ID) throws Exception {

    }

    public void deleteAll(Collection entities)throws Exception{

    }

    public List<?> findAll() throws Exception {
        return null;
    }

	@Override
	public List<?> find(Map<String, String> formMap) throws Exception {
		return null;
	}

    public Pagination find(Map<String, String> formMap, Pagination pagination,
                           Integer userId) throws Exception {
        return null;
    }
}
