import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.GradientPaint;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Mandelbrot extends JPanel {

	private static final long serialVersionUID = 1L;
public int itterationen = 100;
double y1;
double y2;
double ab;
double a;
double range = 6;
double middleR = -0.5;
double middleL = -0.5;
public int colitt = 0;


public void paint (Graphics g) {

int xSize = StartUp.getX() + 1;
int ySize = StartUp.getY() + 1;


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
        	g.setColor(calcCol(1));
        	g.fillRect(xr, yr, 1, 1);
        }
    }
}
}


public boolean checkInside(double ci, double c){
	double zi = 0;
	  double z = 0;
	double xPerc = c / StartUp.getX();
  double yPerc = ci / StartUp.getY();
  c = xPerc  * range +  middleR - range / 2;
  ci = yPerc * range + middleL - range / 4;
 
  for(int i = 0; i < itterationen; i++){
    double ziT = 2*(z*zi);
    double zT =z*z-(zi*zi);

    z = zT + c;
    zi = ziT + ci;

    if(z*z + zi*zi >= 4.0){
    	colitt = i;
    	System.out.println(i);
      return false;
    }
  }
  colitt = 0;
  return true;
}

public Color calcCol(int itt) {
	float hue = 0.9f;
	float saturation = 1.0f;
	float brightness = 0.8f;
	
	//System.out.println(itt);
	
	hue = 255*itt/itterationen;
	saturation = 255f/itterationen;
	if(itt < itterationen) {
		brightness = 50f;
	}
	else {
		brightness = 0f;
	}
	
	
	Color col = Color.getHSBColor(hue, saturation, brightness);
	return col;
}


}
