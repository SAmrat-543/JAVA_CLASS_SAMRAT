import java.io.*;
import java.net.*;

public class TCPServerFact {
    public static void main(String[] args) throws IOException {
        int port =9999;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port : "+ port );
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Server <---- Client");
            int number = inputStream.readInt();
            System.out.println("Number: "+number);
           
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Server ---> Client ");
            int factorial = calculateFactorial(number);
            System.out.println("Factorial : " + factorial);
            outputStream.writeInt(factorial);

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        }
    }

    public static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
