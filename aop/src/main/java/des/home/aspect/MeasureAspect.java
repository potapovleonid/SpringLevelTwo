package des.home.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasureAspect {

    @Pointcut("@annotation(MeasureMethod)")
    private void annotatedMethod(){

    }

    @Around("annotatedMethod()")
    private Object logAround(ProceedingJoinPoint pj) throws Throwable {
        long timeB = System.currentTimeMillis();
        Object value = pj.proceed();
        long timeA = System.currentTimeMillis();
        System.out.println("Log of method" + pj.toLongString() + "\n" +
                "time mills " + (timeB - timeA));
        return value;
    }
}
