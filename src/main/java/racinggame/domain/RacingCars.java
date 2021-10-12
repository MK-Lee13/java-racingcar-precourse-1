package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingCars {
    public static final int LOWEST_CAR_POSITION = 0;
    private List<Car> cars;

    public RacingCars(List<String> carNames) {
        this.cars = mapCar(carNames);
    }

    private static List<Car> mapCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public RacingStatus isWinner(int position) {
        if (cars.get(position).getProgress() == getWinnerScore()) {
            return RacingStatus.WINNER;
        }
        return RacingStatus.LOSER;
    }

    public void setProgressWithPosition(int position, int randomValue) {
        if (position < cars.size() && position >= LOWEST_CAR_POSITION) {
            cars.get(position).setProgress(randomValue);
        }
    }

    private int getWinnerScore() {
        int winningScore = 0;
        for (Car car : cars) {
            int oneCarProgress = car.getProgress();
            winningScore = getCurrentWinnerScore(oneCarProgress, winningScore);
        }
        return winningScore;
    }

    private int getCurrentWinnerScore(int progress, int winningScore) {
        if (progress > winningScore) {
            return progress;
        }
        return winningScore;
    }
}
