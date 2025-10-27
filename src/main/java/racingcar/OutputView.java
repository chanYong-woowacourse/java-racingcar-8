package racingcar;

import java.util.List;

/**
 * 게임 결과를 출력하는 클래스
 */
public class OutputView {
    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}