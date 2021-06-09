import javax.swing.*;
import java.awt.*;

public class Interface {

    public static void main(String[] args) throws Exception{
        JFrame uint = new JFrame();
        uint.setSize(300, 500);
        uint.setTitle("User Interface");
        JPanel p1 = new JPanel();

        JLabel title = new JLabel("Settings");
        title.setFont(new Font("Coursier", Font.BOLD,25));
        //GridBagLayout

        p1.add(title);
        uint.add(p1);
        uint.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        uint.setVisible(true);
    }
    }



