import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public Socket socket;

    public TCPClient(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket(host, port);
    }

    public String getInputFromUser() throws IOException {
        System.out.println("Input From Client: ");
        BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
        String message = inputFromUser.readLine();
        return message;
    }

    public void sendMessage(String message) throws IOException {
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        outToServer.writeBytes(message + '\n');
    }

    public String getMessage() throws IOException {
        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String response = inFromServer.readLine();
        return response.trim();
    }

    public void show(String message) {
        System.out.print("FROM SERVER: " + message + '\n');
    }

    public void close() throws IOException {
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            TCPClient client = new TCPClient("localhost", 6709);
            String message = client.getInputFromUser();
            client.sendMessage(message);
            if (message.compareTo("q") == 0) {
                client.close();
                break;
            }
            String response = client.getMessage();
            client.show(response);
        }

    }
}
