package util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public static List<String> mapToList(String value) {
        List<String> result = new ArrayList<>();

        char[] charArray = value.toCharArray();
        for (char c : charArray) {
            result.add(String.valueOf(c));
        }

        //for (int i = 0; i < value.length() - 1; i++) {
        //    result.add(value.charAt(i));
        //}

        return result;
    }

    public static String mapToString(List<String> strings) {
        StringJoiner result = new StringJoiner("");
        for (String string : strings) {
            result.add(string);
        }
        return result.toString();
    }
}
