package racinggame.utils;

import java.util.regex.Pattern;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingGameValidation {
    private static final Pattern pattern = Pattern.compile("[1-9]+[0-9]*");

    public static boolean isPositiveNumber(String input) {
        return pattern.matcher(input).matches();
    }
}
