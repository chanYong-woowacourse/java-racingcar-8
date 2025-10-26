package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceWinnerChecker winnerChecker;

    private int attempts;
    private List<Car> cars;

    public RacingCarGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.winnerChecker = new RaceWinnerChecker();
        this.cars = new ArrayList<>();
    }

    public void play() {
        readInput();
        System.out.println("생성된 자동차 목록:");
        for (Car car : cars) {
            System.out.println("- " + car.getName());
        }
        System.out.println("시도 횟수: " + attempts);
    }
    private void readInput() {
        String carNamesInput = inputView.getCarNames();
        String tryCountInput = inputView.getTryCount();

        InputValidator.validateCarNames(carNamesInput);
        InputValidator.validateTryCount(tryCountInput);

        this.attempts = Integer.parseInt(tryCountInput);
        createCars(carNamesInput);
    }
    private void createCars(String carNamesInput) {
        String[] names = carNamesInput.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

}
