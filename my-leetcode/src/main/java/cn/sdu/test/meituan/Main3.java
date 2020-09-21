package cn.sdu.test.meituan;

import java.util.Scanner;

/** 找朋友 A 100
 * @author icatzfd
 * Created on 2020/9/20 10:21.
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        long res=0;
        int i=0,start=0;
        for(i=0;i<m;i++){
            char tmp = t.charAt(i);
            while (start<n&&s.charAt(start)!=tmp){
                start++;
            }
            if(start==n){
                System.out.println("No");
                return;
            }
            res+=++start;

        }
        System.out.println("Yes");
        System.out.println(res);
    }
}
