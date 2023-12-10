package bridge.util;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.option.GameStatus;

public class BridgeDisplayer {
    private BridgeDisplayer() {
    }

    public static String show(GameStatus gameStatus, BridgeGame bridgeGame) {
        StringBuilder upBridge = getUpBridge(gameStatus, bridgeGame);
        StringBuilder downBridge = getDownBridge(gameStatus, bridgeGame);
        return upBridge + "\n" + downBridge;
    }

    private static StringBuilder getUpBridge(GameStatus gameStatus, BridgeGame bridgeGame) {
        StringBuilder upBridge = new StringBuilder();
        makeUpBridge(gameStatus, bridgeGame, upBridge, "U");
        return upBridge;
    }

    private static StringBuilder getDownBridge(GameStatus gameStatus, BridgeGame bridgeGame) {
        StringBuilder downBridge = new StringBuilder();
        makeUpBridge(gameStatus, bridgeGame, downBridge, "D");
        return downBridge;
    }

    private static void makeUpBridge(GameStatus gameStatus, BridgeGame bridgeGame, StringBuilder upBridge, String status) {
        upBridge.append("[ ");
        for (int i = 0; i < bridgeGame.getBridges().size(); i++) {
            Bridge bridge = bridgeGame.getBridges().get(i);
            appendIfClear(bridge, upBridge, status);
            if (isNotClear(gameStatus, upBridge, bridge)) {
                break;
            }
            if (isFail(upBridge, bridge)) {
                break;
            }
            if (isAllClear(bridgeGame, upBridge, i)) {
                break;
            }
            appendIfNext(gameStatus, bridgeGame, upBridge, i);
        }
    }

    private static void appendIfClear(Bridge bridge, StringBuilder upBridge, String status) {
        if (bridge.isSamePosition(status) && bridge.isClear()) {
            upBridge.append("O");
        }
        if (!bridge.isSamePosition(status) && bridge.isClear()) {
            upBridge.append(" ");
        }
    }

    private static boolean isNotClear(GameStatus gameStatus, StringBuilder upBridge, Bridge bridge) {
        if (!bridge.isClear() && gameStatus != GameStatus.RESTART) {
            upBridge.append(" ]");
            return true;
        }
        return false;
    }

    private static boolean isFail(StringBuilder upBridge, Bridge bridge) {
        if (!bridge.isClear()) {
            upBridge.append("X ]");
            return true;
        }
        return false;
    }

    private static boolean isAllClear(BridgeGame bridgeGame, StringBuilder upBridge, int i) {
        if (i + 1 == bridgeGame.getBridges().size()) {
            upBridge.append(" ]");
            return true;
        }
        return false;
    }

    private static void appendIfNext(GameStatus gameStatus, BridgeGame bridgeGame, StringBuilder upBridge, int i) {
        if (i != bridgeGame.showClearStatus() || gameStatus == GameStatus.RESTART) {
            upBridge.append(" | ");
        }
    }


}
