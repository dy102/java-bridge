package bridge.domain;

import bridge.option.GameStatus;

import java.util.ArrayList;
import java.util.List;

import static bridge.option.Error.INPUT_R_OR_Q;

public class BridgeGame {
    private int tryNumber = 1;
    private final List<Bridge> bridges;


    private BridgeGame(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static BridgeGame form(List<String> bridgeStatus) {
        List<Bridge> bridges = new ArrayList<>();
        for (String status : bridgeStatus) {
            if (status.equals("U")) {
                bridges.add(new Bridge("U"));
            }
            if (status.equals("D")) {
                bridges.add(new Bridge("D"));
            }
        }
        return new BridgeGame(bridges);
    }

    public GameStatus retry(String sign) {
        if (sign.equals("R")) {
            tryNumber++;
            return GameStatus.RUN;
        }
        if (sign.equals("Q")) {
            return GameStatus.FAIL;
        }
        throw new IllegalArgumentException(INPUT_R_OR_Q.getMessage());
    }

    public GameStatus tryMove(String position) {
        for (Bridge bridge : bridges) {
            if (!bridge.isClear()) {
                return move(position, bridge);
            }
        }
        return GameStatus.SUCCESS;
    }

    private GameStatus move(String position, Bridge bridge) {
        bridge.clear(position);
        if (bridge.isClear()) {
            if (isWin()) {
                return GameStatus.SUCCESS;
            }
            return GameStatus.RUN;
        }
        return GameStatus.RESTART;
    }

    public boolean isWin() {
        for (Bridge bridge : bridges) {
            if (!bridge.isClear()) {
                return false;
            }
        }
        return true;
    }

    public int showClearStatus() {
        for (int i = 0; i < bridges.size(); i++) {
            if (!bridges.get(i).isClear()) {
                return i - 1;
            }
        }
        return bridges.size() - 1;

    }

    public int getTryNumber() {
        return tryNumber;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
