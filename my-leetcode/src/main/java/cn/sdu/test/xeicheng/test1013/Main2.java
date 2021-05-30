package cn.sdu.test.xeicheng.test1013;

import java.util.Scanner;

/**
 * 查找最小降序正整数
 *
 * @author icatzfd
 * Created on 2020/10/13 11:16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a= scanner.nextInt();
        System.out.println(find(a));
    }

    private static int find(int a) {

        for(int i=a;i<100000000;i++){
            if(isQual(i)){
                return i;
            }
        }
        return 0;
    }

    private static boolean isQual(int num) {
        String str=String.valueOf(num);
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)-'0'<str.charAt(i+1)-'0'){
                return false;
            }
        }
        return true;
    }
}
