package rule;

import util.StringUtil;

import java.util.List;

public class CustomBasicChartarsRule extends AbstractBasicRule {

    private final List<Character> customCharters;

    public CustomBasicChartarsRule(List<Character> customCharters) {
        super();
        this.customCharters = customCharters;
        setupValidCarters();
        this.length = customCharters.size();
    }


    @Override
    protected void setupValidCarters() {
        this.validCharters = StringUtil.toString(customCharters);
    }
}
