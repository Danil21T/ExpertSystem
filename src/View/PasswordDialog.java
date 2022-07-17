package View;

import IO.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PasswordDialog extends JDialog {
    public PasswordDialog(JFrame f){
        super(f,"Введите пароль",true);
        setLayout(new LayoutCenter(2,6));
        setBounds((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-150,
                (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-100,
                300, 200);
        setResizable(false);

        JTextField t = new JTextField("Введите пароль",25);
        add(t);
        JButton ok = new JButton("войти");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reader r = new Reader("Pass");
                if(t.getText().equals(r.getGame().get(0))) {
                    try {
                        int mode = 1;
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
                    dispose();
                }else{
                    t.setText("Неверный пароль");
                }

            }

        });
        add(ok);
        setVisible(true);
    }


}
