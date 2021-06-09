package fraktal.v4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JProgressBar;

public class Bild extends JComponent {

    private static final long serialVersionUID = 1L;

    JProgressBar b;

    double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    Einstellungen e;

    //int[] data = new int[(int)e.getWidth()*(int)e.getHeight()];
    int[] data = new int[(int)width*(int)height];

    public Bild (JProgressBar b) {
        this.b = b;
    }
    public Bild (JProgressBar b, Einstellungen e) {
        this.b = b;
        this.e = e;
    }
    public Bild (Einstellungen e) {
        this.e = e;
    }

    public void paintComponent(Graphics g) {
        //int width = getSize().width;
        //int height = getSize().height;
        super.paintComponent(g);

        Mandelbrot mandelbrot = new Mandelbrot(e);
        try {
            int[][] iterations = mandelbrot.pixelArrayIter();

            int i = 0;
            for (int y = 0; y < e.getHeight(); y++) {
                for (int x = 0; x < e.getWidth(); x++) {
                    int red = mandelbrot.getRed(iterations[y][x]);
                    int green = mandelbrot.getGreen(iterations[y][x]);
                    int blue = mandelbrot.getBlue(iterations[y][x]);
                    data[i++] = (red << 16) | (green << 8) | blue;
                }
            }
        } catch(Exception e) {

        }

        BufferedImage image = new BufferedImage((int)e.getWidth(), (int)e.getHeight(), BufferedImage.TYPE_INT_RGB);
        image.setRGB(0, 0, (int)e.getWidth(), (int)e.getHeight(), data, 0, (int)e.getWidth());
        g.drawImage(image, 0, 0, this);


        if(e.isGitterAn()) {

            g.setColor(Color.red);
            g.drawRect((int)((width-width/e.getZoomFak())/2), (int)((height-height/e.getZoomFak())/2), (int)(width/e.getZoomFak()), (int)(height/e.getZoomFak()));
            g.drawLine((int)((width-width/e.getZoomFak())/2), (int)((height-height/e.getZoomFak())/2), ((int)((width-width/e.getZoomFak())/2))+((int)(width/e.getZoomFak())), ((int)((height-height/e.getZoomFak())/2))+((int)(height/e.getZoomFak())));
            g.drawLine((int)((width-width/e.getZoomFak())/2), ((int)((height-height/e.getZoomFak())/2))+((int)(height/e.getZoomFak())), ((int)((width-width/e.getZoomFak())/2))+((int)(width/e.getZoomFak())), (int)((height-height/e.getZoomFak())/2));
        }
    }

    public Einstellungen getE(){
        return e;
    }
}
