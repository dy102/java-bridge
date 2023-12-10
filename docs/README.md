## 진행 순서

- 다리의 길이를 입력받는다.
- 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
- 이동할 수 없는 칸일 경우 X를 나타내고, 재시작 여부를 입력받는다. (시도횟수 +1)
- 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.

## 기능 목록

### controller

- GameController : 다리 건너기 게임을 진행하는 역할

---

### domain

- Bridge : 다리 한칸의 정보 저장하는 역할
- BridgeGame : 다리의 정보를 저장하고, 조작하는 역할

---

### option

- Error : 에러 메시지를 저장하는 enum
- GameStatus : 게임 상태를 저장하는 enum
- GameOption : 게임 옵션을 저장하는 class

---

### util

- BridgeDisplayer : 다리의 정보를 시각화 해주는 역할
- BridgeMaker : 다리를 제작하는 역할
- Converter : 어떤 값을 특정 값으로 변환하는 역할

---

### view

- InputView : 입력을 받고 반환하는 역할
- OutputView : 출력하는 역할

---
할

### generator

- BridgeNumberGenerator : 숫자 생성 Interface
- BridgeRandomNumberGenerator : 0,1 중 랜덤한 수를 생성하는 class