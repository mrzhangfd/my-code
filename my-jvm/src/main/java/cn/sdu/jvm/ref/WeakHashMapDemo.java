package cn.sdu.jvm.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author icatzfd
 * Created on 2020/8/22 16:25.
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        // myHashMap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {

        WeakHashMap<Integer, String> map = new WeakHashMap<Integer, String>();

        Integer key = new Integer(2);
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        //手动gc，
        System.gc();
        //此时map为空
        System.out.println(map);
    }

    private static void myHashMap() {

        HashMap<Integer, String> map = new HashMap<>();

        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        //手动gc 后，map 不变
        System.gc();
        System.out.println(map);
    }
}
