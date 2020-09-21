package cn.sdu.test.jiage;

import java.util.Arrays;
import java.util.Scanner;


public class Main1{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        int key=sc.nextInt();
        String str=String.valueOf(data);
        char[] chars = str.toCharArray();
        char[] res=new char[chars.length];
        StringBuilder resStr= new StringBuilder();
        for(int i=0;i<chars.length;i++){
            res[i]=chars[(i+key)% chars.length];
            resStr.append(res[i]);
        }
        System.out.println(resStr);
    }
}
