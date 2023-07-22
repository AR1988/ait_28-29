package rule;

import util.StringUtil;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class AlphabetLowerCaseRule extends AbstractBasicRule {

    public AlphabetLowerCaseRule(int length) {
        super(length);
    }

    @Override
    protected void setupValidCarters() {
        this.validCharters = StringUtil.generateLowerCharters();
    }
}
