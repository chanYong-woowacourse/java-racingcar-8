package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 경주 우승자를 판정하는 클래스
 * - 가장 멀리 이동한 자동차들을 찾음
 */
public class RaceWinnerChecker {
    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findCarsAtPosition(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<Car> findCarsAtPosition(List<Car> cars, int position) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car);
            }
        }
        return winners;
    }
}