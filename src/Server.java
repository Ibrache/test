import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5050);
            Socket socket = server.accept();
            System.out.println("Client connected");
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            String textFromClient="";
            while((textFromClient = (String) inStream.readObject()) != null) {
                System.out.println(textFromClient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
