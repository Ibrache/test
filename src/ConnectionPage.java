import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionPage extends JPanel {
    Frame parent;
    String localText;
    String portField;
    Socket socket;

    public ConnectionPage(Frame parent){
        this.parent = parent;
        setSize(500, 280);
        setLayout(null);

        JLabel ipLabel = new JLabel("IP:");
        ipLabel.setSize(80,30);
        ipLabel.setLocation(70,30);
        add(ipLabel);

        JTextField ipText = new JTextField();
        ipText.setSize(250, 30);
        ipText.setLocation(130, 30);
        add(ipText);

        JLabel portLabel = new JLabel("Port:");
        portLabel.setSize(80,30);
        portLabel.setLocation(70,80);
        add(portLabel);

        JTextField portText = new JTextField();
        portText.setSize(250, 30);
        portText.setLocation(130, 80);
        add(portText);

        JButton connectButton = new JButton("Connect");
        connectButton.setSize(180, 30);
        connectButton.setLocation(165, 140);
        add(connectButton);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                localText = ipText.getText();
                portField = portText.getText();
                try {
                    socket = new Socket("localhost",5050);

                        parent.MP.outStream = new ObjectOutputStream(parent.CP.socket.getOutputStream());

//                   socket = new Socket(localText, Integer.parseInt(portField));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                parent.CP.setVisible(false);
                parent.MP.setVisible(true);
            }
        });
    }
}
