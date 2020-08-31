package cn.sdu.test.tencent.test0823;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数字之和
 *
 * @author icatzfd
 * Created on 2020/8/23 21:09.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<t;i++){
            int n= sc.nextInt();
            int maxVal=0;
            for(int j=1;j<n/2;j++){
                int val;
                int v1;
                int v2;
                if(map.containsKey(j)){
                    v1=map.get(j);
                }else {
                    v1=calVal(j);
                    map.put(j,v1);
                }
                if(map.containsKey(n-j)){
                    v2=map.get(n-j);
                }else {
                    v2=calVal(n-j);
                    map.put(n-j,v2);
                }
                val=v1+v2;
                if(val>maxVal){
                    maxVal=val;
                }
            }

            System.out.println(maxVal);
        }

    }
    public static int calVal(int num){
        int res=0;
        while (num!=0){
            res+= num%10;
            num=num/10;
        }
        return res;
    }
}
