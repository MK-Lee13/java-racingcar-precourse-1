package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.ErrorStatus;
import racinggame.domain.RacingReports;
import racinggame.domain.RacingWinners;
import racinggame.service.RacingService;
import racinggame.view.RacingView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Minky on 2021-10-12
 */
public class RacingController {
    public static final String SPLIT_REGEX = ",";
    private RacingService racingService;
    private RacingView racingView;

    public RacingController() {
        this.racingService = new RacingService();
        this.racingView = new RacingView();
    }

    public void startGame() {
        racingView.displayCarNamesInputMessage();
        racingService.initRacingCars(getCarNames());
        racingView.displayNumericInputMessage();
        repeatGame(getGameNumber());
        responseWinnersMessage(racingService.getRacingWinners());
    }

    private void repeatGame(int repeatSize) {
        racingView.displayEmptyMessage();
        racingView.displayStartReportMessage();
        for (int i = 0; i < repeatSize; i++) {
            racingService.startRace();
            responseRacingReport();
        }
    }

    private void responseRacingReport() {
        RacingReports racingReports = racingService.getRacingReports();
        for (int i = 0; i < racingService.length(); i++) {
            responseInterimMessage(racingReports, i);
        }
        racingView.displayEmptyMessage();
    }

    private void responseInterimMessage(RacingReports racingReports, int position) {
        racingView.displayReportMessage(racingReports
                .getMessage(position));
    }

    private void responseWinnersMessage(RacingWinners racingWinners) {
        racingView.displayReportMessage(racingWinners
                .getMessage());
    }

    private void responseErrorMessage(ErrorStatus errorStatus) {
        if (!errorStatus.isCorrect()) {
            racingView.displayErrorMessage(errorStatus);
        }
    }

    private List<String> getCarNames() {
        ErrorStatus errorStatus = ErrorStatus.IS_NULL_OR_EMPTY_STRING;
        List<String> userInputList = new ArrayList<>();
        while (!errorStatus.isCorrect()) {
            userInputList = getUserInputList();
            errorStatus = isValidateInputList(userInputList);
            responseErrorMessage(errorStatus);
        }
        return userInputList;
    }

    private int getGameNumber() {
        ErrorStatus errorStatus = ErrorStatus.IS_NOT_POSITIVE_NUMBER;
        String userInput = "";
        while (!errorStatus.isCorrect()) {
            userInput = getUserInput();
            errorStatus = isValidateInput(userInput);
            responseErrorMessage(errorStatus);
        }
        return Integer.parseInt(userInput);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private List<String> getUserInputList() {
        String userInput = Console.readLine();
        String[] userInputArray = userInput.split(SPLIT_REGEX);
        return Arrays.asList(userInputArray);
    }

    private ErrorStatus isValidateInputList(List<String> userInputList) {
        ErrorStatus inputValidationStatus = racingService.validateInputCarNames(userInputList);
        if (!inputValidationStatus.isCorrect()) {
            return inputValidationStatus;
        }
        return racingService.validateDuplicateCarNames(userInputList);
    }

    private ErrorStatus isValidateInput(String userInput) {
        return racingService.validateInputGameNumber(userInput);
    }
}
