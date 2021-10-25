package au.com.vincentbai.ioc.f_proxy;

public class Test {
    public static void main(String[] args) {

        ProxyUtil proxyUtil = new ProxyUtil(new CalculatorImpl());

        CalculatorI proxy = (CalculatorI) proxyUtil.getProxy();

        int result = proxy.add(2,1);

        System.out.println(result);

    }
}
