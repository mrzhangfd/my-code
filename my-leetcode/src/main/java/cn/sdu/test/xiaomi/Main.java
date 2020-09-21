package cn.sdu.test.xiaomi;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/8 18:47.
 */
public class Main {
    public static int check(String password){


        int minLength = 8; // 最小长度
        int maxLength = 120; // 最大长度
        if(password==null || password.length()<minLength || password.length()>maxLength){
            // 长度不符合
            return 1;
        }
        boolean containUpperCase = false;// 包含大写字母
        boolean containLowerCase = false;//// 包含小写字母
        boolean containDigit = false;// 包含数字
        boolean containSpecial = false;// 包含特殊字符
        for(char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)){
                containUpperCase = true;
            }else if(Character.isLowerCase(ch)){
                containLowerCase = true;
            }else if(Character.isDigit(ch)){
                containDigit = true;
            }else {
                containSpecial = true;
            }
        }

        if(!containLowerCase||!containUpperCase||!containDigit||!containSpecial){
            return 2;
        }


        return 0;
    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password=input.nextLine();
        String[] passwords = password.split(" ");
        for(String pwd:passwords){
            System.out.println(check(pwd));
        }



    }
}
