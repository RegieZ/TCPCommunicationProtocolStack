import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP客户端代码实现步骤
        * 创建客户端Socket对象并指定服务器地址和端口号
        * 调用Socket对象的getOutputStream方法获得字节输出流对象
        * 调用字节输出流对象的write方法往服务器端输出数据
        * 调用Socket对象的getInputStream方法获得字节输入流对象
        * 调用字节输入流对象的read方法读取服务器端返回的数据
        * 关闭Socket对象断开连接。
 */
// TCP客户端代码实现
public class TCPClient {
    public static void main(String[] args) throws Exception{
        System.out.println("I am Client.");
        // 要发送的内容
        String content = "Where is Regino's Bidirectional Transmission?";
        // 创建Socket对象
        Socket socket = new Socket("127.0.0.1",9000);
        // System.out.println(socket);
        // 获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        // 输出数据到服务器端
        out.write(content.getBytes());

        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        // 创建字节数组：用来存储读取到服务器端数据
        byte[] buf = new byte[1024];
        // 读取服务器端返回的数据
        int len = in.read(buf);
        System.out.println("Server send: " + new String(buf,0,len));
        System.out.println("Length of content = " + len);

        // 关闭socket对象
        socket.close();
    }
}
