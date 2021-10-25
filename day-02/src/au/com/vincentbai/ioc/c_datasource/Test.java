package au.com.vincentbai.ioc.c_datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("datasource.xml");

        DruidDataSource datasource = ac.getBean("datasource", DruidDataSource.class);

        System.out.println(datasource.getConnection());

    }
}
