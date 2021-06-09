import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartUp extends JFrame implements KeyListener{

    public static void main(String[] args) throws Exception {
        StartUp t = new StartUp();
        t.createFrame();
    }

    ImageIcon img = new ImageIcon("manic.png");
    public JFrame frame = new JFrame("Mandelbrot-Calculator");
    public JLabel bild;
    public double width = 600;
    public double height = 600;
    public int farb = 1;
    public int itter = 0;
    public double zfac = 1;
    public double xver = 0;
    public double yver = 0;
    public int expo = 0;

    public void createFrame(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setJMenuBar(createMenuBar());
        frame.setIconImage(img.getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) width, (int) height);
        frame.addKeyListener(this);
        bild = new JLabel(new ImageIcon(Mandelbrot.manim(farb, (int) width, (int) height, itter, zfac, xver, yver)));
        frame.add(bild);
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                if(frame.getWidth() > frame.getHeight()){
                    System.out.println("Frame Size changed to: " + frame.getHeight() + " x " + frame.getHeight());
                    width = frame.getHeight(); height= frame.getHeight();
                    frame.setSize(frame.getHeight(), frame.getHeight());
                    refreshFrame(farb,(int)frame.getWidth(),(int)frame.getHeight(),itter,zfac,xver,yver);
                }
                else{
                    if(frame.getHeight() > frame.getWidth()) {
                        System.out.println("Frame Size changed to: " + frame.getWidth() + " x " + frame.getWidth());
                        frame.setSize(frame.getWidth(), frame.getWidth());
                        width = frame.getWidth(); height= frame.getWidth();
                        refreshFrame(farb, (int) frame.getWidth(), (int) frame.getHeight(), itter, zfac, xver, yver);
                    }
                    else{System.out.println("Frame stayed the same Size");}
                }
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public void refreshFrame(int farb, int wi, int hi, int itterra, double zfac, double xver, double yver){
        frame.getContentPane().removeAll();
        System.out.println("ITT: " + itterra + "          " + "ZFAC: " +zfac);
        bild = new JLabel(new ImageIcon(Mandelbrot.manim(farb, wi, hi, itterra, zfac, xver, yver)));
        frame.add(bild);
        frame.setSize(wi, hi);
        frame.validate();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
    }



    public void keyTyped(KeyEvent e) {
        int key = e.getKeyChar();

        switch(key){
            /*Reset*/case 'r': {width = 600;height = 600;farb = 1;itter = 1;zfac = 1;xver = 0;yver = 0;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*UP*/case 'w': {yver = yver + 0.1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Down*/case 's': {yver = yver - 0.1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Links*/case 'a': {xver = xver + 0.1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Rechts*/case 'd': {xver = xver - 0.1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*-Itt*/case 'c': {itter = itter - 10;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*+Itt*/case 'v': {expo = expo  + 1;itter=(int)Math.pow(2,expo);refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*-MinItt*/case 'g': {itter = itter - 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*+MinItt*/case 'h': {itter = itter + 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Zoom Out*/case 'o': {zfac = zfac - 0.01;itter = itter - 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Zoom In*/case 'p': {zfac = zfac + 0.01;itter = itter + 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*DynZoom Out*/case 'k': {zfac = zfac - 0.01;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*DynZoom In*/case 'l': {zfac = zfac + 0.1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C1*/case '1': {farb = 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '2': {farb = 2;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '3': {farb = 3;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '4': {farb = 4;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*SizeUp*/case 'm': {width = width + 20;height = height + 20;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*SizeUp*/case 'n': {width = width - 20;height = height - 20;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Esacpe*/case 27:{frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));}break;
            default:{System.out.println("Key" + key);}
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(createControlMenu());
        return menuBar;
    }

    private JMenu createEditMenu() {
        JMenu editMenu = new JMenu("Photo");
        JMenuItem cutItem = new JMenuItem("Save");
        editMenu.add(cutItem);
        JMenuItem copyItem = new JMenuItem("Copy");
        editMenu.add(copyItem);
        return editMenu;
    }
    private JMenu createControlMenu() {
        JMenu editMenu = new JMenu("Control");
        JMenuItem re = new JMenuItem("Reeeeeeset");
        re.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                farb = 1; width = 600; height = 600; itter=0; zfac=1; xver=0; expo=0;
                refreshFrame(farb, (int) width, (int) height, itter, zfac, xver, yver);
            }});
        editMenu.add(re);
        return editMenu;
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("Info");
        JMenuItem help = new JMenuItem("Hilfe");
        help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PopUpMessage startPop = new PopUpMessage();
                try {
                    startPop.help();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        fileMenu.add(help);
        JMenuItem credit = new JMenuItem("Credits");
        credit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PopUpMessage startPop = new PopUpMessage();
                try {
                    startPop.credit();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        fileMenu.add(credit);
        return fileMenu;
    }

}