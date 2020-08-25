package cn.sdu.test.shangtang;

import java.util.HashSet;
import java.util.Set;

/**
 * 有向图 找环的长度
 *
 * @author icatzfd
 * Created on 2020/8/20 21:19.
 */

public class Main4 {
    public int findCycleLen(int[] input){
        HashSet<Integer> integers = new HashSet<>();
        int index=0;
        for(int i=0;i<input.length;i++){
            if(integers.contains(input[i])){
                index=i;
                break;
            }
            integers.add(input[i]);
        }
        int res=1;
        int cur=input[index];
        while(input[cur]!=input[index]){
            res++;
            cur=input[cur];
        }
        return res;
    }
}
