package racinggame.utils;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingCarValidation {
    public static final int CAR_NAME_MAX_LENGTH = 5;

    public static boolean isLessEqualFive(String input) {
        if (input.length() > CAR_NAME_MAX_LENGTH) {
            return false;
        }
        return true;
    }
}
