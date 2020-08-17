package cn.sdu.test.dji;

import java.util.Scanner;

/**  AC  27%
 * @author icatzfd
 * Created on 2020/8/16 19:36.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        char[] chars=s.toCharArray();
        int count=0;
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("");

        for(int i=1;i<s.length() && count<k;i++){
            for(int j=0;j<i;j++){
                if(chars[i]<chars[j]){
                    s=s.substring(0,j)+s.substring(i);
                    /*chars[j]='-';
                    count++;*/
                    count++;
                }
            }
        }
        System.out.println(s);

       /* int numof0=0;
        int numofG=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]!='-' ){
                stringBuffer.append(chars[i]);
            }
            if(chars[i]=='0' || chars[i]=='-'){
                numof0++;
            }
            if(chars[i]=='-'){
                numofG++;
            }
        }
        if(numof0+numofG==s.length()){
            System.out.println("0");
        }else {
            StringBuilder res= new StringBuilder();
            String temp=stringBuffer.toString();
            //falg=true 表示开头没有数字
            boolean flag=true;
            for(int i=0;i<temp.length();i++){
                if(flag&&temp.charAt(i)=='0'){
                    continue;
                }
                if(temp.charAt(i)!='0'){
                    flag=false;
                    res.append(temp.charAt(i));
                }
            }
            System.out.println(res);
        }*/


    }
}
