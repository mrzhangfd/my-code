package cn.sdu.test.yy;

/**
 * 水仙花数
 * @author icatzfd
 * Created on 2020/8/31 19:29.
 */
public class Main1 {
    /**
     * 找到比输入的整数大的下一个水仙花数
     * @param n int整型 输入的整数
     * @return long长整型
     */
    public long nextNarcissisticNumber (int n) {
        if(n<8 && n>=0){
            return n+1;
        }
        if(n<1000){
            for(int i=n+1;i<=999;i++){
                int a=i/100;
                int b=i/10%10;
                int c=i%10;
                if(i==a*a*a+b*b*b+c*c*c){
                    return i;
                }
            }
        }
        if(n<10000){
            for(int i=n+1;i<=9999;i++){
                int a=i/1000;
                int b=i/100%10;
                int c=i/10%10;
                int d=i%10;
                if(i== a*a*a*a+b*b*b*b+c*c*c*c+d*d*d*d){
                    return i;
                }
            }
        }
        if(n<100000){
            for(int i=n+1;i<=99999;i++){
                int a=i/10000;
                int b=i/1000%10;
                int c=i/100%10;
                int d=i/10%10;
                int e=i%10;
                if(i== Math.pow(a,5)+Math.pow(b,5)+Math.pow(c,5)+Math.pow(d,5)+Math.pow(e,5)){
                    return i;
                }
            }
        }
        return 1000;

        // write code here
    }
}
