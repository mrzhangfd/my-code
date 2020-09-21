package cn.sdu.test.laohu;

import java.util.Arrays;
import java.util.Scanner;

/** A了
 * @author icatzfd
 * Created on 2020/9/20 17:00.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        for(int i=2;i<n;i++){
            if(i%2==0){
                int tmp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=tmp;
            }
        }
        for(int i=0;i<n;i++){
            if(i==n-1)
                System.out.println(arr[i]);
            else
                System.out.print(arr[i]+" ");
        }
    }
}
