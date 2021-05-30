package cn.sdu.design_pattern.template;

/**
 * @author icatzfd
 * Created on 2020/10/14 11:09.
 */
public class MoneyMarketAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}
