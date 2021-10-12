package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void beforeEach() {
        this.racingCars = new RacingCars(Arrays.asList("minky", "teddy", "conn"));
        racingCars.setProgressWithPosition(0, 4);
        racingCars.setProgressWithPosition(1, 5);
        racingCars.setProgressWithPosition(2, 1);
    }

    @DisplayName(value = "자동차_게임_우승자_복수_판별")
    @Test
    void 자동차_게임_우승자_복수_판별() {
        RacingWinners compareAnswer = new RacingWinners(Arrays.asList("minky", "teddy"));
        assertThat(racingCars.reports().equals(compareAnswer)).isTrue();
    }

    @DisplayName(value = "자동자_게임_우승자_판별")
    @Test
    void 자동자_게임_우승자_판별() {
        assertThat(racingCars.report(0)).isEqualTo(RacingStatus.WINNER);
        assertThat(racingCars.report(1)).isEqualTo(RacingStatus.WINNER);
        assertThat(racingCars.report(2)).isEqualTo(RacingStatus.LOSER);
    }
}
