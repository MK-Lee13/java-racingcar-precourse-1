package racinggame.domain;

import java.util.Objects;

/**
 * Created by Minky on 2021-10-12
 */
public class Car {
    private final String name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return progress == car.progress &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, progress);
    }
}
