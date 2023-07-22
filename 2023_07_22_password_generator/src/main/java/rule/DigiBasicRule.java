package rule;

/**
 * @author Andrej Reutow
 * created on 22.07.2023
 */
public class DigiBasicRule extends AbstractBasicRule {

    public DigiBasicRule(int length) {
        super(length);
    }

    @Override
    protected void setupValidCarters() {
        this.validCharters = "0123456789";
    }
}
