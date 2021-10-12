package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingCars {
    private List<Car> cars;
    private int winnerScore = 0;

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
        if (cars.get(position).getProgress() == winnerScore) {
            return RacingStatus.WINNER;
        }
        return RacingStatus.LOSER;
    }

    public void setProgressWithPosition(int position, int randomValue) {
        if (position < cars.size() && position >= 0) {
            cars.get(position).setProgress(randomValue);
        }
    }

    public void setWinnerScore() {
        int winningScore = 0;
        for (Car car : cars) {
            int oneCarProgress = car.getProgress();
            winningScore = getCurrentWinnerScore(oneCarProgress, winningScore);
        }
        winnerScore = winningScore;
    }

    private int getCurrentWinnerScore(int progress, int winningScore) {
        if (progress > winningScore) {
            return progress;
        }
        return winningScore;
    }
}
