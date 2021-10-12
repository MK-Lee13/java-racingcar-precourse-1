package racinggame.domain;

import java.util.List;
import java.util.Objects;

import static racinggame.view.ReportMessage.INTERIM_MESSAGE;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingReports {
    public static final String PROGRESS_VIEW = "-";
    private final List<Car> cars;

    public RacingReports(List<Car> cars) {
        this.cars = cars;
    }

    public int length() {
        return cars.size();

    }

    public String getMessage(int position) {
        return String.format(INTERIM_MESSAGE, getCarName(position), getCarProgressString(position));
    }

    private String getCarName(int position) {
        return cars.get(position)
                .getName();
    }

    private int getCarProgress(int position) {
        return cars.get(position)
                .getProgress();
    }

    private String getCarProgressString(int position) {
        int targetProgress = getCarProgress(position);
        return getProgressView(targetProgress);
    }

    private String getProgressView(int progress) {
        String progressView = "";
        for (int i = 0; i < progress; i++) {
            progressView += PROGRESS_VIEW;
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
