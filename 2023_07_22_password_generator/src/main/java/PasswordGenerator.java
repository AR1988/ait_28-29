import rule.AbstractBasicRule;

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

        String password = buffer.toString();

        //TODO fix it
        if (password.length() < passTotalLength) {
            password = enrichPass(rules, password);
        }

        return password;
    }


    //TODO fix it
    private String enrichPass(List<AbstractBasicRule> rules, String password) {
        final int restLength = passTotalLength - password.length();

        final StringBuilder buffer = new StringBuilder(password);

        for (AbstractBasicRule rule : rules) {
            final String validRuleCharters = rule.getValidCharters();

            final String passPart = getPasswordPart(validRuleCharters, restLength / rules.size());
            buffer.append(passPart);
        }

        return buffer.toString();
    }

    private String getPasswordPart(String validRuleCharters, int ruleLength) {

        StringBuilder partPassBuffer = new StringBuilder();

        // ruleLength = 4
        for (int i = 0; i < ruleLength; i++) {
            // 0 - 27
            int index = RANDOM.nextInt(validRuleCharters.length() - 1);
            // validRuleCharters = "bac" index = 2 result = 'c'
            char randomChar = validRuleCharters.charAt(index);
            partPassBuffer.append(randomChar);
        }

        return partPassBuffer.toString();
    }
}
