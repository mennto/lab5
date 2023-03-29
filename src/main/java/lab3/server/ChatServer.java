package lab3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {
    private Map<Integer, Socket> mapClient = new TreeMap<Integer,Socket>();

    @Override
    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8887);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server is running. Waiting for clients");
        int numberClient=1;
        Socket client =null;
        while (true){
            try {
                client=server.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Thread clientThread = new Thread (new ClientThread(client,this,numberClient));
            clientThread.setDaemon(true);
            clientThread.start();
            mapClient.put(numberClient,client);
            numberClient++;
        }
    }

    public void sendMessageForAllClient(int numberClient, String clientMessage) throws IOException {
        for(Map.Entry<Integer,Socket> entry : mapClient.entrySet()){

        }
    }
}
