package cn.sdu.test.shangtang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/20 21:04.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Map<String,Integer> map=new HashMap<>();
        map.put("G",0);
        map.put("Go",0);
        map.put("Goo",0);
        char c;
        int res=0;
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(c=='G'){
                map.put("G",map.get("G")+1);
            }
            if(c=='o'){
                if(map.get("Go")>0){
                    map.put("Goo",map.get("Goo")+1);
                    map.put("Go",map.get("Go")-1);
                    continue;
                }
                if(map.get("G")>0){
                    map.put("Go",map.get("Go")+1);
                    map.put("G",map.get("G")-1);
                    continue;
                }
            }
            if(c=='d'){
                if(map.get("Goo")>0){
                    res+=1;
                    map.put("Goo",map.get("Goo")-1);
                }
            }
        }
        System.out.println(res);
    }
}
