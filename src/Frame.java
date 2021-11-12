import javax.swing.*;
import java.net.Socket;

public class Frame extends JFrame{
    ConnectionPage CP;
    MessagePage MP;

    public Frame(){
        setSize(500, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Client");
        setLayout(null);

        CP = new ConnectionPage(this);
        CP.setVisible(true);
        add(CP);

        MP = new MessagePage(this);
        MP.setVisible(false);
        add(MP);
    }
}