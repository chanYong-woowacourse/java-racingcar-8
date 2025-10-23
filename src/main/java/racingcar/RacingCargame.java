package racingcar;
import java.util.List;

public class RacingCargame {
    InputView inputView;
    OutputView outputView;
    RaceWinnerChecker winnerChecker;
    List<Car> car;

    public RacingCargame() {
        inputView = new InputView();
        outputView = new OutputView();
        winnerChecker = new RaceWinnerChecker();
    }

    public void play(){
        // 게임 로직 구현
    }
}
