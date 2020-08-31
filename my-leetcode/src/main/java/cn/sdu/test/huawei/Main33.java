package cn.sdu.test.huawei;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/19 20:55.
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frame = scanner.next();
        String brick = scanner.next();

        int[] fs=new int[4];
        for(int i=0;i<frame.length();i++){
            fs[i]=frame.charAt(i)-'0';
        }
        int lenb=brick.length();
        int[] bs=new int[lenb];
        for(int i=0;i<brick.length();i++){
            bs[i]=brick.charAt(i)-'0';
        }

        int[][] res=new int[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                break;
            }
        }
    }
}
