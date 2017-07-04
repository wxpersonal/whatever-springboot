package me.weix.whatever.aop;

import me.weix.whatever.config.common.CONST;
import me.weix.whatever.config.dataSource.DataSourceContextHolder;
import me.weix.whatever.config.dataSource.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 切面
 * @author weix
 */



@Order(1)
@Aspect
@Component
public class DataSourceAspectj {

	private Logger log = LoggerFactory.getLogger(DataSourceAspectj.class);
	
	//定义通用切点，以便下面4个通知使用
	
	@Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.get*(..)) ||" +
              "execution(* me.weix.whatever.service.impl.*ServiceImpl.query*(..)) ||" +
              "execution(* me.weix.whatever.service.impl.*ServiceImpl.select*(..))")
	public void readPointcut(){}

    @Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.insert*(..)) ||" +
            "execution(* me.weix.whatever.service.impl.*ServiceImpl.update*(..)) ||" +
            "execution(* me.weix.whatever.service.impl.*ServiceImpl.delete*(..))")
    public void writePointcut(){}
	
	/*@Before("dataSourceAop()")
	public void logBefore(JoinPoint joinpoint){
	    String methodName = joinpoint.getSignature().getName();
		log.info("前置通知Before-->{}");
	}
	
	@AfterReturning("dataSourceAop()")
	public void logAfterReturning(){
		log.info("返回通知AfterReturning-->{}");
	}
	
	
	@After("dataSourceAop()")
	public void logAfter(){
		log.info("后置通知After-->{}");
	}
	
	@AfterThrowing("dataSourceAop()")
	public void logAfterThrow(){
		log.info("异常通知AfterThrowing-->{}");
	}*/
	
	@Around("readPointcut()")
	public void setReadDataSource(ProceedingJoinPoint jp){
		try {
		    String dataSourceKey = DataSourceType.master.getName();
            DataSourceContextHolder.setDataSource(dataSourceKey);
			log.debug("切换数据源------------>" + dataSourceKey);
			jp.proceed();
            // return 之后清空
            DataSourceContextHolder.clearDataSource();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		log.debug("自定义后置通知After-->{}");
	}

    @Around("writePointcut()")
    public void setWriteDataSource(ProceedingJoinPoint jp){
        try {
            String dataSourceKey = DataSourceType.slave1.getName();
            DataSourceContextHolder.setDataSource(dataSourceKey);
            log.debug("切换数据源------------>" + dataSourceKey);
            jp.proceed();
//            log.debug("自定义返回通知AfterReturning-->{}");
        } catch (Throwable throwable) {
//            log.debug("异常处理-->{}");
            throwable.printStackTrace();
        }
//        log.debug("自定义后置通知After-->{}");
    }
	
	
}
