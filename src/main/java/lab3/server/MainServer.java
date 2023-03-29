package lab3.server;

public class MainServer {
    public static void main(String[] args){
        ChatServer chatServer= new ChatServer();
        Thread tChatServer=new Thread(chatServer);
        tChatServer.start();
    }
}
