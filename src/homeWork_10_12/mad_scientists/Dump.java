package homeWork_10_12.mad_scientists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dump {
    public static final Random RANDOM = new Random();
    private static final int MIN_ROBOT_PART_AMOUNT = 1;
    private static final int MAX_ROBOT_PART_AMOUNT = 4;
    public static final int TIME = 100;
    private static final RobotParts[] ROBOT_PARTS = RobotParts.values();
    private static volatile int producedPartsAmount;
    private static volatile List<RobotParts> producedParts = new ArrayList<>();

    public Dump(int producedPartsAmount) {
        Dump.producedPartsAmount = producedPartsAmount;
        //устанавливаем первоначальное количество частей на свалке
        for (int i = 0; i < producedPartsAmount; i++) {
            producedParts.add(getRandomRobotPart());
        }
    }

    public static List<RobotParts> getProducedPartsList() {
        return producedParts;
    }

    public static int getProducedPartsAmount() {
        return producedPartsAmount;
    }

    public static void setProducedPartsAmount(int producedPartsAmount) {
        Dump.producedPartsAmount = producedPartsAmount;
    }

    public static RobotParts getRandomRobotPart() {
        return ROBOT_PARTS[RANDOM.nextInt(ROBOT_PARTS.length)];
    }

    public static int getRandomRobotPartAmount() {
        return RANDOM.nextInt(MAX_ROBOT_PART_AMOUNT) + MIN_ROBOT_PART_AMOUNT;
    }

    public static int getRandomRobotPartIndex() {
       return RANDOM.nextInt(getProducedPartsList().size());
    }

    //фабрика производит от 1 до 4 частей робота
    public synchronized void producedPartsFromFactory(){
        for (int i = 0; i < getRandomRobotPartAmount(); i++) {
            getProducedPartsList().add(getRandomRobotPart());
            setProducedPartsAmount(getProducedPartsAmount() + MIN_ROBOT_PART_AMOUNT);
        }
    }

}
