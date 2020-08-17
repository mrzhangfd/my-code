package cn.sdu.test.tencent;

/**
 * @author icatzfd
 * Created on 2020/8/16 9:28.
 */

public class Bitmap {
    private byte[] bitmap;
    private long length;

    public boolean get(long number){
        //获取位置
        long site=number>>>3;
        //获取该字节
        byte temp=bitmap[(int) site];//目前的QQ号在30亿之内，右移三位后肯定在Int最大值内（21亿内）
        //获取该字节的第几个
        long i=number&7;//等价于 i=number%8
        //将这个字节数右移(7-i)位（也就是把要查找的位移动到最右侧），然后与 0000 0001相与
        if(((temp>>>(7-i))&1)==0){
            return false;
        }
        return true;
    }
    private void set(long number, boolean bool){
        //获取位置
        long site=number>>>3;
        //获取该字节
        byte temp=bitmap[(int) site];

        //获取该字节的第几个
        long i=number&7;//等价于 i=number%8
        //将0000 0001 左移(7-i)
        byte comp= (byte) (1<<(7-i));

        if(bool){//设置为1
            bitmap[(int) site]= (byte) (comp|temp);//取或(0.. 1 0..)
        }else {//设置为0
            comp= (byte) ~comp;//取反
            bitmap[(int) site]= (byte) (comp&temp);//相与(1.. 0 1..)
        }
    }
    public void add(long index){
        set(index,true);
    }
    public void delete(long index){
        set(index,false);
    }

    public Bitmap (long length){
        this.length=length;
        bitmap=new byte[(int) (length>>>3)];
    }

    public long getLength() {
        return length;
    }

    public static void main(String[] args){
        Bitmap bitmap=new Bitmap(100000);
        bitmap.add(100);
        System.out.println(bitmap.get(100));
        bitmap.delete(100);
        System.out.println(bitmap.get(100));
    }

}