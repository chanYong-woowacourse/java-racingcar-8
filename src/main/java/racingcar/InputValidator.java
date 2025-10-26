package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("최소 1대 이상의 자동차가 필요합니다.");
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (trimmedName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
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
