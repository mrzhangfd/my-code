package javacourse.test3;

/**
 * 银行账户类
 *
 * @author icatzfd
 * Created on 2019/10/16 10:20.
 */
public class Account {

    public int account;
    public String name;
    public MyDate date;
    public String IDnumber;
    public int balance;

    public Account() {//默认构造函数
        this.account = 0;
        this.name = null;
        this.date = new MyDate();
        this.IDnumber = null;
        this.balance = 0;
        System.out.println("建立一个空账户！");
    }

    public Account(int account, String name, MyDate date, String IDnumber) {
        this.set(account, name, date, IDnumber, 0);
        System.out.println("个人账户开户成功！");
    }

    public void set(int account, String name, MyDate date, String IDnumber, int balance) {//设置各个属性

        this.account = account;
        this.name = name;
        this.date = date;
        this.IDnumber = IDnumber;
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void getMoney(int a) {
        if (this.balance - a < 0) {
            System.out.println("您的账户余额不足！");
        } else {
            this.balance -= a;
            System.out.println("您现在账户的余额为" + getBalance());
        }
    }

    @Override
    public String toString() {
        return "你的账号是：" + this.account + "   户主姓名为：" + this.name + "   开户时间为：" + this.date.toString()
                + "    身份证号码为：" + this.IDnumber + "   余额为：" + this.balance;
    }

    @Override
    public void finalize() {//析构函数
        System.out.println("您已销户！");
    }


    public static void main(String arg[]) {
        Account a = new Account();
        MyDate date = new MyDate(2017, 11, 1);

        a.set(123, "李威宇", date, "51564564654", 1000);
        System.out.println(a.toString());
        a.getMoney(100);
        a.finalize();
    }


}