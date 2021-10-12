package racinggame.domain;

import java.util.List;
import java.util.Objects;

import static racinggame.view.ReportMessage.WINNERS_MESSAGE;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingWinners {
    public static final String WINNER_NAMES_FORMAT = ",%s";
    private final List<String> names;

    public RacingWinners(List<String> winnerNames) {
        this.names = winnerNames;
    }

    public String getMessage() {
        return String.format(WINNERS_MESSAGE, getWinnerNamesString());
    }

    private String getWinnerNamesString() {
        String winnersNames = names.get(0);
        for (int i = 1; i < names.size(); i++) {
            winnersNames += String.format(WINNER_NAMES_FORMAT, names.get(i));
        }
        return winnersNames;
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
