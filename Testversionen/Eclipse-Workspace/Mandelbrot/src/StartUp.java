import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;

public class StartUp {
	static int xSize = 2000;
	static int ySize = 3000;
	//MyFrame
	public static void main(String[] args) {
		
		JFrame frame = new Mandelbrot();
		frame.setTitle("Et klappt!!!!");
		frame.setSize(xSize, ySize);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//SimpleFrame
	/*public static void main(String[] args) {
	    JFrame frame = new MyFrame();
	    frame.setSize(200,300);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);
	    frame.setVisible(true);
	   }*/

	public static  int getX() {
		return xSize;
	}
	public static  int getY() {
		return ySize;
	}
	
}
