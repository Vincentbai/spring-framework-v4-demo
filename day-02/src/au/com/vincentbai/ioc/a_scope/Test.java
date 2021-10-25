package au.com.vincentbai.ioc.a_scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");

        Student student1 = ac.getBean("student", Student.class);
        Student student2 = ac.getBean("student", Student.class);

        System.out.println(student1);
        System.out.println(student2);

    }
}
