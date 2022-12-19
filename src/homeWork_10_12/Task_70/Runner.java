package homeWork_10_12.Task_70;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

        /*Задание 70
        Создать класс Man c произвольным набором полей и методов (не менее 3) Создать метод,
        который распечатает информацию о классе с помощью рефлексии.
        Вызвать метод с помощью рефлексии из основной программы.*/
public class Runner {

    public static void main(String[] args) {
        Man man = new Man("Grisha", 21, 111);
        try {
            Method method = man.getClass().getMethod("getInfo");
            method.invoke(man);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
