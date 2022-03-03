package ChatServer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends Application {

    /*
    * ThreadPool 에서 Thread 를 관리하기 위해서 사용하는 ExecutorService 클래스
    * */
    public static ExecutorService threadPool;
    /*
    * 멀테 쓰레드 환경에서 안전하지 못한 ArrayList 대신
    * 멀티 쓰레드 환경에서 안전하게 동기화가 가능한 Vector 클래스 사용
    * */
    public static Vector<Client> clients = new Vector<>();
    ServerSocket serverSocket;

    public void startServer(String ip, int port){
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip,port));
        } catch (Exception e) {
            e.printStackTrace();
            if (!serverSocket.isClosed()){
                stopServer();
            }
            return;
        }
        /*
        * Client 가 계속 접속할때까지 기다리는 쓰레드
        * */
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        /*
                        * accept() 메소드를 호출하여 원격 호출을 대기하는 상태
                        * */
                        Socket socket = serverSocket.accept();

                        clients.add(new Client(socket));
                        System.out.println("클라이언트 접속 " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread());
                    }catch (Exception e){
                        e.printStackTrace();
                        if (serverSocket.isClosed()){
                            stopServer();
                            System.out.println("서버가 종료되었습니다.");
                        }
                        break;
                    }
                }
            }
        };
        /*
        * 사이즈가 유동적으로 증가하고 줄어드는 ThreadPool 생성
        * */
        threadPool = Executors.newCachedThreadPool();
        threadPool.submit(thread);
    }

    public void stopServer(){
        try{
            /*
            * 현재 작동중인 모든 소켓 종료
            * */
            Iterator<Client> clientIterator = clients.iterator();
            while (clientIterator.hasNext()){
                Client client = clientIterator.next();
                client.socket.close();
                clientIterator.remove();
            }

            /*
            * ServerSocket 객체 종료
            * */
            if (serverSocket != null && !serverSocket.isClosed()){
                serverSocket.close();
            }

            /*
            * ThreadPool 종료
            * */
            if (threadPool != null && !threadPool.isShutdown()){
                threadPool.shutdown();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    * UI를 생성하고 직접적으로 프로그램을 실행시키는 메소드
    * */
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        //textArea.setFont(new Font("Arial",15));
        root.setCenter(textArea);

        Button toggleButton = new Button("시작하기");
        toggleButton.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(toggleButton,new Insets(1,0,0,0));
        root.setBottom(toggleButton);

        String ip = "127.0.0.1";
        int port = 9000;

        toggleButton.setOnAction(event -> {
            if (toggleButton.getText().equals("시작하기")){
                startServer(ip,port);
                Platform.runLater(() -> {
                    String msg = String.format("서버 시작\n",ip,port);
                    textArea.appendText(msg);
                    toggleButton.setText("종료하기");
                });
            }else {
                stopServer();
                Platform.runLater(() -> {
                    String msg = String.format("서버 종료 \n",ip,port);
                    textArea.appendText(msg);
                    toggleButton.setText("시작하기");
                });
            }
        });

        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("채팅서버");
        primaryStage.setOnCloseRequest(event -> stopServer());
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
