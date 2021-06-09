import javax.swing.*;
import java.awt.*;

public class StartUp {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //JPanel
        JPanel pOne = new JPanel();


        //Text
        JLabel titel = new JLabel("Hallo");


        pOne.add(titel);

        //Color
        pOne.setBackground(Color.blue);

        //Add Panel
        frame.add(pOne);
    }
}
