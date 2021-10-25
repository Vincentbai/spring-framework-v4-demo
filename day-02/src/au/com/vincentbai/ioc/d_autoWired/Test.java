package au.com.vincentbai.ioc.d_autoWired;

import au.com.vincentbai.ioc.b_life.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("autoWired.xml");

        Emp emp = ac.getBean("emp", Emp.class);

        System.out.println(emp);

    }
}
