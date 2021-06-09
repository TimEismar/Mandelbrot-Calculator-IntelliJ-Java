import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.GradientPaint;

import javax.swing.JFrame;
public class Mandelbrot extends JFrame {

    private static final long serialVersionUID = 1L;
    public int itterationen = 500;//TODO Variabel machen
    double y1;
    double y2;
    double ab;
    double a;
    double range = 4;
    double middleR = -0.5;
    double middleL = 1.5;
    public int colitt = 0;

    public Mandelbrot(int ittera){
        itterationen = ittera;
    }


    public void paint (Graphics g) {

        int xSize = StartUp.getX() ;
        int ySize = StartUp.getY() ;

        for(double x1 = 0; x1 != xSize; x1++){
            for(double y1 = 0; y1 !=  ySize; y1++){
                boolean ter = checkInside(y1, x1);
                if( ter == true){
                    int xr = (int)x1;
                    int yr = (int)y1;
                    g.setColor(Color.black);
                    g.fillRect(xr, yr, 1, 1);
                }
                else {
                    int xr = (int)x1;
                    int yr = (int)y1;
                    g.setColor(Color.CYAN);//calcCol(colitt)
                   // System.out.println(colitt);
                    g.fillRect(xr, yr, 1, 1);
                }
            }
        }
    }


    public boolean checkInside(double ci, double c){
        double zi = 0;
        double z = 0;
        double xPerc = c; // / StartUp.getX();
        double yPerc = ci; // / StartUp.getY();
        c = xPerc  * range +  middleR - range;
        c = c/2;
        ci = yPerc * range + middleL - range;
        ci = ci/4;

        c = -1 + 3 * xPerc;
        c = c/4;
        ci = 0 + 2 * yPerc;
        ci= ci /4;
        for(int i = 0; i < itterationen; i++){
            double ziT = 2*(z*zi);
            double zT =z*z-(zi*zi);

            z = zT + c;
            zi = ziT + ci;

            if(z*z + zi*zi >= 4.0){
                colitt = i;
                //System.out.println(i);
                return false;
            }
        }
        colitt = 0;
        return true;
    }


    //TODO Farbalgorithmus verbessern
    public Color calcCol(int itt) {

        float hue = 255 * ((float)itt) / itterationen;
        float saturation = 255f;
        float value = 255f;

        if(itt < itterationen) {
            value = 255f;
        }
        else {
            value = 0f;
        }


        Color col = Color.getHSBColor(hue, saturation, value);
        //System.out.println(itt +  "" + hue +  "" + saturation +  "" + value);
        return col;
    }




}
