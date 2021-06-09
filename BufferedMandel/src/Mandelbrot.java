import java.awt.Color;
import java.awt.image.BufferedImage;


public class Mandelbrot {

    public static BufferedImage manim (int farb, int wi, int hi, int itterra, double zfac, double xver, double yver)  {
        int width = wi, height = hi, max = itterra;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int black = 0;
        int[] colors = new int[max];
        for (int i = 0; i<max; i++) {
            switch(farb) {
                case 1:{colors[i] = Color.HSBtoRGB(i / 256f, 1, i / (i + 8f));}break;
                case 2:{colors[i] = Color.HSBtoRGB(i / 256f, 2, i / (i + 8f));}break;
                case 3:{colors[i] = Color.HSBtoRGB(i / 256f, 2, i * i / (i + 8f));}break;
                case 4:{
                    if(i % 2 == 0){colors[i] = Color.HSBtoRGB(1, 1, 0); }
                    else{colors[i] = Color.HSBtoRGB(0,0,1);}
                }break;
                default:{colors[i] = Color.HSBtoRGB(i / 256f, 1, i / (i + 8f));}break;
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double cre = (((col - width/2.0)*4.0/width)/zfac)+xver;
                double cim = (((row - height/2.0)*4.0/height)/zfac)+yver;
                double x = 0, y = 0;
                double r2;
                int iteration = 0;
                while (x*x+y*y < 4 && iteration < max) {
                    double xnew = x*x-y*y+cre;
                    y = 2*x*y+cim;
                    x = xnew;
                    iteration++;
                }
                if (iteration < max) image.setRGB(col, row, colors[iteration]);
                else image.setRGB(col, row, black);
            }
        }
        return image;
        
    }


}
