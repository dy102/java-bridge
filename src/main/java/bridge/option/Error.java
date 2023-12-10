package bridge.option;

public enum Error {
    THREE_TO_TWENTY("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_R_OR_Q("R 또는 Q를 입력해주세요."),
    NOT_NUMBER("숫자가 아닙니다.");

    private final String message;

    private Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
