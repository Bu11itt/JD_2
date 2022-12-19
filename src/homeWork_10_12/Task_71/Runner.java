package homeWork_10_12.Task_71;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello hello = new Hello();
        Method method = hello.getClass().getMethod("printHelloWorld");
        method.invoke(hello);
    }
}
