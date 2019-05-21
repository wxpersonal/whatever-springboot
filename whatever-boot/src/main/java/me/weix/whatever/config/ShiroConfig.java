package me.weix.whatever.config;

import me.weix.whatever.config.shiro.authc.CustomerDefaultModularRealm;
import me.weix.whatever.config.shiro.filter.CustomFormAuthenticationFilter;
import me.weix.whatever.config.shiro.realm.EmailRealm;
import me.weix.whatever.config.shiro.realm.MobileRealm;
import me.weix.whatever.config.shiro.realm.AccountRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * @Author: WeiX
 * @Date: 2017-10-23
 * @description :
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/user/login");
        bean.setSuccessUrl("/");
        Map<String, Filter> filters = bean.getFilters();
        filters.put("authc", customFormAuthenticationFilter());

        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //表示可以匿名访问
        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/api/swagger.json", "anon");
//        filterChainDefinitionMap.put("/user/logout", "logout");
        filterChainDefinitionMap.put("/user/login", "authc");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return bean;
    }

    /**
     * 配置自定义的权限登录器
     */
    @Bean(name = "customFormAuthenticationFilter")
    public CustomFormAuthenticationFilter customFormAuthenticationFilter() {
        CustomFormAuthenticationFilter filter = new CustomFormAuthenticationFilter();
        filter.setLoginUrl("/user/login");

        return filter;
    }

    /**
     * 配置自定义的权限登录器
     */
    @Bean(name = "accountRealm")
    public AccountRealm usernameRealm() {
        AccountRealm authRealm = new AccountRealm();
        return authRealm;
    }

    @Bean(name = "emailRealm")
    public EmailRealm emailRealm() {
        EmailRealm authRealm = new EmailRealm();
        return authRealm;
    }

    @Bean(name = "mobileRealm")
    public MobileRealm mobileRealm() {
        MobileRealm authRealm = new MobileRealm();
        return authRealm;
    }

    @Bean(name = "defaultModularRealm")
    public CustomerDefaultModularRealm defaultModularRealm(@Qualifier("accountRealm") AccountRealm accountRealm,
                                                           @Qualifier("emailRealm") EmailRealm emailRealm,
                                                           @Qualifier("mobileRealm") MobileRealm mobileRealm) {
        CustomerDefaultModularRealm customerDefaultModularRealm = new CustomerDefaultModularRealm();
        Map<String, Object> definedRealms = new HashMap<>();
        definedRealms.put("usernameRealm", accountRealm);
        definedRealms.put("emailRealm", emailRealm);
        definedRealms.put("mobileRealm", mobileRealm);
        customerDefaultModularRealm.setDefinedRealms(definedRealms);
        return customerDefaultModularRealm;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * @return DefaultAdvisorAutoProxyCreator
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * 配置核心安全事务管理器
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("accountRealm") AccountRealm accountRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);
        return securityManager;
    }

    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return EhCacheManager
     */
    @Bean(name = "ehCacheManager")
    public EhCacheManager ehCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }

    /**
     * authorizationAttributeSourceAdvisor
     * @param  manager
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        manager.setCacheManager(ehCacheManager());
        return advisor;
    }

    /**
     * spring session管理器（多机环境）
     */
    /*@Bean
    @ConditionalOnProperty(prefix = "guns", name = "spring-session-open", havingValue = "true")
    public ServletContainerSessionManager servletContainerSessionManager() {
        return new ServletContainerSessionManager();
    }*/

    /**
     * session管理器
     */
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(@Qualifier("ehCacheManager") EhCacheManager cacheManager) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(cacheManager);
        sessionManager.setSessionValidationInterval(5 * 60 * 1000);
        sessionManager.setGlobalSessionTimeout(10 * 60 * 1000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setName("shiroCookie");
        cookie.setHttpOnly(true);
        sessionManager.setSessionIdCookie(cookie);
        return sessionManager;
    }
}
