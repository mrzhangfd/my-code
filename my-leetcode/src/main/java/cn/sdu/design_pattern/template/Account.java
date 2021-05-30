package cn.sdu.design_pattern.template;

/**
 * 抽象模板角色类
 *
 * @author icatzfd
 * Created on 2020/10/14 11:01.
 */
public abstract class Account {
    /**
     * 模板方法，计算利息金额
     *
     * @return 利息数额
     */
    public final double calculateInterest() {

        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }

    /**
     * 基本方法留给子类实现
     * 计算账户类型
     *
     * @return
     */
    protected abstract String doCalculateAccountType();


    /**
     * 基本方法留给子类实现
     * 计算利率
     *
     * @return
     */
    protected abstract double doCalculateInterestRate();

    /**
     * 基本方法，已经实现
     * 计算金额
     */
    private double calculateAmount(String accountType) {
        /**
         * 省略相关的业务逻辑
         */
        return 7243.00;
    }


}
