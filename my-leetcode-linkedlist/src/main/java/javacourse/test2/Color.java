package javacourse.test2;


public class Color {
    private int value;
    public int red,green,blue;

    public Color(int red,int green,int blue){
        this.red=red;
        this.green=green;
        this.blue=blue;
        this.value=blue+(green<<8)+(red<<16)+(255<<24);
        //位运算
    }

    public Color(int rgb){
        this.value=rgb;
        //百度查找代码,位运算
        this.blue=this.value&255;

        this.green=(this.value&(255<<8))>>8;
        this.red=(this.value&(255<<16))>>16;
    }

    public Color(){
        this.red=0;
        this.green=0;
        this.blue=0;
        this.value=0;
    }

    public String getRGB(){
        //改成二进制
        return Integer.toHexString(value);
    }
    public int getRed(){
        return this.red;
    }
    public int getGreen(){
        return this.green;
    }
    public int getBlue(){
        return this.blue;
    }
    @Override
    public String toString(){

        return "(red,green,blue) = ("+this.red+","+this.green+","+this.blue+")";
    }
    public static void main(String arg[]){
        int a=(255<<24)+(255<<16)+(255<<8)+255;
        Color c1 = new Color(a);
        c1.toString();
        System.out.println("red="+c1.getRed()+" green="+c1.getGreen()+" blue="+c1.getBlue());
        System.out.println("Ox"+c1.getRGB());
    }
}
