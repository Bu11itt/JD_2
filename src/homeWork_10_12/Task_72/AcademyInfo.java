package homeWork_10_12.Task_72;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AcademyInfo {
    int year();
}
