package View;

import IO.Reader;
import IO.Writer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Wrapper;
import java.util.Vector;

public class AnswerPanel extends JPanel{
    private Image back = ImageIO.read(new File("Image/back.jpg"));
    private Font BigFont = new Font("Yu Gothic Light", Font.BOLD, 18);

    public AnswerPanel(JFrame f, String answerPath, int mode) throws IOException {

        if(mode == 0){
            setLayout(new LayoutCenter(5,7));
            JTextArea text = new JTextArea();
            Reader r = new Reader(answerPath);
            Vector<String> anwser = r.getGame();
            StringBuilder sb = new StringBuilder();
            for(String s: anwser){
                sb.append(s).append("\n");
            }
            text.setWrapStyleWord(true);
            text.setLineWrap(true);
            text.setText(sb.toString());
            JButton b = new JButton("Пройти заново");
            b.addActionListener(new ActionListener() {
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
                }
            });
            add(text);
            add(b);
        }else{
            setLayout(new LayoutCenter(7,9));
            JTextField inputText = new JTextField(100);
            JButton b = new JButton("Добавить");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = inputText.getText();
                    Writer w = new Writer(answerPath);
                    w.putGame(s);
                    AddGame a = new AddGame(f);
                }
            });
            add(inputText);
            add(b);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(back,0,0,null);
        g.setFont(BigFont);
        g.setColor(Color.ORANGE);
    }
}
