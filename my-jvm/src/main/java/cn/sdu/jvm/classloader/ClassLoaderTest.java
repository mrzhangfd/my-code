package cn.sdu.jvm.classloader;

import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示
 *
 * @author icatzfd
 * Created on 2020/9/7 9:22.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try{
                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is=getClass().getResourceAsStream(fileName);
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(Exception e){
                    e.printStackTrace();
                }

            };

        };
        Object obj = myLoader.loadClass("org.fenixsoft.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof org.fenixsoft.classloading.ClassLoaderTest);
    }
}
