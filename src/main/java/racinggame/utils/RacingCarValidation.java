package racinggame.utils;

import java.util.HashSet;
import java.util.List;

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

    public static boolean isNotNullOrEmptyString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isNotDuplicate(List<String> names) {
        HashSet<String> notDuplicateNames = new HashSet<>(names);
        if (notDuplicateNames.size() == names.size()) {
            return true;
        }
        return false;
    }
}
