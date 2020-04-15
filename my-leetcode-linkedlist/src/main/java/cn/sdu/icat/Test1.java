package cn.sdu.icat;

import java.util.HashMap;

/**
 * LCP 1, 771
 *
 * @author 张峰达
 * Created on 2019/10/28 23:00.
 */

public class Test1 {

    public Test1() {
    }

    public int game(int[] guess, int[] answer) {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                num++;
            }
        }

        return num;
    }

    /**
     * 771 宝石与石头
     */
    public int numJewelsInStones(String J, String S) {

        HashMap<Character, Integer> SMap = new HashMap<>();
        char[] charS = S.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (SMap.containsKey(charS[i])) {
                SMap.put(charS[i], SMap.get(charS[i]) + 1);
            } else {
                SMap.put(charS[i], 1);
            }
        }
        System.out.println(SMap);
        int num=0;
        char[] chars = J.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(SMap.containsKey(chars[i])){
                num=num+SMap.get(chars[i]);
            }
        }
        return num;
    }


    /**
     * 矩形覆盖
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }else if (target==1){
            return 1;
        }else if (target==2){
            return 2;
        }
        else {
            int res=RectCover(target-1)+RectCover(target-2);
            return res;
        }

    }

    /**
     * 跳台阶
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        } else if (target==1) {
            return 1;
        }else if(target==2){
            return 2;
        }else {
            int res=JumpFloor(target-1)+JumpFloor(target-2);
            return res;
        }

    }

    public static void main(String[] args) {
        String s = "abcd";
        char[] chars = s.toCharArray();
        Test1 test1=new Test1();
        System.out.println(test1.numJewelsInStones("aA","aAABBCCA"));
        //System.out.println(chars[1]);
    }
}
