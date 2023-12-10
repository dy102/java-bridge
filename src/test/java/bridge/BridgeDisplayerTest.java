package bridge;

import bridge.domain.BridgeGame;
import bridge.option.GameStatus;
import bridge.util.BridgeDisplayer;
import bridge.util.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeDisplayerTest {
    @Test
    @DisplayName("bridge의 상태를 잘 출력하는지 확인한다.")
    void checkShow() {
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = BridgeGame.form(bridgeMaker.makeBridge(3));
        bridgeGame.tryMove("D");
        bridgeGame.tryMove("U");
        bridgeGame.tryMove("U");
        assertThat(BridgeDisplayer.show(GameStatus.SUCCESS, bridgeGame)).isEqualTo("[   | O | O ]\n[ O |   |   ]");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
