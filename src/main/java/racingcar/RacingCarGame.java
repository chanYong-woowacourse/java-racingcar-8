package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 게임의 전체 흐름을 제어하는 클래스
 * - 입력 받기 → 경주 진행 → 우승자 발표
 */
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
        outputView.printRaceStart();
        for (int i = 0; i < attempts; i++) {
            moveAllCars();
            outputView.printRoundResult(cars);
        }
        printWinners();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printWinners() {
        List<Car> winners = winnerChecker.findWinners(cars);
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        outputView.printWinners(winnerNames);
    }
}
