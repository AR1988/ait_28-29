package util;

import java.util.List;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class StringUtil {

    public static String generateLowerCharters() {
        StringBuilder buffer = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            buffer.append(i);
        }
        return buffer.toString();
    }

    public static String toString(List<Character> charters) {
        StringBuffer builder = new StringBuffer();
        for (Character charter : charters) {
            builder.append(charter);
        }
        return builder.toString();
    }
}
