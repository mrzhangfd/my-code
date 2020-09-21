package cn.sdu.test.laohu;

import java.util.*;

/**
 * 做项目的最大收益问题
 *
 * @author icatzfd
 * Created on 2020/9/20 16:51.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int k = scanner.nextInt();
        int[] costs = new int[n];
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }
        Queue<Project> queue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });
        for (int i = 0; i < n; i++) {
            Project project = new Project();
            project.cost = costs[i];
            project.profit = profits[i];
            queue.offer(project);
        }
        long curW = w;
        long curK = k;
        while (curW > 0 && curK > 0) {
            List<Project> list = new ArrayList<>();
            while (curW < queue.peek().cost) {
                list.add(queue.poll());
            }
            Project temp = queue.poll();

            curW += temp.profit;
            curK--;
            for (Project pro : list) {
                queue.offer(pro);
            }
            list.clear();

        }
        System.out.println(curW);

    }
}

class Project {
    int cost;
    int profit;

    public Project() {

    }


}
