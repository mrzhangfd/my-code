package cn.sdu.test.duoyi;

/**
 * @author icatzfd
 * Created on 2020/8/28 21:15.
 */
public class Main1 {
    public static void main(String[] args) {
        int re=0;
        int sum=0;
        for(int i=1;i<=108;i++){
            if(i%4==0 || i%6==0){
                re+=i;
            }else {
                sum+=i;
            }

        }
        System.out.println(sum);
    }
}
