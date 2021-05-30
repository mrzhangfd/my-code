package cn.sdu.design_pattern.proxy;

/**
 * @author icatzfd
 * Created on 2020/9/29 16:09.
 */
public class Client {
    public static void main(String[] args) {
        PermissionProxy permissionProxy=new PermissionProxy();
        permissionProxy.modifyUserInfo();
        permissionProxy.viewNote();
    }
}
