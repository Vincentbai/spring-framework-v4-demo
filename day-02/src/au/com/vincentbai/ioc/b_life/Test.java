package au.com.vincentbai.ioc.b_life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        ac.close();

    }
}
