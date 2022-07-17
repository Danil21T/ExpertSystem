package View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyFrame extends JFrame {
    public MyFrame(String name) throws IOException {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(new Rectangle((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        setResizable(false);
        add(new Menu(this));
        setVisible(true);

    }
}
