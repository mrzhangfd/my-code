package cn.sdu;

/**
 * 递归
 *
 * @author icatzfd
 * Created on 2020/6/7 16:09.
 */
public class Recursion {
    /**
     * 跳台阶
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        } else if (target==1) {
            return 1;
        }else if(target==2){
            return 2;
        }else {
            int res=JumpFloor(target-1)+JumpFloor(target-2);
            return res;
        }

    }

    /**
     * 矩形覆盖
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target==0){
            return 0;
        }else if (target==1){
            return 1;
        }else if (target==2){
            return 2;
        }
        else {
            int res=RectCover(target-1)+RectCover(target-2);
            return res;
        }

    }
}
