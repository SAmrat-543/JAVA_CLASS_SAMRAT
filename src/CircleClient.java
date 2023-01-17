import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CircleClient {
    public static void main(String[] args) throws IOException {
        int port = 8888;
        System.out.println("--- Client ---");
        try{
            Socket socket = new Socket("localhost", port);
            System.out.println("Attemping to connect to host on port : "+ port);
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the radius of circle : ");
            double radius = in.nextDouble();
            dataOut.writeDouble(radius);
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            double area = dataIn.readDouble();
            System.out.println("The area of the circle is: ");
            System.out.println("Server --> " + area);
            socket.close();
            in.close();
        }
        catch(Exception e){
            System.out.println("Error Occured : " + e);
        }
    }
}
