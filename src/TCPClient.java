import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1"); // use the IP address of the server

        if (args.length > 0)
            serverHostname = args[0];

        System.out.println("Attemping to connect to host " + serverHostname + " on port 1234.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 1234);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Unable to get streams from server");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("--- Client ---");
        System.out.println("!!! Enter 'exit' to terminate !!!" );
        System.out.print ("input: ");
        while ((userInput = stdIn.readLine()) != null) {
            if (userInput.equals("exit")){
                System.out.println("Exiting ....");
                System.exit(0);
            }
               
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
            System.out.print ("input: ");
            
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
