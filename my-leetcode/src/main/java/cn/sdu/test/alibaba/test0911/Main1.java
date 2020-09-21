package cn.sdu.test.alibaba.test0911;

/**
 * @author icatzfd
 * Created on 2020/9/11 9:37.
 */
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String[] strings=new String[m];
        String str=sc.next();
        for(int i=0;i<m;i++){
            strings[i]=sc.next();
        }
        int res=0;
        for(int i=0;i<m;i++){
            String temp=str;
            while (!"".equals(temp) &&temp.contains(strings[i] )){
                res++;
                temp=temp.replaceFirst(strings[i],"");
            }
        }
        System.out.println(res);

    }






}

