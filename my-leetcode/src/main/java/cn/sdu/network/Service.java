package cn.sdu.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单的client server设计。
 *
 * @author icatzfd
 * Created on 2020/8/6 19:48.
 */
public class Service {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            //创建一个ServerSocket 在端口4700 监听客户请求
            server = new ServerSocket(4700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server=======================");
        Socket socket = null;
        try {
            //使用accept() 阻塞等待客户请求，有客户请求到来，则产生一个Socket对象，并继续执行
            socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line;
        try {
            BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
