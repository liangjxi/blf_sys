package com.blf.system.service.impl;

import com.blf.system.entities.BlfOperationLog;
import com.blf.system.service.IOperationLogService;
import common.dao.IBaseDao;
import common.page.Pagination;
import common.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * BlfOperationLog: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.service.impl
 * DateTime: 2017/5/16  17:39
 * Description:手动添加
 */
@Service
public class OperationLogServiceImpl extends BaseServiceImpl implements IOperationLogService {
    @Autowired
    private IBaseDao baseDao;

    @Override
    public Pagination find(Map<String, String> formMap, Pagination page) throws Exception {
        StringBuffer hql = new StringBuffer("from BlfOperationLog where is_Delete = false ");
        if (null!=formMap && formMap.values().size() >0) {

        }
        hql.append(" order by lastUpdateDate desc ");
        return baseDao.find(hql.toString(),
                Pagination.getInitPage(page), Pagination.getInitPageSize(page));
    }

//    @Override
//    public Object findById(Integer id) throws Exception {
//        return baseDao.findById(BlfOperationLog.class, id);
//    }

//    @Override
//    public void update(Object obj) throws Exception {
//        baseDao.update(obj);
//    }

//    @Override
//    public void save(Object obj) throws Exception {
//        baseDao.save(obj);
//    }

//    @Override
//    public void deleteAll(Collection entities)throws Exception{
//        if (null != entities && entities.size() > 0){
//            for (Object obj:entities){
//                baseDao.update(obj);
//            }
//        }
//    }

//    public void deleteByIds(String[] ids) throws Exception {
//        for(String id : ids){
//            BlfOperationLog BlfOperationLog = (BlfOperationLog) findById(Integer.valueOf(id.trim()));
//            update(BlfOperationLog);
//        }
//    }
}
