package au.com.vincentbai.ioc.f_proxy;

public class MyLogger {
    public static void before(String methodName, String args){
        System.out.println("Method:" + methodName + ", arguments: " + args);
    }

    public static void after(String methodName, String result){
        System.out.println("Method:" + methodName + ", result: " + result);
    }

    public static void throwing(){
        System.out.println("Catched an exception!");
    }
}
