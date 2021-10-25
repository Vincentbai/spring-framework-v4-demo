package au.com.vincentbai.spring.bookStore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("book-store.xml");

        BookStoreController bookStoreController = ac.getBean("bookStoreController", BookStoreController.class);

//        bookStoreController.buyBook();

        bookStoreController.checkOut();
    }
}
