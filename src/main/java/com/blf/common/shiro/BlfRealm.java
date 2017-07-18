package com.blf.common.shiro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.backstage.shiro
 * DateTime: 2016年5月19日 下午4:26:31
 * Description:自己修改描述
 */
public class BlfRealm extends AuthorizingRealm{
	//日志对象
	protected final Log LOG = LogFactory.getLog(getClass());

//	@Autowired
//	private IUserService userService;
//
//	private User user;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String)super.getAvailablePrincipal(principals);  
//		 SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		
		//角色判断实现
		//hasRole(String roleName)  是否分配了某角色
		//hasRoles(List<String> roleNames) ：返回一个与方法参数中目录一致的hasRole 结果的数组。
		//hasAllRoles(Collection<String> roleNames)：返回true 如果Subject 被分配了所有的角色
		
		//权限判断实现
		//isPermitted(String perm)、isPermitted(String... perms)、isPermittedAll(String... perms)
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
		LOG.info("开始对 ["+userName+"]授权验证");
		return (AuthorizationInfo) authenticationInfo;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		LOG.info("开始对 ["+token.getUsername()+"] 做登录验证");
		try{
//			if(null!=token){
//				user = userService.getByMobileOrWithPasswd(token.getUsername(), String.valueOf(token.getPassword()));
//				if(null!=user && null!=user.getId()){
//					if (user.getState()) {
//						SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getCode(),user.getPasswd(),getName());
//
//						this.setSession("currentUser", user);
//
//						this.setSession("userName", user.getRealName());
//						return authcInfo;
//					}else{
//						return null;
//					}
//				}
//			}
		}catch(Exception e){
			LOG.error("登录认证失败:"+e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     */
	private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
        	//session true说明：如果Session有了，直接用，否则，创建一个   false：则是不创建
            Session session = currentUser.getSession(true);
            //设置session有效时间
            session.setTimeout(5);
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
