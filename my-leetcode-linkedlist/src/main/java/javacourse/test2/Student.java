package javacourse.test2;

/**
 * 学生类
 *
 * @author icatzfd
 * Created on 2019/10/16 10:55.
 */
public class Student extends Person {              //Student继承person类
    public String dept;         //增加专业
    public int number;
    public int grade;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Student(String name, MyDate birthday, String dept, int grade)     //构造方法
    {
        super(name, birthday);                              //调用父类指定参数的构造方法
        this.dept = dept;
        this.grade = grade;
        count++;
        number = count;
    }

    public void set(String name, MyDate birthday, String dept, int grade)     //构造方法
    {

        this.dept = dept;
        this.grade = grade;
    }

    public Student()                                    //Java提供的默认构造方法
    {
        super();
        grade = 0;
        count++;
        number = count;
    }

    @Override
    public void finalize() {//析构函数
        count--;
        number = count;
    }

    public static void howMany() {
        System.out.println(count + "个Student对象");
    }

    @Override
    public String toString() {
        return ("学号为：" + number + "  成绩为：" + grade);
    }

    public static void main(String args[]) {
        Person p1 = new Person("李小明", new MyDate(1992, 3, 15));
        Student s1 = new Student();                        //默认构造方法，执行父类构造方法Person()
        s1.dept = "计算机";
        Student.howMany();                                 //继承父类的静态方法，执行Person.howMany()方法
        System.out.println("p1：" + p1.toString() + "；s1：" + s1.toString());
        s1.set("王江", new MyDate(1987, 2, 27), "", "", "");      //s1对象调用父类的成员方法
        s1.toString();
        System.out.println("删除该学生");
        s1.finalize();                                     //继承父类的析构方法
        Student.howMany();

    }
}
