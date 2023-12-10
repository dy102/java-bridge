package bridge.domain;

public class Bridge {
    private final String position;
    private boolean clear = false;

    public Bridge(String position) {
        this.position = position;
    }

    public void clear(String position) {
        if (isSamePosition(position)) {
            this.clear = true;
        }
    }

    public boolean isSamePosition(String position) {
        return this.position.equals(position);
    }

    public boolean isClear() {
        return clear;
    }
}
