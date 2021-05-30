package cn.sdu.design_pattern.proxy;

/**
 * 真实权限类
 *
 * @author icatzfd
 * Created on 2020/9/29 16:05.
 */
public class RealPermission  implements AbstractPermission{
    @Override
    public void modifyUserInfo() {
        System.out.println("修改");
    }

    @Override
    public void viewNote() {
        System.out.println("查看");
    }

    @Override
    public void setLevel(int level) {

    }
}
