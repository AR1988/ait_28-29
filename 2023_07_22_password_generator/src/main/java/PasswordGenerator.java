import rule.AbstractBasicRule;
import util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class PasswordGenerator {

    private static final Random RANDOM = new Random();
    private final int passTotalLength;

    public PasswordGenerator(int passTotalLength) {
        this.passTotalLength = passTotalLength;
    }

    public String generate(List<AbstractBasicRule> rules) {

        StringBuilder buffer = new StringBuilder();

        Collections.shuffle(rules);

        for (AbstractBasicRule rule : rules) {
            int ruleLength = rule.getLength();
            String validRuleCharters = rule.getValidCharters();

            String passPart = getPasswordPart(validRuleCharters, ruleLength);
            buffer.append(passPart);
        }

        if (buffer.length() < passTotalLength) {

            int restCounter = passTotalLength - buffer.length(); //8
            int ruleSize = rules.size(); //4
            int symbolsPerRule = restCounter / ruleSize; // 2

            for (AbstractBasicRule rule : rules) {
                int ruleLength = symbolsPerRule;
                String validRuleCharters = rule.getValidCharters();

                String passPart = getPasswordPart(validRuleCharters, ruleLength);
                buffer.append(passPart);
            }
        }

        List<String> passwordAsCharList = StringUtil.mapToList(buffer.toString());
        Collections.shuffle(passwordAsCharList);

        return StringUtil.mapToString(passwordAsCharList);
    }

    private String enrichPass(String password) {
        return getPasswordPart(password, passTotalLength - password.length());
    }

    private String getPasswordPart(String validRuleCharters, int ruleLength) {
        StringBuilder partPassBuffer = new StringBuilder();

        // ruleLength = 4
        for (int i = 0; i < ruleLength; i++) {
            // 0 - 27
            int index = RANDOM.nextInt(validRuleCharters.length());
            // validRuleCharters = "bac" index = 2 result = 'c'
            char randomChar = validRuleCharters.charAt(index);
            partPassBuffer.append(randomChar);
        }

        return partPassBuffer.toString();
    }
}
