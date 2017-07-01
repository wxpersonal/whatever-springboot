package me.weix.whatever.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author weix
 *
 */

@Order(1)
@Aspect
@Component
public class AspectjLog {
	
	private Logger log = LoggerFactory.getLogger(AspectjLog.class);
	
	//定义通用切点，以便下面4个通知使用
	
	@Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.*(..))")
	public void logAop(){}
	
	@Before("logAop()")
	public void logBefore(){
		log.info("前置通知Before-->{}");
	}
	
	@AfterReturning("logAop()")
	public void logAfterReturning(){
		log.info("返回通知AfterReturning-->{}");
	}
	
	
	@After("logAop()")
	public void logAfter(){
		log.info("后置通知After-->{}");
	}
	
	@AfterThrowing("logAop()")
	public void logAfterThrow(){
		log.info("异常通知AfterThrowing-->{}");
	}
	
	/*@Around("logAop()")
	public void logAround(ProceedingJoinPoint jp){
		try {
			log.debug("自定义前置通知Before-->{}");
			jp.proceed();
			log.debug("自定义返回通知AfterReturning-->{}");
		} catch (Throwable throwable) {
			log.debug("异常处理-->{}");
			throwable.printStackTrace();
		}
		log.debug("自定义后置通知After-->{}");
	}*/
	
	
}
