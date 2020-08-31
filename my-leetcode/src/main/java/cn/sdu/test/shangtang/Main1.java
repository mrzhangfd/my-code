package cn.sdu.test.shangtang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * How many Good
 *
 * @author icatzfd
 * Created on 2020/8/20 20:15.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Map<Character,Integer> map=new HashMap<>();
        map.put('G',0);
        map.put('o',0);
        map.put('d',0);
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
        }
        int numofG=map.get('G');
        int numofO=map.get('o');
        int numofd=map.get('d');
        if(numofd ==numofG){
            if(numofO>=2*numofd){
                System.out.println(numofd);
            }else{
                System.out.println(numofO/2);

            }
        }else if(numofd>numofG){
            if(numofO>=2*numofG){
                System.out.println(numofG);
            }else {
                System.out.println(numofO/2);
            }
        }else {
            if(numofO>=2*numofd){
                System.out.println(numofd);
            }else {
                System.out.println(numofO/2);
            }
        }

    }
}
