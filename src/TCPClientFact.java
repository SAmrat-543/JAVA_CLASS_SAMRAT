import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClientFact {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        System.out.println("--- Client ---");
        try{
        Socket socket = new Socket("localhost",port);
        System.out.println("Attemping to connect to host on port : "+ port);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Client ---> Server");
        outputStream.writeInt(number);

        int factorial = inputStream.readInt();
        System.out.println("Factorial: ");
        System.out.println("Server --> " + factorial);

        outputStream.close();
        inputStream.close();
        socket.close();
        scanner.close();
    }
    catch(Exception e){
        System.out.println("Error Occured : " + e);
    }
    }
}
