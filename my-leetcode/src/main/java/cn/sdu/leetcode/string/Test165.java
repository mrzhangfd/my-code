package cn.sdu.leetcode.string;

/**
 * 比较版本号 字符串处理
 *
 * @author icatzfd
 * Created on 2020/7/28 11:23.
 */
public class Test165 {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int len1 = str1.length;
        int len2 = str2.length;
        for (int i = 0; i < len1 && i < len2; i++) {

            if (Integer.parseInt(str1[i]) > Integer.parseInt(str2[i])) {
                return 1;
            } else if (Integer.parseInt(str1[i]) < Integer.parseInt(str2[i])) {
                return -1;
            }
        }
        if (len1 > len2) {
            for (int i = len2 - 1; i < len1; i++) {
                if(Integer.parseInt(str1[i])!=0){
                    return 1;
                }
            }
            return 0;
        }else {
            for(int i=len1-1;i<len2;i++){
                if(Integer.parseInt(str2[i])!=0){
                    return -1;
                }
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Test165 test=new Test165();
        System.out.println(test.compareVersion("1.0","1"));
        System.out.println(Integer.parseInt("01"));
    }
}
