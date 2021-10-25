package au.com.vincentbai.spring.a_mod;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBySpring {
    public static void main(String[] args) {

        // 1. 初始化容容器, 在web项目中，该初始化过程是自动的
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 5. ConfigurableApplicationContext 是 ApplicationContext 的子类，有更丰富的方法，比如 close 方法
        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 获取bean 对象, 通过唯一属性id 来获取 bean
//        Person person = (Person) ac.getBean("person");

        // 3. 通过类型获取 bean
//        Person person1 = ac.getBean(Person.class);

        // 4. 推荐使用该方法来获取对象z
        Person person2 = ac.getBean("person2", Person.class);

        System.out.println(person2);

    }
}
