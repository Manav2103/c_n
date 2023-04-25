import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            int num1 = Integer.parseInt(inFromClient.readLine());
            int num2 = Integer.parseInt(inFromClient.readLine());
            int result = num1 + num2;
            System.out.println("calculate result on the server side and then also displaying it on the cclient machine");
            System.out.println(result);
            outToClient.writeBytes(result + "\n");
            connectionSocket.close();
        }
    }
}
