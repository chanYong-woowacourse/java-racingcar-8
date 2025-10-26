package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputValidatorTest {
    @Test
    void 정상적인_자동차_이름_입력() {
        assertThatCode(() -> InputValidator.validateCarNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @Test
    void 빈_문자열_입력시_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해야 합니다");
    }

    @Test
    void 자동차_이름_5자_초과시_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    void 중복된_자동차_이름_입력시_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 공백만_있는_이름_입력시_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi, ,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백일 수 없습니다");
    }

    @Test
    void 정상적인_시도_횟수_입력() {
        assertThatCode(() -> InputValidator.validateTryCount("5"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    void 시도_횟수_0이하_입력시_예외(String input) {
        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    void 시도_횟수_숫자가_아닌_경우_예외() {
        assertThatThrownBy(() -> InputValidator.validateTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}