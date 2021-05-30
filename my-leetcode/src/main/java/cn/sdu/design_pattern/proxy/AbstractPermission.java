package cn.sdu.design_pattern.proxy;

/**
 * 抽象权限类
 *
 * @author icatzfd
 * Created on 2020/9/29 16:04.
 */
public interface AbstractPermission {
    void modifyUserInfo();

    void viewNote();

    void setLevel(int level);


}
