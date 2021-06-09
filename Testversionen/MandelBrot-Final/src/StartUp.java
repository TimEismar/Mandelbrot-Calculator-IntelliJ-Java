import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;

public class StartUp {
    static int xSize = 1000;
    static int ySize = 1000;
    static int  xSizeMan = 500;
    static int ySizeMan = 500;
    //MyFrame
    public static void main(String[] args) {

        JFrame frame = new Mandelbrot();
        frame.setTitle("Et klappt!!!!");
        frame.setSize(xSize, ySize);
//TODO User-Interface
        JPanel p1 = new JPanel();
        p1.add(new JButton("Test"));

        frame.add(p1);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static  int getX() {
        return xSizeMan;
    }
    public static  int getY() {
        return ySizeMan;
    }
    public static double getMiddleX(){
        double m = xSizeMan / 2;
        return m;
    }
    public static double getMiddleY(){
        double mw = ySizeMan / 2;
        return mw;
    }

}
