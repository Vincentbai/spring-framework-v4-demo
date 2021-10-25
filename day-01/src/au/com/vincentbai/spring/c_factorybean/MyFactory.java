package au.com.vincentbai.spring.c_factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setMake("BMW");
        car.setPrice(20000.0);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        // 获得 class 的三种方法：Class.forName 类名.class 对象.getClass()
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
