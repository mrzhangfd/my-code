package cn.sdu.design_pattern;

/**
 * 枚举 单例模式
 *
 * @author icatzfd
 * Created on 2020/9/22 20:59.
 */
public enum  SingleEnum {
    /**
     * 123
     */
    INSTANCE;

    private String objName;

    public String getObjName(){
        return objName;
    }

    public void setObjName(String objName){
        this.objName=objName;
    }

    public static void main(String[] args) {
        SingleEnum singleEnum=SingleEnum.INSTANCE;
    }


}
