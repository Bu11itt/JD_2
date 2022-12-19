package homeWork_10_12.mad_scientists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static homeWork_10_12.mad_scientists.Dump.TIME;

public class Scientist implements Runnable {
    public static final int MAGIC_ONE = 1;
    private Dump dump;
    private String name;
    private Assistant assistant;
    private HashMap<RobotParts, Integer> scientistRobotPartsCollected = new HashMap<>();
    private int assembledRobotsCount;

    public Scientist(Dump dump, String name, Assistant assistant) {
        this.dump = dump;
        this.name = name;
        this.assistant = assistant;
    }

    public String getName() {
        return name;
    }

    public int getAssembledRobotsCount() {
        return assembledRobotsCount;
    }

    public void setAssembledRobotsCount(int assembledRobotsCount) {
        this.assembledRobotsCount = assembledRobotsCount;
    }

    private void takePartsFromAssistant(List<RobotParts> takenParts) {
        for (RobotParts parts : takenParts) {
            if (!scientistRobotPartsCollected.containsKey(parts)) {
                scientistRobotPartsCollected.put(parts, MAGIC_ONE);
            } else {
                scientistRobotPartsCollected.put(parts, scientistRobotPartsCollected.get(parts) + MAGIC_ONE);
            }
        }
        if (scientistRobotPartsCollected.size() == RobotParts.values().length) {
            assembleRobot(scientistRobotPartsCollected);
        }
    }

    private void assembleRobot(HashMap<RobotParts, Integer> scientistRobotPartsCollected) {
        for (Map.Entry<RobotParts,Integer> parts : scientistRobotPartsCollected.entrySet()) {
            parts.setValue(parts.getValue() - MAGIC_ONE);
        }
        setAssembledRobotsCount(getAssembledRobotsCount() + MAGIC_ONE);
    }

    @Override
    public void run() {
        for (int i = 0; i < TIME; i++) {
            assistant.takeParts();
            takePartsFromAssistant(assistant.getTakenParts());
            assistant.getTakenParts().clear();
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
