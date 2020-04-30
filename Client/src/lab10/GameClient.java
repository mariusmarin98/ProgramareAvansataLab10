package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    String serverAddress; // The server's IP address
    int PORT; // The server's port

    public GameClient(String serverAddress, int PORT) {
        this.serverAddress = serverAddress;
        this.PORT = PORT;

    }

    public void start() {
        try {
            Socket socket = new Socket(serverAddress, PORT);
            while (true) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter command:");
                String request = keyboard.next();
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                // Send a request to the server
                out.println(request);
                if (request.equals("exit"))
                    break;
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
