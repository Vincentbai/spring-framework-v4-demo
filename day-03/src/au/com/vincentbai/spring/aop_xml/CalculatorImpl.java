package au.com.vincentbai.spring.aop_xml;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements CalculatorI {
    @Override
    public int add(int i, int j) {
        System.out.println("业务函数执行中。。。");
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("业务函数执行中。。。");
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("业务函数执行中。。。");
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("业务函数执行中。。。");
        int result = i / j;
        return result;
    }
}
