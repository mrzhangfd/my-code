import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL的加密与解密
 *
 * @author icatzfd
 * Created on 2019/9/25 21:47.
 */
public class Codec {
    Map<Integer, String> map = new HashMap<>();
    int i = 0;

    public String encode(String longUrl) {
        System.out.println(longUrl);
        map.put(i,longUrl);
        System.out.println(map);
        String shortUrl="http://tinyurl.com/"+i;
        i++;
        return shortUrl;
    }

    public String decode(String shortUrl) {
        System.out.println(shortUrl);
        int num=Integer.parseInt(shortUrl.substring(shortUrl.length()-1));

        return map.get(num);
    }
    public static void main(String[] args) {
        Codec codec=new Codec();
        codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));
    }

}


