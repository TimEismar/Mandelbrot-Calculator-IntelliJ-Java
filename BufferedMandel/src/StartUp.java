import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//TODO User einstellunge Speicher (evt. durch TXT)
public class StartUp extends JFrame implements KeyListener{

    public static void main(String[] args) throws Exception {
        StartUp t = new StartUp();
        t.createFrame();
    }

    ImageIcon img = new ImageIcon("ab.jpg");
    ImageIcon img2 = new ImageIcon("images.jfif");
    ImageIcon img3 = new ImageIcon("manic.png");
    ImageIcon img4 = new ImageIcon("manic2.png");
    ImageIcon img5 = new ImageIcon("mandel_fig3.gif");
    String uin;
    String fName;
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

    public void videoCreater(int farb, int wi, int hi,int start, int max, double zfac, double xver, double yver) throws IOException {
        for(int i = start; i != max; i++){
            BufferedImage tempBuff = Mandelbrot.manim(farb, 5000, 5000, i, zfac, xver, yver);
            String fileName = "C:\\Users\\eisma\\OneDrive - Wirteltor Gymnasium\\Projektkurs-PH-IF\\BufferedMandel\\vidImgZoom\\videoBild" + i + ".jpg";
            File outputfile = new File(fileName);
            ImageIO.write(tempBuff, "jpg", outputfile);
            System.out.println(i);
        }
    }



    public void keyTyped(KeyEvent e) {
        int key = e.getKeyChar();

        switch(key){
            /*Reset*/case 'r': {width = 600;height = 600;farb = 1;itter = 0;zfac = 1;xver = 0;yver = 0;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*UP*/case 'w': {yver = yver + 0.01;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Down*/case 's': {yver = yver - 0.01;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Links*/case 'a': {xver = xver + 0.01;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Rechts*/case 'd': {xver = xver - 0.01;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*-Itt*/case 'c': {itter = itter - 10;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*+Itt*/case 'v': {expo = expo  + 1;itter=(int)Math.pow(2,expo);refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*-MinItt*/case 'g': {itter = itter - 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*+MinItt*/case 'h': {itter = itter + 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Zoom Out*/case 'o': {zfac = zfac - 0.01;itter = itter - 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Zoom In*/case 'p': {zfac = zfac + 0.01;itter = itter + 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*DynZoom Out*/case 'k': {zfac = zfac - 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*DynZoom In*/case 'l': {zfac = zfac + 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C1*/case '1': {farb = 1;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '2': {farb = 2;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '3': {farb = 3;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*C2*/case '4': {farb = 4;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*SizeUp*/case 'm': {width = width + 20;height = height + 20;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*SizeUp*/case 'n': {width = width - 20;height = height - 20;refreshFrame(farb,(int)width,(int)height,itter,zfac,xver,yver);}break;
            /*Esacpe*/case 27:{frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));}break;
            /*Video*/case 'q': {
                try {
                    videoCreater(farb, (int)width,(int)height,0,200,zfac,xver,yver);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }}break;
            default:{System.out.println("Key" + key);}
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createInfoMenu());
        menuBar.add(createPhotoMenu());
        menuBar.add(createControlMenu());
        menuBar.add(createIconMenu());
        return menuBar;
    }

    private JMenu createPhotoMenu() {
        JMenu editMenu = new JMenu("Photo");
        JMenuItem saveItm = new JMenuItem("Save");
        saveItm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
                chooser.setMultiSelectionEnabled(false);
                int returnVal = chooser.showSaveDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    String a = f.getAbsolutePath();
                    BufferedImage temp = Mandelbrot.manim(farb, (int) width, (int) height, itter, zfac, xver, yver);
                    File outputFile = new File(a);
                    try {
                        ImageIO.write(temp, "png", outputFile);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                }});
        editMenu.add(saveItm);
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                BufferedImage temp = Mandelbrot.manim(farb, (int) width, (int) height, itter, zfac, xver, yver);
                ClipboardImage clip = new ClipboardImage();
                clip.clipImage(temp);
            }});
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

    private JMenu createInfoMenu() {
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

    private JMenu createIconMenu() {
        JMenu fileMenu = new JMenu("Icon");

        JMenuItem imgg = new JMenuItem("Icon1");
        imgg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    frame.setIconImage(img.getImage());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        fileMenu.add(imgg);

        JMenuItem imgg2 = new JMenuItem("Icon2");
        imgg2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setIconImage(img2.getImage());
            }
        });
        fileMenu.add(imgg2);

        JMenuItem imgg3 = new JMenuItem("Icon3");
        imgg3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setIconImage(img3.getImage());
            }
        });
        fileMenu.add(imgg3);

        JMenuItem imgg4 = new JMenuItem("Icon4");
        imgg4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setIconImage(img4.getImage());
            }
        });
        fileMenu.add(imgg4);

        JMenuItem imgg5 = new JMenuItem("Icon5");
        imgg5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setIconImage(img5.getImage());
            }
        });
        fileMenu.add(imgg5);
        return fileMenu;
    }

}