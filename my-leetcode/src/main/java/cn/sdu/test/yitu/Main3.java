package cn.sdu.test.yitu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 摩尔斯密码
 *
 * @author icatzfd
 * Created on 2020/8/28 16:08.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if(str.length()>=2000){
            return;
        }

        Map<String,Character> psdMap=new HashMap<>();
        psdMap.put(".-",'A');
        psdMap.put("-...",'B');
        psdMap.put("-.-.",'C');
        psdMap.put("-..",'D');
        psdMap.put(".",'E');
        psdMap.put("..-.",'F');

        psdMap.put("--.",'G');
        psdMap.put("....",'H');
        psdMap.put("..",'I');
        psdMap.put(".---",'J');
        psdMap.put("-.-",'K');
        psdMap.put(".-..",'L');
        psdMap.put("--",'M');
        psdMap.put("-.",'N');
        psdMap.put("---",'O');
        psdMap.put(".--.",'P');
        psdMap.put("--.-",'Q');
        psdMap.put(".-.",'R');
        psdMap.put("...",'S');
        psdMap.put("-",'T');
        psdMap.put("..-",'U');
        psdMap.put("...-",'V');
        psdMap.put(".--",'W');
        psdMap.put("-..-",'X');
        psdMap.put("-.--",'Y');
        psdMap.put("--..",'Z');
        psdMap.put(".----",'1');
        psdMap.put("..---",'2');
        psdMap.put("...--",'3');
        psdMap.put("....-",'4');
        psdMap.put(".....",'5');
        psdMap.put("-....",'6');
        psdMap.put("--...",'7');
        psdMap.put("---.",'8');
        psdMap.put("----.",'9');
        psdMap.put("-----",'0');

        Map<String,String> map=new HashMap<>();
        map.put("1",".");
        map.put("111","-");

        //单词之间停顿
        String[] strings=str.split("0000000");
        if(strings==null || strings.length==0){
            return;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i< strings.length;i++){
            //字符之间的停顿
            String[] chr=strings[i].split("000");
            StringBuffer ssbb=new StringBuffer();
            for(String sss:chr){
                //字符内部的停顿
                String[] cc=sss.split("0");
                StringBuffer stringBuffer=new StringBuffer();
                for(String c:cc){
                    //StringBuffer 为 ...
                    stringBuffer.append(map.get(c));
                }
                char ch=psdMap.get(stringBuffer.toString());
                ssbb.append(ch);
            }
            if(i!= strings.length-1){
                sb.append(ssbb).append(" ");
            }else {
                sb.append(ssbb);
            }


        }
        System.out.println(sb);

    }
}
