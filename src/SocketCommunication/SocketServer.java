package SocketCommunication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try{
            //포트번호 9000번 으로 ServerSocket 객체 생성
            server = new ServerSocket(9000);

            while(true){
                System.out.println("Server Waiting");
                /*
                *  accept() 메소드를 호출하여 다른 원격 호출을 대기하는 상태로 만듬
                *  연결이 완료되면 Server 객체를 client 에 넘김
                * */
                client = server.accept();
                System.out.println("Server Accept");
                /*
                * 데이터를 받기위해 Socket 클래스의 getInputStream() 메소드를 통해 InputStream 객체를 반환
                * */
                InputStream stream = client.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String data = null;
                StringBuilder receiveData = new StringBuilder();
                while ((data=reader.readLine())!=null){
                    receiveData.append(data);
                }
                System.out.println("Receive Data : " + receiveData);

                reader.close();
                stream.close();
                client.close();

                if (receiveData != null && receiveData.toString().equals("EXIT")){
                    System.out.println("Stop Server");
                    break;
                }
                System.out.println("================");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
