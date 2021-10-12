package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.domain.ErrorStatus;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingReports;
import racinggame.domain.RacingWinners;

import java.util.List;

import static racinggame.utils.RacingCarValidation.*;
import static racinggame.utils.RacingGameValidation.isPositiveNumber;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingService {
    public static final int START_PICK_NUMBER = 0;
    public static final int END_PICK_NUMBER = 9;
    private RacingCars racingCars;

    public RacingService() { }

    public int getRandomValue() {
        return Randoms.pickNumberInRange(START_PICK_NUMBER, END_PICK_NUMBER);
    }

    public void initRacingCars(List<String> names) {
        this.racingCars = new RacingCars(names);
    }

    public void startRace() {
        for (int i = 0; i < racingCars.getCarsSize(); i++) {
            racingCars.setProgressWithPosition(i, getRandomValue());
        }
    }

    public RacingWinners getRacingWinners() {
        return racingCars.reports();
    }

    public RacingReports getRacingReports() {
        return racingCars.interimReports();
    }

    public ErrorStatus validateInputCarNames(List<String> names) {
        ErrorStatus errorStatus = ErrorStatus.CORRECT;
        for (int i = 0; i < names.size() && errorStatus.isCorrect(); i++) {
            errorStatus = validateInputCarName(names.get(i));
        }
        return errorStatus;
    }

    public ErrorStatus validateDuplicateCarNames(List<String> names) {
        if (isNotDuplicate(names)) {
            return ErrorStatus.CORRECT;
        }
        return ErrorStatus.IS_DUPLICATE;
    }

    private ErrorStatus validateInputCarName(String name) {
        if (!isNotNullOrEmptyString(name)) {
            return ErrorStatus.IS_NULL_OR_EMPTY_STRING;
        }
        if (!isLessEqualFive(name)) {
            return ErrorStatus.IS_MORE_THAN_FIVE;
        }
        return ErrorStatus.CORRECT;
    }

    public ErrorStatus validateInputGameNumber(String gameNumber) {
        if (isPositiveNumber(gameNumber)) {
            return ErrorStatus.CORRECT;
        }
        return ErrorStatus.IS_NOT_POSITIVE_NUMBER;
    }
}