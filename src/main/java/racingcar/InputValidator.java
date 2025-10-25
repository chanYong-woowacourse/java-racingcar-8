package racingcar;

public class InputValidator {
    public static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateTryCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
