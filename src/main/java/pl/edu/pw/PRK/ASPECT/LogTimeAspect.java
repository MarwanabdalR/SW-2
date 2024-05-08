package pl.edu.pw.PRK.ASPECT;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Order(1)

@Component
public class LogTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(LogTimeAspect.class);

    @Around(value = "execution (* pl.edu.pw.PRK.service..*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("KPI: ");
        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
                .append("\tWithArgs: ").append("(").append(StringUtils.arrayToCommaDelimitedString(joinPoint.getArgs())).append(")");
        sb.append("\ttook: ");

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;
        log.info(sb.append(executionTime).append(" ms. ").toString());

        return result;
    }


 
}
