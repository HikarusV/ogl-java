package com.games;

import com.games.helper.RGB;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.ArrayList;
import java.util.Random;

public class Listener implements GLEventListener {

    private RGB rgb = new RGB();

    private GLWindow window;
    private int wScreen, hScreen;
    private float  unitsWide, unitsHeight;

    private Random random = new Random(30);

    // animasi
    static ArrayList<dot> snake = new ArrayList<dot>();
    static float[] cekPoin = {100, 100};
    static boolean isNegatif = true;

    public boolean[] isX= new boolean[14];
    public static boolean isHorizontal = true;
    static int time = 0;

    public Listener(GLWindow window, float unitsWide) {
        this.window = window;
        this.unitsWide = unitsWide;
    }

    void kotak(GLAutoDrawable drawable, float x0, float y0, float lebar, float panjang){
        lebar = lebar/2;
        panjang = panjang/2;

        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

//        rgb.RGB_Change_Color_Rainbow(0.05f);
        rgb.GreenColor();

        gl.glColor3f(rgb.R, rgb.G, rgb.B);
//        gl.glBegin(GL2.GL_QUADS);
////            gl.glVertex2f(x0, y0);
////            gl.glVertex2f(x0 + lebar, y0);
////            gl.glVertex2f(x0, y0 + panjang);
////            gl.glVertex2f(x0 + lebar, y0 + panjang);
////
//            gl.glVertex2f(x0 - lebar, y0-panjang);
//            gl.glVertex2f(x0 + lebar, y0-panjang);
//            gl.glVertex2f(x0 + lebar, y0 + panjang);
//            gl.glVertex2f(x0-lebar, y0 + panjang);
//        gl.glEnd();
//        System.out.println(snake.size());
        for (byte i = 0; i < snake.size(); i++) {
            gl.glBegin(GL2.GL_QUADS);
                gl.glVertex2f(snake.get(i).getX() - lebar, snake.get(i).getY() - panjang);
                gl.glVertex2f(snake.get(i).getX() + lebar, snake.get(i).getY() - panjang);
                gl.glVertex2f(snake.get(i).getX() + lebar, snake.get(i).getY() + panjang);
                gl.glVertex2f(snake.get(i).getX() - lebar, snake.get(i).getY() + panjang);
            gl.glEnd();
        }

    }

    public static void setCekPoin(boolean horizotal, boolean isMinus){
//        cekPoin[0] = xArr[0];
//        cekPoin[1] = yArr[0];
        isHorizontal = horizotal;
        isNegatif = isMinus;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("mulai");

        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.75f,0.75f,0.75f,1);

        for (byte i = 0; i < 35; i++){
            //xArr[i] = random.nextInt(300);
            //yArr[i] = random.nextInt(300);
            snake.add(new dot(-i/4, 0f));
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {

        if (time++ == 2) {
            for (byte i = (byte) (snake.size() - 1); i > 0; i--) {
            snake.get(i).setX(snake.get(i-1).getX());
            snake.get(i).setY(snake.get(i-1).getY());
            }
            time = 0;
        }

        if (isHorizontal) {
            if (isNegatif) {
                snake.get(0).setX(snake.get(0).getX()+0.3f);
                if (snake.get(0).getX() >= this.unitsWide/2) {
                    snake.get(0).setX(-this.unitsWide/2);
                }
            } else {
                snake.get(0).setX(snake.get(0).getX()-0.3f);
                if (snake.get(0).getX() <= -this.unitsWide/2) {
                    snake.get(0).setX(this.unitsWide/2);
                }
            }
        } else {
            if (isNegatif) {
                snake.get(0).setY(snake.get(0).getY()+0.3f);
                if (snake.get(0).getY() >= this.unitsHeight/2) {
                    snake.get(0).setY(-this.unitsHeight/2);
                }
            } else {
                snake.get(0).setY(snake.get(0).getY()-0.3f);
                if (snake.get(0).getY() <= -this.unitsHeight/2) {
                    snake.get(0).setY(this.unitsHeight/2);
                }
            }
        }

        kotak(drawable, 0, 0, 2f, 2f);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        wScreen = window.getWidth();
        hScreen = window.getHeight();
        unitsHeight = hScreen / (wScreen / unitsWide);

        GL2 gl = drawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-unitsWide / 2, unitsWide / 2, -unitsHeight / 2, unitsHeight / 2,  -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);

    }
}

class dot{
    private float x;
    private float y;

    public dot(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}