package racingcar;

public class RacingCargame {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceWinnerChecker winnerChecker;

    private String carNamesRaw;
    private int attempts;

    public RacingCargame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.winnerChecker = new RaceWinnerChecker();
    }

    public void play() {
        readInput();
        System.out.println("\n입력받은 자동차 이름: " + carNamesRaw);
        System.out.println("시도 횟수: " + attempts);
    }
    private void readInput() {
        this.carNamesRaw = inputView.getCarNames();
        String tryCountRaw = inputView.getTryCount();

        InputValidator.validateCarNames(carNamesRaw);
        InputValidator.validateTryCount(tryCountRaw);

        this.attempts = Integer.parseInt(tryCountRaw);

    }
}
