import java.io.*;
import java.net.*;

public class CircleServer {
    public static void main(String[] args) throws IOException {
        int port =8888;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port : "+ port );
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Server <---- Client");
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            double radius = dataIn.readDouble();
            System.out.println("Radius : "+radius);
            double area = Math.PI * radius * radius;

            System.out.println("Server ---> Client ");
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            dataOut.writeDouble(area);
            System.out.println("Area : " + area);
            socket.close();
            serverSocket.close();
        }
    }
}
