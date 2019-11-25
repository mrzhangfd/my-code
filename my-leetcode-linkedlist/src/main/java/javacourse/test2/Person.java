package javacourse.test2;

/**
 * @author icatzfd
 * Created on 2019/10/16 10:55.
 */
public class Person {
    public String name;                                    //姓名
    public MyDate birthday;                                //生日
    public String sex, province, city;                       //性别，所在省份、城市
    private static int count = 0;                            //静态成员变量，本类及子类实例计数

    public Person(String name, MyDate birthday, String sex, String province, String city) {
        super();
        this.set(name, birthday, sex, province, city);
        count++;
    }

    public Person(String name, MyDate birthday) {//重载构造方法
        this(name, birthday, "", "", "");
    }

    public Person() {//没有参数的构造方法
        this("", null);
    }

    public Person(Person p) {//复制构造函数
        this(p.name, new MyDate(p.birthday), p.sex, p.province, p.city); //深拷贝，创建日期实例
    }

    public void set(String name, MyDate birthday, String sex, String province, String city) {//set函数
        this.name = name == null ? "" : name;
        this.birthday = birthday;
        this.sex = sex == null ? "" : sex;
        this.province = province == null ? "" : province;
        this.city = city == null ? "" : city;
    }

    public static void howMany()//输出多少个人
    {
        System.out.print(Person.count + "个Person对象，");
    }

    @Override
    public String toString() {//输出该人的属性
        return this.name + "," + (this.birthday == null ? "" : this.birthday.toString())
                + "," + this.sex + "," + this.province + "," + this.city;
    }

    @Override
    public void finalize() {//析构函数
        Person.count--;
    }
}
