package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.option.GameStatus;
import bridge.util.BridgeDisplayer;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(BridgeNumberGenerator bridgeNumberGenerator,
                          InputView inputView,
                          OutputView outputView) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        GameStatus gameStatus = GameStatus.RUN;
        BridgeGame bridgeGame = inputBridgeSize();

        while (gameStatus == GameStatus.RUN) {
            gameStatus = inputMoveStatus(bridgeGame);
            outputView.printMap(BridgeDisplayer.show(gameStatus, bridgeGame));
            if (gameStatus == GameStatus.RESTART) {
                gameStatus = inputRetryNumber(bridgeGame);
            }
        }
        outputView.printResult(BridgeDisplayer.show(gameStatus, bridgeGame),
                bridgeGame.isWin(), bridgeGame.getTryNumber());

    }

    private GameStatus inputRetryNumber(BridgeGame bridgeGame) {
        GameStatus gameStatus;
        gameStatus = bridgeGame.retry(inputView.readGameCommand());
        return gameStatus;
    }

    private BridgeGame inputBridgeSize() {
        outputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return BridgeGame.form(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private GameStatus inputMoveStatus(BridgeGame bridgeGame) {
        return bridgeGame.tryMove(inputView.readMoving());
    }
}
