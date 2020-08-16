package cn.sdu.wangyihuyu;

import java.util.*;

/**
 * @author icatzfd
 * Created on 2020/8/12 20:38.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] sss = new String[t];
        for (int i = 0; i < t; i++) {

            sss[i] = sc.nextLine();
        }
        for (String str : sss) {
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
            if (list1 == null || list2 == null || list3 == null) {
                isPrint = true;
                flag = true;
                System.out.println("NO");
            }

            if(!isPrint){
                if ((list1 != null && list1.size() > 3) || (list2 != null && list2.size() > 3) || (list3 != null && list3.size() > 3)) {
                    isPrint = true;
                    flag = true;
                    System.out.println("NO");

                }
            }

            if (list1 != null) {
                Collections.sort(list1);
            }
            if (list2 != null) {
                Collections.sort(list2);
            }
            if (list3 != null) {
                Collections.sort(list3);
            }

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
