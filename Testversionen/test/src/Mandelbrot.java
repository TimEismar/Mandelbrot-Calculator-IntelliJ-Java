package fraktal.v4;

import fraktal.v2.ComplexNumber;

public class Mandelbrot extends Thread {

    private ComplexNumber z = new ComplexNumber();

    private Einstellungen e;
    private int threadNumber;
    private Mandelbrot aufrufer;
    private int[][] pixelIterationen;
    private int endY;
    private int endX;
    private int startY;
    private int startX;
    private int threadsFinished;

    public Mandelbrot(Einstellungen einstellungen) {
        this.e = einstellungen;
    }

    public Mandelbrot(int threadNumber, Mandelbrot aufrufer, Einstellungen einstellungen, int[][] pixelIterationen, int startX, int startY, int endX, int endY) {
        this.e = einstellungen;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.pixelIterationen = pixelIterationen;
        this.aufrufer = aufrufer;
        this.threadNumber = threadNumber;

    }

    public int getIterationen(ComplexNumber c) {
        z.set(0, 0);

        return funktionIterationen(z, c, 0);
    }

    public int funktionIterationen(ComplexNumber z, ComplexNumber c, int iterationen) {

        for(int i = 0; i<e.getIterationen(); i++) {

            if(z.abs() > 2 || c.abs() > 2 || iterationen == e.getIterationen()) {
                return i;
            }else {
                z.set(z.square());
                //z.set(z.pow(z, 4));
                z.add(c);
                iterationen++;
            }
        }

        return iterationen;
    }

    public int getRed(int iterationen) {
        if(e.getFarbgebung() == 0) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen<e.getIterationen()/3){
                return iterationen%255;
            } else if (iterationen >= e.getIterationen()/2){
                return 255;
            } else if (iterationen >= e.getIterationen()) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 1) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 2) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if(iterationen%2 == 0) {
                return 0;
            }else if (iterationen%2 != 0) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 3) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return (int)(1*iterationen)%e.getIterationen();
            }
        }

        if(e.getFarbgebung() == 4) {
            if (iterationen < e.getIterationen()) {
                int i = iterationen % 16;

                if(i == 0) {
                    return 66;
                }else if(i == 1) {
                    return 25;
                }else if(i == 2) {
                    return 9;
                }else if(i == 3) {
                    return 4;
                }else if(i == 4) {
                    return 0;
                }else if(i == 5) {
                    return 12;
                }else if(i == 6) {
                    return 24;
                }else if(i == 7) {
                    return 57;
                }else if(i == 8) {
                    return 134;
                }else if(i == 9) {
                    return 211;
                }else if(i == 10) {
                    return 241;
                }else if(i == 11) {
                    return 248;
                }else if(i == 12) {
                    return 255;
                }else if(i == 13) {
                    return 204;
                }else if(i == 14) {
                    return 153;
                }else if(i == 15) {
                    return 106;
                }else {
                    return 0;
                }
            }
        }

        return 0;
    }

    public int getGreen(int iterationen) {
        if(e.getFarbgebung() == 0) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen<e.getIterationen()/3){
                return 0;
            } else if (iterationen >= e.getIterationen()/2){
                return iterationen%255;
            } else if (iterationen >= e.getIterationen()) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 1) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 2) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if(iterationen%2 == 0) {
                return 0;
            }else if (iterationen%2 != 0) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 3) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return (int)(0.7*iterationen)%e.getIterationen();
            }
        }

        if(e.getFarbgebung() == 4) {
            if (iterationen < e.getIterationen()) {
                int i = iterationen % 16;

                if(i == 0) {
                    return 30;
                }else if(i == 1) {
                    return 7;
                }else if(i == 2) {
                    return 1;
                }else if(i == 3) {
                    return 4;
                }else if(i == 4) {
                    return 7;
                }else if(i == 5) {
                    return 44;
                }else if(i == 6) {
                    return 82;
                }else if(i == 7) {
                    return 125;
                }else if(i == 8) {
                    return 181;
                }else if(i == 9) {
                    return 236;
                }else if(i == 10) {
                    return 233;
                }else if(i == 11) {
                    return 201;
                }else if(i == 12) {
                    return 170;
                }else if(i == 13) {
                    return 128;
                }else if(i == 14) {
                    return 87;
                }else if(i == 15) {
                    return 52;
                }else {
                    return 0;
                }
            }
        }

        return 0;
    }

    public int getBlue(int iterationen) {
        if(e.getFarbgebung() == 0) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen<e.getIterationen()/3){
                return 0;
            } else if (iterationen >= e.getIterationen()/2){
                return 0;
            } else if (iterationen >= e.getIterationen()) {
                return iterationen%255;
            }
        }

        if(e.getFarbgebung() == 1) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 2) {
            if(iterationen == e.getIterationen()) {
                return 0;
            }else if(iterationen%2 == 0) {
                return 0;
            }else if (iterationen%2 != 0) {
                return 255;
            }
        }

        if(e.getFarbgebung() == 3) {
            if(iterationen==e.getIterationen()) {
                return 0;
            }else if (iterationen != e.getIterationen()) {
                return (int)(1.3*iterationen)%e.getIterationen();
            }
        }

        if(e.getFarbgebung() == 4) {
            if (iterationen < e.getIterationen()) {
                int i = iterationen % 16;

                if(i == 0) {
                    return 15;
                }else if(i == 1) {
                    return 26;
                }else if(i == 2) {
                    return 47;
                }else if(i == 3) {
                    return 73;
                }else if(i == 4) {
                    return 110;
                }else if(i == 5) {
                    return 138;
                }else if(i == 6) {
                    return 177;
                }else if(i == 7) {
                    return 209;
                }else if(i == 8) {
                    return 229;
                }else if(i == 9) {
                    return 248;
                }else if(i == 10) {
                    return 291;
                }else if(i == 11) {
                    return 95;
                }else if(i == 12) {
                    return 0;
                }else if(i == 13) {
                    return 0;
                }else if(i == 14) {
                    return 0;
                }else if(i == 15) {
                    return 3;
                }else {
                    return 0;
                }
            }
        }

        return 0;
    }

    public int[][] pixelArrayIter() throws InterruptedException{

        //long startTime = System.currentTimeMillis();

        this.pixelIterationen = new int[(int)e.getHeight()][(int)e.getWidth()];
        System.out.println("Array created");
        long startTime = System.currentTimeMillis();
	/*
		Mandelbrot thread1 = new Mandelbrot(1,this, this.e, this.pixelIterationen, 0, 0, (int)e.getWidth()/20 * 1, (int)e.getHeight());
		Mandelbrot thread2 = new Mandelbrot(2,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 1, 0, (int)e.getWidth()/20 * 2, (int)e.getHeight());
		Mandelbrot thread3 = new Mandelbrot(3,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 2, 0, (int)e.getWidth()/20 * 3, (int)e.getHeight());
		Mandelbrot thread4 = new Mandelbrot(4,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 3, 0, (int)e.getWidth()/20 * 4, (int)e.getHeight());
		Mandelbrot thread5 = new Mandelbrot(5,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 4, 0, (int)e.getWidth()/20 * 5, (int)e.getHeight());
		Mandelbrot thread6 = new Mandelbrot(6,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 5, 0, (int)e.getWidth()/20 * 6, (int)e.getHeight());
		Mandelbrot thread7 = new Mandelbrot(7,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 6, 0, (int)e.getWidth()/20 * 7, (int)e.getHeight());
		Mandelbrot thread8 = new Mandelbrot(8,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 7, 0, (int)e.getWidth()/20 * 8, (int)e.getHeight());
		Mandelbrot thread9 = new Mandelbrot(9,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 8, 0, (int)e.getWidth()/20 * 9, (int)e.getHeight());
		Mandelbrot thread10 = new Mandelbrot(10,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 9, 0, (int)e.getWidth()/20 * 10, (int)e.getHeight());
		Mandelbrot thread11 = new Mandelbrot(11,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 10, 0, (int)e.getWidth()/20 * 11, (int)e.getHeight());
		Mandelbrot thread12 = new Mandelbrot(12,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 11, 0, (int)e.getWidth()/20 * 12, (int)e.getHeight());
		Mandelbrot thread13 = new Mandelbrot(13,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 12, 0, (int)e.getWidth()/20 * 13, (int)e.getHeight());
		Mandelbrot thread14 = new Mandelbrot(14,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 13, 0, (int)e.getWidth()/20 * 14, (int)e.getHeight());
		Mandelbrot thread15 = new Mandelbrot(15,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 14, 0, (int)e.getWidth()/20 * 15, (int)e.getHeight());
		Mandelbrot thread16 = new Mandelbrot(16,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 15, 0, (int)e.getWidth()/20 * 16, (int)e.getHeight());
		Mandelbrot thread17 = new Mandelbrot(17,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 16, 0, (int)e.getWidth()/20 * 17, (int)e.getHeight());
		Mandelbrot thread18 = new Mandelbrot(18,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 17, 0, (int)e.getWidth()/20 * 18, (int)e.getHeight());
		Mandelbrot thread19 = new Mandelbrot(19,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 18, 0, (int)e.getWidth()/20 * 19, (int)e.getHeight());
		Mandelbrot thread20 = new Mandelbrot(20,this, this.e, this.pixelIterationen, (int)e.getWidth()/20 * 19, 0, (int)e.getWidth()/20 * 20, (int)e.getHeight());

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		thread11.start();
		thread12.start();
		thread13.start();
		thread14.start();
		thread15.start();
		thread16.start();
		thread17.start();
		thread18.start();
		thread19.start();
		thread20.start();

		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		thread6.join();
		thread7.join();
		thread8.join();
		thread9.join();
		thread10.join();
		thread11.join();
		thread12.join();
		thread13.join();
		thread14.join();
		thread15.join();
		thread16.join();
		thread17.join();
		thread18.join();
		thread19.join();
		thread20.join();
	*/


	/*	Mandelbrot thread1 = new Mandelbrot(1,this, this.e, this.pixelIterationen, 0, 0, (int)e.getWidth()/8 * 1, (int)e.getHeight());
		Mandelbrot thread2 = new Mandelbrot(2,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 1, 0, (int)e.getWidth()/8 * 2, (int)e.getHeight());
		Mandelbrot thread3 = new Mandelbrot(3,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 2, 0, (int)e.getWidth()/8 * 3, (int)e.getHeight());
		Mandelbrot thread4 = new Mandelbrot(4,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 3, 0, (int)e.getWidth()/8 * 4, (int)e.getHeight());
		Mandelbrot thread5 = new Mandelbrot(5,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 4, 0, (int)e.getWidth()/8 * 5, (int)e.getHeight());
		Mandelbrot thread6 = new Mandelbrot(6,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 5, 0, (int)e.getWidth()/8 * 6, (int)e.getHeight());
		Mandelbrot thread7 = new Mandelbrot(7,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 6, 0, (int)e.getWidth()/8 * 7, (int)e.getHeight());
		Mandelbrot thread8 = new Mandelbrot(8,this, this.e, this.pixelIterationen, (int)e.getWidth()/8 * 7, 0, (int)e.getWidth()/8 * 8, (int)e.getHeight());

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();

		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		thread6.join();
		thread7.join();
		thread8.join();
	*/


        Mandelbrot thread1 = new Mandelbrot(1,this, this.e, this.pixelIterationen, 0, 0, (int)e.getWidth()/50 * 1, (int)e.getHeight());
        Mandelbrot thread2 = new Mandelbrot(2,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 1, 0, (int)e.getWidth()/50 * 2, (int)e.getHeight());
        Mandelbrot thread3 = new Mandelbrot(3,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 2, 0, (int)e.getWidth()/50 * 3, (int)e.getHeight());
        Mandelbrot thread4 = new Mandelbrot(4,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 3, 0, (int)e.getWidth()/50 * 4, (int)e.getHeight());
        Mandelbrot thread5 = new Mandelbrot(5,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 4, 0, (int)e.getWidth()/50 * 5, (int)e.getHeight());
        Mandelbrot thread6 = new Mandelbrot(6,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 5, 0, (int)e.getWidth()/50 * 6, (int)e.getHeight());
        Mandelbrot thread7 = new Mandelbrot(7,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 6, 0, (int)e.getWidth()/50 * 7, (int)e.getHeight());
        Mandelbrot thread8 = new Mandelbrot(8,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 7, 0, (int)e.getWidth()/50 * 8, (int)e.getHeight());
        Mandelbrot thread9 = new Mandelbrot(9,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 8, 0, (int)e.getWidth()/50 * 9, (int)e.getHeight());
        Mandelbrot thread10 = new Mandelbrot(10,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 9, 0, (int)e.getWidth()/50* 10, (int)e.getHeight());
        Mandelbrot thread11 = new Mandelbrot(11,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 10, 0, (int)e.getWidth()/50 * 11, (int)e.getHeight());
        Mandelbrot thread12 = new Mandelbrot(12,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 11, 0, (int)e.getWidth()/50 * 12, (int)e.getHeight());
        Mandelbrot thread13 = new Mandelbrot(13,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 12, 0, (int)e.getWidth()/50 * 13, (int)e.getHeight());
        Mandelbrot thread14 = new Mandelbrot(14,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 13, 0, (int)e.getWidth()/50 * 14, (int)e.getHeight());
        Mandelbrot thread15 = new Mandelbrot(15,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 14, 0, (int)e.getWidth()/50 * 15, (int)e.getHeight());
        Mandelbrot thread16 = new Mandelbrot(16,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 15, 0, (int)e.getWidth()/50 * 16, (int)e.getHeight());
        Mandelbrot thread17 = new Mandelbrot(17,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 16, 0, (int)e.getWidth()/50 * 17, (int)e.getHeight());
        Mandelbrot thread18 = new Mandelbrot(18,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 17, 0, (int)e.getWidth()/50 * 18, (int)e.getHeight());
        Mandelbrot thread19 = new Mandelbrot(19,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 18, 0, (int)e.getWidth()/50 * 19, (int)e.getHeight());
        Mandelbrot thread20 = new Mandelbrot(20,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 19, 0, (int)e.getWidth()/50 * 20, (int)e.getHeight());
        Mandelbrot thread21 = new Mandelbrot(21,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 20, 0, (int)e.getWidth()/50 * 21, (int)e.getHeight());
        Mandelbrot thread22 = new Mandelbrot(22,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 21, 0, (int)e.getWidth()/50 * 22, (int)e.getHeight());
        Mandelbrot thread23 = new Mandelbrot(23,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 22, 0, (int)e.getWidth()/50 * 23, (int)e.getHeight());
        Mandelbrot thread24 = new Mandelbrot(24,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 23, 0, (int)e.getWidth()/50 * 24, (int)e.getHeight());
        Mandelbrot thread25 = new Mandelbrot(25,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 24, 0, (int)e.getWidth()/50 * 25, (int)e.getHeight());
        Mandelbrot thread26 = new Mandelbrot(26,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 25, 0, (int)e.getWidth()/50 * 26, (int)e.getHeight());
        Mandelbrot thread27 = new Mandelbrot(27,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 26, 0, (int)e.getWidth()/50 * 27, (int)e.getHeight());
        Mandelbrot thread28 = new Mandelbrot(28,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 27, 0, (int)e.getWidth()/50 * 28, (int)e.getHeight());
        Mandelbrot thread29 = new Mandelbrot(29,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 28, 0, (int)e.getWidth()/50 * 29, (int)e.getHeight());
        Mandelbrot thread30 = new Mandelbrot(30,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 29, 0, (int)e.getWidth()/50 * 30, (int)e.getHeight());
        Mandelbrot thread31 = new Mandelbrot(31,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 30, 0, (int)e.getWidth()/50 * 31, (int)e.getHeight());
        Mandelbrot thread32 = new Mandelbrot(32,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 31, 0, (int)e.getWidth()/50 * 32, (int)e.getHeight());
        Mandelbrot thread33 = new Mandelbrot(33,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 32, 0, (int)e.getWidth()/50 * 33, (int)e.getHeight());
        Mandelbrot thread34 = new Mandelbrot(34,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 33, 0, (int)e.getWidth()/50 * 34, (int)e.getHeight());
        Mandelbrot thread35 = new Mandelbrot(35,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 34, 0, (int)e.getWidth()/50 * 35, (int)e.getHeight());
        Mandelbrot thread36 = new Mandelbrot(36,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 35, 0, (int)e.getWidth()/50 * 36, (int)e.getHeight());
        Mandelbrot thread37 = new Mandelbrot(37,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 36, 0, (int)e.getWidth()/50 * 37, (int)e.getHeight());
        Mandelbrot thread38 = new Mandelbrot(38,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 37, 0, (int)e.getWidth()/50 * 38, (int)e.getHeight());
        Mandelbrot thread39 = new Mandelbrot(39,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 38, 0, (int)e.getWidth()/50 * 39, (int)e.getHeight());
        Mandelbrot thread40 = new Mandelbrot(40,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 39, 0, (int)e.getWidth()/50 * 40, (int)e.getHeight());
        Mandelbrot thread41 = new Mandelbrot(41,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 40, 0, (int)e.getWidth()/50 * 41, (int)e.getHeight());
        Mandelbrot thread42 = new Mandelbrot(42,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 41, 0, (int)e.getWidth()/50 * 42, (int)e.getHeight());
        Mandelbrot thread43 = new Mandelbrot(43,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 42, 0, (int)e.getWidth()/50 * 43, (int)e.getHeight());
        Mandelbrot thread44 = new Mandelbrot(44,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 43, 0, (int)e.getWidth()/50 * 44, (int)e.getHeight());
        Mandelbrot thread45 = new Mandelbrot(45,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 44, 0, (int)e.getWidth()/50 * 45, (int)e.getHeight());
        Mandelbrot thread46 = new Mandelbrot(46,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 45, 0, (int)e.getWidth()/50 * 46, (int)e.getHeight());
        Mandelbrot thread47 = new Mandelbrot(47,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 46, 0, (int)e.getWidth()/50 * 47, (int)e.getHeight());
        Mandelbrot thread48 = new Mandelbrot(48,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 47, 0, (int)e.getWidth()/50 * 48, (int)e.getHeight());
        Mandelbrot thread49 = new Mandelbrot(49,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 48, 0, (int)e.getWidth()/50 * 49, (int)e.getHeight());
        Mandelbrot thread50 = new Mandelbrot(50,this, this.e, this.pixelIterationen, (int)e.getWidth()/50 * 49, 0, (int)e.getWidth()/50 * 50, (int)e.getHeight());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();
        thread20.start();
        thread21.start();
        thread22.start();
        thread23.start();
        thread24.start();
        thread25.start();
        thread26.start();
        thread27.start();
        thread28.start();
        thread29.start();
        thread30.start();
        thread31.start();
        thread32.start();
        thread33.start();
        thread34.start();
        thread35.start();
        thread36.start();
        thread37.start();
        thread38.start();
        thread39.start();
        thread40.start();
        thread41.start();
        thread42.start();
        thread43.start();
        thread44.start();
        thread45.start();
        thread46.start();
        thread47.start();
        thread48.start();
        thread49.start();
        thread50.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
        thread11.join();
        thread12.join();
        thread13.join();
        thread14.join();
        thread15.join();
        thread16.join();
        thread17.join();
        thread18.join();
        thread19.join();
        thread20.join();
        thread21.join();
        thread22.join();
        thread23.join();
        thread24.join();
        thread25.join();
        thread26.join();
        thread27.join();
        thread28.join();
        thread29.join();
        thread30.join();
        thread31.join();
        thread32.join();
        thread33.join();
        thread34.join();
        thread35.join();
        thread36.join();
        thread37.join();
        thread38.join();
        thread39.join();
        thread40.join();
        thread41.join();
        thread42.join();
        thread43.join();
        thread44.join();
        thread45.join();
        thread46.join();
        thread47.join();
        thread48.join();
        thread49.join();
        thread50.join();


        //wartenAufThreads();

        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("Rechenzeit f�r Datenmenge (Mit Multi-threading):" + finishTime);

        return this.pixelIterationen;
    }

    public void run() {

        System.out.println("T"+this.threadNumber+" started");
        long startTime = System.currentTimeMillis();
        for(int x = this.startX; x < this.endX; x++) {
            for(int y = this.startY; y < this.endY ; y++) {
                this.pixelIterationen[y][x] = getIterXY(x, y);

            }
        }
        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("Rechenzeit im Thread: " + finishTime);
        System.out.println("T"+this.threadNumber+" complete");
        aufrufer.setThreadsFinishedPlus1();

    }

    public ComplexNumber getComplex(int x, int y) {

        double leftOffset = e.getLeftOffset();
        double topOffset = e.getTopOffset();
        double zoom = e.getZoom();

        return new ComplexNumber(leftOffset + 2.8*x/(e.getHeight()*zoom), topOffset - 2.8*y/(e.getHeight()*zoom));
    }

    public int getIterXY(int x, int y) {

        return getIterationen(getComplex(x, y));
    }

    public void setThreadsFinishedPlus1() {
        this.threadsFinished += 1;
        //System.out.println(threadsFinished);
    }

    public void wartenAufThreads() throws InterruptedException {
        while(true) {
            if(!(threadsFinished < 1)) return;
            //System.out.println(threadsFinished);
            Thread.sleep(10);
        }
    }
}
