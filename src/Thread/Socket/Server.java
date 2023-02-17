package Thread.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1331);
            Socket socket = serverSocket.accept()){
                PrintWriter pt = new PrintWriter(socket.getOutputStream(),true);
                pt.println("привет");
            }
        }
    }
