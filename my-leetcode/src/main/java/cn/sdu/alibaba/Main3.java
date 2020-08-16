package cn.sdu.alibaba;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 阿舟 通话记录展示逻辑
 *
 * @author icatzfd
 * Created on 2020/8/13 20:50.
 */
public class Main3 {
    public List<String> dispaly(List<Long> list) {
        List<String> res = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/DD");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        for (long unixTimeStamp : list) {
            long curUnixTimeStamp = getUnixTimeStamp();
            String curDate = dateFormat1.format(new Date(curUnixTimeStamp));

            long temp = unixTimeStamp - curUnixTimeStamp;
            String date = dateFormat1.format(new Date(unixTimeStamp));

            if (curDate.equals(date)) {
                //今天
                String time = dateFormat2.format(new Date(unixTimeStamp));
                res.add(time);
            }
            String[] dates=date.split("/");
            String[] curDates=curDate.split("/");
            int dis=Integer.parseInt(dates[2])-Integer.parseInt(curDates[2]);
            if (dates[0].equals(curDates[0]) && dates[1].equals(curDates[1]) ){
                if(dis==-1){
                    //昨天
                    res.add("昨天");
                }else if(dis==-2){
                    res.add("前天");
                }else if(dis<-2 && dis>-7){
                    //显示周几

                }


            }
        }
        return null;
    }

    public static long toUnixTimeStamp(long timestamp) {
        return timestamp / 1000;
    }

    public static long getUnixTimeStamp() {
        //初始化时区对象，北京时间是UTC+8，所以入参为8
        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        //初始化LocalDateTime对象
        LocalDateTime localDateTime = LocalDateTime.now();
        //获取LocalDateTime对象对应时区的Unix时间戳

        return localDateTime.toEpochSecond(zoneOffset);
    }

    public static void main(String[] args) {
        //初始化时区对象，北京时间是UTC+8，所以入参为8
        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        //初始化LocalDateTime对象
        LocalDateTime localDateTime = LocalDateTime.now();
        //获取LocalDateTime对象对应时区的Unix时间戳
        long curUnixTimeStamp=localDateTime.toEpochSecond(zoneOffset);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/DD");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        long cur=System.currentTimeMillis()/1000L;
        String dateTime=dateFormat.format(new Date(cur));
        String date=dateFormat1.format(new Date(cur));
        String time=dateFormat2.format(new Date(cur));
    }
}
