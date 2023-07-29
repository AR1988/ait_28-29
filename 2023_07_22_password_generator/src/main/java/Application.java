import rule.AbstractBasicRule;
import rule.AlphabetLowerCaseRule;
import rule.CustomSymbolBasicRule;
import rule.DigiBasicRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class Application {

    public static void main(String[] args) {

        AbstractBasicRule ruleAlphabet = new AlphabetLowerCaseRule(3);
        AbstractBasicRule ruleDigi = new DigiBasicRule(4);
        AbstractBasicRule myCustomSymbolRule = new CustomSymbolBasicRule(";._#");
        List<AbstractBasicRule> ruleList = new ArrayList<>();
        ruleList.add(ruleAlphabet);
        ruleList.add(ruleDigi);
        ruleList.add(myCustomSymbolRule);

        PasswordGenerator passwordGenerator = new PasswordGenerator(20);
        for (int i = 0; i < 5; i++) {
            String generate = passwordGenerator.generate(ruleList);
            System.out.println(generate);
        }
    }
}
