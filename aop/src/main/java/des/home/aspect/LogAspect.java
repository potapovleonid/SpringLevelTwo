package des.home.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* des.home.service..*.*(..))")
    private void anyMethod(){
    }

    @Before("anyMethod()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("log before anyMethod: " + joinPoint);
    }

    @After("anyMethod()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("log after anyMethod:" + joinPoint);
    }

    @AfterReturning("anyMethod()")
    public void logAfterReturning(JoinPoint joinPoint){
        System.out.println("log after returning anyMethod" + joinPoint);
    }

    @AfterThrowing("anyMethod()")
    public void logAfterThrowing(JoinPoint joinPoint){
        System.out.println("log after throwing anyMethod" + joinPoint);
    }

    @Around("anyMethod()")
    private Object logAround(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("log around after" + System.currentTimeMillis());
        Object value = pj.proceed();
        System.out.println("log around beforer" + System.currentTimeMillis());
        return value;
    }
}
