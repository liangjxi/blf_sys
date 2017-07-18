package com.blf.common.controller;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.common.controller
 * DateTime: 2017/5/15  16:53
 * Description:手动添加
 */
@Controller
@RequestMapping("")
public class LoginController extends BaseController{

    @RequestMapping("login")
    public String login(String loginName,String pwd){
        try{
//            if (StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(pwd)){
//                pwd = shiroEncrypt(loginName,pwd);
//                UsernamePasswordToken token = new UsernamePasswordToken(loginName,pwd);
//                Subject currenUser = SecurityUtils.getSubject();
//                currenUser.login(token);
//            }
        }catch(UnknownAccountException uae){
            LOG.error("Login info:验证未通过,账户不存在");
//            session.setAttribute("msg", "用户名或密码不正确");
            return "redirect:/login.jsp";
        }catch(IncorrectCredentialsException ice){
            LOG.error("Login info:验证未通过,错误的凭证");
//            session.setAttribute("msg", "密码不正确");
            return "redirect:/login.jsp";
        }catch(LockedAccountException lae){
            LOG.error("Login info:验证未通过,账户已锁定");
//            session.setAttribute("msg", "用户已锁定");
            return "redirect:/login.jsp";
        }catch(ExcessiveAttemptsException eae){
            LOG.error("Login info:验证未通过,错误次数过多");
//            session.setAttribute("msg", "用户名或密码错误次数过多");
            return "redirect:/login.jsp";
        }catch(AuthenticationException ae){
            LOG.error("Login info:验证未通过,堆栈轨迹如下");
            LOG.error("ERROR:"+ae);
//            session.setAttribute("msg", "用户名或密码不正确");
            return "redirect:/login.jsp";
        }catch (Exception e) {
            LOG.error("Login info:验证未通过,堆栈轨迹如下");
            LOG.error("ERROR:"+e);
            e.printStackTrace();
//            session.setAttribute("msg", "授权错误，请联系管理员");
            return "redirect:/login.jsp";
        }
        return "/index";
    }

}
