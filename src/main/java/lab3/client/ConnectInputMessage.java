package lab3.client;

import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {
    private Socket serverConnect;
    private InputStream inputStreamServer;

    public Socket getServerConnect() {
        return serverConnect;
    }

    public void setServerConnect(Socket serverConnect) {
        this.serverConnect = serverConnect;
    }

    public InputStream getInputStreamServer() {
        return inputStreamServer;
    }

    public void setInputStreamServer(InputStream inputStreamServer) {
        this.inputStreamServer = inputStreamServer;
    }

    public ConnectInputMessage() throws IOException {
        serverConnect = new Socket("localhost", 8887);
        inputStreamServer = serverConnect.getInputStream();
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        while (true) {
            try {
                serverMessage = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (serverMessage != null) {
                System.out.println(serverMessage + "\n");
                break;
            }
        }

        PrintWriter out = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));

        String userMessage = null;
        while (true) {
            System.out.println("Input message");
            try {
                userMessage = inputUser.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                out = new PrintWriter(serverConnect.getOutputStream(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.println(userMessage);
            if ("exit".equals(userMessage)) {
                break;
            }
        }
    }
}
