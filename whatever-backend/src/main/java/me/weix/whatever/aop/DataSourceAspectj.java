//
//package me.weix.whatever.aop;
//
//import me.weix.whatever.config.dataSource.DataSourceContextHolder;
//import me.weix.whatever.config.dataSource.DataSourceType;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.reflect.Method;
//
//
///*
// * 切面
// * @author weix
// */
//
//@Order(1)
//@Aspect
//@Component
//public class DataSourceAspectj {
//
//	private Logger log = LoggerFactory.getLogger(DataSourceAspectj.class);
//
//	//定义通用切点
//    @Pointcut("execution(* me.weix.whatever.service.impl.*ServiceImpl.*(..))")
//    public void writePointcut(){}
//
//
//    @Around("writePointcut()")
//    public Object setWriteDataSource(ProceedingJoinPoint jp){
//        try {
//            Signature signature = jp.getSignature();
//			Method method=((MethodSignature)jp.getSignature()).getMethod();
//			Method realMethod = jp.getTarget().getClass().getDeclaredMethod(signature.getName(),
//					method.getParameterTypes());
//			Transactional annotation = realMethod.getAnnotation(Transactional.class);
//			if(annotation != null) {
//				DataSourceContextHolder.setDataSource(DataSourceType.master.getName());
//				log.debug("switch datasource ------------>" + DataSourceType.master.getName());
//			}
//            Object obj = jp.proceed();
//			return obj;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        } finally {
//            DataSourceContextHolder.clearDataSource();
//        }
//        return null;
//    }
//
//
//}
//
