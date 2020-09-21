package cn.sdu.test.hengsheng;
/**
 * @author icatzfd
 * Created on 2020/9/18 20:39.
 */
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                double d1 = Double.parseDouble(o1);
                double d2 = Double.parseDouble(o2);
                if (d1 > d2) {
                    return -1;
                } else if (d2 > d1) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });
        int len = strings.length;
        System.out.println(strings[0]);
        System.out.println(strings[len - 1]);

        Map<String, Num> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(strings[i])) {
                Num temp = map.get(strings[i]);
                temp.time++;
                map.put(strings[i], temp);
            } else {
                Num num = new Num(strings[i], 1);
                map.put(strings[i], num);
            }
        }

        Queue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.time - o2.time;
            }
        });

        for (String num : map.keySet()) {
            if (queue.size() < 3) {
                queue.offer(map.get(num));
            } else {
                if (map.get(num).time > queue.peek().time) {
                    queue.poll();
                    queue.offer(map.get(num));
                } else if (map.get(num).time == queue.peek().time) {
                    if (Double.parseDouble(num) > Double.parseDouble(queue.peek().num)) {
                        queue.poll();
                        queue.offer(map.get(num));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll().num+" ");
        }

    }
}

class Num {
    String num;
    int time;

    public Num(String num, int time) {
        this.num = num;
        this.time = time;
    }
}
