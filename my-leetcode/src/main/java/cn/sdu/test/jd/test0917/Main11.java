package cn.sdu.test.jd.test0917;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author icatzfd
 * Created on 2020/9/17 20:07.
 */
public class Main11 {
   /* 作者：西兰没有花
    链接：https://www.nowcoder.com/discuss/514837?type=post&order=create&pos=&page=0&channel=1009&source_id=search_post
    来源：牛客网*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 要验证的字符串
        // String str = "baike 2019 xsoftlab 2020 net";
        // 正则表达式规则
        String regEx = "\\d{4}";
        // 编译正则表达式
        Pattern pat = Pattern.compile(regEx);

        Matcher mat = pat.matcher(str);

        while(true){
            if(mat.find()) {
                System.out.print(mat.group() + " ");
            }
            else{
                break;
            }
        }
    }
}
