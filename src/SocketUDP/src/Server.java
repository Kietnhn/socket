
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public DatagramSocket socket;
    public DatagramPacket recivePacket, sendPacket;

    public Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public String recivedMessage() throws IOException {
        byte[] dataRecived = new byte[1024];
        recivePacket = new DatagramPacket(dataRecived, dataRecived.length);
        socket.receive(recivePacket);
        String message = new String(recivePacket.getData());
        return message.trim();
    }

    public void sendMessage(String message) throws IOException {
        InetAddress address = recivePacket.getAddress();
        int port = recivePacket.getPort();

        byte[] dataSend = new byte[2048];
        String sendToClient = handleMessage(message);
        dataSend = sendToClient.getBytes();
        sendPacket = new DatagramPacket(dataSend, dataSend.length, address, port);
        socket.send(sendPacket);
    }

    public String handleMessage(String message) throws IOException {
        return message.toUpperCase();
    }

    public void close() throws IOException {
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(9999);
        while (true) {
            String message = server.recivedMessage();
            if (message.compareTo("q") == 0) {
                break;
            }
            server.sendMessage(message);

        }
        server.close();

    }

}
