package cn.sdu.test.dahua;

import java.util.Date;

/**
 * 车辆抓拍信息
 *
 * @author icatzfd
 * Created on 2020/9/7 21:11.
 */
public class shootCar {

    //抓拍路口编码
    private int adrId;

    private String carNum;

    private Date shootTime;

    public int getAdrId() {
        return adrId;
    }

    public void setAdrId(int adrId) {
        this.adrId = adrId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Date getShootTime() {
        return shootTime;
    }

    public void setShootTime(Date shootTime) {
        this.shootTime = shootTime;
    }
}
