package com.blf.common.controller;

import com.alibaba.fastjson.JSON;
import common.page.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.controller
 * DateTime: 2016年5月23日 下午4:33:25
 * Description:基础Controller
 */
public class BaseController {
	/**
     * 日志输出控制对象
     */
    protected final Log LOG = LogFactory.getLog(getClass());
    /**
     * 定义分页对像,在ACTION引用分页时更简单，直接把PG带到需要引用的方法处即可
     */
    protected Pagination pagination = new Pagination();
    /**
     * 用户密码机密盐
     */
    protected final static String SALT = "@blf_sys";
    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination
     *            the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * 保存到cookie中
     *
     * @param response
     * @param name
     * @param value
     */
    public void setCookieValue(HttpServletResponse response, String name,
                               String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24 * 7);// 保存一个星期
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获取cookie中保存的值
     * @param request
     * @param name
     * @return
     */
    public String getCookieValue(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (null != name && null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name))
                    value = cookie.getValue();
            }
        }
        return value;
    }

    /**
     * 获取IP地址
     *
     * @return String IP地址
     */
    public String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 向页面输出JSON对象
     * @param response
     * @param obj
     * @throws IOException
     */
    public void writeJson(HttpServletResponse response, Object obj) throws IOException {
    	response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(obj));
        writer.flush();
        writer.close();
    }


    /**
     * 向页面输出文本
     * @param response
     * @param str
     * @throws IOException
     */
    public void writeString(HttpServletResponse response, String str) throws IOException {
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(str);
        writer.flush();
        writer.close();
    }
    
    /**
     * 获取session中Key为S的值
     * @param request
     * @return string
     */
    public String getCurrenUser(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("userName");
	}
    
    /**
     * 获取session中值
     * @param request 
     * @param objName session中所存值的key
     * @return
     */
    public Object getSessionObj(HttpServletRequest request, String objName) {
		return request.getSession().getAttribute(objName);
	}
    
    
    /**
     * 将对象存入Session
     * @param request
     * @param objName 存入对象的key
     * @param obj   存入的对象
     */
    public void setObj2Session(HttpServletRequest request, String objName, Object obj) {
		 request.getSession().setAttribute(objName,obj);
	}
    
    /**
	 * Shiro md5 加密   （支持）
	 * @param pwd 用户密码
	 * @return 加密后密码
	 */
	public String shiroEncrypt(String userName,String pwd) {
		try {
			if (StringUtils.isNotBlank(userName)&& StringUtils.isNotBlank(pwd)) {
				SimpleHash hash = new SimpleHash("md5",pwd,SALT,2);
				if (!hash.isEmpty()) {
					return hash.toString();
				}
				return null;
			}
		} catch (Exception e) {
			LOG.error("ERROR:"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

    /**
     * 设置分页初始参数
     * @param request
     */
	public void initPagination(HttpServletRequest request,Integer pageSize){
        //获取跳转页面
        String goPage = request.getParameter("goPage");
        //获取操作状态  1.首页 2.上一页 3.自定义页 4.下一页 5.尾页
        String pageState = request.getParameter("pageState");

        if(null!=request){
            if (StringUtils.isNotBlank(goPage)&& !"undefined".equals(goPage)) {
                 getPagination().setGoPage(Integer.valueOf(goPage));
            }else{
                  getPagination().setPageNow(0);
            }

            if (StringUtils.isNotBlank(pageState)&&!"undefined".equals(pageState)) {
                getPagination().setState(Integer.valueOf(pageState));
            }else{
                 getPagination().setState(0);
            }
        }

        if (pageSize > 0){
            getPagination().setPageSize(pageSize);
        }
    }

}
