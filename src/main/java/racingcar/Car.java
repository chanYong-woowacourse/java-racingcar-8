package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차 경주 게임의 전체 흐름을 제어하는 클래스
 * - 입력 받기 → 경주 진행 → 우승자 발표
 */
public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
