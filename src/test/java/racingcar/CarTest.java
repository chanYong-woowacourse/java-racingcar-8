package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 자동차_이름_확인() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_초기_위치는_0() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}