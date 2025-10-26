package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RaceWinnerCheckerTest {
    @Test
    void 우승자_1명_찾기() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("pobi");
                    Car car2 = new Car("woni");

                    car1.move(); // 4 이상 → 전진
                    car2.move(); // 3 이하 → 정지

                    RaceWinnerChecker checker = new RaceWinnerChecker();
                    List<Car> winners = checker.findWinners(Arrays.asList(car1, car2));

                    assertThat(winners).hasSize(1);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                },
                4, 3  // 순서대로 반환될 랜덤 값
        );
    }

    @Test
    void 공동_우승자_찾기() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car1 = new Car("pobi");
                    Car car2 = new Car("woni");
                    Car car3 = new Car("jun");

                    car1.move(); // 4 → position 1
                    car2.move(); // 5 → position 1
                    car3.move(); // 3 → position 0

                    RaceWinnerChecker checker = new RaceWinnerChecker();
                    List<Car> winners = checker.findWinners(Arrays.asList(car1, car2, car3));

                    assertThat(winners).hasSize(2);
                    assertThat(winners).extracting("name")
                            .containsExactlyInAnyOrder("pobi", "woni");
                },
                4, 5, 3
        );
    }
}