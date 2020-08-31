package cn.sdu.juc.enums;

import lombok.Getter;

/**
 * 七国枚举
 *
 * @author icatzfd
 * Created on 2020/8/17 23:03.
 */

public enum CountryEnum {
    /**
     * 齐国
     */
    ONE(1,"齐国"),

    /**
     *
     */
    TWO(2,"楚国"),
    THREE(3,"燕国"),
    FOUR(4,"韩国");

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    @Getter private Integer retCode;
   @Getter private String retMessage;

    CountryEnum(int retCode, String retMessage) {
        this.retCode=retCode;
        this.retMessage=retMessage;
    }

    public static CountryEnum forEachCountryEnum(int index){
        CountryEnum[] arr=CountryEnum.values();
        for(CountryEnum element:arr){
            if(index==element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
