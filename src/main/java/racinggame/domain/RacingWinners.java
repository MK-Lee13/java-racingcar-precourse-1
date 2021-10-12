package racinggame.domain;

import javax.smartcardio.Card;
import java.util.List;
import java.util.Objects;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingWinners {
    private List<String> names;

    public RacingWinners(List<String> winnerNames) {
        this.names = winnerNames;
    }

    public List<String> getNames() {
        return this.names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingWinners that = (RacingWinners) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
