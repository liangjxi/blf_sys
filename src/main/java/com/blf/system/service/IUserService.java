package com.blf.system.service;

import common.service.IBaseService;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.system.service
 * DateTime: 2017/5/16  17:45
 * Description:手动添加
 */
public interface IUserService extends IBaseService {

    public void deleteByIds(String[] ids) throws Exception;
}
