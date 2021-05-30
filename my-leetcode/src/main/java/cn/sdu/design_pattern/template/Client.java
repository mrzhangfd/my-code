package cn.sdu.design_pattern.template;

/**
 * @author icatzfd
 * Created on 2020/10/14 11:14.
 */
public class Client {
    public static void main(String[] args) {
        Account account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());
    }
}
