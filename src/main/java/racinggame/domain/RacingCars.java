package racinggame.domain;

import java.util.ArrayList;
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

    public RacingStatus report(int position) {
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

    public int getCarsSize() {
        return cars.size();
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

    public RacingWinners reports() {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addWinner(i, winnerNames);
        }
        return new RacingWinners(winnerNames);
    }

    private void addWinner(int targetCarIndex, List<String> winnerNames) {
        if (report(targetCarIndex).isWinner()) {
            winnerNames.add(cars.get(targetCarIndex).getName());
        }
    }

    public RacingReports interimReports() {
        return new RacingReports(cars);
    }
}
