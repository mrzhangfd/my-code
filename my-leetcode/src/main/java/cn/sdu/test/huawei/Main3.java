package cn.sdu.test.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 俄罗斯方块
 *
 * @author icatzfd
 * Created on 2020/8/19 19:52.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f = scanner.next();
        String b = scanner.next();
        int[] arr=new int[f.length()];
        int[] barr=new int[b.length()];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int fMax=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<f.length();i++){
            arr[i]=f.charAt(i)-'0';
            min=Math.min(min,arr[i]);
            fMax=Math.max(max,arr[i]);
        }
        for(int i=0;i<b.length();i++){
            barr[i]=b.charAt(i)-'0';
            if(barr[i]>max){
                index=i;
                max=barr[i];
            }

        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<f.length();i++){
            if(arr[i]==min){
                int[] arrT=new int[f.length()];
                System.arraycopy(arr,0,arrT,0,f.length());
                arrT[i]+=barr[index];
                int t=index-1;
                while(t>=0){
                    if(i-index+t>=0) {
                        arrT[i-index+t]+=barr[t];
                    }
                }
                t=index+1;
                while (t<b.length()){
                    if(i-index+t<f.length()) {
                        arrT[i-index+t]+=barr[t];
                    }
                }
                int m = Arrays.stream(arrT).min().getAsInt();
                res=Math.min(res,fMax-m);

            }

        }
        System.out.println(res);
    }
}
