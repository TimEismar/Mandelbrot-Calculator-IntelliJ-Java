import javax.swing.*;
public class StartUpMessage {
    public static void main(String[] args) throws Exception{
        Runnable r = () -> {
            String html = "<html><body width='%1s'><h1>Controls</h1>"
                    + "<p>L = Leave/Close <br>"
                    + "UpperArrow = Higher Ittertions<br>"
                    + "LowerArrow = Lower Itterations <br>"
                    + "C = Change Color<br><br>";
            // change to alter the width
            int w = 200;

            JOptionPane.showMessageDialog(null, String.format(html, w, w));
        };
        SwingUtilities.invokeLater(r);
    }
    }

