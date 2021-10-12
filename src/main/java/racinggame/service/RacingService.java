package racinggame.service;

import nextstep.utils.Randoms;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingService {
    public static final int START_PICK_NUMBER = 0;
    public static final int END_PICK_NUMBER = 9;

    public int getRandomValue() {
        return Randoms.pickNumberInRange(START_PICK_NUMBER, END_PICK_NUMBER);
    }
}
