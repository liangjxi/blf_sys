package com.blf.system.service.impl;

import com.blf.system.entities.BlfCity;
import com.blf.system.service.ICityService;
import common.dao.IBaseDao;
import common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.service.impl
 * DateTime: 2017/5/16  16:10
 * Description:手动添加
 */
@Service
public class CityServiceImpl extends BaseServiceImpl implements ICityService {
    @Autowired
    private IBaseDao baseDao;

    @Override
    public List<?> find(Map<String,String> formMap)throws Exception{
        StringBuffer hql = new StringBuffer("from BlfCity where 1 = 1 and state = true and isDelete = false ");
        hql.append("order by createDate desc ");
        return baseDao.find(hql.toString());
    }

    @Override
    public Object findById(Integer id) throws Exception {
        return baseDao.findById(BlfCity.class, id);
    }
}
