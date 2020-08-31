package cn.sdu.test.yitu;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/28 17:41.
 */
public class Main11 {
    int dir = 0;
    int x = 0;
    int y = 0;
    int[][] moveDir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] commons=new String[m+1];
        for(int y=0;y<t;y++){
            System.out.println("Case #"+t+":");
            for(int i=0;i<m+1;i++){
                commons[i]=sc.nextLine().replace(" ","");
            }
            commit(commons,n*(-1)+1);
        }   

    }

    private static void commit(String[] z, int n) {

    }

    public void print(int n){
        if(x>0 && y>0){
            x=0;
            y=0;
        }else if (x>0 && y<=0&& y>=n){
            x=0;
        }

    }
}
