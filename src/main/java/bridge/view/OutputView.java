package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(String bridge) {
        System.out.println(bridge);
    }

    public void printResult(String bridge, boolean isWin, int tryNumber) {
        System.out.println("최종 게임 결과");
        System.out.println(bridge);
        System.out.println();
        if (isWin) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + tryNumber);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + tryNumber);
    }
}
