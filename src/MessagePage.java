import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MessagePage extends JPanel {
    Frame parent;
    String message="";
    ObjectOutputStream outStream;

    public MessagePage(Frame parent){
        this.parent = parent;

        Scanner in = new Scanner(System.in);

        setSize(500, 280);
        setLayout(null);

        JLabel TextLabel = new JLabel("Отправьте сообщение серверу");
        TextLabel.setSize(300,30);
        TextLabel.setLocation(160,20);
        add(TextLabel);

        JTextField serverText = new JTextField();
        serverText.setSize(300, 40);
        serverText.setLocation(100, 80);
        add(serverText);

        JButton connectButton = new JButton("Отправить");
        connectButton.setSize(180, 30);
        connectButton.setLocation(160, 150);
        add(connectButton);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    message = serverText.getText();
                    outStream.writeObject(message);
                    serverText.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
