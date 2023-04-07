import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class TCPServer {
    public ServerSocket server;
    public Socket socket;

    public TCPServer(int port) throws IOException {
        System.out.print("Server is running...");
        server = new ServerSocket(port);
    }

    public void connect() throws IOException {
        socket = server.accept();
    }

    public String getMessage() throws IOException {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String sentence = inFromClient.readLine();
        return sentence.trim();
    }

    public void closeSocket() throws IOException {
        System.out.println("Close socket");
        socket.close();
    }

    public void close() throws IOException {
        System.out.println("Close server!");
        server.close();
    }

    public void send(String sentence) throws IOException {
        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

        String response = handleMessage(sentence);

        outToClient.writeBytes(response);
    }

    public String handleMessage(String message) throws IOException {
        return message.toUpperCase() + " (server accepted!)" + '\n';
    }

    public static void main(String[] args) throws Exception {
        TCPServer server = new TCPServer(6709);
        while (true) {
            server.connect();
            String sentence = server.getMessage();
            if (sentence.compareTo("q") == 0) {
                server.closeSocket();
                break;
            }
            server.send(sentence);
        }

        server.close();
    }
}
