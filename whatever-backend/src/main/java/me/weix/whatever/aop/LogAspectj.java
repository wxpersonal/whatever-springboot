/*
package me.weix.whatever.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

*/
/**
 * 切面
 * @author weix
 *
 *//*


@Order(1)
@Aspect
@Component
public class LogAspectj {
	
	private Logger log = LoggerFactory.getLogger(LogAspectj.class);
	
	//定义通用切点，以便下面4个通知使用
	
	@Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.*(..)) ||" +
              "execution(* me.weix.whatever.base.BaseServiceImpl.*(..))"
             )
	public void logAop(){}
	
	@Before("logAop()")
	public void logBefore(JoinPoint joinpoint){
        String methodName = joinpoint.getSignature().getName();

        log.info("进入方法"+methodName);
	}
	
	*/
/*@AfterReturning("logAop()")
	public void logAfterReturning(){
		log.info("返回通知AfterReturning-->{}");
	}*//*

	
	
	@After("logAop()")
	public void logAfter(JoinPoint joinpoint){
        String methodName = joinpoint.getSignature().getName();
		log.info("方法"+ methodName +"结束");
	}
	
	@AfterThrowing("logAop()")
	public void logAfterThrow(){
		log.info("异常通知AfterThrowing-->{}");
	}
	
	@Around("logAop()")
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
	}
	
	
}
*/
