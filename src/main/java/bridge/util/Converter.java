package bridge.util;

import static bridge.option.Error.NOT_NUMBER;

public class Converter {
    private Converter() {
    }

    public static int stringToInt(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
