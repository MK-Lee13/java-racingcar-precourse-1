package racinggame.domain;

/**
 * Created by Minky on 2021-10-12
 */
public enum ErrorStatus {
    IS_NULL_OR_EMPTY_STRING, IS_MORE_THAN_FIVE, CORRECT, IS_DUPLICATE;

    public boolean isCorrect() {
        return this == CORRECT;
    }

    public boolean isNullOrEmptyString() {
        return this == IS_NULL_OR_EMPTY_STRING;
    }

    public boolean isMoreThanFive() {
        return this == IS_MORE_THAN_FIVE;
    }

    public boolean isDuplicate() {
        return this == IS_DUPLICATE;
    }
}
