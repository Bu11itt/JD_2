package homeWork_10_12.mad_scientists;
        /*Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей.
        Для этого каждую ночь каждый из них отправляет своего прислужника на свалку фабрики роботов за деталями.
        Чтобы собрать одного робота им нужно:
        Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
        В первую ночь на свалке находится 20 случайных деталей. Каждую ночь фабрика выбрасывает на свалку от 1 до 4
        случайных деталей.
        В то же самое время прислужники обоих учёных отправляются на свалку, и каждый собирает от 1 до 4 случайных деталей.
        Если на свалке деталей нет – прислужник уходит ни с чем.
        Затем они возвращаются домой и отдают детали хозяевам.
        Учёные пытаются собрать как можно больше роботов из деталей, которые они получили.
        Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.

        Фабрика и два прислужника действуют в одно и то же время.
        После 100 ночей (около 10 секунд) определить победителя соревнования.*/

public class Runner {
    public static void main(String[] args) {
        Dump dump = new Dump(20);
        Factory factory = new Factory(dump);
        Assistant assistant1 = new Assistant("T800");
        Assistant assistant2 = new Assistant("R2D2");
        Scientist scientist1 = new Scientist(dump, "Cameron", assistant1);
        Scientist scientist2 = new Scientist(dump, "Lucas", assistant2);

        Thread thread1 = new Thread(scientist1);
        Thread thread2 = new Thread(scientist2);
        Thread thread3 = new Thread(factory);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (scientist1.getAssembledRobotsCount() > scientist2.getAssembledRobotsCount()) {
            System.out.printf("%s is the winner! He assembled %d robots%n", scientist1.getName(), scientist1.getAssembledRobotsCount());
            System.out.printf("%s assembled %d robots, too bad.", scientist2.getName(), scientist2.getAssembledRobotsCount());
        } else if (scientist1.getAssembledRobotsCount() < scientist2.getAssembledRobotsCount()) {
            System.out.printf("%s is the winner! He assembled %d robots%n", scientist2.getName(), scientist2.getAssembledRobotsCount());
            System.out.printf("%s assembled %d robots, too bad.%n", scientist1.getName(), scientist1.getAssembledRobotsCount());
        } else if (scientist1.getAssembledRobotsCount() == scientist2.getAssembledRobotsCount()) {
            System.out.printf("We have a draw. Both scientists assembled %d robots.", scientist1.getAssembledRobotsCount());
        }
    }
}