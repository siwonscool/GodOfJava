package SocketCommunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Hashtable;

public class DatagramClient {
    public static void main(String[] args) {
        DatagramClient dc = new DatagramClient();
        for (int i = 0; i < 3; i++) {
            dc.sendData("data " + (i + 1) +" send");
        }
        dc.sendData("EXIT");
    }

    public void sendData(String data){
        try{
            //아무런 매개변수 없이 DatagramSocket 클래스 생성
            DatagramSocket client = new DatagramSocket();

            /*
            * InetAddress 클래스를 사용하여 데이터를 받는 서버의 IP 주소를 설정한다.
            * */
            InetAddress address = InetAddress.getByName("127.0.0.1");
            byte[] buffer = data.getBytes();
            /*
             * 데이터를 보내기위한 DatagramPacket 객체로 서버의 주소와 포트번호를 매개변수로 넘겨주면
             * 데이터를 받는 객체가아닌 보내기위한 객체가 된다.
             * */
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length,address,9000);
            /*
            * send() 메소드를 사용하여 데이터 전송
            * */
            client.send(packet);
            System.out.println("Client send Data : " + data);
            client.close();
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}