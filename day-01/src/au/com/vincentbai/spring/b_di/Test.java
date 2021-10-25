package au.com.vincentbai.spring.b_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

// 测试依赖注入
public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-di.xml");

        // 6. 通过普通的依赖注入来赋值
        Student s1 = ac.getBean("s1", Student.class);

        // 7. 通过第一个构造方法来赋值
        Student s2 = ac.getBean("s2", Student.class);

        // 8. 通过另一个构造方法来赋值
        Student s3 = ac.getBean("s3", Student.class);

        // 9. 通过 p 命名空间来赋值
        Student s4 = ac.getBean("s4", Student.class);

        // 10. 字面量和 ref, 一有 ref 就会涉及到级联
        Student s5 = ac.getBean("s5", Student.class);
        
        // 11. 内部 bean
        Student s6 = ac.getBean("s6", Student.class);

        // 12. 报错找不到 tt （no bean named 'tt' is defined）
        // Student s7 = ac.getBean("s7", Student.class);

        // 13. 集合类
        Teacher t1 = ac.getBean("t1", Teacher.class);

        Teacher t2 = ac.getBean("t2", Teacher.class);

        Teacher t3 = ac.getBean("t3", Teacher.class);

        // 14. 直接创建结合类
        ArrayList studentList = ac.getBean("studentList", ArrayList.class);

        HashMap mapBean = ac.getBean("mapBean", HashMap.class);


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        //System.out.println(s7);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(studentList);
        System.out.println(mapBean);

    }
}
