package cn.sdu.test.meituan;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/20 11:26.
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        char[][] map=new char[n][m];
        int[] cur=new int[2];
        for(int i=0;i<n;i++){
            String tmp = scanner.nextLine();
            int index=tmp.indexOf("S");
            if(index!=-1){
                cur[0]=i;
                cur[1]=index;

            }
            map[i]=tmp.toCharArray();
        }

        String path = scanner.nextLine();
        int res=0;
        for(char c:path.toCharArray()){
            res+=move(map,cur,c,p,q);
        }
        System.out.println(res);
    }

    private static int move(char[][] map, int[] cur, char c,int p,int q) {
        int x=cur[0],y=cur[1];
        switch (c){
            case 'S':x++;break;
            case 'D':y++;break;
            case 'A':y--;break;
            case 'W':x--;break;
        }
        if(x<0||x>=map.length||y<0||y>=map[0].length||map[x][y]=='#')
            return 0;
        cur[0]=x;
        cur[1]=y;
        if(map[x][y]=='O'){
            map[x][y]='+';
            return p;
        }

        else if(map[x][y]=='X'){
            map[x][y]='+';
            return -q;
        }

        else
            return 0;

    }
}
