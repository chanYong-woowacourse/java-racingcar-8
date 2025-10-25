package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    //getCarNames
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(쉼표로 구분)");
        return Console.readLine().trim();
    }

    public String getTryCount() {
        System.out.println("시도할 횟수를 입력하세요.(숫자 입력)");
        return Console.readLine().trim();
    }
}
