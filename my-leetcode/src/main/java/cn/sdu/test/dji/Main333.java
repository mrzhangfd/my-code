package cn.sdu.test.dji;

import java.util.Scanner;

/**ac 100%
 * https://www.nowcoder.com/discuss/479182?type=post&order=create&pos=&page=1&channel=666&source_id=search_post
 * @author icatzfd
 * Created on 2020/8/16 20:05.
 */
public class Main333 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.next();
        int n = input.nextInt();

        char a1[] = a.toCharArray();

        if(n == 0) {
            System.out.println(a);
        }

        int t = n;
        int i = 0;
        while(t > 0&&i<a.length()-1) {
            if(a1[i]>a1[i+1]) {
                for(int j = i;j<a1.length-1;j++) {
                    a1[j] = a1[j+1];
                }
                i = -1;
                t--;
            }
            i++;

        }
        String s="";
        boolean start=false;
        for(int j = 0;j < a1.length-n;j++) {

            if(!start&&'0'==a1[j]){
                continue;
            }else {
                start=true;
                s+=a1[j];
            }
        }
        if(s.length()==0){
            System.out.println(0);
        }else{

            System.out.println(s);
        }
    }

}
