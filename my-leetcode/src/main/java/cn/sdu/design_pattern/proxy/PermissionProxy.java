package cn.sdu.design_pattern.proxy;

/**
 * 权限代理类
 *
 * @author icatzfd
 * Created on 2020/9/29 16:06.
 */
public class PermissionProxy {
    private RealPermission realPermission = new RealPermission();
    private int level = 0;

    public void modifyUserInfo() {
        if (level == 0) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

    public void viewNote(){
        System.out.println("view note");
    }
}
