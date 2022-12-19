package homeWork_10_12.mad_scientists;

import java.util.*;

import static homeWork_10_12.mad_scientists.Dump.*;

public class Assistant {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 4;
    private int loadCapacity = RANDOM.nextInt(MAX_VALUE) + MIN_VALUE;
    private List<RobotParts> takenParts;
    private String name;

    public Assistant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<RobotParts> getTakenParts() {
        return takenParts;
    }

    //ассистент собирает от 1 до 4 частей робота
    public synchronized void takeParts() {
        int randomPartInd;
        takenParts = new ArrayList<>();
        try {
            if (!Dump.getProducedPartsList().isEmpty()) {
                for (int i = 0; i < loadCapacity; i++) {
                    randomPartInd = getRandomRobotPartIndex();
                    takenParts.add(getProducedPartsList().get(randomPartInd));
                    getProducedPartsList().remove(randomPartInd);
                    setProducedPartsAmount(getProducedPartsAmount() - MIN_VALUE);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(getName() + ": There was no parts to collect, master");
        }
    }
}


