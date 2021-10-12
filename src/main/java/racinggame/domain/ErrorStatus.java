package racinggame.domain;

/**
 * Created by Minky on 2021-10-12
 */
public enum ErrorStatus {
    IS_NULL_OR_EMPTY_STRING("[ERROR] 빈 문자열은 사용이 불가합니다."),
    IS_MORE_THAN_FIVE("[ERROR] 차 이름의 길이는 5이하로 지정하세요."),
    CORRECT(""),
    IS_DUPLICATE("[ERROR] 차 이름은 중복될 수 없습니다."),
    IS_NOT_POSITIVE_NUMBER("[ERROR] [1 - 9] 사이의 양수만 입력하세요('01' 같은 형식 제외).");

    private final String value;

    ErrorStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

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

    public boolean isNotPositiveNumber() {
        return this == IS_NOT_POSITIVE_NUMBER;
    }
}
