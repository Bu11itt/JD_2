package homeWork_10_12.mad_scientists;

import static homeWork_10_12.mad_scientists.Dump.TIME;

public class Factory implements Runnable{
    private Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < TIME; i++) {
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dump.producedPartsFromFactory();
        }

    }
}
