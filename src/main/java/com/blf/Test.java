package com.blf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf
 * DateTime: 2017/5/17  16:06
 * Description:手动添加
 */
public class Test {

    protected static  final Log LOG = LogFactory.getLog(Test.class);

    public static void main(String[]args){
        LOG.info("========= 日志输出");

        LOG.trace("我是LOG，trace");

        LOG.debug("我是LOG，debug");

        LOG.info("我是LOG，info");

        LOG.warn("我是LOG，warn");

        LOG.error("我是LOG，error");

        LOG.fatal("我是LOG，fatal");
    }
}
