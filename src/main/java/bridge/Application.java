package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new GameController(new BridgeRandomNumberGenerator(),
                new InputView(),
                new OutputView()).run();
    }
}
