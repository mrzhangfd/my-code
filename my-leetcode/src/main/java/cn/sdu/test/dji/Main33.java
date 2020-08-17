package cn.sdu.test.dji;

import java.util.Scanner;

/**
 * AC 36
 * @author icatzfd
 * Created on 2020/8/16 20:13.
 */
public class Main33 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int k=sc.nextInt();
        int kk=k;
        char[] chars=str.toCharArray();
        int len = str.length();
        if(k > len) {
            System.out.println("error\n");
        }
        int i = 0;
        int j=0;
        while(k>0) {
            if(i == 0 || chars[i] < chars[i+1]){
                while(i < len-1 && chars[i] < chars[i+1]) {
                    i++;
                }
            } else {
                if (chars[i-1] > chars[i]) {
                    i--;
                }
            }
            for(j = i; j < len-1; j++) {
                chars[j] = chars[j+1];
            }
            k--;
            len--;
        }
        StringBuffer res=new StringBuffer();
        for(int m=0;m<=str.length()-kk;m++){
            res.append(chars[m]);
        }
        System.out.println(res);
    }
}
