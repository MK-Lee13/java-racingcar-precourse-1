package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.domain.ErrorStatus;

import java.util.List;

import static racinggame.utils.RacingCarValidation.*;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingService {
    public static final int START_PICK_NUMBER = 0;
    public static final int END_PICK_NUMBER = 9;

    public int getRandomValue() {
        return Randoms.pickNumberInRange(START_PICK_NUMBER, END_PICK_NUMBER);
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
}