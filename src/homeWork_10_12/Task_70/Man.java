package homeWork_10_12.Task_70;

import java.util.Arrays;

public class Man {
    private String name;
    private int age;
    private int IQ;

    public Man(String name, int age, int IQ) {
        this.name = name;
        this.age = age;
        this.IQ = IQ;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getIQ() {
        return IQ;
    }

    public static void getInfo(Object o) {
        Class<?> clazz = o.getClass();
        System.out.println("Class name: " + clazz);
        System.out.println("Class declared fields: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Class Parent: " + clazz.getSuperclass());
        System.out.println("Class declared methods: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Class constructors: " + Arrays.toString(clazz.getConstructors()));
    }
}

