package racinggame.domain;

/**
 * Created by Minky on 2021-10-12
 */
public class Car {
    private String name;
    private int progress = 0;

    public Car(String name) {
        this.name = name;
    }

    public void setProgress(int randomValue) {
        if (isKeepGoing(randomValue)) {
            progress += 1;
        }
    }

    private boolean isKeepGoing(int randomValue) {
        return randomValue > 3;
    }

    public String getName() {
        return this.name;
    }

    public int getProgress() {
        return this.progress;
    }
}
