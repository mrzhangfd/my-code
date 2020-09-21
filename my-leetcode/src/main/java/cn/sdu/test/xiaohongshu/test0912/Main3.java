package cn.sdu.test.xiaohongshu.test0912;

import java.util.*;

/**
 * 叠箱子
 *
 * @author icatzfd
 * Created on 2020/9/12 10:38.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            Box box = new Box(a, b, c);
            boxes.add(box);
        }
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.l / o1.h - o2.l / o2.h;

            }
        });
        int res = 0;
        for (Box box : boxes) {
            System.out.println(box.l+""+box.h+""+box.w);
            res += box.w;
        }
        System.out.println(res);
        System.out.println("==============");
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.l / o1.w - o2.l / o2.w;

            }
        });
        int res1 = 0;
        for (Box box : boxes) {
            System.out.println(box.l+""+box.h+""+box.w);
            res1 += box.h;
        }
        System.out.println(res1);
        System.out.println("================");
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.w / o1.h - o2.w/ o2.h;

            }
        });
        int res2= 0;
        for (Box box : boxes) {
            System.out.println(box.l+""+box.h+""+box.w);
            res2 += box.l;
        }
        System.out.println(res2);
        System.out.println(Math.max(res,Math.max(res1,res2)));
    }
}

class Box {
    int l;
    int w;
    int h;

    public Box() {
    }

    public Box(int l, int w, int h) {

        this.l = l;
        this.w = w;
        this.h = h;
    }
}
