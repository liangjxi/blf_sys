package com.blf.common.servlet;

import common.util.VerifyCodeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.servlet
 * DateTime: 2016年5月5日 下午5:23:05
 * Description:生成验证码 servlet
 */
public class ValcodeServlet extends HttpServlet {
	//日志对象
	protected final Log LOG = LogFactory.getLog(getClass());
	
	private static final long serialVersionUID = -1343894554248341890L;

	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("image/jpeg");
	       //不缓存
	       response.setHeader("pragma", "no-cache");
	       response.setHeader("cache-control", "no-cache");
	       response.setHeader("expires", "0");
	       //生成四位随机验证码
	       String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 4, null);
	       request.getSession().setAttribute("codeNo", verifyCode);
	       LOG.info("生成随机验证码为：" + verifyCode);
//	       LOG.info("客户端IP：" + getIpAddr(request));
	       //生成图片字节流
	       BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 10, true, Color.WHITE, Color.BLACK, null);
	       //输出图片

	       ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}
	
}
