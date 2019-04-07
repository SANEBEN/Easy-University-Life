package com.eul.eulproject.configuration;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class shiroConfiguation {

    private Logger logger = LoggerFactory.getLogger(shiroConfiguation.class);

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */


    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }

    @Bean("SecurityManager")
    public SecurityManager securityManager(@Qualifier("MyShiroRealm") MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRememberMeManager(cookieRememberMeManager()); //注入rememberMeManager
        securityManager.setRealm(myShiroRealm);
        return securityManager;
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     */
    @Bean("MyShiroRealm")
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm realm = new MyShiroRealm();
        realm.setAuthorizationCachingEnabled(false);
        return realm;
    }

    //cookie对象;
    @Bean("rememberMeCookie")
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间15天 ,单位秒;-->
        simpleCookie.setMaxAge(60 * 60 * 24 * 15);
        return simpleCookie;
    }

    //cookie管理对象;
    @Bean("cookieRememberMeManager")
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager manager = new CookieRememberMeManager();
        manager.setCookie(rememberMeCookie());
        return manager;
    }

    @Bean("HashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        logger.info("修改了shiro的验证模式");
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

}
