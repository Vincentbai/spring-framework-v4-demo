package au.com.vincentbai.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect // 标注当前类为切面
@Order(0) // order 值越小优先级越高，默认值为int的最大值
public class MyLoggerAspect {

    // 定义一个公共的切入点
    @Pointcut(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))")
    public void myPointCut(){}

//    @Before(value = "execution(public int au.com.vincentbai.spring.aop.CalculatorImpl.add(int, int))")
//    @Before(value ="execution(public int au.com.vincentbai.spring.aop.CalculatorImpl.*(int, int))")
//    @Before(value ="execution(* au.com.vincentbai.spring.aop.CalculatorImpl.*(int, int))")
//    @Before(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))")
    @Before(value = "myPointCut()")
    public void beforeAction(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("前置通知 -> Method: " + methodName + " , args:" + Arrays.toString(args) + " 优先级为 0");
    }

    // @After 作用于finally里，有没有异常都会执行
//    @After(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))")
    @After(value = "myPointCut()")
    public void afterAction(JoinPoint joinPoint){
        System.out.println("后置通知 -> 执行在 finally 语句块中");
    }

    // @AfterReturning 返回通知，当代码有异常时不执行返回通知， 相当于执行再方法返回之后
    @AfterReturning(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))", returning = "result")
    public void afterReturningAction(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("返回通知 -> method: " + methodName + ", result: " + result);
    }

    // 只要抛出异常就会被执行
    @AfterThrowing(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))", throwing = "ex")
    public void afterThrowingAction(Exception ex){
        System.out.println("异常通知 -> Exception:" + ex);
    }

    // 有空指针异常的时候才会被执行
    @AfterThrowing(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))", throwing = "ex")
    public void afterThrowingNullPointerExceptionAction(NullPointerException ex){
        System.out.println("空指针异常通知 -> Exception:" + ex);
    }

    // 有空指针异常的时候才会被执行
    @AfterThrowing(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))", throwing = "ex")
    public void afterThrowingArithmeticExceptionAction(ArithmeticException ex){
        System.out.println("数学异常通知 -> Exception:" + ex);
    }

    // 1. 方法执行之前 @Before 2，方法执行之后 @AfterReturning 3. catch @AfterThrowing 4. finally @After
    @Around(value ="execution(* au.com.vincentbai.spring.aop.*.*(..))")
    public Object aroundAction(ProceedingJoinPoint proceedingJoinPoint){

        Object result = null;

        try {
            // 前置通知
            System.out.println("环绕通知 -> 前置通知");
            result = proceedingJoinPoint.proceed(); // 执行方法
            // 返回通知
            System.out.println("环绕通知 -> 返回通知");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
            System.out.println("环绕通知 -> 异常通知");
        } finally {
            // 后置通知
            System.out.println("环绕通知 -> 后置通知");
        }

        return -1;
    }
}
