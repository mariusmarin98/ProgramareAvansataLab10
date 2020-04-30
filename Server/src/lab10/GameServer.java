package lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {
    String serverAddress; // The server's IP address
    int PORT; // The server's port
    ServerSocket serverSocket;

    public GameServer(String serverAddress, int PORT) throws IOException {
        this.serverAddress = serverAddress;
        this.PORT = PORT;
        this.serverSocket = new ServerSocket(PORT);
        init();
    }

    public void init() throws IOException {
        try {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Error:" + e);
        } finally {
            serverSocket.close();
        }
    }
}
