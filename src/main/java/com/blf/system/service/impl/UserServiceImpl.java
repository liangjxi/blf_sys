package com.blf.system.service.impl;

import com.blf.system.entities.BlfUser;
import com.blf.system.service.IUserService;
import common.dao.IBaseDao;
import common.page.Pagination;
import common.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * BlfUser: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.service.impl
 * DateTime: 2017/5/16  17:46
 * Description:手动添加
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

    @Autowired
    private IBaseDao baseDao;

    @Override
    public Pagination find(Map<String, String> formMap, Pagination page) throws Exception {
        StringBuffer hql = new StringBuffer("from BlfUser where is_Delete = false ");
        if (null!=formMap && formMap.values().size() >0) {
            if (StringUtils.isNotBlank(formMap.get("search_code"))) {
                hql.append(" and code like '%").append(formMap.get("search_code")).append("%' ");
            }
            if (StringUtils.isNotBlank(formMap.get("search_name"))) {
                hql.append(" and realName like '%").append(formMap.get("search_name")).append("%' ");
            }
            if (StringUtils.isNotBlank(formMap.get("search_mobile"))) {
                hql.append(" and mobile like '%").append(formMap.get("search_mobile")).append("%' ");
            }

        }
        hql.append(" order by lastUpdateDate desc ");
        return baseDao.find(hql.toString(),
                Pagination.getInitPage(page), Pagination.getInitPageSize(page));
    }

    @Override
    public Object findById(Integer id) throws Exception {
        return baseDao.findById(BlfUser.class, id);
    }

    @Override
    public void update(Object obj) throws Exception {
        baseDao.update(obj);
    }

    @Override
    public void save(Object obj) throws Exception {
        baseDao.save(obj);
    }

    @Override
    public void deleteAll(Collection entities)throws Exception{
        if (null != entities && entities.size() > 0){
            for (Object obj:entities){
                baseDao.update(obj);
            }
        }
    }

    public BlfUser getByMobileOrWithPasswd(String loginName, String passwd) throws Exception {
        StringBuffer hql = null;
        if (StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(passwd)){
            hql = new StringBuffer("from BlfUser where is_Delete = false ");
            hql.append(" and ( mobile = '").append(loginName).append("' ");
            hql.append(" or code = '").append(loginName).append("')  ");
            hql.append(" and passwd  = '").append(passwd).append("'");
            List<BlfUser> BlfUsers = (List<BlfUser>) baseDao.find(hql.toString());
            if (null != BlfUsers && BlfUsers.size() > 0){
                return BlfUsers.get(0);
            }
        }
        return null;
    }

    public void deleteByIds(String[] ids) throws Exception {
        for(String id : ids){
            BlfUser BlfUser = (BlfUser) findById(Integer.valueOf(id.trim()));
            BlfUser.setIsDelete(true);
            update(BlfUser);
        }
    }
}
