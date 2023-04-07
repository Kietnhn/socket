package jdbc_udp;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;

public class Client {
    public DatagramSocket clientSocket;
    public InetAddress ipAddress;
    public int portServer = 9999;

    public Client(int port) throws SocketException {
        clientSocket = new DatagramSocket(port);
    }

    public void getIPAddress() throws SocketException, UnknownHostException {
        ipAddress = InetAddress.getByName("localhost");
    }

    public void sendMessage(String message) throws IOException {
        byte[] sendData = new byte[1024];
        sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, portServer);
        clientSocket.send(sendPacket);
    }

    public String recivedMessage() throws IOException {
        byte[] receiveData = new byte[2048];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String receiveMessage = new String(receivePacket.getData());
        return receiveMessage;
    }

    public void show(String message) {
        System.out.println("From server: " + message);
    }

    public void close() throws IOException {
        clientSocket.close();
    }

    public String getInputFromUser() throws IOException {
        System.out.print("Input From Client: ");
        BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
        return inputFromUser.readLine();
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client(6897);
        client.getIPAddress();
        while (true) {
            String sentence = client.getInputFromUser();
            if (sentence.compareTo("q") == 0) {
                break;
            }
            client.sendMessage(sentence);
            client.show(client.recivedMessage());
        }
        client.close();
    }

}
