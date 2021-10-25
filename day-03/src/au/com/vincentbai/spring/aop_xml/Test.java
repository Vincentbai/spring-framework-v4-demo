package au.com.vincentbai.spring.aop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");

        CalculatorI calculator = ac.getBean("calculatorImpl", CalculatorI.class);

        calculator.add(1,1);
    }
}
