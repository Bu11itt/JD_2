package homeWork_10_12.Task_72;

import java.time.LocalDate;

public class Task72 {

    @AcademyInfo(year = 2022)
    public void getYear(){
        System.out.println(LocalDate.now().getYear());
    }

    public void getNextYear(){
        System.out.println(LocalDate.now().plusYears(1));
    }
}
