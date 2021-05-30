package cn.sdu.test.huawei.test0331;

/**
 * @author icatzfd
 * Created on 2021/3/31 19:04.
 */
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        //输入空行结束
        while (scanner.hasNextLine()) {
            String temp=scanner.nextLine();
            if(temp.equals("")){
                break;
            }

            String[] str = temp.split(" ");

            String first = str[0].split("-")[0];
            String second = str[0].split("-")[1];

            if (!map.containsKey(first)) {
                map.put(first, 0);
            }
            if (!map.containsKey(second)) {
                map.put(second, 0);
            }
            String score1 = str[1].split(":")[0];
            String score2 = str[1].split(":")[1];
            int score11 = Integer.parseInt(score1);
            int score22 = Integer.parseInt(score2);
            int tempScore1=map.get(first);
            int tempScore2=map.get(second);
            if (score11 > score22) {

                map.put(first,3+tempScore1);
            }else  if(score11<score22){

                map.put(second,3+tempScore2);
            }else {
               map.put(first,1+tempScore1);
               map.put(second,1+tempScore2);
            }
        }
        //value-sort
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if(i!=list.size()-1){
                System.out.print(list.get(i).getKey() + " " + list.get(i).getValue()+",");
            }else {
                System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
            }
        }
    }
}
