package rule;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public abstract class AbstractBasicRule {

    protected int length;
    protected String validCharters;

    protected AbstractBasicRule(int length) {
        this.length = length;
        this.setupValidCarters();
    }

    protected abstract void setupValidCarters();

    public int getLength() {
        return length;
    }

    public String getValidCharters() {
        return validCharters;
    }
}
