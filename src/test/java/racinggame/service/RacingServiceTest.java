package racinggame.service;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racinggame.domain.ErrorStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void beforeEach() {
        this.racingService = new RacingService();
    }

    @DisplayName(value = "자동차_게임_진행_횟수_입력_검증")
    @Test
    void 자동차_게임_진행_횟수_입력_검증() {
        assertThat(racingService.validateInputGameNumber("1").isCorrect()).isTrue();
        assertThat(racingService.validateInputGameNumber("100").isCorrect()).isTrue();
        assertThat(racingService.validateInputGameNumber("0").isNotPositiveNumber()).isTrue();
        assertThat(racingService.validateInputGameNumber("a").isNotPositiveNumber()).isTrue();
    }

    @DisplayName(value = "자동차_이름_입력_중복_검증")
    @Test
    void 자동차_이름_입력_중복_검증() {
        assertThat(racingService.validateDuplicateCarNames(Arrays.asList("minky", "teddy", "conn")).isCorrect()).isTrue();
        assertThat(racingService.validateDuplicateCarNames(Arrays.asList("minky", "minky", "conn")).isDuplicate()).isTrue();
    }

    @DisplayName(value = "자동차_이름_입력_검증")
    @Test
    void 자동차_이름_입력_검증() {
        assertThat(racingService.validateInputCarNames(Arrays.asList("minky", "teddy", "conn")).isCorrect()).isTrue();
        assertThat(racingService.validateInputCarNames(Arrays.asList("minky", "", "conn")).isNullOrEmptyString()).isTrue();
        assertThat(racingService.validateInputCarNames(Arrays.asList("minky123", "teddy", "conn")).isMoreThanFive()).isTrue();
    }

    @DisplayName(value = "전진_조건_랜덤_값_생성")
    @Test
    void 전진_조건_랜덤_값_생성() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3);
            assertThat(racingService.getRandomValue()).isEqualTo(3);
        }
    }
}
