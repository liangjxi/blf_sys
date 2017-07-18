/**
 * 
 */
package com.blf.common.interceptor;

import com.blf.common.annotation.Token;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;


/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common
 * DateTime: 2016年6月6日 下午8:46:36
 * Description:token拦截器 防止重复提交
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
	//日志对象
	protected final Log LOG = LogFactory.getLog(getClass());
	
	/**
	 * 预处理回调方法，实现controller的预处理（如登陆检查），
	 * app处理请求,对已登录用户重新赋予登录状态
	 * 
	 * 
	 * return  true 表示继续流程/false 表示流程中断 
	 */
	@Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//来源,app session处理
		String from = request.getParameter("from");
		//app登录token
		String token = request.getParameter("token");

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();  
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null) {  
                boolean needSaveSession = annotation.save();  
                if (needSaveSession) {  
                    request.getSession().setAttribute("token", UUID.randomUUID().toString());  
                    LOG.info("生成Token为："+request.getSession().getAttribute("token"));
                }  
                boolean needRemoveSession = annotation.remove();  
                if (needRemoveSession) {  
                    if (isRepeatSubmit(request)) { 
                    	 response.setCharacterEncoding("utf-8");         
    				     response.setContentType("text/html; charset=utf-8"); 
                    	 PrintWriter out = response.getWriter();  
                         out.print("不能重复提交，请返回继续操作"); 
                         return false;
                    }  
                    request.getSession(false).removeAttribute("token");  
                }  
            }  
            return true;  
        } else {  
            return super.preHandle(request, response, handler);  
        }  
    }

    /**
     * 判断是否是重复提交
     * @param request
     * @return
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");  
        if (serverToken == null) {  
            return true;  
        }  
        String clinetToken = request.getParameter("token");  
        if (clinetToken == null) {  
            return true;  
        }  
        if (!serverToken.equals(clinetToken)) {  
            return true;  
        }  
        return false;  
    }  
	
}
