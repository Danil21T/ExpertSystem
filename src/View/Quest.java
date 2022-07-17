package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Quest extends JPanel {
    private Image back = ImageIO.read(new File("Image/back.jpg"));
    private Map<String,String> question;
    private String currentKey;
    private Font BigFont = new Font("Yu Gothic Light", Font.BOLD, 18);
    private boolean first_question = true;

    public Quest(JFrame f, int mode) throws IOException {
        currentKey = "";
        initQuestions();
        setLayout(new LayoutCenter(7,7));
        JButton yes = new JButton("Да");
        yes.setFont(BigFont);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentKey+=1;
                if(question.get(currentKey).equals("Ответ")){
                    AnswerPanel a = null;
                    try {
                        a = new AnswerPanel(f, currentKey, mode);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    f.getContentPane().removeAll();
                    a.setPreferredSize(new Dimension(f.getWidth() ,f.getHeight() ));
                    f.setLayout(new BorderLayout());
                    f.getContentPane().add(a,BorderLayout.CENTER);
                    f.pack();
                    f.setVisible(true);
                }
                repaint();
            }
        });
        JButton no = new JButton("Нет");
        no.setFont(BigFont);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentKey+=0;
                if(question.get(currentKey).equals("Ответ")){
                    AnswerPanel a = null;
                    try {
                        a = new AnswerPanel(f, currentKey, mode);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    f.getContentPane().removeAll();
                    a.setPreferredSize(new Dimension(f.getWidth() ,f.getHeight() ));
                    f.setLayout(new BorderLayout());
                    f.getContentPane().add(a,BorderLayout.CENTER);
                    f.pack();
                    f.setVisible(true);
                }
                repaint();
            }
        });
        add(yes);
        add(no);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(back,0,0,null);
        g.setFont(BigFont);
        g.fillRect(0,150,getWidth(),400);
        g.setColor(Color.ORANGE);
        if(first_question){
            g.drawString("Вам\n нравится история?",450,200);
            first_question = false;
        }
        if(currentKey.equals("0010")){
            currentKey = "000";
        }
        g.drawString(question.get(currentKey),450,200);
    }

    public void initQuestions(){
        question = new HashMap<>();
        question.put("1010","Хотите учавствовать в войне?");
        question.put("10100","Ответ");
        question.put("10101","Ответ");
        question.put("101","Вам нравится романтика?");
        question.put("1011","Ответ");
        question.put("10","Вам нравится следовать сюжету?");
        question.put("1","Вы представляете себя\n в роли правителя?");
        question.put("","Вам нравится история?");
        question.put("100","Хотите управлять военной техникой?");
        question.put("1001", "Ответ");
        question.put("1000","Вам нравится фантасктика?");
        question.put("10001","Ответ");
        question.put("10000","Ответ");
        question.put("11","Вы бы хотели попасть в\n фантастический мир?");
        question.put("110","Вы хотите управлять войском?");
        question.put("1100","Ответ");
        question.put("1101","Ответ");
        question.put("111","Хотите сражаться в космосе?");
        question.put("1111","Ответ");
        question.put("1110","Ответ");
        question.put("0","Вам нравится музыка?");
        question.put("01","У вас хорошая реакция?");
        question.put("011","Вам нравятся головоломки?");
        question.put("0111","Ответ");
        question.put("0110","Ответ");
        question.put("010","Вам нравятся танцы?");
        question.put("0101","Ответ");
        question.put("0100","Ответ");
        question.put("00","Вам нравится биология?");
        question.put("001","Хотите создать жизнь?");
        question.put("0011","Ответ");
        question.put("000","Вам нравится фильмы\n Marvel studios?");
        question.put("0001","Вам нравится лего?");
        question.put("00010","Ответ");
        question.put("00011","Ответ");
        question.put("0000","Вам нравятся лего?");
        question.put("00000","Ответ");
        question.put("00001","Ответ");

    }
}
