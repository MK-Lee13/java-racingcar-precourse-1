package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingCarValidationTest {

    @DisplayName(value = "자동자_이름_중복_검증")
    @Test
    void 자동자_이름_중복_검증() {
        assertThat(RacingCarValidation.isNotDuplicate(Arrays.asList("minky", "teddy", "conn"))).isTrue();
        assertThat(RacingCarValidation.isNotDuplicate(Arrays.asList("minky", "minky", "teddy"))).isFalse();
        assertThat(RacingCarValidation.isNotDuplicate(Arrays.asList("minky", "teddy", "minky"))).isFalse();
    }

    @DisplayName(value = "자동자_이름_Null_빈_스트링_검증")
    @Test
    void 자동자_이름_Null_빈_스트링_검증() {
        assertThat(RacingCarValidation.isNotNullOrEmptyString("minky")).isTrue();
        assertThat(RacingCarValidation.isNotNullOrEmptyString(null)).isFalse();
        assertThat(RacingCarValidation.isNotNullOrEmptyString("")).isFalse();
    }

    @DisplayName(value = "자동자_이름_길이_5_이하_검증")
    @Test
    void 자동자_이름_길이_5_이하_검증() {
        assertThat(RacingCarValidation.isLessEqualFive("mink")).isTrue();
        assertThat(RacingCarValidation.isLessEqualFive("minky")).isTrue();
        assertThat(RacingCarValidation.isLessEqualFive("minkyu")).isFalse();
        assertThat(RacingCarValidation.isLessEqualFive("minkyue")).isFalse();
    }
}
