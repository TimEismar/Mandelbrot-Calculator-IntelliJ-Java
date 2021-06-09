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
public int itterationen = 20;
double y1;
double y2;
double ab;
double a;

public void paint (Graphics g) {

int xSize = StartUp.getX() + 1;
int ySize = StartUp.getY() + 1;

for(double x = 0; x != xSize; x++){
    for(double y = 0; y !=  ySize; y++){
        if(checkInside(x, y) == true){
          int xr = (int)x;
          int yr = (int)y;
          g.setColor(Color.RED);
          g.fillRect(xr, yr, 1, 1);
        }
    }
}
}

public boolean checkInside(double c, double ci){
  double zi = 0;
  double z = 0;
  for(int i = 0, i < itterationen; i++){
    double ziT = 2*(z*zi);
    double zT =z*z-(zi*zi);

    if(z*z + zi*zi >= 4.0){
      return false
    }
  }
  return true;
}


}
