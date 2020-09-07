package cn.sdu.test.tencent.test0906;

import java.util.*;

/**
 * 字符串次数
 *
 * @author icatzfd
 * Created on 2020/9/6 20:40.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        int k = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<Node> list = new ArrayList<>();
        for (String s : map.keySet()) {
            Node node = new Node();
            node.str = s;
            node.num = map.get(s);
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.num == o2.num) {
                    return o2.str.compareTo(o1.str);
                } else {
                    return o1.num - o2.num;
                }

            }
        });

        int len = list.size();

        for (int i = len - 1; i >= len - k; i--) {
            System.out.println(list.get(i).str + " " + list.get(i).num);
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.num == o2.num) {
                    return o1.str.compareTo(o2.str);
                } else {
                    return o1.num - o2.num;
                }

            }
        });
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).str + " " + list.get(i).num);
        }

    }
}

class Node {
    String str;
    int num;
}
