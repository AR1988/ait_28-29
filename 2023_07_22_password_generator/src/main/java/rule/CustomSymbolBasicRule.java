package rule;

public class CustomSymbolBasicRule extends AbstractBasicRule {

    public CustomSymbolBasicRule(String mySymbols) {
        super(mySymbols.length());
        this.validCharters = mySymbols;
    }

    public CustomSymbolBasicRule(int length, String mySymbols) {
        super(length);
        this.validCharters = mySymbols;
    }

    @Override
    protected void setupValidCarters() {
    }
}
