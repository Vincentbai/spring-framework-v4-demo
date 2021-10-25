package au.com.vincentbai.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");

        // ac.getBean("calculatorImpl", CalculatorI.class); 一定要传接口类型进去， proxy才可以生成
        CalculatorI calculator = ac.getBean("calculatorImpl", CalculatorI.class);

        calculator.div(1,1);

    }
}
