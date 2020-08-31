package cn.sdu.test.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/8/16 9:27.
 */
public class OverlapQQ {
    //目前的qq号十位以内，大小应该在30亿之内。
    private static final long MAX_QQ = 5000000000L;
    //测试长度为五百万
    private static final int TEST_LENGTH = 5000000;

    static int GetTheSameQQ(final List<String> vecA, final List<String> vecB, List<String> vecRes) {
        int res = 0;
        Bitmap bitmap = new Bitmap(MAX_QQ);
        for (String qq : vecA) {
            long tmp = Long.parseLong(qq);
            bitmap.add(tmp);
        }
        for (String qq : vecB) {
            long tmp = Long.parseLong(qq);
            if (bitmap.get(tmp)) {
                vecRes.add(tmp + "");
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //vecA 范围(Integer.MAX_VALUE-TEST_LENGTH， Integer.MAX_VALUE+TEST_LENGTH]
        ArrayList<String> vecA = new ArrayList<>();
        final long TEMP = Integer.MAX_VALUE;
        for (long i = TEMP - TEST_LENGTH; i < TEMP + TEST_LENGTH; i++) {
            vecA.add(i + "");
        }

        //VecB 范围[Integer.MAX_VALUE-TEST_LENGTH/2,Integer.MAX_VALUE+TEST_LENGTH)
        ArrayList<String> vecB = new ArrayList<>();
        for (long i = TEMP - TEST_LENGTH / 2; i < TEMP + TEST_LENGTH / 2; i++) {
            vecB.add(i + "");
        }

        ArrayList<String> vecRes = new ArrayList<>();
        System.out.println(GetTheSameQQ(vecA, vecB, vecRes));
        for (int i = 0; i < 30; i++) {
            System.out.println(vecRes.get(i));
        }

    }
}
