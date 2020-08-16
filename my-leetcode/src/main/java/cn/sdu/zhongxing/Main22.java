package cn.sdu.zhongxing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/15 11:52.
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        HashMap<Integer, HashSet<Integer>> nodeToSet = new HashMap<>();
        for(int i=0;i<m;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            HashSet<Integer> hashSet = nodeToSet.get(x);
            if(hashSet==null){
                hashSet=new HashSet<Integer>();
            }
            hashSet.add(y);
            nodeToSet.put(x,hashSet);
            hashSet = nodeToSet.get(y);


            if(hashSet==null){
                hashSet=new HashSet<Integer>();
            }
            hashSet.add(x);
            nodeToSet.put(y,hashSet);


        }
        int res=0;
        for(int key:nodeToSet.keySet()){
            HashSet<Integer> integers = nodeToSet.get(key);
            for(int keyNext:integers){

                HashSet<Integer> integers1 = nodeToSet.get(keyNext);
                for(int keyNextNext:integers1){
                    if(keyNextNext==key)
                        continue;
                    HashSet<Integer> integers2 =nodeToSet.get(keyNextNext);
                    if(integers2.size()==integers.size()&&integers.containsAll(integers2)){
                        res++;
                    }
                }

            }


        }
        System.out.println(res/2);
    }
}
