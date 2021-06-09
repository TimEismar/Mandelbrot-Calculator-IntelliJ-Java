import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;

public class StartUp {

    //Größe
    static int xSize = 1000;
    static int ySize = 1000;
    static int  xSizeMan = 500;
    static int ySizeMan = 500;

    //MyFrame
    public static void main(String[] args) throws Exception {
        //JFrame
        //for (int e = 500; e < 500;){
            JFrame frame = new Mandelbrot(500);
            frame.setTitle("Mandelbrot-Calculator");
            frame.setSize(xSize, ySize);
//TODO User-Interface
            //JPanel
            JPanel p1 = new JPanel();


            //Titel
            JLabel title = new JLabel("Mandelbrot");
            frame.add(title);
            //Textboxen
            //Buttons
            //Sliders
            //Abschluss
            frame.add(p1);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
          //  String filename = "Bild";
            //filename = filename.concat(String.valueOf(e));
           // filename = filename.concat(".png");
           // ComponentSnapShot.getSaveSnapShot(frame, filename);
            //e = e + 1000000;
            //frame.setVisible(false); //you can't see me!
            //frame.dispose(); //Destroy the JFrame object
        }
   // }

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
