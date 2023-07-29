import rule.AbstractBasicRule;
import rule.AlphabetLowerCaseRule;
import rule.CustomBasicChartarsRule;
import rule.DigiBasicRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class Application {

    public static void main(String[] args) {

        AbstractBasicRule ruleAlphabet = new AlphabetLowerCaseRule(1);
        AbstractBasicRule ruleDigi = new DigiBasicRule(1);
        List<Character> myCharters = List.of(
          '§',
          '#',
          '+',
          '-',
          '(',
          '?'
        );
        AbstractBasicRule customCharterRule = new CustomBasicChartarsRule(myCharters);
        List<AbstractBasicRule> ruleList = new ArrayList<>();
        ruleList.add(ruleAlphabet);
        ruleList.add(ruleDigi);
        ruleList.add(customCharterRule);

        PasswordGenerator passwordGenerator = new PasswordGenerator(10);
        for (int i = 0; i < 5; i++) {
            String generate = passwordGenerator.generate(ruleList);
            System.out.println(generate);
        }
    }
}
