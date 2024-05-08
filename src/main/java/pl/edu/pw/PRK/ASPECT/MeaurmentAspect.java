package pl.edu.pw.PRK.ASPECT;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Order(0)
@Component
public class MeaurmentAspect {


    private static final Logger log = LoggerFactory.getLogger(LogTimeAspect.class);

       @Pointcut(value =" execution (* pl.edu.pw.PRK.service..*(..))")
    public void forServcieLog(){}
    @Pointcut(value =" execution (* pl.edu.pw.PRK.controller..*(..))")
    public void forControllerLog(){}

    @Pointcut(value ="forServcieLog() || forControllerLog()")
    public void forAllApp(){}

    @Before (value = "forAllApp()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        log.info("====> Method Name is >> {}",methodName);
        Object[] args=joinPoint.getArgs();
        for (Object arg : args) {
            log.info("=====> argument >>{}", arg);
            
        }
    }
    
}
