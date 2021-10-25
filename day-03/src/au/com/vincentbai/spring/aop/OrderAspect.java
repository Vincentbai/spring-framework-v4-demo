package au.com.vincentbai.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class OrderAspect {

    @Before(value = "execution(* au.com.vincentbai.spring.aop.*.*(..))")
    public void beforeAction(){

        System.out.println("前置通知 -> 优先级为 1");

    }

}
