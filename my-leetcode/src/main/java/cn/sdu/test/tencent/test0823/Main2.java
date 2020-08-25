package cn.sdu.test.tencent.test0823;

import java.util.*;

/**
 * 第k小子串
 *
 * @author icatzfd
 * Created on 2020/8/23 20:21.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        int k=sc.nextInt();
        if(str.length()==1){
            System.out.println(str);
            return;
        }
        Queue<String> queue=new PriorityQueue<>(3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o2.compareTo(o1);
            }
        });
        List<String> list=new ArrayList<>();
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<=str.length();j++){
                String temp=str.substring(i,j);
                if(queue.contains(temp)){
                    continue;
                }else {
                    if(queue.size()<3){
                        queue.offer(temp);
                    }else {
                        String tt=queue.peek();
                        if(tt.compareTo(temp)>0){
                            queue.poll();
                            queue.offer(temp);
                        }
                    }
                }

                /*if(queue.contains(temp)){
                    continue;
                }
                list.add(str.substring(i,j));*/
            }
        }
        /*Collections.sort(list);
        for(String ss:list){
            System.out.print (ss+" ");
        }
        System.out.println(" =====");
        System.out.println(list.get(k-1));*/
        /*while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }*/
        System.out.println(queue.peek());
    }
}
