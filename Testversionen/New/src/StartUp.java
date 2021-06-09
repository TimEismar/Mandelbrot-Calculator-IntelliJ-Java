import javax.swing.*;
import java.awt.*;

public class StartUp {

    static int xSize = 1000;
    static int ySize = 1000;
    static int xSizeMan = 500;
    static int ySizeMan = 500;

    public static void main(String[] args){

        //JFrame
        JFrame frame = new JFrame();
        frame.setSize(xSize, ySize);
        frame.setTitle("Mandelbrot-Calculator");

        //Mandelbrot
        JPanel man = new JPanel();
        man.setBackground(Color.RED);
        JLabel test = new JLabel("Tim");
        man.add(test);
        //UserInterface
        JPanel uiPanel = new JPanel();
        uiPanel.setBackground(Color.BLUE);
        JLabel ter = new JLabel("Ter");
        uiPanel.add(ter);


        //Abschluss
        frame.add(man);
        frame.add(uiPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
