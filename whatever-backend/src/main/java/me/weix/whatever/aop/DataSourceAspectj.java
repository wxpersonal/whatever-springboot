package me.weix.whatever.aop;


import me.weix.whatever.config.dataSource.DataSourceContextHolder;
import me.weix.whatever.config.dataSource.DataSourceType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 数据源  切面
 * @author weix
 */

@Order(1)
@Aspect
@Component
public class DataSourceAspectj {

    private Logger log = LoggerFactory.getLogger(DataSourceAspectj.class);

    // 定义通用切点
    @Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.*(..))")
    public void dataSourcePointcut() {
    }


    /**
     * 数据源切换
     *
     * @param jp
     * @return
     */
    @Around("dataSourcePointcut()")
    public Object routeDataSource(ProceedingJoinPoint jp) {
        try {
            String dataSourceKey;
            String methodName = jp.getSignature().getName();
            if (methodName.startsWith("del") || methodName.startsWith("update") ||
                    methodName.startsWith("mod") || methodName.startsWith("insert")) {
                dataSourceKey = DataSourceType.master.getName();
            } else {
                dataSourceKey = DataSourceType.slave1.getName();
            }
            log.debug("==========》aop switch datasource: " + dataSourceKey);
            DataSourceContextHolder.setDataSource(dataSourceKey);
            Object obj = jp.proceed();
            DataSourceContextHolder.clearDataSource();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
