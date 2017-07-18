package com.blf.common.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.filter
 * DateTime: 2016年5月5日 下午7:18:00
 * Description:自己修改描述
 */
public class UserFilter implements Filter {
	//日志对象
	protected final Log LOG = LogFactory.getLog(getClass());
	
	@Override
	public void destroy() {
		LOG.info("过滤器销毁！");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		LOG.info("过滤器执行！");
//		System.out.println("================:"+IQuartzService.COMMON_CONFIG);
		try{
//			IQuartzService quartzService = new QuartzServiceImpl();
//			String cron = CronUtil.getCron(new Date());
//			TestJob job = new TestJob();
//			quartzService.dailyCalQuartzS("TestJob", "test_trigger", "jobGroup", "triggerGroup", job, cron);
		}catch(Exception e){
			e.printStackTrace();
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOG.info("过滤器初始化！");
	}
	
}
