package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력을 받는 클래스
 */
public class InputView {

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    public String getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine().trim();
    }
}
