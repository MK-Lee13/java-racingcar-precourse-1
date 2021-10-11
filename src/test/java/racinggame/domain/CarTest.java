package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.RacingCarValidation;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Minky on 2021-10-12
 */
public class CarTest {
    public static final String CAR_NAME = "Minky";
    private Car car;

    @BeforeEach
    void beforeEach() {
        this.car = new Car(CAR_NAME);
    }

    @DisplayName(value = "자동자_전진")
    @Test
    void 자동자_전진() {
        car.setProgress(4);
        assertThat(car.getProgress()).isEqualTo(1);
    }

    @DisplayName(value = "자동자_정지")
    @Test
    void 자동자_정지() {
        car.setProgress(3);
        assertThat(car.getProgress()).isEqualTo(0);
    }
}
