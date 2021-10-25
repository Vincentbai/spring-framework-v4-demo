package au.com.vincentbai.ioc.f_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {

    private Object calculatorImpl;

    public ProxyUtil(Object calculatorImpl) {
        this.calculatorImpl = calculatorImpl;
    }

    // 自动生成的代理类会继承 Proxy，实现目标类的 接口 CalculatorI
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), calculatorImpl.getClass().getInterfaces(), new InvocationHandler() {

            // invoke 方法就是定义方法该如何执行
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                try {

                    MyLogger.before(method.getName(), Arrays.toString(args));

                    Object result = method.invoke(calculatorImpl, args);

                    MyLogger.after(method.getName(), result.toString());

                    return result;

                } catch (Exception e) {

                    e.printStackTrace();
                    MyLogger.throwing();

                }finally {
                    System.out.println("Finally section");
                }

                return null;
            }
        });
    }
}
