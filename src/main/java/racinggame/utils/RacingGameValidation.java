package racinggame.utils;

import java.util.regex.Pattern;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingGameValidation {
    public static final String POSITIVE_NUMBER_REGEX = "[1-9]+[0-9]*";
    private static final Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGEX);

    public static boolean isPositiveNumber(String input) {
        return pattern.matcher(input).matches();
    }
}