package cn.sdu.test.dahua;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/9/7 21:12.
 */
public class ShootCarService {

    public float getAvgTravel(int beginAddress, int endAddress, List<shootCar> shootCars) {
        shootCar start = new shootCar();
        shootCar end=new shootCar();
        for (shootCar shootCar : shootCars) {
            if (shootCar.getAdrId() == beginAddress) {
                start=shootCar;
            }
            if(shootCar.getAdrId()==endAddress){
                end=shootCar;
            }

        }

        float totalTime=(float) (end.getShootTime().getTime()-start.getShootTime().getTime())/(1000*60*60);
        float res;
        res=(float)totalTime/(float)shootCars.size()-1;

        return Float.parseFloat(String.format("%.2f",res));
    }
}
