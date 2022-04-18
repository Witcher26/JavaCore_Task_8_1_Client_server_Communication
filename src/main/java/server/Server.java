package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8181;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();

                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted");
                final String name = in.readLine();

                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}

