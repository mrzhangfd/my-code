package cn.sdu.test.tencent;

import java.util.HashMap;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/8/15 19:03.
 * @descirble: A和B号码包都是亿级的号码包文件,  文件A和文件B中的号码全为QQ号，
 * 号码包文件一行一个QQ号， A和B号码包是有重叠的，请找出A，B两个号码包中重叠的QQ号。
 */
public class Main1 {
    int GetTheSameQQ(final List<String> vecA, final List<String> vecB, List<String> vecRes) {
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(String qqNumA:vecA){
            map.put(qqNumA,1);
        }
        for(String qqNumB:vecB){
            if(map.containsKey(qqNumB)){
                vecRes.add(qqNumB);
                count++;
            }
        }
        return count;
    }

    //计算qq号num在byte[]数组中的下标
    public int getIndex(String num) {
        Long longNum = Long.parseLong(num) / 8;
        int index = longNum.intValue();
        return index;
    }

    //计算num在byte[index]中的位置。即在byte[index]的第几位。
    //对8取余，等同：2^n -1 相与
    public int getPosition(String num) {
        Long longNum=Long.parseLong(num);
        long index = longNum % 8;
       return 1;
    }
}
