package homeWork_10_12.Task_72;

import java.lang.reflect.Method;
import java.text.Annotation;

public class Runner {
    public static void main(String[] args) {
        Class<Task72> task72Class = Task72.class;
        Method[] methods = task72Class.getDeclaredMethods();
        for (Method methodName : methods){
            if(methodName.isAnnotationPresent(AcademyInfo.class)){
                AcademyInfo annotation = methodName.getAnnotation(AcademyInfo.class);
                System.out.println("Method " + methodName.getName() + " has the annotation " + annotation);
            } else {
                System.out.println("Method " + methodName.getName() + " has no annotations");
            }

        }
    }
}
