package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
class StringUtilTest {

    @Test
    @DisplayName("тестирование генерации алфавита от 'a' до 'z'")
    void test_generateSymbols_symbolsFromAToZGenerated() {
        String result = StringUtil.generateLowerCharters();

        String expectedResult = "abcdefghijklmnopqrstuvwxyz";

        Assertions.assertEquals(expectedResult, result);
    }
}
