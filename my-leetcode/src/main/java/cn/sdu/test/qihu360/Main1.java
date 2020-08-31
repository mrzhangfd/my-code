package cn.sdu.test.qihu360;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/22 18:58.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=0;
        String[] strs=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=sc.next();
        }
        for(String str:strs){
            if(isLegal(str)){
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean isLegal(String str){
        if(str.length()>10 ||str.length()<=0){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='_'){
                return false;
            }
            if(str.charAt(i)>='0'&& str.charAt(i)<='9'){
                return false;
            }
        }
        return true;
    }
}
