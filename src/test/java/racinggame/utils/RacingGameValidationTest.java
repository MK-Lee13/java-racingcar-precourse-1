package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingGameValidationTest {
    @DisplayName(value = "자동차_게임_진행_횟수_양수_검증")
    @Test
    void 자동차_게임_진행_횟수_양수_검증() {
        assertThat(RacingGameValidation.isPositiveNumber("40")).isTrue();
        assertThat(RacingGameValidation.isPositiveNumber("1")).isTrue();
        assertThat(RacingGameValidation.isPositiveNumber("0")).isFalse();
        assertThat(RacingGameValidation.isPositiveNumber("-1")).isFalse();
        assertThat(RacingGameValidation.isPositiveNumber("Minky")).isFalse();
    }
}
