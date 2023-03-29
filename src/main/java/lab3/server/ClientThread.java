package lab3.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket clientSocket;
    private ChatServer chatServer;
    private int numberClient;

    public ClientThread(Socket client, ChatServer chatServer, int numberClient) {
        this.clientSocket = client;
        this.chatServer = chatServer;
        this.numberClient = numberClient;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client " + numberClient + " connected");
            try {
                new PrintWriter(clientSocket.getOutputStream(), true).println("Client " + numberClient + ".");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String clientMessage = null;
            while (true) {
                clientMessage = in.readLine();
                if (!"exit".equals(clientMessage)) {
                    System.out.println("Client " + numberClient + ":" + clientMessage);
                    chatServer.sendMessageForAllClient(numberClient, clientMessage);
                } else
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
