package bridge.util;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.option.Error.THREE_TO_TWENTY;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validate(size);
        List<String> bridgeStatus = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 0) {
                bridgeStatus.add("D");
            }
            if (number == 1) {
                bridgeStatus.add("U");
            }
        }
        return bridgeStatus;
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(THREE_TO_TWENTY.getMessage());
        }
    }
}
