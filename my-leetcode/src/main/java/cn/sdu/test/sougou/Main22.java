package cn.sdu.test.sougou;

import java.util.Arrays;

/**
 * 旋转密码
 *
 * @author icatzfd
 * Created on 2020/9/25 19:47.
 */
public class Main22 {
    public static String rotatePassword(String[] s1,String[] s2){
        if(s1.length<1||s2.length<1) {
            return "";
        }
        int n=s1.length;
        char[][] ciphertext = new char[n][n];
        char[][] password = new char[n][n];

        int count=0;
        for(int i=0;i<n;i++){
            password[i]=s1[i].toCharArray();
            ciphertext[i]=s2[i].toCharArray();
            for(int j=0;j<n;j++){
                if(password[i][j]=='0') {
                    count++;
                }
            }

        }
        int[][] arr = new int[count][2];
        int curIndex=0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (password[i][j] == '0') {
                    arr[curIndex][0] = i;
                    arr[curIndex++][1] = j;
                }
            }

        }
        String res="";
        for(int i=0;i<count;i++)
            res+=ciphertext[arr[i][0]][arr[i][1]];
        for(int j=0;j<3;j++){
            roate(arr,n-1);
            for(int i=0;i<count;i++) {
                res+=ciphertext[arr[i][0]][arr[i][1]];
            }

        }

        return res;

    }
    public static void roate(int[][] arr,int n){
        for(int i=0;i<arr.length;i++){
            int temp=arr[i][0];
            arr[i][0]=arr[i][1];
            arr[i][1]=n-temp;
        }
        Arrays.sort(arr,(a,b)->(a[1]-b[1]));
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));

    }
}
