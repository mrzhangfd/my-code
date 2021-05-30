package cn.sdu.design_pattern.template;

/**
 * @author icatzfd
 * Created on 2020/10/14 11:14.
 */
public class CDAccount  extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

}
