package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel {
    private int mode;
    private Image back = ImageIO.read(new File("Image/back.jpg"));

    public Menu(JFrame f) throws IOException {
        setLayout(new LayoutCenter(7, 7));
        setBounds(f.getBounds());
        JButton b1 = new JButton("Получить решение");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    mode = 0;
                    Quest q = new Quest(f, mode);
                    f.getContentPane().removeAll();
                    q.setPreferredSize(new Dimension(f.getWidth(), f.getHeight()));
                    f.setLayout(new BorderLayout());
                    f.getContentPane().add(q, BorderLayout.CENTER);
                    f.pack();
                    f.setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        JButton b2 = new JButton("Добаdить игру");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    PasswordDialog dialog = new PasswordDialog(f);
            }
        });

        add(b1);
        add(b2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(back, 0, 0, null);
    }
}
