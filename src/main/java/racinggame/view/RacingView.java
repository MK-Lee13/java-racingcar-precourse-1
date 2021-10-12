package racinggame.view;

import racinggame.domain.ErrorStatus;

import static racinggame.view.InputMessage.CAR_NAMES_MESSAGE;
import static racinggame.view.InputMessage.NUMERIC_MESSAGE;
import static racinggame.view.ReportMessage.START_MESSAGE;

/**
 * Created by Minky on 2021-10-13
 */
public class RacingView {
    public RacingView() { }

    public void displayNumericInputMessage() {
        System.out.println(NUMERIC_MESSAGE);
    }

    public void displayCarNamesInputMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
    }

    public void displayStartReportMessage() {
        System.out.println(START_MESSAGE);
    }

    public void displayReportMessage(String message) {
        System.out.println(message);
    }

    public void displayEmptyMessage() {
        System.out.println();
    }

    public void displayErrorMessage(ErrorStatus errorStatus) {
        System.out.println(errorStatus.getValue());
    }
}
