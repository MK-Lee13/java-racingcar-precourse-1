package racinggame.service;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

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
