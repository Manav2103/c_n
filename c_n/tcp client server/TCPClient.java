import java.io.*;
import java.net.*;

class TCPClient {
    public static void main(String argv[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String n ;

        System.out.println("Enter the first number: ");
        int num1 = Integer.parseInt(inFromUser.readLine());
        System.out.println("Enter the second number: ");
        int num2 = Integer.parseInt(inFromUser.readLine());

        outToServer.writeBytes(num1 + "\n");
        outToServer.writeBytes(num2 + "\n");
        int result = Integer.parseInt(inFromServer.readLine());
        System.out.println("Result from server: " + result);
        clientSocket.close();

    }
}
