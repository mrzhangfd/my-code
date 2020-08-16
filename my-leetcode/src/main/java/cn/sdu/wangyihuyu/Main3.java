package cn.sdu.wangyihuyu;

import java.util.*;

/**
 * @author icatzfd
 * Created on 2020/8/12 21:00.
 */
class Event {
    int id;
    int start;
    int end;
    int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }



    public Event() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][3];
            for (int j = 0; j < n; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
                nums[j][2] = sc.nextInt();
            }
            List<Event> events = new ArrayList<>();
            Map<Integer, Event> map = new HashMap<>();
            for (int[] num : nums) {
                if (map.containsKey(num[1])) {
                    if(num[2]==0){

                    }
                    Event event = map.get(num[1]);
                    event.setEnd(num[0]);
                    event.setSum(event.getEnd() - event.getStart());
                } else {
                    Event event = new Event();
                    event.setId(num[1]);
                    event.setStart(num[0]);

                    map.put(num[1], event);
                    events.add(event);
                }
            }
            Collections.sort(events, new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {

                    return o2.getSum()-o1.getSum();
                }
            });
            System.out.println(events.get(0).id);
        }
    }
}
