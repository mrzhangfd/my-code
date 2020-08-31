package cn.sdu.test;

import java.util.*;

/**
 * @author icatzfd
 * Created on 2020/8/31 20:37.
 */
public class tongcheng58 {
    /**
     * 翻译组合数
     *
     * @param num int整型 数字加密报文
     * @return int整型
     */
    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int a = 0, b = 0, c = 1;
        for (int i = 0; i < src.length(); ++i) {
            a = b;
            b = c;
            c = 0;
            c += b;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                c += a;
            }
        }
        return c;

        // write code here
    }

    /**
     * @param a int整型
     * @param b int整型
     * @return int整型
     */
    public static int question(int a, int b) {
        // write code here
        for (int i = 1; i < 500; i++) {
            if (isSquare(i + a) && isSquare(i + b)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isSquare(int num) {
        for (int i = 0; i < num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param values string字符串ArrayList<ArrayList<>>
     * @return string字符串ArrayList
     */
    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        if (values == null || values.size() == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> stringNumMap = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (ArrayList<String> stringList : values) {
            Collections.sort(stringList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (int i = 0; i < stringList.size(); i++) {
                Integer num = stringNumMap.get(stringList.get(i));
                if (num == null) {
                    num = 1;
                } else {
                    num++;
                }
                if (num >= values.size()) {
                    res.add(stringList.get(i));
                }
                stringNumMap.put(stringList.get(i), num);

            }

        }
        return res;


    }



    public static void main(String[] args) {
        int num =58;
        System.out.println(translateNum(num));
    }
}
