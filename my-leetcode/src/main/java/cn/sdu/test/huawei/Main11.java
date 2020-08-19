package cn.sdu.test.huawei;

/**
 * @author icatzfd
 * Created on 2020/8/19 20:44.
 */
public class Main11 {


    public static int[][] spiralOrder(int M, int N) {

        int[][] arr = new int[N][2];
        if (M <= 0 || N <= 0) {
            return arr;
        }
        int index = 0;
        int cnt = 0;
        int startx = 0;
        int starty = 0;
        int endx = M - 1;
        int endy = N - 1;
        while (startx < endx && starty < endy) {
            for (int i = starty; i < endy; i++) {
                cnt++;
                System.out.println(cnt + " " + startx + " " + i);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = startx;
                    arr[index][1] = i;
                    index++;
                }


            }


            for (int i = startx; i < endx; i++) {
                cnt++;
                System.out.println(cnt + " " + i + " " + endy);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = i;
                    arr[index][1] = endy;
                    index++;
                }


            }
            for (int i = endy; i > starty; i--) {
                cnt++;
                System.out.println(cnt + " " + endx + " " + i);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = endx;
                    arr[index][1] = i;
                    index++;
                }


            }
            for (int i = endx; i > startx; i--) {
                cnt++;
                System.out.println(cnt + " " + i + " " + starty);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = i;
                    arr[index][1] = starty;
                    index++;
                }


            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        //只有一列时
        if (starty == endy) {
            while (startx <= endx) {
                cnt++;
                System.out.println(cnt + " " + startx + " " + starty);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = startx;
                    arr[index][1] = starty;
                    index++;
                }

                startx++;

            }
        }
        //只有一行时
        if (startx == endx) {
            while (starty <= endy) {
                cnt++;
                System.out.println(cnt + " " + startx + " " + starty);
                if (cnt % 10 == 7 && (cnt / 10 % 10) % 2 == 1) {
                    arr[index][0] = startx;
                    arr[index][1] = starty;
                    index++;
                }

                starty++;

            }


        }

        return arr;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] arr = spiralOrder(-10, 10);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {

            if (arr[0][0] == 0 && arr[0][1] == 0) {
                while (i < arr.length) {
                    System.out.print("[" + 0 + "," + 0 + "]");
                }
                break;
            } else {
                if (arr[i][0] != 0 && arr[i][1] != 0) {
                    System.out.print("[" + arr[i][0] + "," + arr[i][1] + "]");
                }

            }


        }
        System.out.println("]");


    }

}
