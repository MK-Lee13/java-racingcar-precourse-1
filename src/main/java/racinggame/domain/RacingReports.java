package racinggame.domain;

import java.util.List;
import java.util.Objects;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingReports {
    private final List<Car> cars;

    public RacingReports(List<Car> cars) {
        this.cars = cars;
    }

    public String getCarName(int position) {
        return cars.get(position).getName();
    }

    public int getCarProgress(int position) {
        return cars.get(position).getProgress();
    }

    public String getCarProgressString(int position) {
        int targetProgress = cars.get(position).getProgress();
        return getProgressView(targetProgress);
    }

    private String getProgressView(int progress) {
        String progressView = "";
        for (int i = 0; i < progress; i++) {
            progressView += "-";
        }
        return progressView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingReports that = (RacingReports) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
