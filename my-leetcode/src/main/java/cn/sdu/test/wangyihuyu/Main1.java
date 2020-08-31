package cn.sdu.test.wangyihuyu;

import java.util.*;

/**
 * 网易互娱
 *
 * @author icatzfd
 * Created on 2020/8/12 19:37.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        while (count < t) {
            count++;
            sc.nextLine();
            String str = sc.nextLine();
            String[] ss = str.split(" ");
            Map<Character, List<Integer>> map = new HashMap<>();

            for (String s : ss) {
                char[] chars = s.toCharArray();
                List<Integer> list = new ArrayList<>();
                int num = chars[0] - '0';
                if (chars[1] == 'T') {
                    if (map.containsKey('T')) {
                        map.get('T').add(num);
                    } else {
                        list.add(num);
                        map.put('T', list);
                    }

                } else if (chars[1] == 'W') {
                    if (map.containsKey('W')) {
                        map.get('W').add(num);
                    } else {
                        list.add(num);
                        map.put('W', list);
                    }
                } else if (chars[1] == 'B') {
                    if (map.containsKey('B')) {
                        map.get('B').add(num);
                    } else {
                        list.add(num);
                        map.put('B', list);
                    }
                }
            }
            List<Integer> list1 = map.get('T');
            List<Integer> list2 = map.get('W');
            List<Integer> list3 = map.get('B');
            boolean flag = false;
            boolean isPrint = false;
            if (list1.size() > 3 || list2.size() > 3 || list3.size() > 3) {
                isPrint = true;
                flag = true;
                System.out.println("NO");
                break;
            }
            Collections.sort(list1);
            Collections.sort(list2);
            Collections.sort(list3);
            if (!isPrint) {
                for (int j = 1; j < list1.size(); j++) {
                    if (list1.get(j) - list1.get(j - 1) < 3) {
                        flag = true;
                        isPrint = true;
                        System.out.println("NO");
                        break;
                    }
                }
                for (int j = 1; j < list2.size(); j++) {
                    if (list2.get(j) - list2.get(j - 1) < 3) {
                        flag = true;
                        isPrint = true;
                        System.out.println("NO");
                        break;
                    }
                }
                for (int j = 1; j < list3.size(); j++) {
                    if (list3.get(j) - list3.get(j - 1) < 3) {
                        flag = true;
                        isPrint = true;
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if ((!flag) && (!isPrint)) {
                System.out.println("YES");
            }


        }


    }
}
