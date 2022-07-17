package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddGame extends JDialog {
    public AddGame(JFrame f){
        super(f,"Entered name",true);
        setLayout(new LayoutCenter(2,6));
        setBounds((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-150,
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-100,
                300, 200);
        setResizable(false);

        JTextArea t = new JTextArea("Хотите добавить ещё?");
        add(t);
        JButton ok = new JButton("да");
        JButton no = new JButton("нет");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m = null;
                f.getContentPane().removeAll();
                try {
                    m = new Menu(f);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                f.add(m);
                f.setVisible(true);
                dispose();
            }
        });
        add(no);
        add(ok);
        setVisible(true);
    }


}
