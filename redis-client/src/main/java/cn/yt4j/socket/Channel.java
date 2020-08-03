package cn.yt4j.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Channel {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("39.99.213.137",8848);
            InputStream inputStream= socket.getInputStream();
            OutputStream outputStream= socket.getOutputStream();
            outputStream.write( "set a a".getBytes());
            byte [] bb =new byte[1024];
            inputStream.read(bb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
