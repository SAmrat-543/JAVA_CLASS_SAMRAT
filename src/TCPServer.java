import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        int port = 1234; // use any free port number
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine, outputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("exit"))
                    break;
                outputLine = "Server: " + inputLine;
                out.println(outputLine);
                
            }

            socket.close();
            serverSocket.close();
        }
    }
}
