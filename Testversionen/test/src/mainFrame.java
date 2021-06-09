package fraktal.v4;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class mainFrame extends JFrame implements KeyListener, MouseListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Bild bild;
    // private JProgressBar b;
    // private JPanel rectangle;
    static double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private int shiftZ�hler = 1;
    Einstellungen e = new Einstellungen("b&w", width, height, this);
    private double fak = e.getZoomFak();
    //private double schiebFak = e.getSchiebFak();

/*
	protected void ProcessMouseEvent(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			int x = (int)e.getPoint().getX();
	        int y = (int)e.getPoint().getX();
	        double iNeu = this.e.getTopOffset() - 2.8*((int)((height-height/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());
        	double rNeu = this.e.getLeftOffset() + 2.8*((int)((width-width/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());

        	this.e.setTopOffset(iNeu);
        	this.e.setLeftOffset(rNeu);
        	bild.getE().setZoom(bild.getE().getZoom()*fak);

        	bild = new Bild(this.e);
        	//bild.repaint();

        	//b.setValue(100);
        	//b.revalidate();
        	//b.repaint();

        	repaint();
		}
	}
*/

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }

    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_L) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            System.exit(0);
        }
        if(e.getKeyCode()== KeyEvent.VK_Z) {

            double iNeu = this.e.getTopOffset() - 2.8*((int)((height-height/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());
            double rNeu = this.e.getLeftOffset() + 2.8*((int)((width-width/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());

            this.e.setTopOffset(iNeu);
            this.e.setLeftOffset(rNeu);
            bild.getE().setZoom(bild.getE().getZoom()*fak);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_MINUS) {

            if(bild.getE().getIterationen() >= 21) bild.getE().setIterationen(bild.getE().getIterationen()-20);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_PLUS) {

            bild.getE().setIterationen(bild.getE().getIterationen()+20);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_B) {

            bild.getE().setZoom(bild.getE().getZoom()/fak);

            double iNeu = this.e.getTopOffset() + 2.8*((int)((height-height/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());
            double rNeu = this.e.getLeftOffset() - 2.8*((int)((width-width/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());

            this.e.setTopOffset(iNeu);
            this.e.setLeftOffset(rNeu);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_UP) {

            bild.getE().setTopOffset(bild.getE().getTopOffset()+ bild.getE().getSchiebFak()/(fak * bild.getE().getZoom()*fak));

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {

            bild.getE().setLeftOffset(bild.getE().getLeftOffset()+ bild.getE().getSchiebFak()/(fak * bild.getE().getZoom()*fak));

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_DOWN) {

            //if(bild.getE().getTopOffset() >= 0.7/(fak * bild.getE().getZoom()*fak))
            bild.getE().setTopOffset(bild.getE().getTopOffset() - bild.getE().getSchiebFak()/(fak * bild.getE().getZoom()*fak));

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_LEFT) {

            //if(bild.getE().getLeftOffset() >= 0.7/(fak * bild.getE().getZoom()*fak))
            bild.getE().setLeftOffset(bild.getE().getLeftOffset() - bild.getE().getSchiebFak()/(fak * bild.getE().getZoom()*fak));

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_Y) {

            bild.getE().setFarbgebung(0);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_X) {

            bild.getE().setFarbgebung(1);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_C) {

            bild.getE().setFarbgebung(2);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_V) {

            bild.getE().setFarbgebung(3);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_A) {

            bild.getE().setFarbgebung(4);

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_T) {

            bild.getE().setGitterAn(!bild.getE().isGitterAn());

            bild = new Bild(this.e);
            //bild.repaint();

            //b.setValue(100);
            //b.revalidate();
            //b.repaint();

            repaint();
        }

        if(e.getKeyCode()== KeyEvent.VK_SHIFT) {

            shiftZ�hler += 1;

            if((shiftZ�hler%2) == 0) {
                bild.getE().setSchiebFak(0.03);

            }else {
                bild.getE().setSchiebFak(0.7);

            }


        }

        if(e.getKeyCode()== KeyEvent.VK_R) {

            bild.getE().setTopOffset(1.4);
            bild.getE().setLeftOffset(-2.75);
            bild.getE().setZoom(1);
            this.bild = new Bild(this.e);

            repaint();

        }
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }

    public mainFrame(){
        //this.b = new JProgressBar();
        this.bild = new Bild(this.e);
        //fak = bild.getE().getZoomFak();
        //  b.setStringPainted(true);
        //  b.setForeground(Color.green);
        //  b.setBackground(Color.BLUE);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame frame = new mainFrame();
                frame.setUndecorated(true);
                frame.setTitle("Mandelbrot");
                frame.setResizable(false);
                frame.setLocation(0,0);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setSize((int)width, (int)height);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.getContentPane().add(frame.b, BorderLayout.SOUTH);
                frame.getContentPane().add(frame.bild);


                frame.setVisible(true);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Mouse released");
        if(e.getButton() == MouseEvent.BUTTON1) {

            int x = (int)e.getX();
            int y = (int)e.getY();

            double iNeu = this.e.getTopOffset() + 2.8*((this.e.getHeight()/2)-y)/(this.e.getHeight()*this.e.getZoom());
            double rNeu = this.e.getLeftOffset() - 2.8*((this.e.getWidth()/2)-x)/(this.e.getHeight()*this.e.getZoom());

            this.e.setTopOffset(iNeu);
            this.e.setLeftOffset(rNeu);

            if(e.isControlDown()) {

                iNeu = this.e.getTopOffset() - 2.8*((int)((height-height/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());
                rNeu = this.e.getLeftOffset() + 2.8*((int)((width-width/this.e.getZoomFak())/2))/(this.e.getHeight()*this.e.getZoom());

                bild.getE().setZoom(bild.getE().getZoom()*fak);

                this.e.setTopOffset(iNeu);
                this.e.setLeftOffset(rNeu);

                this.e.getRobot().mouseMove((int)this.e.getWidth()/2, (int)this.e.getHeight()/2);
            }



            bild = new Bild(this.e);

            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
