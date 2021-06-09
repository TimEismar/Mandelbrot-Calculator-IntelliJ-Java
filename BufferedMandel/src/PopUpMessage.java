import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class PopUpMessage {
    public String uin;
    public static void help(){
        Runnable r = () -> {
            String html = "<html><body width='%1s'><h1>Controls</h1>"
                    + "<p>ESC = Leave/Close <br>"
                    + "W / A / S / D = Move<br>"
                    + "C / V = Iteration <br>"
                    + "1 - 4 = Change Color<br><br>"
                    + "G / H = Minimal Iteration <br>"
                    + "O / P = Zoom <br>"
                    + "K / L = Dynamical Zoom <br>"
                    + "R = Reset <br>"
                    + "M / N = Size<br></p>";

            // change to alter the width
            int w = 200;

            JOptionPane.showMessageDialog(null, String.format(html, w, w),"Help",JOptionPane.QUESTION_MESSAGE);
        };
        SwingUtilities.invokeLater(r);
    }

    public static void credit(){
        Runnable r = () -> {
            String html = "<html><body width='%1s'><h1>Credits</h1>"
                    +"<p>Developer: Tim  J. Eismar<br>"
                    +"Sources: StackOverflow & Uni-Leipzig & GitHub</p>"
                    +"Help: Simon aka Pi";

            int w = 300;

            JOptionPane.showMessageDialog(null, String.format(html, w, w),"Credits",JOptionPane.INFORMATION_MESSAGE);
        };
        SwingUtilities.invokeLater(r);
    }

    public String fileNameUserInput()  {
        Runnable r = () -> {
            int w = 300;
            uin = (String)JOptionPane.showInputDialog("Dateiname");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        SwingUtilities.invokeLater(r);

        return uin;
    }
}
