package javacourse.test2;

public class MyDate {
    private int year, month, day;
    private static int thisYear;

    static {
        thisYear = 2017;
    }

    public MyDate()                                        //无参数构造方法,默认为2017.1.1
    {
        this.year = 2017;
        this.month = 1;
        this.day = 1;
    }

    public MyDate(int year, int month, int day)//构造函数
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate d) //复制构造函数
    {
        this(d.year, d.month, d.day);
    }

    public int getYear()                                   //获得年份
    {
        return this.year;
    }

    public int getMonth()                                  //获得月份
    {
        return this.month;
    }

    public int getDay()                                    //获得当月日期
    {
        return this.day;
    }

    public static int getThisYear()                        //获得今年年份
    {
        return thisYear;
    }

    @Override
    public String toString()                               //输出
    {
        return this.year + "年" + String.format("%02d", this.month) + "月" +
                String.format("%02d", this.day) + "日";
    }

    public static boolean isLeapYear(int year)             //判断指定年份是否闰年
    {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    public boolean isLeapYear()                            //判断当前日期的年份是否闰年
    {
        return isLeapYear(this.year);
    }

    public boolean equals(MyDate d)                        //比较当前日期值与d是否相等
    {
        return this == d || d != null && this.year == d.year && this.month == d.month && this.day == d.day;

    }

    public static int daysOfMonth(int year, int month)     //返回指定年月的天数，静态方法
    {
        switch (month)                                     //计算每月的天数
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return MyDate.isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    public int daysOfMonth()                               //返回当月天数
    {
        return daysOfMonth(this.year, this.month);
    }

    public void tomorrow()                                 //当前日期改为之后一天日期
    {
        this.day++;
        if (this.day > this.daysOfMonth()) {
            this.day = 1;
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }

    public MyDate yestoday()                               //返回当前日期的前一天日期
    {
        MyDate date = new MyDate(this);
        date.day--;
        if (date.day == 0) {
            date.month--;
            if (date.month == 0) {
                date.month = 12;
                date.year--;
            }
            date.day = daysOfMonth(date.year, date.month);
        }
        return date;                                       //返回对象date引用的实例
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MyDate) {
            MyDate d = (MyDate) obj;
            return this.year == d.year && this.month == d.month && this.day == d.day;
        }
        return false;
    }
}

