package NIOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) {
        NioTest nt = new NioTest();
        String path = "C:\\Users\\urp시스템\\IdeaProjects\\filetest\\nio.txt";
        try {
            nt.writeFile(path,"hello");
            nt.readFile(path);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void writeFile(String path, String data) throws Exception {
        FileChannel channel = new FileOutputStream(path).getChannel();
        byte[] bytes = data.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        channel.write(buffer);
        channel.close();
    }

    public void readFile(String path) throws Exception {
        FileChannel channel = new FileInputStream(path).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }

        channel.close();
    }
}
