package re.edu.hackathon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDateTime;

@Aspect
public class LoggingAspect {
    @Before("execution(* re.edu.hackathon.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        joinPoint.getSignature().getName();
        LocalDateTime.now();
        System.out.println("Method " + joinPoint.getSignature().getName() + " Thời gian:  " + LocalDateTime.now());
    }
}
