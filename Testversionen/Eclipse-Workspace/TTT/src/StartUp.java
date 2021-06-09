import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class StartUp {

	//MyFrame
	public static void main(String[] args) {
		JFrame frame = new MyFrame();
		frame.setSize(200, 300);
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

}
