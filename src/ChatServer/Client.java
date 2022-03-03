package ChatServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    Socket socket;

    /*
    * Socket 을 활용한 TCP 통신
    * */
    public Client(Socket socket) {
        this.socket = socket;
        receive();
    }

    /*
    * 클라이언트로부터 메시지를 받는 메소드
    * */
    public void receive(){
        /*
        * 메세지를 받는 쓰레드 구현
        * */
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        /*
                        * getInputStream() 메소드로 socket 의 데이터를 InputStream 타입으로 변환
                        * */
                        InputStream input = socket.getInputStream();
                        /*
                        * Stream 을 담을 byte 배열
                        * */
                        byte[] buffer = new byte[512];

                        int length = input.read(buffer);
                        if (length == -1) throw new IOException();
                        System.out.println("메세지 수신 성공" + socket.getRemoteSocketAddress() + " : " + Thread.currentThread());

                        String msg = new String(buffer,0,length,"UTF-8");

                        /*
                        * 서버에서 메세지를 받으면 접속중인 사용자들 에게 전부 메세지 전송
                        * */
                        for (Client client: Main.clients) {
                            client.send(msg);
                        }
                    }
                }catch (Exception e){
                    try{
                        System.out.println("메세지 수신오류 " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread());
                        Main.clients.remove(Client.this);
                        socket.close();
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        };
        Main.threadPool.submit(thread);
    }

    /*
    * 클라이언트로 메시지를 보내는 메소드
    * */
    public void send(String msg){
        /*
        * 메세지를 전송하는 쓰레드
        * */
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                try {
                    /*
                    * getOutputSteam() 메소드로 Socket 의 데이터를 전송하기위한 OutputStream 객체로 반환
                    * */
                    OutputStream output = socket.getOutputStream();
                    /*
                    * 전송할 메세지를 byte 형 배열로 변환
                    * */
                    byte[] buffer = msg.getBytes("UTF-8");
                    output.write(buffer);
                    output.flush();
                }catch (Exception e){
                    try{
                        System.out.println("메세지 송신 오류 " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread());
                        Main.clients.remove(Client.this);
                        socket.close();
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                }

            }
        };
        Main.threadPool.submit(thread);
    }
}
