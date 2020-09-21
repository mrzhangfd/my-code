package cn.sdu.test.alibaba.test0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 图像恢复
 * @author icatzfd
 * Created on 2020/9/11 9:09.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        List<List<Point>> lists=numofBadPoint(arr);
        int[][] copy= Arrays.copyOf(arr,arr.length);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j]!=-1){
                    continue;
                }
                if(isIso(arr,i,j,n,m)){
                    int up=Integer.MAX_VALUE,down=Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                    int count=0;
                    int sum=0;
                    if(i-1>=0){
                        up=arr[i-1][j];
                        sum+=up;
                        count++;
                    }
                    if(j-1>=0){
                        left=arr[i][j-1];
                        sum+=left;
                        count++;
                    }
                    if(i+1<n){
                         down=arr[i+1][j];
                         sum+=down;
                        count++;
                    }
                    if(j+1>m){
                        right=arr[i][j+1];
                        sum+=right;
                        count++;
                    }
                    copy[i][j]=sum/count;


                }
            }
        }
        System.out.println(Arrays.deepToString(copy));



    }

    public static List<List<Point>> numofBadPoint(int[][] nums){
        if(nums==null ||nums.length==0 ||nums[0].length==0){
            return null;
        }
        int rows=nums.length;
        int cols=nums[0].length;
        int res=0;
        List<List<Point>> lists=new ArrayList<>();
        int[][] visited=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(nums[i][j]==-1 &&visited[i][j]==0){

                    res++;
                    List<Point> temp=new ArrayList<>();
                    helper(nums,i,j,visited,rows,cols,temp);
                    lists.add(new ArrayList<>(temp));
                }
            }
        }
        return lists;
    }

    private static void helper(int[][] nums, int i, int j, int[][] visited, int rows, int cols, List<Point> temp) {

        if(i>=rows ||i<0 || j>=cols ||j<0){
            return;
        }

        if(nums[i][j]!=-1){
            return;
        }

        if(visited[i][j]==1){
            return;
        }

        visited[i][j]=1;
        Point point=new Point();
        point.x=i;
        point.y=j;
        temp.add(point);
        helper(nums,i+1,j,visited,rows,cols,temp);
        helper(nums,i-1,j,visited,rows,cols,temp);
        helper(nums,i,j+1,visited,rows,cols,temp);
        helper(nums,i,j-1,visited,rows,cols,temp);

    }


    public static boolean isIso(int[][] nums,int i,int j,int n,int m){
        if(i-1>=0 && nums[i-1][j]==-1){
            return false;
        }
        if(i+1<n &&nums[i+1][j]==-1){
            return false;
        }

        if(j-1>=0 && nums[i][j-1]==-1){
            return false;
        }

        if(j+1<m && nums[i][j+1]==-1){
            return false;
        }
        return true;
    }
}
class Point{
    int x;
    int y;
    public Point(){}
}
