package util;

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
}
