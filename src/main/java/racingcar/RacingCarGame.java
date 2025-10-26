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
        runRace();
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
    private void runRace() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveAllCars();
            printRoundResult();
        }
        printWinners();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners() {
        List<Car> winners = winnerChecker.findWinners(cars);
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

}
