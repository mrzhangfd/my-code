package cn.sdu.test.yitu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/28 16:52.
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.length() >= 2000) {
            return;
        }

        Map<String, Character> psdMap = new HashMap<>();
        psdMap.put(".-", 'A');
        psdMap.put("-...", 'B');
        psdMap.put("-.-.", 'C');
        psdMap.put("-..", 'D');
        psdMap.put(".", 'E');
        psdMap.put("..-.", 'F');

        psdMap.put("--.", 'G');
        psdMap.put("....", 'H');
        psdMap.put("..", 'I');
        psdMap.put(".---", 'J');
        psdMap.put("-.-", 'K');
        psdMap.put(".-..", 'L');
        psdMap.put("--", 'M');
        psdMap.put("-.", 'N');
        psdMap.put("---", 'O');
        psdMap.put(".--.", 'P');
        psdMap.put("--.-", 'Q');
        psdMap.put(".-.", 'R');
        psdMap.put("...", 'S');
        psdMap.put("-", 'T');
        psdMap.put("..-", 'U');
        psdMap.put("...-", 'V');
        psdMap.put(".--", 'W');
        psdMap.put("-..-", 'X');
        psdMap.put("-.--", 'Y');
        psdMap.put("--..", 'Z');
        psdMap.put(".----", '1');
        psdMap.put("..---", '2');
        psdMap.put("...--", '3');
        psdMap.put("....-", '4');
        psdMap.put(".....", '5');
        psdMap.put("-....", '6');
        psdMap.put("--...", '7');
        psdMap.put("---.", '8');
        psdMap.put("----.", '9');
        psdMap.put("-----", '0');

        Map<String, String> map = new HashMap<>();
        map.put("1", ".");
        map.put("111", "-");

        String[] words = str.split("0000000");
        if (words == null || words.length == 0) {
            return;
        }
        StringBuffer sbb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            //字符之间的停顿
            String[] letters = words[i].split("000");
            String ssbb = "";
            for (String chr : letters) {
                chr=chr.replaceAll("111", "-");
                chr=chr.replaceAll("1", ".");
                chr=chr.replaceAll("0", "");
                ssbb += psdMap.get(chr);
            }
            sbb.append(ssbb).append(" ");

        }
        System.out.println(sbb);
    }

}
