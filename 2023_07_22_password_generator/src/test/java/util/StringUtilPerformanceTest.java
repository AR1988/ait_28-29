package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
class StringUtilPerformanceTest {

    @Test
    @DisplayName("Тест производительности конвертации строки в список символов")
    void test_generateSymbols_symbolsFromAToZGenerated() {
        String underTest = "abc".repeat(1000);

        long start1 = System.currentTimeMillis();
        mapToListWithToCharArray(underTest);
        long end1 = System.currentTimeMillis();

        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        mapToListWithToForiLoop(underTest);
        long end2 = System.currentTimeMillis();

        System.out.println(end2 - start2);
    }


    public static List<String> mapToListWithToCharArray(String value) {
        List<String> result = new ArrayList<>();
        char[] charArray = value.toCharArray();
        for (char c : charArray) {
            result.add(String.valueOf(c));
        }
        return result;
    }

    public static List<String> mapToListWithToForiLoop(String value) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < value.length() - 1; i++) {
            result.add(String.valueOf(value.charAt(i)));
        }
        return result;
    }
}
