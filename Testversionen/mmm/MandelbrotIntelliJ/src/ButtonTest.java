import java.awt.event.*;

import javax.swing.*;

public class ButtonTest {

    public static void main(String[] args) {
        JFrame f = new JFrame("ButtonTest");
        ImageIcon img = new ImageIcon("C:\\Users\\eisma\\OneDrive - Wirteltor Gymnasium\\Projektkurs-PH-IF\\Eclipse-Workspace\\Mandel\\src\\res\\unnamed.gif");
        f.setIconImage(img.getImage());

        JPanel p = new JPanel();
        JLabel title = new JLabel("Mandelbrot");
        title.setText("Test");


        p.add(title);
        f.add(p);

        f.setSize(500, 1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
