import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 TCP服务器端代码实现

 ServerSocket类构造方法
 * ServerSocket(int port) 根据指定的端口号开启服务器。

 ServerSocket类常用方法
 *  Socket accept() 等待客户端连接并获得与客户端关联的Socket对象

 TCP服务器端代码实现步骤
 * 创建ServerSocket对象并指定端口号(相当于开启了一个服务器)
 * 调用ServerSocket对象的accept方法等待客端户连接并获得对应Socket对象
 * 调用Socket对象的getInputStream方法获得字节输入流对象
 * 调用字节输入流对象的read方法读取客户端发送的数据
 * 调用Socket对象的getOutputStream方法获得字节输出流对象
 * 调用字节输出流对象的write方法往客户端输出数据
 * 关闭Socket和ServerSocket对象
 */
public class TCPServer {
    public static void main(String[] args)throws Exception{
        System.out.println("I am Server.");
        // 创建服务器ocket对象
        ServerSocket serverSocket = new ServerSocket(9000);
        // 等待客户端连接并获得与客户端关联的Socket对象
        Socket socket = serverSocket.accept();
        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        // 创建字节数组：用来存储读取到客户端发送的数据
        byte[] buf = new byte[1024];
        // 读取客户端发送过来的数据
        int len = in.read(buf);
        System.out.println("Client send: " + new String(buf,0,len));
        System.out.println("Length of content = " + len);

        // 获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        // 往客户端输出数据
        out.write("Here.".getBytes());

        // 关闭socket
        socket.close();
        // 关闭服务器（在实际开发中，服务器一般不会关闭）
        serverSocket.close();
    }
}
