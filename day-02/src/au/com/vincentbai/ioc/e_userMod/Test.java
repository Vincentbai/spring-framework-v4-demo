package au.com.vincentbai.ioc.e_userMod;

import au.com.vincentbai.ioc.e_userMod.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("userMod.xml");

        UserController userController = ac.getBean("userController", UserController.class);

        userController.addUser();

    }
}
