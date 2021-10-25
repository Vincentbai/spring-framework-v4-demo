package au.com.vincentbai.spring.c_factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("factory-bean.xml");

        Object object = ac.getBean("factory");

        // 14. object 对象是工厂类创建的对象，而不是工厂自身的对象
        System.out.println(object);


    }
}
