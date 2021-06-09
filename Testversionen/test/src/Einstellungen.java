package fraktal.v4;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JFrame;

public class Einstellungen {

    private double height;
    private double width;
    private String coloring;
    private double leftOffset = -2.75;
    private JFrame jf;
    //private int iterationen = 102;
    private int iterationen = 102;
    private int farbgebung = 0;
    private int rectPosX, rectPosY, rectHeight, rectWidth;
    private double zoomFak = 2.0 ;
    private double schiebFak = 0.7;
    private double zoom = 1.0;
    private double topOffset = 1.4;
    private boolean gitterAn = false;
    private Robot robot; //= new Robot();



    public double getSchiebFak() {
        return schiebFak;
    }



    public void setSchiebFak(double schiebFak) {
        this.schiebFak = schiebFak;
    }



    public boolean isGitterAn() {
        return gitterAn;
    }



    public void setGitterAn(boolean gitterAn) {
        this.gitterAn = gitterAn;
    }



    public double getZoomFak() {
        return zoomFak;
    }



    public void setZoomFak(double zoomFak) {
        this.zoomFak = zoomFak;
    }



    public int getIterationen() {
        return iterationen;
    }



    public int getRectPosX() {
        return rectPosX;
    }



    public void setRectPosX(int rectPosX) {
        this.rectPosX = rectPosX;
    }



    public int getRectPosY() {
        return rectPosY;
    }



    public void setRectPosY(int rectPosY) {
        this.rectPosY = rectPosY;
    }



    public int getRectHeight() {
        return rectHeight;
    }



    public void setRectHeight(int rectHeight) {
        this.rectHeight = rectHeight;
    }



    public int getRectWidth() {
        return rectWidth;
    }



    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }



    public int getFarbgebung() {
        return farbgebung;
    }



    public void setFarbgebung(int farbgebung) {
        this.farbgebung = farbgebung;
    }



    public void setIterationen(int iterationen) {
        this.iterationen = iterationen;
    }



    public Einstellungen (String coloring, double width, double height, JFrame jf) {

        this.height = height;
        this.width = width;
        this.jf = jf;

        this.coloring = coloring;

        try {
            this.robot = new Robot();
        } catch(AWTException e) {}
    }

    public Robot getRobot() {
        return this.robot;
    }

    public double getLeftOffset() {
        return leftOffset;
    }



    public void setLeftOffset(double leftOffset) {
        this.leftOffset = leftOffset;
    }



    public double getTopOffset() {
        return topOffset;
    }



    public void setTopOffset(double topOffset) {
        this.topOffset = topOffset;
    }

    public JFrame getJf() {
        return jf;
    }

    public double getZoom() {
        return zoom;
    }



    public void setZoom(double zoom) {
        this.zoom = zoom;
    }



    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColoring() {
        return coloring;
    }

    public void setColoring(String coloring) {
        this.coloring = coloring;
    }

}
