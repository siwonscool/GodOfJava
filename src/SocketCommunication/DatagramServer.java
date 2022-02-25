package SocketCommunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) {
        DatagramSocket server = null;

        try{
            //포트번호 9000번 으로 DatagramSocket 객체 생성
            server = new DatagramSocket(9000);
            int bufferLength = 256;
            byte[] buffer = new byte[bufferLength];
            /*
            * 데이터를 받기위한 DatagramPacket 객체로 byte 배열과 크기를 지정하여 사용한다.
            * */
            DatagramPacket packet = new DatagramPacket(buffer,bufferLength);
            while (true){
                System.out.println("Server waiting");
                /*
                 *  receive() 메소드를 호출하여 데이터가 오기 전까지 대기
                 *  데이터가 넘어오면 packet 객체에 데이터를 담는다.
                 * */
                server.receive(packet);
                int dataLength = packet.getLength();
                System.out.println("Server received. Data length = " + dataLength);
                /*
                * String 생성자를 이용해서 byte 배열로 되어있는 데이터를 String 문자열로 변경한다.
                * */
                String data = new String(packet.getData(),0,dataLength);
                System.out.println("Received data : " + data);
                if (data.equals("EXIT")){
                    System.out.println("Stop Server");
                    break;
                }
                System.out.println("=====================");

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (server != null){
                try{
                    server.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
