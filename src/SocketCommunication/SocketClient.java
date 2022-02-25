package SocketCommunication;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        for (int i = 0; i < 3; i++) {
            client.sendData("data " + (i+1) + " send");
        }
        client.sendData("EXIT");
    }

    public void sendData(String data){
        Socket socket = null;
        try{
            System.out.println("Client Connect");
            /*
            * IP 는 127.0.0.1 으로 로컬호스트 즉, 같은 장비를 의미하며 포트번호는 9000으로 Socket 객체생성
            * */
            socket = new Socket("127.0.0.1",9000);
            System.out.println("Client connect status : " + socket.isConnected());
            Thread.sleep(1000);
            /*
            * 데이터를 서버에 전송하기 위해서 Socket 클래스의 getOutputStream()으로 OutputStream 객체 반환
            * */
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client Send Data : " + data);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (socket != null){
                try{
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
