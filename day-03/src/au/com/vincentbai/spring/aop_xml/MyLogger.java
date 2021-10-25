package au.com.vincentbai.spring.aop_xml;

import org.springframework.stereotype.Component;

@Component
public class MyLogger {

    public void before(){
        System.out.println("xml前置通知");
    }

}
